package org.usfirst.frc4904.robot.humaninterface.drivers;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import org.usfirst.frc4904.standard.humaninput.Driver;
import edu.wpi.first.wpilibj.command.Command;

public class DefaultGain extends Driver {
	public static final double SPEED_GAIN = 1;
	public static final double SPEED_EXP = 2;
	public static final double TURN_GAIN = 1;
	public static final double TURN_EXP = 2;
	public static final double CLIMB_GAIN = 1;
	public static final double CLIMB_EXP = 2;
	public static final double Y_SPEED_SCALE = 1;
	public static final double TURN_SPEED_SCALE = 1;
	public static final double PASSIVE_CLIMBER_SPIN_SPEED = 0.07;

	public DefaultGain() {
		super("DefaultGain");
	}

	protected double scaleGain(double input, double gain, double exp) {
		return Math.pow(Math.abs(input), exp) * gain * Math.signum(input);
	}

	@Override
	public void bindCommands() {}

	@Override
	public double getX() {
		return 0;
	}

	@Override
	public double getY() {
		double rawSpeed = RobotMap.Component.driverXbox.rt.getX() - RobotMap.Component.driverXbox.lt.getX();
		double speed = scaleGain(rawSpeed, DefaultGain.SPEED_GAIN, DefaultGain.SPEED_EXP)
			* DefaultGain.Y_SPEED_SCALE;
		return speed;
	}

	@Override
	public double getTurnSpeed() {
		double rawTurnSpeed = RobotMap.Component.driverXbox.leftStick.getX();
		double turnSpeed = scaleGain(rawTurnSpeed, DefaultGain.TURN_GAIN, DefaultGain.TURN_EXP)
			* DefaultGain.TURN_SPEED_SCALE;
		return turnSpeed;
	}
}