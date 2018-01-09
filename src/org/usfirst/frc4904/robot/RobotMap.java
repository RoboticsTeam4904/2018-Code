package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.robot.RobotMap.Port;
import org.usfirst.frc4904.robot.subsytems.PistonIntake;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;

public class RobotMap {
	public static class Port {
		public static class HumanInput {
			public static final int joystick = 0;
			public static final int xboxController = 1;
		}

		public static class CANMotor {
			public static final int pistonIntakeRoller = 2;
		}

		public static class PWM {}

		public static class CAN {}

		public static class Pneumatics {
			public static final int pistonIntakeGrab = 3;
			public static final int pistonIntakeRelease = 4;
		}
	}

	public static class Metrics {}

	public static class Component {
		public static PistonIntake pistonIntake;
	}
	/**
	 * The static initializer runs exactly once and ensures that
	 * the variables are properly initialized.
	 */
	static {
		Motor pistonIntakeRoller = new Motor("PistonIntakeRoller", new TalonSRX(Port.CANMotor.pistonIntakeRoller));
		pistonIntakeRoller.setInverted(true);
		DoubleSolenoid pistonIntakePiston = new DoubleSolenoid(Port.Pneumatics.pistonIntakeGrab, Port.Pneumatics.pistonIntakeRelease);
		Component.pistonIntake = new PistonIntake(pistonIntakeRoller, pistonIntakePiston);
	}

	/**
	 * Private constructor overrides the default package-public constructor auto-generated by Java
	 */
	private RobotMap() {}
}
