package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class FarLeftSwitchDistance extends FarSideSwitchStrategy {
	public FarLeftSwitchDistance() {
		new RunIfElse(new FarLeftSwitchLeftDistance(), new FarLeftSwitchRightDistance(), () -> {
			return RobotMap.gameField.ourSwitch.isLeftOurs();
		});
	}
}
