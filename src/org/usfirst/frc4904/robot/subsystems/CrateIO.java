package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.RollersRest;

public class CrateIO extends Subsystem {
	
	public static final double INTAKE_SPEED = 1.0;
	public static final double OUTTAKE_SPEED = -1.0;
	public static final double AT_REST = 0.0;
	
	public CrateIO(Motor roller) {
		RobotMap.Component.CubeIOroller = roller;
		this.setDefaultCommand(new RollersRest());
	}

	@Override
	protected void initDefaultCommand() {
		set(CrateIO.AT_REST);
	}

	private void set(double atRest) {
		
	}

}
