package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.RollyBOI;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class IndexerIntake extends CommandGroup {
	public IndexerIntake() {
		super("IndexerIntake");
		requires(RobotMap.Component.rollyBOI);
		addParallel(new IndexerGrabberRelease());
		addParallel(new MotorConstant(RobotMap.Component.rollyBOIRollerLeft, RollyBOI.INTAKE_SPEED));
		addParallel(new MotorConstant(RobotMap.Component.rollyBOIRollerRight, RollyBOI.INTAKE_SPEED));
	}
}