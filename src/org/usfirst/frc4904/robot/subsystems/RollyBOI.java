package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.commands.IdleMotors;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RollyBOI extends Subsystem {
	
	public static final double INTAKE_SPEED = 0.5;
	public static final double OUTTAKE_SPEED = -0.5;
	public static final DoubleSolenoid.Value RELEASED = DoubleSolenoid.Value.kReverse;
	public static final DoubleSolenoid.Value CLASPED = DoubleSolenoid.Value.kForward;
	public final Motor rollerLeft;
	public final Motor rollerRight;
	public final DoubleSolenoid grabber;
	
	public RollyBOI(Motor rollerLeft, Motor rollerRight, DoubleSolenoid grabber) {
		this.rollerLeft = rollerLeft;
		this.rollerRight = rollerRight;
		this.grabber = grabber;
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
