/**
 * File: MenuDriver.java
 * Package: Lab1
 * Author: Jacob Sones
 * Date: April 16, 2026
 *
 * Main driver class for the Smart Home Automation System. Serves as the entry point
 * and user interface for the program. Manages all smart device objects through an
 * ArrayList of SmartDevice interface references, demonstrating polymorphism by
 * treating SmartLight, SmartSpeaker, and SmartThermostat objects uniformly through
 * the shared interface. Provides a text-based menu system allowing the user to view
 * device statuses, toggle power states, and adjust device-specific settings such as
 * brightness, volume, and temperature. Input validation and error handling are
 * implemented throughout to ensure stable program execution.
 */
package SmartHomeAutomationSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuDriver {

    static void main() {
        //declaring an ArrayList for an object declared as a reference of the SmartDevice interface
        ArrayList<SmartDevice> smartDevicesList = new ArrayList<>();

        //declaring variable to store user menu selection choice in
        int choice = 0;
        int subMenuChoice = 0;
        //creating an instance of the MenuDriver class to allow for the displayOnOff menu method to be used inside the main method
        MenuDriver menuDriver = new MenuDriver();

        /*declaring a new scanner object to allow the program to gather user input
         for operation and interaction with the Smart Device Menu and Smart device objects
         */
        Scanner scanner = new Scanner(System.in);

        /*declaring and initializing new subclass objects to store in SmartDeviceList, setting as null,
         to then use a try-catch statement to initialize the subclass objects
         */
        SmartLight smartLight1 = null;
        try {
            smartLight1 = new SmartLight("living Room Light", true, 50);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }//end of catch

        SmartSpeaker smartSpeaker1 = null;
        try {
            smartSpeaker1 = new SmartSpeaker("Kitchen Sound System", false, 0,"Through The Wire","Kanye West");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }//end of catch

        SmartThermostat smartThermostat1 = null;
        try {
            smartThermostat1 = new SmartThermostat("House Smart Thermostat", true, 68);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }//end of catch

        //adding Smart devices to smartDeviceList
        smartDevicesList.add(smartLight1);
        smartDevicesList.add(smartSpeaker1);
        smartDevicesList.add(smartThermostat1);

        do {
            //displaying menu options to the user for valid operations they can execute for SmartDevice objects
            System.out.println("=========================");
            System.out.println("|***Smart Device Menu***|");
            System.out.println("=========================");
            System.out.println("------------------------------------");
            System.out.println("1: Display All Smart Devices       |");
            System.out.println("2: Turn Smart Device On/Off        |");
            System.out.println("3: Adjust Smart Device settings    |");
            System.out.println("4: exit Smart Device Menu          |");
            System.out.println("------------------------------------");
            System.out.println("Please Select an option");
            System.out.println("Option:");
            //using scanner object to gather user input for operation to be performed on the smart devices
            choice = scanner.nextInt();

            /*start of first switch statement to go into first menu, 3 options: display all info, turn on/off
            a Smart Device, and adjust the settings of the Smart Device or display a thank you message to
            the user if they select to exit ie 4
             */
            switch (choice) {

                /*First case statement to display all Smart Devices stored in the smartDeviceList
                using an enhanced for loop and the @Overridden getStatus method
                 */
                case 1:
                    /*implementing an enhanced for loop to iterate through each SmartDevice stored
                     in the smartDeviceList and displaying its current status/info
                     */
                    for (SmartDevice smartDevice : smartDevicesList) {
                        smartDevice.getStatus();
                        System.out.println();
                    }//end of enhanced for loop
                    break;//end of case 1

                /*Start of the second case statement displaying a second menu of all devices that can be turned on or off,
                prompting the user to select a smart device to perform the desired operation on, then going into a nested
                switch statement and prompting the user whether they want to turn the selected device on or off
                 */
                case 2:
                    System.out.println("===============================");
                    System.out.println("***Turn Smart Device On/Off***|");
                    System.out.println("===============================");
                    System.out.println("----------------------");
                    System.out.println("Devices:             |");
                    System.out.println("1: Smart Light       |");
                    System.out.println("2: Smart Speaker     |");
                    System.out.println("3: Smart Thermostat  |");
                    System.out.println("----------------------");
                    System.out.println("Please Select a Smart Device you would like to turn On/Off");
                    System.out.println("Option:");
                    subMenuChoice = scanner.nextInt();

                    //using a nested switch statement within case two to execute the desired turn on/off operation for the selected device, user choices
                    switch (subMenuChoice) {
                        /*start of nested case statement displaying selected device from menu above and prompting the user
                         to select the operation the user would like to perform on the selected device, i.e.,
                         turn on or off
                         */
                        case 1:
                            menuDriver.displayOnOffMenu("Smart Light");
                            subMenuChoice = scanner.nextInt();
                            if (subMenuChoice == 1) {
                                smartLight1.turnOn();
                            } else if (subMenuChoice == 2) {

                                smartLight1.turnOff();
                            } else {
                                System.out.println("could not perform task invalid option selected Please select 1 or 2");
                            }
                            break;//end of nested case 1

                        case 2:

                            menuDriver.displayOnOffMenu("Smart Speaker");
                            subMenuChoice = scanner.nextInt();
                            if (subMenuChoice == 1) {
                                smartSpeaker1.turnOn();
                            } else if (subMenuChoice == 2) {
                                smartSpeaker1.turnOff();
                            } else {
                                System.out.println("could not perform task invalid option selected Please select 1 or 2");
                            }
                            break;//end of nested case 2

                        case 3:

                            menuDriver.displayOnOffMenu("Smart Thermostat");
                            subMenuChoice = scanner.nextInt();
                            if (subMenuChoice == 1) {
                                smartThermostat1.turnOn();
                            } else if (subMenuChoice == 2) {
                                smartThermostat1.turnOff();
                            } else {
                                System.out.println("could not perform task invalid option selected Please select 1 or 2");
                            }
                            break;//end of nested case 3

                        //implementing a default case for any input that is not in the range of 1-3, informing the user that they selected an invalid
                        default:
                            System.out.println("Error: could not perform task on selected option please select a valid option from list");
                            break;//end of default case in nested switch
                    }//end of nested switch statement
                    break;//end of case 2

                /*start of third case statement displaying a new sub menu of valid operations that can be performed
                on Smart Devices, such as adjust brightness for SmartLights, adjust volume for SmartSpeakers,
                and adjust degrees for SmartThermostat, using a nested switch statement to gather desired adjustments
                to the selected device and then setting it
                 */
                case 3:
                    System.out.println("====================================");
                    System.out.println("|***Adjust Smart Device settings***|");
                    System.out.println("====================================");
                    System.out.println("------------------------------------");
                    System.out.println("Operations                         |");
                    System.out.println("1: Adjust Smart Light Brightness   |");
                    System.out.println("2: Adjust Smart Speaker Volume     |");
                    System.out.println("3: Adjust Smart Thermostat degrees |");
                    System.out.println("------------------------------------");
                    System.out.println("Please select operation:");
                    subMenuChoice = scanner.nextInt();

                    //using a nested switch statement within case three to execute the desired adjustment in setting that they selected
                    switch (subMenuChoice) {
                         /*start of nested case statement displaying selected device from menu above and prompting the user
                         to select the desired adjustment of setting on the device they selected
                         */
                        case 1:
                            System.out.println("==============================");
                            System.out.println("|***Smart Light Brightness***|");
                            System.out.println("==============================");
                            System.out.println("What would you like to adjust the Smart Lights brightness to: 0-100");
                            int newBrightness = scanner.nextInt();
                            try {
                                smartLight1.setBrightnessLevel(newBrightness);
                            } catch (RuntimeException e) {
                                System.out.println("Error: " + e.getMessage());
                            }//end of try-catch statement
                            break;//end of first nested case statement

                        case 2:
                            System.out.println("============================");
                            System.out.println("|***Smart Speaker Volume***|");
                            System.out.println("============================");
                            System.out.println("What would you like to adjust the Smart Speaker volume to:0-100");
                            int newVolume = scanner.nextInt();
                            try{
                                smartSpeaker1.setVolume(newVolume);
                            }catch (RuntimeException e){
                                System.out.println("Error: " + e.getMessage());
                            }//end of try-catch statement
                            break;//end of nested case statement 2

                        case 3:
                            System.out.println("====================================");
                            System.out.println("|***Smart Thermostat temperature***|");
                            System.out.println("====================================");
                            System.out.println("What would you like to adjust the Smart Thermostat to:40-90 degrees");
                            double newTemperature = scanner.nextDouble();
                            try{
                                smartThermostat1.setHouseTemp(newTemperature);
                            }catch (RuntimeException e){
                                System.out.println("Error: " + e.getMessage());
                            }//end of try-catch
                            break;//end of nested case statement 3

                        //implementing a default case for any input that is not in the range of 1-3, informing the user that they selected an invalid
                        default:
                            System.out.println("Error: could not perform task on selected option please select a valid option from list");
                    }//end of nested switch statement

                    break;//end of case statement 3

                //start of the fourth case statement displaying a thank you message to the user if the selected choice is to exit the Smart Device Menu loop
                case 4:
                    System.out.println("Thank you for using the Smart Device menu hope you have a great day :)");
                    break;//end of case statement 4

                //implementing a default case for any input that is not in the range of 1-4, informing the user that they selected an invalid
                default:
                    System.out.println("Error: seem you entered an invalid menu option please try again and select option: 1-4 ");
                    break;

            }//end of switch statement

        //end of do while loop if user input is 4
        } while (choice != 4);


    }//end of main method

    //implementing a displayOnOfMenu to declutter code reuse of the turn on/off menu in case statement two
    public void displayOnOffMenu(String promt){
        int promtLength = promt.length() + 8;
        int i;
        for(i = 0 ; i < promtLength ; i++)
        {
            System.out.print("+");
        }

        System.out.println("\n|***" + promt + "***|");

        for(i = 0 ; i < promtLength ; i++)
        {
            System.out.print("+");
        }
        System.out.println("\nTurn " + promt + " On/Off:");
        System.out.println("1: On");
        System.out.println("2: Off");
        System.out.println("Select an Option");
    }//end of the displayOnOffMenu method

}//end f MenuDriver class
