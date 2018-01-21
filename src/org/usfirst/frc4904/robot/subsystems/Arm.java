package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.Idle;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;
import edu.wpi.first.wpilibj.SpeedController;

public class Arm extends PositionSensorMotor {
	public static final double ELBOW_MULTIPLIER = 1.0;
	public final Motor elbowMotorA;
	public final Motor elbowMotorB;
	public final MotionController elbowMotionController;

	public Arm(MotionController motionController, SpeedController elbowControllerA, SpeedController elbowControllerB) {
		super("Arm", motionController, elbowControllerA, elbowControllerB);
		this.elbowMotorA = new Motor(elbowControllerA);
		this.elbowMotorB = new Motor(elbowControllerB);
		this.elbowMotionController = motionController;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub. Do whatever we want to do when we turn the robot on
		setDefaultCommand(new Idle(RobotMap.Component.arm));
	}
}
