/*
 * ActiveState.java
 * Author: Jacob Sones
 * Date: May 3, 2026
 * Represents the Active state in the State design pattern.
 * This state indicates that the disaster is fully underway and conditions
 * are escalating. Implements the DisasterState interface and provides
 * unique output for each disaster type. Sits between the Monitoring and
 * Critical states in the disaster lifecycle, reflecting a significant
 * escalation in the severity of the ongoing event.
 */
package NaturalDisasterTrackingSystem;

public class ActiveState implements DisasterState{

    /*Implementation of the Overridden doAction() method for the ActiveState class, checking the current disaster type,
     and depending on whether the type is a flood, tornado, or earthquake, a unique message is printed out
     */
    @Override
    public void doAction(NaturalDisaster naturalDisaster){
        //Implementing UtilityMethod class to use printBanner method
        UtilityMethod utilityMethod = new UtilityMethod();

        if(naturalDisaster.getDisasterType() == DisasterType.FLOOD){

            utilityMethod.printBanner("Flood State Is Currently Active");
            System.out.println("Floodwaters are actively rising in " + naturalDisaster.getLocation() + ".\n" +
                    "Water levels are rising at an accelerating rate and the situation is developing rapidly.\n" +
                    "Conditions are expected to continue worsening as the flood advances further");

        }else if(naturalDisaster.getDisasterType() == DisasterType.TORNADO){
            utilityMethod.printBanner("Tornado State Is Currently Active");
            System.out.println("Active tornado conditions are now in effect. The storm is intensifying and pushing further into " + naturalDisaster.getLocation() + ".\n" +
                    "Conditions are deteriorating rapidly and the situation remains extremely volatile.");

        }else if(naturalDisaster.getDisasterType() == DisasterType.EARTHQUAKE){
            utilityMethod.printBanner("Earthquake State Is Currently Active");
            System.out.println("Active seismic conditions are now in effect across " + naturalDisaster.getLocation() + ".\n" +
                    "The earthquake is ongoing and growing in intensity. The situation is fluid and conditions could change rapidly without warning.");
        }else{
            System.out.println("An unidentified disaster event in " + naturalDisaster.getLocation() +
                    " is currently active. Conditions are escalating and the situation is developing rapidly.");
        }//end of if/if-else statements

    }//end of doAction method

}
