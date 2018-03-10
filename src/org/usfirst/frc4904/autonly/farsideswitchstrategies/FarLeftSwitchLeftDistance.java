package org.usfirst.frc4904.autonly.farsideswitchstrategies;


import org.usfirst.frc4904.autonly.OuttakeSwitch;
import org.usfirst.frc4904.robot.RobotMap;
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
		// Do all the outtake stuff
		addSequential(new RunIf(new OuttakeSwitch(DISTANCE_APPROACH_SWITCH), () -> {
			return RobotMap.gameField.ourSwitch.isRightOurs();
		}));
	}
}
