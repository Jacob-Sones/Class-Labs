/*
 * Name: Jacob Sones
 * Date: 04/21/2026
 * File: SupportTicket.java
 * Program: Support Ticket System
 *
 * Description:
 * This file defines SupportTicket, a class that models a support ticket with a
 * description and priority level. It includes a default constructor, a parameterized
 * constructor, and getters and setters with validation for each private member variable.
 */
package SupportTicketSystem;

public class SupportTicket {

    //Implementing private member variables for the SupportTicket class
    private String description;
    private Priority priorityLevel;

    /*Implementation of the default constructor to assign values to private member variables
     if none are given at initialization of SupportTicket objects
     */
    public SupportTicket() {
        this.description = "Unknown";
        this.priorityLevel = Priority.LOW;
    }//end of default constructor

    /*Implementation of the parameterized constructor to assign data passed in the parameters
     to the private member attributes of new SupportTicket objects
     */
    public SupportTicket(String description, Priority priorityLevel) {
        setDescription(description);
        setPriorityLevel(priorityLevel);
    }//end of parameterized constructor


    //start of getters and setters with validation checks
    public String getDescription() {
        return description;
    }//end of getDescription

    public void setDescription(String description) {
        //throwing RuntimeException if description is null or empty
        if(description == null || description.trim().isEmpty()){
            throw new RuntimeException("Description cannot be null or empty");
        }else {
            this.description = description;
        }
    }//end of setDescription

    public Priority getPriorityLevel() {
        return priorityLevel;
    }//end of getPriorityLevel

    public void setPriorityLevel(Priority priorityLevel) {
        //throwing RuntimeException if priorityLevel is null
        if (priorityLevel == null){
            throw new RuntimeException("Priority Level cannot be null");
        }else {
            this.priorityLevel = priorityLevel;
        }
    }//end of setPriorityLevel

}
