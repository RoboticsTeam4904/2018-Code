package org.usfirst.frc4904.robot.humaninterface.drivers;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.SingleOp;
import org.usfirst.frc4904.standard.commands.chassis.ChassisShift;
import org.usfirst.frc4904.standard.humaninput.Driver;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;

public class NathanGain extends Driver {
	public static final double SPEED_GAIN = 1;
	public static final double SPEED_EXP = 2;
	public static final double TURN_GAIN = 1;
	public static final double TURN_EXP = 2;
	public static final double Y_SPEED_SCALE = 1;
	public static final double TURN_SPEED_SCALE = 1;

	public NathanGain() {
		super("NathanGain");
	}

	protected double scaleGain(double input, double gain, double exp) {
		return Math.pow(Math.abs(input), exp) * gain * Math.signum(input);
	}

	@Override
	public void bindCommands() {
		RobotMap.HumanInput.Driver.xbox.lb
			.whenPressed(new ChassisShift(RobotMap.Component.chassis.getShifter(), SolenoidShifters.ShiftState.DOWN));
		RobotMap.HumanInput.Driver.xbox.rb
			.whenPressed(new ChassisShift(RobotMap.Component.chassis.getShifter(), SolenoidShifters.ShiftState.UP));
		RobotMap.HumanInput.Driver.xbox.x.whenReleased(new SingleOp(() -> { // TODO: change this
			RobotMap.Component.arm.encoder.resetViaOffset(6.0); // TODO: change this
		}));
		RobotMap.HumanInput.Driver.xbox.a
			.whileHeld(new ChassisShift(RobotMap.Component.chassis.getShifter(), SolenoidShifters.ShiftState.UP));
		RobotMap.HumanInput.Driver.xbox.a
			.whenReleased(new ChassisShift(RobotMap.Component.chassis.getShifter(), SolenoidShifters.ShiftState.DOWN));
	}

	@Override
	public double getX() {
		return 0;
	}

	@Override
	public double getY() {
		double rawSpeed = RobotMap.HumanInput.Driver.xbox.rt.getX() - RobotMap.HumanInput.Driver.xbox.lt.getX();
		double speed = scaleGain(rawSpeed, NathanGain.SPEED_GAIN, NathanGain.SPEED_EXP)
			* NathanGain.Y_SPEED_SCALE;
		return speed;
	}

	@Override
	public double getTurnSpeed() {
		double rawTurnSpeed = RobotMap.HumanInput.Driver.xbox.leftStick.getX();
		double turnSpeed = scaleGain(rawTurnSpeed, NathanGain.TURN_GAIN, NathanGain.TURN_EXP)
			* NathanGain.TURN_SPEED_SCALE;
		return turnSpeed;
	}
}