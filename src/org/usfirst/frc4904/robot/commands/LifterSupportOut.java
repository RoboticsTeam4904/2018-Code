package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Lifter;

public class LifterSupportOut extends LifterSet {
	public LifterSupportOut(Lifter lifter) {
		super(lifter.support, Lifter.LIFTER_SOLENOID_RAISED, lifter);
	}
}
