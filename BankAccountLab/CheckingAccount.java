
/*
 * Name: Elijah Jones
 * Date: 04/06/2026
 * File: CheckingAccount.java
 * Program: Bank Account Lab (BankAccount / SavingAccount / CheckingAccount / MainDriver)
 *
 * Description:
 * This file defines CheckingAccount, a concrete subclass of BankAccount. It adds
 * overdraftLimit, overdraftFee, transactionLimit, and transactionsUsed fields,
 * and implements the abstract withdraw() and deposit() methods with overdraft
 * protection and transaction limit enforcement.
 */
package BankAccountLab;

public class CheckingAccount extends BankAccount implements BankActions {

    // New attributes
    private double overdraftLimit;
    private double overdraftFee;
    private int transactionLimit;
    private int transactionsUsed;

    // Default constructor
    public CheckingAccount() {
        super();
        this.overdraftLimit = 100.0;
        this.overdraftFee = 35.0;
        this.transactionLimit = 5;
        this.transactionsUsed = 0;
    }

    // Parameterized constructor
    public CheckingAccount(String bankAccountID, String routingNumber, double amount,
                           double overdraftLimit, double overdraftFee,
                           int transactionLimit) {

        super(bankAccountID, routingNumber, amount);
        setOverdraftLimit(overdraftLimit);
        setOverdraftFee(overdraftFee);
        setTransactionLimit(transactionLimit);
    }

    // Copy constructor
    public CheckingAccount(CheckingAccount other) {
        super(other);
        this.overdraftLimit = other.overdraftLimit;
        this.overdraftFee = other.overdraftFee;
        this.transactionLimit = other.transactionLimit;
        this.transactionsUsed = other.transactionsUsed;
    }

    // Getters
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public double getOverdraftFee() {
        return overdraftFee;
    }

    public int getTransactionLimit() {
        return transactionLimit;
    }

    public int getTransactionsUsed() {
        return transactionsUsed;
    }

    // Setters
    public void setOverdraftLimit(double overdraftLimit) {
        if (overdraftLimit < 0) throw new RuntimeException("Overdraft limit cannot be negative");
        this.overdraftLimit = overdraftLimit;
    }

    public void setOverdraftFee(double overdraftFee) {
        if (overdraftFee < 0) throw new RuntimeException("Overdraft fee cannot be negative");
        this.overdraftFee = overdraftFee;
    }

    public void setTransactionLimit(int transactionLimit) {
        if (transactionLimit < 0) throw new RuntimeException("Transaction limit cannot be negative");
        this.transactionLimit = transactionLimit;
    }

    /*overriding setAmount to the current built-in validation set in the BankAccount class,
    so setAmount can set negative amount values without throwing an error
     */
    @Override
    public void setAmount(double amount) {
        if (amount < -overdraftLimit) {
            throw new RuntimeException("Amount exceeds overdraft limit");
        }
        this.amount = amount;
    }


    // Withdraw with transaction + overdraft logic
    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new RuntimeException("Withdrawal amount must be positive");
        }

        // Check transaction limit
        if (transactionsUsed >= transactionLimit) {
            throw new RuntimeException("Transaction limit reached");
        }

        if (getAmount() - amount >= -overdraftLimit) {
            setAmount(getAmount() - amount);

            transactionsUsed++;
            if (getAmount()< 0) {
                setAmount(getAmount() - overdraftFee);
                System.out.println("Overdraft used. Fee applied: $" + overdraftFee);
            }

            System.out.println("Withdraw successful");
            System.out.println("Withdrawing " + curr.format(amount) + " from checking account new balance in account is:" + curr.format(getAmount()));

        } else {
            throw new RuntimeException("Withdrawal exceeds overdraft limit");
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Deposit amount must be positive");
        }
        setAmount(getAmount() + amount);
        System.out.println("Deposit successful");
        System.out.println("Depositing " + curr.format(amount) + " to checking account new balance after deposit:" + curr.format(getAmount()));
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n\tOverdraft Limit: " + curr.format(overdraftLimit)
                + "\n\tOverdraft Fee: " + curr.format(overdraftFee)
                + "\n\tTransactions Used: " + transactionsUsed + "/" + transactionLimit;
    }
}


