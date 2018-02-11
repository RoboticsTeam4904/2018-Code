package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.RollyBOI;

public class IndexerGrabberClasp extends IndexerGrabberSet {

	public IndexerGrabberClasp() {
		super(RollyBOI.GrabberState.CLASPED);
	}
}
