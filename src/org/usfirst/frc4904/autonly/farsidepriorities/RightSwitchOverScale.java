package org.usfirst.frc4904.autonly.farsidepriorities;


import org.usfirst.frc4904.autonly.CrossBaselineDistance;
import org.usfirst.frc4904.autonly.Strategy;
import org.usfirst.frc4904.autonly.farsidescalestrategies.FarRightScaleRightDistance;
import org.usfirst.frc4904.autonly.farsideswitchstrategies.FarRightSwitchLeftDistance;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class RightSwitchOverScale extends Strategy {
	public RightSwitchOverScale() {
		addSequential(new RunIfElse(new KittenCommand("Switch", LogKitten.LEVEL_WTF),
			new RunIfElse(new KittenCommand("Scale", LogKitten.LEVEL_WTF), new KittenCommand("baseline", LogKitten.LEVEL_WTF),
				() -> {
					return RobotMap.gameField.scale.isRightOurs();
				}),
			() -> {
				return RobotMap.gameField.ourSwitch.isRightOurs();
			}));
		addSequential(new RunIfElse(new FarRightSwitchLeftDistance(),
			new RunIfElse(new FarRightScaleRightDistance(), new CrossBaselineDistance(true),
				() -> {
					return RobotMap.gameField.scale.isRightOurs();
				}),
			() -> {
				return RobotMap.gameField.ourSwitch.isRightOurs();
			}));
	}

	@Override
	public void setup() {}
}
