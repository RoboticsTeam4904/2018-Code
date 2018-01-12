package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ArmMove extends CommandGroup{
	
	public ArmMove() {
		requires(RobotMap.Component.boxio);

	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		RobotMap.Component.boxio.elbowMotorA.set(RobotMap.HumanInput.Operator.leftStick.getY());
		RobotMap.Component.boxio.elbowMotorB.set(RobotMap.HumanInput.Operator.leftStick.getY()*-1);//either *-1, or invert one motor in setup
		//TODO: is there a less ghetto way of setting both motors? Theoretically the xbox input could change in between and mess stuff up
		RobotMap.Component.boxio.wristMotorA.set(RobotMap.HumanInput.Operator.rightStick.getY());
		RobotMap.Component.boxio.wristMotorB.set(RobotMap.HumanInput.Operator.rightStick.getY()*-1);
		
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
