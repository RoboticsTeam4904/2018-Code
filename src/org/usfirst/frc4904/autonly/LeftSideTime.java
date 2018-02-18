package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIf;

public class LeftSideTime extends SideSwitchTime {
	public LeftSideTime() {
		super();
		addSequential(new RunIf(new KittenCommand("It's our switch", LogKitten.KittenLevel.WTF), () -> {
			return RobotMap.gameField.ourSwitch.isLeftOurs();
		}));
	}
}
