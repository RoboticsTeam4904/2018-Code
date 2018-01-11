package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsytems.PistonIntake;
import org.usfirst.frc4904.standard.commands.SingleOp;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class PistonIntakeRelease extends CommandGroup{
	public PistonIntakeRelease(){
		requires(RobotMap.Component.pistonIntake);
		addParallel(new MotorConstant(RobotMap.Component.pistonIntake.roller, 0));
		addParallel(new SingleOp(() -> RobotMap.Component.pistonIntake.piston.set(PistonIntake.RELEASED)));
	}
}