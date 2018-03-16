package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisConstant;

public class CrossBaselineTime extends Strategy {
	public static final double CROSSBASELINE_TIME = 2;
	public CrossBaselineTime() {
		addSequential(new ChassisConstant(RobotMap.Component.chassis, 0, AutonConfig.DEAD_RECKON_DRIVE_SPEED, 0,
			CROSSBASELINE_TIME));
	}

	@Override
	public void setup() {}
}
