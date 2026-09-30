/*
 * EmergencyServices.java
 * Author: Jacob Sones
 * Date: May 6, 2026
 *
 * Concrete implementation of the DisasterObserver interface representing
 * an emergency response organization subscribed to the NaturalDisasterTrackingSystem.
 * Maintains a serviceType field identifying the type of service and a location
 * field indicating where the service is based. Implements the update() method
 * to generate operational response messages focused on resource deployment,
 * rescue coordination, and infrastructure recovery using a switch statement
 * to check the disaster type and a nested switch to check the current state,
 * producing unique operational output for each combination of disaster type
 * and state. Participates in the Observer pattern as one of three concrete
 * observer types managed by the NaturalDisasterStation's ArrayList of
 * DisasterObserver references.
 */
package NaturalDisasterTrackingSystem.NaturalDisasterTrackingSystem;

public class EmergencyServices implements DisasterObserver{

    //Declaring a private member attribute serviceType and location for the EmergencyService class
    private String serviceType;
    private String location;


    /*Implementation of a default constructor to assign base values to private member variables
     if none are given on initialization of new objects
     */
    public EmergencyServices() {
        this.serviceType = "Unknown";
        this.location = "Unknown";
    }//end of default constructor


    /*Implementation of the parameterized constructor, assigning values passed in the parameters
    to private member variables using setters with built-in validation checks
    */
    public EmergencyServices(String serviceType, String location) {
        setServiceType(serviceType);
        setLocation(location);
    }//end of parameterized constructor


    /*Implementation of the copy constructor to take an existing object of the EmergencyServices class
    and create a new object with identical attributes
    */
    public EmergencyServices(EmergencyServices emergencyServicesCopy){
        this.serviceType = emergencyServicesCopy.getServiceType();
        this.location = emergencyServicesCopy.getLocation();

    }//end of copy constructor


    /*Implementation of getters and setters with built-in validation to check that serviceType
        and location are not null or empty
         */
    public String getServiceType() {
        return serviceType;
    }//end of getServiceType


    public void setServiceType(String serviceType) {
       if(serviceType == null || serviceType.trim().isEmpty()){
           throw new RuntimeException("Error: An error has occurred Service Type cannot be null or empty");
       }else{
           this.serviceType = serviceType;
       }//end of if-else statement

    }//end of setServiceType

    public String getLocation() {
        return location;
    }//end of getLocation

    public void setLocation(String location) {
       if(location == null || location.trim().isEmpty()){
           throw new RuntimeException("Error: An error has occurred Location cannot be null or empty");
       }else {
           this.location = location;
       }//end of if-else statement

    }//end of setLocation



    /*Implementation of the update() method for the Emergency Services observer class.
    This method receives a NaturalDisaster object and determines the type of disaster
    Flood, Earthquake, or Tornado using a switch statement.
    It then uses the findDisasterState() method from the UtilityMethods class to
    determine the current disaster state Monitoring, Active, Critical, or Resolved.
    A nested switch statement is used to generate operational response messages focused on
    emergency coordination, resource deployment, rescue operations, and recovery efforts.
    */
    @Override
    public void update(NaturalDisaster naturalDisaster){

        //Utility class used to print banners and determine disaster state
        UtilityMethod utilityMethod = new UtilityMethod();

        //Gets the current disaster state 1-4 from the UtilityMethod class
        int currentDisasterState = utilityMethod.findDisasterState(naturalDisaster);

        //Switch statement checking the type of disaster Flood, Earthquake, Tornado
        switch(naturalDisaster.getDisasterType()){

            case FLOOD:

                //Nested switch statement checking the current flood state
                switch (currentDisasterState){

                    //Monitoring Flood state case
                    case 1:
                        utilityMethod.printBanner("EMERGENCY SERVICES FLOOD MONITORING");
                        System.out.println("Flood monitoring initiated in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Monitoring\n" +
                                "Hydrology teams are tracking rainfall and river levels for early warning signs.\n" +
                                "Response units are placed on standby and evacuation routes are being reviewed.");
                        break;//end of Monitoring Flood state case

                    //Active Flood state case
                    case 2:
                        utilityMethod.printBanner("EMERGENCY SERVICES FLOOD RESPONSE ACTIVE");
                        System.out.println("Flood response activated in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Active\n" +
                                "Emergency units deployed with high-water rescue vehicles and evacuation support.\n" +
                                "Command centers are coordinating real-time field operations and road closures.");
                        break;//end of Active Flood state case

                    //Critical Flood state case
                    case 3:
                        utilityMethod.printBanner("EMERGENCY SERVICES FLOOD CRITICAL RESPONSE");
                        System.out.println("CRITICAL flood emergency in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Critical\n" +
                                "Mass flooding has created life-threatening conditions across multiple zones.\n" +
                                "Search and rescue operations are fully active with emergency medical deployment.");
                        break;//end of Critical Flood state case

                    //Resolved Flood state case
                    case 4:
                        utilityMethod.printBanner("EMERGENCY SERVICES FLOOD RECOVERY");
                        System.out.println("Flood emergency resolved in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Resolved\n" +
                                "Search, recovery, and infrastructure repair operations are underway.\n" +
                                "Damage assessments are being conducted across affected regions.");
                        break;//end of Resolved Flood state case

                    //Default Flood state case
                    default:
                        System.out.println("No active flood response required in " + naturalDisaster.getLocation() + " area at this time.");
                        break;//end of Default Flood state case

                }//end of nested switch statement for Flood

                break;//end of Flood disaster case

            case EARTHQUAKE:

                //Nested switch statement checking the current earthquake state
                switch (currentDisasterState){

                    //Monitoring Earthquake state case
                    case 1:
                        utilityMethod.printBanner("EMERGENCY SERVICES EARTHQUAKE MONITORING");
                        System.out.println("Seismic monitoring active in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Monitoring\n" +
                                "Geological sensors are tracking minor tremors and fault activity.\n" +
                                "Emergency teams remain on standby for rapid deployment if conditions escalate.");
                        break;//end of Monitoring Earthquake state case

                    //Active Earthquake state case
                    case 2:
                        utilityMethod.printBanner("EMERGENCY SERVICES EARTHQUAKE RESPONSE ACTIVE");
                        System.out.println("Earthquake response activated in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Active\n" +
                                "Search and rescue units deployed for structural assessment and victim assistance.\n" +
                                "Medical teams are mobilized and emergency shelters are being activated.");
                        break;//end of Active Earthquake state case

                    //Critical Earthquake state case
                    case 3:
                        utilityMethod.printBanner("EMERGENCY SERVICES EARTHQUAKE CRITICAL RESPONSE");
                        System.out.println("CRITICAL earthquake impact in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Critical\n" +
                                "Widespread structural collapse reported across multiple zones.\n" +
                                "Large-scale rescue operations and medical triage centers are fully active.");
                        break;//end of Critical Earthquake state case

                    //Resolved Earthquake state case
                    case 4:
                        utilityMethod.printBanner("EMERGENCY SERVICES EARTHQUAKE RECOVERY");
                        System.out.println("Earthquake situation stabilized in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Resolved\n" +
                                "Aftershock monitoring continues while recovery teams assess damage.\n" +
                                "Infrastructure restoration and cleanup operations are underway.");
                        break;//end of Resolved Earthquake state case

                    //Default Earthquake state case
                    default:
                        System.out.println("No active earthquake response required in " + naturalDisaster.getLocation() + " area at this time.");
                        break;//end of Default Earthquake state case

                }//end of nested switch statement for Earthquake

                break;//end of Earthquake disaster case

            case TORNADO:

                //Nested switch statement checking the current tornado state
                switch (currentDisasterState){

                    //Monitoring Tornado state case
                    case 1:
                        utilityMethod.printBanner("EMERGENCY SERVICES TORNADO MONITORING");
                        System.out.println("Tornado monitoring initiated in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Monitoring\n" +
                                "Meteorological teams are tracking storm development and atmospheric instability.\n" +
                                "Emergency shelters are placed on readiness standby.");
                        break;//end of Monitoring Tornado state case

                    //Active Tornado state case
                    case 2:
                        utilityMethod.printBanner("EMERGENCY SERVICES TORNADO RESPONSE ACTIVE");
                        System.out.println("Tornado confirmed in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Active\n" +
                                "Emergency response units deployed for evacuation enforcement and rescue support.\n" +
                                "Command centers are coordinating live updates from field operations.");
                        break;//end of Active Tornado state case

                    //Critical Tornado state case
                    case 3:
                        utilityMethod.printBanner("EMERGENCY SERVICES TORNADO CRITICAL RESPONSE");
                        System.out.println("CRITICAL tornado impact in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Critical\n" +
                                "Severe destruction reported across multiple zones with structural collapse.\n" +
                                "Mass casualty response teams and emergency medical units are deployed.");
                        break;//end of Critical Tornado state case

                    //Resolved Tornado state case
                    case 4:
                        utilityMethod.printBanner("EMERGENCY SERVICES TORNADO RECOVERY");
                        System.out.println("Tornado emergency resolved in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Resolved\n" +
                                "Damage assessment and debris removal operations are ongoing.\n" +
                                "Infrastructure restoration efforts are underway.");
                        break;//end of Resolved Tornado state case

                    //Default Tornado state case
                    default:
                        System.out.println("No active tornado response required in " + naturalDisaster.getLocation() + " area at this time.");
                        break;//end of Default Tornado state case

                }//end of nested switch statement for Tornado

                break;//end of Tornado disaster case

        }//end of disaster type switch
    }//end of the update() method

    /*
     * Returns the name of the Emergency Service observer, used by the NaturalDisasterStation
     * to identify this observer in the tracked observer list.
     */
    @Override
    public String getObserverName(){
        //returning the service name to identify this observer
        return serviceType;
    }


    @Override
    public String toString() {
       UtilityMethod utilityMethod = new UtilityMethod();

       String myReturn = utilityMethod.printBanner("Emergency Service Info");
              myReturn += "Service Type: " + getServiceType() + "\n";
              myReturn += "Location: " + getLocation() + "\n";
              return myReturn;

    }//end of toString
}
