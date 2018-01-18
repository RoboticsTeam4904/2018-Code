package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.Noop;
import org.usfirst.frc4904.standard.commands.RunIf;

public class RightSideDistance extends SideSwitchDistance {
	public RightSideDistance () {
		addSequential(new RunIf(new Noop(), () -> {
    		return RobotMap.gameField.ourSwitch.isRightOurs();
    	}));
	}
}
