package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.SensorIntake;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.RunWhile;
import org.usfirst.frc4904.standard.commands.chassis.ChassisConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeCube extends CommandGroup {
	public final float TIME_ATTEMPT_INTAKE = 2; // TODO: test
	
	public IntakeCube() {
		addParallel(new RunFor(new SensorIntake(), TIME_ATTEMPT_INTAKE));
		addParallel(new RunWhile(new ChassisConstant(RobotMap.Component.chassis, 0, AutonConfig.DEAD_RECKON_DRIVE_SPEED, 0,
			TIME_ATTEMPT_INTAKE), () -> {
				return !RobotMap.Component.crateIO.getCube();
			}));
	}
}
