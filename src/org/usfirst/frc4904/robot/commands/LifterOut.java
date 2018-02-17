package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Lifter;

public class LifterOut extends LifterSet {
	public LifterOut(Lifter lifter) {
		super(lifter.extender, Lifter.LIFTER_SOLENOID_RAISED, lifter);
	}
}