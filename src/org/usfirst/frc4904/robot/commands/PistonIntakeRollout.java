package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsytems.PistonIntake;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class PistonIntakeRollout extends CommandGroup {
	public PistonIntakeRollout() {
		// Makes the motors spin "outwards" to release a power cube
		
		requires(RobotMap.Component.pistonIntake);
		addParallel(new MotorConstant(RobotMap.Component.pistonIntake.roller, PistonIntake.OUTTAKE_SPEED));
		// Currently the motors will spin regardless of if piston is in the grabbed position
		// Don't know if this will be a problem yet
	}
	
}
