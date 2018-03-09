package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.robot.commands.ArmBrakeSet;
import org.usfirst.frc4904.standard.Util;
import org.usfirst.frc4904.standard.commands.motor.MotorIdle;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.CustomEncoder;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.SpeedModifier;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends PositionSensorMotor {
	public static final double ARM_SPEED_RAISE = 0.8;
	public static final double ARM_SPEED_LOWER = 0.4;
	private final double ENCODER_TICKS = 1024.0;
	private final double TICK_MULTIPLIER = 360.0 / ENCODER_TICKS;
	private static final double TICK_OFFSET = 0.0; // TODO: needs to be set
	public final CustomEncoder encoder;
	public static final Util.Range motorAngleRange = new Util.Range(ArmState.ARM_POSITION_INTAKE.position,
		ArmState.ARM_POSITION_SCALE.position);

	public enum ArmState {
		ARM_POSITION_INTAKE(0), ARM_POSITION_SWITCH(53), ARM_POSITION_SCALE(143); // TODO: need to be tweaked a lot
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

	public Arm(MotionController motionController, SpeedModifier armModifier, CustomEncoder encoder,
		SpeedController... elbowControllers) {
		super("Arm", armModifier, motionController, elbowControllers);
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
		super.set(speed);
	}

	public void setOverride(double speed) {
		super.set(speed);
	}

	public double getAngle() {
		return encoder.getDistance() + TICK_OFFSET;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MotorIdle(this));
	}

	public static class DiscBrake extends Subsystem {
		protected DoubleSolenoid brake;
		public static DoubleSolenoid.Value BRAKE_ENABLED = DoubleSolenoid.Value.kForward;
		public static DoubleSolenoid.Value BRAKE_DISABLED = DoubleSolenoid.Value.kReverse;

		public DiscBrake(DoubleSolenoid brake) {
			super("DiscBrake");
			this.brake = brake;
		}

		public void set(boolean on) {
			if (on) {
				brake.set(DiscBrake.BRAKE_ENABLED);
			} else {
				brake.set(DiscBrake.BRAKE_DISABLED);
			}
		}

		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new ArmBrakeSet(false));
		}
	}
}
