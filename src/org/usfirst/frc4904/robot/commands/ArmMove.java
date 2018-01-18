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
		double rightStickY = RobotMap.HumanInput.Operator.rightStick.getY();
		RobotMap.Component.boxio.elbowMotorA.set(rightStickY);
		RobotMap.Component.boxio.elbowMotorB.set(rightStickY * -1);// either *-1, or invert one motor in setup
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
