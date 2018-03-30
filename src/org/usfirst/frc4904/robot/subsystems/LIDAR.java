package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.custom.sensors.InvalidSensorException;
import org.usfirst.frc4904.standard.custom.sensors.PIDSensor;
import edu.wpi.first.wpilibj.PIDSourceType;

public class LIDAR implements PIDSensor {
	private PIDSourceType pidSource;
	public double offset;
	private double last_reading;

	public LIDAR(double offset) {
		this.offset = offset;
		this.last_reading = 0.0;
		setPIDSourceType(PIDSourceType.kDisplacement);
	}

	public LIDAR() {
		this(-45.0);
	}

	/**
	 * Sets PID mode
	 * PIDSourceType is either PIDSourceType.kDisplacement
	 * or PIDSourceType.kRate.
	 */
	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		this.pidSource = pidSource;
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return pidSource;
	}

	public double getDistance() {
		double dist = RobotMap.NetworkTables.Localization.distObstFrontEntry.getDouble(0.0);
		if (dist == 0.0) {
			return last_reading;
		} else {
			last_reading = dist + offset;
			return dist + offset;
		}
	}

	@Override
	public double pidGetSafely() throws InvalidSensorException {
		return getDistance();
	}

	@Override
	public double pidGet() {
		try {
			return pidGetSafely();
		}
		catch (Exception e) {
			LogKitten.ex(e);
			return 0;
		}
	}
}
