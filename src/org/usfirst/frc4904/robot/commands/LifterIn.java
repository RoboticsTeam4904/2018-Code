package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Lifter;

public class LifterIn extends LifterSet {
	public LifterIn(Lifter lifter) {
		super(lifter, Lifter.SUPPORT_SOLENOID_LOWERED);
	}
}