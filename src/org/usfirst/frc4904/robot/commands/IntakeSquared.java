package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.RunIf;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeSquared extends CommandGroup {
	public IntakeSquared() {
		super("IntakeSquared");
		addSequential(new RunIf(new ArmSet(Arm.ArmState.ARM_POSITION_INTAKE), () -> {
			return RobotMap.Component.arm.getAngle() != Arm.ArmState.ARM_POSITION_INTAKE.position;
		}));
		addParallel(new IndexerIntake());
		addParallel(new IntakeRollersIntake());
	}
}
