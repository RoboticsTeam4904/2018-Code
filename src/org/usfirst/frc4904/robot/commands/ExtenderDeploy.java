package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Lifter;

public class ExtenderDeploy extends ExtenderSet {
	public ExtenderDeploy(Lifter lifter) {
		super(lifter.extender, true);
	}
}