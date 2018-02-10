package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.commands.IdleMotors;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CrateIO extends Subsystem {

	public static final double INTAKE_SPEED = -0.85;
	public static final double OUTTAKE_SPEED = 0.75;
	public final Motor rollerLeft;
	public final Motor rollerRight;

	public CrateIO(Motor rollerLeft, Motor rollerRight) {
		this.rollerLeft = rollerLeft;
		this.rollerRight = rollerRight;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new IdleMotors(this, rollerLeft, rollerRight));
	}

	public void set(double speed) {
		rollerLeft.set(speed);
		rollerRight.set(speed);
	}

}
