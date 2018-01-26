package org.usfirst.frc4904.tx1comms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TestClient {
	
	private static BufferedReader input;
	private static PrintWriter output;

	
	public static void main(String[] args) {
		Socket s = connect();
		System.out.println("=== Connection Established! ===");

		/* Extract the input and output streams from the socket. */
		try {
			input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			output = new PrintWriter(s.getOutputStream());
		} catch (IOException e) {
			System.out.println("AAaaAAAAaaaaaAAAAA");
		}
		String currentline;
		try {
			/* Continuously read messages from the source. */
			while (true) {
				currentline = input.readLine();
				if (currentline == null) break;

				System.out.println("Client got " + currentline);
				
				
			}
		} catch (IOException e) {
			System.out.println("AAAAAaaaAAaaAaaa");
		}
		System.out.println("=== Connection Closed ===");
	}
	
	private static Socket connect() {
		while (true) {
			try {
				Socket s = new Socket(InetAddress.getByName(Sockets.HOSTNAME), Sockets.PORT_NUMBER);
				System.out.println("Socket achieved");
				return s;
			} catch (IOException e) {
				System.out.println("no connection");
				//fatalError("Error connecting to the server, try again later.");
			}
		}  
	}

}
