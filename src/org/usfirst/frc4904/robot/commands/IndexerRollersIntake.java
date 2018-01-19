package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.RollyBOI;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;


public class IndexerRollersIntake extends MotorConstant {

	public IndexerRollersIntake() {
		super(RobotMap.Component.rollyBOI.roller, RollyBOI.INTAKE_SPEED);
	}
	

}