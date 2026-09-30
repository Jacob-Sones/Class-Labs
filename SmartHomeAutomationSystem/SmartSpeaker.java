/**
 * File: SmartSpeaker.java
 * Package: Lab1
 * Author: Jacob Sones
 * Date: April 16, 2026
 *
 * Concrete class representing a smart speaker device in the Smart Home Automation System.
 * Extends the abstract Device class to inherit shared attributes such as name and power
 * state, and implements the SmartDevice interface to provide concrete behavior for
 * turning the speaker on and off, as well as reporting its current status. This class
 * introduces a volume attribute unique to smart speakers, with validation to ensure
 * volume stays within a valid range of 0 to 100. It also includes a playSong() method
 * that displays the currently playing song and artist to the user.
 */
package SmartHomeAutomationSystem;

public class SmartSpeaker extends Device implements SmartDevice {

    //declaring subclass specific private member variables
    private int volume;
    private String currentSong;
    private String nameOfArtist;

    /*Implementing a default constructor to assign values to volume and inherited attributes from
     the base class if none are given on initialization of the SmartSpeaker class
     */
    public SmartSpeaker(){
        super();
        this.volume = 0;
        this.nameOfArtist = "Unknown";
        this.nameOfArtist = "Unknown";
    }//end of default constructor

    /*Implementing a parameterized constructor to assign values passed in the parameter of the constructor
     and using setters to avoid accessing private member variables directly, as well as super to access
     the base class, parameterized constructor.
     */



    public SmartSpeaker(String name, boolean isOn, int volume, String currentSong, String nameOfArtist) {
        super(name, isOn);
        setVolume(volume);
        setCurrentSong(currentSong);
        setNameOfArtist(nameOfArtist);
    }//end of parameterized constructor

    //implementing setters and getters, including validation to make sure the values are not negative or over 100
    public int getVolume() {
        return volume;
    }//end of getVolume method

    public void setVolume(int volume) {
        if(volume < 0 ){
           throw new RuntimeException("Volume cannot be negative");
        } else if (volume > 100) {
            throw new RuntimeException("Volume cannot exceed 100");
        } else {
            this.volume = volume;
        }
    }//end of setVolume method

    public String getCurrentSong() {
        return currentSong;
    }//end of getCurrentSong method

    public void setCurrentSong(String currentSong) {
       if(currentSong == null || currentSong.trim().isEmpty()){
           this.currentSong = "Unknown";
       }else {
           this.currentSong = currentSong;
       }
    }//end of setCurrentSong method

    public String getNameOfArtist() {
        return nameOfArtist;
    }//end of getNameOfArtist

    public void setNameOfArtist(String nameOfArtist) {
        if(nameOfArtist == null || nameOfArtist.trim().isEmpty()){
            this.nameOfArtist = "Unknown";
        }else {
            this.nameOfArtist = nameOfArtist;
        }
    }//end of setNameOfArtist

    /*Implementation of the playSong method for the SmartSpeaker class takes two parameters: songName and artistName,
         then displays a neatly formatted output of the current song playing and who it was made by to the user
         */
    public void playSong(){
        System.out.println("You are now grooving to " + getCurrentSong() + " by " + getNameOfArtist());
    }//end of playSong method

    //logic for abstract SmartDevice methods for the SmartSpeaker subclass
    /*Implementation of the overridden turnOn method to set SmartSpeaker's status to On
    and display an informational message to the user about the current on/off status of SmartSpeaker
     */
    @Override
    public void turnOn() {
        System.out.println("Turning on Smart Speaker");
        setOn(true);
    }//end of turnOn

    /*Implementation of the overridden turnOff method to set SmartSpeaker's status to Off and display an
    informational message to the user about the current on/off status of SmartSpeaker
     */
    @Override
    public void turnOff() {
        System.out.println("Turning off Smart Speaker");
        setOn(false);
    }//end of turnOff

    /* implementation of the overridden getStatus method to display info/current status of SmartSpeaker,
     such as name on/off status, and current volume the speaker is set to in a neat formatted output
     */
    @Override
    public void getStatus() {
        System.out.println("===============================");
        System.out.println("|***Status of Smart Speaker***|");
        System.out.println("===============================");
        System.out.println("Name of Smart Speaker: " + getName());
        //using an if statement to check if Smart Speaker is on or off, i.e., true or false, then printing output depending on whether the condition is met or not
        if(isOn()){
            System.out.println("Smart Speaker is currently: on");
            //using playSong method to display the current song playing if the Smart Speaker is on if off playSong() will not run
            playSong();
        }else{
            System.out.println("Smart Speaker is currently: off");
        }
        System.out.println("Smart Speaker volume is set to: " + getVolume());


    }//end of get status
}
