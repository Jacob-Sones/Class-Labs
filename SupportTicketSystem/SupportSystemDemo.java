/*
 * Name: Jacob Sones
 * Date: 04/21/2026
 * File: SupportSystemDemo.java
 * Program: Support Ticket System
 *
 * Description:
 * This file defines SupportSystemDemo, a driver class that demonstrates the chain of
 * responsibility pattern used in the Support Ticket System. It initializes the support
 * handlers, links them together in a chain, creates three SupportTicket objects of
 * varying priority levels, and passes each ticket to the chain to be handled.
 */
package SupportTicketSystem;

public class SupportSystemDemo {

    static void main() {
        //initializing each support handler in the chain
        SupportHandler basicTechnician = new BasicSupport();
        SupportHandler technicalTechnician = new TechnicalSupport();
        SupportHandler managerialTechnician = new ManagerialSupport();

        //linking the handlers together to form the chain of responsibility
        basicTechnician.setNextHandler(technicalTechnician);
        technicalTechnician.setNextHandler(managerialTechnician);

        //creating SupportTicket objects with descriptions and priority levels to be passed through the chain
        SupportTicket supportTicket1 = new SupportTicket("Password Reset", Priority.LOW);
        SupportTicket supportTicket2 = new SupportTicket("Cant connect to the file server", Priority.MEDIUM);
        SupportTicket supportTicket3 = new SupportTicket("Critical data breach report", Priority.HIGH);

        //displaying header for the support ticket system demo
        System.out.println("=============================");
        System.out.println("|***Support Ticket System***|");
        System.out.println("=============================");

        //passing each ticket to the start of the chain and displaying results
        System.out.println("Ticket 1: ");
        basicTechnician.handleRequest(supportTicket1);
        System.out.println();

        System.out.println("Ticket 2: ");
        basicTechnician.handleRequest(supportTicket2);
        System.out.println();

        System.out.println("Ticket 3: ");
        basicTechnician.handleRequest(supportTicket3);

    }//end of main method

}
