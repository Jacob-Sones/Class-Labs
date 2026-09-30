/*
 * DisasterObserver.java
 * Author: Jacob Sones
 * Date: May 6, 2026
 *
 * This interface defines the contract for the Observer pattern within the
 * Natural Disaster Tracking System. It establishes the mandatory update() method
 * that all concrete observer classes—such as Citizen, News, and EmergencyServices—must
 * implement. This ensures that the NaturalDisasterStation can generically notify
 * all registered observers by passing a NaturalDisaster object, allowing for
 * decoupled, real-time communication across the system.
 */
package NaturalDisasterTrackingSystem;

public interface DisasterObserver {

    void update(NaturalDisaster naturalDisaster);


}
