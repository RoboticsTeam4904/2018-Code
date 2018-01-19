package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.commands.motor.MotorIdle;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RollyBOI extends Subsystem {
	
	public static final double INTAKE_SPEED = 0.5;
	public static final double OUTTAKE_SPEED = -0.5;
	public static final boolean ARMS_IN = true;
	public static final boolean ARMS_OUT = false;
	public Motor roller;
	public DoubleSolenoid arm;
	
	public RollyBOI(Motor roller) {
		this.roller = roller;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MotorIdle(roller));
		
	}
	
	public void set(double speed) {
		roller.set(speed);
	}
	
	
}
