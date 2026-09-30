/*
 * DisasterState.java
 * Author: Jacob Sones
 * Date: May 3, 2026
 *
 * Interface defining the contract for all concrete state classes in the State
 * design pattern within the NaturalDisasterTrackingSystem. Requires all
 * implementing classes to define the doAction() method which receives a
 * NaturalDisaster object and executes behavior unique to that state. This
 * interface allows the NaturalDisaster base class to hold a single currentState
 * reference and delegate behavior dynamically at runtime through the
 * executeCurrentState() method, enabling disasters to transition through
 * Monitoring, Active, Critical, and Resolved states without altering their
 * class structure.
 */
package NaturalDisasterTrackingSystem.NaturalDisasterTrackingSystem;

public interface DisasterState {

   void doAction(NaturalDisaster naturalDisaster);

}
