import lejos.hardware.sensor.EV3ColorSensor;

public class DataExchange extends Thread {

    private boolean obstacleDetected = false; 
    
    //writing out the variables from each class
    //color:
    
    
    
    
    public float[] ultraSample; //ultrasonic sensor sample
    

    
    
    
    
    
    
    private int CMD = 1; 

    public DataExchange() {

    }

    /* getters and setter */ 

     public void setObstacleDetected (boolean status) {
        obstacleDetected = status; 

    }
    public boolean getObstacleDetected () {
        return obstacleDetected;
    }
    public void setCMD (int command) {
        CMD = command; 
    }
    public int getCMD() {
        return CMD; 
    }

}