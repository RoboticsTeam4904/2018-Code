package org.usfirst.frc4904.autonly.farsidepriorities;


import org.usfirst.frc4904.autonly.CrossBaselineDistance;
import org.usfirst.frc4904.autonly.farsidescalestrategies.FarLeftScaleLeftDistance;
import org.usfirst.frc4904.autonly.farsideswitchstrategies.FarLeftSwitchLeftDistance;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class LeftSwitchOverScale extends RunIfElse {
	public LeftSwitchOverScale() {
		super(new FarLeftSwitchLeftDistance(),
			new RunIfElse(new FarLeftScaleLeftDistance(), new CrossBaselineDistance(false),
				RobotMap.gameField.scale::isLeftOurs),
			RobotMap.gameField.ourSwitch::isLeftOurs);
	}
}
