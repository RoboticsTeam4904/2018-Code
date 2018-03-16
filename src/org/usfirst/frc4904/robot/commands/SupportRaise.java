package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Lifter;

public class SupportRaise extends SupportSet {
	public SupportRaise(Lifter lifter) {
		super(lifter.support, true);
	}
}
