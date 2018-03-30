package org.usfirst.frc4904.autonly.farsideswitchstrategies;


import org.usfirst.frc4904.autonly.AutonConfig;
import org.usfirst.frc4904.autonly.DelayedArmSet;
import org.usfirst.frc4904.autonly.OuttakeSwitch;
import org.usfirst.frc4904.autonly.SafeVisionCubeIntake;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurnAbsolute;

public class FarLeftSwitchLeftDistance extends FarSideSwitchStrategy {
	public FarLeftSwitchLeftDistance() {
		addParallel(new RunIf(new DelayedArmSet(Arm.ArmState.ARM_POSITION_SWITCH, 0.4), () -> {
			return AutonConfig.EARLY_ARM_RAISE;
		}));
		// Move backwards to switch (on side though)
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, -DISTANCE_CLOSE_SWITCH, RobotMap.Component.drivePID));
		// Turn left to face switch (face the right)
		addSequential(
			new ChassisTurnAbsolute(RobotMap.Component.chassis, 90, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC));
		// Lift arm, drive, outtake to switch, and reset robot position
		addSequential(new RunIf(new OuttakeSwitch(DISTANCE_APPROACH_SWITCH, AutonConfig.EARLY_ARM_RAISE), () -> {
			return RobotMap.gameField.ourSwitch.isLeftOurs();
		}));
		addSequential(new SafeVisionCubeIntake());
	}
}
