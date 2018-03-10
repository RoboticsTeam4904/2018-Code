package org.usfirst.frc4904.autonly.farsideswitchstrategies;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class FarRightSwitchLeftDistance extends FarSideSwitchStrategy {
	public FarRightSwitchLeftDistance() {
		// Move forward past switch
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_TO_BEHIND_SWITCH, RobotMap.Component.drivePID));
		// Turn left
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		// Cross behind switch
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_CROSS_BEHIND_SWITCH, RobotMap.Component.drivePID));
		// Turn left
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		// Move back to be next to horizontal with switch
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_BACK_TO_SWITCH, RobotMap.Component.drivePID));
		// Turn left
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		// Raise arm to ARM_POSITION_SWITCH height
		addSequential(new RunIf(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH), () -> {
			return RobotMap.gameField.ourSwitch.isLeftOurs();
		}));
		// Move forwards to approach the switch
		addSequential(new RunIf(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_APPROACH_SWITCH, RobotMap.Component.drivePID), () -> {
				return RobotMap.gameField.ourSwitch.isRightOurs();
			}));
		// Outtake cube
		addSequential(new RunIf(new OuttakeSquared(), () -> {
			return RobotMap.gameField.ourSwitch.isRightOurs();
		}));
		// Back away from switch
		addSequential(new RunIf(new ChassisMoveDistance(RobotMap.Component.chassis,
			-RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_APPROACH_SWITCH, RobotMap.Component.drivePID), () -> {
				return RobotMap.gameField.ourSwitch.isRightOurs();
			}));
	}
}
