/*
 * Name: Jacob Sones
 * Date: 04/17/2026
 * File: MainDriver.java
 * Program: Bank Account Lab (BankAccount / SavingAccount / CheckingAccount / CDSavingsAccount / MainDriver)
 *
 * Description:
 * This file serves as the entry point for the BankAccount lab. It creates two objects
 * from each subclass (SavingAccount, CheckingAccount, and CDSavingsAccount), adds them
 * to an AccountPortfolio composite object, and tests deposits, withdrawals, transfers,
 * and interest calculations across all account types. Intentional invalid inputs are
 * included throughout to verify each class handles bad input and edge cases correctly.
 */
package BankAccountLab;

public class MainDriver {

    static void main() {
        //printing out the welcome banner to the program
        System.out.println("============================");
        System.out.println("|***Bank Account Tracker***|");
        System.out.println("============================");
        System.out.println();

        AccountPortfolio accountPortfolio = new AccountPortfolio();
        MainDriver mainDriver = new MainDriver();

        //initializing two objects from each subclass
        SavingAccount savingAccount1 = new SavingAccount("203823948", "203754928",
                20000, 0.03, 5000, 10000);
        SavingAccount savingAccount2 = new SavingAccount("902832475", "102374384",
                10000, 0.05, 2000, 5000);

        CheckingAccount checkingAccount1 = new CheckingAccount("702528735", "685294781",
                15000, 6000, 15, 6);
        CheckingAccount checkingAccount2 = new CheckingAccount("582109738", "105932640",
                9000, 1200, 50.99, 10);

        CDSavingsAccount cdSavingAccount1 = new CDSavingsAccount("902384394","283102209",
                14000,6,0.04,0.10);
        CDSavingsAccount cdSavingAccount2 = new CDSavingsAccount("283092102","584209182",
                5000,0,0.05,0.15);

        //adding subclass objects to accountPortfolio objects built array list
        accountPortfolio.addAccount(savingAccount1);
        accountPortfolio.addAccount(savingAccount2);
        accountPortfolio.addAccount(checkingAccount1);
        accountPortfolio.addAccount(checkingAccount2);
        accountPortfolio.addAccount(cdSavingAccount1);
        accountPortfolio.addAccount(cdSavingAccount2);

        //using the displayPortfolio method to loop through all objects stored in the accountPortfolio array list
       accountPortfolio.displayPortfolio();

        //printing out banner for depositing and withdrawing attempts for saving accounts
        mainDriver.printBanner("Depositing and Withdrawing For Saving Accounts");
        System.out.println("SavingAccount1:");
        System.out.println("---------------");
        savingAccount1.deposit(1000);

        System.out.println();//line break

        savingAccount1.withdraw(4000);
        System.out.println();//line break

        System.out.println("SavingAccount2:");
        System.out.println("---------------");
        //trying to deposit a negative number to display how SavingAccount class handles bad input
        System.out.println("Attempting to deposit a negative number");
        savingAccount2.deposit(-5000);

        System.out.println();//line break

        //trying to withdraw more then maxWithdrawLimitPerMonth and more then the account balance to display how class handles bad input
        System.out.println("Attempting to withdraw more money then account has");
        savingAccount2.withdraw(11000);
        System.out.println();
        System.out.println("Attempting to withdraw more then the monthly withdraw limit allows");
        savingAccount2.withdraw(3000);
        System.out.println();//line break

        //printing banner for transfer attempts with the SavingAccount objects
       mainDriver.printBanner("Transferring Money");
        System.out.println("SavingAccount1:");
        System.out.println("---------------");
        savingAccount1.transferMoney(1000, "901203495");
        System.out.println();//line break

        System.out.println("SavingAccount2:");
        System.out.println("---------------");
        //trying to transfer more then set transferLimit on savingAccount2 object to display how class handles bad input
        System.out.println("Attempting to transfer more then monthly transfer limit allows");
        savingAccount2.transferMoney(7000, "902374836");
        System.out.println();//line break

        //printing banner for the annual interest expected to be earned on savingAccount objects
        mainDriver.printBanner("Expected Annual Interest For Saving Accounts");
        System.out.println("SavingAccount1:");
        System.out.println("---------------");
        savingAccount1.calculateAnnualInterest();
        System.out.println();//line break

        System.out.println("SavingAccount2:");
        System.out.println("---------------");
        savingAccount2.calculateAnnualInterest();
        System.out.println();//line break


        //printing out banner for depositing and withdrawing attempts for CD Savings Account
        mainDriver.printBanner("Depositing and Withdrawing For CD Savings Accounts");
        System.out.println("CDSavingsAccount1:");
        System.out.println("-----------------");
        try{
            cdSavingAccount1.deposit(1000);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        try{
            cdSavingAccount1.withdraw(500);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }


        System.out.println("CDSavingsAccount2:");
        System.out.println("-----------------");
        System.out.println("Attempting to deposit a negative number");
        try {
            //trying to deposit a negative amount
            cdSavingAccount2.deposit(-100);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Attempting to deposit after CD account has reached maturity");
        try {
            //trying to deposit after CD account has reach maturity
            cdSavingAccount2.deposit(700);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Attempting to withdraw a negative number");
        try{
            //trying to withdraw a negative amount
            cdSavingAccount2.withdraw(-695);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Attempting to withdraw from CD account that has reached maturity");
        try{
            //withdrawing after CD account maturity date so no fee/penalty will be applied
            cdSavingAccount2.withdraw(2000);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        //printing out banner for expected interest earned for CD Savings Account
        mainDriver.printBanner("Expected Interest Earned For CD Savings Accounts");
        System.out.println("CDSavingsAccount1:");
        System.out.println("-----------------");
        cdSavingAccount1.calculateAnnualInterest();

        System.out.println("CDSavingsAccount2:");
        System.out.println("-----------------");
        cdSavingAccount2.calculateAnnualInterest();


        //printing out banner for depositing and withdrawing attempts for checking accounts
        mainDriver.printBanner("Depositing and Withdrawing For Checking Accounts");
        System.out.println("CheckingAccount1:");
        System.out.println("-----------------");
        //using try-catch statements to handle errors throw if bad input is given
        try {
            checkingAccount1.deposit(3000);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();//line break
        //using try-catch statements to handle errors throw if bad input is given
        try {
            checkingAccount1.withdraw(2000);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();//line break
        System.out.println("CheckingAccount2:");
        System.out.println("-----------------");
        System.out.println("Attempting to deposit a negative number");
        //using try-catch statements to handle errors throw if bad input is given
        try {
            //trying to deposit a negative number to display how CheckingAccount class handles bad input
            checkingAccount2.deposit(-293);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();//line break
        System.out.println("Attempting to withdraw more money then account has");
        //using try-catch statements to handle errors throw if bad input is given
        try {
            //Attempting to withdraw more then currently in CheckingAccount object to display how it handles overDraft
            checkingAccount2.withdraw(10000);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    //implementing printBanner method to take a String and print a neat formated banner
    public void printBanner(String bannerMessage){
        int promtLength = bannerMessage.length() + 8;
        int i;
        for(i = 0 ; i < promtLength ; i++)
        {
            System.out.print("+");
        }

        System.out.println("\n|***" + bannerMessage + "***|");

        for(i = 0 ; i < promtLength ; i++)
        {
            System.out.print("+");
        }
        System.out.println();
    }//end of printBanner
}

