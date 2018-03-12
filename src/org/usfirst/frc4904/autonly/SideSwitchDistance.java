package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.LogKitten.KittenLevel;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;

public class SideSwitchDistance extends Strategy {
	public static final double DISTANCE_APPROACH_SWITCH = 144 - RobotMap.Metrics.LENGTH; // TODO: Test this distance.
	
	public SideSwitchDistance() {
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, DISTANCE_APPROACH_SWITCH, RobotMap.Component.drivePID));
		addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
		addSequential(new KittenCommand("Finished lifting arm", KittenLevel.WTF));
	}

	@Override
	public void setup() {}
}
