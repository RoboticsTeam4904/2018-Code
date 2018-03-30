package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.autonly.CenterSwitchDistance;
import org.usfirst.frc4904.autonly.CrossBaselineTime;
import org.usfirst.frc4904.autonly.farsidepriorities.LeftScaleOverSwitch;
import org.usfirst.frc4904.autonly.farsidepriorities.LeftSwitchOverScale;
import org.usfirst.frc4904.autonly.farsidepriorities.RightScaleOverSwitch;
import org.usfirst.frc4904.autonly.farsidepriorities.RightSwitchOverScale;
import org.usfirst.frc4904.autonly.farsidescalestrategies.FarRightScaleRightDistance;
import org.usfirst.frc4904.autonly.farsideswitchstrategies.FarLeftSwitchLeftDistance;
import org.usfirst.frc4904.autonly.sideswitchnoturn.LeftSideTime;
import org.usfirst.frc4904.autonly.sideswitchnoturn.RightSideTime;
import org.usfirst.frc4904.autonly.test.SwitchThenIntake;
import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.robot.humaninterface.operators.DefaultOperator;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.commands.motor.MotorControl;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.sensors.CANSensor;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends CommandRobotBase {
	private RobotMap map = new RobotMap();

	@Override
	public void initialize() {
		driverChooser.addDefault(new NathanGain());
		operatorChooser.addDefault(new DefaultOperator());
		autoChooser.addDefault(
			// new ChassisIdle(RobotMap.Component.chassis));
			// new ArmSet(Arm.ArmState.ARM_POSITION_SCALE));
			// new ChassisIdle(RobotMap.Component.chassis));
			// new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
			// new ChassisMoveDistance(RobotMap.Component.chassis, 120, RobotMap.Component.drivePID));
			// new ChassisMoveDistance(RobotMap.Component.chassis, 72, RobotMap.Component.drivePID));
			// new Square());
			// new FarLeftSwitchDistance());
			// new FarLeftScaleDistance());
			// new CenterSwitchDistance());
			// new CrossBaselineTime());
			// new SwitchThenIntake());
			// new TurnThenReset(90));
			// new OuttakeSwitch(12));
			new FarLeftSwitchLeftDistance());
		autoChooser.addObject("Scale", new ArmSet(Arm.ArmState.ARM_POSITION_SCALE));
		autoChooser.addObject("Switch", new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
		autoChooser.addObject("Intake", new ArmSet(Arm.ArmState.ARM_POSITION_INTAKE));
		autoChooser.addObject(new SwitchThenIntake());
		autoChooser.addObject(new LeftSideTime());
		autoChooser.addObject(new RightSideTime());
		autoChooser.addObject(new FarRightScaleRightDistance());
		autoChooser.addObject(new ChassisTurn(RobotMap.Component.chassis, -90, RobotMap.Component.navx,
			RobotMap.Component.chassisTurnMC));
		// autoChooser.addObject(new LeftSideDistance());
		// autoChooser.addObject(new RightSideDistance());
		autoChooser.addObject(new CenterSwitchDistance());
		// autoChooser.addObject(new FarLeftSwitchDistance());
		// autoChooser.addObject(new FarRightSwitchDistance());
		// autoChooser.addObject(new FarLeftScaleDistance());
		// autoChooser.addObject(new FarRightScaleDistance());
		autoChooser.addObject(new LeftScaleOverSwitch());
		autoChooser.addObject(new LeftSwitchOverScale());
		autoChooser.addObject(new RightScaleOverSwitch());
		autoChooser.addObject(new RightSwitchOverScale());
		autoChooser.addObject(new CrossBaselineTime());
		SmartDashboard.putString("Most Recent CAN Success", "never");
		SmartDashboard.putBoolean("ShouldResetArmEncoder", false);
		SmartDashboard.putNumber("drivePID/P", RobotMap.Component.drivePID.getP());
		SmartDashboard.putNumber("drivePID/I", RobotMap.Component.drivePID.getI());
		SmartDashboard.putNumber("drivePID/D", RobotMap.Component.drivePID.getD());
		SmartDashboard.putNumber("drivePID/F", RobotMap.Component.drivePID.getF());
		SmartDashboard.putNumber("turnPID/P", RobotMap.Component.chassisTurnMC.getP());
		SmartDashboard.putNumber("turnPID/I", RobotMap.Component.chassisTurnMC.getI());
		SmartDashboard.putNumber("turnPID/D", RobotMap.Component.chassisTurnMC.getD());
		SmartDashboard.putNumber("turnPID/F", RobotMap.Component.chassisTurnMC.getF());
		SmartDashboard.putNumber("armPID/P", RobotMap.Component.armController.getP());
		SmartDashboard.putNumber("armPID/I", RobotMap.Component.armController.getI());
		SmartDashboard.putNumber("armPID/D", RobotMap.Component.armController.getD());
		SmartDashboard.putNumber("armPID/F", RobotMap.Component.armController.getF());
		SmartDashboard.putNumber("arm_accel_cap", RobotMap.Metrics.ARM_ACCEL_CAP);
		SmartDashboard.putNumber("turn_correction", RobotMap.Component.chassis.turn_correction);
		// streaming:
		new Thread(() -> {
			CameraServer.getInstance().startAutomaticCapture();
		}).start();
		RobotMap.Component.rightWheelEncoder.reset();
		RobotMap.Component.rightWheelEncoder.resetViaOffset();
		RobotMap.Component.leftWheelEncoder.reset();
		RobotMap.Component.leftWheelEncoder.resetViaOffset();
	}

	@Override
	public void teleopInitialize() {
		// Command intakeRelease = new ReleaseIntake();
		// intakeRelease.start(); // Flip out intake in the beginning of teleop
		// RobotMap.Component.arm.encoder.reset();
		Command arm_stay = new MotorControl(RobotMap.Component.arm, RobotMap.HumanInput.Operator.joystick,
			CustomJoystick.Y_AXIS,
			0.0);
		arm_stay.start();
		RobotMap.Component.arm.set(0.0);
		teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
		teleopCommand.start();
	}

	@Override
	public void teleopExecute() {}

	@Override
	public void autonomousInitialize() {
		// Component.leftWheelEncoder.reset();
		// TODO: Fix encoder resetting.
		// LogKitten.wtf("---RESET ARM ENCODER--- BE SURE THAT ARM IS IN AUTON INITIAL POSITION");
		// RobotMap.Component.arm.encoder.reset();
		RobotMap.Component.arm.encoder.resetViaOffset(8.0); // WARNING: Reseting arm encoder to 8 degrees above rest (where we start in auton). Arm HAS to be in lowered position for ArmStates and PID to be accurate later and so it doesn't flip out
		LogKitten.wtf("---END RESET ARM ENCODER---");
		RobotMap.gameField.update(DriverStation.getInstance().getAlliance(),
			DriverStation.getInstance().getGameSpecificMessage());
		RobotMap.Component.navx.reset(); // Set yaw to 0 // WARNING: resetting the navx so that absolute turn works. Normal chassis turn will be sketchy (init angle set before resetting navx).
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
		SmartDashboard.putNumber("drivePID/e", RobotMap.Component.drivePID.getError());
		SmartDashboard.putNumber("drivePID/x", RobotMap.Component.drivePID.getSensorValue());
		SmartDashboard.putNumber("turnPID/e", RobotMap.Component.chassisTurnMC.getError());
		SmartDashboard.putNumber("turnPID/x", RobotMap.Component.chassisTurnMC.getSensorValue());
		SmartDashboard.putNumber("armPID/e", RobotMap.Component.armController.getError());
		SmartDashboard.putNumber("armPID/x", RobotMap.Component.armController.getSensorValue());
		RobotMap.Component.drivePID.setPIDF(SmartDashboard.getNumber("drivePID/P", 0),
			SmartDashboard.getNumber("drivePID/I", 0),
			SmartDashboard.getNumber("drivePID/D", 0), SmartDashboard.getNumber("drivePID/F", 0));
		RobotMap.Component.chassisTurnMC.setPIDF(SmartDashboard.getNumber("turnPID/P", 0),
			SmartDashboard.getNumber("turnPID/I", 0),
			SmartDashboard.getNumber("turnPID/D", 0), SmartDashboard.getNumber("turnPID/F", 0));
		RobotMap.Component.armController.setPIDF(SmartDashboard.getNumber("armPID/P", 0),
			SmartDashboard.getNumber("armPID/I", 0),
			SmartDashboard.getNumber("armPID/D", 0), SmartDashboard.getNumber("armPID/F", 0));
		SmartDashboard.putNumber("armEncoder, 0x612", RobotMap.Component.arm.getTrueAngle());
		SmartDashboard.putNumber("navx", RobotMap.Component.navx.getYaw());
		SmartDashboard.putNumber("leftEncoder, 0x610", RobotMap.Component.leftWheelEncoder.getDistance());
		SmartDashboard.putNumber("rightEncoder, 0x611", RobotMap.Component.rightWheelEncoder.getDistance());
		// LogKitten.wtf("ARM" + Double.toString(RobotMap.Component.arm.getTrueAngle())
		// + ", RIGHT, " + Double.toString(RobotMap.Component.rightWheelEncoder.getDistance())
		// + ", LEFT, " + Double.toString(RobotMap.Component.leftWheelEncoder.getDistance())
		// + ", NAVX: " + Double.toString(RobotMap.Component.navx.getYaw()));
		// TODO: Fix arm resetting.
		// if (SmartDashboard.getBoolean("ShouldResetArmEncoder", false)) {
		// RobotMap.Component.arm.encoder.reset();
		// SmartDashboard.putBoolean("ShouldResetArmEncoder", false);
		// }
		SmartDashboard.putStringArray("Sensor Status", CANSensor.getSensorStatuses());
		RobotMap.Component.chassis.turn_correction = SmartDashboard.getNumber("turn_correction", 0.0);
		SmartDashboard.putNumber("turn_correction", RobotMap.Component.chassis.turn_correction);
		// Push values to network table
		RobotMap.NetworkTables.Sensors.yawEntry.setNumber(RobotMap.Component.navx.getYaw());
		RobotMap.NetworkTables.Sensors.accelXEntry.setNumber(RobotMap.Component.navx.getWorldLinearAccelX());
		RobotMap.NetworkTables.Sensors.accelYEntry.setNumber(RobotMap.Component.navx.getWorldLinearAccelY());
		RobotMap.NetworkTables.Sensors.accelZEntry.setNumber(RobotMap.Component.navx.getWorldLinearAccelZ());
		RobotMap.NetworkTables.Sensors.rightEncoderEntry.setDouble(RobotMap.Component.rightWheelEncoder.getDistance());
		RobotMap.NetworkTables.Sensors.leftEncoderEntry.setDouble(RobotMap.Component.leftWheelEncoder.getDistance());
	}

	void putSBSubsystemSummary() {
		String summary = "";
		for (Subsystem subsystem : RobotMap.Component.mainSubsystems) {
			summary += "{" + subsystem.getName() + "} running command {" + subsystem.getCurrentCommand() + "}\n";
		}
		SmartDashboard.putString("Subsystem Overview", summary);
	}
}
