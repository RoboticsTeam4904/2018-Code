package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.robot.commands.MotorIdleGroup;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.custom.sensors.CANSensor;
import org.usfirst.frc4904.standard.custom.sensors.InvalidSensorException;
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
	public final CANSensor cubeSensor;
	public final Motor rollerLeft;
	public final Motor rollerRight;

	/**
	 * Create a new CrateIO instance.
	 * 
	 * @param rollerLeft
	 *        The motor object corresponding
	 *        to the left motors for intaking
	 *        and outtaking cubes.
	 * @param rollerRight
	 *        The motor object corresponding
	 *        to the right motors for intaking
	 *        and outtaking cubes.
	 */
	public CrateIO(Motor rollerLeft, Motor rollerRight, CANSensor cubeSensor) {
		this.rollerLeft = rollerLeft;
		this.rollerRight = rollerRight;
		this.cubeSensor = cubeSensor;
	}

	public boolean getCube() {
		try {
			return (cubeSensor.readSensor()[0] == 1);
		}
		catch (InvalidSensorException e) {
			LogKitten.ex(e);
			return false;
		}
	}

	@Override
	protected void initDefaultCommand() {
		new MotorIdleGroup(rollerLeft, rollerRight);
	}
}
