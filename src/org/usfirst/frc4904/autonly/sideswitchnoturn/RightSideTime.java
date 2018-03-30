package org.usfirst.frc4904.autonly.sideswitchnoturn;


import org.usfirst.frc4904.autonly.AutonConfig;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ArmSet;
import org.usfirst.frc4904.robot.commands.IndexerOuttake;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.LogKitten.KittenLevel;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.chassis.ChassisConstant;

public class RightSideTime extends SideSwitchTime {
	public RightSideTime() {
		addParallel(new RunIf(new ArmSet(Arm.ArmState.ARM_POSITION_SWITCH), () -> {
			return RobotMap.gameField.ourSwitch.isRightOurs();
		}));
		addSequential(new ChassisConstant(RobotMap.Component.chassis, 0, AutonConfig.DEAD_RECKON_DRIVE_SPEED, 0,
			SideSwitchTime.TIME_APPROACH_SWITCH));
		addSequential(new KittenCommand(
			"Is the right switch ours: " + Boolean.toString(RobotMap.gameField.ourSwitch.isRightOurs()), KittenLevel.WTF));
		addSequential(
			new RunIf(new RunFor(new IndexerOuttake(AutonConfig.AUTON_OUTTAKE_SPEED), SideSwitchTime.TIME_OUTTAKE), () -> {
				return RobotMap.gameField.ourSwitch.isRightOurs();
			}));
	}
}
