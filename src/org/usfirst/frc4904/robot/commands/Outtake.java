package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.MilkIO;
import edu.wpi.first.wpilibj.command.Command;


public class Outtake extends Command {
	
	protected void execCommand() {
		set(MilkIO.OUTTAKE_SPEED);
	}

	private void set(double outtakeSpeed) {
		
		MilkIO.roller.set(outtakeSpeed);
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
}