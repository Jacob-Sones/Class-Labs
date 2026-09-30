/*
 * Name: Quinton Hardman
 * Date: 04/06/2026
 * File: BankActions.java
 * Program: Bank Account Lab (BankAccount / SavingAccount / CheckingAccount / CDSavingsAccount / MainDriver)
 *
 * Description:
 * This file defines the BankActions interface, which serves as the contract for all
 * bank account types in the BankAccount lab. It declares the abstract methods
 * withdraw() and deposit() that all implementing classes must provide concrete
 * implementations for.
 */
package BankAccountLab;

public interface BankActions {

    void withdraw(double amount);

    void deposit(double amount);
}