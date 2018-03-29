package org.usfirst.frc4904.autonly.farsidescalestrategies;


import org.usfirst.frc4904.autonly.OuttakeScale;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurnAbsolute;

public class FarLeftScaleRightDistance extends FarSideScaleStrategy {
	public FarLeftScaleRightDistance() {
		// Move backwards past scale
		addSequential(
			new ChassisMoveDistance(RobotMap.Component.chassis, -DISTANCE_TO_BEHIND_SWITCH, RobotMap.Component.drivePID));
		// Turn left
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, 109, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		// Cross behind switch
		addSequential(
			new ChassisMoveDistance(RobotMap.Component.chassis, DISTANCE_CROSS_BEHIND_SWITCH, RobotMap.Component.drivePID));
		// Turn right to face away from scale
		addSequential(
			new ChassisTurnAbsolute(RobotMap.Component.chassis, ANGLE_TO_FAR_SCALE, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC));
		// Lift arm, drive, outtake to scale, and reset robot position.
		addSequential(new RunIf(new OuttakeScale(DISTANCE_APPROACH_FAR_SCALE), () -> {
			return RobotMap.gameField.scale.isRightOurs();
		}));
	}
}
