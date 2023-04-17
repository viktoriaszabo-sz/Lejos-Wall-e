public class Main{


	public static void main(String[] args) {

	  DataExchange DE = new DataExchange();
		
	  LineFollower lineFollower = new LineFollower(DE);
      ColorSensor colorSensor = new ColorSensor(DE); 
      UltrasonicSensor ultraSonic = new UltrasonicSensor(DE); 
      
      lineFollower.start();
      colorSensor.start(); 
      ultraSonic.start();
    }
}