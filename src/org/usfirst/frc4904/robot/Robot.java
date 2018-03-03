package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.autonly.LeftSideTime;
import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.robot.humaninterface.operators.DefaultOperator;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends CommandRobotBase {
	private RobotMap map = new RobotMap();

	@Override
	public void initialize() {
		driverChooser.addDefault(new NathanGain());
		operatorChooser.addDefault(new DefaultOperator());
		autoChooser.addDefault(new LeftSideTime());
		// autoChooser.addDefault(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
		// autoChooser.addDefault(new LeftSideTime());
		// autoChooser.addDefault(new LeftSideDistance());
		// autoChooser.addDefault(new RightSideDistance());
		SmartDashboard.putString("Most Recent CAN Success", "never");
		SmartDashboard.putBoolean("ShouldResetArmEncoder", false);
	}

	@Override
	public void teleopInitialize() {
		teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
		teleopCommand.start();
		// RobotMap.Component.arm.encoder.reset();
		// LogKitten.wtf(RobotMap.Component.arm.getAngle());
	}

	@Override
	public void teleopExecute() {
		// SmartDashboard.putNumber("Arm Angle", RobotMap.Component.arm.getAngle());
	}

	@Override
	public void autonomousInitialize() {
		LogKitten.wtf("---RESET ARM ENCODER---");
		RobotMap.Component.arm.encoder.reset();
		LogKitten.wtf("---END RESET ARM ENCODER---");
		RobotMap.gameField.update(DriverStation.getInstance().getAlliance(),
			DriverStation.getInstance().getGameSpecificMessage());
		// ((Strategy) autoChooser.getSelected()).setup();
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
		// try {
		// int[] sensorValues = RobotMap.Component.leftWheelEncoder.readSensor();
		// SmartDashboard.putNumberArray("Most Recent CAN Message", new double[] {sensorValues[0], sensorValues[1]});
		SmartDashboard.putString("Most Recent CAN Success", System.currentTimeMillis() + "");
		// }
		// catch (InvalidSensorException e) {
		// SmartDashboard.putNumber("Most Recent CAN Failure", System.currentTimeMillis());
		// }
		// LogKitten.wtf("Chassis Encoders. Left: " + RobotMap.Component.leftWheelEncoder.getDistance() + " Right: "
		// + RobotMap.Component.rightWheelEncoder.getDistance());
		SmartDashboard.putNumber("armEncoder, 0x612", RobotMap.Component.arm.getAngle());
		SmartDashboard.putNumber("leftEncoder, 0x610", RobotMap.Component.leftWheelEncoder.getDistance());
		SmartDashboard.putNumber("rightEncoder, 0x611", RobotMap.Component.rightWheelEncoder.getDistance());
		// try {
		// LogKitten.wtf("Chassis Encoders. Left: " + RobotMap.Component.leftWheelEncoder.read() + " Right: " + RobotMap.Component.rightWheelEncoder.read());
		// }
		// catch (CANMessageUnavailableException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// putSBSubsystemSummary();
		// LogKitten.wtf("Arm: " + RobotMap.Component.arm.getAngle());
		// SmartDash.putNumber("")
		// SmartDashboard.getNumber(LiveWindow.addSensor(moduleType, channel, component);, defaultValue)
		if (SmartDashboard.getBoolean("ShouldResetArmEncoder", false)) {
			RobotMap.Component.arm.encoder.reset();
			SmartDashboard.putBoolean("ShouldResetArmEncoder", false);
		}
	}

	void putSBSubsystemSummary() {
		String summary = "";
		for (Subsystem subsystem : RobotMap.Component.mainSubsystems) {
			summary += "{" + subsystem.getName() + "} running command {" + subsystem.getCurrentCommand() + "}\n";
		}
		SmartDashboard.putString("Subsystem Overview", summary);
	}
}
