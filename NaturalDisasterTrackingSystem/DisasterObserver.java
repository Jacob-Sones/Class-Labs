/*
 * DisasterObserver.java
 * Author: Jacob Sones
 * Date: May 6, 2026
 *
 * Interface defining the contract for all concrete observer classes in the
 * Observer design pattern within the NaturalDisasterTrackingSystem. Requires
 * all implementing classes to define the update() method which receives a
 * NaturalDisaster object and executes observer specific notification logic,
 * and the getObserverName() method used by the NaturalDisasterStation to
 * identify each subscriber. Implemented by Citizen, News, and EmergencyServices,
 * allowing the NaturalDisasterStation to generically notify all registered
 * observers through a single ArrayList of DisasterObserver references without
 * needing to know the specific observer type.
 */
package NaturalDisasterTrackingSystem.NaturalDisasterTrackingSystem;

public interface DisasterObserver {

    void update(NaturalDisaster naturalDisaster);


    String getObserverName();
}
