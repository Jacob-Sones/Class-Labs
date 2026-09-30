/*
 * Earthquake.java
 * Author: Jacob Sones
 * Date: May 3, 2026
 *
 * Concrete subclass of NaturalDisaster representing an Earthquake event.
 * Extends the base class by adding a magnitude field measured on the Richter scale.
 * Implements the abstract methods causeDisaster() and calculateDamages() with
 * earthquake specific logic, using magnitude to determine destruction output and
 * damage calculations. Participates in both the Observer and State patterns as
 * the subject being tracked and notified through the NaturalDisasterStation.
 */
package NaturalDisasterTrackingSystem;
import java.text.NumberFormat;

public class Earthquake extends NaturalDisaster {

    //declaring a class-specific private member variable for the concrete Earthquake subclass
    private double magnitude;//magnitude set to use the Richter scale


    /*Implementation of a default constructor to assign base values to private member variables if none are given
     on initialization of new objects using super() to utilize the NaturalDisaster base class, default constructor
     */
    public Earthquake() {
        super();
        this.magnitude = 0.0;
    }//end of default constructor


    /*Implementation of the parameterized constructor, assigning values passed in the parameters to private member
    variables using setters with built-in validation checks, and utilizing super to access the NaturalDisasters
    base class parameterized constructor.
     */
    public Earthquake(int severityLevel, int affectedPopulation, double estimatedCostOfDamages, String name, String location, DisasterType disasterType, DisasterState currentState, double magnitude) {
        super(severityLevel, affectedPopulation, estimatedCostOfDamages, name, location, disasterType, currentState);
        setMagnitude(magnitude);
    }//end of parameterized constructor


    /*Implementation of the copy constructor to take an existing object of the Earthquake subclass and create a new
    object with identical attributes utilizing super to access the NaturalDisaster base class copy constructor
     */
    public Earthquake(Earthquake earthquakeCopy) {
        super(earthquakeCopy);
        this.magnitude = earthquakeCopy.getMagnitude();
    }//end of copy constructor


    /*Implementation of getters and setters with built-in validation to check that attributes are not set to
      invalid dates, like magnitude being negative, or higher than 10 based on the Richter scale
      */
    public double getMagnitude() {
        return magnitude;
    }//end of getMagnitude

    public void setMagnitude(double magnitude) {
        if (magnitude < 0) {
            throw new RuntimeException("Error: an error has occurred Magnitude cannot be set to a negative number");
        } else if (magnitude > 10) {
            throw new RuntimeException("Error: An error has occurred Magnitude cannot be set higher then 10 on the Richter scale");
        } else {
            this.magnitude = magnitude;
        }//end of if/if-else statement

    }//end of setMagnitude

    /*Overridden causeDisaster() implementation that checks the earthquake's magnitude and outputs
      a Low, Moderate, or Catastrophic destruction description based on the level
     */
    @Override
    public void causeDisaster() {
       //creating temp UtilityMethod object to access printBanner method
        UtilityMethod utilityMethod = new UtilityMethod();

        if (magnitude <= 4.9) {
        utilityMethod.printBanner("Low Magnitude Earthquake Is Causing Destruction");
            System.out.println("The ground begins to lightly tremble beneath your feet. Small objects rattle and fall from shelves.\n" +
                    "Walls crack slightly as the earth shifts. The shaking is mild but unsettling ");

        } else if (magnitude <= 6.9) {
            utilityMethod.printBanner("Moderate Magnitude Earthquake Is Causing Destruction");
            System.out.println("The earth violently shakes as windows shatter and walls begin to crack.\n" +
                    "Older buildings groan under the stress as chunks of debris rain down onto the streets below.\n" +
                    "Roads split open and water mains burst sending water flooding across the pavement.");

        } else if (magnitude <= 10) {
            utilityMethod.printBanner("Catastrophic Magnitude Earthquake Is Causing Destruction");
            System.out.println("The ground tears itself apart as massive fissures rip open across roads and fields.\n" +
                    "Buildings crumble and collapse in clouds of dust and debris. Bridges twist and fall into rivers below as the earth convulses with devastating force.");
        }//end of if/if-else statements

    }//end of causeDisaster method



    /*Implementation of the Overridden calculateDamages() method Calculates total earthquake damage by converting severityLevel and magnitude to
    decimal multipliers and applying them against the base estimated cost of damages
    */
    @Override
    public double calculateDamages() {
        //Implementing the NumberFormat class to use to format currency to two decimal places
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        //Implementing UtilityMethod class to use printBanner method
        UtilityMethod utilityMethod = new UtilityMethod();

        double totalCostOfDamages;
        //down casting severityLevel and magnitude to a double then converting to percentage to be used in calculation
        double severityPercentage = (double) getSeverityLevel() / 10;
        double magnitudePercentage = (double) getMagnitude() / 10;

        //formula used to calculate totalCostOfDamages
        totalCostOfDamages = getEstimatedCostOfDamages() +(getEstimatedCostOfDamages() * severityPercentage) + (getEstimatedCostOfDamages() * magnitudePercentage);

        //printing message for how much the totalCostOfDamages are for the disaster
        utilityMethod.printBanner("Calculating Total Cost Of Damages");
        System.out.println("After Earthquake has rampaged through " + getLocation() + " the total cost of damages caused is: " + curr.format(totalCostOfDamages));

        //returning totalCostOfDamages
        return totalCostOfDamages;
    }//end of calculateDamages method

    /*Implementation of toString to return a neatly formatted String of info for the Earthquake subclass,
     utilizing super.toString to access the NaturalDisaster base class built-in toString()
     */
    @Override
    public String toString() {
        String myReturn = super.toString();
        myReturn += "Magnitude on the Richter scale: " + getMagnitude() + "/10\n";
        return myReturn;
    }//end of toString
}
