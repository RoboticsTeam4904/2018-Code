package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.RollyBOI;
import edu.wpi.first.wpilibj.command.Command;

public class IndexerGrabberSet extends Command {
	protected final RollyBOI.GrabberState state;

	public IndexerGrabberSet(RollyBOI.GrabberState state) {
		this.state = state;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.rollyBOI.setState(state);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
