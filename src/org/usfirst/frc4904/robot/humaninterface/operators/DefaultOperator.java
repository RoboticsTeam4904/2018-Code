package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.LifterOut;
import org.usfirst.frc4904.robot.commands.LifterSupportOut;
import org.usfirst.frc4904.robot.subsystems.Lifter;
import org.usfirst.frc4904.standard.commands.RunIf;
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
		RobotMap.Component.operatorStick.button1.onlyWhileHeld(new RunIf(
			new LifterOut(RobotMap.Component.lifterLeft), RobotMap.Component.driverXbox.b::get));
		RobotMap.Component.operatorStick.button3.onlyWhileHeld(new RunIf(
			new LifterSupportOut(RobotMap.Component.lifterLeft),
			RobotMap.Component.driverXbox.b::get,
			() -> {
				return RobotMap.Component.lifterLeft.extender.get() == Lifter.LIFTER_SOLENOID_RAISED;
			}));

		RobotMap.Component.operatorStick.button2.onlyWhileHeld(new RunIf(
			new LifterOut(RobotMap.Component.lifterRight), RobotMap.Component.driverXbox.b::get));
		RobotMap.Component.operatorStick.button4.onlyWhileHeld(new RunIf(
			new LifterSupportOut(RobotMap.Component.lifterRight),
			RobotMap.Component.driverXbox.b::get,
			() -> {
				return RobotMap.Component.lifterRight.extender.get() == Lifter.LIFTER_SOLENOID_RAISED;
			}));
	}
}
