package org.usfirst.frc4904.robot.humaninterface.operators;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.IndexerRollersIntake;
import org.usfirst.frc4904.robot.commands.IndexerRollersOuttake;
import org.usfirst.frc4904.robot.commands.RollersIntake;
import org.usfirst.frc4904.robot.commands.RollersOuttake;
import org.usfirst.frc4904.standard.humaninput.Operator;

public class DefaultOperator extends Operator {
	public DefaultOperator(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bindCommands() {
		RobotMap.Component.joystick.button1.onlyWhileHeld(new IndexerRollersIntake());
		RobotMap.Component.joystick.button2.onlyWhileHeld(new IndexerRollersOuttake());
		RobotMap.Component.joystick.button3.onlyWhileHeld(new RollersIntake());
		RobotMap.Component.joystick.button4.onlyWhileHeld(new RollersOuttake());
	}
}
