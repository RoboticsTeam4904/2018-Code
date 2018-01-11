package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CrateIO;
import edu.wpi.first.wpilibj.command.Command;


public class RollersOuttake extends Command {
	
	protected void execute() {
		set(CrateIO.OUTTAKE_SPEED);
	}

	private void set(double outtakeSpeed) {
		
		RobotMap.Component.CubeIOroller.set(outtakeSpeed);
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
}