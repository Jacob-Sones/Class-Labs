/**
 * File: Device.java
 * Package: Lab1
 * Author: Jacob Sones
 * Date: April 16, 2026
 *
 * Abstract base class representing a generic smart home device.
 * Encapsulates shared attributes common to all smart devices, including
 * the device's name and its current power state (on/off). This class is
 * not meant to be instantiated directly — it serves as a superclass for
 * concrete device types such as SmartLight, SmartSpeaker, and SmartThermostat.
 *
 * Subclasses inherit the name and power state fields, along with their
 * associated getters and setters, and are responsible for implementing
 * device-specific behaviors defined by the SmartDevice interface.
 */
package SmartHomeAutomationSystem;

public abstract class Device {

    //declaring base class variables
    private String name;
    private boolean isOn;


    //default constructor
    public Device(){
        this.name = "Unknown";
        this.isOn = false;
    }

    /*Implementing a parameterized constructor to assign values passed in the parameter
    of the constructor and using setters to avoid accessing private member variables directly
     */
    public Device(String name, boolean isOn){
        setName(name);
        setOn(isOn);
    }

    //implementing setters and getters, including validation to make sure values set are not null or empty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            this.name = "Unknown";
        }else {
            this.name = name;
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        this.isOn = on;
    }

}
