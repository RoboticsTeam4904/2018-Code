package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Lifter.Support;
import edu.wpi.first.wpilibj.command.Command;

public class SupportSet extends Command {
	private boolean raised;
	private Support support;

	public SupportSet(Support support, boolean raised) {
		requires(support);
		this.support = support;
		this.raised = raised;
	}

	@Override
	protected void initialize() {
		support.set(raised);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
