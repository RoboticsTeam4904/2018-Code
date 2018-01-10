package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.CubeIO;
import edu.wpi.first.wpilibj.command.Command;


public class RollersIntake extends Command {
	
	protected void execute() {
		set(CubeIO.INTAKE_SPEED);
	}

	private void set(double intakeSpeed) {
		
		CubeIO.roller.set(intakeSpeed);
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
}