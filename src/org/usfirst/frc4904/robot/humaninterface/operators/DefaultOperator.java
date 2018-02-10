package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.IndexerGrabberClasp;
import org.usfirst.frc4904.robot.commands.IntakeRollersIntake;
import org.usfirst.frc4904.robot.commands.IntakeRollersOuttake;
import org.usfirst.frc4904.robot.commands.IntakeSquared;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
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
		RobotMap.Component.joystick.button3.onlyWhileHeld(new IntakeSquared());
		RobotMap.Component.joystick.button3.whenReleased(new IndexerGrabberClasp());
		RobotMap.Component.joystick.button4.onlyWhileHeld(new OuttakeSquared());
		RobotMap.Component.joystick.button4.whenReleased(new IndexerGrabberClasp());
		RobotMap.Component.joystick.button5.onlyWhileHeld(new IntakeRollersIntake());
		RobotMap.Component.joystick.button6.onlyWhileHeld(new IntakeRollersOuttake());
	}
}
