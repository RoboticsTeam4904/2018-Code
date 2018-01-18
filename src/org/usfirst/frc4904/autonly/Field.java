package org.usfirst.frc4904.autonly;


import edu.wpi.first.wpilibj.DriverStation.Alliance;

public class Field {
	public Piece ourSwitch;
	public Piece scale;
	public Piece theirSwitch;
	public Alliance ourTeam;

	public Field(Alliance team, String posConfig) {
		ourSwitch = new Piece(team, posConfig.charAt(0));
		scale = new Piece(team, posConfig.charAt(1));
		theirSwitch = new Piece(team, posConfig.charAt(2));
		ourTeam = team;
	}

	public class Piece {
		public Alliance left;
		public Alliance right;

		public Piece(Alliance team, char reference) {
			if (reference == 'L') {
				left = team;
				right = Alliance.values()[1 - team.ordinal()];
				return;
			}
			right = team;
			left = Alliance.values()[1 - team.ordinal()];
		}
	}
}
