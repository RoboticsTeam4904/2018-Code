package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.IntakeSquared;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurnAbsolute;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class VisionCubeIntake extends CommandGroup {
	double cubeAngle;
	double cubeDist;

	public VisionCubeIntake() {
		cubeAngle = RobotMap.NetworkTables.cubeAngleEntry.getDoubleArray(new double[]{3600000})[0];
		cubeDist = RobotMap.NetworkTables.cubeDistanceEntry.getDoubleArray(new double[] {0})[0];
		addSequential(
			new ChassisTurnAbsolute(RobotMap.Component.chassis, cubeAngle,
				RobotMap.Component.navx,
			RobotMap.Component.chassisTurnMC));
		addSequential(
			new ChassisMoveDistance(RobotMap.Component.chassis,
				cubeDist,
				RobotMap.Component.drivePID));
		addParallel(new IntakeSquared());
	}
}
