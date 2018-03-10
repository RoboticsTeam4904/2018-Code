package org.usfirst.frc4904.autonly.farsideswitchstrategies;


import org.usfirst.frc4904.autonly.OuttakeSwitch;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class FarRightSwitchRightDistance extends FarSideSwitchStrategy {
	public FarRightSwitchRightDistance() {
		// Move forwards to switch (on the side though)
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DISTANCE_CLOSE_SWITCH, RobotMap.Component.drivePID));
		// Turn left
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		// Do all the outtake stuff
		addSequential(new RunIf(new OuttakeSwitch(DISTANCE_APPROACH_SWITCH), () -> {
			return RobotMap.gameField.ourSwitch.isRightOurs();
		}));
	}
}
