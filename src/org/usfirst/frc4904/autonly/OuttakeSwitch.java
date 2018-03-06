package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;

/**
 *	Sequentially set arm to switch position, approach switch, outtake,
 *  drive back approach_dist, and set arm to intake position.
 *
 */
public class OuttakeSwitch extends Strategy {
	/**
	 * Constructor. Never call unless certain outtaking onto OUR switch.
	 *
	 * @param approach_dist
	 */
	public OuttakeSwitch(double approach_dist) {
		addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.Metrics.Wheel.TICKS_PER_INCH * approach_dist, RobotMap.Component.drivePID));
		addSequential(new OuttakeSquared());
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, -RobotMap.Metrics.Wheel.TICKS_PER_INCH * approach_dist, RobotMap.Component.drivePID));
		addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_INTAKE));
	}

	@Override
	public void setup() {}
}
