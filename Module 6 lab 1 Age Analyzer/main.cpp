/*
 * Name: Jacob Sones
 * Date: 10/31/2025
 * File: main.cpp
 *
 * Description:
 *  Entry point for the "Age Analyzer" program. It welcomes the user, creates and
 *  manages a vector of ages, and coordinates user input and analysis through
 *  utility functions. The program validates input, stores only valid ages, can
 *  display the full list, calculate the average (to two decimals), identify the
 *  highest and lowest ages, and sort the ages for presentation.
 *
 * Functions used (from utility module):
 *  - welcomeMessage(title): Displays a program greeting.
 *  - manageAgeInput(ages): Repeatedly prompts the user to add ages or exit.
 *        Internally calls getAge(ages), which asks for one age, validates it,
 *        and appends it to the vector if valid.
 *  - ageAnalyzerMenu(ages): Displays analysis options and performs the choice.
 *        Internally calls:
 *          • displayAges(ages)           — shows all ages
 *          • findAvgAge(ages)            — computes and shows the average
 *          • lowestAndHighestAges(ages)  — shows the lowest and highest ages
 *          • sortAges(ages)              — sorts the list in ascending order
 *
 * Notes:
 *  - main.cpp controls overall program flow.
 *  - All input validation, sorting, and data processing are implemented in
 *    utility.cpp and declared in utility.hpp.
 */

#include "utility.hpp"
#include <iostream>
#include <iomanip>
#include <vector>
#include <algorithm>
using namespace std;


int main(){
    //Welcoming the user to the Age Analyzer Program
    welcomeMessage("Age Analyzer Program");
    
    //Creating a vector for ages and not setting the parameters for how many elements will be stored, but rather reserving 20 spaces/elements inside the ages vector, so it does not have to keep resizing, wasting resources
    vector<int>ages;
    ages.reserve(20);
  
    
    //Calling the manageAgeInput function to display a menu inside a do-while loop, asking the user if they'd like to add an age to analyze or exit the program if the user chooses to add option. The manageAgeInput function calls another function, inside the manageAgeInput one, called getAge, which prompts the user to enter an age
    manageAgeInput(ages);

    //using displayAges function to show all ages in the ages vector neatly formated
    cout << "\n\n";
    cout << "thanks for using the Age Analyzer Program\n";
   
    //calling on the ageAnalyzerMenu function to display a menu of options to analyze the ages in the vector, like sort vector, display vector average of all ages, or the highest and lowest age
    ageAnalyzerMenu(ages);

    
    
    
    return 0;
}
