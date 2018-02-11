package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CrateIO;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command allows the rollers in
 * CrateIO to spin at a constant rate
 * away from the robot, allowing it to
 * outtake cubes that are at its front.
 */
public class IntakeRollersOuttake extends Command {

	public IntakeRollersOuttake() {
		super("IntakeRollersOuttake");
		requires(RobotMap.Component.crateIO);
	}

	@Override
	protected void initialize() {
		RobotMap.Component.crateIO.set(CrateIO.OUTTAKE_SPEED);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}