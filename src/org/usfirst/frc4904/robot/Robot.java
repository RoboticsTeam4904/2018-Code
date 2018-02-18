package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.robot.humaninterface.operators.DefaultOperator;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends CommandRobotBase {
	private RobotMap map = new RobotMap();

	@Override
	public void initialize() {
		driverChooser.addDefault(new NathanGain());
		operatorChooser.addDefault(new DefaultOperator());
		autoChooser.addDefault(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
		// autoChooser.addDefault(new LeftSideDistance());
		// autoChooser.addDefault(new RightSideDistance());
	}

	@Override
	public void teleopInitialize() {
		teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
		teleopCommand.start();
	}

	@Override
	public void teleopExecute() {}

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
	public void alwaysExecute() {
		// putSBSubsystemSummary();
		// LogKitten.wtf("Arm Brake: " + RobotMap.Component.discBrake.getCurrentCommandName());
	}

	void putSBSubsystemSummary() {
		String summary = "";
		for (Subsystem subsystem : RobotMap.Component.mainSubsystems) {
			summary += "{" + subsystem.getName() + "} running command {" + subsystem.getCurrentCommand() + "}\n";
		}
		SmartDashboard.putString("Subsystem Overview", summary);
	}
}
