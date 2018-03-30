package org.usfirst.frc4904.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class RightSideDistance extends Strategy {
	public static final double DISTANCE_APPROACH_SWITCH = 144 - RobotMap.Metrics.LENGTH;

	public RightSideDistance() {
		super();
		addSequential(new RunIfElse(new OuttakeSwitch(DISTANCE_APPROACH_SWITCH),
			new CrossBaselineDistance(), () -> {
				return RobotMap.gameField.ourSwitch.isRightOurs();
			}));
		addSequential(new RunIf(new SafeVisionCubeIntake(), () -> {
			return RobotMap.gameField.ourSwitch.isRightOurs();
		}));
	}

	@Override
	public void setup() {}
}
