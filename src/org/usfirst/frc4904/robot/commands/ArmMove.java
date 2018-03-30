package org.usfirst.frc4904.robot.commands;


/*
 * ArmSet is similar to MotorPositionConstant
 * but takes an ArmState instead of an absolute position.
 */
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;

public class ArmMove extends MotorPositionConstant {
	protected final Arm.ArmState state;

	public ArmMove(Arm.ArmState state, boolean endOnArrival) {
		super(RobotMap.Component.arm, state.position, endOnArrival);
		this.state = state;
	}

	/**
	 * @see #ArmSet
	 *      endOnArrival defaults to true
	 */
	public ArmMove(Arm.ArmState state) {
		super(RobotMap.Component.arm, state.position);
		this.state = state;
	}

	public Arm.ArmState getState() {
		return state;
	}
}
