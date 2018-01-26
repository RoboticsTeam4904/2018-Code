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
	
	public void sendEncoderData() {

		int leftBack = ((Encoder) null/*RobotMap.Component.encoder1*/).get();
		int leftFront = ((Encoder) null/*RobotMap.Component.encoder1*/).get();
		int rightBack = ((Encoder) null/*RobotMap.Component.encoder1*/).get();
		int rightFront = ((Encoder) null/*RobotMap.Component.encoder1*/).get();
		String message = JSONObject.valueToString(leftBack);
		sendMessage(message);
	}
	
	public void sendIMUData() {
		IMU imu = null; //RobotMap.Component.IMU (but it doesn't exist yet)
		
		String message = JSONObject.valueToString(imu);
		sendMessage(message);
	}
	
	public static void main(String[] args) {
		HashMap<String, Integer> foo = new HashMap<String, Integer>();	
		foo.put("encoder1", 5);
		foo.put("encoder2", 7);
		System.out.println(JSONObject.valueToString(foo));
	}
}
