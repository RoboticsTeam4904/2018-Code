package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Arm;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.motor.MotorControl;
import org.usfirst.frc4904.standard.custom.controllers.Controller;

public class ArmSpeedActivation extends MotorControl {
	protected Arm.ArmState target;
	protected final double minScale;
	protected final double maxDist;
	protected final double curvature;
	protected static double DEFAULT_CURVATURE = 3;

	public ArmSpeedActivation(Arm.ArmState target, Controller controller, int axis, double minScale, double maxDist, double curvature) {
		super(RobotMap.Component.arm, controller, axis, Arm.ARM_SPEED_SCALE);
		this.target = target;
		if (minScale <= 0 || minScale > 1) {
			throw new IllegalArgumentException("minScale must be between 0 and 1.  Given:" + minScale);
		}
		this.minScale = minScale;
		this.maxDist = maxDist;
		if (curvature <= 0) {
			throw new IllegalArgumentException("curvature must be greater than 0.  Given:" + curvature);
		}
		this.curvature = curvature;
	}

	public ArmSpeedActivation(Arm.ArmState target, Controller controller, int axis, double minScale, double maxDist) {
		this(target, controller, axis, minScale, maxDist, DEFAULT_CURVATURE);
	}

	@Override
	protected void execute() {
		LogKitten.d("ArmControlActivation executing: " + controller.getAxis(axis));
		double dist = target.position - RobotMap.Component.arm.encoder.getDistance();
		if (dist > maxDist) {
			motor.set(controller.getAxis(axis) * scale);
		} else {
			motor.set(controller.getAxis(axis) * scale * calcActivation(dist));
		}
	}

	protected double calcActivation(double dist) {
		if (dist > 0) {
			return minScale + (1-minScale) * Math.log(1+dist*curvature) / Math.log(1+maxDist*curvature);
		} else {
			return minScale * Math.exp(dist * curvature * (1-minScale) / (minScale*Math.log(1+maxDist*curvature)));
		}
	}
}
