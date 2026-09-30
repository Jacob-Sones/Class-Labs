/*
 * DisasterType.java
 * Author: Jacob Sones
 * Date: May 3, 2026
 *
 * Enum defining the valid disaster types supported by the NaturalDisasterTrackingSystem.
 * Restricts the disasterType field in NaturalDisaster to only accepted values of
 * EARTHQUAKE, FLOOD, and TORNADO, preventing invalid disaster types from being assigned.
 * Used throughout the system by state classes and observer classes to identify the
 * type of disaster and execute unique type specific behavior and output messages.
 */
package NaturalDisasterTrackingSystem;

public enum DisasterType {
    EARTHQUAKE,
    FLOOD,
    TORNADO,
}
