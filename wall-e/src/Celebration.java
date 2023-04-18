import java.io.File;
import lejos.hardware.Sound;


public class Celebration extends Thread{

	public Celebration() {}
	
	public void run() 
	{
		System.out.println("DISRESPECT YOUR		SURROUNDINGS!");
		Sound.playSample(new File ("dis.wav"), Sound.VOL_MAX);
	}
}
