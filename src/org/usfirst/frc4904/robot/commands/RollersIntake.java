package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CrateIO;
import edu.wpi.first.wpilibj.command.Command;


public class RollersIntake extends Command {
	
	protected void execute() {
		set(CrateIO.INTAKE_SPEED);
	}

	private void set(double intakeSpeed) {
		
		RobotMap.Component.CubeIOroller.set(intakeSpeed);
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
}