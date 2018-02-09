package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.RollyBOI;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class IndexerRollersIntake extends CommandGroup {
	public IndexerRollersIntake() {
		super("IndexerRollersIntake");
		requires(RobotMap.Component.rollyBOI.rollerLeft);
		requires(RobotMap.Component.rollyBOI.rollerRight);
		LogKitten.wtf("doing stuff");
		addParallel(new MotorConstant(RobotMap.Component.rollyBOI.rollerLeft, RollyBOI.INTAKE_SPEED));
		addParallel(new MotorConstant(RobotMap.Component.rollyBOI.rollerRight, RollyBOI.INTAKE_SPEED));
	}
}