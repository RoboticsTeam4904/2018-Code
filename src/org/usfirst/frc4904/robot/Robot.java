package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.robot.humaninterface.operators.DefaultOperator;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import org.usfirst.frc4904.standard.custom.sensors.InvalidSensorException;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends CommandRobotBase {
	private RobotMap map = new RobotMap();

	@Override
	public void initialize() {
		driverChooser.addDefault(new NathanGain());
		operatorChooser.addDefault(new DefaultOperator());
	}

	@Override
	public void teleopInitialize() {
		teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
		teleopCommand.start();
	}

	@Override
	public void teleopExecute() {
		int[] sensorValues;
		try {
			sensorValues = RobotMap.Component.intakeSwitch.readSensor();
			SmartDashboard.putBooleanArray("IntakeSwitches", new boolean[] {sensorValues[0] == 1, sensorValues[1] == 1});
		}
		catch (InvalidSensorException e) {
			// TODO Auto-generated catch block
			LogKitten.ex(e);
		}
	}

	@Override
	public void autonomousInitialize() {}

	@Override
	public void autonomousExecute() {}

	@Override
	public void disabledInitialize() {}

	@Override
	public void disabledExecute() {}

	@Override
	public void testInitialize() {}

	@Override
	public void testExecute() {}

	@Override
	public void alwaysExecute() {}
}
