package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.robot.commands.IndexerGrabberClasp;
import org.usfirst.frc4904.robot.commands.MotorIdleGroup;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RollyBOI extends Subsystem {
	public static final double INTAKE_SPEED = -0.5;
	public static final double OUTTAKE_SPEED = 1.0;
	public final Motor rollerLeft;
	public final Motor rollerRight;
	public final Grabber grabber;

	public RollyBOI(Motor rollerLeft, Motor rollerRight, Grabber grabber) {
		this.rollerLeft = rollerLeft;
		this.rollerRight = rollerRight;
		this.grabber = grabber;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MotorIdleGroup("RollyBOI", this, rollerLeft, rollerRight));
	}

	public void set(double speed) {
		rollerLeft.set(speed);
		rollerRight.set(speed);
	}

	public static class Grabber extends Subsystem {
		public static final DoubleSolenoid.Value CLASPED = DoubleSolenoid.Value.kForward;
		public static final DoubleSolenoid.Value RELEASED = DoubleSolenoid.Value.kReverse;
		protected final DoubleSolenoid grabber;

		public Grabber(DoubleSolenoid grabber) {
			super("RollyBOI Grabber");
			this.grabber = grabber;
		}

		public void set(boolean clasped) {
			if (clasped) this.grabber.set(CLASPED);
			else this.grabber.set(RELEASED);
		}

		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new IndexerGrabberClasp());
		}
	}
}
