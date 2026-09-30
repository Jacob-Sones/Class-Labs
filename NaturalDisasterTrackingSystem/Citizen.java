/*
 * Citizen.java
 * Author: Jacob Sones
 * Date: May 6, 2026
 *
 * Concrete implementation of the DisasterObserver interface representing an
 * individual resident in the tracking system. This class maintains personal
 * data including name, location, and validated phone numbers. It implements
 * the update() method to provide citizen-specific safety alerts and
 * recommended actions based on the current state of a disaster Monitoring,
 * Active, Critical, or Resolved. It functions as a subscriber within the
 * Observer pattern, managed by the NaturalDisasterStation's ArrayList.
 */
package NaturalDisasterTrackingSystem;


public class Citizen implements DisasterObserver{

    //Declaring a private member attribute name,location, and phoneNumber for the Citizen class
    private String name;
    private String location;
    private String phoneNumber;

    /*Implementation of a default constructor to assign base values to private member variable if
      none are given on initialization of new objects
     */
    public Citizen() {
        this.name = "Unknown";
        this.location = "Unknown";
        this.phoneNumber = "Unknown";
    }//end of default constructor


    /*Implementation of the parameterized constructor, assigning values passed in the parameters
    to private member variables using setters with built-in validation checks
     */
    public Citizen(String name, String location, String phoneNumber) {
     setName(name);
     setLocation(location);
     setPhoneNumber(phoneNumber);
    }//end of parameterized constructor


    /*Implementation of the copy constructor to take an existing object of the Citizen class
   and create a new object with identical attributes
    */
    public Citizen(Citizen citizenCopy){
        this.name = citizenCopy.getName();
        this.location = citizenCopy.getLocation();
        this.phoneNumber = citizenCopy.getPhoneNumber();
    }//end of the copy constructor


    /*Implementation of getters and setters with built-in validation to check that name, location, and phoneNumber
         are not null or empty, and phoneNumber is set to numeric values between 0-9 and is exactly 10 digits long
         */
    public String getName() {
        return name;
    }//end of getName

    public void setName(String name) {
      if(name == null || name.trim().isEmpty()){
          throw new RuntimeException("Error: An error has occurred Name cannot be null or empty");
      }else {
          this.name = name;
      }//end of if-else statement

    }//end of setName

    public String getLocation() {
        return location;
    }//end of getLocation

    public void setLocation(String location) {
        if(location == null || location.trim().isEmpty()){
            throw new RuntimeException("Error: An error has occurred Location cannot be set to null or empty");
        }else {
            this.location = location;
        }//end of if-else statement

    }//end of setLocation

    public String getPhoneNumber() {
        return phoneNumber;
    }//end of getPhoneNumber

    public void setPhoneNumber(String phoneNumber) {
       if(phoneNumber == null || phoneNumber.trim().isEmpty()){
           throw new RuntimeException("Error: An error has occurred Phone Number cannot be null or empty");
       }else if(!phoneNumber.matches("[0-9]{10}")){
           throw new RuntimeException("Error: An error has occurred Phone Number must be 10 digits long");
       }else {
           this.phoneNumber = phoneNumber;
       }//end of if/if-else statement

    }//end of setPhoneNumber



    /*Implementation of the update() method for the Citizen observer class.
    This method receives a NaturalDisaster object and determines the type of disaster
    Flood, Earthquake, or Tornado using a switch statement.
    It then uses the findDisasterState() method from the UtilityMethods class to
    determine the current disaster state Monitoring, Active, Critical, or Resolved.
    A nested switch statement is used to output citizen-focused alerts that provide
    recommended safety actions based on the severity of the disaster.
    */
    @Override
    public void update(NaturalDisaster naturalDisaster){

        //Utility class used to print banners and determine disaster state
        UtilityMethod utilityMethod = new UtilityMethod();

        //Gets the current disaster state 1-4 from the UtilityMethod class
        int currentDisasterState = utilityMethod.findDisasterState(naturalDisaster);

        //Switch statement checking the type of disaster Flood, Earthquake, Tornado
        switch(naturalDisaster.getDisasterType()){

            case DisasterType.FLOOD:

                //Nested switch statement checking the current flood state
                switch (currentDisasterState){

                    //Monitoring Flood state case
                    case 1:
                        utilityMethod.printBanner("CITIZEN FLOOD MONITORING ALERT");
                        System.out.println("Flood watch issued for " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Monitoring\n" +
                                "Water levels are beginning to rise in your area.\n" +
                                "Stay informed, avoid low-lying areas, and prepare an emergency kit.");
                        break;//end of Monitoring Flood state case

                    //Active Flood state case
                    case 2:
                        utilityMethod.printBanner("CITIZEN ACTIVE FLOOD ALERT");
                        System.out.println("Flood warning issued for " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Active\n" +
                                "Flooding is occurring in your area. Move to higher ground immediately.\n" +
                                "Avoid driving or walking through flooded roads and follow evacuation orders.");
                        break;//end of Active Flood state case

                    //Critical Flood state case
                    case 3:
                        utilityMethod.printBanner("CITIZEN CRITICAL FLOOD ALERT");
                        System.out.println("Flood emergency in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Critical\n" +
                                "Life-threatening flooding conditions are present in your area.\n" +
                                "Evacuate immediately if you have not done so and avoid all flood waters.");
                        break;//end of Critical Flood state case

                    //Resolved Flood state case
                    case 4:
                        utilityMethod.printBanner("CITIZEN FLOOD RESOLVED ALERT");
                        System.out.println("Flood conditions have been resolved in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Resolved\n" +
                                "The immediate threat has passed, but hazards may still exist.\n" +
                                "Avoid damaged areas and wait for official clearance before returning.");
                        break;//end of Resolved Flood state case

                    //Default Flood state case
                    default:
                        System.out.println("No active flood alert for " + naturalDisaster.getLocation() + " area at this time.");
                        break;//end of Default Flood state case

                }//end of nested switch statement for Flood

                break;//end of Flood disaster case

            case DisasterType.EARTHQUAKE:

                //Nested switch statement checking the current earthquake state
                switch (currentDisasterState){

                    //Monitoring Earthquake state case
                    case 1:
                        utilityMethod.printBanner("CITIZEN EARTHQUAKE MONITORING ALERT");
                        System.out.println("Earthquake watch issued for " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Monitoring\n" +
                                "Minor seismic activity detected in your area.\n" +
                                "Secure heavy objects and identify safe shelter locations indoors.");
                        break;//end of Monitoring Earthquake state case

                    //Active Earthquake state case
                    case 2:
                        utilityMethod.printBanner("CITIZEN ACTIVE EARTHQUAKE ALERT");
                        System.out.println("Earthquake warning for " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Active\n" +
                                "Seismic activity is occurring in your area.\n" +
                                "Drop, cover, and hold on. Stay away from windows and exterior walls.");
                        break;//end of Active Earthquake state case

                    //Critical Earthquake state case
                    case 3:
                        utilityMethod.printBanner("CITIZEN CRITICAL EARTHQUAKE ALERT");
                        System.out.println("Earthquake emergency in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Critical\n" +
                                "Severe earthquake activity is occurring in your area.\n" +
                                "Take immediate cover and avoid moving until shaking stops.");
                        break;//end of Critical Earthquake state case

                    //Resolved Earthquake state case
                    case 4:
                        utilityMethod.printBanner("CITIZEN EARTHQUAKE RESOLVED ALERT");
                        System.out.println("Earthquake conditions have stabilized in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Resolved\n" +
                                "Be cautious of aftershocks and inspect your surroundings for damage.\n" +
                                "Avoid damaged buildings and unstable structures.");
                        break;//end of Resolved Earthquake state case

                    //Default Earthquake state case
                    default:
                        System.out.println("No active earthquake alert for " + naturalDisaster.getLocation() + " area at this time.");
                        break;//end of Default Earthquake state case

                }//end of nested switch statement for Earthquake

                break;//end of Earthquake disaster case

            case DisasterType.TORNADO:

                //Nested switch statement checking the current tornado state
                switch (currentDisasterState){

                    //Monitoring Tornado state case
                    case 1:
                        utilityMethod.printBanner("CITIZEN TORNADO MONITORING ALERT");
                        System.out.println("Tornado watch issued for " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Monitoring\n" +
                                "Conditions are favorable for tornado development in your area.\n" +
                                "Stay alert and identify a safe interior shelter location.");
                        break;//end of Monitoring Tornado state case

                    //Active Tornado state case
                    case 2:
                        utilityMethod.printBanner("CITIZEN ACTIVE TORNADO ALERT");
                        System.out.println("Tornado warning issued for " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Active\n" +
                                "A tornado has been confirmed in your area.\n" +
                                "Move immediately to a basement or interior room away from windows.");
                        break;//end of Active Tornado state case

                    //Critical Tornado state case
                    case 3:
                        utilityMethod.printBanner("CITIZEN CRITICAL TORNADO ALERT");
                        System.out.println("Tornado emergency in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Critical\n" +
                                "A violent tornado is impacting your area.\n" +
                                "Take shelter immediately and protect your head and neck.");
                        break;//end of Critical Tornado state case

                    //Resolved Tornado state case
                    case 4:
                        utilityMethod.printBanner("CITIZEN TORNADO RESOLVED ALERT");
                        System.out.println("Tornado conditions have cleared in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Resolved\n" +
                                "Remain cautious of debris and damaged structures.\n" +
                                "Do not enter unsafe buildings and wait for official clearance.");
                        break;//end of Resolved Tornado state case

                    //Default Tornado state case
                    default:
                        System.out.println("No active tornado alert for " + naturalDisaster.getLocation() + " area at this time.");
                        break;//end of Default Tornado state case

                }//end of nested switch statement for Tornado

                break;//end of Tornado disaster case

        }//end of disaster type switch
    }//end of the update() method


    //Implementation of toString to return a neatly formatted String of info for the Citizen class
    @Override
    public String toString() {
        UtilityMethod utilityMethod = new UtilityMethod();
        String myReturn = utilityMethod.printBanner("Citizen Info");
               myReturn += "Name: " + getName() + "\n";
               myReturn += "Address: " + getLocation() + "\n";
               myReturn += "Phone Number: " + getPhoneNumber() + "\n";
               return  myReturn;
    }//end of toString method
}
