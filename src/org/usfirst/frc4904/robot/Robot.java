package org.usfirst.frc4904.robot;


<<<<<<< HEAD
=======
import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
>>>>>>> origin/basic-driving
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;

public class Robot extends CommandRobotBase {
<<<<<<< HEAD
	private RobotMap robotMap = new RobotMap();

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
=======
	private RobotMap map = new RobotMap();

	@Override
	public void initialize() {
		driverChooser.addDefault(new NathanGain());
>>>>>>> origin/basic-driving
	}

	@Override
	public void teleopInitialize() {
<<<<<<< HEAD
		// TODO Auto-generated method stub
=======
		teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
		teleopCommand.start();
>>>>>>> origin/basic-driving
	}

	@Override
	public void teleopExecute() {
		// TODO Auto-generated method stub
	}

	@Override
<<<<<<< HEAD
	public void autonomousInitialize() {
		// TODO Auto-generated method stub
	}
=======
	public void autonomousInitialize() {}
>>>>>>> origin/basic-driving

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
