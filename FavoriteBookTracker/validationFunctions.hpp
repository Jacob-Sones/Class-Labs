/*
 * validationFunctions.hpp
 * Module 7 – Favorite Book Tracker
 *
 * Author: Jacob Sones
 * Date: 11/21/2025
 *
 * Description:
 * --------------------
 * This header file declares reusable input-validation and
 * display-support functions used throughout the Favorite
 * Book Tracker program. These functions provide safe user
 * input handling and a consistent formatted introduction
 * message for the application.
 *
 * Provided Functions:
 *  - int validateInt(string prompt, int minNum, int maxNum);
 *        Prompts the user for an integer and enforces a
 *        valid numeric range. Prevents invalid, non-numeric,
 *        or out-of-range input from entering the program.
 *
 *  - void welcomeMessage(string message);
 *        Displays a centered or formatted "welcome" message
 *        used for program start-up and menu transitions.
 */

#ifndef validationFunctions_hpp
#define validationFunctions_hpp

#include <stdio.h>
#include <iomanip>
#include <iostream>
using namespace std;

//Declaring a helper function to validate integer values
int validateInt(string prompt, int minNum, int maxNum);

//Declaring function for welcome Message for the intro to program display
void welcomeMessage(string message);


#endif /* validationFunctions_hpp */
