/*
 * Tornado.java
 * Author: Jacob Sones
 * Date: May 3, 2026
 *
 * Concrete subclass of NaturalDisaster representing a Tornado event in the
 * NaturalDisasterTrackingSystem. Extends the base class by adding a category
 * field rated on the Enhanced Fujita scale from EF0 to EF5 and a windSpeed
 * field measured in mph. Overrides the abstract methods causeDisaster() and
 * calculateDamages() with tornado specific logic, using the EF category
 * thresholds to output Low, Moderate, or Catastrophic destruction descriptions,
 * and combining category and severityLevel as decimal multipliers in the damage
 * formula. Participates in both the State and Observer patterns as one of the
 * tracked disaster subjects managed and broadcasted through the NaturalDisasterStation.
 */
package NaturalDisasterTrackingSystem.NaturalDisasterTrackingSystem;
import java.text.NumberFormat;

public class Tornado extends NaturalDisaster {

    //declaring a class-specific private member variable for the concrete Tornado subclass
    private int category;//set to use the Enhanced Fujita (EF) Scale which rate a Tornado from EF-1 to EF-5
    private double windSpeed;//set to use miles per hour mph for speed scale


    /*Implementation of a default constructor to assign base values to private member variables if none are given
    on initialization of new objects using super() to utilize the NaturalDisaster base class, default constructor
     */
    public Tornado() {
        super();
        this.category = 0;
        this.windSpeed = 0.0;
    }//end of default constructor


    /*Implementation of the parameterized constructor, assigning values passed in the parameters to private member
    variables using setters with built-in validation checks, and utilizing super to access the NaturalDisasters base
    class parameterized constructor.
     */
    public Tornado(int severityLevel, int affectedPopulation, double estimatedCostOfDamages, String name, String location, DisasterType disasterType, DisasterState currentState, int category, double windSpeed) {
        super(severityLevel, affectedPopulation, estimatedCostOfDamages, name, location, disasterType, currentState);
        setCategory(category);
        setWindSpeed(windSpeed);
    }//end of parameterized constructor


    /*Implementation of the copy constructor to take an existing object of the Tornado subclass and create a
    new object with identical attributes utilizing super to access the NaturalDisaster base class copy constructor
     */
    public Tornado(Tornado tornadoCopy){
        super(tornadoCopy);
        this.category = tornadoCopy.getCategory();
        this.windSpeed = tornadoCopy.getWindSpeed();
    }//end of copy constructor


    /*Implementation of getters and setters with built-in validation to check that attributes are not set to
      invalid dates, like category is not negative or greater than 5, and that windSpeed is not set to negative
       */
    public int getCategory() {
        return category;
    }//end of getCategory

    public void setCategory(int category) {
      if(category < 0){
          throw new RuntimeException("Error: An error has occurred Category cannot be set to a negative number");
      }else if(category > 5){
          throw new RuntimeException("Error: An error has occurred Category cannot be greater then 5 on the EF scale");
      }else {
          this.category = category;
      }//end of if/if-else statement

    }//end of setCategory

    public double getWindSpeed() {
        return windSpeed;
    }//end of getWindSpeed

    public void setWindSpeed(double windSpeed) {
       if(windSpeed < 0){
           throw new RuntimeException("Error: An error has occurred Wind Speed cannot be set to a negative number");
       }else {
           this.windSpeed = windSpeed;
       }
    }//end of setWindSpeed


    /*Overridden causeDisaster() implementation that checks the Tornados EF category and outputs
      a Low, Moderate, or Catastrophic destruction description based on the level
     */
    @Override
    public void causeDisaster() {
        //creating temp UtilityMethod object to access printBanner method
        UtilityMethod utilityMethod = new UtilityMethod();

        if(category <= 1){
            utilityMethod.printBanner("Category "+ getCategory() + " Tornado Is Causing Destruction");
            System.out.println("Powerful winds begin to tear through the area snapping small tree branches and sending loose debris skipping across the ground.\n" +
                    "Poorly built fences begin to break as the funnel cloud churns across the landscape.");
        }else if(category <= 3){
            utilityMethod.printBanner("Category " + getCategory() + " Tornado Is Causing Destruction");
            System.out.println("The intensifying tornado tears through the area ripping shingles from rooftops and snapping large tree branches.\n" +
                    "Fences and outbuildings are destroyed as the powerful winds push through neighborhoods\n" +
                    "leaving a trail of damage and debris scattered across streets and yards.");
        }else if(category <= 5) {
            utilityMethod.printBanner("Category " + getCategory() + " Tornado Is Causing Destruction");
            System.out.println("The powerful tornado rips through neighborhoods destroying the upper floors of sturdy buildings and hurling large debris across great distances.\n" +
                    "Trees are completely uprooted and roads are buried under heavy rubble as the swirling tornado pushes forward.");
        }//end of if/if-else statement

    }//end of causeDisaster method


    /* Implementation of the Overridden calculateDamages() method Calculates total Tornado damage by converting
    severityLevel and category to decimal multipliers and applying them against the base estimated cost of damages
     */
    @Override
    public double calculateDamages(){
        //Implementing the NumberFormat class to use to format currency to two decimal places
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        //Implementing UtilityMethod class to use printBanner method
        UtilityMethod utilityMethod = new UtilityMethod();

        double totalCostOfDamages = 0;
        //down casting severityLevel and category to a double then converting to percentage to be used in calculation
        double severityPercentage = (double) getSeverityLevel() / 10;
        double categoryPercentage = (double) getCategory() / 5;

        //formula used to calculate totalCostOfDamages
        totalCostOfDamages = getEstimatedCostOfDamages() + (getEstimatedCostOfDamages() * severityPercentage) + (getEstimatedCostOfDamages() * categoryPercentage);


        //printing message for how much the totalCostOfDamages are for the disaster
        utilityMethod.printBanner("Calculating Total Cost Of Damages");
        System.out.println("After Tornado has wreaked havoc on " + getLocation() + " the total cost of damages is: " + curr.format(totalCostOfDamages));

        //returning totalCostOfDamages
        return totalCostOfDamages;
    }//end of calculateDamages method

    @Override
    public String toString() {
      String myReturn = super.toString();
      myReturn += "Category: EF-" + getCategory() + "/5\n";
      myReturn += "Wind Speed: " + getWindSpeed() + " mph\n";
      return myReturn;
    }
}
