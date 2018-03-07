package org.usfirst.frc4904.autonly.farsidescalestrategies;


import org.usfirst.frc4904.autonly.OuttakeScale;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class FarRightScaleLeftDistance extends FarSideScaleStrategy {
	public FarRightScaleLeftDistance() {
		// Move forwards past scale
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_TO_BEHIND_SWITCH, RobotMap.Component.drivePID));
		// Turn left
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		// Cross behind switch
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_CROSS_BEHIND_SWITCH, RobotMap.Component.drivePID));
		// Turn left to face away from scale
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		// Lift arm, drive, outtake to scale, and reset robot position.
		addSequential(new RunIf(new OuttakeScale(DISTANCE_APPROACH_FAR_SCALE), () -> {
			return RobotMap.gameField.scale.isLeftOurs();
		}));
	}
}
