package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Lifter.Extender;
import edu.wpi.first.wpilibj.command.Command;

public class ExtenderSet extends Command {
	private boolean deployed;
	private Extender extender;

	public ExtenderSet(Extender extender, boolean deployed) {
		requires(extender);
		this.extender = extender;
		this.deployed = deployed;
	}

	@Override
	protected void initialize() {
		extender.set(deployed);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
