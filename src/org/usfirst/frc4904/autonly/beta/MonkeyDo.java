package org.usfirst.frc4904.autonly.beta;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import org.usfirst.frc4904.standard.LogKitten;
import edu.wpi.first.wpilibj.command.Command;

public class MonkeyDo extends Command {
	// private static String RECORD_FILE_PATH = "/home/lvuser/logs/monkey_see.csv";
	private File recordFile;
	private Timer timer;
	private DoTask task;

	public MonkeyDo() {
		recordFile = new File(MonkeySee.RECORD_FILE_PATH);
		timer = new Timer();
		task = new DoTask(recordFile);
	}

	@Override
	protected void initialize() {}

	@Override
	protected boolean isFinished() {
		return task.done;
	}

	class DoTask extends TimerTask {
		BufferedReader br;
		boolean done = false;

		public DoTask(File file) {
			try {
				br = new BufferedReader(new FileReader(file));
			}
			catch (FileNotFoundException e) {
				LogKitten.e(e);
			}
		}

		@Override
		public void run() {
			String nextLine;
			try {
				nextLine = br.readLine();
			}
			catch (IOException e) {
				LogKitten.e(e);
				return;
			}
			if (nextLine == null) {
				done = true;
				this.cancel();
				return;
			}
			double[] motorSpeeds = Arrays.stream(nextLine.split(",")).mapToDouble(Double::parseDouble).toArray();
			for (int i = 0; i < motorSpeeds.length; i++) {
				double speed = motorSpeeds[i];
				MonkeySee.MOTOR_LIST[i].set(speed);
			}
		}
	}
}
