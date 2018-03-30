package org.usfirst.frc4904.autonly.farsideswitchstrategies;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class FarRightSwitchDistance extends RunIfElse {
	public FarRightSwitchDistance() {
		super(new FarRightSwitchRightDistance(), new FarRightSwitchLeftDistance(), () -> {
			return RobotMap.gameField.ourSwitch.isRightOurs();
		});
	}
}
