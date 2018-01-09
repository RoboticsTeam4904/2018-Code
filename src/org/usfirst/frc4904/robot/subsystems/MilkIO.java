package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MilkIO extends Subsystem {

	public static Motor roller;
	public static final double INTAKE_SPEED = 1.0;
	public static final double OUTTAKE_SPEED = -1.0;
	public static final double AT_REST = 0.0;
	
	public MilkIO(Motor roller) {
		this.roller = roller;
	}
	
	@Override
	protected void initDefaultCommand() {
		set(MilkIO.AT_REST);
	}

	private void set(double atRest) {
		
	}

}
