package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CrateIO;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeRollersIntake extends CommandGroup {
	public IntakeRollersIntake() {
		super("IntakeRollersIntake");
		requires(RobotMap.Component.crateIO);
		// requires(RobotMap.Component.crateIO.rollerLeft);
		// requires(RobotMap.Component.crateIO.rollerRight);
		addParallel(new KittenCommand("We is intaking boios", LogKitten.KittenLevel.WTF));
		addParallel(new MotorConstant(RobotMap.Component.crateIO.rollerLeft, CrateIO.INTAKE_SPEED));
		addParallel(new MotorConstant(RobotMap.Component.crateIO.rollerRight, CrateIO.INTAKE_SPEED));
	}
}