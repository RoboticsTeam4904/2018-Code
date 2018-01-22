package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;

public class ArmSet extends MotorPositionConstant {
	protected final Arm.ArmState state;
	
	public ArmSet(Arm.ArmState state, boolean endOnArrival) {
		super(RobotMap.Component.arm, state.position, endOnArrival);
		this.state = state;
	}
	
	/**
	 * @see #ArmSet
	 *      endOnArrival defaults to true
	 */
	public ArmSet(Arm.ArmState state) {
		super(RobotMap.Component.arm, state.position);
		this.state = state;
	}
	
	public Arm.ArmState getState() {
		return state;
	}
}
