package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem{
	
	public final Motor elbowMotorA;
	public final Motor elbowMotorB;
	public final Motor wristMotorA;
	public final Motor wristMotorB;
	
	public Arm (Motor elbowMotorA, Motor elbowMotorB, Motor wristMotorA, Motor wristMotorB) {
		this.elbowMotorA = elbowMotorA;
		this.elbowMotorB = elbowMotorB;
		this.wristMotorA = wristMotorA;
		this.wristMotorB = wristMotorB;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub. Call the other command
		
	}
	
	
}
