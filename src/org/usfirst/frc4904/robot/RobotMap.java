package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.robot.RobotMap.Component;
import org.usfirst.frc4904.robot.RobotMap.Port;
import org.usfirst.frc4904.robot.subsystems.CrateIO;
import org.usfirst.frc4904.robot.subsystems.RollyBOI;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
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
			public static final int joystick = 0;
			public static final int xboxController = 1;
		}

		public static class CANMotor {
			public static final int crateIORollerMotorLeft = 14;
			public static final int crateIORollerMotorRight = -1;
			public static final int rollyBOIRollerMotorLeft = -1;
			public static final int rollyBOIRollerMotorRight = -1;
		}

		public static class PWM {
//			public static final int leftDriveA = 2;
//			public static final int leftDriveB = 3;
//			public static final int rightDriveA = 0;
//			public static final int rightDriveB = 1;
		}

		public static class CAN {}

		public static class Pneumatics {
//			public static final int shifterUp = -1;
//			public static final int shifterDown = -1;
//			public static final int rollyBOIArmIn = -1;
//			public static final int rollyBOIArmOut = -1;
		}
	}

	public static class Metrics { // TODO: Check in later with design to confirm these metrics.
		public static final double WHEEL_DIAMETER_INCHES = 4;
		public static final double WHEEL_CIRCUMFERENCE_INCHES = Metrics.WHEEL_DIAMETER_INCHES * Math.PI;
		public static final double WHEEL_DISTANCE_FRONT_BACK = 27.373;
		public static final double WHEEL_DISTANCE_SIDE_SIDE = 24.5;
	}

	public static class Component {
		public static PDP pdp;
//		public static TankDriveShifting chassis;
//		public static Motor leftWheel;
//		public static Motor rightWheel;
		public static Motor crateIORollerLeft;
		public static Motor crateIORollerRight;
		public static Motor rollyBOIRollerLeft;
		public static Motor rollyBOIRollerRight;
//		public static SolenoidShifters shifter;
		public static DoubleSolenoid rollyBOIArms;
//		public static EnableableModifier rightWheelAccelerationCap;
//		public static EnableableModifier leftWheelAccelerationCap;
		public static CrateIO crateIO;
		public static RollyBOI rollyBOI;
		public static CustomJoystick joystick;
	}

	public RobotMap() {
		Component.joystick = new CustomJoystick(Port.HumanInput.joystick);
		Component.pdp = new PDP();
//		Component.leftWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
//		Component.leftWheelAccelerationCap.enable();
//		Component.rightWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
//		Component.rightWheelAccelerationCap.enable();
//		Component.leftWheel = new Motor("LeftWheel", Component.leftWheelAccelerationCap,
//			new VictorSP(Port.PWM.leftDriveA), new VictorSP(Port.PWM.leftDriveB));
//		Component.rightWheel = new Motor("RightWheel", Component.rightWheelAccelerationCap,
//			new VictorSP(Port.PWM.rightDriveA), new VictorSP(Port.PWM.rightDriveB));
//		Component.shifter = new SolenoidShifters(Port.Pneumatics.shifterUp, Port.Pneumatics.shifterDown);
//		Component.chassis = new TankDriveShifting("2018-Chassis", Component.leftWheel, Component.rightWheel, Component.shifter);
		Component.crateIORollerLeft = new Motor("CrateIORollers", new CANTalonSRX(Port.CANMotor.crateIORollerMotorLeft));
		Component.crateIORollerRight = new Motor("CrateIORollers", new CANTalonSRX(Port.CANMotor.crateIORollerMotorRight));
		Component.crateIO = new CrateIO(Component.crateIORollerLeft, Component.crateIORollerRight);
		Component.rollyBOIRollerLeft = new Motor("RollyBOIRollers", new CANTalonSRX(Port.CANMotor.rollyBOIRollerMotorLeft));
		Component.rollyBOIRollerRight = new Motor("RollyBOIRollers", new CANTalonSRX(Port.CANMotor.rollyBOIRollerMotorRight));
		Component.rollyBOI = new RollyBOI(Component.rollyBOIRollerLeft, Component.rollyBOIRollerRight);
//		Component.rollyBOIArms = new DoubleSolenoid(Port.Pneumatics.rollyBOIArmIn, Port.Pneumatics.rollyBOIArmOut);
	}
}
