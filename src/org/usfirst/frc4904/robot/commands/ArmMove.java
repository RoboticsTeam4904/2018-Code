package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ArmMove extends CommandGroup {
	public ArmMove() {
		requires(RobotMap.Component.boxio);
	}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		double leftStickY = RobotMap.HumanInput.Operator.leftStick.getY();
		double rightStickY = RobotMap.HumanInput.Operator.rightStick.getY();
		RobotMap.Component.boxio.elbowMotorA.set(leftStickY);
		RobotMap.Component.boxio.elbowMotorB.set(leftStickY * -1);// either *-1, or invert one motor in setup
		// TODO: is there a less ghetto way of setting both motors? Theoretically the xbox input could change in between and mess stuff up
		RobotMap.Component.boxio.wristMotorA.set(rightStickY);
		RobotMap.Component.boxio.wristMotorB.set(rightStickY * -1);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}
}
