package org.usfirst.frc4904.robot.humaninterface.drivers;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import org.usfirst.frc4904.standard.humaninput.Driver;
import edu.wpi.first.wpilibj.command.Command;

public class SkrtSkrt extends Driver {
	public static final double SPEED_GAIN = 1;
	public static final double SPEED_EXP = 2;
	public static final double TURN_GAIN = 1;
	public static final double TURN_EXP = 2;
	public static final double CLIMB_GAIN = 1;
	public static final double CLIMB_EXP = 2;
	public static final double Y_SPEED_SCALE = 1;
	public static final double TURN_SPEED_SCALE = 1;
	public static final double PASSIVE_CLIMBER_SPIN_SPEED = 0.07;

	public SkrtSkrt() {
		super("NathanGain");
	}

	protected double scaleGain(double input, double gain, double exp) {
		return Math.pow(Math.abs(input), exp) * gain * Math.signum(input);
	}

	@Override
	public void bindCommands() {
		Command normalDrive = new ChassisMove(RobotMap.Component.chassis, this);
	}

	@Override
	public double getX() {
		return 0;
	}

	@Override
	public double getY() {
		double rawSpeed = RobotMap.Component.driverXbox.rt.getX() - RobotMap.Component.driverXbox.lt.getX();
		double speed = scaleGain(rawSpeed, SkrtSkrt.SPEED_GAIN, SkrtSkrt.SPEED_EXP)
			* SkrtSkrt.Y_SPEED_SCALE;
		return speed;
	}

	@Override
	public double getTurnSpeed() {
		double rawTurnSpeed = RobotMap.Component.driverXbox.leftStick.getX();
		double turnSpeed = scaleGain(rawTurnSpeed, SkrtSkrt.TURN_GAIN, SkrtSkrt.TURN_EXP)
			* SkrtSkrt.TURN_SPEED_SCALE;
		return turnSpeed;
	}
}