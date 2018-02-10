package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CrateIO;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

/**
 * This command allows the rollers in
 * CrateIO to spin at a constant rate
 * towards the robot, allowing it to
 * intake cubes that are in front of it.
 */
public class RollersIntake extends MotorConstant {
	public RollersIntake() {
		super(RobotMap.Component.crateIO.roller, CrateIO.INTAKE_SPEED);
	}
}