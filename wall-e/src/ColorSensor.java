import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;

public class ColorSensor extends Thread{
	
	
	//public static float[] colorSample;
	//public static final float BLACK_THRESHOLD = 0.1f;
    public static EV3ColorSensor colorSensor;
    DataExchange DE = new DataExchange(); 

	public ColorSensor () { //(Port colorPort)
        colorSensor = new EV3ColorSensor(SensorPort.S3);
        //this.DE = DE; 
    } 
	
	
	 public void run ()
	 {	
	    
		 while(!Button.ESCAPE.isDown()) 
	    
		 	{
			 float[] colorSample = new float[colorSensor.getRedMode().sampleSize()];
			 colorSensor.getRedMode().fetchSample(colorSample, 0);
			 DataExchange.setColorSample(colorSample);
		 	}
	    
		 colorSensor.close();
		 
	  }
}


