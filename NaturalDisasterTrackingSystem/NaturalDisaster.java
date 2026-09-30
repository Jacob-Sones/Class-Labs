/*
 * NaturalDisaster.java
 * Author: Jacob Sones
 * Date: May 3, 2026
 *
 * Abstract base class representing a natural disaster in the NaturalDisasterTrackingSystem.
 * This class serves as the foundation of the inheritance hierarchy, defining shared attributes
 * and behaviors that all disaster types inherit. It holds a reference to a DisasterState object
 * as part of the State design pattern, allowing each disaster to dynamically change behavior
 * based on its current state. Abstract methods causeDisaster() and calculateDamages() enforce
 * unique implementations in each subclass, demonstrating polymorphism throughout the system.
 */
package NaturalDisasterTrackingSystem;
import java.text.NumberFormat;

public abstract class NaturalDisaster {

    /*declaring a private member variable for the abstract NaturalDisaster base class
     to be inherited by subclasses of NaturalDisaster
     */
    private int severityLevel; //severity level used to determine how impactful a disaster is set to 1-10

    private int affectedPopulation;//how many people are effected by the natural disaster

    private double estimatedCostOfDamages;//initial cost of estimated damages

    private String name;//name given to natural disaster

    private String location;//location of where natural disaster is occurring

    private DisasterType disasterType;//enum of which natural disaster is set for the subclass ie FLOOD,EARTHQUAKE, and TORNADO

    private DisasterState currentState;//used to determine the current state of the natural disaster ie MonitoringState, ActiveState, CriticalState, and ResolvedState


    /*Implementation of a default constructor to assign base values to private member variables
    if none are given on initialization of new objects
     */
    public NaturalDisaster(){
        this.severityLevel = 0;
        this.affectedPopulation = 0;
        this.estimatedCostOfDamages = 0.0;
        this.name = "Unknown";
        this.location = "Unknown";
        this.disasterType = null;
        this.currentState = null;

    }//end of default constructor


    /*Implementation of the parameterized constructor, assigning values passed in the parameters
     to private member variables using setters with built-in validation checks
     */
    public NaturalDisaster(int severityLevel, int affectedPopulation, double estimatedCostOfDamages, String name, String location, DisasterType disasterType, DisasterState currentState) {
      setSeverityLevel(severityLevel);
      setAffectedPopulation(affectedPopulation);
      setEstimatedCostOfDamages(estimatedCostOfDamages);
      setName(name);
      setLocation(location);
      setDisasterType(disasterType);
      setCurrentState(currentState);
    }//end of parameterized constructor


    //Implementation of the copy constructor to take an existing object of the NaturalDisaster class and create a new object
    public NaturalDisaster(NaturalDisaster disasterCopy){
        this.severityLevel = disasterCopy.getSeverityLevel();
        this.affectedPopulation = disasterCopy.getAffectedPopulation();
        this.estimatedCostOfDamages = disasterCopy.getEstimatedCostOfDamages();
        this.name = disasterCopy.getName();
        this.location = disasterCopy.getLocation();
        this.disasterType = disasterCopy.getDisasterType();
        this.currentState = disasterCopy.getCurrentState();
    }//end of copy constructor


    /*Implementation of getters and setters with built-in validation to check that attributes are not set to invalid date
          validation, including:
          severityLevel is not negative or greater than 10,
          affectedPopulation and estimatedCostOfDamages are not negative, name and location are not null or empty,
          as well as DisasterType and currentState are not null
         */
    public int getSeverityLevel() {
        return severityLevel;
    }//end of getSeverityLevel

    public void setSeverityLevel(int severityLevel) {
        if(severityLevel < 0 ){
            throw new RuntimeException("Error: An error has occurred Severity Level can not be set to a negative number");
        }else if(severityLevel > 10){
            throw new RuntimeException("Error: An Error has occurred Severity Level can not be greater then 10");
        }else {
            this.severityLevel = severityLevel;
        }//end of if/if-else statement

    }//end of setSeverityLevel

    public int getAffectedPopulation() {
        return affectedPopulation;
    }//end of getEffectedPopulation

    public void setAffectedPopulation(int affectedPopulation) {
        if(affectedPopulation < 0){
            throw new RuntimeException("Error: An error has occurred Effected Population cannot be negative");
        }else {
            this.affectedPopulation = affectedPopulation;
        }//end of if-else statement

    }//end of setEffectedPopulation

    public double getEstimatedCostOfDamages() {
        return estimatedCostOfDamages;
    }//end of getCostOfDamages

    public void setEstimatedCostOfDamages(double costOfDamages) {
       if(costOfDamages < 0){
           throw new RuntimeException("Error: An error has occurred Estimated Cost Of Damages cannot be a negative number");
       }else {
           this.estimatedCostOfDamages = costOfDamages;
       }//end of if-else statement

    }//end of setCostOfDamages

    public String getName() {
        return name;
    }//end of getName

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new RuntimeException("Error: An error has occurred natural disasters name cannot be empty");
        }else {
            this.name = name;
        }//end of if-else statement

    }//end of setName

    public String getLocation() {
        return location;
    }//end of getLocation

    public void setLocation(String location) {
        if(location == null || location.trim().isEmpty()){
            throw new RuntimeException("Error: An error has occurred Location of natural disaster cannot be empty");
        }else {
            this.location = location;
        }//end of if-else statement

    }//end of setLocation

    public DisasterType getDisasterType() {
        return disasterType;
    }//end of getDisasterType

    /*Implementation of getStateName() checks the instanceof the currentState object and returns
    a readable String name instead of a memory address reference when displaying the state.
     */
    public String getStateName() {
        if (currentState instanceof MonitoringState) {
            return "Monitoring";
        } else if (currentState instanceof ActiveState) {
            return "Active";
        } else if (currentState instanceof CriticalState) {
            return "Critical";
        } else if (currentState instanceof ResolvedState) {
            return "Resolved";
        } else {
            return "Unknown";
        }
    }

    public void setDisasterType(DisasterType disasterType) {
        if(disasterType == null){
            throw new RuntimeException("Error: An error has occurred Disaster Type cannot be null");
        }else {
            this.disasterType = disasterType;
        }//end of if-else statement

    }//end of setDisasterType

    public DisasterState getCurrentState() {
        return currentState;
    }//end of getCurrentState

    public void setCurrentState(DisasterState currentState) {
        if(currentState == null){
            throw new RuntimeException("Error: An error has occurred Current State of natural disaster cannot be null");
        }else {
            this.currentState = currentState;
        }//end of if-else statement

    }//end of setCurrentState

    /*Declaring abstract method causeDisaster() and calculateDamages for extended subclasses
     to be forced to implement/define unique subclass-specific logic for both methods
     */
    public abstract void causeDisaster();

    public abstract double calculateDamages();

    /*Implementation of the executeCurrentState() method, which delegates to the currentState doAction() method,
     passing "this" so the state can check the disaster type and execute its unique behavior
     */
    public void executeCurrentState(){
        currentState.doAction(this);
    }//end of executeCurrentState


    //implementation of toString to return a neatly formatted String of info for the NaturalDisaster base class
    @Override
    public String toString() {
        //Implementing the NumberFormat class to use to format currency to two decimal places
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        //Implementing UtilityMethod class to use printBanner method
        UtilityMethod utilityMethod = new UtilityMethod();

        String myReturn = utilityMethod.printBanner("Natural Disaster Info");
               myReturn +="Natural Disaster Type: " + getDisasterType() + "\n";
               myReturn +="Disasters Name: " + getName() + "\n";
               myReturn +="Location Of Disaster: " + getLocation() + "\n";
               myReturn +="Affected Population: " + getAffectedPopulation() + "\n";
               myReturn +="Disaster State: " + getStateName() + "\n";
               myReturn +="Severity Level: " + getSeverityLevel() + "/10\n";
               myReturn +="Estimated Cost Of Damages: " + curr.format(getEstimatedCostOfDamages()) + "\n";
               return myReturn;
    }//end of toString





}
