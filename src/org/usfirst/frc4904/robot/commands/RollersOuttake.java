package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CrateIO;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;


public class RollersOuttake extends MotorConstant {

	public RollersOuttake() {
		super(RobotMap.Component.crateIO.roller, CrateIO.OUTTAKE_SPEED);
	}
	

}