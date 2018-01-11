package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;

public class LeftSideTime extends SideSwitchTime {
	public LeftSideTime () {
		super(RobotMap.gamefield.ourSwitch.left);
	}
}
