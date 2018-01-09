package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class NearSwitchTime extends CommandGroup {
	public static final double TIME_APPROACH_SWITCH = -1;

    public NearSwitchTime() { //TODO: Add rest of code.
        addSequential(new ChassisConstant(RobotMap.Component.chassis, 0, AutonConfig.DEAD_RECKON_DRIVE_SPEED, 0,
			NearSwitchTime.TIME_APPROACH_SWITCH));
    }
}
