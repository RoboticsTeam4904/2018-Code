package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.commands.IndexerOuttake;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Sequentially set arm to scale position, approach scale, outtake,
 * drive back approach_dist, and set arm to intake position.
 *
 */
public class OuttakeScale extends CommandGroup {
	protected static final double APPROACH_DISTANCE_PAST_SCALE = 6; // this shall now be known as Shiley's Constant.

	/**
	 * Sequentially set arm to scale position, approach scale, outtake,
	 * drive back approach_dist, and set arm to intake position.
	 * Never call unless certain outtaking onto OUR scale.
	 *
	 * @param approach_dist
	 *        Positive distance to approach the scale. Will drive backwards.
	 * @param arm_set
	 *        Boolean signifying if the arm is already in position.
	 */
	public OuttakeScale(double approach_dist, boolean arm_set) {
		// Set arm to scale position. If it's already there, just keep it there in parallel to the rest
		if (arm_set) {
			addParallel(new ArmSet(Arm.ArmState.ARM_POSITION_SCALE));
		} else {
			addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_SCALE));
		}
		// Back up towards scale
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, -approach_dist - APPROACH_DISTANCE_PAST_SCALE,
			RobotMap.Component.drivePID));
		// Outtake cube
		addSequential(new RunFor(new IndexerOuttake(AutonConfig.AUTON_OUTTAKE_SPEED), 1));
		addParallel(new RunFor(new IndexerOuttake(AutonConfig.AUTON_OUTTAKE_SPEED), 1));
		// Move forwards away from scale
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, approach_dist + APPROACH_DISTANCE_PAST_SCALE,
			RobotMap.Component.drivePID));
		// Set arm to intake position
		addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_INTAKE));
	}

	/**
	 * Sequentially set arm to scale position, approach scale, outtake,
	 * drive back approach_dist, and set arm to intake position.
	 * Never call unless certain outtaking onto OUR scale.
	 *
	 * @param approach_dist
	 *        Positive distance to approach the scale. Will drive backwards.
	 */
	public OuttakeScale(double approach_dist) {
		this(approach_dist, false);
	}
}
