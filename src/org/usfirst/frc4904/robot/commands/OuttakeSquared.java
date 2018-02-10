package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class OuttakeSquared extends CommandGroup {

	public OuttakeSquared() {
		super("OuttakeSquared");
		requires(RobotMap.Component.crateIO);
		requires(RobotMap.Component.rollyBOI);
		addParallel(new IndexerRollersOuttake());
		addParallel(new IntakeRollersOuttake());
	}
}
