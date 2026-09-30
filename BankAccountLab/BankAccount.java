/*
 * Name: Quinton Hardman
 * Date: 04/06/2026
 * File: BankAccount.java
 * Program: Bank Account Lab (BankAccount / SavingAccount / CheckingAccount / MainDriver)
 *
 * Description:
 * This file defines the abstract BankAccount class, serving as the base class for the
 * BankAccount lab. It encapsulates bankAccountID, routingNumber, and amount with
 * validated setters, and declares the abstract methods withdraw() and deposit()
 * that all subclasses must implement.
 */
package BankAccountLab;
import java.text.NumberFormat;

public class BankAccount implements BankActions {

    //Implementing the NumberFormat class to use to format currency to two decimal places
    NumberFormat curr = NumberFormat.getCurrencyInstance();

    // Attributes
    private String bankAccountID; // must be 9 digits
    private String routingNumber; // must be 9 digits
    protected double amount;

    // Default construct
    public BankAccount() {
        this.bankAccountID = "Unknown";
        this.routingNumber = "Unknown";
        this.amount = 0;
    }

    // Param construct
    public BankAccount(String bankAccountID, String routingNumber, double amount) {
        setBankAccountID(bankAccountID);
        setRoutingNumber(routingNumber);
        setAmount(amount);
    }

    // Copy construct
    public BankAccount(BankAccount other) {
        this.bankAccountID = other.bankAccountID;
        this.routingNumber = other.routingNumber;
        this.amount = other.amount;
    }

    // Getters
    public String getBankAccountID() {
        return bankAccountID;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public double getAmount() {
        return amount;
    }

    // Setters that validate
    public void setBankAccountID(String bankAccountID) {
        if (bankAccountID == null || bankAccountID.trim().isEmpty() || bankAccountID.length() < 9) {
            throw new RuntimeException("Bank account ID cannot be less than 9 characters");
        }
        if (bankAccountID.length() > 9) {
            throw new RuntimeException("Bank account ID cannot be more than 9 characters");
        }
        this.bankAccountID = bankAccountID;
    }

    public void setRoutingNumber(String routingNumber) {
        if (routingNumber == null || routingNumber.trim().isEmpty() || routingNumber.length() < 9) {
            throw new RuntimeException("Routing number cannot be less than 9 characters");
        }
        if (routingNumber.length() > 9) {
            throw new RuntimeException("Routing number cannot be more than 9 characters");
        }
        this.routingNumber = routingNumber;
    }

    public void setAmount(double amount) {
        if (amount < 0) {
            throw new RuntimeException("Amount cannot be negative");
        }
        this.amount = amount;
    }

    // Implemented methods from interface
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Withdrawal amount must be positive");
        }
        if (amount > this.amount) {
            throw new RuntimeException("Insufficient funds");
        }
        this.amount -= amount;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Deposit amount must be positive");
        }
        this.amount += amount;
    }

    // toString override
    @Override
    public String toString() {
        return  "\n\t=================================="
                + "\n\t|***Bank account ID: " + bankAccountID + "***|"
                + "\n\t=================================="
                + "\n\tRouting Number: " + routingNumber
                + "\n============================="
                + "\n\tBalance: " + curr.format(getAmount());
    }
}