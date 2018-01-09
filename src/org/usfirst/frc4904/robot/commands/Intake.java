package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.MilkIO;
import edu.wpi.first.wpilibj.command.Command;


public class Intake extends Command {
	
	protected void initDefaultCommand() {
		set(MilkIO.AT_REST);
	}
	
	protected void execCommand() {
		set(MilkIO.INTAKE_SPEED);
	}

	private void set(double intakeSpeed) {
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
}
