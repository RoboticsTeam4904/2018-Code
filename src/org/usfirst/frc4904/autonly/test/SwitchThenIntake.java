package org.usfirst.frc4904.autonly.test;


import org.usfirst.frc4904.robot.commands.ArmMove;
import org.usfirst.frc4904.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SwitchThenIntake extends CommandGroup {
	public SwitchThenIntake() {
		addSequential(new ArmMove(Arm.ArmState.ARM_POSITION_SCALE, true));
		addSequential(new ArmMove(Arm.ArmState.ARM_POSITION_INTAKE, true));
	}
}