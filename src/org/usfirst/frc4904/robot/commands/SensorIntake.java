package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunWhile;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SensorIntake extends CommandGroup {
	
	public SensorIntake() {
		requires(RobotMap.Component.crateIO);
		addParallel(
			new RunWhile(new IndexerIntake(), () -> {
				return !RobotMap.Component.crateIO.getCube();
			}));

		addParallel(
			new RunWhile(new IntakeRollersIntake(), () -> { 
				return !RobotMap.Component.crateIO.getCube();
			}));
	}
}
