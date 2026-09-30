/*
 * File: CDSavingsAccount.java
 * Package: BankAccountLab
 * Author: Jacob Sones
 * Date: April 17, 2026
 *
 * Concrete class representing a Certificate of Deposit (CD) savings account in the
 * Bank Account system. Extends the abstract BankAccount class to inherit shared
 * attributes such as account ID, routing number, and balance, and implements both
 * the BankActions and CalculateAnnualInterest interfaces to provide concrete behavior
 * for deposits, withdrawals, and interest calculation. This class introduces CD-specific
 * attributes including a fixed interest rate that cannot change after account creation,
 * a term length, a maturity date calculated automatically from the term length, and an
 * early withdrawal penalty applied when funds are withdrawn before the maturity date.
 * Compounding interest is calculated based on the account's term length rather than
 * a fixed 12 month period.
 */
package BankAccountLab;
import java.time.LocalDate;

public class CDSavingsAccount extends BankAccount implements BankActions, CalculateAnnualInterest{

    //Declaring CDSavingsAccount class-specific attributes
    //how long a CDSavingAccount must wait till it can pull money out without being penalized
    private int cdTermLength;
    //current date when object are initialized
    private LocalDate currentDate;
    //date when money can be withdrawn without penalty
    private LocalDate cdMaturityDate;
    //fixed interest rate for account set to final sense CD Saving Accounts interest doesnt change over the Maturity date
    private final double FIXEDINTERESTRATE;
    //penalty for early withdraw used as a percentage
    private double earlyWithdrawPenalty;


    /*Implementation of the default constructor setting CD Saving account attributes to common industry values:
     6 months for the maturity date, 4.40% interest on funds, and a 10% early withdrawal penalty
     */
    public CDSavingsAccount() {
        super();
        this.cdTermLength = 6;//common CD account term length
        this.currentDate = LocalDate.now();//setting currentDate to the local date of objects creation
        this.cdMaturityDate = LocalDate.now().plusMonths(6);//setting CD accounts maturity date to 6 months after current date
        this.FIXEDINTERESTRATE = 0.044;
        this.earlyWithdrawPenalty =0.10;
    }//end of default constructor


    /*Implementation of the parameterized constructor to assign values to private member variables based on data passed
      to the parameters. Assign the current date with the LocalDate.now() method to get the current date on initialization
      of the object, and then setting the maturity date using LocalDate.now().plusMonths(cdTermLength) which is done in the setCdTermLength setter
      to the exact date when funds are available to be withdrawn without penalty
     */
    public CDSavingsAccount(String bankAccountID, String routingNumber, double amount, int cdTermLength, double FIXEDINTERESTRATE, double earlyWithdrawPenalty) {
        super(bankAccountID, routingNumber, amount);
        setCdTermLength(cdTermLength);
        setCurrentDate(LocalDate.now());
        this.FIXEDINTERESTRATE = FIXEDINTERESTRATE;
        setEarlyWithdrawPenalty(earlyWithdrawPenalty);
    }

    //Implementation of the copy constructor to take an existing CDSavingsAccount object and make a copy of it, assigning its values to a new CDSavingsAccount object
    public CDSavingsAccount(CDSavingsAccount cdCopy){
        super(cdCopy);
        this.cdTermLength = cdCopy.getCdTermLength();
        this.currentDate = cdCopy.getCurrentDate();
        this.cdMaturityDate = cdCopy.getCdMaturityDate();
        this.FIXEDINTERESTRATE = cdCopy.getFIXEDINTERESTRATE();
        this.earlyWithdrawPenalty = cdCopy.getEarlyWithdrawPenalty();
    }//end of copy constructor


    //start of getters and setters with validation for setter checking if values are null,empty, or negative
    public double getEarlyWithdrawPenalty() {
        return earlyWithdrawPenalty;
    }//end of getEarlyWithdrawPenalty

    public void setEarlyWithdrawPenalty(double earlyWithdrawPenalty) {
       if(earlyWithdrawPenalty <= 0){
           throw new RuntimeException("Early Withdraw Penalty cannot be a negative percent");
       }
           this.earlyWithdrawPenalty = earlyWithdrawPenalty;

    }//end of setEarlyWithdrawPenalty

    public double getFIXEDINTERESTRATE() {
        return FIXEDINTERESTRATE;
    }//end of getFIXEDINTERESTRATE

    public LocalDate getCdMaturityDate() {
        return cdMaturityDate;
    }//end of getCdMaturityDate

    public void setCdMaturityDate(LocalDate cdMaturityDate) {
      if(cdMaturityDate == null ){
          throw new RuntimeException("CD Accounts Maturity date can not be empty");
      }
        this.cdMaturityDate = cdMaturityDate;
    }//end of setCdMaturityDate

    public LocalDate getCurrentDate() {
        return currentDate;
    }//end of getCurrentDate

    public void setCurrentDate(LocalDate currentDate) {
      if(currentDate == null ){
          throw new RuntimeException("Current Date can not be empty");
      }
        this.currentDate = currentDate;
    }//end of setCurrentDate

    public int getCdTermLength() {
        return cdTermLength;
    }//end of getCDTermLength

    public void setCdTermLength(int cdTermLength) {
      if(cdTermLength < 0 ){
          throw new RuntimeException("CD Savings Account can not be 0 or a negative value");
      }
        this.cdTermLength = cdTermLength;
      //setting new cdMaturity so it matches up with the new term length
       setCdMaturityDate(LocalDate.now().plusMonths(cdTermLength));
    }//end of setCdTermLength


    /* Override of the withdraw method for the CDSavingsAccount class.
     * Validates the withdrawal amount then checks if the CD has matured.
     * If not matured an early withdrawal penalty is applied to the balance,
     * if matured the withdrawal is processed normally with no penalty.
     */
    @Override
    public void withdraw(double amount){
        double newBalance;
        if(amount <= 0){
            throw new RuntimeException("An Error has occurred cannot withdraw a negative amount from balance\n");
        }else if(amount > getAmount()){
            throw new RuntimeException("An Error has occurred when trying to withdraw from CD Savings Account\n" +
                    "The amount can't exceed the current account balance\n");
        }else if(LocalDate.now().isBefore(getCdMaturityDate())){
            //calculating penalty that is applied if CD account is not mature at withdraw time
            double penaltyToBeApplied = getAmount() * getEarlyWithdrawPenalty();
            //new balance after penalty and amount have been subtracted
            newBalance = getAmount() - amount - penaltyToBeApplied;
            System.out.println("Attempting to withdraw before CD maturity date penalty will " +
                    "be applied to current account balance before withdraw");
            System.out.println("Early Withdraw Penalty: " + curr.format (penaltyToBeApplied));
            System.out.println("Withdrawing: " + curr.format(amount) + " From account");
            System.out.println("New Balance: " + curr.format(newBalance));
            System.out.println();
            //setting new balance
            setAmount(newBalance);

        } else  {
            newBalance = getAmount() - amount;
            System.out.println("CD Savings Account has reach its maturity date no penalty applied");
            System.out.println("Withdrawing " + curr.format(amount));
            System.out.println("New Balance: " + curr.format(newBalance) );
            System.out.println();
            setAmount(newBalance);
        }
    }//end of withdraw method


    /* Override of the deposit method for the CDSavingsAccount class.
     * Validates the deposit amount is greater than zero then checks if the CD
     * has matured. If matured no deposits are allowed, if not matured the
     * deposit is added to the current account balance normally.
     */
    @Override
    public void deposit(double amount){
        double newBalance;

        if(amount <= 0 ){
            throw new RuntimeException("An Error has occurred cannot deposit a negative amount to account\n");
        }else if( LocalDate.now().isAfter(getCdMaturityDate()) || LocalDate.now().isEqual(getCdMaturityDate())){
            throw new RuntimeException("CD has reached its maturity date you can not deposit new amounts to account " +
                    "balance after CD account has matured\n");
        }else{
            newBalance = getAmount() + amount;
            System.out.println("CD has not reached maturity date deposit approved adding " + curr.format(amount) + " to account balance");
            System.out.println("New Balance: " + curr.format(newBalance));
            System.out.println();
            setAmount(newBalance);
        }

    }//end of deposit method

    /* Override of the calculateAnnualInterest method for the CDSavingsAccount class.
     * Calculates the expected compounded interest earned on the CD account balance
     * using the fixed interest rate compounded monthly over one year. Displays the
     * interest rate, term length, interest earned, and expected balance to the user.
     */
    @Override
    public void calculateAnnualInterest(){
        // compounding monthly depending on termLength over 1 year (t=1)
        double newBalance = getAmount() * Math.pow(1 + (getFIXEDINTERESTRATE() / getCdTermLength()), getCdTermLength());
        double interestEarnedOnBalance = newBalance - getAmount();

        System.out.println("Calculating expected compounded interest to be earned on CD account after maturity");
        System.out.println("Interest Rate On Account: " + (getFIXEDINTERESTRATE() * 100) + "%");
        System.out.println("Term Length of CD Account: " + getCdTermLength() + " months");
        System.out.println("Starting Account Balance: " + curr.format(getAmount()));
        System.out.println("Interest earned: " + curr.format(interestEarnedOnBalance));
        System.out.println("Expected Balance: " + curr.format(newBalance));
        System.out.println();

    }//end of calculateAnnulInterest method

    @Override
    public String toString() {
        return  super.toString()
                +"\n\tFixed Interest Rate: " + ( getFIXEDINTERESTRATE() * 100) + "%"
                +"\n\tCD Term Length: "  + getCdTermLength() + " months"
                +"\n\tEarly Withdraw Penalty: " + (getEarlyWithdrawPenalty() * 100) + "%"
                +"\n\tOpened on: " + getCurrentDate()
                +"\n\tMaturity Date: " + getCdMaturityDate();
    }
}//end of CDSavingsAccount class
