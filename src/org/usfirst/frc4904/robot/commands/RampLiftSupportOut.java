package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Lifter;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RampLiftSupportOut extends CommandGroup {
	public RampLiftSupportOut() {
		requires(RobotMap.Component.liftMotor);
		addParallel(new MotorConstant(RobotMap.Component.lifter.liftMotor, Lifter.SUPPORT_MOTOR_OUT_SPEED));
	}
}