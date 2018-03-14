package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.Noop;
import org.usfirst.frc4904.standard.commands.RunIf;

public class RightSideTime extends SideSwitchTime {
	public RightSideTime() {
		super();
		addSequential(new RunIf(new Noop(),
			RobotMap.gameField.ourSwitch::isRightOurs
	));
	}
}
