package org.usfirst.frc4904.fieldModel;

import java.awt.Point;
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
	
	//find the cube closest to us, but also on the way to our next destination
	public Cube getClosestCube(int targetX, int targetY) {
		return cubes.get(0); //TODO: make this real
	}
}
