package org.usfirst.frc4904.autonly.farsideswitchstrategies;


import org.usfirst.frc4904.autonly.OuttakeSwitch;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurnAbsolute;

public class FarLeftSwitchRightDistance extends FarSideSwitchStrategy {
	public FarLeftSwitchRightDistance() {
		// Move forwards past switch
		addSequential(
			new ChassisMoveDistance(RobotMap.Component.chassis, DISTANCE_TO_BEHIND_SWITCH, RobotMap.Component.drivePID));
		// Turn right
		addSequential(
			// new ChassisTurn(RobotMap.Component.chassis, -86, RobotMap.Component.navx,
			// RobotMap.Component.chassisTurnMC));
			new ChassisTurnAbsolute(RobotMap.Component.chassis, -90, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC));
		// Cross behind switch
		addSequential(
			new ChassisMoveDistance(RobotMap.Component.chassis, DISTANCE_CROSS_BEHIND_SWITCH, RobotMap.Component.drivePID));
		// Turn right
		addSequential(
			// new ChassisTurn(RobotMap.Component.chassis, -90, RobotMap.Component.navx,
			// RobotMap.Component.chassisTurnMC));
			new ChassisTurnAbsolute(RobotMap.Component.chassis, -180, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC));
		// Move back to be next to horizontal with switch
		addSequential(
			new ChassisMoveDistance(RobotMap.Component.chassis, DISTANCE_BACK_TO_SWITCH, RobotMap.Component.drivePID));
		// Turn right
		addSequential(
			// new ChassisTurn(RobotMap.Component.chassis, -90, RobotMap.Component.navx,
			// RobotMap.Component.chassisTurnMC));
			new ChassisTurnAbsolute(RobotMap.Component.chassis, -270, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC));
		// Do all the outtake stuff
		addSequential(new RunIf(new OuttakeSwitch(DISTANCE_APPROACH_SWITCH), () -> {
			return RobotMap.gameField.ourSwitch.isRightOurs();
		}));
	}
}
