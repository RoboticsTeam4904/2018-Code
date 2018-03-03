package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonSwitch extends CommandGroup {
	public AutonSwitch() {
		addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
	}
}
