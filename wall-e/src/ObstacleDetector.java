import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class ObstacleDetector extends Thread {
    //public EV3UltrasonicSensor sonicSensor;
    public static int TURN_ANGLE = 180; // angle to turn when avoiding obstacle
    DataExchange DE = new DataExchange(); 

    public ObstacleDetector() { //(Port sensorPort)
    	//public ObstacleDetector(DataExchange DE)
       // sonicSensor = new EV3UltrasonicSensor(SensorPort.S4);
    	//this.DE = DE; 
    }

    public void run() {
        /*SampleProvider sp = sonicSensor.getDistanceMode();
        float[] sample = new float[sp.sampleSize()];*/

        while (!Button.ESCAPE.isDown()) {
           /* sp.fetchSample(sample, 0);
            float distance = sample[0];
            System.out.println("Distance: " + distance);*/

                //float distance = DataExchange.distance;
                
				if (DataExchange.getDistance()  < 0.11) //here we use the dataexchange distance value
				{
                    System.out.println("Obstacle detected!");
                    Sound.twoBeeps();
                    Motor.A.stop();
                    Motor.B.stop();
                    
                    //Motor.A.rotate(-TURN_ANGLE);
                    //Motor.B.rotate(TURN_ANGLE);
                    //Motor.A.rotate(-170);
                    //Motor.B.rotate(170, immediateReturn);
                        Motor.A.rotate(-TURN_ANGLE);
                        Motor.A.forward();
                        Motor.B.forward();
                       // Sound.beep();                        //DONT TOUCH THIS SECTION THANK YOU 
                        Motor.A.rotate(TURN_ANGLE);
                        Motor.A.forward();
                        Motor.B.forward();
                        Delay.msDelay(3000);
                        Motor.A.rotate(-TURN_ANGLE/2);
                    }

            else {
                Motor.A.forward();
                Motor.B.forward();
            }
        }

        Motor.A.close();
        Motor.B.close();
    }

    /*
    public void start() {
        Thread t = new Thread(this);
        t.start();
    }
      */
}