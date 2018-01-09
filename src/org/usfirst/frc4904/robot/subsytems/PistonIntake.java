package org.usfirst.frc4904.robot.subsytems;

import org.usfirst.frc4904.robot.commands.PistonIntakeTransport;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PistonIntake extends Subsystem {
	public final Motor roller;
	public final DoubleSolenoid rightPiston;
	public final DoubleSolenoid leftPistion;
	public static final DoubleSolenoid.Value LOWERED = DoubleSolenoid.Value.kReverse;
	public static final DoubleSolenoid.Value RAISED = DoubleSolenoid.Value.kForward;
	public static final double INTAKE_SPEED = -0.55;
	public static final double OUTTAKE_SPEED = 0.45;
	public static final double SECURE_CUBE_SPEED = -1;
	
	public PistonIntake(Motor roller, DoubleSolenoid piston) {
		this.roller = roller;
		this.piston = piston;
	}
	
	@Override
	public void initDefaultCommand(){
		setDefaultCommand(new PistonIntakeTransport());
	}
}
