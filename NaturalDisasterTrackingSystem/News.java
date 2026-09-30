/*
 * News.java
 * Author: Jacob Sones
 * Date: May 6, 2026
 *
 * Concrete implementation of the DisasterObserver interface representing
 * media broadcast stations. This class focuses on public communication and
 * status reporting. It implements the update() method to deliver breaking
 * news updates and weather alerts to the general public. By participating
 * in the Observer pattern, it receives automated updates from the
 * NaturalDisasterStation, allowing it to transition its reporting instantly
 * as a disaster evolves from a Watch (Monitoring) to an Emergency (Critical).
 */
package NaturalDisasterTrackingSystem;

public class News implements DisasterObserver{

    //Declaring a private member attribute stationName for the news class
    private String stationName;


    /*Implementation of a default constructor to assign base values to private member variable if
    none are given on initialization of new objects
     */
    public News() {
        this.stationName = "Unknown";
    }//end of default constructor


    /*Implementation of the parameterized constructor, assigning values passed in the parameters
    to private member variables using setters with built-in validation checks
     */
    public News(String stationName) {
        setStationName(stationName);
    }//end of parameterized constructor


    /*Implementation of the copy constructor to take an existing object of the news class
    and create a new object with identical attributes
     */
    public News(News newsCopy){
        this.stationName = newsCopy.getStationName();
    }//end of copy constructor


    //Implementation of getters and setters with built-in validation to check that stationName is not null or empty
    public String getStationName() {
        return stationName;
    }//end of getStationName

    public void setStationName(String stationName) {

       if(stationName == null || stationName.trim().isEmpty()){
           throw new RuntimeException("Error: An error has occurred Station Name cannot be null or empty");
       }else {
           this.stationName = stationName;
       }//end of if-else statement

    }//end of setStationName

   /*Implementation of the update() method for the News observer class.
    This method receives a NaturalDisaster object and determines the type of disaster
    Flood, Earthquake, or Tornado using a switch statement.
    It then uses the findDisasterState() method from the UtilityMethods class to
    determine the current disaster state Monitoring, Active, Critical, or Resolved.
    A nested switch statement is used to generate public-facing news updates that communicate
    the current disaster status and provide clear, informative safety information to the public.
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
                        utilityMethod.printBanner("NEWS FLOOD WATCH REPORT");
                        System.out.println("Breaking News: Flood watch issued for " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Monitoring\n" +
                                "Meteorologists report rising water levels and potential flood development.\n" +
                                "Residents are advised to stay alert and monitor official updates.");
                        break;//end of Monitoring Flood state case

                    //Active Flood state case
                    case 2:
                        utilityMethod.printBanner("NEWS FLOOD WARNING UPDATE");
                        System.out.println("Breaking News: Active flooding reported in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Active\n" +
                                "Floodwaters are impacting roads, homes, and infrastructure across multiple zones.\n" +
                                "Emergency officials urge immediate evacuation from high-risk areas.");
                        break;//end of Active Flood state case

                    //Critical Flood state case
                    case 3:
                        utilityMethod.printBanner("NEWS FLOOD EMERGENCY ALERT");
                        System.out.println("URGENT: Severe flooding crisis in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Critical\n" +
                                "Life-threatening conditions reported as water levels continue to rise rapidly.\n" +
                                "Authorities confirm large-scale evacuations and emergency rescue operations.");
                        break;//end of Critical Flood state case

                    //Resolved Flood state case
                    case 4:
                        utilityMethod.printBanner("NEWS FLOOD RECOVERY UPDATE");
                        System.out.println("Update: Flood conditions in " + naturalDisaster.getLocation() + " area have stabilized.\n" +
                                "Status: Resolved\n" +
                                "Officials report the immediate threat has passed and recovery efforts are underway.\n" +
                                "Residents are cautioned about lingering hazards in affected areas.");
                        break;//end of Resolved Flood state case

                    //Default Flood state case
                    default:
                        System.out.println("No active flood updates available for " + naturalDisaster.getLocation() + " area at this time.");
                        break;//end of Default Flood state case

                }//end of nested switch statement for Flood

                break;//end of Flood disaster case

            case DisasterType.EARTHQUAKE:

                //Nested switch statement checking the current earthquake state
                switch (currentDisasterState){

                    //Monitoring Earthquake state case
                    case 1:
                        utilityMethod.printBanner("NEWS EARTHQUAKE WATCH");
                        System.out.println("Breaking News: Seismic activity detected near " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Monitoring\n" +
                                "Experts are tracking minor tremors with no major damage reported.\n" +
                                "Residents are encouraged to stay informed and prepared.");
                        break;//end of Monitoring Earthquake state case

                    //Active Earthquake state case
                    case 2:
                        utilityMethod.printBanner("NEWS EARTHQUAKE ALERT");
                        System.out.println("Breaking News: Earthquake activity reported in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Active\n" +
                                "Strong shaking reported across multiple regions with ongoing assessments.\n" +
                                "Authorities advise avoiding damaged buildings and unstable structures.");
                        break;//end of Active Earthquake state case

                    //Critical Earthquake state case
                    case 3:
                        utilityMethod.printBanner("NEWS EARTHQUAKE EMERGENCY");
                        System.out.println("URGENT: Major earthquake impacts " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Critical\n" +
                                "Widespread structural damage confirmed with emergency response underway.\n" +
                                "Officials warn of aftershocks and continued safety risks.");
                        break;//end of Critical Earthquake state case

                    //Resolved Earthquake state case
                    case 4:
                        utilityMethod.printBanner("NEWS EARTHQUAKE RECOVERY UPDATE");
                        System.out.println("Update: Earthquake event in " + naturalDisaster.getLocation() + " area has stabilized.\n" +
                                "Status: Resolved\n" +
                                "Recovery operations continue while aftershock monitoring remains active.\n" +
                                "Infrastructure repairs and damage assessments are in progress.");
                        break;//end of Resolved Earthquake state case

                    //Default Earthquake state case
                    default:
                        System.out.println("No active earthquake updates available for " + naturalDisaster.getLocation() + " area at this time.");
                        break;//end of Default Earthquake state case

                }//end of nested switch statement for Earthquake

                break;//end of Earthquake disaster case

            case DisasterType.TORNADO:

                //Nested switch statement checking the current tornado state
                switch (currentDisasterState){

                    //Monitoring Tornado state case
                    case 1:
                        utilityMethod.printBanner("NEWS TORNADO WATCH");
                        System.out.println("Weather Alert: Tornado conditions possible in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Monitoring\n" +
                                "Storm systems are developing with potential for severe weather activity.\n" +
                                "Residents are advised to remain alert and follow weather updates.");
                        break;//end of Monitoring Tornado state case

                    //Active Tornado state case
                    case 2:
                        utilityMethod.printBanner("NEWS TORNADO WARNING");
                        System.out.println("Breaking News: Tornado confirmed in " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Active\n" +
                                "Severe storm activity is impacting populated regions with urgent warnings issued.\n" +
                                "Authorities instruct residents to seek immediate shelter.");
                        break;//end of Active Tornado state case

                    //Critical Tornado state case
                    case 3:
                        utilityMethod.printBanner("NEWS TORNADO EMERGENCY");
                        System.out.println("URGENT: Violent tornado impacts " + naturalDisaster.getLocation() + " area.\n" +
                                "Status: Critical\n" +
                                "Severe destruction reported with emergency services responding to multiple zones.\n" +
                                "Officials warn residents to remain sheltered due to ongoing danger.");
                        break;//end of Critical Tornado state case

                    //Resolved Tornado state case
                    case 4:
                        utilityMethod.printBanner("NEWS TORNADO RECOVERY UPDATE");
                        System.out.println("Update: Tornado event in " + naturalDisaster.getLocation() + " area has ended.\n" +
                                "Status: Resolved\n" +
                                "Damage assessments and recovery operations are currently underway.\n" +
                                "Residents are advised to avoid debris and hazardous areas.");
                        break;//end of Resolved Tornado state case

                    //Default Tornado state case
                    default:
                        System.out.println("No active tornado updates available for " + naturalDisaster.getLocation() + " area at this time.");
                        break;//end of Default Tornado state case

                }//end of nested switch statement for Tornado

                break;//end of Tornado disaster case

        }//end of disaster type switch
    }//end of the update() method

    //Implementation of toString to return a neatly formatted String of info for the news class
    @Override
    public String toString() {
       UtilityMethod utilityMethod = new UtilityMethod();

        String myReturn = utilityMethod.printBanner("News Station Info");
               myReturn += "Station Name: " + getStationName();
        return myReturn;
    }//end of toString method
}
