package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.motor.MotorIdle;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * 
 * Once ArmMove puts the arm into
 * the desired position, the boolean
 * endOnArrival is true, causing
 * the 'on' value in ArmBrakeSet to
 * change to true, extending the
 * piston and stopping the arm.
 *
 */
public class ArmSet extends CommandGroup {
	public ArmSet(Arm.ArmState state) {
		// Command armMove =
		addSequential(new ArmMove(state, true));
		// addSequential(new KittenCommand("Done moving", LogKitten.KittenLevel.WTF));
		// addSequential(armMove.cancel);
		addParallel(new MotorIdle(RobotMap.Component.arm));
		addSequential(new ArmBrakeSet(true));
	}
}
