/*
 * Name: Jacob Sones
 * Date: 04/21/2026
 * File: Priority.java
 * Program: Support Ticket System
 *
 * Description:
 * This file defines Priority, an enum that represents the three possible priority
 * levels that can be assigned to a SupportTicket. Priority levels are used by the
 * support handler chain to determine which technician should handle a given ticket.
 */
package SupportTicketSystem;

public enum Priority {
    LOW,    //assigned to tickets that can be resolved by a basic support technician
    MEDIUM, //assigned to tickets that require a technical support technician
    HIGH,   //assigned to tickets that require a managerial support technician
}
