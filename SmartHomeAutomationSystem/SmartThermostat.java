/**
 * File: SmartThermostat.java
 * Package: Lab1
 * Author: Jacob Sones
 * Date: April 16, 2026
 *
 * Concrete class representing a smart thermostat device in the Smart Home Automation System.
 * Extends the abstract Device class to inherit shared attributes such as name and power
 * state, and implements the SmartDevice interface to provide concrete behavior for
 * turning the thermostat on and off, as well as reporting its current status. This class
 * introduces a houseTemp attribute unique to the thermostat, with validation to ensure
 * the temperature stays within a safe and reasonable range of 40 to 90 degrees. When
 * turned on, the thermostat actively regulates the house temperature to the set value,
 * and when turned off it stops regulating entirely.
 */
package SmartHomeAutomationSystem;

public class SmartThermostat extends Device implements SmartDevice{

    //declaring SmartThermostat class specific attributes
    private double houseTemp;

    /*Implementing a default constructor to assign values to houseTemp and inherited attributes from
     the base class if none are given on initialization of the SmartThermostat class
     */
    public SmartThermostat(){
        super();
        this.houseTemp = 72;//setting house temp to common Temp in degrees
    }//end of default constructor


    /*Implementing a parameterized constructor to assign values passed in the parameter of the
    constructor and using setters to avoid accessing private member variables directly, as well
    as super to access the base class, parameterized constructor.
     */
    public SmartThermostat(String name, boolean isOn, double houseTemp) {
        super(name, isOn);
        setHouseTemp(houseTemp);
    }//end of parameterized constructor


    //implementing setters and getters, including validation so houseTemp cant be under 40 degrees or over 90 degrees
    public double getHouseTemp() {
        return houseTemp;
    }//end of getHouseTemp method

    public void setHouseTemp(double houseTemp) {
      if(houseTemp < 40){
          throw new RuntimeException("Smart Thermostat cannot be set under 40 degrees ");
      }else if (houseTemp > 90){
          throw new RuntimeException("Smart Thermostat cannot be set over 90 degrees");
      }else {
          this.houseTemp = houseTemp;
      }
    }//end of setHouseTemp method


    //logic for abstract SmartDevice methods for the SmartThermostat subclass
    /*Implementation of the overridden turnOn method to set SmartThermostat status to On
    and display an informational message to the user about the current on/off status
    and temperature it is regulating to  of SmartThermostat
     */
    @Override
    public void turnOn(){
        System.out.println("Turning on Smart Thermostat now regulating House Temperature to " + getHouseTemp());
        setOn(true);
    }//end of turnOn method


    /*Implementation of the overridden turnOff method to set SmartThermostat status to Off and display an
    informational message to the user about the current on/off status of SmartThermostat
    */
    @Override
    public void turnOff(){
        System.out.println("Turning off Smart Thermostat no longer regulating House Temperature");
        setOn(false);
    }//end of turnOff method

    /* implementation of the overridden getStatus method to display info/current status of SmartThermostat,
   such as name on/off status, and current temperature it is regulating to if on in a neat formatted output
   */
    @Override
    public void getStatus(){
        System.out.println("==================================");
        System.out.println("|***Status Of Smart Thermostat***|");
        System.out.println("==================================");
        System.out.println("Smart Thermostat name: " + getName());
        //using an if statement to check if Smart Thermostat is on or off, i.e., true or false, then printing output depending on whether the condition is met or not
        if(isOn()){
            System.out.println("Smart Thermostat is currently: on");
            System.out.println("Smart Thermostat is regulating House Temperature to:" + getHouseTemp() + " degrees");
        }else{
            System.out.println("Smart Thermostat is currently: off");
            System.out.println("Smart Thermostat is not currently regulating House Temperature");
        }
    }//end of getStatus method

}
