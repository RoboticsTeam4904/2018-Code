package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.subsystems.Arm.ArmState;
import org.usfirst.frc4904.standard.commands.Noop;
import org.usfirst.frc4904.standard.commands.RunFor;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class DelayedArmSet extends CommandGroup {
	public static final double DEFAULT_DELAY = 1.0;

	public DelayedArmSet(ArmState state, double delay) {
		addSequential(new RunFor(new Noop(), delay));
		addSequential(new ArmSet(state));
	}

	public DelayedArmSet(ArmState state) {
		this(state, DEFAULT_DELAY);
	}
}
