package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.LifterOut;
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
		// TODO: These are just examples for basic testing. These need to be changed.
		RobotMap.Component.operatorStick.button1.onlyWhileHeld(new LifterOut(RobotMap.Component.lifterLeft));
		RobotMap.Component.operatorStick.button2.onlyWhileHeld(new LifterOut(RobotMap.Component.lifterRight));
	}
}
