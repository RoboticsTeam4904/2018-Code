package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CrateIO;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command allows the rollers in
 * CrateIO to spin at a constant rate
 * towards the robot, allowing it to
 * intake cubes that are in front of it.
 */
public class IntakeRollersIntake extends Command {

	public IntakeRollersIntake() {
		super("IntakeRollersIntake");
		requires(RobotMap.Component.crateIO);
	}

	@Override
	protected void initialize() {
		RobotMap.Component.crateIO.set(CrateIO.INTAKE_SPEED);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}