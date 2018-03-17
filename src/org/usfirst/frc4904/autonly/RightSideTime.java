package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.IndexerOuttake;
import org.usfirst.frc4904.standard.LogKitten.KittenLevel;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.RunIf;

public class RightSideTime extends SideSwitchTime {
	public RightSideTime() {
		super();
		addSequential(new KittenCommand(
			"Is the right switch ours: " + Boolean.toString(RobotMap.gameField.ourSwitch.isRightOurs()), KittenLevel.WTF));
		addSequential(
			new RunIf(new RunFor(new IndexerOuttake(AutonConfig.AUTON_OUTTAKE_SPEED), SideSwitchTime.TIME_OUTTAKE), () -> {
				return RobotMap.gameField.ourSwitch.isRightOurs();
			}));
	}
}
