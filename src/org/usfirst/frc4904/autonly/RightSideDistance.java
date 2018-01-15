package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.Noop;

public class RightSideDistance extends SideSwitchDistance {
	public RightSideDistance () {
		super();
	}
	
	@Override
	public void initialize() { //TODO: Replace with actual deployment code.
		super.initialize();
		if(RobotMap.gameField.ourSwitch.right == RobotMap.gameField.team){
			addSequential(new Noop());
		}
	}
}
