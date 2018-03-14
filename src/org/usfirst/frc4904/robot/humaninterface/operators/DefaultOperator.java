package org.usfirst.frc4904.robot.humaninterface.operators;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmMove;
import org.usfirst.frc4904.robot.commands.ExtenderDeploy;
import org.usfirst.frc4904.robot.commands.IndexerRollersIntake;
import org.usfirst.frc4904.robot.commands.IndexerRollersOuttake;
import org.usfirst.frc4904.robot.commands.IntakeSquared;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.robot.commands.SupportRaise;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.SingleOp;
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
		// arm
		RobotMap.HumanInput.Operator.joystick.button1.onlyWhileHeld(new RunIfElse(
			new MotorControl(RobotMap.Component.arm, RobotMap.HumanInput.Operator.joystick, CustomJoystick.Y_AXIS,
				Arm.ARM_SPEED_RAISE),
			new MotorControl(RobotMap.Component.arm, RobotMap.HumanInput.Operator.joystick, CustomJoystick.Y_AXIS,
				Arm.ARM_SPEED_LOWER),
			() -> {
				return RobotMap.HumanInput.Operator.joystick.getAxis(CustomJoystick.Y_AXIS) > 0;
			}));
		RobotMap.HumanInput.Operator.joystick.button3.onlyWhileHeld(new IntakeSquared());
		RobotMap.HumanInput.Operator.joystick.button4.onlyWhileHeld(new OuttakeSquared());
		RobotMap.HumanInput.Operator.joystick.button5.onlyWhileHeld(new IndexerRollersIntake());
		RobotMap.HumanInput.Operator.joystick.button6.onlyWhileHeld(new IndexerRollersOuttake());
		RobotMap.HumanInput.Operator.joystick.button9.whenPressed(new SingleOp(() -> {
			RobotMap.Component.arm.encoder.reset();
		}));
		RobotMap.HumanInput.Operator.joystick.button8.onlyWhileHeld(new ArmMove(Arm.ArmState.ARM_POSITION_SCALE, true));
		RobotMap.HumanInput.Operator.joystick.button10.onlyWhileHeld(new ArmMove(Arm.ArmState.ARM_POSITION_SWITCH, true));
		RobotMap.HumanInput.Operator.joystick.button12.onlyWhileHeld(new ArmMove(Arm.ArmState.ARM_POSITION_INTAKE, true));
		// Lifter
		RobotMap.Component.operatorStick.button12.onlyWhileHeld(new RunIf(
			new ExtenderDeploy(RobotMap.Component.lifterLeft), RobotMap.Component.driverXbox.rightStick::get));
		RobotMap.Component.operatorStick.button11.onlyWhileHeld(new RunIf(
			new SupportRaise(RobotMap.Component.lifterLeft),
			RobotMap.Component.driverXbox.rightStick::get,
			() -> {
				return RobotMap.Component.lifterLeft.extender.isDeployed;
			}));
		RobotMap.Component.operatorStick.button10.onlyWhileHeld(new RunIf(
			new ExtenderDeploy(RobotMap.Component.lifterRight), RobotMap.Component.driverXbox.rightStick::get));
		RobotMap.Component.operatorStick.button9.onlyWhileHeld(new RunIf(
			new SupportRaise(RobotMap.Component.lifterRight),
			() -> {
				return RobotMap.Component.lifterRight.extender.isDeployed;
			}));
		// intake
		RobotMap.Component.joystick.button3.onlyWhileHeld(new IntakeSquared());
		RobotMap.Component.joystick.button4.onlyWhileHeld(new OuttakeSquared());
	}
}
