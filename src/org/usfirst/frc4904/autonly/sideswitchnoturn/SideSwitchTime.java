package org.usfirst.frc4904.autonly.sideswitchnoturn;


import org.usfirst.frc4904.autonly.Strategy;

public abstract class SideSwitchTime extends Strategy {
	public static final double TIME_APPROACH_SWITCH = 4;
	public static final double TIME_RAM_SWITCH = 1.5;
	public static final double RAM_SWITCH_SPEED = 0.2;
	public static final double TIME_OUTTAKE = 2.0;

	// public SideSwitchTime() {
	// addParallel(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
	// addSequential(new ChassisConstant(RobotMap.Component.chassis, 0, AutonConfig.DEAD_RECKON_DRIVE_SPEED, 0,
	// SideSwitchTime.TIME_APPROACH_SWITCH));
	// }
	@Override
	public void setup() {}
}
