package org.usfirst.frc4904.tx1comms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import org.json.JSONObject;

public class Sockets {
	
	public static int PORT_NUMBER = 5202;
	public static final String HOSTNAME = "127.0.0.1";   
	
	public ServerSocket listener;
	BufferedReader in;
	PrintWriter out;
	
	public Sockets() {
		try {
			listener = new ServerSocket(PORT_NUMBER, 100, InetAddress.getByName(HOSTNAME));
			Socket sock = listener.accept();
			in = new BufferedReader(new InputStreamReader(
				sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message) {
		out.println(message);
		out.flush();
	}
	
	public void sendData(String message) {
		sendMessage(message);
	}
	
	public String getEncoderData() {
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
	
	
	public String getIMUData() {
		//IMU imu =  new IMU(); //RobotMap.Component.IMU (but it doesn't exist yet)
		
		String message = JSONObject.valueToString(5);
		return message;
	}
}
