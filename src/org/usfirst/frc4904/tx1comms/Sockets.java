package org.usfirst.frc4904.tx1comms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Sockets {
	
	public static int PORT_NUMBER = 5002;
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
			out = new PrintWriter(sock.getOutputStream(), true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message) {
		out.println(message);
		out.flush();
	}
}
