package org.usfirst.frc4904.autonly.farsidescalestrategies;


import org.usfirst.frc4904.autonly.AutonConfig;
import org.usfirst.frc4904.autonly.DelayedArmSet;
import org.usfirst.frc4904.autonly.OuttakeScale;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class FarRightScaleRightDistance extends FarSideScaleStrategy {
	public FarRightScaleRightDistance() {
		addParallel(new RunIf(new DelayedArmSet(Arm.ArmState.ARM_POSITION_SCALE, 2.5), () -> {
			return AutonConfig.EARLY_ARM_RAISE;
		}));
		// Move backwards towards scale
		addSequential(
			new ChassisMoveDistance(RobotMap.Component.chassis, -DISTANCE_CLOSE_SCALE, RobotMap.Component.drivePID));
		// Turn left to face away from scale
		addSequential(new ChassisTurn(RobotMap.Component.chassis, -ANGLE_TO_CLOSE_SCALE, RobotMap.Component.navx,
			RobotMap.Component.chassisTurnMC));
		// Lift arm, drive, outtake to scale, and reset robot position.
		addSequential(new RunIf(new OuttakeScale(DISTANCE_APPROACH_SCALE, AutonConfig.EARLY_ARM_RAISE), () -> {
			return RobotMap.gameField.scale.isRightOurs();
		}));
	}
}
