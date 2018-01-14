package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsytems.PistonIntake;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.standard.commands.SingleOp;
import org.usfirst.frc4904.standard.commands.motor.MotorIdle;

public class PistonIntakeGrab extends CommandGroup {
	public PistonIntakeGrab() {
		// Grabs a power cube by using the pistons and stopping the motors
		
		requires(RobotMap.Component.pistonIntake);
		addParallel(new MotorIdle(RobotMap.Component.pistonIntake.rightRoller));
		addParallel(new MotorIdle(RobotMap.Component.pistonIntake.leftRoller));
		addParallel(new SingleOp(() -> RobotMap.Component.pistonIntake.piston.set(PistonIntake.GRABBED)));
	}
	
}
