package org.usfirst.frc4904.autonly.pathing;


import org.usfirst.frc4904.motioncontrol.MotionTrajectory;
import org.usfirst.frc4904.motioncontrol.MotionTrajectoryQueue;
import org.usfirst.frc4904.motioncontrol.pathing.PathGenerator;
import org.usfirst.frc4904.motioncontrol.pathing.spline.QuinticSplineGenerator;
import org.usfirst.frc4904.robot.RobotMap.NetworkTables;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import edu.wpi.first.wpilibj.command.Command;

public class PathingExecutor extends Command {
	protected PathGenerator generator;
	protected MotionTrajectory trajectory;
	protected MotionTrajectoryQueue trajectoryQueue;
	protected CANTalonMotionTrajectoryExecutor executor;
	protected CANTalonSRX leftWheel, rightWheel;

	public PathingExecutor(CANTalonSRX leftWheel, CANTalonSRX rightWheel) {}

	@Override
	public void initialize() {
		double finPosX = Math.cos(NetworkTables.Cubes.angleEntry.getDouble(0) * (Math.PI / 180))
			* NetworkTables.Cubes.distanceEntry.getDouble(0);
		double finPosY = Math.sin(NetworkTables.Cubes.angleEntry.getDouble(0) * (Math.PI / 180))
			* NetworkTables.Cubes.distanceEntry.getDouble(0);
		generator = new QuinticSplineGenerator(0.0, 0.0, finPosX, finPosY, // POS
			0.0, 0.0, 0.0, 0.0, // VEL
			0.0, 0.0, 0.0, 0.0); // ACC
		this.trajectoryQueue.build();
		this.executor = new CANTalonMotionTrajectoryExecutor(this.leftWheel, this.rightWheel, trajectoryQueue);
	}

	@Override
	public void execute() {
		// executor.start();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	public void cancel() {
		// executor.cancel();
		this.trajectoryQueue.cancel();
	}
}
