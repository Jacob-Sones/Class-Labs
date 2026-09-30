/*
 * NaturalDisasterDriver.java
 * Author: Jacob Sones
 * Date: May 7, 2026
 *
 * Main driver class for the NaturalDisasterTrackingSystem. Initializes all
 * required objects including three real world NaturalDisaster subclass objects
 * representing the El Reno Tornado, Hurricane Harvey Floods, and the Haiti
 * Earthquake, all four DisasterState objects, three DisasterObserver objects
 * representing a Citizen, News Station, and EmergencyServices, and the
 * NaturalDisasterStation which manages the observer list. Demonstrates the
 * State design pattern through the ability to update and execute the current
 * state across all tracked disasters, and the Observer design pattern through
 * the ability to notify all subscribed observers with a specific disaster object.
 * Runs a menu driven do-while loop with nested switch statements allowing the
 * user to manage disasters, manage observers, and run simulations that
 * demonstrate polymorphism, inheritance, aggregation, validation, and both
 * design patterns throughout the program.
 */
package NaturalDisasterTrackingSystem.NaturalDisasterTrackingSystem;
import java.util.Scanner;
import java.util.ArrayList;


public class NaturalDisasterDriver {


    static void main() {
        //declaring Utility class to have access to the printBanner() method
        UtilityMethod utilityMethod = new UtilityMethod();
        //declaring a scanner object to gather user input
        Scanner scanner = new Scanner(System.in);


        int choice = 0;


        /*declaring and initializing all four DisasterState objects declared as DisasterState interface references,
        representing each possible state in the disaster lifecycle used by the State design pattern
        */
        DisasterState monitoringState = new MonitoringState();
        DisasterState activeState = new ActiveState();
        DisasterState criticalState = new CriticalState();
        DisasterState resolvedState = new ResolvedState();

        /*declaring NaturalDisaster objects as NaturalDisaster base class references, set to null initially
        so a try-catch can be used to initialize them and handle any validation errors thrown by the constructors
        */
        NaturalDisaster tornado = null;
        NaturalDisaster flood = null;
        NaturalDisaster earthquake = null;

        //initializing the tornado object using the parameterized constructor, passing monitoringState as the initial state, wrapped in a try-catch to handle any constructor validation errors
        try {
            tornado = new Tornado(9, 8000, 9000.0, "El Reno Tornado", "El Reno, Oklahoma", DisasterType.TORNADO, monitoringState, 5, 295.0);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        //initializing the flood object using the parameterized constructor, passing monitoringState as the initial state, wrapped in a try-catch to handle any constructor validation errors
        try {
            flood = new Flood(8, 30000, 12000.0, "Hurricane Harvey Floods", "Houston, Texas", DisasterType.FLOOD, monitoringState, 72);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        //initializing the earthquake object using the parameterized constructor,passing monitoringState as the initial state, wrapped in a try-catch to handle any constructor validation errors
        try {
            earthquake = new Earthquake(9, 230000, 20000.00, "Haiti Earthquake", "Port-au-Prince, Haiti", DisasterType.EARTHQUAKE, monitoringState, 7.0);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        /*declaring and initializing the three observer objects representing the different types of observers
        that can be subscribed to the NaturalDisasterStation to receive disaster notifications
        */
        Citizen citizen = new Citizen("Jacob Sones", "1829 Kings men Drive El Reno, Oklahoma", "2105550101");
        News news = new News("KSAT 12 News");
        EmergencyServices emergency = new EmergencyServices("Fire & Rescue", "Houston, Texas Department 9");

        /*declaring and initializing the NaturalDisasterStation object that manages the observer list
        and handles notifying all subscribed observers when a disaster event occurs
        */
        NaturalDisasterStation station = new NaturalDisasterStation();

        /*declaring and initializing the naturalDisastersList ArrayList declared as a NaturalDisaster base class reference
        to store all tracked disaster objects, demonstrating polymorphism through the base class reference type
        */
        ArrayList<NaturalDisaster> naturalDisastersList = new ArrayList<>();

        //adding all three NaturalDisaster objects to naturalDisastersList to be tracked throughout the program
        naturalDisastersList.add(tornado);
        naturalDisastersList.add(earthquake);
        naturalDisastersList.add(flood);

        /*registering all three observer objects with the NaturalDisasterStation using addObserver(),
        subscribing them to receive disaster notifications demonstrating the Observer design pattern
        */
        station.addObserver(citizen);
        station.addObserver(news);
        station.addObserver(emergency);

        //printing the opening banner to welcome the user to the Natural Disaster Tracking System
        utilityMethod.printBanner("Natural Disaster Tracking System");
        System.out.println();


        //displaying main menu options to the user for valid operations they can execute within the Natural Disaster Tracking System
        do {
            utilityMethod.printBanner("Natural Disaster Main Menu");
            System.out.println("------------------------------");
            System.out.println("1: Manage Natural Disasters  |");
            System.out.println("2: Manage Observers          |");
            System.out.println("3: Run Disaster Simulation   |");
            System.out.println("4: Exit Program              |");
            System.out.println("------------------------------");
            System.out.println("Select:");
            //using scanner to gather user input for main menu selection
            choice = scanner.nextInt();

            /*start of main switch statement evaluating the user's main menu selection,
            4 options: manage disasters, manage observers, run simulation, or exit
            */
            switch (choice) {

                /*start of main case 1 displaying the Manage Natural Disasters sub menu,
                going into a nested switch statement to execute the selected operation
                */
                case 1:
                    utilityMethod.printBanner("Manage Natural Disaster Menu");
                    System.out.println("---------------------------------------------");
                    System.out.println("1: Display All Natural Disasters            |");
                    System.out.println("2: Update Natural Disaster State            |");
                    System.out.println("3: Display Natural Disaster Damage Report   |");
                    System.out.println("---------------------------------------------");
                    System.out.println("Select:");
                    //using scanner to gather user input for Manage Natural Disasters sub menu selection
                    choice = scanner.nextInt();

                    /*start of nested switch statement evaluating the Manage Natural Disasters
                    sub menu selection, 3 options: display all, update state, or damage report
                    */
                    switch (choice) {

                /*start of nested case 1 iterating through naturalDisastersList and displaying
                each disaster's info using the overridden toString() method, demonstrating polymorphism
                */
                        case 1:
                            utilityMethod.printBanner("Displaying All Natural Disasters Being Tracked");
                            //enhanced for loop iterating through each NaturalDisaster and calling its overridden toString() method
                            for (NaturalDisaster disaster : naturalDisastersList) {
                                System.out.println(disaster.toString());
                            }//end of enhanced for loop
                            break;//end of nested case 1

                        /*start of nested case 2 displaying the Update State double nested sub menu,
                        applying the selected DisasterState to all disasters in naturalDisastersList,
                        demonstrating the State design pattern
                        */
                        case 2:
                            utilityMethod.printBanner("Update Natural Disaster State");
                            System.out.println("--------------------------------");
                            System.out.println("1: Update state To Monitoring  |");
                            System.out.println("2: Update State To Active      |");
                            System.out.println("3: Update State To Critical    |");
                            System.out.println("4: Update State To Resolved    |");
                            System.out.println("--------------------------------");
                            System.out.println("Select:");
                            //using scanner to gather user input for the desired state to update all disasters to
                            int tempChoice = scanner.nextInt();

                            /*start of double nested switch statement evaluating the desired state selection
                            and updating all disasters in naturalDisastersList using setCurrentState()
                            */
                            switch (tempChoice) {

                                //double nested case 1 setting all disasters in naturalDisastersList to monitoringState
                                case 1:
                                    System.out.println("Changing all Natural Disasters to Monitoring state");
                                    //enhanced for loop setting each NaturalDisaster's current state to monitoringState
                                    for (NaturalDisaster disaster : naturalDisastersList) {
                                        try {
                                            disaster.setCurrentState(monitoringState);
                                        } catch (RuntimeException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    }//end of enhanced for loop
                                    break;//end of double nested case 1

                                //double nested case 2 setting all disasters in naturalDisastersList to activeState
                                case 2:
                                    System.out.println("Changing all Natural Disasters to Active state");
                                    //enhanced for loop setting each NaturalDisaster's current state to activeState
                                    for (NaturalDisaster disaster : naturalDisastersList) {
                                        try {
                                            disaster.setCurrentState(activeState);
                                        } catch (RuntimeException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    }//end of enhanced for loop
                                    break;//end of double nested case 2

                                //double nested case 3 setting all disasters in naturalDisastersList to criticalState
                                case 3:
                                    System.out.println("Changing all Natural Disasters to Critical state");
                                    //enhanced for loop setting each NaturalDisaster's current state to criticalState
                                    for (NaturalDisaster disaster : naturalDisastersList) {
                                        try {
                                            disaster.setCurrentState(criticalState);
                                        } catch (RuntimeException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    }//end of enhanced for loop
                                    break;//end of double nested case 3

                                //double nested case 4 setting all disasters in naturalDisastersList to resolvedState
                                case 4:
                                    System.out.println("Changing all Natural Disasters to Resolved state");
                                    //enhanced for loop setting each NaturalDisaster's current state to resolvedState
                                    for (NaturalDisaster disaster : naturalDisastersList) {
                                        try {
                                            disaster.setCurrentState(resolvedState);
                                        } catch (RuntimeException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    }//end of enhanced for loop
                                    break;//end of double nested case 4

                                //implementing a double nested default case for any input not in the range of 1-4
                                default:
                                    System.out.println("Error: invalid option chosen please try again and select an option between 1-4");
                                    break;//end of double nested default

                            }//end of double nested switch statement for Update Natural Disaster State
                            break;//end of nested case 2

                            /*start of nested case 3 iterating through naturalDisastersList and calling
                            calculateDamages() on each disaster to display its damage report
                            */
                        case 3:
                            utilityMethod.printBanner("Natural Disaster Damage Report");
                            //enhanced for loop iterating through each NaturalDisaster and calling its overridden calculateDamages() method
                            for (NaturalDisaster disaster : naturalDisastersList) {
                                disaster.calculateDamages();
                            }//end of enhanced for loop
                            break;//end of nested case 3

                        //implementing a nested default case for any input not in the range of 1-3
                        default:
                            System.out.println("Error: invalid option chosen please try again and select an option between 1-3");
                            break;//end of nested default

                    }//end of nested switch statement for Manage Natural Disasters sub menu
                    break;//end of main case 1

                /*start of main case 2 displaying the Manage Observers sub menu,
                going into a nested switch statement to execute the selected observer management operation
                */
                case 2:
                    utilityMethod.printBanner("Manage Observer Menu");
                    System.out.println("----------------------------");
                    System.out.println("1: Display all Observers   |");
                    System.out.println("2: Add Observer            |");
                    System.out.println("3: Remove Observer         |");
                    System.out.println("----------------------------");
                    System.out.println("Select:");
                    //using scanner to gather user input for Manage Observers sub menu selection
                    int tempChoice = scanner.nextInt();

                    /*start of nested switch statement evaluating the Manage Observers sub menu selection,
                    3 options: display all observers, add a new observer, or remove an existing observer
                    */
                    switch (tempChoice) {

                        /*start of nested case 1 calling displayAllObservers() on the station
                        to display all observers currently subscribed
                        */
                        case 1:
                            System.out.println();
                            station.displayAllObservers();
                            break;//end of nested case 1

                        /*start of nested case 2 displaying the Add Observer double nested sub menu,
                         gathering input data to create and add a new observer to the station
                        */
                        case 2:
                            utilityMethod.printBanner("Add Observer To The Natural Disaster Tracking Station");
                            System.out.println("Please select what type of observer you'd like to add");
                            System.out.println("-----------------------");
                            System.out.println("1: News Station       |");
                            System.out.println("2: Emergency Service  |");
                            System.out.println("3: Citizen            |");
                            System.out.println("-----------------------");
                            System.out.println("Select:");
                            //using scanner to gather user input for the type of observer to add
                            tempChoice = scanner.nextInt();
                            scanner.nextLine(); //consuming leftover newline character left in buffer by nextInt()

                            /*start of double nested switch statement evaluating the observer type selected,
                            gathering required input, creating the observer declared as a DisasterObserver reference,
                            and adding it to the station using addObserver()
                            */
                            switch (tempChoice) {

                                //double nested case 1 gathering input, creating a new News observer and adding it to the station
                                case 1:
                                    utilityMethod.printBanner("Please Input Data For The New News Station");
                                    System.out.println("Name of the new News Station:");
                                    String tempName = scanner.nextLine();
                                    try {
                                        DisasterObserver tempNews = new News(tempName);
                                        station.addObserver(tempNews);
                                    } catch (RuntimeException e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;//end of double nested case 1

                                //double nested case 2 gathering input, creating a new EmergencyServices observer and adding it to the station
                                case 2:
                                    utilityMethod.printBanner("Please Input Data For The New Emergency Service");
                                    System.out.println("Emergency Service type:");
                                    String tempServiceType = scanner.nextLine();
                                    System.out.println();
                                    System.out.println("Location where Emergency Service is based:");
                                    String tempLocation = scanner.nextLine();
                                    try {
                                        DisasterObserver tempEmergencyService = new EmergencyServices(tempServiceType, tempLocation);
                                        station.addObserver(tempEmergencyService);
                                    } catch (RuntimeException e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;//end of double nested case 2

                                //double nested case 3 gathering input, creating a new Citizen observer and adding it to the station
                                case 3:
                                    utilityMethod.printBanner("Please Input Data For The New Citizen");
                                    System.out.println("Name:");
                                    tempName = scanner.nextLine();
                                    System.out.println();
                                    System.out.println("Address:");
                                    tempLocation = scanner.nextLine();
                                    System.out.println();
                                    System.out.println("Phone Number:");
                                    String tempPhoneNumber = scanner.nextLine();
                                    try {
                                        DisasterObserver tempCitizen = new Citizen(tempName, tempLocation, tempPhoneNumber);
                                        station.addObserver(tempCitizen);
                                    } catch (RuntimeException e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;//end of double nested case 3

                                //implementing a double nested default case for any input not in the range of 1-3
                                default:
                                    System.out.println("Error: invalid option chosen please try again and select an option between 1-3");
                                    break;//end of double nested default

                            }//end of double nested switch statement for Add Observer
                            break;//end of nested case 2

                        /*start of nested case 3 displaying all subscribed observers with a numbered index,
                        prompting the user to select which observer to remove and calling removeObserverByIndex()
                        */
                        case 3:
                            utilityMethod.printBanner("Remove Observer From The Natural Disaster Tracking Station");
                            System.out.println("Select an observer to remove:");
                            System.out.println("------------------------------");
                            station.displayNumberedObservers();
                            System.out.println("------------------------------");
                            System.out.println("Select:");
                            //using scanner to gather user input for the observer to remove
                            tempChoice = scanner.nextInt();
                            //subtracting 1 from user selection to account for zero based indexing
                            station.removeObserverByIndex(tempChoice - 1);
                            break;//end of nested case 3

                        //implementing a nested default case for any input not in the range of 1-3
                        default:
                            System.out.println("Error: invalid option chosen please try again and select an option between 1-3");
                            break;//end of nested default

                    }//end of nested switch statement for Manage Observers sub menu
                    break;//end of main case 2

                /*start of main case 3 displaying the Run Disaster Simulation sub menu, going into a nested
                switch statement to execute the selected simulation demonstrating the State and Observer patterns
                */
                case 3:
                    utilityMethod.printBanner("Run Natural Disaster Simulation Menu");
                    System.out.println("-------------------------------------");
                    System.out.println("1: Cause Disaster                   |");
                    System.out.println("2: Notify All Observers             |");
                    System.out.println("3: Execute Current Disaster State   |");
                    System.out.println("-------------------------------------");
                    System.out.println("Select:");
                    //using scanner to gather user input for Run Disaster Simulation sub menu selection
                    tempChoice = scanner.nextInt();

                    /*start of nested switch statement evaluating the Run Disaster Simulation sub menu selection,
                    3 options: cause disaster, notify observers, or execute current disaster state
                    */
                    switch (tempChoice) {

                        /*start of nested case 1 iterating through naturalDisastersList and calling causeDisaster()
                        on each disaster, demonstrating polymorphism as each subclass executes unique destruction behavior
                        */
                        case 1:
                            System.out.println();//line break

                            utilityMethod.printBanner("Natural Disasters Causing Destruction");
                            //enhanced for loop iterating through each NaturalDisaster and calling its overridden causeDisaster() method
                            for (NaturalDisaster disaster : naturalDisastersList) {
                                System.out.println();
                                disaster.causeDisaster();
                                System.out.println();
                            }//end of enhanced for loop
                            break;//end of nested case 1

                        /*start of nested case 2 prompting the user to select a specific disaster to notify
                        all observers about, going into a double nested switch to call notifyObservers()
                        demonstrating the Observer design pattern
                        */
                        case 2:
                            utilityMethod.printBanner("Select A Natural Disaster To Notify All Observers");
                            System.out.println("------------------");
                            System.out.println("1: Flood        |");
                            System.out.println("2: Tornado      |");
                            System.out.println("3: Earthquake   |");
                            System.out.println("-----------------");
                            System.out.println("Select:");
                            //using scanner to gather user input for which disaster to notify all observers about
                            tempChoice = scanner.nextInt();

                            /*start of double nested switch statement calling notifyObservers() on the station
                            and passing the selected disaster to trigger update() on all subscribed observers
                            */
                            switch (tempChoice) {

                                //double nested case 1 calling notifyObservers() and passing the flood object
                                case 1:
                                    utilityMethod.printBanner("Notifying All Observers Of A Flood Alert");
                                    station.notifyObservers(flood);
                                    break;//end of double nested case 1

                                //double nested case 2 calling notifyObservers() and passing the tornado object
                                case 2:
                                    utilityMethod.printBanner("Notifying All Observers Of A Tornado Alert");
                                    station.notifyObservers(tornado);
                                    break;//end of double nested case 2

                                //double nested case 3 calling notifyObservers() and passing the earthquake object
                                case 3:
                                    utilityMethod.printBanner("Notifying All Observers Of A Earthquake Alert");
                                    station.notifyObservers(earthquake);
                                    break;//end of double nested case 3

                                //implementing a double nested default case for any input not in the range of 1-3
                                default:
                                    System.out.println("Error: invalid option chosen please try again and select an option between 1-3");
                                    break;//end of double nested default

                            }//end of double nested switch statement for Notify Observers
                            break;//end of nested case 2

                        /*start of nested case 3 iterating through naturalDisastersList and calling
                        executeCurrentState() on each disaster, demonstrating the State design pattern as
                        each disaster delegates to its current DisasterState object's doAction() method
                        */
                        case 3:
                            utilityMethod.printBanner("Executing Current Disaster State For All Natural Disasters");
                            //enhanced for loop iterating through each NaturalDisaster and calling executeCurrentState()
                            for (NaturalDisaster disaster : naturalDisastersList) {
                                System.out.println();
                                disaster.executeCurrentState();
                                System.out.println();
                            }//end of enhanced for loop
                            break;//end of nested case 3

                        //implementing a nested default case for any input not in the range of 1-3
                        default:
                            System.out.println("Error: invalid option chosen please try again and select an option between 1-3");
                            break;//end of nested default

                    }//end of nested switch statement for Run Disaster Simulation sub menu
                    break;//end of main case 3

                //start of main case 4 displaying a farewell message and exiting the do-while loop
                case 4:
                    System.out.println("Thank you for using the Natural Disaster Tracking System stay safe out there");
                    break;//end of main case 4

                //implementing a main default case for any input not in the range of 1-4
                default:
                    System.out.println("Error: invalid option chosen please try again and select an option between 1-4");
                    break;//end of main default

            }//end of main switch statement

        //end of do-while loop, continues until the user selects option 4 to exit
        } while (choice != 4);



    }//end of main method


}//end of the NaturalDisasterDriver class

