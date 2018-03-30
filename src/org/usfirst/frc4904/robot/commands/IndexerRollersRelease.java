package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.RollyBOI;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class IndexerRollersRelease extends CommandGroup {
	public IndexerRollersRelease() {
		super("IndexerRollersRelease");
		addParallel(new MotorConstant(RobotMap.Component.rollyBOIRollerLeft, RollyBOI.RELEASE_SPEED));
		addParallel(new MotorConstant(RobotMap.Component.rollyBOIRollerRight, RollyBOI.RELEASE_SPEED));
	}
}