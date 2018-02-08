package org.usfirst.frc4904.tx1comms;

import java.util.HashMap;
import org.json.JSONObject;

public class TX1Comms {
	
	public static final boolean usingSockets = false;
	
	public static String getEncoderData() {
		HashMap<String, Integer> encoders = new HashMap<String, Integer>();	
//		encoders.put("leftBack", ((Encoder) null).get());
//		encoders.put("leftFront", ((Encoder) null).get());
//		encoders.put("rightBack", ((Encoder) null).get());
//		encoders.put("rightFront", ((Encoder) null).get());
		encoders.put("leftBack", 5);
		encoders.put("leftFront", 4);
		encoders.put("rightBack", 3);
		encoders.put("rightFront", 2);

		String message = JSONObject.valueToString(encoders);
		//sendMessage(message);
		return message;
	}
	
	
	public static String getIMUData() {
		//IMU imu =  new IMU(); //RobotMap.Component.IMU (but it doesn't exist yet)
		
		String message = JSONObject.valueToString(5);
		return message;
	}
	
	public static void main(String[] args) {
		System.out.println("sending data");
		Sockets s = new Sockets();
		YewEsBee usb = new YewEsBee();
		while(true) {
			System.out.println("sending data");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {e.printStackTrace();}
			
			String message = "{ \"encoders:\" " + getEncoderData() + ", \"IMU\": " + getIMUData() + "}";
			if(usingSockets) {
				s.sendData(message);
			} else {
				usb.sendData(message);
			}
		}
	}
}
