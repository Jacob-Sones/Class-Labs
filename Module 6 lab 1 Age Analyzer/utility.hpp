/*
 * Name: Jacob Sones
 * Date: 10/31/2025
 * File: utility.hpp
 *
 * Description:
 *  Declarations for the Age Analyzer program. This header exposes functions for:
 *   - Welcoming the user
 *   - Managing input (with validation) and storing ages in a vector<int>
 *   - Displaying all ages
 *   - Computing summary statistics (average, lowest, highest)
 *   - Sorting ages for presentation/analysis
 *   - Showing a results menu to let the user choose what to display
 *
 * Notes:
 *  - Functions that only READ from the ages vector take a const reference.
 *  - Functions that MODIFY the ages vector take a non-const reference.
 *
 */

#ifndef utility_hpp
#define utility_hpp

#include <stdio.h>
#include <iostream>
#include <iomanip>
#include <vector>
#include <algorithm>
using namespace std;

//Declaring function for welcome Message for the intro to program display
void welcomeMessage(string message);


//Prototyping/declaring the getAge function to ask the user for age every time they click option 1
void getAge(vector<int>& ages);


//Prototyping/declaring the displayAges function to go through the ages vectors and display each one that the user inputs to the vector
void displayAges(const vector<int> ages);


//Prototyping/declaring the findAvgAge function to add all ages in the vector and then to find the average of all ages.
void findAvgAge(const vector<int> ages);


//Prototyping/declaring the lowestAndHighestAges function to sort ages in ascending order to see the lowest and highest ages
void lowestAndHighestAges(vector<int> ages);


//Prototyping/declaring the ManageAgeInput function to display a menu with a do-while loop and have either exit or add an age to the list for options
void manageAgeInput(vector<int>& ages);


//Prototyping/declaring the sortAges function to sort ages from highest to lowest in ascending order and keep it that way by having the vector pass by references, not values
void sortAges(vector<int>& ages);



//Prototyping/declaring ageAnalyzerMenu to display a menu for five options either display all ages, display the average, display the highest and lowest age in the vector, sort vector in asscending order or exit menu
void ageAnalyzerMenu(vector<int>& ages);


#endif /* utility_hpp */
