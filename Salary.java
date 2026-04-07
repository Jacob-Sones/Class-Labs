/*
 * Name: Jacob Sones
 * Date: March 24, 2026
 * Program: Employee Inheritance Lab
 *
 * Description:
 * This class represents a salaried employee and extends the Employee superclass.
 * It adds additional attributes such as annual salary and monthly bonus.
 * The class includes constructors (default, parameterized, and copy) and
 * methods to calculate pay based on 24 pay periods per year. It overrides
 * the printEmployeeInformation() method to include calculated gross pay
 * for each pay period.
 */
package Module5Lab2;

import java.text.NumberFormat;

public class Salary extends Employee{

    //Implementing private member variables specific to the Salary class, being annualSalary and monthlyBonus that are used to calculate the pay stubs for Salary employees
    private double annualSalary;
    private double monthlyBonus;

    /*Implementation of the default constructor to assign default values if none are given on the initialization
     of new salary class objects, using super() to access the employees' default constructor as well, to be used
     in the salary class default constructor
     */
    public Salary() {
        super();
        this.annualSalary = 0;
        this.monthlyBonus = 0;
    }//end of default constructor


    /*Implementation of a parameterized constructor to assign values given in the parameters of the constructor to new objects on
     initialization, using setters to validate that the data is not a negative number, and super to access the Employee parameterized constructor
     */
    public Salary(String fullName, String department, String jobTitle, int employeeID, double annualSalary, double monthlyBonus) {
        super(fullName, department, jobTitle, employeeID);
       setAnnualSalary(annualSalary);
       setMonthlyBonus(monthlyBonus);
    }//end of parameterized constructor


    /*Implementation of a copy constructor to create a deep copy of the object passed in the parameters and assign
     it to a new object using super to access Employee copy constructor to pass logic to are parent class
     */
    public Salary(Salary salaryCopy){
        super(salaryCopy);
        this.annualSalary = salaryCopy.getAnnualSalary();
        this.monthlyBonus = salaryCopy.getMonthlyBonus();
    }//end of copy constructor

    //start of getters and setters with validation for the Salary class
    public double getAnnualSalary() {
        return annualSalary;
    }//end of getAnnualSalary

    public void setAnnualSalary(double annualSalary) {
        if(annualSalary < 0){
            this.annualSalary = 0;
        }else {
            this.annualSalary = annualSalary;
        }
    }//end of setAnnualSalary

    public double getMonthlyBonus() {
        return monthlyBonus;
    }//end of getMonthlyBonus

    public void setMonthlyBonus(double monthlyBonus) {
        if(monthlyBonus < 0){
            this.monthlyBonus = 0;
        }else {
            this.monthlyBonus = monthlyBonus;
        }
    }//end of setMonthlyBonus


    /*Implementation of the calculatePay method that takes the private member attributes of the Salary class,
     annualSalary, and monthlyBonus, dividing by 24 for annualSalary, as employees are paid bimonthly,
     and then dividing monthlyBonus by two, and adding both together for the gross pay of each pay period
     */
    public double calculatePay(){
        double calculatedPay;
        calculatedPay = (annualSalary / 24) + (monthlyBonus / 2);
        return calculatedPay;
    }//end of calculatePay method

    /*Implementation of the printEmployeeInformation method using @Override to implement a custom printEmployeeInformation()
     method to add additional Salary class info, like calculated paycheck for each pay period.
     */
    @Override
    public String printEmployeeInformation(){
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        String myReturn = super.printEmployeeInformation();
        myReturn += "Gross pay per period: " + curr.format(calculatePay());
        return myReturn;
    }

}
