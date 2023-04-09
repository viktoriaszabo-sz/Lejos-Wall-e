import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
//import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
//import lejos.robotics.Color;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class ObstacleDetector extends Thread {
    public EV3UltrasonicSensor sonicSensor;
    public static int SPEED = 250;
    public static int TURN_ANGLE = 180; // angle to turn when avoiding obstacle
    DataExchange DE;

    public ObstacleDetector(DataExchange DE) { //(Port sensorPort)
        sonicSensor = new EV3UltrasonicSensor(SensorPort.S4);
    }

    public void run() {
        SampleProvider sp = sonicSensor.getDistanceMode();
        float[] ultraSample = new float[sp.sampleSize()];

        while (!Button.ESCAPE.isDown()) {
            sp.fetchSample(ultraSample, 0);
            float distance = ultraSample[0];
            
            System.out.println("Distance: " + distance);
            
            if (distance < 0.11) {
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
        sonicSensor.close();
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