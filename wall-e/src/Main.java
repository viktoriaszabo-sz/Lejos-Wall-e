public class Main{


	public static void main(String[] args) {

	  DataExchange DE = new DataExchange();
		
	  ColorSensor colorSensor = new ColorSensor(DE); 
      UltrasonicSensor ultraSonic = new UltrasonicSensor(DE); 
      LineFollower lineFollower = new LineFollower(DE);
      
      colorSensor.start(); 
      ultraSonic.start();
      lineFollower.start();
    }
}