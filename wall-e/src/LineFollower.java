import lejos.hardware.Button;
//import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.Motor;
//import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;


public class LineFollower extends Thread {
    public static final int SPEED = 300;
    public static final float BLACK_THRESHOLD = 0.1f;
    public static EV3ColorSensor colorSensor;
    DataExchange DE;

    public LineFollower(DataExchange DE) { //(Port colorPort)
        colorSensor = new EV3ColorSensor(SensorPort.S3);

    } 

    public void run(){

        while(!Button.ESCAPE.isDown()) {
            float[] colorSample = new float[colorSensor.getRedMode().sampleSize()];
            colorSensor.getRedMode().fetchSample(colorSample, 0);
            if(colorSample[0] == Color.BLACK) {
                // On the line, move straight
                Motor.A.setSpeed(SPEED);
                Motor.B.setSpeed(SPEED);
            } 
            else {
                // Off the line, adjust direction
                if(colorSample[0] < BLACK_THRESHOLD) {
                    // Too far to the right, turn left
                    Motor.A.setSpeed(SPEED / 2);
                    Motor.B.setSpeed(SPEED);

                } 
                else if (colorSample[0] > BLACK_THRESHOLD){

                    // Too far to the left, turn right
                    Motor.A.setSpeed(SPEED);
                    Motor.B.setSpeed(SPEED / 2);

                }
            }
        }

        colorSensor.close();
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