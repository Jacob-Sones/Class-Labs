/*
 * CriticalState.java
 * Author: Jacob Sones
 * Date: May 3, 2026
 *
 * Concrete implementation of the DisasterState interface representing the
 * Critical state in the State design pattern. Indicates the disaster has
 * reached peak intensity and conditions are at their most dangerous point.
 * Implements doAction() to print disaster type specific critical condition
 * messages by checking the DisasterType of the passed NaturalDisaster object.
 * Represents the most severe point in the disaster lifecycle, positioned
 * between ActiveState and ResolvedState as the situation reaches its worst
 * before beginning to stabilize.
 */
package NaturalDisasterTrackingSystem.NaturalDisasterTrackingSystem;

public class CriticalState implements DisasterState{

    /*Implementation of the Overridden doAction() method for the CriticalState class, checking the current disaster type,
     and depending on whether the type is a flood, tornado, or earthquake, a unique message is printed out
     */
    @Override
    public void doAction(NaturalDisaster naturalDisaster){
        //Implementing UtilityMethod class to use printBanner method
        UtilityMethod utilityMethod = new UtilityMethod();

        if(naturalDisaster.getDisasterType() == DisasterType.FLOOD){
            utilityMethod.printBanner("Flood State Is Currently Critical");
            System.out.println("The flood has reached critical status. Water levels are at their peak and the situation is extremely dangerous.\n" +
                    "Conditions have deteriorated to their most severe point with no signs of the water receding.");

        }else if(naturalDisaster.getDisasterType() == DisasterType.TORNADO){
            utilityMethod.printBanner("Tornado State Is Currently Critical");
            System.out.println("The tornado has reached critical status. The funnel is at peak intensity and conditions on the ground are at their most dangerous point.\n" +
                    "The storm is at its most destructive and volatile state.");

        }else if(naturalDisaster.getDisasterType() == DisasterType.EARTHQUAKE){
            utilityMethod.printBanner("Earthquake State Is Currently Critical");
            System.out.println("The earthquake has reached critical status. Seismic activity is at its most intense point and the situation remains extremely dangerous.\n" +
                    "Conditions continue to deteriorate as the event reaches its peak magnitude.");
        }else{
            System.out.println("An unidentified disaster event in " + naturalDisaster.getLocation() +
                    " has reached critical status. Conditions are at their most severe and the situation is extremely dangerous.");
        }//end of if/if-else statement

    }//end of doAction method
}
