package org.usfirst.frc4904.robot;


public enum ShuffleboardKey {
	SUBSYSTEM_SUMMARY("Subsystem summary"), VISION_AUTOCALIBRATION("Autocalibration"), VISION_AUTOCALIBRATION_COMPLETE(
		"Autocalibration complete");
	public final String key;

	private ShuffleboardKey(String key) {
		this.key = key;
	}
}