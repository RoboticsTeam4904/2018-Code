package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.robot.humaninterface.HumanInterfaceConfig;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.robot.subsystems.Arm.DiscBrake;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.custom.sensors.EncoderPair;
import org.usfirst.frc4904.standard.custom.sensors.NavX;
import org.usfirst.frc4904.standard.custom.sensors.PDP;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RobotMap {
	public static class Port { // TODO: Correct Ports
		public static class HumanInput {
			public static final int joystick = 0;
			public static final int xboxController = 1;
		}

		public static class CANMotor {
			public static final int armMotorA = 9;
			public static final int armMotorB = 14;
		}

		public static class CANEncoder {
			public static final int armEncoderPort = 0x612;
		}

		public static class PWM {
			public static final int leftDriveA = 2;
			public static final int leftDriveB = 3;
			public static final int rightDriveA = 0;
			public static final int rightDriveB = 1;
		}

		public static class CAN {
			public static final int leftEncoder = -1;
			public static final int rightEncoder = -1;
		}

		public static class Pneumatics {
			public static int discBrakeOn = 2;
			public static int discBrakeOff = 3;
			public static final int shifterUp = 0;
			public static final int shifterDown = 1;
		}
	}

	public static class Metrics { // TODO: Check in later with design to confirm these metrics.
		public static class Wheel {
			public static final double TICKS_PER_REVOLUTION = 256;
			public static final double DIAMETER_INCHES = 4;
			public static final double CIRCUMFERENCE_INCHES = Metrics.Wheel.DIAMETER_INCHES * Math.PI;
			public static final double TICKS_PER_INCH = Metrics.Wheel.TICKS_PER_REVOLUTION
				/ Metrics.Wheel.CIRCUMFERENCE_INCHES;
			public static final double DISTANCE_FRONT_BACK = 27.37;
			public static final double DISTANCE_SIDE_SIDE = 25.21;
			public static final double INCHES_PER_TICK = Metrics.Wheel.CIRCUMFERENCE_INCHES
				/ Metrics.Wheel.TICKS_PER_REVOLUTION;
		}
		public static final double LENGTH = 32.75;
		public static final double WIDTH = 27.75;
	}

	public static class Component {
		public static Arm arm;
		public static PDP pdp;
		public static TankDriveShifting chassis;
		public static Motor leftWheel;
		public static Motor rightWheel;
		public static DiscBrake discBrake;
		public static SolenoidShifters shifter;
		public static EnableableModifier rightWheelAccelerationCap;
		public static EnableableModifier leftWheelAccelerationCap;
		public static CustomXbox driverXbox;
		public static CANEncoder leftWheelEncoder;
		public static CANEncoder rightWheelEncoder;
		public static EncoderPair chassisEncoders;
		public static CustomPIDController chassisTurnMC;
		public static NavX navx;
		public static Subsystem[] mainSubsystems;
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
		Component.pdp = new PDP();
		// Wheels
		Component.leftWheelEncoder = new CANEncoder("LeftEncoder", Port.CAN.leftEncoder);
		Component.rightWheelEncoder = new CANEncoder("RightEncoder", Port.CAN.rightEncoder);
		Component.leftWheelEncoder.setDistancePerPulse(Metrics.Wheel.INCHES_PER_TICK);
		Component.rightWheelEncoder.setDistancePerPulse(Metrics.Wheel.INCHES_PER_TICK);
		Component.leftWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
		Component.leftWheelAccelerationCap.enable();
		Component.rightWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
		Component.rightWheelAccelerationCap.enable();
		Component.leftWheel = new Motor("LeftWheel", Component.leftWheelAccelerationCap,
			new VictorSP(Port.PWM.leftDriveA), new VictorSP(Port.PWM.leftDriveB));
		Component.rightWheel = new Motor("RightWheel", Component.rightWheelAccelerationCap,
			new VictorSP(Port.PWM.rightDriveA), new VictorSP(Port.PWM.rightDriveB));
		// Chassis
		Component.shifter = new SolenoidShifters(Port.Pneumatics.shifterUp, Port.Pneumatics.shifterDown);
		Component.chassisEncoders = new EncoderPair(Component.leftWheelEncoder, Component.rightWheelEncoder);
		Component.chassis = new TankDriveShifting("2018-Chassis", Component.leftWheel, Component.rightWheel, Component.shifter);
		// Arm
		CANEncoder armEncoder = new CANEncoder(Port.CANEncoder.armEncoderPort);
		CANTalonSRX armA = new CANTalonSRX(Port.CANMotor.armMotorA);
		CANTalonSRX armB = new CANTalonSRX(Port.CANMotor.armMotorB);
		armB.setInverted(true);
		CustomPIDController armController = new CustomPIDController(0.01, 0.00001, -0.001, 0, armEncoder);
		armController.setIThreshold(25);
		armController.setAbsoluteTolerance(5);
		Component.arm = new Arm(armController, armEncoder,
			armA, armB);
		Component.discBrake = new DiscBrake(new DoubleSolenoid(Port.Pneumatics.discBrakeOn, Port.Pneumatics.discBrakeOff));
		HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
		HumanInput.Driver.xbox.setDeadZone(HumanInterfaceConfig.XBOX_DEADZONE);
		HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);
		HumanInput.Operator.joystick.setDeadzone(HumanInterfaceConfig.STICK_LEFT_DEADZONE);
		// Controllers
		Component.driverXbox = new CustomXbox(Port.HumanInput.xboxController);
		Component.driverXbox.setDeadZone(0.1);
		Component.mainSubsystems = new Subsystem[] {
				Component.chassis,
				// Component.crateIO,
				Component.arm// ,
				// Component.lifterRight,
				// Component.lifterLeft
		};
	}
}
