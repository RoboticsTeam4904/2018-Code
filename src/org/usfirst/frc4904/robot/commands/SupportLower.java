package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Lifter;

class SupportLower extends SupportSet {
	public SupportLower(Lifter lifter) {
		super(lifter.support, false);
	}
}
