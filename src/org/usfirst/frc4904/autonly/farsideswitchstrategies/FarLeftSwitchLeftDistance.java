package org.usfirst.frc4904.autonly.farsideswitchstrategies;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class FarLeftSwitchLeftDistance extends FarSideSwitchStrategy {
	public FarLeftSwitchLeftDistance() {
		// Move forward to switch (on side though)
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_CLOSE_SWITCH, RobotMap.Component.drivePID));
		// Turn right to face switch
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, -90, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		// Raise arm to ARM_POSITION_SWITCH
		addSequential(new RunIf(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH), () -> {
			return RobotMap.gameField.ourSwitch.isLeftOurs();
		}));
		// Move forward to approach the switch
		addSequential(new RunIf(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_APPROACH_CLOSE_SWITCH, RobotMap.Component.drivePID), () -> {
				return RobotMap.gameField.ourSwitch.isLeftOurs();
			}));
		// Outtake cube
		addSequential(new RunIf(new OuttakeSquared(), () -> {
			return RobotMap.gameField.ourSwitch.isLeftOurs();
		}));
		// Back away from switch (same distance as approach but negative)
		addSequential(new RunIf(new ChassisMoveDistance(RobotMap.Component.chassis,
			-RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_APPROACH_CLOSE_SWITCH, RobotMap.Component.drivePID), () -> {
				return RobotMap.gameField.ourSwitch.isLeftOurs();
			}));
	}
}
