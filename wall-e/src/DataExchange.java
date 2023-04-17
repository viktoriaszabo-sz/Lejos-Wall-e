import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public class DataExchange 
{
    public static final int SPEED = 300;
    public static final float BLACK_THRESHOLD = 0.1f;

    //colorSensor
    public static EV3ColorSensor colorSensor;
    public static final float[] colorSample = new float[1];

    
    //obstacledetector
    public static int TURN_ANGLE = 180; // angle to turn when avoiding obstacle
    public static float distance = 0;
    
    //ultrasonic sensor 
    public EV3UltrasonicSensor sonicSensor;



    public DataExchange() {} //constructor

    public static void setColorSample(float[] sample)
    {
    	colorSample[0] = sample[0];
    }

    
    private int CMD = 1; //which command the robot should do -- 1=linefollowing 2=obstacle-avoidance
    
    public void setCMD(int command) {
		CMD = command;
	}
	
	public int getCMD() {
		return CMD;
	}
    
}