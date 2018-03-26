package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.chassis.ChassisConstant;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurnAbsolute;

public class CenterSwitchTime extends Strategy {
	public static final double TIME_APPROACH_MID = 2.0; // TODO: actual values
	public static final double TIME_MID_SWITCH = 1.2;
	public static final double TIME_MID_SCALE = 1.4;
	public static final double DEGREES_TURN_LEFT = -90.0;
	public static final double DEGREES_TURN_RIGHT = 90.0;
	public static final double DRIVE_SPEED = 0.5;

	public CenterSwitchTime() {
		addSequential(
			new ChassisConstant(RobotMap.Component.chassis, 0.0, DRIVE_SPEED, 0.0, TIME_APPROACH_MID));
		addSequential(new RunIfElse(
			new ChassisTurnAbsolute(RobotMap.Component.chassis, DEGREES_TURN_LEFT, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			new ChassisTurnAbsolute(RobotMap.Component.chassis, DEGREES_TURN_RIGHT, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			() -> {
				return RobotMap.gameField.ourSwitch.isLeftOurs();
			}));
		addSequential(
			new ChassisConstant(RobotMap.Component.chassis, 0.0, DRIVE_SPEED, 0.0, TIME_MID_SWITCH));
		addSequential(new ChassisTurnAbsolute(RobotMap.Component.chassis, 0, RobotMap.Component.navx,
			RobotMap.Component.chassisTurnMC));
		addSequential(
			new ChassisConstant(RobotMap.Component.chassis, 0.0, DRIVE_SPEED, 0.0, TIME_MID_SCALE));
	}

	@Override
	public void setup() {}
}
