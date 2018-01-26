package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Lifter;
import org.usfirst.frc4904.standard.commands.SingleOp;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RampLiftSupportOut extends Command {
	public RampLiftSupportOut() {
		requires(RobotMap.Component.lifterLeft);	
	}
	
	@Override
	protected void initialize() {
		RobotMap.Component.lifterLeft.extender.set(Lifter.SUPPORT_SOLENOID_RAISED);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}