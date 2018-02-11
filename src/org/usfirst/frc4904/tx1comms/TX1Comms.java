package org.usfirst.frc4904.tx1comms;

import java.util.HashMap;
import org.json.JSONObject;

public class TX1Comms {
	
	public static final boolean usingSockets = true;
	
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
		System.out.println("start");
		send();
	}
	
	public static void send() {
		
		Sockets s = new Sockets();
		System.out.println("socks initialized");
		YewEsBee usb = new YewEsBee();
		System.out.println("done initializing");
		while(true) {
			System.out.println("sending data");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				System.out.println("REEEE");
				e.printStackTrace();
				}
			
			String message = "{ \"encoders:\" " + getEncoderData() + ", \"IMU\": " + getIMUData() + "}" + " " + System.currentTimeMillis();
			if(usingSockets) {
				s.sendData(message);
			} else {
				usb.sendData(message);
			}
		}

	}
}
