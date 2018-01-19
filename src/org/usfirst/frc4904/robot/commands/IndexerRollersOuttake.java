package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.RollyBOI;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;


public class IndexerRollersOuttake extends MotorConstant {

	public IndexerRollersOuttake() {
		super(RobotMap.Component.rollyBOI.roller, RollyBOI.OUTTAKE_SPEED);
	}
	

}