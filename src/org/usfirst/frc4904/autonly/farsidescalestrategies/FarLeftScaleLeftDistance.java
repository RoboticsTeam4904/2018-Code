package org.usfirst.frc4904.autonly.farsidescalestrategies;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class FarLeftScaleLeftDistance extends FarSideScaleStrategy {
	public FarLeftScaleLeftDistance() {
		// Move forward to scale (on side though)
		addSequential(
			new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_CLOSE_SCALE,
				RobotMap.Component.drivePID));
		// Turn backwards for outtake
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		// Raise arm to scale height
		addSequential(new RunIf(new ArmSet(Arm.ArmState.ARM_POSITION_SCALE), () -> {
			return RobotMap.gameField.scale.isLeftOurs();
		}));
		// Back up towards scale
		addSequential(new RunIf(new ChassisMoveDistance(RobotMap.Component.chassis,
			-RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_APPROACH_CLOSE_SCALE, RobotMap.Component.drivePID), () -> {
				return RobotMap.gameField.scale.isLeftOurs();
			}));
		// Outtake cube
		addSequential(new RunIf(new OuttakeSquared(), () -> {
			return RobotMap.gameField.scale.isLeftOurs();
		}));
		// Move forwards away from scale
		addSequential(new RunIf(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_APPROACH_CLOSE_SCALE, RobotMap.Component.drivePID), () -> {
				return RobotMap.gameField.scale.isLeftOurs();
			}));
	}
}
