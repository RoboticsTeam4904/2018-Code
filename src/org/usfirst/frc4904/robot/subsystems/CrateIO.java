package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.commands.motor.MotorIdle;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CrateIO extends Subsystem {	
	public static final double INTAKE_SPEED = 1.0;
	public static final double OUTTAKE_SPEED = -1.0;
	public Motor roller;
	
	public CrateIO(Motor roller) {
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
