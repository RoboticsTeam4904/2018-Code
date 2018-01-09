package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.MilkIO;
import edu.wpi.first.wpilibj.command.Command;


public class IntakeRollers extends Command {
	
	protected void execCommand() {
		set(MilkIO.INTAKE_SPEED);
	}

	private void set(double intakeSpeed) {
		
		MilkIO.roller.set(intakeSpeed);
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
}