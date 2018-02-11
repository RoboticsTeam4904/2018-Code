package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.standard.CommandRobotBase;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4904.robot.subsystems.arm;

public class Robot extends CommandRobotBase {
	private RobotMap robotMap = new RobotMap();

	@Override
	public void initialize() {
		autoChooser.addDefault(CenterSwitchDistance());
		autoChooser.addDefault(LeftSideDistance());
		autoChooser.addDefault(RightSideDistance());
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
		putSBSubsystemSummary();
		SmartDashboard.putNumber("Arm Angle", arm.getAngle());
		// TODO Auto-generated method stub
	}

	void putSBSubsystemSummary() {
		String summary = "";
		for (Subsystem subsystem : RobotMap.Component.mainSubsystems) {
			summary += "{" + subsystem.getName() + "} running command {" + subsystem.getCurrentCommand() + "}\n";
		}
		SmartDashboard.putString("Subsystem Overview", summary);
	}
}
