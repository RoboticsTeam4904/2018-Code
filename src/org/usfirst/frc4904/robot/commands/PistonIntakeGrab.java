package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class PistonIntakeGrab extends CommandGroup {
	public PistonIntakeGrab() {
		requires(RobotMap.Component.pistonIntake);
		addParallel(new MotorConstant(RobotMap.Component.pistonIntake.roller, 0));
	}
}
