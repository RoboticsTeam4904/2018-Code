package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class IndexerOuttake extends CommandGroup {
	public IndexerOuttake(double speed) {
		this(speed, false);
	}
	
	public IndexerOuttake(double speed, boolean release) {
		super("IndexerOuttake");
		if (release) {
			addParallel(new IndexerGrabberRelease());
		}
		addParallel(new MotorConstant(RobotMap.Component.rollyBOI.rollerLeft, speed));
		addParallel(new MotorConstant(RobotMap.Component.rollyBOI.rollerRight, speed));
	}
}