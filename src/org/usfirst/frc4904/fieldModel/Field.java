package org.usfirst.frc4904.fieldModel;

import java.util.ArrayList;

public class Field {

	ArrayList<Cube> cubes;
	ArrayList<Robot> robots;
	
	public Field() {
		cubes = new ArrayList<Cube>();
		robots = new ArrayList<Robot>();
	}
	
	public void addCube(double x, double y, int confidence) {
		cubes.add(new Cube(x, y, confidence));
	}
	
	public void addRobot(int x, int y) {
		robots.add(new Robot());
	}
}
