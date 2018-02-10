package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.standard.Util;
import org.usfirst.frc4904.standard.commands.motor.MotorIdle;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.CustomEncoder;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;

public class Arm extends PositionSensorMotor {
	public static final double ELBOW_MULTIPLIER = 1.0;
	private final double TICK_MULTIPLIER = 360.0/255.0;
	private static final double TICK_OFFSET = 0.0; // TODO: needs to be set
	public static DoubleSolenoid.Value BRAKE_ENABLED = DoubleSolenoid.Value.kForward;
	public static DoubleSolenoid.Value BRAKE_DISABLED = DoubleSolenoid.Value.kReverse;
	public final CustomEncoder encoder;
	public static final Util.Range motorAngleRange = new Util.Range(ArmState.ARM_POSITION_INTAKE.position,
		ArmState.ARM_POSITION_SCALE.position);

	public enum ArmState {
		ARM_POSITION_INTAKE(10), ARM_POSITION_SWITCH(40), ARM_POSITION_SCALE(100); // TODO: need to be tweaked a lot
		public final double position;

		private ArmState(double position) {
			this.position = position + TICK_OFFSET;
		}
	}

	public Arm(MotionController motionController, CustomEncoder encoder, SpeedController... elbowControllers) {
		super("Arm", motionController, elbowControllers);
		this.encoder = encoder;
		this.encoder.setDistancePerPulse(TICK_MULTIPLIER); // Setting degrees per pulse. Now the value from getDistance is in degrees.
	}

	@Override
	public void setPosition(double position) {
		double safePosition = motorAngleRange.limitValue(position);
		super.setPosition(safePosition);
	}

	public void setPosition(Arm.ArmState state) {
		setPosition(state.position);
	}

	@Override
	public void set(double speed) {
		if (encoder.getDistance() > ArmState.ARM_POSITION_INTAKE.position && speed < 0) {
			super.set(0);
			return;
		}
		super.set(speed);
	}

	public void setOverride(double speed) {
		super.set(speed);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MotorIdle(this));
	}
}
