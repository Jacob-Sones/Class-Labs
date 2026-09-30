/**
 * File: SmartLight.java
 * Package: Lab1
 * Author: Jacob Sones
 * Date: April 16, 2026
 *
 * Concrete class representing a smart light device in the Smart Home Automation System.
 * Extends the abstract Device class to inherit shared attributes such as name and power
 * state, and implements the SmartDevice interface to provide concrete behavior for
 * turning the light on and off, as well as reporting its current status. This class
 * also introduces a brightness level attribute unique to smart lights, with validation
 * to ensure the brightness stays within a valid range of 0 to 100.
 */
package SmartHomeAutomationSystem;

public class SmartLight extends Device implements SmartDevice {
    //declaring SmartLight class specific attributes
    private int brightnessLevel;

    //Implementation of the default constructor to assign default values to SmartLight objects if none are given on initialization
    public SmartLight() {
        super();
        this.brightnessLevel = 0;
    }//end of default constructor

    /*Implementing a parameterized constructor to assign values passed in the parameter of the constructor
    and using setters to avoid accessing private member variables directly, as well as super to access
    the base class, parameterized constructor.
     */
    public SmartLight(String name, boolean isOn, int brightnessLevel) {
        super(name, isOn);
        setBrightnessLevel(brightnessLevel);
    }//end of parameterized constructor

    //implementing setters and getters, including validation to make sure brightness is not negative or over 100
    public int getBrightnessLevel() {
        return brightnessLevel;
    }//end of getBrightnessLevel

    public void setBrightnessLevel(int brightnessLevel) {
      if(brightnessLevel < 0 ){
          throw new RuntimeException("Brightness cannot be negative please try again");
      }else if(brightnessLevel > 100){
          throw new RuntimeException("Brightness cannot exceed 100");
      }else {
          this.brightnessLevel = brightnessLevel;
      }
    }//end of setBrightnessLevel


    //logic for abstract SmartDevice methods for the SmartLight subclass
    /*Implementation of the overridden turnOn method to set SmartLight status to On
    and display an informational message to the user about the current on/off status of SmartLight
     */
    @Override
    public void turnOn() {
        System.out.println("Turning on light");
        setOn(true);
    }//end of turnOn method

    /*Implementation of the overridden turnOff method to set SmartLight status to Off and display an
    informational message to the user about the current on/off status of SmartLight
    */
    @Override
    public void turnOff() {
        System.out.println("Turning off light");
        setOn(false);
    }//end of turnOff method


    /* implementation of the overridden getStatus method to display info/current status of SmartLight,
     such as name on/off status, and current brightness level of SmartLight in a neat formatted output
     */
    @Override
    public void getStatus() {
        System.out.println("=============================");
        System.out.println("|***Status Of Smart Light***|");
        System.out.println("=============================");
        System.out.println("Smart Light name: " + getName());
        //using an if statement to check if Smart Light is on or off, i.e., true or false, then printing output depending on whether the condition is met or not
        if(isOn()){
           System.out.println("Smart Light is currently: on");
           //display Smart Lights brightness if smart light is on
           System.out.println("Smart Lights brightness is currently:" + getBrightnessLevel());
       }else{
           System.out.println("Smart Light is currently: off");
           //displaying smart light brightness as 0 if smart light is turned off
           System.out.println("Smart Lights brightness is currently: 0");
       }


    }//end of getStatus method

}
