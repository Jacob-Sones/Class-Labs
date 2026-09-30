/*
 * NaturalDisasterStation.java
 * Author: Jacob Sones
 * Date: May 6, 2026
 *
 * Acts as the Subject in the Observer design pattern within the
 * NaturalDisasterTrackingSystem. Serves as the central notification hub
 * maintaining a private ArrayList of DisasterObserver objects representing
 * all currently subscribed observers. Provides public methods to add and
 * remove observers dynamically by reference or by index, display all
 * subscribers, and notify all registered observers by iterating through
 * the ArrayList and calling each observer's update() method with the passed
 * NaturalDisaster object. The notifyObservers() method is the core of the
 * Observer pattern, ensuring real time disaster alerts are delivered to all
 * subscribed Citizen, News, and EmergencyServices observers without the
 * station needing to know the specific type of each observer.
 */
package NaturalDisasterTrackingSystem.NaturalDisasterTrackingSystem;
import java.util.ArrayList;

public class NaturalDisasterStation {

    //declaring a private ArrayList of DisasterObservers to manage a list of concrete observer classes
    private ArrayList<DisasterObserver> observersList = new ArrayList<>();




    //implementation of the addObserver() method to add a concrete observer class to the observerList
    public void addObserver(DisasterObserver observer) {
        observersList.add(observer);
    }//end of addObserver method


    //Implementation of the removeObserver() method to remove a concrete observer class from the observerList
    public void removeObserver(DisasterObserver observer){
        observersList.remove(observer);
    }//end of removeObserver method


    /*Implementation of the notifyObserver() method utilizing an enhanced for loop to iterate through all observers
     stored in the observerList and calls the update() method, passing the NaturalDisaster object.
     */
    public void notifyObservers(NaturalDisaster naturalDisaster){
        for(DisasterObserver observer : observersList){
            System.out.println();
            observer.update(naturalDisaster);
            System.out.println();
        }
    }//end of the notifyObserver method


    // Iterates through the observersList and displays the information of each observer
    public void displayAllObservers(){
        // enhanced for loop iterating through each observer in the observersList and calling its toString method
        for(DisasterObserver observer : observersList){
            System.out.println(observer.toString());
            System.out.println();
        }
    }

    // Removes an observer from the observersList at the specified index if the index is valid
    public void removeObserverByIndex(int index){
        // checking if the index is within the valid range of the observersList
        if(index >= 0 && index < observersList.size()){
            // printing the name of the observer being removed before removing it from the list
            System.out.println(observersList.get(index).getObserverName() + " has been removed from the station.");
            // removing the observer at the specified index from the observersList
            observersList.remove(index);
        } else {
            // printing an error message if the index is out of the valid range
            System.out.println("Error: invalid index please try again.");
        }
    }

    // Iterates through the observersList and displays each observer with a numbered index for selection
    public void displayNumberedObservers(){
        // enhanced for loop iterating through each observer and printing its number and name
        for(int i = 0; i < observersList.size(); i++){
            System.out.println((i + 1) + ": " + observersList.get(i).getObserverName());
        }
    }



}//end of NaturalDisasterStation
