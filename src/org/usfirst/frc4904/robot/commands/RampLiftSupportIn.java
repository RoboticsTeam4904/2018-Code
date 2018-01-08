package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Lifter;
import org.usfirst.frc4904.standard.commands.SingleOp;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RampLiftSupportIn extends Command {
	public RampLiftSupportIn() {
		requires(RobotMap.Component.lifter);	
	}
	
	@Override
	protected void initialize() {
		RobotMap.Component.lifter.extender.set(Lifter.SUPPORT_SOLENOID_LOWERED);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}