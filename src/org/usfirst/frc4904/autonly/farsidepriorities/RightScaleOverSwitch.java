package org.usfirst.frc4904.autonly.farsidepriorities;


import org.usfirst.frc4904.autonly.CrossBaselineDistance;
import org.usfirst.frc4904.autonly.Strategy;
import org.usfirst.frc4904.autonly.farsidescalestrategies.FarRightScaleLeftDistance;
import org.usfirst.frc4904.autonly.farsideswitchstrategies.FarRightSwitchRightDistance;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class RightScaleOverSwitch extends Strategy {
	public RightScaleOverSwitch() {
		addSequential(new RunIfElse(new KittenCommand("Scale", LogKitten.LEVEL_WTF),
			new RunIfElse(new KittenCommand("Switch", LogKitten.LEVEL_WTF), new KittenCommand("baseline", LogKitten.LEVEL_WTF),
				() -> {
					return RobotMap.gameField.ourSwitch.isRightOurs();
				}),
			() -> {
				return RobotMap.gameField.scale.isRightOurs();
			}));
		addSequential(new RunIfElse(new FarRightScaleLeftDistance(),
			new RunIfElse(new FarRightSwitchRightDistance(), new CrossBaselineDistance(true),
				() -> {
					return RobotMap.gameField.ourSwitch.isRightOurs();
				}),
			() -> {
				return RobotMap.gameField.scale.isRightOurs();
			}));
	}

	@Override
	public void setup() {}
}
