package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.RollyBOI;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class OuttakeSquared extends CommandGroup {
	public OuttakeSquared() {
		super("OuttakeSquared");
		addParallel(new IndexerOuttake(RollyBOI.OUTTAKE_SPEED));
		addParallel(new IntakeRollersOuttake());
	}
}
