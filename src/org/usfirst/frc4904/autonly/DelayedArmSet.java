package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.subsystems.Arm.ArmState;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class DelayedArmSet extends CommandGroup {
	public static final double DEFAULT_DELAY = 1.0;

	public DelayedArmSet(ArmState state, double delay) {
		addSequential(new WaitCommand(delay));
		addParallel(new ArmSet(state));
	}

	public DelayedArmSet(ArmState state) {
		this(state, DEFAULT_DELAY);
	}
}
