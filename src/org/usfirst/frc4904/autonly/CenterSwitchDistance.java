package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class CenterSwitchDistance extends Strategy {
	public static final double DISTANCE_APPROACH_MID = AutonFieldMeasurements.ALLIANCE_SWITCH_DISTANCE / 4.0;
	private static final double x_distance = (AutonFieldMeasurements.SWITCH_WIDTH - AutonFieldMeasurements.SWITCH_PLATE_WIDTH)
		/ 2.0;
	private static final double y_distance = AutonFieldMeasurements.ALLIANCE_SWITCH_DISTANCE - DISTANCE_APPROACH_MID
		- RobotMap.Metrics.LENGTH / 2;
	public static final double DISTANCE_MID_SWITCH = Math
		.sqrt(x_distance * x_distance + y_distance * y_distance) - RobotMap.Metrics.LENGTH / 2;
	public static final double DEGREES_TURN_LEFT = Math
		.atan(y_distance / x_distance);
	public static final double DEGREES_TURN_RIGHT = -DEGREES_TURN_LEFT;

	public CenterSwitchDistance() {
		addSequential(
			new ChassisMoveDistance(RobotMap.Component.chassis, DISTANCE_APPROACH_MID, RobotMap.Component.drivePID));
		addSequential(new RunIfElse(
			new ChassisTurn(RobotMap.Component.chassis, DEGREES_TURN_LEFT, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			new ChassisTurn(RobotMap.Component.chassis, DEGREES_TURN_RIGHT, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			() -> {
				return RobotMap.gameField.ourSwitch.isLeftOurs();
			}));
		addSequential(new OuttakeSwitch(DISTANCE_MID_SWITCH));
		// addSequential(
		// new ChassisMoveDistance(RobotMap.Component.chassis, DISTANCE_MID_SWITCH, RobotMap.Component.drivePID));
		// // The following orients the robot to be perpendicular with the switch again. May not be necessary
		// addSequential(new RunIfElse(
		// new ChassisTurn(RobotMap.Component.chassis, -DEGREES_TURN_LEFT, RobotMap.Component.navx,
		// RobotMap.Component.chassisTurnMC),
		// new ChassisTurn(RobotMap.Component.chassis, -DEGREES_TURN_RIGHT, RobotMap.Component.navx,
		// RobotMap.Component.chassisTurnMC),
		// () -> {
		// return RobotMap.gameField.ourSwitch.isLeftOurs();
		// }));
	}

	@Override
	public void setup() {}
}
