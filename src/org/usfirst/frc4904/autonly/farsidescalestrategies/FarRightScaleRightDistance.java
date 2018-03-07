package org.usfirst.frc4904.autonly.farsidescalestrategies;


import org.usfirst.frc4904.autonly.OuttakeScale;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class FarRightScaleRightDistance extends FarSideScaleStrategy {
	public FarRightScaleRightDistance() {
		// Move forward to scale (line up to its side, in the exact middle of the field between the two alliance driver stations)
		addSequential(
			new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_CLOSE_SCALE,
				RobotMap.Component.drivePID));
		// Turn right to face away from scale
		addSequential(new ChassisTurn(RobotMap.Component.chassis, -90, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		// Lift arm, drive, outtake to scale, and reset robot position.
		addSequential(new RunIf(new OuttakeScale(DISTANCE_APPROACH_FAR_SCALE), () -> {
			return RobotMap.gameField.scale.isRightOurs();
		}));
	}
}
