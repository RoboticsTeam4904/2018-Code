package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;

public class RightSideTime extends SideSwitchTime {
	public RightSideTime () {
		super(RobotMap.gamefield.ourSwitch.right);
	}
}
