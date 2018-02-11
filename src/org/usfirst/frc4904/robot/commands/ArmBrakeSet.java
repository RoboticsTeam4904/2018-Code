package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Arm;
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
		this.on = on;
	}

	@Override
	protected void initialize() {
		if (on) {
			RobotMap.Component.diskBrake.set(Arm.BRAKE_ENABLED);
		} else {
			RobotMap.Component.diskBrake.set(Arm.BRAKE_DISABLED);
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}