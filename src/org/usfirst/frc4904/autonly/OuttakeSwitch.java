package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.commands.IndexerOuttake;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Sequentially set arm to switch position, approach switch, outtake,
 * drive back approach_dist, and set arm to intake position.
 *
 */
public class OuttakeSwitch extends CommandGroup {
	/**
	 * Sequentially set arm to switch position, approach switch, outtake,
	 * drive back approach_dist, and set arm to intake position.
	 * Never call unless certain outtaking onto OUR switch.
	 *
	 * @param approach_dist
	 *        Positive distance to approach the switch.
	 * @param arm_set
	 *        Boolean signifying if the arm is already in position.
	 */
	public OuttakeSwitch(double approach_dist, boolean arm_set) {
		// Set arm to switch position. If it's already there, just keep it there in parallel to the rest
		if (arm_set) {
			addParallel(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
		} else {
			addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
		}
		addParallel(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
		// Drive and approach switch
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, approach_dist, RobotMap.Component.drivePID));
		// Outtake cube
		addSequential(new RunFor(new IndexerOuttake(AutonConfig.AUTON_OUTTAKE_SPEED), 2));
		// Drive back away from switch
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, -approach_dist, RobotMap.Component.drivePID));
		// Set arm to intake position
		addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_INTAKE));
	}

	/**
	 * Sequentially set arm to scale position, approach switch, outtake,
	 * drive back approach_dist, and set arm to intake position.
	 * Never call unless certain outtaking onto OUR switch.
	 *
	 * @param approach_dist
	 *        Positive distance to approach the switch.
	 */
	public OuttakeSwitch(double approach_dist) {
		this(approach_dist, false);
	}

	public OuttakeSwitch(boolean arm_set) {
		// Set arm to switch position. If it's already there, just keep it there in parallel to the rest
		if (arm_set) {
			addParallel(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
		} else {
			addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
		}
		addParallel(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
		// Drive and approach switch
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, 0, RobotMap.Component.lidarPID));
		// Outtake cube
		addSequential(new RunFor(new IndexerOuttake(AutonConfig.AUTON_OUTTAKE_SPEED), 2));
		// Drive back away from switch
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, -20, RobotMap.Component.drivePID));
		// Set arm to intake position
		addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_INTAKE));
	}

	public OuttakeSwitch() {
		this(false);
	}
}
