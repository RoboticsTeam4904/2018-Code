package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmBrakeSet;
import org.usfirst.frc4904.robot.commands.IndexerGrabberClasp;
import org.usfirst.frc4904.robot.commands.IndexerGrabberRelease;
import org.usfirst.frc4904.robot.commands.IntakeSquared;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.robot.commands.UnequalIntake;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.LogKitten.KittenLevel;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorControl;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.humaninput.Operator;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class DefaultOperator extends Operator {
	public DefaultOperator() {
		super("Default Operator");
	}

	public DefaultOperator(String name) {
		super(name);
	}

	@Override
	public void bindCommands() {
		RobotMap.HumanInput.Operator.joystick.button1.onlyWhileReleased(new ArmBrakeSet(true));
		RobotMap.HumanInput.Operator.joystick.button1.onlyWhileHeld(
			new MotorControl(RobotMap.Component.arm, RobotMap.HumanInput.Operator.joystick, CustomJoystick.Y_AXIS,
				Arm.ARM_SPEED_SCALE));
		RobotMap.Component.joystick.button3.onlyWhileHeld(new IntakeSquared());
		RobotMap.Component.joystick.button4.onlyWhileHeld(new OuttakeSquared());
		RobotMap.Component.joystick.button5.whenPressed(new IndexerGrabberRelease());
		RobotMap.Component.joystick.button6.whenPressed(new IndexerGrabberClasp());
		RobotMap.Component.joystick.button8.onlyWhileHeld(new UnequalIntake());
		Command rotate = new RotateIntake();
		RobotMap.Component.joystick.button10.onlyWhileHeld(rotate);
		LogKitten.wtf("is interruptible" + rotate.isInterruptible());
	}

	public static class RotateIntake extends CommandGroup {
		public RotateIntake() {
			addSequential(new RunFor(new UnequalIntake(), 2.0));
			addSequential(new KittenCommand("dones", KittenLevel.WTF));
			addSequential(new IntakeSquared());
		}

		@Override
		public synchronized void cancel() {
			super.cancel();
			LogKitten.wtf("canceling");
		}
	}
}
