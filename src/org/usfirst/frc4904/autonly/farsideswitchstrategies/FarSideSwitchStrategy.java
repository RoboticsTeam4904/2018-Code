package org.usfirst.frc4904.autonly.farsideswitchstrategies;


import org.usfirst.frc4904.autonly.Strategy;

public abstract class FarSideSwitchStrategy extends Strategy {
	public static final double DISTANCE_CLOSE_SWITCH = 0;
	public static final double DISTANCE_APPROACH_CLOSE_SWITCH = 0;
	public static final double DISTANCE_TO_BEHIND_SWITCH = 0;
	public static final double DISTANCE_CROSS_BEHIND_SWITCH = 0;
	public static final double DISTANCE_APPROACH_FAR_SWITCH = 0;
	public static final double TIME_CLOSE_SWITCH = 0;
	public static final double TIME_APPROACH_CLOSE_SWITCH = 0;
	public static final double TIME_TO_BEHIND_SWITCH = 0;
	public static final double TIME_CROSS_BEHIND_SWITCH = 0;
	public static final double TIME_APPROACH_FAR_SWITCH = 0;
	// NEW VALUES
	public static final double ALLIANCE_CUBES_DISTANCE = 98;
	public static final double ALLIANCE_BASELINE_DISTANCE = 120;
	public static final double ALLIANCE_SWITCH_DISTANCE = 140;
	public static final double ALLIANCE_MIDDLE_SWITCH_DISTANCE = 168;
	public static final double ALLIANCE_BEHIND_SWITCH_DISTANCE = 196;
	public static final double SWITCH_LENGTH = 56;
	public static final double ALLIANCE_PLATFORM_DISTANCE = 261.47;
	public static final double ALLIANCE_SCALE_DISTANCE = 288;
	public static final double ALLIANCE_SCALE_PLATE_DISTANCE = 299.65;
	public static final double ALLIANCE_MIDDLE_SCALE_DISTANCE = 324;
	public static final double SCALE_LENGTH = 72;
	public static final double SCALE_PLATE_LENGTH = 48.7;
	public static final double WALL_SWITCH_DISTANCE = 85.25;
	public static final double WALL_SCALE_PLATE_DISTANCE = 71.57;
	public static final double WALL_PLATFORM_DISTANCE = 95.25;
	public static final double SWITCH_WIDTH = 141.5;
	public static final double SCALE_WIDTH = 168.86;
	public static final double PLATFORM_WIDTH = 121.5;

	@Override
	public void setup() {}
}
