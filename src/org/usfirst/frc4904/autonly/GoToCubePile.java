package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurnAbsolute;

public class GoToCubePile extends Strategy {
	public static final double DISTANCE_TO_CUBE_PILE = 59;

	public GoToCubePile(String side) {
		switch (side) {
			case "LEFT":
				addSequential(new ChassisTurnAbsolute(RobotMap.Component.chassis, -90, RobotMap.Component.navx,
					RobotMap.Component.chassisTurnMC));
				addSequential(
					new ChassisMoveDistance(RobotMap.Component.chassis, DISTANCE_TO_CUBE_PILE, RobotMap.Component.drivePID));
			case "RIGHT":
				addSequential(
					new ChassisTurnAbsolute(RobotMap.Component.chassis, 90, RobotMap.Component.navx,
						RobotMap.Component.chassisTurnMC));
				addSequential(
					new ChassisMoveDistance(RobotMap.Component.chassis, DISTANCE_TO_CUBE_PILE, RobotMap.Component.drivePID));
		}
	}

	@Override
	public void setup() {}
}
