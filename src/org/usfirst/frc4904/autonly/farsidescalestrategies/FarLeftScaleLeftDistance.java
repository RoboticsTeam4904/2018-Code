package org.usfirst.frc4904.autonly.farsidescalestrategies;


import org.usfirst.frc4904.autonly.OuttakeScale;
import org.usfirst.frc4904.autonly.SafeVisionCubeIntake;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class FarLeftScaleLeftDistance extends FarSideScaleStrategy {
	public FarLeftScaleLeftDistance() {
		// Move backwards towards scale
		addSequential(
			new ChassisMoveDistance(RobotMap.Component.chassis, -DISTANCE_CLOSE_SCALE, RobotMap.Component.drivePID));
		// Turn right to face away from scale
		addSequential(new ChassisTurn(RobotMap.Component.chassis, ANGLE_TO_CLOSE_SCALE, RobotMap.Component.navx,
			RobotMap.Component.chassisTurnMC));
		// Lift arm, drive, outtake to scale, and reset robot position
		addSequential(new RunIf(new OuttakeScale(DISTANCE_APPROACH_SCALE), () -> {
			return RobotMap.gameField.scale.isLeftOurs();
		}));
		addSequential(new RunIf(new SafeVisionCubeIntake(), () -> {
			return RobotMap.gameField.scale.isLeftOurs();
		}));
	}
}
