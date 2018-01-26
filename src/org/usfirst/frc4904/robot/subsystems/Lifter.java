package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.Idle;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {
	public final DoubleSolenoid extender;
	public static final DoubleSolenoid.Value SUPPORT_SOLENOID_RAISED = DoubleSolenoid.Value.kReverse;
	public static final DoubleSolenoid.Value SUPPORT_SOLENOID_LOWERED = DoubleSolenoid.Value.kForward;

	public Lifter(DoubleSolenoid extender) {
		this.extender = extender;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Idle(RobotMap.Component.lifterLeft));
	}
	
	
}