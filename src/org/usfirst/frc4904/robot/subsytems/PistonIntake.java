package org.usfirst.frc4904.robot.subsytems;

import org.usfirst.frc4904.robot.commands.PistonIntakeTransport;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PistonIntake extends Subsystem {
	public final Motor rightRoller;
	public final Motor leftRoller;
	public final DoubleSolenoid piston;
	public static final DoubleSolenoid.Value RELEASED = DoubleSolenoid.Value.kReverse;
	public static final DoubleSolenoid.Value GRABBED = DoubleSolenoid.Value.kForward;
	public static final double INTAKE_SPEED = -0.55;
	public static final double OUTTAKE_SPEED = 0.45;
	public static final double ROLLOUT_DELAY_SEC = 0.1;
	public static final double ROLLIN_TIMEOUT_SEC = 1;
	
	public PistonIntake(Motor rightRoller, Motor leftRoller, DoubleSolenoid piston) {
		this.rightRoller = rightRoller;
		this.leftRoller = leftRoller;
		this.piston = piston;
	}
	
	@Override
	public void initDefaultCommand(){
		setDefaultCommand(new PistonIntakeTransport());
	}
}
