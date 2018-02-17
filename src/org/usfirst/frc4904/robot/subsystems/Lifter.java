package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.commands.Idle;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {
	public final DoubleSolenoid extender;
	public final DoubleSolenoid support;
	public static final DoubleSolenoid.Value LIFTER_SOLENOID_RAISED = DoubleSolenoid.Value.kReverse;
	public static final DoubleSolenoid.Value LIFTER_SOLENOID_LOWERED = DoubleSolenoid.Value.kForward;

	public Lifter(DoubleSolenoid extender, DoubleSolenoid support) {
		this.extender = extender;
		this.support = support;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Idle(this));
	}
	
	
}