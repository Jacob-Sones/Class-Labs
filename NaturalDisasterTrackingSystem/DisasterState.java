/*
 * DisasterState.java
 * Author: Jacob Sones
 * Date: May 3, 2026
 *
 * Interface defining the contract for all state classes in the State design pattern.
 * Any class implementing DisasterState must define the doAction() method which receives
 * a NaturalDisaster object and executes behavior appropriate to that state. This interface
 * allows the NaturalDisaster base class to hold a reference to any state implementation
 * and delegate behavior dynamically through the executeCurrentState() method, enabling
 * disasters to change behavior at runtime without altering their class structure.
 */
package NaturalDisasterTrackingSystem;

public interface DisasterState {

   void doAction(NaturalDisaster naturalDisaster);

}
