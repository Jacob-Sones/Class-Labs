/*
 * UtilityMethod.java
 * Author: Jacob Sones
 * Date: May 7, 2026
 *
 * A utility class providing shared helper methods used across multiple classes
 * in the NaturalDisasterTrackingSystem to avoid duplicating common logic.
 * Contains two core methods: printBanner() which formats and prints a
 * consistently styled banner to the console used throughout all classes for
 * clean output display, and findDisasterState() which receives a NaturalDisaster
 * object and uses instanceof checks to determine its current state, returning
 * an integer from 1 to 4 representing Monitoring, Active, Critical, or Resolved.
 * The findDisasterState() method is shared across all three observer classes
 * to eliminate duplicated state checking logic and keep the observer
 * implementations clean and focused on their notification responsibilities.
 */
package NaturalDisasterTrackingSystem.NaturalDisasterTrackingSystem;

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
