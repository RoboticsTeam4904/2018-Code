package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.autonly.Strategy;
import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.robot.humaninterface.operators.DefaultOperator;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import org.usfirst.frc4904.standard.custom.sensors.InvalidSensorException;
import edu.wpi.first.wpilibj.DriverStation;
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
		SmartDashboard.putString("Most Recent CAN Success", "never");
	}

	@Override
	public void teleopInitialize() {
		teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
		teleopCommand.start();
	}

	@Override
	public void teleopExecute() {}

	@Override
	public void autonomousInitialize() {
		RobotMap.gameField.update(DriverStation.getInstance().getAlliance(),
			DriverStation.getInstance().getGameSpecificMessage());
		((Strategy) autoChooser.getSelected()).setup();
	}

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
		try {
			int[] sensorValues = RobotMap.Component.leftWheelEncoder.readSensor();
			SmartDashboard.putNumberArray("Most Recent CAN Message", new double[] {sensorValues[0], sensorValues[1]});
			SmartDashboard.putNumber("Most Recent CAN Success", System.currentTimeMillis());
		}
		catch (InvalidSensorException e) {
			SmartDashboard.putNumber("Most Recent CAN Failure", System.currentTimeMillis());
		}
		// LogKitten.wtf("Chassis Encoders. Left: " + RobotMap.Component.leftWheelEncoder.getDistance() + " Right: "
		// + RobotMap.Component.rightWheelEncoder.getDistance());
		// SmartDashboard.putNumber("leftEncoder", RobotMap.Component.leftWheelEncoder.getDistance());
		// SmartDashboard.putNumber("rightEncoder", RobotMap.Component.rightWheelEncoder.getDistance());
		// try {
		// LogKitten.wtf("Chassis Encoders. Left: " + RobotMap.Component.leftWheelEncoder.read() + " Right: " + RobotMap.Component.rightWheelEncoder.read());
		// }
		// catch (CANMessageUnavailableException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// putSBSubsystemSummary();
		LogKitten.wtf("Arm: " + RobotMap.Component.arm.getAngle());
		// SmartDashboard.getNumber(LiveWindow.addSensor(moduleType, channel, component);, defaultValue)
	}

	void putSBSubsystemSummary() {
		String summary = "";
		for (Subsystem subsystem : RobotMap.Component.mainSubsystems) {
			summary += "{" + subsystem.getName() + "} running command {" + subsystem.getCurrentCommand() + "}\n";
		}
		SmartDashboard.putString("Subsystem Overview", summary);
	}
}
