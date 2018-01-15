package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisConstant;

/**
 *
 */
public class SideSwitchTime extends Strategy {
	public static final double TIME_APPROACH_SWITCH = 3; // TODO: Replace with real time
	
    public SideSwitchTime() {
    	addSequential(new ChassisConstant(RobotMap.Component.chassis, 0, AutonConfig.DEAD_RECKON_DRIVE_SPEED, 0, SideSwitchTime.TIME_APPROACH_SWITCH));
    }
    
    @Override
    public void setup() {}
}
