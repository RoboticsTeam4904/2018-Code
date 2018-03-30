package org.usfirst.frc4904.autonly.farsideswitchstrategies;


import org.usfirst.frc4904.autonly.OuttakeSwitch;
import org.usfirst.frc4904.autonly.SafeVisionCubeIntake;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurnAbsolute;

public class FarLeftSwitchLeftDistance extends FarSideSwitchStrategy {
	public FarLeftSwitchLeftDistance() {
		// Move backwards to switch (on side though)
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, -DISTANCE_CLOSE_SWITCH, RobotMap.Component.drivePID));
		// Turn left to face switch (face the right)
		addSequential(
			new ChassisTurnAbsolute(RobotMap.Component.chassis, 90, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC));
		// Lift arm, drive, outtake to switch, and reset robot position
		addSequential(new RunIf(new OuttakeSwitch(DISTANCE_APPROACH_SWITCH), () -> {
			return RobotMap.gameField.ourSwitch.isLeftOurs();
		}));
		addSequential(new SafeVisionCubeIntake());
	}
}
