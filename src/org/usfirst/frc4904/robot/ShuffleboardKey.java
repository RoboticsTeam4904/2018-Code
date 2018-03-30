package org.usfirst.frc4904.robot;

/** 
  * The Shuffleboard Key essentially just stores the strings that are used in the display.
  */
public enum ShuffleboardKey {
	SUBSYSTEM_SUMMARY("Subsystem summary");
	public final String key;

	private ShuffleboardKey(String key) {
		this.key = key;
	}
}