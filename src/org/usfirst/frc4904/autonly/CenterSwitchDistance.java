package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurnAbsolute;

public class CenterSwitchDistance extends Strategy {
	public static final double DISTANCE_APPROACH_MID = AutonFieldMeasurements.ALLIANCE_SWITCH_DISTANCE / 6.0;
	public static final double DISTANCE_APPROACH_SWITCH = AutonFieldMeasurements.ALLIANCE_SWITCH_DISTANCE / 3.0
		- RobotMap.Metrics.LENGTH / 2;
	private static final double x_distance = (AutonFieldMeasurements.SWITCH_WIDTH - AutonFieldMeasurements.SWITCH_PLATE_WIDTH)
		/ 2.0;
	private static final double x_distance_right = x_distance - 7.5;
	private static final double x_distance_left = x_distance + 7.5;
	private static final double y_distance = AutonFieldMeasurements.ALLIANCE_SWITCH_DISTANCE - DISTANCE_APPROACH_MID
		- DISTANCE_APPROACH_SWITCH - RobotMap.Metrics.LENGTH / 2;
	public static final double DISTANCE_MID_RIGHT = Math
		.sqrt(x_distance_right * x_distance_right + y_distance * y_distance);
	public static final double DISTANCE_MID_LEFT = Math
		.sqrt(x_distance_left * x_distance_left + y_distance * y_distance);
	public static final double DEGREES_TURN_RIGHT = -Math.toDegrees(Math
		.atan(y_distance / x_distance_right)) + 9;
	public static final double DEGREES_TURN_LEFT = Math.toDegrees(Math
		.atan(y_distance / x_distance_left));

	public CenterSwitchDistance() {
		addSequential(
			new ChassisMoveDistance(RobotMap.Component.chassis, DISTANCE_APPROACH_MID, RobotMap.Component.drivePID));
		addSequential(new RunIfElse(
			new ChassisTurnAbsolute(RobotMap.Component.chassis, DEGREES_TURN_LEFT, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			new ChassisTurnAbsolute(RobotMap.Component.chassis, DEGREES_TURN_RIGHT, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			() -> {
				return RobotMap.gameField.ourSwitch.isLeftOurs();
			}));
		if (AutonConfig.EARLY_ARM_RAISE) {
			addParallel(new DelayedArmSet(Arm.ArmState.ARM_POSITION_SWITCH, 0.4));
		}
		addSequential(new RunIfElse(
			new ChassisMoveDistance(RobotMap.Component.chassis, DISTANCE_MID_LEFT, RobotMap.Component.drivePID),
			new ChassisMoveDistance(RobotMap.Component.chassis, DISTANCE_MID_RIGHT, RobotMap.Component.drivePID),
			() -> {
				return RobotMap.gameField.ourSwitch.isLeftOurs();
			}));
		// The following orients the robot to be perpendicular with the switch again. May not be necessary
		addSequential(new ChassisTurnAbsolute(RobotMap.Component.chassis, 0, RobotMap.Component.navx,
			RobotMap.Component.chassisTurnMC));
		addSequential(new OuttakeSwitch(DISTANCE_APPROACH_SWITCH - 2.0, AutonConfig.EARLY_ARM_RAISE));
	}

	@Override
	public void setup() {}
}
