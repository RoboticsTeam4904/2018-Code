package org.usfirst.frc4904.autonly.farsidescalestrategies;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class FarLeftScaleDistance extends FarSideScaleStrategy {
	public FarLeftScaleDistance() {
		new RunIfElse(new FarLeftScaleLeftDistance(), new FarLeftScaleRightDistance(), () -> {
			return RobotMap.gameField.scale.isLeftOurs();
		});
	}
}
