package org.usfirst.frc4904.autonly;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;

public class Field {
	public Piece ourSwitch;
	public Piece scale;
	public Piece theirSwitch;
	public Alliance team;
	
	/** The full constructor of the field.
	 * 
	 * @param team Our team as an Alliance Class.
	 * @param posConfig The three character position String provided over FMS.
	 */
	public Field(Alliance team, String posConfig) {
		ourSwitch = new Piece(team, posConfig.charAt(0));
		scale = new Piece(team, posConfig.charAt(1));
		theirSwitch = new Piece(team, posConfig.charAt(2));
		this.team = team;
	}
	/** A partial field constructor for when we don't know the orientation of the switches. Orientation should always be sent later.
	 * 
	 * @param team Our team as an Alliance Class.
	 */
	public Field(Alliance team) {
		ourSwitch = new Piece(Alliance.Invalid, Alliance.Invalid);
		scale = new Piece(Alliance.Invalid, Alliance.Invalid);
		theirSwitch = new Piece(Alliance.Invalid, Alliance.Invalid);
		this.team = team;
	}
	
	/** An empty constructor that should always be updated later with our alliance and the position data.
	 * 
	 */
	public Field(){
		this(Alliance.Invalid);
	}
	
	/** Updates the field object with our team and the switch orientation as a string.
	 * 
	 * @param team Our team as an Alliance Class.
	 * @param posConfig The three character position String provided over FMS.
	 */
	public void update(Alliance team, String posConfig){
		this.team = team;
		this.update(posConfig);
	}
	
	/** Updates the orientation of the switches from the String provided over FMS.
	 * 
	 * @param posConfig The three character position String provided over FMS.
	 */
	public void update(String posConfig){
		ourSwitch = new Piece(team, posConfig.charAt(0));
		scale = new Piece(team, posConfig.charAt(1));
		theirSwitch = new Piece(team, posConfig.charAt(2));
	}
		
	@Override
	public String toString() {
		return "Field{Team:'"+team.name()+"' OurSwitch:'" + ourSwitch.toString() + "' Scale:'" + scale.toString() + "' TheirSwitch:'"+theirSwitch.toString()+"'}";
	}

	/** The piece object, which is either a switch or the scale. Contains the alliances of both the left and right side of the piece from the position of our alliance.
	 * 
	 * @author bilpier
	 *
	 */
	public class Piece {
		public Alliance left;
		public Alliance right;

		/** Constructs the piece based on our team and the side of the position which is ours.
		 * 
		 * @param team Our team as an Alliance Class.
		 * @param reference The side of the switch which is ours, represented through the character of either 'L' or 'R'.
		 */
		public Piece(Alliance team, char reference) {
			if (reference == 'L') {
				left = team;
				right = Alliance.values()[1 - team.ordinal()];
				return;
			}
			right = team;
			left = Alliance.values()[1 - team.ordinal()];
		}
		
		/** Constructs the piece based on the actual left and right alliances.
		 * 
		 * @param left The alliance on the left side of this piece.
		 * @param right The alliance on the right side of this piece.
		 */
		public Piece(Alliance left, Alliance right) { 
			this.left = left;
			this.right = right;
		}
		
		@Override
		public String toString() {
			return "Piece{L:'" + left.name() + "' R:'"+ right.name() +"'}";
		}
		
		/** Tells us if the left side of the pieces is ours.
		 * 
		 * @return true if the left side is ours, false if it is not.
		 */
		public boolean isLeftOurs(){
			return (DriverStation.getInstance().getAlliance() == this.left) ? true : false;
		}
		
		/** Tells us if the right side of the pieces is ours.
		 * 
		 * @return true if the right side is ours, false if it is not.
		 */
		public boolean isRightOurs(){
			return (DriverStation.getInstance().getAlliance() == this.right) ? true : false;
		}
	}
}
