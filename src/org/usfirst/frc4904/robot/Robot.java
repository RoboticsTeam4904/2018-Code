package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.autonly.CenterSwitchDistance;
import org.usfirst.frc4904.autonly.LeftSideDistance;
import org.usfirst.frc4904.autonly.LeftSideTime;
import org.usfirst.frc4904.autonly.RightSideDistance;
import org.usfirst.frc4904.autonly.RightSideTime;
import org.usfirst.frc4904.autonly.farsidescalestrategies.FarLeftScaleDistance;
import org.usfirst.frc4904.autonly.farsidescalestrategies.FarRightScaleDistance;
import org.usfirst.frc4904.autonly.farsideswitchstrategies.FarLeftSwitchDistance;
import org.usfirst.frc4904.autonly.farsideswitchstrategies.FarRightSwitchDistance;
import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.robot.humaninterface.operators.DefaultOperator;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.chassis.ChassisIdle;
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
		autoChooser.addDefault(
			new ChassisIdle(RobotMap.Component.chassis));
		// new ChassisTurn(RobotMap.Component.chassis, 120, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		// new ChassisMoveDistance(RobotMap.Component.chassis, 24, RobotMap.Component.drivePID));
		// new Square());
		// new OuttakeSwitch(12));
		autoChooser.addObject(new LeftSideTime());
		autoChooser.addObject(new RightSideTime());
		autoChooser.addObject(new LeftSideDistance());
		autoChooser.addObject(new RightSideDistance());
		autoChooser.addObject(new CenterSwitchDistance());
		autoChooser.addObject(new FarLeftSwitchDistance());
		autoChooser.addObject(new FarRightSwitchDistance());
		autoChooser.addObject(new FarLeftScaleDistance());
		autoChooser.addObject(new FarRightScaleDistance());
		SmartDashboard.putString("Most Recent CAN Success", "never");
		SmartDashboard.putBoolean("ShouldResetArmEncoder", false);
		SmartDashboard.putNumber("PID/P", RobotMap.Component.drivePID.getP());
		SmartDashboard.putNumber("PID/I", RobotMap.Component.drivePID.getI());
		SmartDashboard.putNumber("PID/D", RobotMap.Component.drivePID.getD());
		SmartDashboard.putNumber("PID/F", RobotMap.Component.drivePID.getF());
		// SmartDashboard.putNumber("PID/P", RobotMap.Component.chassisTurnMC.getP());
		// SmartDashboard.putNumber("PID/I", RobotMap.Component.chassisTurnMC.getI());
		// SmartDashboard.putNumber("PID/D", RobotMap.Component.chassisTurnMC.getD());
		// SmartDashboard.putNumber("PID/F", RobotMap.Component.chassisTurnMC.getF());
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
		// TODO: Fix encoder resetting.
		LogKitten.wtf("---RESET ARM ENCODER---");
		RobotMap.Component.arm.encoder.reset();
		LogKitten.wtf("---END RESET ARM ENCODER---");
		RobotMap.gameField.update(DriverStation.getInstance().getAlliance(),
			DriverStation.getInstance().getGameSpecificMessage());
		RobotMap.Component.navx.reset(); // Set yaw to 0
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
		SmartDashboard.putNumber("PID/e", RobotMap.Component.drivePID.getError());
		SmartDashboard.putNumber("PID/x", RobotMap.Component.drivePID.getSensorValue());
		// SmartDashboard.putNumber("PID/e", RobotMap.Component.chassisTurnMC.getError());
		// SmartDashboard.putNumber("PID/x", RobotMap.Component.chassisTurnMC.getSensorValue());
		RobotMap.Component.drivePID.setPIDF(SmartDashboard.getNumber("PID/P", 0), SmartDashboard.getNumber("PID/I", 0),
			SmartDashboard.getNumber("PID/D", 0), SmartDashboard.getNumber("PID/F", 0));
		// RobotMap.Component.chassisTurnMC.setPIDF(SmartDashboard.getNumber("PID/P", 0), SmartDashboard.getNumber("PID/I", 0),
		// SmartDashboard.getNumber("PID/D", 0), SmartDashboard.getNumber("PID/F", 0));
		// LogKitten.wtf((RobotMap.Component.chassisTurnMC.getP() + " - " + RobotMap.Component.chassisTurnMC.getI() + " - " +
		// RobotMap.Component.chassisTurnMC.getD()));
		// SmartDashboard.putString("Most Recent CAN Success", System.currentTimeMillis() + "");
		SmartDashboard.putNumber("armEncoder, 0x612", RobotMap.Component.arm.getTrueAngle());
		SmartDashboard.putNumber("navx", RobotMap.Component.navx.getYaw());
		SmartDashboard.putNumber("leftEncoder, 0x610", RobotMap.Component.leftWheelEncoder.getDistance());
		SmartDashboard.putNumber("rightEncoder, 0x611", RobotMap.Component.rightWheelEncoder.getDistance());
		// TODO: Fix arm resetting.
		// if (SmartDashboard.getBoolean("ShouldResetArmEncoder", false)) {
		// RobotMap.Component.arm.encoder.reset();
		// SmartDashboard.putBoolean("ShouldResetArmEncoder", false);
		// }
	}

	void putSBSubsystemSummary() {
		String summary = "";
		for (Subsystem subsystem : RobotMap.Component.mainSubsystems) {
			summary += "{" + subsystem.getName() + "} running command {" + subsystem.getCurrentCommand() + "}\n";
		}
		SmartDashboard.putString("Subsystem Overview", summary);
	}
}
