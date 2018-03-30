package org.usfirst.frc4904.autonly.farsidepriorities;


import org.usfirst.frc4904.autonly.CrossBaselineDistance;
import org.usfirst.frc4904.autonly.Strategy;
import org.usfirst.frc4904.autonly.farsidescalestrategies.FarLeftScaleLeftDistance;
import org.usfirst.frc4904.autonly.farsideswitchstrategies.FarLeftSwitchLeftDistance;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class LeftSwitchOverScale extends Strategy {
	public LeftSwitchOverScale() {
		addSequential(new RunIfElse(new KittenCommand("Switch", LogKitten.LEVEL_WTF),
			new RunIfElse(new KittenCommand("Scale", LogKitten.LEVEL_WTF), new KittenCommand("baseline", LogKitten.LEVEL_WTF),
				() -> {
					return RobotMap.gameField.scale.isLeftOurs();
				}),
			() -> {
				return RobotMap.gameField.ourSwitch.isLeftOurs();
			}));
		addSequential(new RunIfElse(new FarLeftSwitchLeftDistance(),
			new RunIfElse(new FarLeftScaleLeftDistance(), new CrossBaselineDistance(true),
				() -> {
					return RobotMap.gameField.scale.isLeftOurs();
				}),
			() -> {
				return RobotMap.gameField.ourSwitch.isLeftOurs();
			}));
	}

	@Override
	public void setup() {}
}
