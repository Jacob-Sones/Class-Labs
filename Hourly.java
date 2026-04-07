/*
 * Name: Jacob Sones
 * Date: March 24, 2026
 * Program: Employee Inheritance Lab
 *
 * Description:
 * This class represents an hourly employee and extends the Employee superclass.
 * It introduces attributes for hourly rate and hours worked. The class includes
 * constructors (default, parameterized, and copy) and calculates weekly pay,
 * including overtime at 1.5 times the hourly rate for hours worked beyond 40.
 * It overrides the printEmployeeInformation() method to include the employee's
 * weekly gross pay.
 */
package Module5Lab2;

import java.text.NumberFormat;

public class Hourly extends Employee{
    //Implementing private member variables specific to the Hourly class, being hourlyRate and hoursWorked, that are used to calculate weekly pay for hourly employees
    private double hourlyRate;
    private double hoursWorked;


    //initializing the default constructor to assign values if none are passed at the initialization of a new object
    public Hourly() {
        super();
        this.hourlyRate = 0;
        this.hoursWorked = 0;
    }//end of default constructor



    //Implementation of the parameterized constructor to assign values passed to the constructor on initialization, to assign values to new objects using built-in setters for data validation.
    public Hourly(String fullName, String department, String jobTitle, int employeeID, double hourlyRate, double hoursWorked) {
        super(fullName, department, jobTitle, employeeID);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }//end of parameterized constructor



    //Implementation of a copy constructor to create a deep copy of the object passed in the parameters and assign it to a new object
    public Hourly(Hourly hourlyCopy){
        super(hourlyCopy);
       this.hourlyRate = hourlyCopy.getHourlyRate();
        this.hoursWorked = hourlyCopy.getHoursWorked();
    }//end of copy constructor



    //start of getters and setters with validation for the Hourly class
    public double getHourlyRate() {
        return hourlyRate;
    }//end of getHourlyRate

    public void setHourlyRate(double hourlyRate) {
       if(hourlyRate < 0 ){
           this.hourlyRate = 0;
       }else {
           this.hourlyRate = hourlyRate;
       }
    }//end of setHourlyRate

    public double getHoursWorked() {
        return hoursWorked;
    }//end of getHoursWorked

    public void setHoursWorked(double hoursWorked) {
        if(hoursWorked < 0 || hoursWorked > 168){
            this.hoursWorked = 0;
        }else {
            this.hoursWorked = hoursWorked;
        }
    }//end of setHoursWorked


    /*Implementation of the printEmployeeInformation method using @Override to implement a custom printEmployeeInformation()
    method to add additional Hourly class info, like calculated paycheck for each pay period.
     */

    public double calculatePay(){
        double totalPayForWeek;
        double overTimeHours;
        if(hoursWorked > 40){
            overTimeHours = hoursWorked -40;
            totalPayForWeek = hourlyRate * 40 + hourlyRate * 1.5 * overTimeHours;
        }else {
            totalPayForWeek = hourlyRate * hoursWorked;
        }
        return  totalPayForWeek;
    }

    /*Implementing the printEmployeeInformation() method to neatly return a formatted display of all
    attributes stored in the Hourly subclass, using @Override to make a new version of the method and
    add attributes specific to the Hourly subclass
     */
    @Override
   public String printEmployeeInformation(){
        NumberFormat curr = NumberFormat.getCurrencyInstance();
       String myReturn = super.printEmployeeInformation();
       myReturn += "Weekly Pay Check: " + curr.format(calculatePay());
       return  myReturn;
    }//end of printEmployeeInformation

}
