/*
 * Name: Jacob Sones
 * Date: 04/21/2026
 * File: SupportHandler.java
 * Program: Support Ticket System
 *
 * Description:
 * This file defines SupportHandler, an interface that establishes the contract for
 * all support handler classes in the chain of responsibility. Any class implementing
 * this interface must provide logic for handling a SupportTicket and setting the
 * next handler in the chain.
 */
package SupportTicketSystem;

public interface SupportHandler {

    //method to be implemented by each handler class to define how a SupportTicket is handled
    void handleRequest(SupportTicket ticket);

    //method to be implemented by each handler class to set the next handler in the support chain
    void setNextHandler(SupportHandler next);

}