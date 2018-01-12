package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;

public class RightSideDistance extends SideSwitchDistance {
	public RightSideDistance () {
		super(RobotMap.gamefield.ourSwitch.right);
	}
}