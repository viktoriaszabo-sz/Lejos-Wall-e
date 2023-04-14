public class Main{

	//private static final DataExchange DE = null;

	//private static DataExchange DE;

	public static void main(String[] args) {
      // Port colorPort = LocalEV3.get().getPort("S3");
      //lineFollower.followLine();
      //public static DataExchange DE; 

	  DataExchange DE = new DataExchange();
	
      LineFollower lineFollower = new LineFollower();
      ObstacleDetector detector1 = new ObstacleDetector();
      ColorSensor colorSensor = new ColorSensor(); 
      UltrasonicSensor ultraSonic = new UltrasonicSensor(); 
      
      colorSensor.start(); 
      ultraSonic.start();
      lineFollower.start();
      detector1.start();

      //Port sensorPort = LocalEV3.get().getPort("S4");
      //EV3UltrasonicSensor usSensor = new EV3UltrasonicSensor(SensorPort.S4);
      //ObstacleDetector detector1 = new ObstacleDetector(SensorPort.S4);
      //Thread detector2 = new Thread(detector1);
    }
    //private static DataExchange DE; 
     //private static LineFollower LFObjt; 
    //private static ObstacleDetector ODObj; 
/*
    private static boolean waitForAnyPress() {
        // TODO Auto-generated method stub
        return false;
    }
*/
}