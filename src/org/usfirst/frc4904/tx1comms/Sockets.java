package org.usfirst.frc4904.tx1comms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.json.*;
import org.usfirst.frc4904.standard.custom.sensors.IMU;
import edu.wpi.first.wpilibj.Encoder;


public class Sockets {
	
	public static int PORT_NUMBER = 5002;
	public static final String HOSTNAME = "127.0.0.1";   
	
	public ServerSocket listener;
	BufferedReader in;
	OutputStreamWriter out;
	
	public Sockets() {
		try {
			listener = new ServerSocket(PORT_NUMBER, 100, InetAddress.getByName(HOSTNAME));
			Socket sock = listener.accept();
			in = new BufferedReader(new InputStreamReader(
				sock.getInputStream()));
			out = new OutputStreamWriter(sock.getOutputStream(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message) {
		try {
			out.write(message);
			out.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendData() {
		sendMessage("{" + getEncoderData() + ", " + getIMUData() + "}");
	}
	
	public String getEncoderData() {
		HashMap<String, Integer> encoders = new HashMap<String, Integer>();	
		encoders.put("leftBack", ((Encoder) null).get());
		encoders.put("leftFront", ((Encoder) null).get());
		encoders.put("rightBack", ((Encoder) null).get());
		encoders.put("rightFront", ((Encoder) null).get());

		String message = JSONObject.valueToString(encoders);
		//sendMessage(message);
		return message;
	}
	
	public String getIMUData() {
		IMU imu = null; //RobotMap.Component.IMU (but it doesn't exist yet)
		
		String message = JSONObject.valueToString(imu);
		return message;
	}
}
