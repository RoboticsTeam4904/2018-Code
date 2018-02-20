package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ReleaseIntake extends CommandGroup {
	private static double releaseSpeed = 0.3;
	private static double releaseTime = 0.5;
	private static double waitTime = 0.25;

	public ReleaseIntake() {
		addSequential(
			new RunFor(new MotorConstant(RobotMap.Component.crateIORollerRight, releaseSpeed), releaseTime));
		addSequential(new KittenCommand("First done", LogKitten.KittenLevel.WTF));
		addSequential(new WaitCommand(waitTime));
		addSequential(new KittenCommand("Second done", LogKitten.KittenLevel.WTF));
		addSequential(
			new RunFor(new MotorConstant(RobotMap.Component.crateIORollerLeft, releaseSpeed), releaseTime));
	}
}
