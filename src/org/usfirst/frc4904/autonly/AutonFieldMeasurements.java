package org.usfirst.frc4904.autonly;


public class AutonFieldMeasurements {
	public static final double FIELD_WIDTH = 324;
	public static final double FIELD_LENGTH = 648;
	public static final double ALLIANCE_CUBES_DISTANCE = 98;
	public static final double ALLIANCE_BASELINE_DISTANCE = 120;
	public static final double ALLIANCE_SWITCH_DISTANCE = 140;
	public static final double ALLIANCE_PLATFORM_DISTANCE = 261.47;
	public static final double ALLIANCE_SCALE_DISTANCE = 299.65;
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