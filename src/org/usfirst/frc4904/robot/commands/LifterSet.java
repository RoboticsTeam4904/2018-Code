package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Lifter;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class LifterSet extends Command {
	private Lifter lifter;
	private DoubleSolenoid.Value state;

	public LifterSet(Lifter lifter, DoubleSolenoid.Value state) {
		this.lifter = lifter;
		this.state = state;
		requires(lifter);
	}

	@Override
	protected void initialize() {
		lifter.extender.set(state);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
