package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsytems.PistonIntake;
import org.usfirst.frc4904.standard.commands.SingleOp;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class PistonIntakeIntake extends CommandGroup{
	public PistonIntakeIntake() {
		requires(RobotMap.Component.pistonIntake);
		addParallel(new MotorConstant(RobotMap.Component.pistonIntake.rightRoller, PistonIntake.INTAKE_SPEED));
		addParallel(new MotorConstant(RobotMap.Component.pistonIntake.leftRoller, PistonIntake.INTAKE_SPEED));
		addParallel(new SingleOp(() -> RobotMap.Component.pistonIntake.piston.set(PistonIntake.GRABBED)));
	}
}
