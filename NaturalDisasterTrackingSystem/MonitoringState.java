/*
 * MonitoringState.java
 * Author: Jacob Sones
 * Date: May 3, 2026
 * Represents the Monitoring state in the State design pattern.
 * This is the initial state of any NaturalDisaster object, indicating that
 * the disaster is in its early stages and being closely observed. Implements
 * the DisasterState interface and provides unique output for each disaster
 * type, serving as the entry point of the disaster lifecycle within the
 * broader State pattern implementation.
 */
package NaturalDisasterTrackingSystem;

public class MonitoringState implements DisasterState {

    /*Implementation of the Overridden doAction() method for the MonitoringState class, checking the current disaster type,
     and depending on whether the type is a flood, tornado, or earthquake, a unique message is printed out
     */
    @Override
    public void doAction(NaturalDisaster naturalDisaster) {
        //Implementing UtilityMethod class to use printBanner method
        UtilityMethod utilityMethod = new UtilityMethod();

        if (naturalDisaster.getDisasterType() == DisasterType.FLOOD) {

            utilityMethod.printBanner("Flood State Is Currently Being Monitored");
            System.out.println("Water levels in the area of " + naturalDisaster.getLocation() + " are beginning to rise slowly. Conditions are being closely watched\n" +
                    "as rainfall continues to accumulate in low lying areas. No immediate threat at this time.");

        } else if (naturalDisaster.getDisasterType() == DisasterType.TORNADO) {
            utilityMethod.printBanner("Tornado State Is Currently Being Monitored");
            System.out.println("Atmospheric conditions are becoming favorable for tornado development in " + naturalDisaster.getLocation() + ".\n" +
                    "Storm systems in the area are being closely tracked as rotating thunderstorms begin to organize in the region.");

        } else if (naturalDisaster.getDisasterType() == DisasterType.EARTHQUAKE) {
            utilityMethod.printBanner("Earthquake State Is Currently Being Monitored");
            System.out.println("Minor seismic activity has been detected in " + naturalDisaster.getLocation() + ".\n" +
                    "Sensors are picking up small tremors beneath the surface as pressure continues\n" +
                    "to build along nearby fault lines. Residents should remain aware.\"");
        } else {
            System.out.println("An unidentified disaster event in " + naturalDisaster.getLocation() +
                    " is currently being monitored. Conditions are being observed as the situation continues to develop.");
        }//end of if/if-else statements

    }//end of doAction method

}
