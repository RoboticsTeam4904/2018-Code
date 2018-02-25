package tx1comms;

import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.usfirst.frc4904.standard.LogKitten;

public class TX1Comms implements Runnable{
	
	int[] lidarData = new int[360];
	
	//The encoders don't exist yet, so we are pretending we can get the data
	public static String getEncoderData() {
		HashMap<String, Integer> encoders = new HashMap<String, Integer>();	
//		encoders.put("leftBack", ((Encoder) RobotMap.whatever).get());
//		encoders.put("leftFront", ((Encoder) RobotMap.whatever).get());
//		encoders.put("rightBack", ((Encoder) RobotMap.whatever).get());
//		encoders.put("rightFront", ((Encoder) RobotMap.whatever).get());
		encoders.put("leftBack", 5);
		encoders.put("leftFront", 4);
		encoders.put("rightBack", 3);
		encoders.put("rightFront", 2);

		String message = JSONObject.valueToString(encoders);
		//sendMessage(message);
		return message;
	}
	
	//The IMU doesn't exist yet, so we are pretending we can get the data
	public static String getIMUData() {
		//IMU imu =  new IMU(); //RobotMap.Component.IMU (but it doesn't exist yet)
		
		String message = JSONObject.valueToString(5);
		return message;
	}
	
	//only for testing purposes
	public static void main(String[] args) {
		System.out.println("starting");
		new TX1Comms().run();
	}

	@Override
	public void run() {
		Sockets s = new Sockets();
		System.out.println("connection established");
		while(true) {
			System.out.println("sending data");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String message = "{ \"encoders:\" " + getEncoderData() + ", \"IMU\": " + getIMUData() + "}" + " " + System.currentTimeMillis();
			s.sendData(message);
			
			processLidar(s);

		}

	}
	
	public void processLidar(Sockets sockets) {
		String line = sockets.readData();
		if(line != null) {
			JSONTokener t = new JSONTokener(line);
			JSONObject jsonData = new JSONObject(t);
			//for each degree in a circle, get the distance that the lidar detects
			for(int i = 0; i < 360; i++) {
				lidarData[i] = jsonData.getInt(Integer.toString(i));
			}
			
		}
	}
}