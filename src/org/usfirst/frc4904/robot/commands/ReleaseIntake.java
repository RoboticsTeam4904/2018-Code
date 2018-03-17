package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ReleaseIntake extends CommandGroup {
	private static final double RELEASE_SPEED = 0.3;
	private static final double RELEASE_TIME = 0.75;
	// private static final double WAIT_TIME = 0.25;

	public ReleaseIntake() {
		addSequential(
			new RunFor(new MotorConstant(RobotMap.Component.crateIORollerRight, RELEASE_SPEED), RELEASE_TIME));
		// addSequential(new WaitCommand(WAIT_TIME));
		addSequential(
			new RunFor(new MotorConstant(RobotMap.Component.crateIORollerLeft, RELEASE_SPEED), RELEASE_TIME));
	}
}
