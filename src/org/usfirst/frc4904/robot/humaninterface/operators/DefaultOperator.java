package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmMove;
import org.usfirst.frc4904.robot.commands.IntakeSquared;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.robot.subsystems.Arm;
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
		// RobotMap.HumanInput.Operator.joystick.button1.onlyWhileReleased(new ArmBrakeSet(true));
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
		RobotMap.HumanInput.Operator.joystick.button9.whenPressed(new SingleOp(() -> {
			RobotMap.Component.arm.encoder.reset();
		}));
		RobotMap.HumanInput.Operator.joystick.button8.onlyWhileHeld(new ArmMove(Arm.ArmState.ARM_POSITION_SCALE, true));
		RobotMap.HumanInput.Operator.joystick.button10.onlyWhileHeld(new ArmMove(Arm.ArmState.ARM_POSITION_SWITCH, true));
		RobotMap.HumanInput.Operator.joystick.button12.onlyWhileHeld(new ArmMove(Arm.ArmState.ARM_POSITION_INTAKE, true));
	}
}
