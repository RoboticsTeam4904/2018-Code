package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.robot.commands.ExtenderSet;
import org.usfirst.frc4904.robot.commands.SupportSet;
import org.usfirst.frc4904.standard.commands.Idle;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {
	public final Extender extender;
	public final Support support;
	public int lifterOut;
	public int lifterIn;
	public int lifterSupportOut;
	public int lifterSupportIn;

	public Lifter(Extender extender, Support support) {
		this.extender = extender;
		this.support = support;
	}

	public Lifter(int lifterOut, int lifterIn, int lifterSupportOut, int lifterSupportIn) {
		this.lifterOut = lifterOut;
		this.lifterIn = lifterIn;
		this.extender = new Extender(
			new DoubleSolenoid(lifterOut, lifterIn));
		this.support = new Support(
			new DoubleSolenoid(lifterSupportOut, lifterSupportIn));
	}

	public Lifter(DoubleSolenoid extender, DoubleSolenoid support) {
		this.extender = new Extender(extender);
		this.support = new Support(support);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Idle(this));
	}

	public static class Extender extends Subsystem {
		public final DoubleSolenoid extender;
		public static final DoubleSolenoid.Value EXTENDER_SOLENOID_NOT_DEPLOYED = DoubleSolenoid.Value.kForward;
		public static final DoubleSolenoid.Value EXTENDER_SOLENOID_DEPLOYED = DoubleSolenoid.Value.kReverse;
		public boolean isDeployed;

		public Extender(DoubleSolenoid extender) {
			this.extender = extender;
			this.isDeployed = false;
		}

		public void set(boolean deployed) {
			if (deployed) {
				this.extender.set(EXTENDER_SOLENOID_DEPLOYED);
				this.isDeployed = true;
			} else {
				this.extender.set(EXTENDER_SOLENOID_NOT_DEPLOYED);
			}
		}

		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new ExtenderSet(this, false));
		}
	}

	public static class Support extends Subsystem {
		public final DoubleSolenoid support;
		public static final DoubleSolenoid.Value SUPPORT_SOLENOID_RAISED = DoubleSolenoid.Value.kForward;
		public static final DoubleSolenoid.Value SUPPORT_SOLENOID_LOWERED = DoubleSolenoid.Value.kReverse;

		public Support(DoubleSolenoid support) {
			this.support = support;
		}

		public void set(boolean raised) {
			if (raised) {
				this.support.set(SUPPORT_SOLENOID_RAISED);
			} else {
				this.support.set(SUPPORT_SOLENOID_LOWERED);
			}
		}

		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new SupportSet(this, false));
		}
	}
}