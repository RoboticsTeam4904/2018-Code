package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.commands.IntakeSquared;
import org.usfirst.frc4904.robot.commands.OuttakeSquared;
import org.usfirst.frc4904.robot.commands.ReleaseIntake;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class SideTwoAuton extends SideSwitchTime {
	public static final double BACKWARD_DISTANCE = -60; // TODO: ALL of these constants
	public static final double FORWARD_DISTANCE = -BACKWARD_DISTANCE;
	public static final double DIST_TO_CUBE_STACK = -BACKWARD_DISTANCE * Math.sqrt(2);
	public static final double TURN_ANGLE = 45;
	public static final double INTAKE_TIME = 3;

	public SideTwoAuton(boolean leftSide) {
		addSequential(new ReleaseIntake());
		addSequential((leftSide ? new LeftSideTime() : new RightSideTime()));
		addParallel(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * BACKWARD_DISTANCE, RobotMap.Component.drivePID));
		addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_INTAKE));
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, (leftSide ? 1 : -1) * TURN_ANGLE, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC));
		addParallel(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * DIST_TO_CUBE_STACK, RobotMap.Component.drivePID));
		addSequential(new RunFor(new IntakeSquared(), INTAKE_TIME));
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * -DIST_TO_CUBE_STACK, RobotMap.Component.drivePID));
		addSequential(
			new ChassisTurn(RobotMap.Component.chassis, (leftSide ? -1 : 1) * TURN_ANGLE, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC));
		addParallel(new ChassisMoveDistance(RobotMap.Component.chassis,
			RobotMap.Metrics.Wheel.TICKS_PER_INCH * FORWARD_DISTANCE, RobotMap.Component.drivePID));
		addSequential(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH));
		addSequential(new RunIf(new OuttakeSquared(), () -> {
			return RobotMap.gameField.ourSwitch.isLeftOurs();
		}));

	}
}
