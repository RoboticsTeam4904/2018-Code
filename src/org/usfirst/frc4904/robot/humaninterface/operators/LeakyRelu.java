package org.usfirst.frc4904.robot.humaninterface.operators;

import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.SpeedModifier;

public class LeakyRelu implements SpeedModifier {
	final double lowerModifier;
	final double raiseModifier;

	public LeakyRelu(double lowerModifier, double raiseModifier) {
		this.lowerModifier = lowerModifier;
		this.raiseModifier = raiseModifier;
	}

	@Override
	public double modify(double speed) {
		if (speed < 0) {
			return speed * lowerModifier;
		}
		return speed * raiseModifier;
	}
}
