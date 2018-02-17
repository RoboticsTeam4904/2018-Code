package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Lifter;

public class LifterIn extends LifterSet {
	public LifterIn(Lifter lifter) {
		super(lifter.extender, Lifter.LIFTER_SOLENOID_LOWERED, lifter);
	}
}