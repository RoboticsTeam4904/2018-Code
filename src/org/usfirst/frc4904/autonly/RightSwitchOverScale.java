package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.autonly.farsidescalestrategies.FarRightScaleRightDistance;
import org.usfirst.frc4904.autonly.farsideswitchstrategies.FarRightSwitchRightDistance;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class RightSwitchOverScale extends RunIfElse {
	public RightSwitchOverScale() {
		super(new FarRightSwitchRightDistance(),
			new RunIfElse(new FarRightScaleRightDistance(), new CrossBaselineDistance(),
				RobotMap.gameField.scale::isRightOurs),
			RobotMap.gameField.ourSwitch::isRightOurs);
	}
}
