package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.RollyBOI;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class IndexerRollersOuttake extends CommandGroup {
	public IndexerRollersOuttake() {
		super("IndexerIntake");
		addParallel(new MotorConstant(RobotMap.Component.rollyBOIRollerLeft, RollyBOI.OUTTAKE_SPEED));
		addParallel(new MotorConstant(RobotMap.Component.rollyBOIRollerRight, RollyBOI.OUTTAKE_SPEED));
	}
}