package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.Idle;
import org.usfirst.frc4904.standard.custom.sensors.CANTalonEncoder;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
	public static final double ELBOW_MULTIPLIER = 1.0;
	public final Motor elbowMotorA;
	public final Motor elbowMotorB;
	public final Motor elbowMotorC;
	public final CANTalonEncoder elbowEncoderA;
	public final CANTalonEncoder elbowEncoderB;
	public final CANTalonEncoder elbowEncoderC;

	public Arm(Motor elbowMotorA, Motor elbowMotorB, Motor elbowMotorC, CANTalonEncoder elbowEncoderA, CANTalonEncoder elbowEncoderB, CANTalonEncoder elbowEncoderC) {
		this.elbowMotorA = elbowMotorA;
		this.elbowMotorB = elbowMotorB;
		this.elbowMotorC = elbowMotorC;
		this.elbowEncoderA = elbowEncoderA;
		this.elbowEncoderB = elbowEncoderB;
		this.elbowEncoderC = elbowEncoderC;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub. Do whatever we want to do when we turn the robot on
		setDefaultCommand(new Idle(RobotMap.Component.boxio));
	}
}
