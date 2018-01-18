package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;

public class LeftSideDistance extends SideSwitchDistance {
	public LeftSideDistance () {
		super(RobotMap.gamefield.ourSwitch.left);
	}
}