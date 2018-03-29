package org.usfirst.frc4904.autonly.test;


import org.usfirst.frc4904.autonly.Strategy;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.SingleOp;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurnAbsolute;

public class Square extends Strategy {
	public Square() {
		for (int i = 1; i < 5; i++) {
			addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, 40, RobotMap.Component.drivePID));
			addSequential(
				new ChassisTurnAbsolute(RobotMap.Component.chassis, -90 * i, RobotMap.Component.navx,
					RobotMap.Component.chassisTurnMC));
		}
		addSequential(new SingleOp(() -> {
			new Square().start();
		}));
	}

	@Override
	public void setup() {}
}
