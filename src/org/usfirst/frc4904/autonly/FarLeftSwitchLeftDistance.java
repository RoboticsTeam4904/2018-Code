package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class FarLeftSwitchLeftDistance extends FarSideSwitchStrategy {
	public FarLeftSwitchLeftDistance() {
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_CLOSE_SWITCH, RobotMap.Component.drivePID));
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, -90, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		// addSequential(new RunIf(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH), () -> {
		// return RobotMap.gameField.ourSwitch.isLeftOurs();
		// }));
		addSequential(new RunIf(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_APPROACH_CLOSE_SWITCH, RobotMap.Component.drivePID), () -> {
				return RobotMap.gameField.ourSwitch.isLeftOurs();
			}));
		addSequential(new RunIf(new OuttakeSquared(), () -> {
			return RobotMap.gameField.ourSwitch.isLeftOurs();
		}));
		addSequential(new RunIf(new ChassisMoveDistance(RobotMap.Component.chassis,
			-RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_APPROACH_CLOSE_SWITCH, RobotMap.Component.drivePID), () -> {
				return RobotMap.gameField.ourSwitch.isLeftOurs();
			}));
	}
}
