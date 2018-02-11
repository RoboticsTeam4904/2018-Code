package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.IndexerGrabberClasp;
import org.usfirst.frc4904.robot.commands.IndexerGrabberRelease;
import org.usfirst.frc4904.robot.commands.IntakeSquared;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.standard.humaninput.Operator;

public class DefaultOperator extends Operator {
	public DefaultOperator() {
		super("DefaultOperator");
	}

	public DefaultOperator(String name) {
		super(name);
	}

	@Override
	public void bindCommands() {
		RobotMap.Component.joystick.button3.onlyWhileHeld(new IntakeSquared());
		// RobotMap.Component.joystick.button3.whenPressed(new IndexerGrabberRelease());
		// RobotMap.Component.joystick.button3.whenReleased(new IndexerGrabberClasp());
		RobotMap.Component.joystick.button4.onlyWhileHeld(new OuttakeSquared());
		RobotMap.Component.joystick.button4.whenPressed(new IndexerGrabberRelease());
		RobotMap.Component.joystick.button4.whenReleased(new IndexerGrabberClasp());
	}
}
