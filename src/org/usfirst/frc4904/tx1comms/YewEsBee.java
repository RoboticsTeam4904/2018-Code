package org.usfirst.frc4904.tx1comms;


import java.util.List;
import javax.usb.UsbClaimException;
import javax.usb.UsbConfiguration;
import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbDisconnectedException;
import javax.usb.UsbEndpoint;
import javax.usb.UsbException;
import javax.usb.UsbHub;
import javax.usb.UsbInterface;
import javax.usb.UsbNotActiveException;
import javax.usb.UsbPipe;
import javax.usb.UsbHub;

public class YewEsBee {
	public YewEsBee() {

		short a = 0;
		short b = 0;
		UsbDevice device = findDevice(null, a, b);
		
		UsbConfiguration configuration = device.getActiveUsbConfiguration();
		UsbInterface iface = configuration.getUsbInterface((byte) 1);
		try {
			iface.claim();
		
		UsbEndpoint endpoint = iface.getUsbEndpoint((byte) 0x03);
		UsbPipe pipe = endpoint.getUsbPipe();
		pipe.open();
		try
		{
		    int sent = pipe.syncSubmit(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 });
		    System.out.println(sent + " bytes sent");
		}
		finally
		{
		    pipe.close();
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	public UsbDevice findDevice(UsbHub hub, short vendorId, short productId) {
		List<UsbDevice> foo = hub.getAttachedUsbDevices();
		for (int i = 0; i < foo.size(); i++) {
			UsbDevice device = foo.get(i);
			UsbDeviceDescriptor desc = device.getUsbDeviceDescriptor();
			if (desc.idVendor() == vendorId && desc.idProduct() == productId) return device;
			if (device.isUsbHub()) {
				device = findDevice((UsbHub) device, vendorId, productId);
				if (device != null) return device;
			}
		}
		return null;
	}
}
