package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.standard.LogKitten.KittenLevel;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.RunIf;

public class LeftSideTime extends SideSwitchTime {
	public LeftSideTime() {
		super();
		addSequential(new KittenCommand(
			"Is the left switch ours: " + Boolean.toString(RobotMap.gameField.ourSwitch.isLeftOurs()), KittenLevel.WTF));
		addSequential(new RunIf(new RunFor(new OuttakeSquared(), SideSwitchTime.TIME_OUTTAKE), () -> {
			return RobotMap.gameField.ourSwitch.isLeftOurs();
		}));
	}
}
