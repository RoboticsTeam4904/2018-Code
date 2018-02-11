package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Lifter;

public class LifterOut extends LifterSet {
	public LifterOut(Lifter lifter) {
		super(lifter, Lifter.SUPPORT_SOLENOID_RAISED);
	}
}