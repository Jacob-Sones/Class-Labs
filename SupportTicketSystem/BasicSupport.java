/*
 * Name: Jacob Sones
 * Date: 04/21/2026
 * File: BasicSupport.java
 * Program: Support Ticket System
 *
 * Description:
 * This file defines BasicSupport, a concrete class that implements the SupportHandler
 * interface. It handles support tickets with a LOW priority level and escalates any
 * tickets it cannot resolve to the next handler in the chain, if one is available.
 */
package SupportTicketSystem;

public class BasicSupport implements SupportHandler {

    //Implementing private member variable to hold a reference to the next handler in the chain
    private SupportHandler nextHandler;

    /*Overriding the handleRequest method to implement custom logic for BasicSupport.
    Handles LOW priority tickets directly, escalates all others to the next handler in the chain
    if one is set, otherwise notifies that no technician is available.
     */
    @Override
    public void handleRequest(SupportTicket ticket) {
        //checking if ticket priority is LOW, if so handle it directly
        if(ticket.getPriorityLevel() == Priority.LOW){
            System.out.println("Support Ticket Priority: Low\nTicket is being handled by Basic Support Technician");
            System.out.println("Ticket Description: " + ticket.getDescription());

            //checking if a next handler exists in the chain to escalate the ticket to
        }else if (nextHandler != null){
            System.out.println("Basic technician cannot resolve this ticket escalating it to technical support technician");
            nextHandler.handleRequest(ticket);
        }else{
            System.out.println("no technician is available to help");
        }
    }//end of handleRequest method

    //Overriding setNextHandler to assign the next handler in the support chain
    @Override
    public void setNextHandler(SupportHandler next) {
        this.nextHandler = next;
    }//end of setNextHandler method

}
