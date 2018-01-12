package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsytems.PistonIntake;
import org.usfirst.frc4904.standard.commands.SingleOp;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class PistonIntakeRollin extends CommandGroup {
	public PistonIntakeRollin() {
		setTimeout(PistonIntake.ROLLIN_TIMEOUT_SEC);
		requires(RobotMap.Component.pistonIntake);
		addParallel(new SingleOp(() -> RobotMap.Component.pistonIntake.piston.set(PistonIntake.GRABBED)));
		addParallel(new MotorConstant(RobotMap.Component.pistonIntake.roller, PistonIntake.INTAKE_SPEED));
	}
	@Override
	protected boolean isFinished() {
		return super.isFinished() || isTimedOut();
	}
}
