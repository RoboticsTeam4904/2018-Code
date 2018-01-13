package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.commands.Idle;
import org.usfirst.frc4904.standard.custom.sensors.CANTalonEncoder;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem{
	
	public static final double ELBOW_MULTIPLIER = 1.0;
	public static final double WRIST_MULTIPLIER = 1.0;
	
	public final Motor elbowMotorA;
	public final Motor elbowMotorB;
	public final Motor wristMotorA;
	public final Motor wristMotorB;
	
	public final CANTalonEncoder elbowEncoderA;
	public final CANTalonEncoder elbowEncoderB;
	public final CANTalonEncoder wristEncoderA;
	public final CANTalonEncoder wristEncoderB;
	
	
	public Arm (Motor elbowMotorA, Motor elbowMotorB, Motor wristMotorA, Motor wristMotorB,
		CANTalonEncoder elbowEncoderA, CANTalonEncoder elbowEncoderB, CANTalonEncoder wristEncoderA,
		CANTalonEncoder wristEncoderB) {

		this.elbowMotorA = elbowMotorA;
		this.elbowMotorB = elbowMotorB;
		this.wristMotorA = wristMotorA;
		this.wristMotorB = wristMotorB;
		
		this.elbowEncoderA = elbowEncoderA;
		this.elbowEncoderB = elbowEncoderB;
		this.wristEncoderA = wristEncoderA;
		this.wristEncoderB = wristEncoderB;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub. Do whatever we want to do when we turn the robot on
		setDefaultCommand(new Idle(RobotMap.Component.boxio));
	}
	
	
}
