package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4904.standard.commands.motor.MotorIdle;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

/**
 * Idles motors of a subsystem.
 * Used as a default command
 *
 */
public class IdleMotors extends CommandGroup{

	/**
	 * Run MotorIdle (from WPILib) in parallel on every motor
	 * from a list of motors with unrestricted size.
	 *
	 * @param subsystem
	 * @param motors
	 */
	public IdleMotors(Subsystem subsystem, Motor[] motors) {
		requires(subsystem);
		for (int i=0; i<motors.length; i++) {
			requires(motors[i]);
			addParallel(new MotorIdle(motors[i]));
		}
	}

	/**
	 * Run MotorIdle (from WPILib) in parallel on each of 2 motors.
	 *
	 * @param subsystem
	 * @param motor1
	 * @param motor2
	 */
	public IdleMotors(Subsystem subsystem, Motor motor1, Motor motor2) {
		requires(subsystem);
		requires(motor1);
		requires(motor2);
		addParallel(new MotorIdle(motor1));
		addParallel(new MotorIdle(motor2));
	}
}
