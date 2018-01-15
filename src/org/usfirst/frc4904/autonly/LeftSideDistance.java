package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIf;

public class LeftSideDistance extends SideSwitchDistance {
	public LeftSideDistance () {
		addSequential(new RunIf(new KittenCommand("It's our left switch.", LogKitten.LEVEL_WTF), () -> {
    		return RobotMap.gameField.ourSwitch.left == RobotMap.gameField.team;
    	}));
	}
}
