package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.IntakeSquared;
import org.usfirst.frc4904.robot.commands.LifterOut;
import org.usfirst.frc4904.robot.commands.LifterSupportOut;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
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
		RobotMap.Component.operatorStick.button12.onlyWhileHeld(new RunIf(
			new LifterOut(RobotMap.Component.lifterLeft), RobotMap.Component.driverXbox.rightStick::get));
		RobotMap.Component.operatorStick.button11.onlyWhileHeld(new RunIf(
			new LifterSupportOut(RobotMap.Component.lifterLeft),
			RobotMap.Component.driverXbox.rightStick::get,
			() -> {
				return RobotMap.Component.lifterLeft.extender.get() == Lifter.LIFTER_SOLENOID_RAISED;
			}));

		RobotMap.Component.operatorStick.button10.onlyWhileHeld(new RunIf(
			new LifterOut(RobotMap.Component.lifterRight), RobotMap.Component.driverXbox.rightStick::get));
		RobotMap.Component.operatorStick.button9.onlyWhileHeld(new RunIf(
			new LifterSupportOut(RobotMap.Component.lifterRight),
			RobotMap.Component.driverXbox.rightStick::get,
			() -> {
				return RobotMap.Component.lifterRight.extender.get() == Lifter.LIFTER_SOLENOID_RAISED;
			}));
		RobotMap.Component.joystick.button3.onlyWhileHeld(new IntakeSquared());
		RobotMap.Component.joystick.button4.onlyWhileHeld(new OuttakeSquared());
	}
}
