package org.usfirst.frc4904.autonly.farsidepriorities;


import org.usfirst.frc4904.autonly.CrossBaselineDistance;
import org.usfirst.frc4904.autonly.farsidescalestrategies.FarLeftScaleLeftDistance;
import org.usfirst.frc4904.autonly.farsideswitchstrategies.FarLeftSwitchLeftDistance;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class LeftScaleOverSwitch extends RunIfElse {
	public LeftScaleOverSwitch() {
		super(new FarLeftScaleLeftDistance(),
			new RunIfElse(new FarLeftSwitchLeftDistance(), new CrossBaselineDistance(false),
				RobotMap.gameField.ourSwitch::isLeftOurs),
			RobotMap.gameField.scale::isLeftOurs);
	}
}
