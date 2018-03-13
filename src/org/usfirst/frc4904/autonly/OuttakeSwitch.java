package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.commands.IndexerOuttake;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Sequentially set arm to switch position, approach switch, outtake,
 * drive back approach_dist, and set arm to intake position.
 *
 */
public class OuttakeSwitch extends CommandGroup {
	/**
	 * Constructor. Never call unless certain outtaking onto OUR switch.
	 *
	 * @param approach_dist
	 *        Positive distance to approach the switch.
	 */
	public OuttakeSwitch(double approach_dist) {
		// Set arm to switch position
		addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
		// Drive and approach switch
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, approach_dist, RobotMap.Component.drivePID));
		// Outtake cube
		addSequential(new IndexerOuttake(AutonConfig.AUTON_OUTTAKE_SPEED));
		// Drive back away from switch
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, -approach_dist, RobotMap.Component.drivePID));
		// Set arm to intake position
		addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_INTAKE));
	}
}
