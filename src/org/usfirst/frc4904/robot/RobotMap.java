package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.autonly.Field;
import org.usfirst.frc4904.robot.humaninterface.HumanInterfaceConfig;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.robot.subsystems.Arm.DiscBrake;
import org.usfirst.frc4904.robot.subsystems.CrateIO;
import org.usfirst.frc4904.robot.subsystems.Lifter;
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
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

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
		}

		public static class PWM {
			public static final int leftDriveA = 2;
			public static final int leftDriveB = 3;
			public static final int rightDriveA = 0;
			public static final int rightDriveB = 1;
		}

		public static class CAN {
			public static final int leftEncoder = 0x611;
			public static final int rightEncoder = 0x610;
			public static final int armEncoderPort = 0x612;
		}

		public static class Pneumatics {
			// TODO: Check if the order of these ports is correct
			public static final PCMPort leftLifter = new PCMPort(0, 2, 3);
			public static final PCMPort rightLifter = new PCMPort(1, 3, 2);
			public static final PCMPort leftLifterSupport = new PCMPort(0, 4, 5);
			public static final PCMPort rightLifterSupport = new PCMPort(1, 5, 4);
			public static final PCMPort shifter = new PCMPort(1, 0, 1);
			public static final PCMPort rollyBOIGrabber = new PCMPort(0, 7, 6);
		}
	}

	public static class Metrics { // TODO: Check in later with design to confirm these metrics.
		public static final double WHEEL_DIAMETER_INCHES = 4;
		public static final double WHEEL_CIRCUMFERENCE_INCHES = Metrics.WHEEL_DIAMETER_INCHES * Math.PI;
		public static final double WHEEL_DISTANCE_FRONT_BACK = 27.373;
		public static final double WHEEL_DISTANCE_SIDE_SIDE = 24.5;

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
			public static final double P = 0.057;
			public static final double I = 0.0000035;
			public static final double D = -0.012;
			public static final double F = 0.0;
		}

		public static class Turn {
			public static final double P = 0.0032;
			public static final double I = 0.0;
			public static final double D = -0.0000025;
			public static final double F = 0.000001;
		}

		public static class Arm {
			public static final double P = 0.01;
			public static final double I = 0.00001;
			public static final double D = -0.001;
			public static final double F = 0.0;
		}
	}

	public static class Component {
		public static Arm arm;
		public static Lifter lifterLeft;
		public static Lifter lifterRight;
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
		public static CustomPIDController chassisTurnMC;
		public static CustomPIDController drivePID;
		public static NavX navx;
		public static Subsystem[] mainSubsystems;
		public static CANSensor intakeSwitch;
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
		Component.navx = new NavX(SerialPort.Port.kMXP);
		gameField = new Field();
		/* Chassis */
		// Wheel Encoders
		Component.leftWheelEncoder = new CANEncoder("LeftEncoder", Port.CAN.leftEncoder);
		Component.rightWheelEncoder = new CANEncoder("RightEncoder", Port.CAN.rightEncoder);
		Component.leftWheelEncoder.setDistancePerPulse(-1 * Metrics.Wheel.INCHES_PER_TICK); // Encoder is mounted backwards
		Component.rightWheelEncoder.setDistancePerPulse(Metrics.Wheel.INCHES_PER_TICK);
		Component.chassisEncoders = new EncoderPair(Component.leftWheelEncoder, Component.rightWheelEncoder);
		// Acceleration Caps
		Component.leftWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
		Component.leftWheelAccelerationCap.enable();
		Component.rightWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
		Component.rightWheelAccelerationCap.enable();
		// Wheels
		Component.leftWheel = new Motor("LeftWheel", Component.leftWheelAccelerationCap,
			new VictorSP(Port.PWM.leftDriveA), new VictorSP(Port.PWM.leftDriveB));
		Component.rightWheel = new Motor("RightWheel", Component.rightWheelAccelerationCap,
			new VictorSP(Port.PWM.rightDriveA), new VictorSP(Port.PWM.rightDriveB));
		// Motion Controllers
		Component.chassisTurnMC = new CustomPIDController(PID.Turn.P, PID.Turn.I, PID.Turn.D, PID.Turn.F, Component.navx);
		Component.chassisTurnMC.setMinimumNominalOutput(0.24);
		Component.chassisTurnMC.setInputRange(-180, 180);
		Component.chassisTurnMC.setContinuous(true);
		Component.chassisTurnMC.setAbsoluteTolerance(1.0);
		// General Chassis
		Component.shifter = new SolenoidShifters(Port.Pneumatics.shifter.buildDoubleSolenoid());
		Component.chassis = new TankDriveShifting("2018-Chassis", Component.leftWheel, Component.rightWheel, Component.shifter);
		Component.drivePID = new CustomPIDController(PID.Drive.P, PID.Drive.I, PID.Drive.D, PID.Drive.F,
			Component.chassisEncoders);
		Component.drivePID.setAbsoluteTolerance(2.0);
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
		/* Lifters */
		Component.lifterRight = new Lifter(
			Port.Pneumatics.rightLifter.buildDoubleSolenoid(),
			Port.Pneumatics.rightLifterSupport.buildDoubleSolenoid());
		Component.lifterLeft = new Lifter(
			Port.Pneumatics.leftLifter.buildDoubleSolenoid(),
			Port.Pneumatics.leftLifterSupport.buildDoubleSolenoid());
		/* Arm */
		// Encoders
		CANEncoder armEncoder = new CANEncoder(Port.CAN.armEncoderPort);
		CustomPIDController armController = new CustomPIDController(PID.Arm.P, PID.Arm.I, PID.Arm.D, PID.Arm.F, armEncoder);
		armController.setIThreshold(25);
		armController.setAbsoluteTolerance(20); // Uhhhhh, is this in ticks? pls not 20 degrees.
		// Motors
		CANTalonSRX armA = new CANTalonSRX(Port.CANMotor.armMotorA);
		CANTalonSRX armB = new CANTalonSRX(Port.CANMotor.armMotorB);
		armB.setInverted(true);
		// General
		Component.arm = new Arm(armController, armEncoder,
			armA, armB);
		/* Controllers */
		HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
		HumanInput.Driver.xbox.setDeadZone(HumanInterfaceConfig.XBOX_DEADZONE);
		HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);
		HumanInput.Operator.joystick.setDeadzone(HumanInterfaceConfig.STICK_LEFT_DEADZONE);
	}

	public static class PCMPort {
		public int pcmID;
		public int forward;
		public int reverse;

		/**
		 * Defines a piston based on two ports and a PCM number
		 * 
		 * @param pcmID
		 *        The ID of the PCM attached to the piston. Usually 0 or 1.
		 * @param forward
		 *        The forward port of the piston.
		 * @param reverse
		 *        The reverse port of the piston.
		 */
		public PCMPort(int pcmID, int forward, int reverse) { // First variable PCM number, second forward, third reverse.
			this.pcmID = pcmID;
			this.forward = forward;
			this.reverse = reverse;
		}

		public DoubleSolenoid buildDoubleSolenoid() {
			return new DoubleSolenoid(pcmID, forward, reverse);
		}
	}
}