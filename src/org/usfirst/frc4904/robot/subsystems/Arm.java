package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.Util;
import org.usfirst.frc4904.standard.commands.Idle;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.CustomEncoder;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;
import edu.wpi.first.wpilibj.SpeedController;

public class Arm extends PositionSensorMotor {
	public static final double ELBOW_MULTIPLIER = 1.0;
	public final Motor elbowMotorA;
	public final Motor elbowMotorB;
	public final CustomEncoder encoder;
	public final MotionController elbowMotionController;
	public final Util.Range range;
	
	public enum ArmState {
		ARM_POSITION_INTAKE(-1), ARM_POSITION_SWITCH(-1), ARM_POSITION_SCALE(-1); //TODO: real values
		public final double position;
		
		private ArmState(double position) {
			this.position = position;
		}
	}

	public Arm(MotionController motionController, CustomEncoder encoder, SpeedController elbowControllerA, SpeedController elbowControllerB) {
		super("Arm", motionController, elbowControllerA, elbowControllerB);
		this.elbowMotorA = new Motor(elbowControllerA);
		this.elbowMotorB = new Motor(elbowControllerB);
		this.elbowMotionController = motionController;
		this.encoder = encoder;
		range = new Util.Range(ArmState.ARM_POSITION_INTAKE.position, ArmState.ARM_POSITION_SCALE.position);
	}
	
	@Override
	public void setPosition(double position) {
		double safePosition = range.limitValue(position);
		super.setPosition(safePosition);
	}
	
	public void setPosition(Arm.ArmState state) {
		setPosition(state.position);
	}
	
	@Override
	public void set(double speed) {
		if (encoder.getDistance() > ArmState.ARM_POSITION_SCALE.position && speed < 0) {
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
		setDefaultCommand(new Idle(RobotMap.Component.arm));
	}
}
