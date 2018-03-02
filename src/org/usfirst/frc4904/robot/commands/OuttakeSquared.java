package org.usfirst.frc4904.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class OuttakeSquared extends CommandGroup {
	public OuttakeSquared() {
		super("OuttakeSquared");
		addParallel(new IndexerOuttake());
		addParallel(new IntakeRollersOuttake());
	}
}
