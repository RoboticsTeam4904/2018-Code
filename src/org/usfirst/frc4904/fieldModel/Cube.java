package org.usfirst.frc4904.fieldModel;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.vision.AligningCamera;

public class Cube {

	//position of the cube
	double x;
	double y;
	//how likely it is that we actually saw a cube
	int confidence;
	//when we last saw the cube
	int frameSeen;
	
	public Cube(double x, double y, int confidence) {
		this.x = x;
		this.y = y;
		this.confidence = confidence;
		frameSeen = RobotMap.Component.cubeCamera.getFrameNumber();
	}
	
	public int getAge() {
		return RobotMap.Component.cubeCamera.getFrameNumber() - frameSeen;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public int getConfidence() {
		return confidence;
	}
}
