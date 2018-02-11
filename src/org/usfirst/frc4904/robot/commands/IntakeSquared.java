package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeSquared extends CommandGroup {
	public IntakeSquared() {
		super("IntakeSquared");
		requires(RobotMap.Component.crateIO);
		requires(RobotMap.Component.rollyBOI);
		// addParallel(new SingleOp(() -> RobotMap.Component.rollyBOI.grabber.set(RollyBOI.RELEASED)));
		addParallel(new IntakeRollersIntake());
		addParallel(new IndexerIntake());
	}
}
