package org.usfirst.frc4904.autonly.farsidescalestrategies;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class FarLeftScaleRightDistance extends FarSideScaleStrategy {
	public FarLeftScaleRightDistance() {
		// Move forwards past scale
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_TO_BEHIND_SCALE, RobotMap.Component.drivePID));
		// Turn right
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, -90, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		// Cross behind scale
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_CROSS_BEHIND_SCALE, RobotMap.Component.drivePID));
		// Turn left to face away from scale
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		// Lift arm to scale height
		addSequential(new RunIf(new ArmSet(Arm.ArmState.ARM_POSITION_SCALE), () -> {
			return RobotMap.gameField.scale.isRightOurs();
		}));
		// Approach scale backwards
		addSequential(new RunIf(new ChassisMoveDistance(RobotMap.Component.chassis,
			-RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_APPROACH_FAR_SCALE, RobotMap.Component.drivePID), () -> {
				return RobotMap.gameField.scale.isRightOurs();
			}));
		// Outtake cube
		addSequential(new RunIf(new OuttakeSquared(), () -> {
			return RobotMap.gameField.scale.isRightOurs();
		}));
		// Move forwards away from scale
		addSequential(new RunIf(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_APPROACH_FAR_SCALE, RobotMap.Component.drivePID), () -> {
				return RobotMap.gameField.scale.isRightOurs();
			}));
	}
}
