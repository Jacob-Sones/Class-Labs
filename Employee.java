/*
 * Name: Jacob Sones
 * Date: March 24, 2026
 * Program: Employee Inheritance Lab
 *
 * Description:
 * This class represents a general Employee and serves as the base (superclass)
 * for other employee types. It stores basic employee information such as full name,
 * department, job title, and employee ID. The class includes constructors
 * (default, parameterized, and copy), along with getters and setters that enforce
 * basic validation. It also provides a method to return formatted employee details.
 */

package Module5Lab2;

public class Employee {
    //Implementing private member variables for the employee superclass that will be inherited for our salary and hourly subclasses
    private String fullName;
    private String department;
    private String jobTitle;
    private int employeeID;


    //Implementation of the default constructor to assign default values if none are given on the initialization of new Employee class objects
    public Employee() {
        this.fullName = "Unknown";
        this.department = "Unknown";
        this.jobTitle = "Unknown";
        this.employeeID = 111111111;
    }//end of default constructor


    /*Implementation of a parameterized constructor to assign values given in the parameters of the constructor
    to new objects on initialization, using setters to validate that the data is not empty or null for string types
    and int data types must be positive
     */
    public Employee(String fullName, String department, String jobTitle, int employeeID) {
       setFullName(fullName);
       setDepartment(department);
       setJobTitle(jobTitle);
       setEmployeeID(employeeID);
    }//end of parameterized constructor

    //Implementation of a copy constructor to create a deep copy of the object passed in the parameters and assign it to a new object
    public Employee(Employee employeeCopy){
        this.fullName = employeeCopy.getFullName();
        this.department = employeeCopy.getDepartment();
        this.jobTitle = employeeCopy.getJobTitle();
        this.employeeID = employeeCopy.getEmployeeID();
    }//end of copy constructor

    //start of getters and setters with validation for the Employee class
    public String getFullName() {
        return fullName;
    }//end of getFullName

    public void setFullName(String fullName) {
      if(fullName == null || fullName.trim().isEmpty()){
          this.fullName = "Unknown";
      }else{
        this.fullName = fullName;
        }
    }//end of setFullName

    public String getDepartment() {
        return department;
    }//end of getDepartment

    public void setDepartment(String department) {
        if(department == null || department.trim().isEmpty()){
            this.department = "Unknown";
        }else {
            this.department = department;
        }
    }//end of setDepartment

    public String getJobTitle() {
        return jobTitle;
    }//end of getJobTitle

    public void setJobTitle(String jobTitle) {
       if(jobTitle == null || jobTitle.trim().isEmpty()){
           this.jobTitle = "Unknown";
       }else {
           this.jobTitle = jobTitle;
       }
    }//end of setJobTitle

    public int getEmployeeID() {
        return employeeID;
    }//end of getEmployeeID

    public void setEmployeeID(int employeeID) {
      if(employeeID <= 0){
          this.employeeID = 111111111;
      }else {
          this.employeeID = employeeID;
      }
    }//end of setEmployeeID


//Implementing the printEmployeeInformation() method to neatly return a formatted display of all attributes stored in the Employee class
    public String printEmployeeInformation() {
       String myReturn;
       myReturn =  "++++++++++++++++++++++++++++\n";
       myReturn += "|***Employee Information***|\n";
       myReturn += "++++++++++++++++++++++++++++\n";
       myReturn += "Full Name: " + getFullName() + "\n";
       myReturn += "Department: " + getDepartment() + "\n";
       myReturn += "Job Role: " + getJobTitle() + "\n";
       myReturn += "Employee ID: " + getEmployeeID() + "\n";
       return myReturn;
    }
}
