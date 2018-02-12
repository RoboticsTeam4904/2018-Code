package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class IndexerGrabberSet extends Command {
	protected final boolean clasped;

	public IndexerGrabberSet(boolean clasped) {
		super(clasped ? "IndexerGrabberClasp" : "IndexerGrabberRelease");
		this.clasped = clasped;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.rollyBOI.grabber.set(clasped);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
