package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Lifter;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class LifterSet extends Command {
	private DoubleSolenoid.Value state;
	private DoubleSolenoid lifterPiston;

	public LifterSet(DoubleSolenoid lifterPiston, DoubleSolenoid.Value state, Lifter lifter) {
		requires(lifter);
		this.lifterPiston = lifterPiston;
		this.state = state;
	}


	@Override
	protected void initialize() {
		lifterPiston.set(state);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
