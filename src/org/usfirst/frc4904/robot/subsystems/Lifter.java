package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {
	public final Motor extender;
	public static final double SUPPORT_MOTOR_OUT_SPEED = 1;
	public static final double SUPPORT_MOTOR_IN_SPEED = -1;

	public Lifter(Motor extender) {
		this.extender = extender;
	}
	
	
}