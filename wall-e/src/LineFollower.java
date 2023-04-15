import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.robotics.Color;


public class LineFollower extends Thread {
    public static final int SPEED = 300;
    public static final float BLACK_THRESHOLD = 0.1f;
    DataExchange DE = new DataExchange(); 

    public LineFollower() { 
    	//this.DE = DE; 
    } 

    public void run()
    {

        while(!Button.ESCAPE.isDown()) 
        {
            float[] colorSample = DataExchange.colorSample;
            
            if(colorSample [0] == Color.BLACK) {
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
        Motor.A.close();
        Motor.B.close();
    }
}