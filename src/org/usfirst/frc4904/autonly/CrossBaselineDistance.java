package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;

public class CrossBaselineDistance extends Strategy {
	public static final double CROSSBASELINE_DIST = 144 - RobotMap.Metrics.LENGTH;
	public CrossBaselineDistance() {
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, CROSSBASELINE_DIST, RobotMap.Component.drivePID));
	}

	@Override
	public void setup() {}
}
