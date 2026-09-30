/**
 * File: SmartDevice.java
 * Package: Lab1
 * Author: Jacob Sones
 * Date: April 16, 2026
 *
 * Interface defining the core behavioral contract for all smart home devices
 * in the Smart Home Automation System. Any class that implements this interface
 * must provide concrete implementations for turning the device on, turning it
 * off, and reporting its current status. This interface enables polymorphism,
 * allowing all device types to be stored and interacted with through a single
 * SmartDevice reference, regardless of their specific type.
 */
package SmartHomeAutomationSystem;

public interface SmartDevice {

    /*declaring an abstract method turnOn, turnOff, and getStatus that will be implemented in the subclasses
     SmartSpeaker and SmartLight of the base class Device to force implementing logic for abstract methods
     */
    void turnOn();

    void turnOff();

    void getStatus();


}
