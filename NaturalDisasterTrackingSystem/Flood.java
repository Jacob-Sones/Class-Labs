/*
 * Flood.java
 * Author: Jacob Sones
 * Date: May 3, 2026
 *
 * Concrete subclass of NaturalDisaster representing a Flood event.
 * Extends the base class by adding a waterLevel field stored in inches.
 * Implements the abstract methods causeDisaster() and calculateDamages() with
 * flood specific logic, using water depth thresholds to determine destruction
 * output and a multiplier based damage formula. Participates in both the Observer
 * and State patterns as the subject being tracked and notified through the NaturalDisasterStation.
 */
package NaturalDisasterTrackingSystem;
import java.text.NumberFormat;

public class Flood extends NaturalDisaster{

    //declaring a class-specific private member variable for the concrete Flood subclass
    private double waterLevel;//waterLevel set in inches


    /*Implementation of a default constructor to assign base values to private member variables if none are given
     on initialization of new objects using super() to utilize the NaturalDisaster base class, default constructor
     */
    public Flood(){
        super();
        this.waterLevel = 0.0;
    }//end of default constructor


    /*Implementation of the parameterized constructor, assigning values passed in the parameters to private member
    variables using setters with built-in validation checks, and utilizing super to access the NaturalDisasters
    base class parameterized constructor
    */
    public Flood(int severityLevel, int affectedPopulation, double estimatedCostOfDamages, String name, String location, DisasterType disasterType, DisasterState currentState, double waterLevel) {
        super(severityLevel, affectedPopulation, estimatedCostOfDamages, name, location, disasterType, currentState);
       setWaterLevel(waterLevel);
    }//end of


    /*Implementation of the copy constructor to take an existing object of the Flood subclass and create a new object
    with identical attributes utilizing super to access the NaturalDisaster base class copy constructor
     */
    public Flood(Flood floodCopy){
        super(floodCopy);
        this.waterLevel = floodCopy.getWaterLevel();
    }//end of copy constructor


    /*Implementation of getters and setters with built-in validation to check that attributes
     are not set to invalid dates, like water level being a negative number
     */
    public double getWaterLevel() {
        return waterLevel;
    }//end of getWaterLevel

    public void setWaterLevel(double waterLevel) {
      if(waterLevel < 0){
          throw new RuntimeException("Error: An error has occurred Water Level cannot be set to a negative number");
      }else {
          this.waterLevel = waterLevel;
      }//end of if-else statement

    }//end of setWaterLevel

    /*Overridden causeDisaster() implementation that checks the Floods waterLevel is between 1-2 feet,3-5 feet, and 6+ feet then outputs
      a Low, Moderate, or Catastrophic destruction description based on the water level
     */
    @Override
    public void causeDisaster() {
        //creating temp UtilityMethod object to access printBanner method
        UtilityMethod utilityMethod = new UtilityMethod();

        // Note: waterLevel is stored in inches, thresholds below are converted to inches (e.g. 24 = 2 feet, 60 = 5 feet)
        if(waterLevel <= 24){
        utilityMethod.printBanner("Low Water Level Flood Is Causing Destruction");
            System.out.println("Water begins creeping across low lying roads and into drainage systems as the flood slowly pushes forward.\n" +
                    "Puddles expand into streams as the rising water edges toward nearby neighborhoods and open fields.");

        }else if(waterLevel <= 60){
            utilityMethod.printBanner("Moderate Water Level Flood Is Causing Destruction");
            System.out.println("Rushing floodwaters pour into the ground floors of homes and businesses sweeping furniture and belongings out into the streets.\n" +
                    "Cars are lifted off the pavement and carried downstream as the powerful current surges through the neighborhood.");

        }else if(waterLevel >= 61){
            utilityMethod.printBanner("Catastrophic Water Level Flood Is Causing Destruction");
            System.out.println("Walls of water crash through the area flooding buildings well above their ground floors and tearing through anything not anchored to the earth.\n" +
                    "The raging current drags debris and vehicles through what were once busy streets now completely consumed by the flood.");

        }//end of if/if-else statement

    }//end of the causeDestruction method



    /*Implementation of the Overridden calculateDamages() method calculates total flood damage using waterLevel
     depth as a multiplier (2x, 4x, 6x, or 8x), combined with severityLevel converted to a percentage
     of the base estimated cost.
     */
    @Override
    public double calculateDamages(){
        //Implementing the NumberFormat class to use to format currency to two decimal places
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        //Implementing UtilityMethod class to use printBanner method
        UtilityMethod utilityMethod = new UtilityMethod();

        double totalCostOfDamages = 0;
        //down casting severityLevel to a double then converting to percentage to be used in calculation
        double severityPercentage = (double) getSeverityLevel() / 10;

        //formula used to calculate totalCostOfDamages
        if(waterLevel <= 24){

            totalCostOfDamages = (getEstimatedCostOfDamages() + (getEstimatedCostOfDamages() * severityPercentage)) * 2;

        }else if(waterLevel <= 60){

            totalCostOfDamages = (getEstimatedCostOfDamages() + (getEstimatedCostOfDamages() * severityPercentage)) * 4;

        }else if(waterLevel <= 120){

            totalCostOfDamages = (getEstimatedCostOfDamages() + (getEstimatedCostOfDamages() * severityPercentage)) * 6;

        }else if(waterLevel >= 121){

            totalCostOfDamages = (getEstimatedCostOfDamages() + (getEstimatedCostOfDamages() * severityPercentage)) * 8;

        }//end of if/else-if statements

        //printing message for how much the totalCostOfDamages are for the disaster
        utilityMethod.printBanner("Calculating Total Cost Of Damages");
        System.out.println("After the Flood has tore through " + getLocation() + " the total cost of damages is: " + curr.format(totalCostOfDamages));

        //returning totalCostOfDamages
        return totalCostOfDamages;
    }//end of calculateDamages method


    /*Implementation of toString to return a neatly formatted String of info for the Flood subclass,
    utilizing super.toString to access the NaturalDisaster base class built-in toString()
     */
    @Override
    public String toString() {
        String myReturn = super.toString();
        myReturn += "Water Level: " + getWaterLevel() / 12 + " Feet\n";
        return myReturn;
    }//end of toString
}
