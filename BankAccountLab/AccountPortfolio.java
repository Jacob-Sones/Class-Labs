/*
 * Elijah Jones
 * 04/14/2026
 * File: AccountPortfolio.java
 *
 * Description:
 * Composite class that manages a collection of BankAccount objects.
 * Demonstrates composition by treating multiple accounts as one unit.
 * Supports deposits, withdrawals, and interest calculations across all accounts.
 */

package BankAccountLab;

import java.util.ArrayList;
import java.text.NumberFormat;

public class AccountPortfolio implements BankActions, CalculateAnnualInterest {

    private ArrayList<BankAccount> accounts;
    //Implementing the NumberFormat class to use to format currency to two decimal places
   private NumberFormat curr = NumberFormat.getCurrencyInstance();


    // Default constructor
    public AccountPortfolio() {
        accounts = new ArrayList<>();
    }

    // Add account to portfolio
    public void addAccount(BankActions account) {
        if (account == null) {
            throw new RuntimeException("Cannot add null account");
        }
        accounts.add((BankAccount) account);
    }

    // Remove account
    public void removeAccount(BankAccount account) {
        accounts.remove(account);
    }

    // Get total balance across all accounts
    public double getTotalBalance() {
        double total = 0;
        for (BankAccount acc : accounts) {
            total += acc.getAmount();
        }
        return total;
    }

    // Composite withdraw (applies to all accounts)
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Amount must be positive");
        }

        for (BankAccount acc : accounts) {
            try {
                acc.withdraw(amount);
            } catch (RuntimeException e) {
                System.out.println("Withdraw failed for account: " + acc.getBankAccountID());
                System.out.println(e.getMessage());
            }
        }
    }

    // Composite deposit (applies to all accounts)
    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Amount must be positive");
        }

        for (BankAccount acc : accounts) {
            try {
                acc.deposit(amount);
            } catch (RuntimeException e) {
                System.out.println("Deposit failed for account: " + acc.getBankAccountID());
                System.out.println(e.getMessage());
            }
        }
    }

    // Only calculate interest for accounts that support it
    @Override
    public void calculateAnnualInterest() {

        for (BankAccount acc : accounts) {
            if (acc instanceof CalculateAnnualInterest) {
                ((CalculateAnnualInterest) acc).calculateAnnualInterest();
            }
        }

    }

    // Display all accounts
    public void displayPortfolio() {
        System.out.println("===== Account Portfolio =====");
        for (BankAccount acc : accounts) {
           if(acc instanceof SavingAccount){
               System.out.print("Savings Account:");
               System.out.println(acc);
               System.out.println("----------------------------");
               System.out.println();
           }else if(acc instanceof CheckingAccount){
               System.out.print("Checking Account:");
               System.out.println(acc);
               System.out.println("----------------------------");
               System.out.println();
           }else if(acc instanceof CDSavingsAccount){
               System.out.print("CD Savings Account:");
               System.out.println(acc);
               System.out.println("----------------------------");
               System.out.println();
           }else{
               System.out.print("Account:");
               System.out.println(acc);
               System.out.println("----------------------------");
               System.out.println();
           }
        }
        System.out.println("Total Balance: " + curr.format(getTotalBalance()));
    }
}
