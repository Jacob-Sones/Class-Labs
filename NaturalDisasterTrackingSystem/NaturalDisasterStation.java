/*
 * NaturalDisasterStation.java
 * Author: Jacob Sones
 * Date: May 6, 2026
 *
 * This class acts as the Subject in the Observer design pattern, serving as the
 * central hub for the Natural Disaster Tracking System. It maintains an
 * ArrayList of DisasterObserver objects, providing public methods to add or
 * remove subscribers dynamically. The core functionality is contained in the
 * notifyObservers() method, which utilizes an enhanced for-loop to iterate
 * through the collection and trigger the update() method on all registered
 * observers, ensuring real-time dissemination of NaturalDisaster data.
 */
package NaturalDisasterTrackingSystem;
import java.util.ArrayList;

public class NaturalDisasterStation {

    //declaring a private ArrayList of DisasterObservers to manage a list of concrete observer classes
    private ArrayList<DisasterObserver> observersList = new ArrayList<>();

    /*declaring a private member variable NaturalDisaster to pass in the update()
    method for each observer in the notifyObservers() method
     */
    private NaturalDisaster naturalDisaster;


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
            observer.update(naturalDisaster);
        }
    }//end of the notifyObserver method


    //Implementation of getters and setters for NaturalDisaster validation, checking if the object passed is null.
    public NaturalDisaster getNaturalDisaster() {
        return naturalDisaster;
    }//end of get naturalDisaster

    public void setNaturalDisaster(NaturalDisaster naturalDisaster) {
        if (naturalDisaster == null) {
            throw new RuntimeException("Error: An error has occurred Natural Disaster cannot be null");
        } else {
            this.naturalDisaster = naturalDisaster;
        }//end of if-else statement

    }//end of setNaturalDisaster

}//end of NaturalDisasterStation
