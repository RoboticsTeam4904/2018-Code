package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Lifter;

class LifterSupportIn extends LifterSet {
	public LifterSupportIn(Lifter lifter) {
		super(lifter.support, Lifter.LIFTER_SOLENOID_LOWERED, lifter);
		}
	}
