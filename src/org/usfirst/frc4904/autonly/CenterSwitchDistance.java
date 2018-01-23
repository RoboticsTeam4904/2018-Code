package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class CenterSwitchDistance extends Strategy {
	public static final double DISTANCE_APPROACH_MID = 60 - RobotMap.Metrics.LENGTH; // TODO: real values
	public static final double DISTANCE_MID_SWITCH = 97; // sqrt((140-DISTANCE_APPROACH_MID)^2 + 54^2)
	public static final double DEGREES_TURN = 34; // arctan(54/(140-DISTANCE_APPROACH_MID))

	public CenterSwitchDistance() {
		addSequential(
			new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_APPROACH_MID,
				RobotMap.Component.drivePID));
		addSequential(new RunIfElse(
			new ChassisTurn(RobotMap.Component.chassis, -1 * DEGREES_TURN, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			new ChassisTurn(RobotMap.Component.chassis, DEGREES_TURN, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			() -> {
				return RobotMap.gameField.ourSwitch.isLeftOurs();
			}));
		addSequential(
			new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_MID_SWITCH,
				RobotMap.Component.drivePID));
		// The following orients the robot to be perpendicular with the switch again. May not be necessary
		addSequential(new RunIfElse(
			new ChassisTurn(RobotMap.Component.chassis, DEGREES_TURN, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			new ChassisTurn(RobotMap.Component.chassis, -1 * DEGREES_TURN, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			() -> {
				return RobotMap.gameField.ourSwitch.isLeftOurs();
			}));
	}

	@Override
	public void setup() {}
}
