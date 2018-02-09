package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4904.standard.commands.Idle;

public class IdleMotors extends CommandGroup{
	
	public IdleMotors(Subsystem subsystem1, Subsystem subsystem2) {
		addParallel(new Idle(subsystem1));
		addParallel(new Idle(subsystem2));
	}
}
