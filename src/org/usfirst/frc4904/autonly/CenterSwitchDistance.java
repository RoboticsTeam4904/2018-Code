package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class CenterSwitchDistance extends Strategy {
	public static final double DISTANCE_APPROACH_MID = -1; //TODO: real values
	public static final double DISTANCE_MID_SWITCH = -1;
	public static final double DEGREES_TURN_LEFT = -1;
	public static final double DEGREES_TURN_RIGHT = -1;

	public CenterSwitchDistance() {
        addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_APPROACH_MID,
        	RobotMap.Component.drivePID));
        addSequential(new RunIfElse(
        	new ChassisTurn(RobotMap.Component.chassis, DEGREES_TURN_LEFT, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC), 
        	new ChassisTurn(RobotMap.Component.chassis, DEGREES_TURN_RIGHT, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC),
        	() -> {
        		return RobotMap.gameField.ourSwitch.isLeftOurs();
        	}));
        addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_MID_SWITCH,
        	RobotMap.Component.drivePID));
	}

	@Override
	public void setup() {}
}
