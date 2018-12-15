package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * Allows the piston for the brake
 * on the arm to extend and retract,
 * stopping the arm from moving
 *
 */
public class ArmBrakeSet extends Command {
	private boolean on;

	public ArmBrakeSet(boolean on) {
		requires(RobotMap.Component.discBrake);
		this.on = on;
	}

	@Override
	protected void initialize() {
		LogKitten.wtf("BRAKE HAS BEEN SET");
		RobotMap.Component.discBrake.set(on);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}