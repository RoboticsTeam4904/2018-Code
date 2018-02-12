package org.usfirst.frc4904.tx1comms;

import java.util.HashMap;
import org.json.JSONObject;

public class TX1Comms implements Runnable{
	
	public static final boolean usingSockets = true;
	
	
	//The encoders don't exist yet, so we are pretending we can get the data
	public static String getEncoderData() {
		HashMap<String, Integer> encoders = new HashMap<String, Integer>();	
//		encoders.put("leftBack", ((Encoder) RobotMap.whatever).get());
//		encoders.put("leftFront", ((Encoder) RobotMap.whatever).get());
//		encoders.put("rightBack", ((Encoder) RobotMap.whatever).get());
//		encoders.put("rightFront", ((Encoder) RobotMap.whatever).get());
		encoders.put("leftBack", 5);
		encoders.put("leftFront", 4);
		encoders.put("rightBack", 3);
		encoders.put("rightFront", 2);

		String message = JSONObject.valueToString(encoders);
		//sendMessage(message);
		return message;
	}
	
	//The IMU doesn't exist yet, so we are pretending we can get the data
	public static String getIMUData() {
		//IMU imu =  new IMU(); //RobotMap.Component.IMU (but it doesn't exist yet)
		
		String message = JSONObject.valueToString(5);
		return message;
	}
	
	//only for testing purposes
	public static void main(String[] args) {
		System.out.println("starting");
		new TX1Comms().run();
	}

	@Override
	public void run() {
		Sockets s = new Sockets();
		System.out.println("socks initialized");
		USBSender usb = new USBSender();
		System.out.println("done initializing");
		while(true) {
			System.out.println("sending data");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
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
