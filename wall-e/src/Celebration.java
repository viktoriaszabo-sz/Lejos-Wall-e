import java.io.File;

import lejos.hardware.Sound;


public class Celebration {

	public Celebration() {}
	
	public static void disrespect() 
	{
		//should be working with the destruction song mentioned yesterday 
		//with "disrespect_your_sorroundings.wav" file
		//File disrespect = new File("disrespect_your_sorroundings.wav");
		//Sound.playSample(disrespect);
		Sound.playSample(new File ("dis.wav"), Sound.VOL_MAX);
	}
	
}
