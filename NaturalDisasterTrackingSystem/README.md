# Natural Disaster Tracking System
**Author:** Jacob Sones  
**Date:** May 8, 2026  
**Course:** Java Programming — Course Capstone Lab

---

## Program Description

The Natural Disaster Tracking System is a Java application that simulates a
real-world disaster monitoring and alert platform. The program tracks three
active natural disasters — the El Reno Tornado, Hurricane Harvey Floods, and
the Haiti Earthquake — and notifies subscribed observers including citizens,
news stations, and emergency services as each disaster progresses through
different states of severity.

The program is driven by a menu based interface that allows the user to manage
tracked disasters, manage subscribed observers, and run simulations that
demonstrate both design patterns and core object-oriented programming concepts
in action.

---

## Design Patterns Used

### State Pattern
The State design pattern is implemented through the `DisasterState` interface
and four concrete state classes: `MonitoringState`, `ActiveState`,
`CriticalState`, and `ResolvedState`. Each `NaturalDisaster` object holds a
reference to the current `DisasterState` and delegates behavior to it through
the `executeCurrentState()` method, which internally calls `doAction()` on
the current state. Each state class checks the `DisasterType` of the disaster
and prints a unique message describing the current conditions, allowing
disaster behavior to change dynamically at runtime without altering the
disaster class structure.

### Observer Pattern
The Observer design pattern is implemented through the `DisasterObserver`
interface and three concrete observer classes: `Citizen`, `News`, and
`EmergencyServices`. The `NaturalDisasterStation` acts as the subject,
maintaining a private `ArrayList` of `DisasterObserver` objects and providing
methods to add, remove, and notify all registered observers. When
`notifyObservers()` is called with a `NaturalDisaster` object, it iterates
through the observer list and calls `update()` on each one, triggering
unique alert output based on the disaster type and current state.
---


## Project Structure-Diagram
![Class Diagram](src/NaturalDisasterTrackingSystem/NaturalDisasterTrackingSystem/Diagram image/NaturalDisasterTrackingSystemDiagram.jpg)
![Class Diagram](src/NaturalDisasterTrackingSystem/NaturalDisasterTrackingSystem/Diagram image/NaturalDisasterClasses.png)
![Class Diagram](src/NaturalDisasterTrackingSystem/NaturalDisasterTrackingSystem/Diagram image/StatePatternClasses.png)
![Class Diagram](src/NaturalDisasterTrackingSystem/NaturalDisasterTrackingSystem/Diagram image/ObserverPatternClasses.png)
---

## OOP Concepts Demonstrated

### Inheritance
`NaturalDisaster` serves as the abstract base class. `Earthquake`, `Flood`,
and `Tornado` all extend it meaningfully by inheriting shared attributes such
as `severityLevel`, `affectedPopulation`, `estimatedCostOfDamages`, `name`,
`location`, `disasterType`, and `currentState`, while each adding their own
class specific fields — `magnitude` for Earthquake, `waterLevel` for Flood,
and `category` and `windSpeed` for Tornado.

### Polymorphism
All three disaster subclass objects are declared as `NaturalDisaster` base
class references and stored in an `ArrayList<NaturalDisaster>`. The driver
iterates through this list and calls `causeDisaster()`, `calculateDamages()`,
and `executeCurrentState()` on each object through the base class reference,
with each subclass executing its own unique overridden implementation. Observer
objects are similarly declared as `DisasterObserver` interface references,
allowing the station to call `update()` on each without knowing the specific
observer type.

### Aggregation and Composition
The `NaturalDisasterStation` class demonstrates aggregation by containing an
`ArrayList<DisasterObserver>` that manages all subscribed observer objects.
The `NaturalDisaster` base class demonstrates composition by holding a
reference to a `DisasterState` object that defines its current behavioral
state, and a `DisasterType` enum value that identifies its type.

### Constructors
Every class in the project implements three constructor types:
- **Default constructor** — initializes fields to safe base values
- **Parameterized constructor** — sets fields through validated setters
- **Copy constructor** — creates a new object from an existing object of the
  same class

### Validation
All setter methods across every class include validation logic. Examples
include `severityLevel` being restricted to 1-10, `magnitude` restricted to
0.0-10.0 on the Richter scale, `category` restricted to 0-5 on the EF scale,
`waterLevel` prevented from being negative, phone numbers validated to exactly
10 numeric digits, and all String fields checked for null or empty values.
Validation errors throw `RuntimeException` and are caught in the driver using
try-catch blocks.

---

## Real World Scenario

This program models a real-world emergency alert and disaster tracking system
similar to platforms used by government agencies and emergency management
organizations. The three disasters are based on real historical events — the
2013 El Reno Tornado (EF5), the 2017 Hurricane Harvey Floods in Houston, and
the 2010 Haiti Earthquake (7.0 magnitude). The system demonstrates how
different types of subscribers receive different types of alerts based on the
same disaster event, mirroring how real emergency notification systems
communicate with the public, media, and first responders simultaneously.

---

## Architecture Benefits

Using the **State pattern** eliminates the need for complex if/else chains
inside the disaster classes to handle different severity behaviors. Each state
encapsulates its own logic and the disaster simply delegates to whatever state
is currently set, making it easy to add new states in the future without
modifying existing classes.

Using the **Observer pattern** completely decouples the disaster tracking
system from the notification system. The `NaturalDisasterStation` does not
need to know anything about the specific observer types — it simply calls
`update()` on all registered observers. New observer types can be added to
the system at any time without changing any existing code.

The `UtilityMethod` class follows the **DRY principle** by centralizing shared
logic like banner printing and state evaluation, preventing code duplication
across all observer and state classes.

---

## Dependencies

- Uses `java.text.NumberFormat` for currency formatting
- Uses `java.util.ArrayList` and `java.util.Scanner`