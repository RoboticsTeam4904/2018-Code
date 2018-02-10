package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CrateIO;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This command allows the rollers in
 * CrateIO to spin at a constant rate
 * away from the robot, allowing it to
 * outtake cubes that are at its front.
 */
public class IntakeRollersOuttake extends CommandGroup {
	public IntakeRollersOuttake() {
		super("IntakeRollersOuttake");
		requires(RobotMap.Component.crateIO.rollerLeft);
		requires(RobotMap.Component.crateIO.rollerRight);
		addParallel(new MotorConstant(RobotMap.Component.crateIO.rollerLeft, CrateIO.OUTTAKE_SPEED));
		addParallel(new MotorConstant(RobotMap.Component.crateIO.rollerRight, CrateIO.OUTTAKE_SPEED));
	}
}