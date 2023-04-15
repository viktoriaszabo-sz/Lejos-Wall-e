public class Main{


	public static void main(String[] args) {

	  DataExchange DE = new DataExchange();
	
      LineFollower lineFollower = new LineFollower();
      ObstacleDetector detector1 = new ObstacleDetector();
      ColorSensor colorSensor = new ColorSensor(); 
      UltrasonicSensor ultraSonic = new UltrasonicSensor(); 
      
      colorSensor.start(); 
      ultraSonic.start();
      lineFollower.start();
      detector1.start();
    }
}