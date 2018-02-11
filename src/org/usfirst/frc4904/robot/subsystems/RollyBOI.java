package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.commands.MotorIdleGroup;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RollyBOI extends Subsystem {
	
	public static final double INTAKE_SPEED = 0.5;
	public static final double OUTTAKE_SPEED = -0.5;
	public final Motor rollerLeft;
	public final Motor rollerRight;
	public final DoubleSolenoid grabber;
	protected GrabberState currentState;
	
	public RollyBOI(Motor rollerLeft, Motor rollerRight, DoubleSolenoid grabber) {
		this.rollerLeft = rollerLeft;
		this.rollerRight = rollerRight;
		this.grabber = grabber;
	}

	public static enum GrabberState {
		RELEASED(DoubleSolenoid.Value.kReverse), CLASPED(DoubleSolenoid.Value.kForward);
		private final DoubleSolenoid.Value grabberValue;

		private GrabberState(DoubleSolenoid.Value grabberValue) {
			this.grabberValue = grabberValue;
		}

		public DoubleSolenoid.Value getGrabberValue() {
			return grabberValue;
		}
	}

	public GrabberState getState() {
		return currentState;
	}

	public void setState(GrabberState state) {
		grabber.set(state.getGrabberValue());
		currentState = state;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MotorIdleGroup("RollyBOI", this, true, rollerLeft, rollerRight));
	}
	
	public void set(double speed) {
		rollerLeft.set(speed);
		rollerRight.set(speed);
	}
	
	
}
