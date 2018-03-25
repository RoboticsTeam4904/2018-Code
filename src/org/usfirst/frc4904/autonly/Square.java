package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.SingleOp;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class Square extends Strategy {
	public Square() {
		for (int i = 0; i < 4; i++) {
			addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, 40, RobotMap.Component.drivePID));
			addSequential(
				new ChassisTurn(RobotMap.Component.chassis, -90, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		}
		addSequential(new SingleOp(() -> {
			new Square().start();
		}));
	}

	@Override
	public void setup() {}
}
