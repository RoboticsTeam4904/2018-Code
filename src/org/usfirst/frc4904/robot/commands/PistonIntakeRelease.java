package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsytems.PistonIntake;
import org.usfirst.frc4904.standard.commands.SingleOp;
import org.usfirst.frc4904.standard.commands.motor.MotorIdle;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Releases a power cube from the pistons, setting it down.
 */
public class PistonIntakeRelease extends CommandGroup {
	public PistonIntakeRelease() {
		requires(RobotMap.Component.pistonIntake);
		addParallel(new MotorIdle(RobotMap.Component.pistonIntake.rightRoller));
		addParallel(new MotorIdle(RobotMap.Component.pistonIntake.leftRoller));
		addParallel(new SingleOp(() -> RobotMap.Component.pistonIntake.piston.set(PistonIntake.RELEASED)));
	}
}