package org.usfirst.frc4904.autonly.farsidescalestrategies;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class FarRightScaleDistance extends RunIfElse {
	public FarRightScaleDistance() {
		super(new FarRightScaleRightDistance(), new FarRightScaleLeftDistance(), () -> {
			return RobotMap.gameField.scale.isRightOurs();
		});
	}
}
