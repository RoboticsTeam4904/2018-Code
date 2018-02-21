package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.subsystems.Arm;

public class SideSwitchTime extends Strategy {
	public static final double TIME_APPROACH_SWITCH = 1; // TODO: Replace with real time
	public static final double TIME_OUTTAKE = 1.0;

	public SideSwitchTime() {
		// addSequential(new ChassisConstant(RobotMap.Component.chassis, 0, AutonConfig.DEAD_RECKON_DRIVE_SPEED, 0,
		// SideSwitchTime.TIME_APPROACH_SWITCH));
		addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
	}

	@Override
	public void setup() {}
}
