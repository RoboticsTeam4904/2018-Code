package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.autonly.Field;
import org.usfirst.frc4904.autonly.Strategy;
import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import edu.wpi.first.wpilibj.DriverStation;

public class Robot extends CommandRobotBase {
	
	@Override
	public void initialize() {
		driverChooser.addDefault(new NathanGain());
	}

	@Override
	public void teleopInitialize() {
		teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
		teleopCommand.start();
	}

	@Override
	public void teleopExecute() {
		// TODO Auto-generated method stub
	}

	@Override
	public void autonomousInitialize() {
		RobotMap.gameField.update(DriverStation.getInstance().getAlliance(), DriverStation.getInstance().getGameSpecificMessage());
		((Strategy) autoChooser.getSelected()).setup();
	}

	@Override
	public void autonomousExecute() {
		// TODO Auto-generated method stub
	}

	@Override
	public void disabledInitialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void disabledExecute() {
		// TODO Auto-generated method stub
	}

	@Override
	public void testInitialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void testExecute() {
		// TODO Auto-generated method stub
	}

	@Override
	public void alwaysExecute() {
		// TODO Auto-generated method stub
	}
}
