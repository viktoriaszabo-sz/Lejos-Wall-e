import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public class DataExchange {

    //private boolean obstacleDetected = false; 
    //writing out the variables from each class
    //linefollower
    public static final int SPEED = 300;
    public static final float BLACK_THRESHOLD = 0.1f;
    
    //colorSensor
    public static EV3ColorSensor colorSensor;
    //public static final int[] colorSample = colorSensor.colorSample;
    //public static final float[] colorSample = new float[colorSensor.getRedMode().sampleSize()];
    public static final float[] colorSample = new float[1];
    
    //obstacledetector
    public static int TURN_ANGLE = 180; // angle to turn when avoiding obstacle
	
    //ultrasonic sensor 
    public EV3UltrasonicSensor sonicSensor;
    
  
    //private int CMD = 1; 

    public DataExchange() {} //constructor
    
    public static void setColorSample(float[] sample)
    {
    	colorSample[0] = sample[0];
    }
    
    
  //public static float distance = UltrasonicSensor.distance;
    public static float distance = 0;
    public static void setDistance(float d)
    {
    	distance = d; //we put the distance into this DE method
    }
    public static float getDistance()
    {
    	return distance; //We will use this DE method for distance in OB
    }

    
    
    
    
    /* getters and setter */ 

    /* public void setObstacleDetected (boolean status) {
        obstacleDetected = status; 

    }
    public boolean getObstacleDetected () {
        return obstacleDetected;
    }
    public void setCMD (int command) {
        CMD = command; 
    }
    public int getCMD() {
        return CMD; 
    }*/

}