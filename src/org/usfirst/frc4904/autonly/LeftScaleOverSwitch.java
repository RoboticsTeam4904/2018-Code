package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.autonly.farsidescalestrategies.FarLeftScaleLeftDistance;
import org.usfirst.frc4904.autonly.farsideswitchstrategies.FarLeftSwitchLeftDistance;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class LeftScaleOverSwitch extends RunIfElse {
	public LeftScaleOverSwitch() {
		super(new FarLeftScaleLeftDistance(),
			new RunIfElse(new FarLeftSwitchLeftDistance(), new CrossBaselineDistance(),
				RobotMap.gameField.ourSwitch::isLeftOurs),
			RobotMap.gameField.scale::isLeftOurs);
	}
}
