package org.usfirst.frc4904.robot.vision;

import org.usfirst.frc4904.standard.custom.sensors.InvalidSensorException;
import org.usfirst.frc4904.standard.custom.sensors.PIDSensor;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.PIDSourceType;

public class AligningCamera implements PIDSensor {
	public static final double[] DEFAULT_RESPONSE = {};
	public static final String TABLE_NAME = "Vision";
	public static final String FIELD_DEGREES = "degrees";
	public static final String FIELD_DISTANCE = "distance";
	public static final String FIELD_FRAME = "frameNumber";
	protected NetworkTable cameraTable;
	private PIDSourceType sourceType;
	
	public AligningCamera(PIDSourceType sourceType, String cameraTableName) {
		this.sourceType = sourceType;
		cameraTable = NetworkTableInstance.getDefault().getTable(cameraTableName);
	}
	
	public AligningCamera(PIDSourceType sourceType) {
		this(sourceType, AligningCamera.TABLE_NAME);
	}

	public AligningCamera() {
		this(PIDSourceType.kDisplacement, AligningCamera.TABLE_NAME);
	}

	
	
	public double[] getDegrees() {
		return cameraTable.getEntry(FIELD_DEGREES).getDoubleArray(DEFAULT_RESPONSE);
	}

	public double[] getDistance() {
		return cameraTable.getEntry(FIELD_DISTANCE).getDoubleArray(DEFAULT_RESPONSE);
	}
	
	public int getFrameNumber() {
		return cameraTable.getEntry(FIELD_FRAME).getNumber(0).intValue();
	}
	
	@Override
	public PIDSourceType getPIDSourceType() {
		return sourceType;
	}

	@Override
	public double pidGet() {
		try {
			return pidGetSafely();
		} catch (InvalidSensorException e) {
			// This will never happen (famous last words)
			return Double.NaN;
		}
	}

	@Override
	public void setPIDSourceType(PIDSourceType sourceType) {
		this.sourceType = sourceType;
	}

	@Override
	public double pidGetSafely() throws InvalidSensorException {
		return getDegrees()[0];
	}
	
}
