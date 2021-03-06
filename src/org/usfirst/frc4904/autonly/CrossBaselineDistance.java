package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;

public class CrossBaselineDistance extends Strategy {
	public static final double CROSSBASELINE_DIST = AutonFieldMeasurements.ALLIANCE_SWITCH_DISTANCE - RobotMap.Metrics.LENGTH
		+ 15;

	public CrossBaselineDistance(boolean backwards) {
		if (backwards) {
			addSequential(
				new ChassisMoveDistance(RobotMap.Component.chassis, -CROSSBASELINE_DIST, RobotMap.Component.drivePID));
		} else {
			addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, CROSSBASELINE_DIST, RobotMap.Component.drivePID));
		}
	}

	public CrossBaselineDistance() {
		this(false);
	}

	@Override
	public void setup() {}
}
