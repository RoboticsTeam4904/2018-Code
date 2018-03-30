package org.usfirst.frc4904.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeSquared extends CommandGroup {
	public IntakeSquared() {
		super("IntakeSquared");
		// addSequential(new ArmMove(Arm.ArmState.ARM_POSITION_INTAKE));
		addParallel(new IndexerIntake());
		addParallel(new IntakeRollersIntake());
	}
}
