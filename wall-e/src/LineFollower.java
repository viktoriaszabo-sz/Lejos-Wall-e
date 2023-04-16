import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.robotics.Color;
import lejos.utility.Delay;


public class LineFollower extends Thread {
    public static final int SPEED = 300;
    public static final float BLACK_THRESHOLD = 0.1f;
    public static int TURN_ANGLE = 170;
    DataExchange DE; 
    
    /*private RegulatedMotor Motor.A = new EV3LargeRegulatedMotor(MotorPort.B);
	private RegulatedMotor Motor.B = new EV3LargeRegulatedMotor(MotorPort.A);*/

    public LineFollower(DataExchange DE) { 
    	this.DE = DE; 
    } 

    public void run()
    {

        while(!Button.ESCAPE.isDown()) 
        {
            float[] colorSample = DataExchange.colorSample;
            
            if (DE.getCMD() == 1) 
            {
				//LineFollower code if no obstacle is detected

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
                    	Motor.A.forward();
                    	Motor.B.forward();

                	} 
                	else if (colorSample[0] > BLACK_THRESHOLD){

                    	// Too far to the left, turn right
                    	Motor.A.setSpeed(SPEED);
                    	Motor.B.setSpeed(SPEED / 2);
                    	Motor.A.forward();
                    	Motor.B.forward();

                	}
            	}
            }
            else {
            	System.out.println("Obstacle detected!");
                Sound.twoBeeps();
                Motor.A.stop();
                Motor.B.stop();
                    Motor.A.rotate(-TURN_ANGLE);
                    Motor.A.forward();
                    Motor.B.forward();
                    Motor.A.rotate(TURN_ANGLE);
                    Motor.A.forward();
                    Motor.B.forward();
                    Delay.msDelay(3000);
                    Motor.A.rotate(-TURN_ANGLE/2);
            }
        }
        Motor.A.close();
        Motor.B.close();
    }
}