package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten.KittenLevel;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class LeftSideDistance extends Strategy {
	public static final double DISTANCE_APPROACH_SWITCH = 144 - RobotMap.Metrics.LENGTH;

	public LeftSideDistance() {
		super();
		addSequential(new KittenCommand(
			"Is the left switch ours: " + Boolean.toString(RobotMap.gameField.ourSwitch.isLeftOurs()), KittenLevel.WTF));
		addSequential(new RunIfElse(new OuttakeSwitch(DISTANCE_APPROACH_SWITCH),
			new CrossBaselineDistance(), () -> {
				return RobotMap.gameField.ourSwitch.isLeftOurs();
			}));
	}

	@Override
	public void setup() {}
}
