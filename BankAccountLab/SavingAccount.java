/*
 * Name: Jacob Sones
 * Date: 04/06/2026
 * File: SavingAccount.java
 * Program: Bank Account Lab (BankAccount / SavingAccount / CheckingAccount / MainDriver)
 *
 * Description:
 * This file defines SavingAccount, a concrete subclass of BankAccount. It adds
 * interestRate, maxWithdrawLimitPerMonth, and transferLimit fields, implements
 * the abstract withdraw() and deposit() methods, and adds calculateAnnualInterest()
 * and transferMoney() as savings-specific behaviors.
 */
package BankAccountLab;

public class SavingAccount extends BankAccount implements BankActions,CalculateAnnualInterest{

    //implementation of class-specific attributes for SavingAccount, i.e., interestRate, maxWithdrawLimitPerMonth, transferLimit
    private double interestRate;
    private double maxWithdrawLimitPerMonth;
    private double transferLimit;

    //Implementation of the default constructor to assign data to new SavingAccount objects if no data is given to the parameters of the constructor on initialization
    public SavingAccount() {
        super();
        this.interestRate = 0.0;
        this.maxWithdrawLimitPerMonth = 0;
        this.transferLimit = 0.0;
    }//end of default constructor

    //Implementation of the parameterized constructor to assign data passed in the parameters to the private member attributes of new SavingAccount objects

    public SavingAccount(String bankAccountID, String routingNumber, double amount, double interestRate, double maxWithdrawLimitPerMonth, double transferLimit) {
        super(bankAccountID, routingNumber, amount);
        setInterestRate(interestRate);
        setMaxWithdrawLimitPerMonth(maxWithdrawLimitPerMonth);
        setTransferLimit(transferLimit);
    }


    //Implementation of the copy constructor to take an existing SavingAccount object and make a copy of it, assigning its values to a new SavingAccount object
    public SavingAccount(SavingAccount savingCopy){
        super(savingCopy);
        this.interestRate = savingCopy.getInterestRate();
        this.maxWithdrawLimitPerMonth = savingCopy.getMaxWithdrawLimitPerMonth();
        this.transferLimit = savingCopy.getTransferLimit();
    }//end of copy constructor


    //start of getters and setters with validation
    public double getInterestRate() {
        return interestRate;
    }//end of getInterestRate

    public void setInterestRate(double interestRate) {
        if (interestRate <= 0) {
            this.interestRate = 0.05; //setting interest rate to common rate for banks if interest rate is 0 or below
        } else {
            this.interestRate = interestRate;
        }
    }//end of setInterestRate

    public double getMaxWithdrawLimitPerMonth() {
        return maxWithdrawLimitPerMonth;
    }//end of getMaxWithdrawLimitPerMonth

    public void setMaxWithdrawLimitPerMonth(double maxWithdrawLimitPerMonth) {
        if (maxWithdrawLimitPerMonth <= 0) {
            this.maxWithdrawLimitPerMonth = 10000.0;//setting to common withdraw limit for most banks
        } else {
            this.maxWithdrawLimitPerMonth = maxWithdrawLimitPerMonth;
        }
    }//end of setMaxWithdrawLimitPerMonth

    public double getTransferLimit() {
        return transferLimit;
    }//end of getTransferLimit

    public void setTransferLimit(double transferLimit) {
        if (transferLimit <= 0) {
            this.transferLimit = 10000.0;
        } else {
            this.transferLimit = transferLimit;
        }
    }//end of setTransferLimit

    /*overriding the withdraw() method to implement custom logic/output for the saving account subclass
    subtracting amount passed in the parameters from current amount in account
     */
    @Override
    public void withdraw(double amountToWithdraw) {
        //checking if amountToWithdraw is a negative number or more then current balance
        if (amountToWithdraw <= 0 || amountToWithdraw > getAmount()) {
            System.out.println("An error occurred when trying to withdraw from the savings account. \n" +
                    "The amount can't be negative or exceed the current account balance");

            //checking if amountToWithdraw is more then maxWithdrawLimitPerMonth
        } else if (amountToWithdraw > maxWithdrawLimitPerMonth) {
            System.out.println("An error has occurred withdraw amount cant exceed maximum monthly withdraw limit");
        } else {
            System.out.println("Withdrawing " + curr.format(amountToWithdraw) + " from savings account");
            //subtracting amountToWithdraw from current balance of account
            double newAmount = getAmount() - amountToWithdraw;
            //using try-catch to utilize built in error handling from base class for setAmount
            try {
                setAmount(newAmount);

                //changing maxWithdrawLimitPerMonth based on amountToWithdraw
                maxWithdrawLimitPerMonth -= amountToWithdraw;

                //printing new amount in account after withdraw and the interest being earned on it
                System.out.println("Saving account now earning " + (interestRate * 100) + "% interest on: " + curr.format(getAmount()));
                System.out.println("Withdraw limit has been updated\nUpdated Withdraw Limit:" + curr.format(maxWithdrawLimitPerMonth));
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }//end of withdraw method

    /*overriding the deposit method to implement custom logic/output for the SavingAccount subclass
    adding amount to account and displaying new amount user is earning interest on
     */
    @Override
    public void deposit(double amountToDeposit) {

        if (amountToDeposit <= 0) {
            System.out.println("An error has occurred. Cannot deposit a negative amounts to account");
        } else {
            System.out.println("Depositing " + curr.format(amountToDeposit) + " To the savings account");
            double newAmount = getAmount() + amountToDeposit;
            //using try-catch to utilize built in error handling from base class for setAmount
            try{
                setAmount(newAmount);
                System.out.println("New account balance: " + curr.format(getAmount()));
                System.out.println("you will now be earning " + (interestRate * 100) +  "% interest on: " + curr.format(getAmount()));
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }//end of try-catch statement

        }
    }//end of deposit method

    /* Implementation of the calculateAnnualInterest method, taking the interest rate associated with the
    savings account and calculating the expected next 12 months of interest
     */
    @Override
    public void calculateAnnualInterest(){

        double finalAmount;
        double interestEarned;

        //logic/formula for calculating interest for the next 12 months
        finalAmount = getAmount() * Math.pow((1 + (interestRate / 12)),12);
        interestEarned = finalAmount - getAmount();

        //displaying expected interest earned as well new total amount with interest
        System.out.println("Account is earning " + (interestRate * 100) +"% interest on " + curr.format(getAmount()));
        System.out.println("Expected interest earned in the next 12 months: " + curr.format(interestEarned));
        System.out.println("Final balance after 12 months: " + curr.format(finalAmount));

    }//end of calculateAnnualInterest method


    /*Implementation of the transferMoney method, taking amountToTransfer and routingNumber,
    validating that amountToTransfer is not negative or exceeds the current account balance or transferLimit of the account.
     */
    public void transferMoney(double amountToTransfer, String routingNumber){

        if(amountToTransfer < 0 || amountToTransfer > getAmount() ){
            System.out.println("An error has occurred. Please make sure the amount you want to transfer is not negative or exceeds the current " +
                    "balance in the account");
        } else if (amountToTransfer > transferLimit) {
            System.out.println("An error has occurred Transfer amount cannot be more then monthly transfer limit");
        } else{
            System.out.println("Transferring: " + curr.format(amountToTransfer) + " To " + routingNumber);
            //Subtracting amountToTransfer from the balance of the current bank account, if the amountToTransfer passes validation checks, then setting it to the new account balance
            double newAmount = getAmount() - amountToTransfer;
            setAmount(newAmount);

            //Changing transferLimit to new value by subtracting amountToTransfer from transferLimit
            this.transferLimit -= amountToTransfer;


            //Printing out new account balance after transfer
            System.out.println("New account balance after transfer is: " + curr.format(newAmount));
            System.out.println("Transfer limit has been updated\nUpdated Transfer limit:" + curr.format(transferLimit));
        }
    }//end of TransferMoney method

    @Override
    public String toString() {
        return  super.toString()
                +"\n\tInterest Rate: " + (interestRate * 100) + "%"
                +"\n\tWithdraw Limit Per Month: "  + curr.format(maxWithdrawLimitPerMonth)
                +"\n\tTransfer Limit Per Month: " + curr.format(transferLimit);
    }//end of toString method
}

