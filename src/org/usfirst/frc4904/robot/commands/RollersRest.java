package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CrateIO;
import edu.wpi.first.wpilibj.command.Command;


public class RollersRest extends Command {
	
	protected void execute() {
		set(CrateIO.AT_REST);
	}

	private void set(double atRest) {
		
		RobotMap.Component.CubeIOroller.set(atRest);
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
}