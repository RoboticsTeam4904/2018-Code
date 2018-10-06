package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.autonly.Field;
import org.usfirst.frc4904.robot.humaninterface.HumanInterfaceConfig;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.robot.subsystems.Arm.DiscBrake;
import org.usfirst.frc4904.robot.subsystems.CrateIO;
import org.usfirst.frc4904.robot.subsystems.LIDAR;
import org.usfirst.frc4904.robot.subsystems.RollyBOI;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.custom.sensors.CANSensor;
import org.usfirst.frc4904.standard.custom.sensors.EncoderPair;
import org.usfirst.frc4904.standard.custom.sensors.NavX;
import org.usfirst.frc4904.standard.custom.sensors.PDP;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;
import org.usfirst.frc4904.standard.custom.PCMPort;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.I2C;


public class RobotMap {
	public static Field gameField;

	public static class Port { // TODO: Correct Ports
		public static class HumanInput {
			public static final int joystick = 0;
			public static final int xboxController = 1;
		}

		public static class CANMotor {
			public static final int armMotorA = 9;
			public static final int armMotorB = 14;
			public static final int crateIORollerMotorLeft = 1;
			public static final int crateIORollerMotorRight = 7;
			public static final int rollyBOIRollerMotorLeft = 11;
			public static final int rollyBOIRollerMotorRight = 3;
			public static final int leftDriveA = 4;
			public static final int leftDriveB = 5;
			public static final int rightDriveA = 15;
			public static final int rightDriveB = 16;
		}

		public static class CAN {
			public static final int leftEncoder = 0x610;
			public static final int rightEncoder = 0x611;
			public static final int armEncoderPort = 0x612;
		}

		public static class Pneumatics {
//			// TODO: Check if the order of these ports is correct
			public static final PCMPort shifter = new PCMPort(1, 0, 1); 
			public static final PCMPort rollyBOIGrabber = new PCMPort(1, 7, 6); // clasp, release
		}
	}

	public static class Metrics { // TODO: Check in later with design to confirm these metrics.
		public static final double WHEEL_DIAMETER_INCHES = 4;
		public static final double WHEEL_CIRCUMFERENCE_INCHES = Metrics.WHEEL_DIAMETER_INCHES * Math.PI;
		public static final double WHEEL_DISTANCE_FRONT_BACK = 27.373;
		public static final double WHEEL_DISTANCE_SIDE_SIDE = 24.5;
		public static final double ARM_ACCEL_CAP = 0.55;
		public static double TURN_CORRECTION = 0.0;

		public static class Wheel {
			public static final double TICKS_PER_REVOLUTION = 1024;
			public static final double DIAMETER_INCHES = 4;
			public static final double CIRCUMFERENCE_INCHES = Metrics.Wheel.DIAMETER_INCHES * Math.PI;
			public static final double TICKS_PER_INCH = Metrics.Wheel.TICKS_PER_REVOLUTION
				/ Metrics.Wheel.CIRCUMFERENCE_INCHES;
			public static final double DISTANCE_FRONT_BACK = 27.37;
			public static final double DISTANCE_SIDE_SIDE = 25.21;
			public static final double INCHES_PER_TICK = Metrics.Wheel.CIRCUMFERENCE_INCHES
				/ Metrics.Wheel.TICKS_PER_REVOLUTION;
		}
		public static final double LENGTH = 49.04;// 32.75;
		public static final double WIDTH = 34.25;// 27.75;
		public static final double ROBOT_DISTANCE_FROM_CLOSE_WALL = 29.69 + WIDTH / 2; // this is variable, find way to determine real value
	}

	public static class PID {
		public static class Drive {
			public static final double P = 0.04;
			public static final double I = 0.0;
			public static final double D = -0.006;
			public static final double F = 0.01;
			public static final double tolerance = 4.5;
			public static final double dTolerance = 3.0;
		}

		public static class Turn {
			public static final double P = 0.0015;
			public static final double I = 0.0;
			public static final double D = -0.05;
			public static final double F = 0.2;
			public static final double tolerance = 1.0;
			public static final double dTolerance = 0.1;
		}

		public static class Arm {
			public static final double P = 0.010;
			public static final double I = 0.000005;
			public static final double D = -0.0004;
			public static final double F = 0.007;
			public static final double tolerance = 4.0;
			public static final double dTolerance = 3.0;
		}

		public static class LIDAR {
			public static final double P = 0.0001;
			public static final double I = 0.0;
			public static final double D = -0.0018;
			public static final double F = 0.0;
			public static final double tolerance = 4.0;
			public static final double dTolerance = 3.0;
		}
	}

	public static class Component {
		public static Arm arm;
		public static PDP pdp;
		public static Motor crateIORollerLeft;
		public static Motor crateIORollerRight;
		public static Motor rollyBOIRollerLeft;
		public static Motor rollyBOIRollerRight;
		public static RollyBOI.Grabber rollyBOIGrabber;
		public static CrateIO crateIO;
		public static RollyBOI rollyBOI;
		public static TankDriveShifting chassis;
		public static Motor leftWheel;
		public static Motor rightWheel;
		public static DiscBrake discBrake;
		public static SolenoidShifters shifter;
		public static EnableableModifier rightWheelAccelerationCap;
		public static EnableableModifier leftWheelAccelerationCap;
		public static CANEncoder leftWheelEncoder;
		public static CANEncoder rightWheelEncoder;
		public static EncoderPair chassisEncoders;
		public static LIDAR lidar;
		public static CustomPIDController chassisTurnMC;
		public static CustomPIDController drivePID;
		public static CustomPIDController armController;
		public static CustomPIDController lidarPID;
		public static NavX navx;
		public static Subsystem[] mainSubsystems;
		public static CANSensor intakeSwitch;
	}

	public static class NetworkTables {
		public static NetworkTableInstance inst;
		public static NetworkTable table;

		public static class Sensors {
			public static NetworkTable table;
			public static NetworkTableEntry yawEntry;
			public static NetworkTableEntry rightEncoderEntry;
			public static NetworkTableEntry leftEncoderEntry;
			public static NetworkTableEntry accelXEntry;
			public static NetworkTableEntry accelYEntry;
			public static NetworkTableEntry accelZEntry;
		}

		public static class Cubes {
			public static NetworkTable table;
			public static NetworkTableEntry angleEntry;
			public static NetworkTableEntry distanceEntry;
		}

		public static class Localization {
			public static NetworkTable table;
			public static NetworkTableEntry distObstFrontEntry;
			public static NetworkTableEntry ourXEntry;
			public static NetworkTableEntry ourYEntry;
		}
	}

	public static class HumanInput {
		public static class Driver {
			public static CustomXbox xbox;
		}

		public static class Operator {
			public static CustomJoystick joystick;
		}
	}

	public RobotMap() {
		/* General */
		Component.pdp = new PDP();
		Component.navx = new NavX(I2C.Port.kMXP); //SerialPort.Port.kMXP);
		gameField = new Field();
		/* Chassis */
		// Wheel Encoders
		Component.leftWheelEncoder = new CANEncoder("LeftEncoder", Port.CAN.leftEncoder, true);
		Component.rightWheelEncoder = new CANEncoder("RightEncoder", Port.CAN.rightEncoder);
		Component.leftWheelEncoder.setDistancePerPulse(Metrics.Wheel.INCHES_PER_TICK);
		Component.rightWheelEncoder.setDistancePerPulse(Metrics.Wheel.INCHES_PER_TICK);
		Component.chassisEncoders = new EncoderPair(Component.leftWheelEncoder, Component.rightWheelEncoder);
		// Acceleration Caps
		Component.leftWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
		Component.leftWheelAccelerationCap.enable();
		Component.rightWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
		Component.rightWheelAccelerationCap.enable();
		// Wheels
		Component.leftWheel = new Motor("LeftWheel", true, Component.leftWheelAccelerationCap,
			new CANTalonSRX(Port.CANMotor.leftDriveA), new CANTalonSRX(Port.CANMotor.leftDriveB));
		Component.rightWheel = new Motor("RightWheel", Component.rightWheelAccelerationCap,
			new CANTalonSRX(Port.CANMotor.rightDriveA), new CANTalonSRX(Port.CANMotor.rightDriveB));
		// Motion Controllers
		Component.chassisTurnMC = new CustomPIDController(PID.Turn.P, PID.Turn.I, PID.Turn.D, PID.Turn.F, Component.navx);
		Component.chassisTurnMC.setMinimumNominalOutput(0.24);
		Component.chassisTurnMC.setInputRange(-180, 180);
		Component.chassisTurnMC.setContinuous(true);
		Component.chassisTurnMC.setAbsoluteTolerance(PID.Turn.tolerance);
		Component.chassisTurnMC.setDerivativeTolerance(PID.Turn.dTolerance);
		// General Chassis
		Component.shifter = new SolenoidShifters(Port.Pneumatics.shifter.buildDoubleSolenoid());
		Component.chassis = new TankDriveShifting("2018-Chassis", Component.leftWheel, Component.rightWheel, Component.shifter);
		Component.chassis.turn_correction = Metrics.TURN_CORRECTION;
		Component.drivePID = new CustomPIDController(PID.Drive.P, PID.Drive.I, PID.Drive.D, PID.Drive.F,
			Component.rightWheelEncoder);
		Component.drivePID.setAbsoluteTolerance(PID.Drive.tolerance);
		Component.drivePID.setDerivativeTolerance(PID.Drive.dTolerance);
		/* Arm */
		// Encoders
		CANEncoder armEncoder = new CANEncoder("ArmEncoder", Port.CAN.armEncoderPort, true);
		// armEncoder.reset();
		Component.armController = new CustomPIDController(PID.Arm.P, PID.Arm.I, PID.Arm.D, PID.Arm.F, armEncoder);
		Component.armController.setIThreshold(13);
		Component.armController.setAbsoluteTolerance(PID.Arm.tolerance);
		Component.armController.setDerivativeTolerance(PID.Arm.dTolerance);
		// LIDAR
		// Component.lidar = new LIDAR();
		// Component.lidarPID = new CustomPIDController(PID.LIDAR.P, PID.LIDAR.I, PID.LIDAR.D, PID.LIDAR.F,
		// Component.lidar);
		// Component.lidarPID.setAbsoluteTolerance(PID.LIDAR.tolerance);
		// Component.lidarPID.setDerivativeTolerance(PID.LIDAR.dTolerance);
		// Motors
		CANTalonSRX armA = new CANTalonSRX(Port.CANMotor.armMotorA);
		CANTalonSRX armB = new CANTalonSRX(Port.CANMotor.armMotorB);
		armB.setInverted(true);
		// General
		Component.arm = new Arm(Component.armController, armEncoder,
			armA, armB);
		/* CrateIO */
		Component.crateIORollerLeft = new Motor("CrateIORollerLeft", new CANTalonSRX(Port.CANMotor.crateIORollerMotorLeft));
		Component.crateIORollerRight = new Motor("CrateIORollerRight", new CANTalonSRX(Port.CANMotor.crateIORollerMotorRight));
		Component.crateIO = new CrateIO(Component.crateIORollerLeft, Component.crateIORollerRight);
		/* RollyBoi */
		Component.rollyBOIRollerLeft = new Motor("RollyBOIRollerLeft", new CANTalonSRX(Port.CANMotor.rollyBOIRollerMotorLeft));
		Component.rollyBOIRollerLeft.setInverted(true);
		Component.rollyBOIRollerRight = new Motor("RollyBOIRollerRight",
			new CANTalonSRX(Port.CANMotor.rollyBOIRollerMotorRight));
		Component.rollyBOIGrabber = new RollyBOI.Grabber(Port.Pneumatics.rollyBOIGrabber.buildDoubleSolenoid());
		Component.rollyBOI = new RollyBOI(Component.rollyBOIRollerLeft, Component.rollyBOIRollerRight,
			Component.rollyBOIGrabber);
		/* Controllers */
		HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
		HumanInput.Driver.xbox.setDeadZone(HumanInterfaceConfig.XBOX_DEADZONE);
		HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);
		HumanInput.Operator.joystick.setDeadzone(HumanInterfaceConfig.STICK_LEFT_DEADZONE);
		Component.mainSubsystems = new Subsystem[] {
				Component.chassis,
				// Component.crateIO,
				// Component.rollyBOI,
				Component.arm
		};
		/* NetworkTables */
		NetworkTables.inst = NetworkTableInstance.getDefault();
		NetworkTables.table = NetworkTables.inst.getTable("vision");
		NetworkTables.Sensors.table = NetworkTables.inst.getTable("sensorData");
		NetworkTables.Sensors.yawEntry = NetworkTables.Sensors.table.getEntry("yaw");
		NetworkTables.Sensors.rightEncoderEntry = NetworkTables.Sensors.table.getEntry("rightEncoder");
		NetworkTables.Sensors.leftEncoderEntry = NetworkTables.Sensors.table.getEntry("leftEncoder");
		NetworkTables.Sensors.accelXEntry = NetworkTables.Sensors.table.getEntry("accelX");
		NetworkTables.Sensors.accelYEntry = NetworkTables.Sensors.table.getEntry("accelY");
		NetworkTables.Sensors.accelZEntry = NetworkTables.Sensors.table.getEntry("accelZ");
		NetworkTables.Cubes.table = NetworkTables.table.getSubTable("cubes");
		NetworkTables.Cubes.angleEntry = NetworkTables.Cubes.table.getEntry("relangle");
		NetworkTables.Cubes.distanceEntry = NetworkTables.Cubes.table.getEntry("distance");
		NetworkTables.Localization.table = NetworkTables.table.getSubTable("localization");
		NetworkTables.Localization.distObstFrontEntry = NetworkTables.Localization.table
			.getEntry("frontObsticalDist");
		NetworkTables.Localization.ourXEntry = NetworkTables.Localization.table.getEntry("x");
		NetworkTables.Localization.ourYEntry = NetworkTables.Localization.table.getEntry("y");
	}
}