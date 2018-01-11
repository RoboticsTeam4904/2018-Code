package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.Noop;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisConstant;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SideSwitchTime extends CommandGroup {
	public static final double TIME_APPROACH_SWITCH = -1; // TODO: Replace with real time

    public SideSwitchTime(Alliance switchSideAlliance) { //TODO: Add rest of code.
        addSequential(new ChassisConstant(RobotMap.Component.chassis, 0, AutonConfig.DEAD_RECKON_DRIVE_SPEED, 0,
			SideSwitchTime.TIME_APPROACH_SWITCH));
        addSequential(new RunIf(new Noop(), () -> switchSideAlliance == RobotMap.gamefield.ourTeam)); //TODO: Replace with outtake.
    }
}
