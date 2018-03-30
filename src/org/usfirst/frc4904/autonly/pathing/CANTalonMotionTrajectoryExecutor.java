package org.usfirst.frc4904.autonly.pathing;


import org.usfirst.frc4904.motioncontrol.MotionTrajectory;
import org.usfirst.frc4904.motioncontrol.MotionTrajectoryPoint;
import org.usfirst.frc4904.motioncontrol.MotionTrajectoryQueue;
import org.usfirst.frc4904.motioncontrol.Tuple;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motion.SetValueMotionProfile;
import com.ctre.phoenix.motion.TrajectoryPoint;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Notifier;

strictfp public class CANTalonMotionTrajectoryExecutor {
	// Callback for the cancel method.
	private static interface Callback {
		public void cancel();
	}
	protected MotionTrajectoryQueue queue;
	protected final MotionTrajectory trajectory;
	protected final CANTalonSRX motorLeft, motorRight;
	protected final ControlMode originalModeLeft, originalModeRight;
	protected CANTalonMotionTrajectoryPointMessenger pointMessenger;
	protected CANTalonMotionTrajectoryStatusManager statusManager;
	protected CANTalonMotionTrajectoryBufferUpdater bufferUpdater;
	protected Notifier bufferUpdaterNotifier;
	private final Thread pointMessengerThread;
	private final Thread statusManagerThread;

	/**
	 * Executes a motion trajectory on CANTalon motors.
	 * 
	 * @param motorLeft
	 * @param motorRight
	 * @param queue
	 *        the queue from which we fetch motion trajectory points during the motion trajectory.
	 */
	public CANTalonMotionTrajectoryExecutor(CANTalonSRX motorLeft, CANTalonSRX motorRight, MotionTrajectoryQueue queue) {
		this.motorLeft = motorLeft;
		this.motorRight = motorRight;
		originalModeLeft = motorLeft.getControlMode();
		originalModeRight = motorLeft.getControlMode();
		this.queue = queue;
		trajectory = queue.getTrajectory();
		pointMessenger = new CANTalonMotionTrajectoryPointMessenger(this, queue, motorLeft, motorRight);
		pointMessengerThread = new Thread(pointMessenger);
		statusManager = new CANTalonMotionTrajectoryStatusManager(motorLeft, motorRight, this::cancel);
		statusManagerThread = new Thread(statusManager);
		bufferUpdater = new CANTalonMotionTrajectoryBufferUpdater(motorLeft, motorRight);
		bufferUpdaterNotifier = new Notifier(bufferUpdater);
		this.motorLeft.changeMotionControlFramePeriod((int) trajectory.getTickTime() / 2);
		this.motorRight.changeMotionControlFramePeriod((int) trajectory.getTickTime() / 2);
	}

	public TrajectoryPoint standardToTalonPoint(MotionTrajectoryPoint standardPoint) {
		TrajectoryPoint canPoint = new TrajectoryPoint();
		canPoint.position = standardPoint.pos;
		canPoint.velocity = standardPoint.vel;
		canPoint.profileSlotSelect = 0;
		canPoint.zeroPos = standardPoint.tick == 0;
		canPoint.isLastPoint = standardPoint.tick == trajectory.getTickTotal();
		// TODO: Look into heading degrees.
		// 2018 Talon SRX Motion Profile Reference Manual, Page 21:
		// "future feature - not used in this example"
		// We may not need to implement this afterall.
		canPoint.headingDeg = 0;
		return canPoint;
	}

	/**
	 * Starts and initializes the motors and the necessary threads.
	 */
	public void start() {
		motorLeft.clearMotionProfileTrajectories();
		motorRight.clearMotionProfileTrajectories();
		motorLeft.set(ControlMode.MotionProfile, SetValueMotionProfile.Disable.value);
		motorRight.set(ControlMode.MotionProfile, SetValueMotionProfile.Disable.value);
		statusManagerThread.start();
		pointMessengerThread.start();
		bufferUpdaterNotifier.startPeriodic((trajectory.getTickTime() / 2) / 1000);
	}

	/**
	 * Cleanup threads and motor settings when the trajectory is stopped for
	 * any reason.
	 */
	public void cancel() {
		pointMessenger.interrupt();
		statusManager.interrupt();
		bufferUpdaterNotifier.stop();
		// Be a good citizen: Clean up after yourself
		motorLeft.clearMotionProfileTrajectories();
		motorRight.clearMotionProfileTrajectories();
	}

	private static class CANTalonMotionTrajectoryStatusManager implements Runnable {
		private volatile boolean interrupted = false;
		private final CANTalonSRX motorLeft, motorRight;
		private LocalState localState = LocalState.LOADING;
		private final Callback cancelCallback;

		private enum LocalState {
			LOADING, ACTIVE;
		}

		/**
		 * Watches and manages the status of the left/right motors to ensure the
		 * motors act as intended.
		 * 
		 * @param motorLeft
		 * @param motorRight
		 * @param cancelCallback
		 *        ensures that the proper cleanup is run in the event that the
		 *        control mode is switched unexpectedly.
		 */
		CANTalonMotionTrajectoryStatusManager(CANTalonSRX motorLeft, CANTalonSRX motorRight, Callback cancelCallback) {
			this.motorLeft = motorLeft;
			this.motorRight = motorRight;
			this.cancelCallback = cancelCallback;
		}

		@Override
		public void run() {
			while (!interrupted) {
				MotionProfileStatus statusLeft = new MotionProfileStatus();
				MotionProfileStatus statusRight = new MotionProfileStatus();
				motorLeft.getMotionProfileStatus(statusLeft);
				motorRight.getMotionProfileStatus(statusRight);
				if (motorLeft.getControlMode() != ControlMode.MotionProfile
					|| motorRight.getControlMode() != ControlMode.MotionProfile) {
					cancelCallback.cancel();
				}
				switch (localState) {
					case LOADING:
						if (statusLeft.btmBufferCnt > CANTalonMotionTrajectoryPointMessenger.TALON_MIN_POINTS
							&& statusRight.btmBufferCnt > CANTalonMotionTrajectoryPointMessenger.TALON_MIN_POINTS) {
							motorLeft.set(ControlMode.MotionProfile, SetValueMotionProfile.Enable.value);
							motorRight.set(ControlMode.MotionProfile, SetValueMotionProfile.Enable.value);
							localState = LocalState.ACTIVE;
						}
						break;
					case ACTIVE:
						if (statusLeft.activePointValid && statusRight.activePointValid && statusLeft.isLast
							&& statusRight.isLast) {
							motorLeft.set(ControlMode.MotionProfile, SetValueMotionProfile.Hold.value);
							motorRight.set(ControlMode.MotionProfile, SetValueMotionProfile.Hold.value);
							localState = LocalState.LOADING;
						}
				}
			}
		}

		public void interrupt() {
			interrupted = true;
		}
	}

	private static class CANTalonMotionTrajectoryBufferUpdater implements Runnable {
		private final CANTalonSRX motorLeft, motorRight;

		/**
		 * Tells the CANTalons to process the buffer. This should be run periodically,
		 * at a rate faster than the tick time to ensure that the motors don't run out
		 * of points.
		 * 
		 * @param motorLeft
		 * @param motorRight
		 */
		CANTalonMotionTrajectoryBufferUpdater(CANTalonSRX motorLeft, CANTalonSRX motorRight) {
			this.motorLeft = motorLeft;
			this.motorRight = motorRight;
		}

		@Override
		public void run() {
			motorLeft.processMotionProfileBuffer();
			motorRight.processMotionProfileBuffer();
		}
	}

	private static class CANTalonMotionTrajectoryPointMessenger implements Runnable {
		private volatile boolean interrupted = false;
		private final CANTalonMotionTrajectoryExecutor executor;
		private final MotionTrajectoryQueue queue;
		private final CANTalonSRX motorLeft, motorRight;
		static final int TALON_MIN_POINTS = 5;

		/**
		 * Manages pushing the points to the CANTalons as soon as it gets a point from
		 * the trajectory queue.
		 * 
		 * @param executor
		 *        provides access to the standardToTalonPoint method
		 * @param queue
		 *        the wrapper around the queue that the MotionTrajectoryPoints are added to.
		 * @param motorLeft
		 * @param motorRight
		 */
		CANTalonMotionTrajectoryPointMessenger(CANTalonMotionTrajectoryExecutor executor, MotionTrajectoryQueue queue,
			CANTalonSRX motorLeft, CANTalonSRX motorRight) {
			this.executor = executor;
			this.queue = queue;
			this.motorLeft = motorLeft;
			this.motorRight = motorRight;
		}

		@Override
		public void run() {
			while (!interrupted) {
				Tuple<MotionTrajectoryPoint, MotionTrajectoryPoint> pointPair = queue.pointQueue.pop();
				motorLeft.pushMotionProfileTrajectory(executor.standardToTalonPoint(pointPair.getX()));
				motorRight.pushMotionProfileTrajectory(executor.standardToTalonPoint(pointPair.getY()));
			}
		}

		public void interrupt() {
			interrupted = true;
		}
	}
}