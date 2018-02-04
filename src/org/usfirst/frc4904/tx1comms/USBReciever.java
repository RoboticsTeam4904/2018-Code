package org.usfirst.frc4904.tx1comms;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.usb4java.BufferUtils;
import org.usb4java.DeviceHandle;
import org.usb4java.LibUsb;
import org.usb4java.LibUsbException;

public class USBReciever {
	
    private static final int TIMEOUT = 5000;
    
    private static final byte IN_ENDPOINT = (byte) 0x83;
	
	static short VENDOR_ID = 1452;
	static short PRODUCT_ID = -32112;
	
	static int messageSize = 100;
	
    private static final byte INTERFACE = 1;
    
	public static void main(String[] args) {
		
		DeviceHandle handle = LibUsb.openDeviceWithVidPid(null, VENDOR_ID,
            PRODUCT_ID);
		
		int result = LibUsb.claimInterface(handle, INTERFACE);
		
		while(true) {
			
			ByteBuffer buffer = read(handle, messageSize);
			if(buffer != null) {
				System.out.println("yay!");
			}
		}
	}
	
    public static ByteBuffer read(DeviceHandle handle, int size)
    {
        ByteBuffer buffer = BufferUtils.allocateByteBuffer(size).order(
            ByteOrder.LITTLE_ENDIAN);
        IntBuffer transferred = BufferUtils.allocateIntBuffer();
        int result = LibUsb.bulkTransfer(handle, IN_ENDPOINT, buffer,
            transferred, TIMEOUT);
        if (result != LibUsb.SUCCESS)
        {
            throw new LibUsbException("Unable to read data", result);
        }
        System.out.println(transferred.get() + " bytes read from device");
        return buffer;
    }
}
