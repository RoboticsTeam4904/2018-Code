package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.RunWhile;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurnAbsolute;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SafeVisionCubeIntake extends CommandGroup {
	public SafeVisionCubeIntake() {
		addSequential(new RunIf(new ChassisMoveDistance(RobotMap.Component.chassis,
			-0.25,
			RobotMap.Component.drivePID), () -> {
				return RobotMap.NetworkTables.Localization.distObstFrontEntry.getDouble(1.0) < 0.25;
			}));
		addSequential(new RunWhile(new ChassisTurnAbsolute(RobotMap.Component.chassis, -1,
			RobotMap.Component.navx,
			RobotMap.Component.chassisTurnMC), () -> {
				return RobotMap.NetworkTables.Cubes.distanceEntry.getDoubleArray(new double[] {4.0})[0] < 3;
			}));
		addSequential(new VisionCubeIntake());
	}
}
