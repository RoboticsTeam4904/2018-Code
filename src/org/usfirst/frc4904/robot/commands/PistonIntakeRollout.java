package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsytems.PistonIntake;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.standard.commands.SingleOp;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

/**
 * Makes the motors spin "outwards" to release a power cube. The pistons stay in the "grabbed" state because
 * if they released the cube it wouldn't touch the rollers. 
 */

public class PistonIntakeRollout extends CommandGroup {
	public PistonIntakeRollout() {
		requires(RobotMap.Component.pistonIntake);
		addParallel(new MotorConstant(RobotMap.Component.pistonIntake.rightRoller, PistonIntake.OUTTAKE_SPEED));
		addParallel(new MotorConstant(RobotMap.Component.pistonIntake.leftRoller, PistonIntake.OUTTAKE_SPEED));
		addParallel(new SingleOp(() -> RobotMap.Component.pistonIntake.piston.set(PistonIntake.GRABBED)));
	}
	
}
