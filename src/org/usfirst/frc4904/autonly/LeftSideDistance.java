package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.standard.LogKitten.KittenLevel;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIf;

public class LeftSideDistance extends SideSwitchDistance {
	public LeftSideDistance() {
		super();
		addSequential(new KittenCommand("Is the left switch ours: " + Boolean.toString(RobotMap.gameField.ourSwitch.isLeftOurs()), KittenLevel.WTF));
		addSequential(new RunIf(new OuttakeSquared(), () -> {
			return RobotMap.gameField.ourSwitch.isLeftOurs();
		}));
	}
}
