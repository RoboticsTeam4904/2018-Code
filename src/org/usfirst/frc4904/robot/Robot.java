package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.autonly.Field;
import org.usfirst.frc4904.standard.CommandRobotBase;
import edu.wpi.first.wpilibj.DriverStation;

public class Robot extends CommandRobotBase {
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teleopInitialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teleopExecute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void autonomousInitialize() {
		// TODO Auto-generated method stub
		String fmsData;
		fmsData = DriverStation.getInstance().getGameSpecificMessage();
		Field gamefield = new gameField(,fmsData)
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
