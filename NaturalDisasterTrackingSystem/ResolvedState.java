/*
 * ResolvedState.java
 * Author: Jacob Sones
 * Date: May 3, 2026
 *
 * Concrete implementation of the DisasterState interface representing the
 * Resolved state in the State design pattern. Indicates the disaster has
 * passed its peak intensity and conditions are stabilizing across the affected
 * area. Implements doAction() to print disaster type specific resolved condition
 * messages by checking the DisasterType of the passed NaturalDisaster object.
 * Serves as the final state in the disaster lifecycle, signaling that the
 * immediate threat has passed and the situation is returning to normal.
 */
package NaturalDisasterTrackingSystem.NaturalDisasterTrackingSystem;

public class ResolvedState implements DisasterState{

    /*Implementation of the Overridden doAction() method for the ResolvedState class, checking the current disaster type,
     and depending on whether the type is a flood, tornado, or earthquake, a unique message is printed out
     */
    @Override
    public void doAction(NaturalDisaster naturalDisaster){
        //Implementing UtilityMethod class to use printBanner method
        UtilityMethod utilityMethod = new UtilityMethod();

        if(naturalDisaster.getDisasterType() == DisasterType.FLOOD){
            utilityMethod.printBanner("Flood State Is Resolved");
            System.out.println("The flood has been downgraded to a resolved state. Water levels are slowly receding and the immediate threat has passed.\n" +
                    "Conditions are stabilizing across " + naturalDisaster.getLocation() + " as the situation continues to improve.");

        }else if(naturalDisaster.getDisasterType() == DisasterType.TORNADO){
            utilityMethod.printBanner("Tornado State Is Resolved");
            System.out.println("Tornado conditions have been resolved. The storm has weakened and the funnel is no longer active.\n" +
                    "Atmospheric conditions are stabilizing and the immediate threat posed by this tornado has passed.");

        }else if(naturalDisaster.getDisasterType() == DisasterType.EARTHQUAKE){
            utilityMethod.printBanner("Earthquake State Is Resolved");
            System.out.println("The earthquake has been downgraded to a resolved state. Seismic activity has subsided and the ground has stabilized.\n" +
                    "The most intense phase of this event has passed and conditions are returning to normal.");

        }else{
            System.out.println("An unidentified disaster event in " + naturalDisaster.getLocation() +
                    " has been resolved. Conditions are stabilizing and the immediate threat has passed.");
        }//end of if/if-else statement

    }//end of doAction method
}
