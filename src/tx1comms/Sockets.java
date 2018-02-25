package tx1comms;

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
	public static final String HOSTNAME = "127.0.0.1"; //"tegra-ubuntu.local";
	
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
	
	public String readData() {
		try {
			return in.readLine();
		} catch (IOException e) {
			e.printStackTrace(); 
			return null; 
		}
	}
}
