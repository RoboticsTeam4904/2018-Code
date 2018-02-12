package org.usfirst.frc4904.tx1comms;

import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.usb.UsbConst;
import javax.usb.UsbControlIrp;
import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbServices;

public class USBSender {
	static short VENDOR_ID = 1452;
	static short PRODUCT_ID = -32112;

    public void sendData(String message) {
    	
    	UsbDevice tx1;
    	try {
			tx1 = findTX1(UsbHostManager.getUsbServices().getRootUsbHub());

    	sendMessage(tx1, message.getBytes());
    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public static void sendMessage(UsbDevice device, byte[] message) throws UsbException {
        UsbControlIrp irp = device.createUsbControlIrp(
            (byte) (UsbConst.REQUESTTYPE_TYPE_CLASS |
            UsbConst.REQUESTTYPE_RECIPIENT_INTERFACE), (byte) 0x09,
            (short) 2, (short) 1);
        irp.setData(message);
        device.syncSubmit(irp);
    }
    
    public static UsbDevice findTX1(UsbHub hub) {
        UsbDevice launcher = null;

        for (UsbDevice device: (List<UsbDevice>) hub.getAttachedUsbDevices()) {
            if (device.isUsbHub()) {
                launcher = findTX1((UsbHub) device);
                if (launcher != null) {
                	return launcher;
                }
            }
            else {
                UsbDeviceDescriptor desc = device.getUsbDeviceDescriptor();
                if (desc.idVendor() == VENDOR_ID && desc.idProduct() == PRODUCT_ID) {
                	return device;
                }
            }
        }
        return null;
    }
}