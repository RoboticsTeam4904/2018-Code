package org.usfirst.frc4904.autonly.test;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnThenReset extends CommandGroup {
	public TurnThenReset(double degrees_turn) {
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, degrees_turn, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC));
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, -degrees_turn, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC));
	}
}
