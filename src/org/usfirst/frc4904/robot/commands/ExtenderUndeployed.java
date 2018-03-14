package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Lifter;

public class ExtenderUndeployed extends ExtenderSet {
	public ExtenderUndeployed(Lifter lifter) {
		super(lifter.extender, false);
	}
}