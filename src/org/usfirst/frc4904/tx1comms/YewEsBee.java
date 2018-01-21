package org.usfirst.frc4904.tx1comms;


import java.util.List;
import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbHub;

public class YewEsBee {
	public YewEsBee() {}

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
