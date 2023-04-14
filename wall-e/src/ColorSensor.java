import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;
import lejos.hardware.Button;
//import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.Motor;
//import lejos.hardware.port.Port;

public class colorSensor {

	 public static final float BLACK_THRESHOLD = 0.1f;
	    public static EV3ColorSensor colorSensor;
	    
	    float[] colorSample = new float[colorSensor.getRedMode().sampleSize()];
        //colorSensor.getRedMode().fetchSample(colorSample, 0);
	
}

