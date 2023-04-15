import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class UltrasonicSensor extends Thread {

	public static float distance;
	//public static float distance;
	public EV3UltrasonicSensor sonicSensor;
	DataExchange DE = new DataExchange(); 

    public UltrasonicSensor() { //(Port sensorPort)
       sonicSensor = new EV3UltrasonicSensor(SensorPort.S4);
       //this.DE = DE; 
    }

    public void run() {

    	SampleProvider sp = sonicSensor.getDistanceMode();
        float[] ultraSample = new float[sp.sampleSize()];
        		//creating an array, but instead of putting a definite number as a size for that, 
        		//we put the sampleSize as a measurement for the size

        while (!Button.ESCAPE.isDown()) 
        {
        	sp.fetchSample(ultraSample, 0);
        				//ultrasample is the array itself, 0 is just the position of the first element
        	float distance = ultraSample[0];

            DataExchange.setDistance(distance); //we out the detected distance value into a dataexchange method

            System.out.println("Distance: " + distance);
        }

        sonicSensor.close();
        Motor.A.close();
        Motor.B.close();
    }
} 