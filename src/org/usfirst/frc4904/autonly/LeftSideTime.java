package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.standard.commands.RunIf;

public class LeftSideTime extends SideSwitchTime {
	public LeftSideTime() {
		super();
		addSequential(new RunIf(new OuttakeSquared(), () -> {
			return RobotMap.gameField.ourSwitch.isLeftOurs();
		}));
	}
}