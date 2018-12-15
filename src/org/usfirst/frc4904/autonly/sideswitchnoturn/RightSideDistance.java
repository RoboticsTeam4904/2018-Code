package org.usfirst.frc4904.autonly.sideswitchnoturn;


import org.usfirst.frc4904.autonly.CrossBaselineDistance;
import org.usfirst.frc4904.autonly.OuttakeSwitch;
import org.usfirst.frc4904.autonly.SafeVisionCubeIntake;
import org.usfirst.frc4904.autonly.Strategy;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class RightSideDistance extends Strategy {
	public static final double DISTANCE_APPROACH_SWITCH = 144 - RobotMap.Metrics.LENGTH;

	public RightSideDistance() {
		super();
		addSequential(new RunIfElse(new OuttakeSwitch(DISTANCE_APPROACH_SWITCH),
			new CrossBaselineDistance(), () -> {
				return RobotMap.gameField.ourSwitch.isRightOurs();
			}));
		addSequential(new SafeVisionCubeIntake());
	}

	@Override
	public void setup() {}
}
