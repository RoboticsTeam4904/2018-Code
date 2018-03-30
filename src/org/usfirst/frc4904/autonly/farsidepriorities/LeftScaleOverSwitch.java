package org.usfirst.frc4904.autonly.farsidepriorities;


import org.usfirst.frc4904.autonly.CrossBaselineDistance;
import org.usfirst.frc4904.autonly.Strategy;
import org.usfirst.frc4904.autonly.farsidescalestrategies.FarLeftScaleLeftDistance;
import org.usfirst.frc4904.autonly.farsideswitchstrategies.FarLeftSwitchLeftDistance;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class LeftScaleOverSwitch extends Strategy {
	public LeftScaleOverSwitch() {
		addSequential(new RunIfElse(new KittenCommand("Scale", LogKitten.LEVEL_WTF),
			new RunIfElse(new KittenCommand("Switch", LogKitten.LEVEL_WTF), new KittenCommand("baseline", LogKitten.LEVEL_WTF),
				() -> {
					return RobotMap.gameField.ourSwitch.isLeftOurs();
				}),
			() -> {
				return RobotMap.gameField.scale.isLeftOurs();
			}));
		addSequential(new RunIfElse(new FarLeftScaleLeftDistance(),
			new RunIfElse(new FarLeftSwitchLeftDistance(), new CrossBaselineDistance(true),
				() -> {
					return RobotMap.gameField.ourSwitch.isLeftOurs();
				}),
			() -> {
				return RobotMap.gameField.scale.isLeftOurs();
			}));
	}

	@Override
	public void setup() {}
}
