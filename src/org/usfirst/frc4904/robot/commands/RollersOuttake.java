package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.CubeIO;
import edu.wpi.first.wpilibj.command.Command;


public class RollersOuttake extends Command {
	
	protected void execute() {
		set(CubeIO.OUTTAKE_SPEED);
	}

	private void set(double outtakeSpeed) {
		
		CubeIO.roller.set(outtakeSpeed);
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
}