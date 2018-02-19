package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.Cancel;
import org.usfirst.frc4904.standard.commands.Noop;
import org.usfirst.frc4904.standard.commands.RunAllSequential;
import org.usfirst.frc4904.standard.commands.WaitUntil;
import org.usfirst.frc4904.standard.custom.sensors.InvalidSensorException;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeSquaredGeneral extends CommandGroup {
	protected IntakeRollersIntake intakeRollersIntake = new IntakeRollersIntake();

	public IntakeSquaredGeneral() {
		super("IntakeSquaredGeneral");
		requires(RobotMap.Component.crateIO);
		requires(RobotMap.Component.rollyBOI);
		addParallel(new IndexerIntake());
		addParallel(intakeRollersIntake);
		addParallel(new RunAllSequential(new WaitUntil(() -> {
			try {
				return (RobotMap.Component.intakeSwitch.readSensor()[0] == 1)
					|| (RobotMap.Component.intakeSwitch.readSensor()[1] == 1);
			}
			catch (InvalidSensorException e) {
				e.printStackTrace();
				return false;
			}
		}), new Cancel(intakeRollersIntake), new Noop()));
	}

	public class IntakeJank extends CommandGroup {
		public IntakeJank() {}
	}
}
