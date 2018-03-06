package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;

/**
 *	Sequentially set arm to scale position, approach switch, outtake,
 *  drive back approach_dist, and set arm to intake position.
 *
 */
public class OuttakeScale extends Strategy {
	/**
	 * Constructor. Never call unless certain outtaking onto OUR scale.
	 *
	 * @param approach_dist
	 *		  Positive distance to approach the scale. Will drive backwards.
	 */
	public OuttakeScale(double approach_dist) {
		// Set arm to scale position
		addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_SCALE));
		// Back up towards scale
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, -RobotMap.Metrics.Wheel.TICKS_PER_INCH * approach_dist, RobotMap.Component.drivePID));
		// Outtake cube
		addSequential(new OuttakeSquared());
		// Move forwards away from scale
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.Metrics.Wheel.TICKS_PER_INCH * approach_dist, RobotMap.Component.drivePID));
		// Set arm to intake position
		addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_INTAKE));
	}

	@Override
	public void setup() {}
}
