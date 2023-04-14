/*import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
//import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
//import lejos.robotics.Color;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class ultrasonicSensor extends Thread {
    public EV3UltrasonicSensor sonicSensor;
    DataExchange DE;

    public ultrasonicSensor(DataExchange DE) { //(Port sensorPort)
        //sonicSensor = new EV3UltrasonicSensor(SensorPort.S4);
    }

    public void run() {
        SampleProvider sp = sonicSensor.getDistanceMode();
        float[] ultraSample = new float[sp.sampleSize()];

        while (!Button.ESCAPE.isDown()) {
            sp.fetchSample(ultraSample, 0);
            float distance = ultraSample[0];
            
            System.out.println("Distance: " + distance);
        }
        sonicSensor.close();
        Motor.A.close();
        Motor.B.close();
    }
} */