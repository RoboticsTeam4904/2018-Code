package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.commands.IdleMotors;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RollyBOI extends Subsystem {
	
	public static final double INTAKE_SPEED = 0.5;
	public static final double OUTTAKE_SPEED = -0.5;
	public static final boolean ARMS_IN = true;
	public static final boolean ARMS_OUT = false;
	public Motor rollerLeft;
	public Motor rollerRight;
	public DoubleSolenoid arm;
	
	public RollyBOI(Motor rollerLeft, Motor rollerRight) {
		this.rollerLeft = rollerLeft;
		this.rollerRight = rollerRight;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new IdleMotors(this, rollerLeft, rollerRight));		
	}
	
	public void set(double speed) {
		rollerLeft.set(speed);
		rollerRight.set(speed);
	}
	
	
}
