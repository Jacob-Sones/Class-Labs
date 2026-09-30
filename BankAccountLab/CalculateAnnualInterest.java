/*
 * Name: Quinton Hardman
 * Date: 04/06/2026
 * File: CalculateAnnualInterest.java
 * Program: Bank Account Lab (BankAccount / SavingAccount / CheckingAccount / CDSavingsAccount / MainDriver)
 *
 * Description:
 * This file defines the CalculateAnnualInterest interface, which serves as the contract
 * for bank account types that support interest calculations. It declares the abstract
 * method calculateAnnualInterest() that all implementing classes must provide a concrete
 * implementation for.
 */
package BankAccountLab;

public interface CalculateAnnualInterest {

    void calculateAnnualInterest();

}