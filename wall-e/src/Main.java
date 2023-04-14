/*import lejos.hardware.motor.EV3LargeRegulatedMotor; 
import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.Brick; 
import lejos.hardware.BrickFinder; //connects to the body/brick 
import lejos.hardware.motor.Motor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.port.TachoMotorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;*/


//hello? comment made by yours truly KatieRJ

//Creating pull request from project by Roy



//another comment made by yours truly KatieRJ
public class Main{

    public static void main(String[] args) {
      // Port colorPort = LocalEV3.get().getPort("S3");

      //lineFollower.followLine();

      //public static DataExchange DE; 

      DataExchange DE = new DataExchange(); 

      LineFollower lineFollower = new LineFollower(DE);

      //Port sensorPort = LocalEV3.get().getPort("S4");
      //EV3UltrasonicSensor usSensor = new EV3UltrasonicSensor(SensorPort.S4);
        ObstacleDetector detector1 = new ObstacleDetector(DE);
      //ObstacleDetector detector1 = new ObstacleDetector(SensorPort.S4);
      //Thread detector2 = new Thread(detector1);



        lineFollower.start();
        detector1.start();
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