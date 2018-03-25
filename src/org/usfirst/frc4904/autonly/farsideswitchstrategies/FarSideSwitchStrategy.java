package org.usfirst.frc4904.autonly.farsideswitchstrategies;


import org.usfirst.frc4904.autonly.AutonFieldMeasurements;
import org.usfirst.frc4904.autonly.Strategy;
import org.usfirst.frc4904.robot.RobotMap;

public abstract class FarSideSwitchStrategy extends Strategy {
	public static final double DISTANCE_MARGIN_BEHIND_SWITCH = (AutonFieldMeasurements.SWITCH_PLATFORM_DISTANCE
		- RobotMap.Metrics.LENGTH) / 2;
	// real words yes definitely
	public static final double DISTANCE_CLOSE_SWITCH = AutonFieldMeasurements.ALLIANCE_MIDDLE_SWITCH_DISTANCE
		- RobotMap.Metrics.LENGTH / 2 - 10.0;
	public static final double DISTANCE_APPROACH_SWITCH = AutonFieldMeasurements.WALL_SWITCH_DISTANCE
		- RobotMap.Metrics.ROBOT_DISTANCE_FROM_CLOSE_WALL - RobotMap.Metrics.LENGTH / 2 + 5.0;
	public static final double DISTANCE_TO_BEHIND_SWITCH = AutonFieldMeasurements.ALLIANCE_BEHIND_SWITCH_DISTANCE
		+ DISTANCE_MARGIN_BEHIND_SWITCH - 3.0;
	public static final double DISTANCE_CROSS_BEHIND_SWITCH = AutonFieldMeasurements.WALL_SWITCH_DISTANCE
		- RobotMap.Metrics.ROBOT_DISTANCE_FROM_CLOSE_WALL + AutonFieldMeasurements.SWITCH_WIDTH
		- AutonFieldMeasurements.SWITCH_PLATE_WIDTH / 2;
	public static final double DISTANCE_BACK_TO_SWITCH = 0;
	public static final double TIME_MARGIN_BEHIND_SWITCH = 0;
	public static final double TIME_CLOSE_SWITCH = 0;
	public static final double TIME_APPROACH_CLOSE_SWITCH = 0;
	public static final double TIME_TO_BEHIND_SWITCH = 0;
	public static final double TIME_CROSS_BEHIND_SWITCH = 0;

	@Override
	public void setup() {}
}
