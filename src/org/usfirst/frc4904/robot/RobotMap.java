package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.robot.humaninterface.HumanInterfaceConfig;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.sensors.CANTalonEncoder;
import org.usfirst.frc4904.standard.custom.sensors.PDP;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;
import edu.wpi.first.wpilibj.VictorSP;

public class RobotMap {
	public static class Port { // TODO: Correct Ports
		public static class HumanInput {
			public static final int leftStick = 0;
			public static final int xboxController = 1;
			public static final int rightStick = 2;
		}

		public static class CANMotor {
			public static final int elbowMotorA = -1; // TODO: change this motor port numbers when we know what they are
			public static final int elbowMotorB = -1;
			public static final int wristMotorA = -1;
			public static final int wristMotorB = -1;
		}

		public static class CANEncoder {
			public static final int elbowEncoderA = -1;
			public static final int elbowEncoderB = -1;
			public static final int wristEncoderA = -1;
			public static final int wristEncoderB = -1;
		}

		public static class PWM {
			public static final int leftDriveA = -1;
			public static final int leftDriveB = -1;
			public static final int rightDriveA = -1;
			public static final int rightDriveB = -1;
		}

		public static class CAN {}

		public static class Pneumatics {
			public static final int shifterUp = -1;
			public static final int shifterDown = -1;
		}
	}

	public static class Metrics {
		public static final double WHEEL_DIAMETER_INCHES = 4;
		public static final double WHEEL_CIRCUMFERENCE_INCHES = Metrics.WHEEL_DIAMETER_INCHES * Math.PI;
		public static final double WHEEL_DISTANCE_FRONT_BACK = 27.373;
		public static final double WHEEL_DISTANCE_SIDE_SIDE = 24.5;
	}

	public static class Component {
		public static Arm boxio;
		public static PDP pdp;
		public static TankDriveShifting chassis;
		public static Motor leftWheel;
		public static Motor rightWheel;
		public static SolenoidShifters shifter;
		public static EnableableModifier rightWheelAccelerationCap;
		public static EnableableModifier leftWheelAccelerationCap;
	}

	public static class HumanInput {
		public static class Driver {
			public static CustomXbox xbox;
		}

		public static class Operator {
			public static CustomJoystick leftStick;
			public static CustomJoystick rightStick;
		}
	}
	/**
	 * The static initializer runs exactly once and ensures that
	 * the variables are properly initialized.
	 */
	static {
		Motor elbowMotorA = new Motor("elbowMotorA", new CANTalonSRX(Port.CANMotor.elbowMotorA)); // use TalonSRX when we have it
		Motor elbowMotorB = new Motor("elbowMotorB", new CANTalonSRX(Port.CANMotor.elbowMotorB));
		Motor wristMotorA = new Motor("wristMotorA", new CANTalonSRX(Port.CANMotor.wristMotorA));
		Motor wristMotorB = new Motor("wristMotorB", new CANTalonSRX(Port.CANMotor.wristMotorB));
		CANTalonEncoder elbowEncoderA = new CANTalonEncoder("elbowEncoderA", new CANTalonSRX(Port.CANEncoder.elbowEncoderA));
		CANTalonEncoder elbowEncoderB = new CANTalonEncoder("elbowEncoderB", new CANTalonSRX(Port.CANEncoder.elbowEncoderB));
		CANTalonEncoder wristEncoderA = new CANTalonEncoder("wristEncoderA", new CANTalonSRX(Port.CANEncoder.wristEncoderA));
		CANTalonEncoder wristEncoderB = new CANTalonEncoder("wristEncoderB", new CANTalonSRX(Port.CANEncoder.wristEncoderB));
		Component.boxio = new Arm(elbowMotorA, elbowMotorB, wristMotorA, wristMotorB,
			elbowEncoderA, elbowEncoderB, wristEncoderA, wristEncoderB);
		HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
		HumanInput.Driver.xbox.setDeadZone(HumanInterfaceConfig.XBOX_DEADZONE);
		HumanInput.Operator.leftStick = new CustomJoystick(Port.HumanInput.leftStick);
		HumanInput.Operator.leftStick.setDeadzone(HumanInterfaceConfig.STICK_LEFT_DEADZONE);
		HumanInput.Operator.rightStick = new CustomJoystick(Port.HumanInput.rightStick);
		HumanInput.Operator.leftStick.setDeadzone(HumanInterfaceConfig.STICK_RIGHT_DEADZONE);
		Component.pdp = new PDP();
		Component.leftWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
		Component.leftWheelAccelerationCap.enable();
		Component.rightWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
		Component.rightWheelAccelerationCap.enable();
		Component.leftWheel = new Motor("LeftWheel", Component.leftWheelAccelerationCap,
			new VictorSP(Port.PWM.leftDriveA), new VictorSP(Port.PWM.leftDriveB));
		Component.rightWheel = new Motor("RightWheel", Component.rightWheelAccelerationCap,
			new VictorSP(Port.PWM.rightDriveA), new VictorSP(Port.PWM.rightDriveB));
		Component.shifter = new SolenoidShifters(Port.Pneumatics.shifterUp, Port.Pneumatics.shifterDown);
		Component.chassis = new TankDriveShifting("2018-Chassis", Component.leftWheel, Component.rightWheel, Component.shifter);
	}

	/**
	 * Private constructor overrides the default package-public constructor auto-generated by Java
	 */
	private RobotMap() {}
}
