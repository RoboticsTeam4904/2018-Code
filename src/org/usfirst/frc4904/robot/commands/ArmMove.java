package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ArmMove extends CommandGroup{
	
	public ArmMove() {
		requires(RobotMap.Component.boxio);
	}
}
