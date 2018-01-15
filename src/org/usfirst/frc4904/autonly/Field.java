package org.usfirst.frc4904.autonly;


import edu.wpi.first.wpilibj.DriverStation.Alliance;

public class Field {
	public Piece ourSwitch;
	public Piece scale;
	public Piece theirSwitch;
	public Alliance team;

	public Field(Alliance team, String posConfig) {
		ourSwitch = new Piece(team, posConfig.charAt(0));
		scale = new Piece(team, posConfig.charAt(1));
		theirSwitch = new Piece(team, posConfig.charAt(2));
		this.team = team;
	}
	
	public Field(Alliance team) {
		ourSwitch = new Piece(Alliance.Invalid, Alliance.Invalid);
		scale = new Piece(Alliance.Invalid, Alliance.Invalid);
		theirSwitch = new Piece(Alliance.Invalid, Alliance.Invalid);
		this.team = team;
	}
	
	public Field(){
		this(Alliance.Invalid);
	}
	
	public void update(Alliance team, String posConfig){
		this.team = team;
		this.update(posConfig);
	}
	
	public void update(String posConfig){
		ourSwitch = new Piece(team, posConfig.charAt(0));
		scale = new Piece(team, posConfig.charAt(1));
		theirSwitch = new Piece(team, posConfig.charAt(2));
	}
		
	@Override
	public String toString() {
		return "Field{Team:'"+team.name()+"' OurSwitch:'" + ourSwitch.toString() + "' Scale:'" + scale.toString() + "' TheirSwitch:'"+theirSwitch.toString()+"'}";
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
		
		public Piece(Alliance left, Alliance right) { 
			this.left = left;
			this.right = right;
		}
		
		@Override
		public String toString() {
			return "Piece{L:'" + left.name() + "' R:'"+ right.name() +"'}";
		}
	}
}
