package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CrateIO;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class UnequalIntake extends CommandGroup {
	public UnequalIntake() {
		super("UnequalIntake");
		addParallel(new MotorConstant(RobotMap.Component.crateIO.rollerLeft, CrateIO.OUTTAKE_SPEED));
		addParallel(new MotorConstant(RobotMap.Component.crateIO.rollerRight, CrateIO.INTAKE_SPEED));
		addParallel(new IndexerIntake());
	}
}
