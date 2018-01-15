package org.usfirst.frc4904.autonly;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.Noop;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SideSwitchDistance extends Strategy {
	public static final double DISTANCE_APPROACH_SWITCH = 9; // TODO: Test this distance.
	
	public SideSwitchDistance() {}

	@Override
	public void setup() {
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.Metrics.Wheel.TICKS_PER_INCH * this.DISTANCE_APPROACH_SWITCH, RobotMap.Component.drivePID));
    }
}
