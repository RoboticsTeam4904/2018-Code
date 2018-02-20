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
		this.minScale = minScale;
		this.maxDist = maxDist;
		this.curvature = curvature;
	}

	public ArmSpeedActivation(Arm.ArmState target, Controller controller, int axis, double minScale, double maxDist) {
		this(target, controller, axis, minScale, maxDist, DEFAULT_CURVATURE);
	}

	@Override
	protected void execute() {
		LogKitten.d("ArmControlActivation executing: " + controller.getAxis(axis));
		double dist = Math.abs(RobotMap.Component.arm.encoder.getDistance() - target.position);
		if (dist > maxDist) {
			motor.set(controller.getAxis(axis) * scale);
		} else {
			motor.set(controller.getAxis(axis) * scale * calcActivation(dist));
		}
	}

	protected double calcActivation(double dist) {
		return minScale + (1-minScale) * Math.log(1+dist*curvature) / Math.log(1+maxDist*curvature);
	}
}
