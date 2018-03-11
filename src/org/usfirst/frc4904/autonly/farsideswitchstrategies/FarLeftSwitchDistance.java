package org.usfirst.frc4904.autonly.farsideswitchstrategies;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class FarLeftSwitchDistance extends RunIfElse {
	public FarLeftSwitchDistance() {
		super(new FarLeftSwitchLeftDistance(), new FarLeftSwitchRightDistance(), () -> {
			return RobotMap.gameField.ourSwitch.isLeftOurs();
		});
	}
}
