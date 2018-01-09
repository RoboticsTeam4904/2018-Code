package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.autonly.Field;
import org.usfirst.frc4904.robot.humaninterface.drivers.DefaultGain;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import edu.wpi.first.wpilibj.DriverStation;

public class Robot extends CommandRobotBase {
	@Override
	public void initialize() {
		driverChooser.addDefault(new DefaultGain());
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
		String fmsData;
		fmsData = DriverStation.getInstance().getGameSpecificMessage();
		Field gamefield = new Field(DriverStation.getInstance().getAlliance(), fmsData);
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
