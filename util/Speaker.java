package util;

import java.io.IOException;

public class Speaker {
  public static void speedySpeak(String sentence,int speed) throws InterruptedException, IOException{
	  String _speed = String.valueOf(speed);
	  System.out.println(_speed);
	  String cmd = "spd-say -r"+_speed+" -p -20 --voice-type child_female -m some \""+sentence+"\"";
	  String[] cmdss = {"/bin/sh","-c",cmd};
	  Process process;
	  try {
		  process=Runtime.getRuntime().exec(cmdss);
		  process.waitFor();
	  }catch(InterruptedException e) {
		  System.out.println(e.getMessage());
	  }
  }
  
  public static int speedUp(String sentence,int speed) throws InterruptedException, IOException{
	  String _speed = String.valueOf(speed+10);
	  System.out.println(_speed);
	  String cmd = "spd-say -r"+_speed+" -p -20 --voice-type child_female -m some \""+sentence+"\"";
	  String[] cmdss = {"/bin/sh","-c",cmd};
	  Process process;
	  try {
		  process=Runtime.getRuntime().exec(cmdss);
		  process.waitFor();
	  }catch(InterruptedException e) {
		  System.out.println(e.getMessage());
	  }
	return speed+10;
  }
  
  public static int slowDown(String sentence, int speed) throws InterruptedException, IOException{
	  String _speed = String.valueOf(speed-10);
	  System.out.println(_speed);
	  String cmd = "spd-say -r"+_speed+" -p -20 --voice-type child_female -m some \""+sentence+"\"";
	  String[] cmdss = {"/bin/sh","-c",cmd};
	  Process process;
	  try {
		  process=Runtime.getRuntime().exec(cmdss);
		  process.waitFor();
	  }catch(InterruptedException e) {
		  System.out.println(e.getMessage());
	  }
	return speed-10;
  }
}
