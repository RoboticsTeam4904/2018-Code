package org.usfirst.frc4904.autonly.farsidescalestrategies;


import org.usfirst.frc4904.autonly.AutonFieldMeasurements;
import org.usfirst.frc4904.autonly.Strategy;
import org.usfirst.frc4904.robot.RobotMap;

public abstract class FarSideScaleStrategy extends Strategy {
	public static final double DISTANCE_MARGIN_BEHIND_SWITCH = (AutonFieldMeasurements.SWITCH_PLATFORM_DISTANCE
		- RobotMap.Metrics.LENGTH) / 2;
	public static final double DISTANCE_CLOSE_SCALE = AutonFieldMeasurements.ALLIANCE_BEHIND_SWITCH_DISTANCE
		+ DISTANCE_MARGIN_BEHIND_SWITCH;
	public static final double DISTANCE_APPROACH_SCALE_X = AutonFieldMeasurements.WALL_SCALE_DISTANCE
		- RobotMap.Metrics.ROBOT_DISTANCE_FROM_CLOSE_WALL;
	public static final double DISTANCE_APPROACH_SCALE_Y = AutonFieldMeasurements.ALLIANCE_SCALE_DISTANCE
		- DISTANCE_CLOSE_SCALE;
	public static final double ANGLE_TO_CLOSE_SCALE = 90
		+ Math.toDegrees(Math.atan(DISTANCE_APPROACH_SCALE_Y / DISTANCE_APPROACH_SCALE_X));
	public static final double ANGLE_TO_FAR_SCALE = -Math.atan(DISTANCE_APPROACH_SCALE_Y / DISTANCE_APPROACH_SCALE_X);
	public static final double DISTANCE_APPROACH_SCALE = Math
		.sqrt(DISTANCE_APPROACH_SCALE_X * DISTANCE_APPROACH_SCALE_X + DISTANCE_APPROACH_SCALE_Y * DISTANCE_APPROACH_SCALE_Y)
		- RobotMap.Metrics.LENGTH / 2;
	public static final double DISTANCE_TO_BEHIND_SWITCH = AutonFieldMeasurements.ALLIANCE_BEHIND_SWITCH_DISTANCE
		+ DISTANCE_MARGIN_BEHIND_SWITCH;
	public static final double DISTANCE_CROSS_BEHIND_SWITCH = AutonFieldMeasurements.FIELD_WIDTH
		- RobotMap.Metrics.ROBOT_DISTANCE_FROM_CLOSE_WALL * 2;
	public static final double DISTANCE_APPROACH_FAR_SCALE = DISTANCE_APPROACH_SCALE;
	public static final double TIME_CLOSE_SCALE = 0;
	public static final double TIME_APPROACH_CLOSE_SCALE = 0;
	public static final double TIME_TO_BEHIND_SWITCH = 0;
	public static final double TIME_CROSS_BEHIND_SWITCH = 0;
	public static final double TIME_APPROACH_FAR_SCALE = 0;

	@Override
	public void setup() {}
}
