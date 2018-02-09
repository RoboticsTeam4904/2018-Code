package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.commands.motor.MotorIdle;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CrateIO extends Subsystem {	
	public static final double INTAKE_SPEED = 0.5;
	public static final double OUTTAKE_SPEED = -0.5;
	public Motor rollerLeft;
	public Motor rollerRight;
	
	public CrateIO(Motor rollerLeft, Motor rollerRight) {
		this.rollerLeft = rollerLeft;
		this.rollerRight = rollerRight;
	}

	@Override
	protected void initDefaultCommand() {
//		setDefaultCommand(new MotorIdle(roller));
	}

	public void set(double speed) {
		rollerLeft.set(speed);
		rollerRight.set(speed);
	}

}
