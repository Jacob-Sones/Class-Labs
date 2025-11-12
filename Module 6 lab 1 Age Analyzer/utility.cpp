/*
 * Name: Jacob Sones
 * Date: 10/31/2025
 * File: utility.cpp
 *
 * Description:
 *  Implements the Age Analyzer functions declared in utility.hpp. This file
 *  handles all logic for welcoming the user, collecting validated ages,
 *  displaying age lists, calculating the average, finding the lowest and
 *  highest ages, and sorting the vector of ages for analysis.
 *
 * Internal call relationships:
 *  - manageAgeInput(ages) calls getAge(ages) to prompt once for a new age,
 *    validate it, and add it to the list.
 *  - ageAnalyzerMenu(ages) displays a results menu and, based on the user's
 *    choice, calls:
 *       • displayAges(ages)           — prints all ages
 *       • findAvgAge(ages)            — calculates and prints the average
 *       • lowestAndHighestAges(ages)  — displays lowest and highest ages
 *       • sortAges(ages)              — sorts the list and shows it
 *
 * Notes:
 *  - Functions that only read from the vector take const references.
 *  - Sorting is used so the user can easily see ages in ascending order.
 */

#include "utility.hpp"
#include <iostream>
#include <iomanip>
#include <vector>
#include <algorithm>;
using namespace std;

//Message for intro to program display
void welcomeMessage(string message){
    int const COLUMN = 28;
    int messageLength = message.length();
    cout << setfill('=') << setw(COLUMN + messageLength) << " ";
    cout << "\n|*****Welcome to the " << message << "*****|\n";
    cout << setw(COLUMN + messageLength) << "\n";
    
}//end of welcomeMessage function



// start of implementation of logic for the getAge function
void getAge(vector<int>& ages){
    int tempAge;
    //asking for Age
    cout << "Please only enter positive whole numbers\n";
    cout << "Add an Age to the list\nAge:";
    cin >> tempAge;
    
    
    //Using a while loop to make sure that the user's input is a positive number and is an integer data type
    while(cin.fail() || tempAge <= 0){
        cin.clear();
        cin.ignore(1000,'\n');
        cout << "Sorry, it seems you entered an invalid input. Please only enter a Positive numeric value larger than 0\nAge:";
        cin >> tempAge;
      
    }//end of while loop for input validation

    ages.push_back(tempAge);
    
}//End of getAge function



//Implementing the displayAges function, go through the vector and display each age in it
void displayAges(const vector<int> ages){
    int i;
    cout << setfill('=') << setw(25) << "\n";
    cout << "|***All Ages In List***|\n";
    cout << setw(25) << "\n";
    
    //Start of for loop to go through each index of the ages vector and end once i is larger than the size of ages
    for(i = 0; i < ages.size(); i++){
        cout << "Age " << i + 1 << ": " << ages[i] << " years old\n";
        
        
    }//end of for loop
        
    
}//end of displayAges function



//Implementation of the findAvgAge function to add all ages in the vector, then divide by the total number of elements in the vector to get the average
void findAvgAge(const vector<int> ages){
    double avgAge;
    int totalAges = 0;
    int i;
    //Start of for loop to go through all elements in ages and add to the totalAges variable.
    for(i = 0; i < ages.size(); i++){
        totalAges += ages[i];
        
    }//End of for loop
    avgAge = static_cast<double>(totalAges) / ages.size();
    cout << "Avarage of all ages is:" << fixed << setprecision(2) << avgAge;
}//End of findAvgAge function



//Implementing the sortAges function to sort ages in ascending order, so I can display the lowest and highest ages in the ages vector
void lowestAndHighestAges(vector<int> ages){
    sort(ages.begin(), ages.end());
    cout <<"The lowest and the highest ages in the list are:\n";
    cout << "Lowest age is :" << ages.front() << "\n";
    cout << "Highest age is :" << ages.back() << "\n";
    
}//End of the sortAges function

//Implementing the sortAges function to sort ages from highest to lowest in ascending order and keep it that way by having the vector pass by references, not values
void sortAges(vector<int>& ages){
    sort(ages.begin(), ages.end());
    displayAges(ages);
    
    
    
}//End of sortAges function



//Implementing manageAgeInput to prompt the user with a menu using a do-while loop to keep the menu running until the user exits, also gives the option to add age to the list, which will then go into the getAge function if selected.
void manageAgeInput(vector<int>& ages){
    
    int const LARGECOLUMN = 40;
    int const SMALLCOLUMN = 20;
    int choice;
    
    
    //Start of do-while loop to keep asking user if they'd like to add a new age or exit, and see the results of the Age Analyzer Program
    do{
        
        
        //Displaying a menu for options to add an age or to exit and get the results of the Age Analyzer Program
        cout << setfill('-') << setw(LARGECOLUMN - 2) << " ";
        cout << "\n|***Choose an option -1 through 1***|\n";
        cout << setw(LARGECOLUMN - 2) << "\n";
        
        
        cout << setw(LARGECOLUMN) << "\n";
        cout << "Options" << setfill(' ') << setw(LARGECOLUMN - 7) << "|\n";
        cout << "Exit and display final results" << setw(SMALLCOLUMN - 10) << ":-1|\n";
        cout << "Add an age to the list" << setw(SMALLCOLUMN - 2) << ":1 |\n";
        cout << setfill('-') << setw(LARGECOLUMN) << "\n";
        
        
        //asking the user for an option to be chosen
        cout << "Options Choice\n:";
        cin >> choice;
        
        //Creating a while loop to check if user input is in a valid range and is in the correct data type
        while(cin.fail() || choice < -1 || choice > 1 || choice == 0 ){
            cin.clear();
            cin.ignore(1000,'\n');
            cout << "Sorry, the option you entered is out of range or is not a numeric value. Please try again and enter only -1 or 1 to choose an option\nOptions Choice\n:";
            cin >> choice;
        }//end of while loop for input validation
        
        
        //Creating an if-else statement to check if the choice variable is = to -1, which is to exit the program if it is, then to go into a break statement, and get out of the loop, and not run the rest of the code in the do-while loop
        if(choice == -1){
            break;
        }else{
            //Using the getAge function to prompt the user for age and check if it's in a valid range and correct data type, then storing that in the ages vector
            getAge(ages);
        }//End of if-else statment
        
        
    
        
        
    }while(choice != -1);//End of do-while loop
   
    
}//End of manageAgeInput function



//Implementation of the ageAnalyzerMenu to display a menu of 1-5 options: either display all ages, display the average, or display the highest and lowest age in the vector or sort vector in asscending order
void ageAnalyzerMenu(vector<int>& ages){
    int choice;
    do{
        //Creating a menu to display three options to pick from to analyze ages
        cout << setfill('=') << setw(43) << "\n";
        cout << "|***Age Analyzer Menu pick options 1-5***|\n";
        cout << setw(43) << "\n";
        
        cout << setfill('-') << setw(45) << "\n";
        cout << "Options" << setfill(' ') << setw(38) << "|\n";
        cout << "Display All Ages" << setw(29) << ":1|\n";
        cout << "Display Average Age" << setw(26) << ":2|\n";
        cout << "Display Lowest and Highest Ages" << setw(14) << ":3|\n";
        cout << "Sort all ages in ascending order" << setw(13) << ":4|\n";
        cout << "Exit Age Analyzer Menu" << setw(23) << ":5|\n";
        cout << setfill('-') << setw(45) << "\n";
        cout << "Option choice:";
        cin >> choice;
        
        //While loop to make sure user input is in range of 1-3 and is an integer
        while(cin.fail() || choice < 1 || choice > 5){
            cin.clear();
            cin.ignore(1000,'\n');
            cout << "Sorry, it seems you entered an invalid option. Please only enter numeric values between 1 and 5\nOption :";
            cin >> choice;
            
        }//End of while loop
        
        // Start of if statement to check if the user chooses option four, and if so, exit the do-while loop
        if(choice == 5){
            break;
            
        }//End of if statment
        
        //Start of switch statement to go into code depending on the option chosen from the menu
        switch (choice) {
            case 1:
                cout << "\n";
                displayAges(ages);
                cout << "\n";
                break;
                
            case 2:
                cout << "\n";
                findAvgAge(ages);
                cout << "\n";
                break;
                
            case 3:
                cout << "\n";
                lowestAndHighestAges(ages);
                cout << "\n";
                break;
          
            case 4:
                cout << "\n";
                sortAges(ages);
                cout << "\n";
                break;
        }//End of switch statement
        
    }while(choice != 5);//End of do-while loop
    
}//End of the ageAnalyzerMenu


