package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.RollyBOI;
import org.usfirst.frc4904.standard.LogKitten;
import edu.wpi.first.wpilibj.command.Command;

public class IndexerGrabberSet extends Command {
	protected final RollyBOI.GrabberState state;

	public IndexerGrabberSet(RollyBOI.GrabberState state) {
		this.state = state;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.rollyBOI.setState(state);
		LogKitten.wtf("We are setting solenoid to " + state.name());
	}

	@Override
	protected void interrupted() {
		RobotMap.Component.rollyBOI.setState(RollyBOI.GrabberState.CLASPED);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
