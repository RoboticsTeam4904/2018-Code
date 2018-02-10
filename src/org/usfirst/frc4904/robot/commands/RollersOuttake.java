package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CrateIO;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

/**
 * This command allows the rollers in
 * CrateIO to spin at a constant rate
 * away from the robot, allowing it to
 * outtake cubes that are at its front.
 */
public class RollersOuttake extends MotorConstant {
	public RollersOuttake() {
		super(RobotMap.Component.crateIO.roller, CrateIO.OUTTAKE_SPEED);
	}
}