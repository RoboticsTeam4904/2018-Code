package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.Noop;

public class LeftSideDistance extends SideSwitchDistance {
	public LeftSideDistance () {
		super();
	}
	
	@Override
	public void initialize() { //TODO: Replace with actual deployment code.
		super.initialize();
		if(RobotMap.gameField.ourSwitch.left == RobotMap.gameField.team){
			addSequential(new Noop());
		}
	}
}
