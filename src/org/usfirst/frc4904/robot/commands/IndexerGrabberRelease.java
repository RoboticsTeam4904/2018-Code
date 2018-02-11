package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.RollyBOI;

public class IndexerGrabberRelease extends IndexerGrabberSet {

	public IndexerGrabberRelease() {
		super(RollyBOI.GrabberState.RELEASED);
	}
}