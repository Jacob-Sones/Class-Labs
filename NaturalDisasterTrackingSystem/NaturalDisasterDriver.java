package NaturalDisasterTrackingSystem;
import java.util.Scanner;
import java.util.ArrayList;

public class NaturalDisasterDriver {

    static void main() {
        //declaring Utility class to have access to the printBanner() method
        UtilityMethod utilityMethod = new UtilityMethod();
        //declaring a scanner object to gather user input
        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        DisasterState monitoringState = new MonitoringState();
        DisasterState activeState = new ActiveState();
        DisasterState criticalState = new CriticalState();
        DisasterState resolvedState = new ResolvedState();

        NaturalDisaster tornado = null;
        NaturalDisaster flood = null;
        NaturalDisaster earthquake = null;
        try {
            tornado = new Tornado(9, 8000, 9000.0, "El Reno Tornado", "El Reno, Oklahoma", DisasterType.TORNADO, monitoringState, 5, 295.0);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        try {
             flood = new Flood(8, 30000, 12000.0, "Hurricane Harvey Floods", "Houston, Texas", DisasterType.FLOOD, monitoringState, 72);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        try {
             earthquake = new Earthquake(9, 230000, 20000.00, "Haiti Earthquake", "Port-au-Prince, Haiti", DisasterType.EARTHQUAKE, monitoringState, 7.0);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        // Create observer objects
        Citizen citizen = new Citizen("Jacob Sones", "El Reno, Oklahoma", "2105550101");
        News news = new News("KSAT 12 News");
        EmergencyServices emergency = new EmergencyServices("Fire & Rescue", "Houston, Texas");



        // Create the NaturalDisasterStation (the subject)
        NaturalDisasterStation station = new NaturalDisasterStation();
        ArrayList<NaturalDisaster> naturalDisastersList = new ArrayList<>();

        naturalDisastersList.add(tornado);
        naturalDisastersList.add(earthquake);
        naturalDisastersList.add(flood);

        // Register observers with the station
        station.addObserver(citizen);
        station.addObserver(news);
        station.addObserver(emergency);

        utilityMethod.printBanner("Natural Disaster Tracking System");
        System.out.println();
        System.out.println();

        do {
            utilityMethod.printBanner("Natural Disaster Main Menu");
            System.out.println("------------------------------");
            System.out.println("1: Manage Natural Disasters  |");
            System.out.println("2: Manage Observers          |");
            System.out.println("3: Run Disaster Simulation   |");
            System.out.println("4: Exit Program              |");
            System.out.println("------------------------------");
            System.out.println("Select:");
           choice = scanner.nextInt();

           switch (choice){

               case 1:
                   utilityMethod.printBanner("Manage Natural Disaster Menu");
                   System.out.println("---------------------------------------------");
                   System.out.println("1: Display All Natural Disasters            |");
                   System.out.println("2: Update Natural Disaster State            |");
                   System.out.println("3: Display Natural Disaster Damage Report   |");
                   System.out.println("---------------------------------------------");
                   System.out.println("Select:");
                   choice = scanner.nextInt();

                   switch (choice){
                       case 1:
                           utilityMethod.printBanner("Displaying All Natural Disasters Being Tracked");
                           for(NaturalDisaster disaster : naturalDisastersList){
                               System.out.println(disaster.toString());
                           }//end of enhanced for loop

                           break;

                       case 2:
                           utilityMethod.printBanner("Update Natural Disaster State");
                           System.out.println("--------------------------------");
                           System.out.println("1: Update state To Monitoring  |");
                           System.out.println("2: Update State To Active      |");
                           System.out.println("3: Update State To Critical    |");
                           System.out.println("4: Update State To Resolved    |");
                           System.out.println("--------------------------------");
                           System.out.println("Select:");
                           int tempChoice = scanner.nextInt();

                           switch (tempChoice){
                               case 1:
                               System.out.println("Changing all Natural Disasters to Monitoring state");

                               for(NaturalDisaster disaster : naturalDisastersList){
                                   try {
                                       disaster.setCurrentState(monitoringState);
                                   }catch (RuntimeException e){
                                       System.out.println(e.getMessage());
                                   }


                               }//end of enhanced for loop
                                   break;

                               case 2:
                                   System.out.println("Changing all Natural Disasters to Active state");
                                   for(NaturalDisaster disaster : naturalDisastersList){
                                       try {
                                           disaster.setCurrentState(activeState);
                                       }catch (RuntimeException e){
                                           System.out.println(e.getMessage());
                                       }


                                   }//end of enhanced for loop
                                   break;

                               case 3:
                                   System.out.println("Changing all Natural Disasters to Critical state");
                                   for(NaturalDisaster disaster : naturalDisastersList){
                                       try {
                                           disaster.setCurrentState(criticalState);
                                       }catch (RuntimeException e){
                                           System.out.println(e.getMessage());
                                       }


                                   }//end of enhanced for loop
                                   break;

                               case 4:
                                   System.out.println("Changing all Natural Disasters to Resolved state");
                                   for(NaturalDisaster disaster : naturalDisastersList){
                                      try {
                                          disaster.setCurrentState(resolvedState);
                                      }catch (RuntimeException e){
                                          System.out.println(e.getMessage());
                                      }

                                   }//end of enhanced for loop
                                   break;

                               default:
                                   System.out.println("Error: invalid option chosen please try again and select an option between 1-4");
                                   break;

                           }

                           break;

                       case 3:

                           break;

                       default:

                           break;

                   }


                   break;

               case 2:

                   break;

               case 3:

                   break;

               case 4:

                   break;

               default:

                   break;
           }

















        }while(choice != 4);







    }

}
