package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.RollyBOI;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class IndexerRollersOuttake extends CommandGroup {

	public IndexerRollersOuttake() {
		addParallel(new MotorConstant(RobotMap.Component.rollyBOI.rollerLeft, RollyBOI.OUTTAKE_SPEED));
		addParallel(new MotorConstant(RobotMap.Component.rollyBOI.rollerRight, RollyBOI.OUTTAKE_SPEED));
	}
	

}