package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.autonly.farsidescalestrategies.FarRightScaleRightDistance;
import org.usfirst.frc4904.autonly.farsideswitchstrategies.FarRightSwitchRightDistance;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class RightScaleOverSwitch extends RunIfElse {
	public RightScaleOverSwitch() {
		super(new FarRightScaleRightDistance(),
			new RunIfElse(new FarRightSwitchRightDistance(), new CrossBaselineDistance(),
				RobotMap.gameField.ourSwitch::isRightOurs),
			RobotMap.gameField.scale::isRightOurs);
	}
}
