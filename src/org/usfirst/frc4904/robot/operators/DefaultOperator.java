package org.usfirst.frc4904.robot.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.motor.MotorControl;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.humaninput.Operator;

public class DefaultOperator extends Operator {
	public DefaultOperator() {
		super("Default Operator");
	}
	public DefaultOperator(String name) {
		super(name);
	}

	@Override
	public void bindCommands() {
		new MotorControl(RobotMap.Component.arm, RobotMap.Component.operatorStick, CustomJoystick.Y_AXIS,
			Arm.ARM_SPEED_SCALE).start();
	}
}
