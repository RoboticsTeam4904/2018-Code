package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ExtenderDeploy;
import org.usfirst.frc4904.robot.commands.IndexerRollersIntake;
import org.usfirst.frc4904.robot.commands.IndexerRollersOuttake;
import org.usfirst.frc4904.robot.commands.IntakeSquared;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.robot.commands.ReleaseIntake;
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
		// intake and indexer
		RobotMap.HumanInput.Operator.joystick.button2.whenPressed(new ReleaseIntake());
		RobotMap.HumanInput.Operator.joystick.button3.onlyWhileHeld(new IntakeSquared());
		// RobotMap.HumanInput.Operator.joystick.button3.whenReleased(new ArmMove(Arm.ArmState.ARM_POSITION_INTOOK, true));
		RobotMap.HumanInput.Operator.joystick.button4.onlyWhileHeld(new OuttakeSquared());
		RobotMap.HumanInput.Operator.joystick.button5.onlyWhileHeld(new IndexerRollersIntake());
		RobotMap.HumanInput.Operator.joystick.button6.onlyWhileHeld(new IndexerRollersOuttake());
		// arm
		RobotMap.HumanInput.Operator.joystick.button1.onlyWhileHeld(new RunIfElse(
			new MotorControl(RobotMap.Component.arm, RobotMap.HumanInput.Operator.joystick, CustomJoystick.Y_AXIS,
				Arm.ARM_SPEED_RAISE),
			new MotorControl(RobotMap.Component.arm, RobotMap.HumanInput.Operator.joystick, CustomJoystick.Y_AXIS,
				Arm.ARM_SPEED_LOWER),
			() -> {
				return RobotMap.HumanInput.Operator.joystick.getAxis(CustomJoystick.Y_AXIS) > 0;
			}));
		RobotMap.HumanInput.Operator.joystick.button7.whenPressed(new SingleOp(() -> {
			RobotMap.Component.arm.encoder.reset();
		}));
		// RobotMap.HumanInput.Operator.joystick.button7
		// .onlyWhileHeld(new ArmMove(Arm.ArmState.ARM_POSITION_INTOOK, true));
		// RobotMap.HumanInput.Operator.joystick.button8
		// .onlyWhileHeld(new ArmMove(Arm.ArmState.ARM_POSITION_INTAKE, true));
		// RobotMap.HumanInput.Operator.joystick.button10
		// .onlyWhileHeld(new ArmMove(Arm.ArmState.ARM_POSITION_SWITCH, true));
		// RobotMap.HumanInput.Operator.joystick.button12
		// .onlyWhileHeld(new ArmMove(Arm.ArmState.ARM_POSITION_SCALE, true));
		// Lifter
		// button 12 + right stick: left lifter deploy
		RobotMap.HumanInput.Operator.joystick.button12.whenPressed(new RunIf(
			new ExtenderDeploy(RobotMap.Component.lifterLeft), RobotMap.HumanInput.Driver.xbox.rightStick::get));
		// button 11 + deployed: left lifter raise
		RobotMap.HumanInput.Operator.joystick.button11.whenPressed(new RunIf(
			new SupportRaise(RobotMap.Component.lifterLeft),
			() -> {
				return RobotMap.Component.lifterLeft.extender.isDeployed && RobotMap.HumanInput.Driver.xbox.rightStick.get();
			}));
		// button 10 + right stick: right lifter deploy
		RobotMap.HumanInput.Operator.joystick.button10.whenPressed(new RunIf(
			new ExtenderDeploy(RobotMap.Component.lifterRight), RobotMap.HumanInput.Driver.xbox.rightStick::get));
		// button 9 + deployed: right lifter raise
		RobotMap.HumanInput.Operator.joystick.button9.whenPressed(new RunIf(
			new SupportRaise(RobotMap.Component.lifterRight),
			() -> {
				return RobotMap.Component.lifterRight.extender.isDeployed && RobotMap.HumanInput.Driver.xbox.rightStick.get();
			}));
	}
}
