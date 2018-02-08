package org.usfirst.frc4904.tx1comms;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import dk.thibaut.serial.SerialChannel;
import dk.thibaut.serial.SerialPort;
import dk.thibaut.serial.enums.*;

public class NotherTest {
	
	public void sendData(String message) {

		// Get a list of available ports names (COM2, COM4, ...)
		List<String> portsNames = SerialPort.getAvailablePortsNames();

		try {
		// Get a new instance of SerialPort by opening a port.
		SerialPort port = SerialPort.open("COM2");

		// Configure the connection

			port.setTimeout(100);

			port.setConfig(BaudRate.B115200, Parity.NONE, StopBits.ONE, DataBits.D8);
	
			// You have the choice, you can either use the Java NIO channels
			// or classic Input/Ouput streams to read and write data.
			SerialChannel channel = port.getChannel();
			InputStream istream = port.getInputStream();
	
			// Read some data using a stream
			byte[] byteBuffer = new byte[4096];
			// Will timeout after 100ms, returning 0 if no bytes were available.
			int n = istream.read(byteBuffer);
	
			// Read some data using a ByteBuffer.
			ByteBuffer buffer = ByteBuffer.allocate(4096);
			int c = channel.read(buffer);
	
			port.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
