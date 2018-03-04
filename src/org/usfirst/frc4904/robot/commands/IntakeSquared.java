package org.usfirst.frc4904.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeSquared extends CommandGroup {
	public IntakeSquared() {
		super("IntakeSquared");
		addParallel(new IndexerIntake());
		addParallel(new IntakeRollersIntake());
	}
}
