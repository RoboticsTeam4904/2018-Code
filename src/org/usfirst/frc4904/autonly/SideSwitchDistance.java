package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.Noop;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SideSwitchDistance extends CommandGroup {
	public static final double DISTANCE_APPROACH_SWITCH = 9; // TODO: Test this ditance.

    public SideSwitchDistance(Alliance switchSideAlliance) { //TODO: Add rest of code.
        addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.Metrics.Wheel.TICKS_PER_INCH * this.DISTANCE_APPROACH_SWITCH, RobotMap.Component.drivePID));
        addSequential(new RunIf(new Noop(), () -> switchSideAlliance == RobotMap.gamefield.ourTeam)); //TODO: Replace with outtake.
    }
}
