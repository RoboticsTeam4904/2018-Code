package org.usfirst.frc4904.autonly.farsideswitchstrategies;


import org.usfirst.frc4904.autonly.Strategy;
import org.usfirst.frc4904.robot.RobotMap;

public abstract class FarSideSwitchStrategy extends Strategy {
	public static class FieldConstants {
		public static final double FIELD_WIDTH = 324;
		public static final double FIELD_LENGTH = 648;
		public static final double ALLIANCE_CUBES_DISTANCE = 98;
		public static final double ALLIANCE_BASELINE_DISTANCE = 120;
		public static final double ALLIANCE_SWITCH_DISTANCE = 140;
		public static final double ALLIANCE_PLATFORM_DISTANCE = 261.47;
		public static final double ALLIANCE_SCALE_PLATE_DISTANCE = 299.65;
		public static final double WALL_PLATFORM_DISTANCE = 95.25;
		public static final double SWITCH_PLATE_LENGTH = 56;
		public static final double SWITCH_PLATE_WIDTH = 36;
		public static final double SCALE_PLATE_LENGTH = 48;
		public static final double SCALE_PLATE_WIDTH = 36;
		public static final double WALL_SWITCH_DISTANCE = 85.25;
		public static final double WALL_SCALE_DISTANCE = 71.57;
		public static final double ALLIANCE_BEHIND_SWITCH_DISTANCE = ALLIANCE_SWITCH_DISTANCE + SWITCH_PLATE_LENGTH;
		public static final double SWITCH_PLATFORM_DISTANCE = ALLIANCE_PLATFORM_DISTANCE - ALLIANCE_BEHIND_SWITCH_DISTANCE;
		public static final double ALLIANCE_MIDDLE_SCALE_DISTANCE = FIELD_LENGTH / 2;
		public static final double SWITCH_WIDTH = FIELD_WIDTH - WALL_SWITCH_DISTANCE * 2;
		public static final double SCALE_WIDTH = FIELD_WIDTH - WALL_SCALE_DISTANCE * 2;
		public static final double PLATFORM_WIDTH = FIELD_WIDTH - WALL_PLATFORM_DISTANCE * 2;
		public static final double ALLIANCE_MIDDLE_SWITCH_DISTANCE = ALLIANCE_SWITCH_DISTANCE
			+ SWITCH_PLATE_LENGTH / 2;
	}
	public static final double DISTANCE_MARGIN_BEHIND_SWITCH = (FieldConstants.SWITCH_PLATFORM_DISTANCE
		- RobotMap.Metrics.LENGTH) / 2;
	// real words yes definitely
	public static final double DISTANCE_CLOSE_SWITCH = FieldConstants.ALLIANCE_MIDDLE_SWITCH_DISTANCE
		- RobotMap.Metrics.LENGTH / 2;
	public static final double DISTANCE_APPROACH_CLOSE_SWITCH = FieldConstants.WALL_SWITCH_DISTANCE
		- RobotMap.Metrics.ROBOT_DISTANCE_FROM_CLOSE_WALL - RobotMap.Metrics.LENGTH / 2;
	public static final double DISTANCE_TO_BEHIND_SWITCH = FieldConstants.ALLIANCE_BEHIND_SWITCH_DISTANCE
		+ DISTANCE_MARGIN_BEHIND_SWITCH;
	public static final double DISTANCE_CROSS_BEHIND_SWITCH = FieldConstants.WALL_SWITCH_DISTANCE
		- RobotMap.Metrics.ROBOT_DISTANCE_FROM_CLOSE_WALL + FieldConstants.SWITCH_WIDTH - FieldConstants.SWITCH_PLATE_WIDTH / 2;
	public static final double TIME_MARGIN_BEHIND_SWITCH = 0;
	public static final double TIME_CLOSE_SWITCH = 0;
	public static final double TIME_APPROACH_CLOSE_SWITCH = 0;
	public static final double TIME_TO_BEHIND_SWITCH = 0;
	public static final double TIME_CROSS_BEHIND_SWITCH = 0;

	@Override
	public void setup() {}
}
