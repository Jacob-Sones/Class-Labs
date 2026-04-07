/*
 * Name: Jacob Sones
 * Date: March 24, 2026
 * Program: Employee Inheritance Lab
 *
 * Description:
 * This class serves as the driver program to test the Employee, Salary,
 * and Hourly classes. It creates multiple employee objects using
 * parameterized constructors, including examples with invalid data to
 * demonstrate validation. The program stores all employees in an ArrayList
 * and uses polymorphism to iterate through the list and display each
 * employee’s information using overridden methods.
 */
package Module5Lab2;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {

    static void main() {
        //Creating 4 new objects for each Salary subclass and Hourly subclass one being with bad input to display validation of constructor
        Hourly employee1 = new Hourly("Daniel Carter","HR","HR receptionist",901293923,14.50,38);
        Hourly employee2 = new Hourly("Sophia Ramirez","Cleaning","janitor",901584756,17.25,48);
        Hourly employee3 = new Hourly("Olivia Chen","Games","Game operator",901935612,11,30);
        Hourly employee4 = new Hourly(" ","",null,-2937,-15,-10);

        Salary employee5 = new Salary("Ethan Walker","HR","HR Manager",901294503,90000,500);
        Salary employee6 = new Salary("Isabella Torres","IT","Help Desk Technician",901208942,58000,1000);
        Salary employee7 = new Salary("Jason Patel","IT","senior developer",901284790,120000, 1500);
        Salary employee8 = new Salary("","     ",null, -2934, -20000, -203);




        /*Creating an ArrayList called employeeList that stores the superclass Employee as the data type stored in the list
        to facilitate polymorphism, to allow both subclasses of employee, being hourly and Salary, to be stored in one list,
        to be used to loop through all employees and display information using a temporary array to populate an ArrayList
        with all Salary and Hourly objects using the asList method
         */
        ArrayList<Employee> employeeList = new ArrayList<>(Arrays.asList(employee1,employee2,employee3,employee4,employee5,employee6,employee7,employee8));

        /*Implementation of an enhanced for loop to go through our employeeList and use the overridden
        printEmployeeInformation() method for each object in the ArrayList
         */
        for(Employee employee : employeeList){
            System.out.println(employee.printEmployeeInformation());
        }
    }
}
