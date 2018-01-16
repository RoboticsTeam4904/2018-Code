package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class MidSwitchDistance extends CommandGroup {
	public static final double DISTANCE_APPROACH_MID = -1; //TODO: real values
	public static final double DISTANCE_APPROACH_SWITCH = -1;
	public static final double DEGREES_TURN_LEFT = -1;
	public static final double DEGREES_TURN_RIGHT = -1;

	public MidSwitchDistance() {
        addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_APPROACH_MID,
        	RobotMap.Component.drivePID));
        addSequential(new RunIf(new ChassisTurn(RobotMap.Component.chassis, DEGREES_TURN_LEFT, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC), () -> RobotMap.gamefield.ourSwitch.left == RobotMap.gamefield.ourTeam));
        addSequential(new RunIf(new ChassisTurn(RobotMap.Component.chassis, DEGREES_TURN_RIGHT, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC), () -> RobotMap.gamefield.ourSwitch.right == RobotMap.gamefield.ourTeam));
        addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_APPROACH_SWITCH,
        	RobotMap.Component.drivePID));
	}
}
