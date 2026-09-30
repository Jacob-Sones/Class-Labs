/*
 * UtilityMethod.java
 * Author: Jacob Sones
 * Date: May 7, 2026
 * A utility class providing shared helper methods used across multiple classes
 * in the NaturalDisasterTrackingSystem. This class exists to avoid duplicating
 * common logic across the observer and disaster classes. It provides two core
 * utilities — a formatted banner printer used throughout the program for clean
 * console output, and a state evaluation method that determines the current
 * state of a NaturalDisaster object and returns a corresponding integer value
 * used by the observer classes to drive unique notification output without
 * repeating state checking logic across each observer implementation.
 */
package NaturalDisasterTrackingSystem;

public class UtilityMethod {

    //Implementation of the printBanner() method, taking a String in its parameters to print a neatly formatted banner.
    public String printBanner(String message){
        int stringLength = message.length() + 8;
        int i;

        //printing top part of banner lines
        for(i = 0; i < stringLength; i++){
            System.out.print("=");
        }
        //printing formated message in banner
        System.out.println("\n|***" + message + "***|");

        //printing bottom part of banner lines
        for(i = 0; i < stringLength; i++){
            System.out.print("=");
        }
        System.out.println();//line break

        return "";
    }//end of printBanner method


    /*Utility method that takes a NaturalDisaster object as a parameter and
     returns an integer value from 1 to 4 representing the current state of
     the disaster. 1 = Monitoring, 2 = Active, 3 = Critical, 4 = Resolved.
     Used across the observer classes to avoid duplicating state checking logic.
     */
    public int findDisasterState(NaturalDisaster naturalDisaster) {
        int disasterState = 0;
        if (naturalDisaster.getCurrentState() instanceof MonitoringState ) {
            disasterState = 1;
        } else if (naturalDisaster.getCurrentState() instanceof ActiveState) {
            disasterState = 2;
        } else if (naturalDisaster.getCurrentState() instanceof CriticalState) {
            disasterState = 3;
        } else if (naturalDisaster.getCurrentState() instanceof ResolvedState) {
            disasterState = 4;
        }

        return disasterState;
    }//end of findDisasterState method

}
