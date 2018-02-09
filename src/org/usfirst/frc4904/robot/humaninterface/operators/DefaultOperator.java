package org.usfirst.frc4904.robot.humaninterface.operators;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.IndexerRollersIntake;
import org.usfirst.frc4904.robot.commands.IndexerRollersOuttake;
import org.usfirst.frc4904.robot.commands.IntakeRollersIntake;
import org.usfirst.frc4904.robot.commands.IntakeRollersOuttake;
import org.usfirst.frc4904.standard.humaninput.Operator;

public class DefaultOperator extends Operator {

	public DefaultOperator() {
		super("DefaultOperator");
	}

	public DefaultOperator(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bindCommands() {
		RobotMap.Component.joystick.button5.onlyWhileHeld(new IntakeRollersIntake());
		RobotMap.Component.joystick.button6.onlyWhileHeld(new IntakeRollersOuttake());
		RobotMap.Component.joystick.button3.onlyWhileHeld(new IndexerRollersIntake());
		RobotMap.Component.joystick.button4.onlyWhileHeld(new IndexerRollersOuttake());
	}
}
