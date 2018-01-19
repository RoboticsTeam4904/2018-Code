package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.Noop;
import org.usfirst.frc4904.standard.commands.RunIf;

public class RightSideDistance extends SideSwitchDistance {
	public RightSideDistance() {
		super();
		addSequential(new RunIf(new Noop(), () -> {
			return RobotMap.gameField.ourSwitch.isRightOurs();
		}));
	}
}
