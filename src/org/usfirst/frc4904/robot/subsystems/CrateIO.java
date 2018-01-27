package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.standard.commands.motor.MotorIdle;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * CrateIO is the subsystem of rollers
 * in the front of the robot, allowing
 * it to intake/outtake cubes in front
 * of it.
 */
public class CrateIO extends Subsystem {
	public static final double INTAKE_SPEED = 0.5;
	public static final double OUTTAKE_SPEED = -0.5;
	public Motor roller;

	/**
	 * Create a new CrateIO instance.
	 * 
	 * @param roller
	 *        The motor object corresponding
	 *        to the motors for intaking
	 *        and outtaking cubes.
	 */
	public CrateIO(Motor roller) {
		this.roller = roller;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MotorIdle(roller));
	}

	public void set(double speed) {
		roller.set(speed);
	}
}
