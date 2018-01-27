package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.robot.humaninterface.HumanInterfaceConfig;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.custom.sensors.PDP;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class RobotMap {
	public static class Port { // TODO: Correct Ports
		public static class HumanInput {
			public static final int leftStick = -1;
			public static final int xboxController = -1;
			public static final int rightStick = -1;
		}

		public static class CANMotor {
			public static final int armMotorA = -1;
			public static final int armMotorB = -1;
		}

		public static class CANEncoder {
			public static final int armEncoder = -1;
		}

		public static class PWM {
			public static final int leftDriveA = -1;
			public static final int leftDriveB = -1;
			public static final int rightDriveA = -1;
			public static final int rightDriveB = -1;
		}

		public static class CAN {}

		public static class Pneumatics {
			public static int diskBrakeIn = -1;
			public static int diskBrakeOut = -1;
			public static final int shifterUp = -1;
			public static final int shifterDown = -1;
		}
	}

	public static class Metrics { // TODO: Check in later with design to confirm these metrics.
		public static final double WHEEL_DIAMETER_INCHES = 4;
		public static final double WHEEL_CIRCUMFERENCE_INCHES = Metrics.WHEEL_DIAMETER_INCHES * Math.PI;
		public static final double WHEEL_DISTANCE_FRONT_BACK = 27.373;
		public static final double WHEEL_DISTANCE_SIDE_SIDE = 24.5;
	}

	public static class Component {
		public static Arm arm;
		public static PDP pdp;
		public static TankDriveShifting chassis;
		public static Motor leftWheel;
		public static Motor rightWheel;
		public static DoubleSolenoid diskBrake;
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

	public RobotMap() {
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
		CANEncoder armEncoder = new CANEncoder(-1);// TODO: get the real id from electronics
		Component.arm = new Arm(new CustomPIDController(0, 0, 0, 0, armEncoder), armEncoder,
			new CANTalonSRX(Port.CANMotor.armMotorA), new CANTalonSRX(Port.CANMotor.armMotorB));
		Component.diskBrake = new DoubleSolenoid(Port.Pneumatics.diskBrakeIn, Port.Pneumatics.diskBrakeOut);
		HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
		HumanInput.Driver.xbox.setDeadZone(HumanInterfaceConfig.XBOX_DEADZONE);
		HumanInput.Operator.leftStick = new CustomJoystick(Port.HumanInput.leftStick);
		HumanInput.Operator.leftStick.setDeadzone(HumanInterfaceConfig.STICK_LEFT_DEADZONE);
		HumanInput.Operator.rightStick = new CustomJoystick(Port.HumanInput.rightStick);
		HumanInput.Operator.rightStick.setDeadzone(HumanInterfaceConfig.STICK_RIGHT_DEADZONE);
	}
}
