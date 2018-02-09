package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.RollyBOI;
import edu.wpi.first.wpilibj.command.Command;

public class IndexerGrabberClasp extends Command {

	public IndexerGrabberClasp() {
		super("IndexerGrabberClasp");
		requires(RobotMap.Component.rollyBOI);
	}

	@Override
	protected void initialize() {
		RobotMap.Component.rollyBOI.grabber.set(RollyBOI.CLASPED);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
