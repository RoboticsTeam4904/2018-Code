package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.IntakeSquared;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurnAbsolute;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class VisionCubeIntake extends CommandGroup {
	double cubeAngle;
	double cubeDist;

	public VisionCubeIntake() {
		cubeAngle = RobotMap.NetworkTables.Cubes.angleEntry.getDoubleArray(new double[] {3600000})[0];
		cubeDist = RobotMap.NetworkTables.Cubes.distanceEntry.getDoubleArray(new double[] {0})[0];
		addSequential(
			new ChassisTurnAbsolute(RobotMap.Component.chassis, cubeAngle, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC));
		addParallel(new IntakeSquared());
		// TODO: DO NOT UNCOMMENT THE FOLLOWING WITHOUT FULL CHECKS TO THE REST OF THE CODE
		// addSequential(
		// new ChassisMoveDistance(RobotMap.Component.chassis, cubeDist, RobotMap.Component.drivePID));
	}
}
