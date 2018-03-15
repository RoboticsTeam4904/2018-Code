package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;

public class CrossBaseline extends Strategy {
	public CrossBaseline(double approach_dist) {
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, approach_dist, RobotMap.Component.drivePID));
	}

	@Override
	public void setup() {}
}
