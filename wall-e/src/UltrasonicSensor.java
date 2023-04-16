import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class UltrasonicSensor extends Thread {

	public static float distance;
	public static double securityDistance = 0.11;
	public EV3UltrasonicSensor sonicSensor;
	DataExchange DE = new DataExchange(); 

    public UltrasonicSensor(DataExchange DE) {
       sonicSensor = new EV3UltrasonicSensor(SensorPort.S4);
       this.DE = DE; 
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
        	distance = ultraSample[0];
        	
            //DataExchange.setDistance(distance); //we put the detected distance value into a dataexchange method

            System.out.println("Distance: " + distance);
            
            
            if(distance > securityDistance)
            {
				//sends message to dataExchange to do command 1 (a.k.a. no obstacle detected)
				DE.setCMD(1);
			}
            else 
			{ //if <= security distance
				
				DE.setCMD(0); //do obstacle avoidance 
				
			}
        }
        sonicSensor.close();
        Motor.A.close();
        Motor.B.close();
    }
} 