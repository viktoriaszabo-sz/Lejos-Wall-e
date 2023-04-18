import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class Destroy {

    public static final int SPEED = 300;
	public Destroy() {}
	
	public void run()
	{
		//System.out.println("DISRESPECT YOUR SURROUNDINGS!");
		Delay.msDelay(1000);
		Motor.A.setSpeed(SPEED);
		Motor.B.setSpeed(SPEED);
		Motor.A.forward();
        Motor.B.forward();
        Delay.msDelay(1000);
        
        for (int i = 1; i < 6; i++)
        {
        	Motor.A.backward();
        	Motor.B.backward();
        	Delay.msDelay(300);
        	Motor.A.forward();
        	Motor.B.forward();
        	Delay.msDelay(300);
        }
        Motor.A.stop();
        Motor.B.stop();
	}

	public void start() {
	   Thread t = new Thread();
	   t.start();
	}
}
