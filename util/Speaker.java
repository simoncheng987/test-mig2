package util;

import java.io.IOException;

public class Speaker {
        /**
	 *  Use spd-say to achieve TTS. Takes a string that needs to be read out and an int that shows the speed.
	 */
	public static void speedySpeak(String sentence, int speed) throws InterruptedException, IOException {
		String _speed = String.valueOf(speed);
		String cmd = "spd-say -r" + _speed + " -p -20 --voice-type child_female -m some \"" + sentence + "\"";
		String[] cmdss = { "/bin/sh", "-c", cmd };
		Process process;
		try {
			process = Runtime.getRuntime().exec(cmdss);
			process.waitFor();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
        /**
	 *  Use spd-say to achieve TTS. Takes a string that needs to be read out and an int that shows the speed.
	 *  Return an int indicating the speed after speed up.
	 */
	public static int speedUp(String sentence, int speed) throws InterruptedException, IOException {
		String _speed = String.valueOf(speed + 10);
		String cmd = "spd-say -r" + _speed + " -p -20 --voice-type child_female -m some \"" + sentence + "\"";
		String[] cmdss = { "/bin/sh", "-c", cmd };
		Process process;
		try {
			process = Runtime.getRuntime().exec(cmdss);
			process.waitFor();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		return speed + 10;
	}
         /**
	 *  Use spd-say to achieve TTS. Takes a string that needs to be read out and an int that shows the speed.
	 *  Return an int indicating the speed after speed down.
	 */
	public static int slowDown(String sentence, int speed) throws InterruptedException, IOException {
		String _speed = String.valueOf(speed - 10);
		String cmd = "spd-say -r" + _speed + " -p -20 --voice-type child_female -m some \"" + sentence + "\"";
		String[] cmdss = { "/bin/sh", "-c", cmd };
		Process process;
		try {
			process = Runtime.getRuntime().exec(cmdss);
			process.waitFor();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		return speed - 10;
	}
}

