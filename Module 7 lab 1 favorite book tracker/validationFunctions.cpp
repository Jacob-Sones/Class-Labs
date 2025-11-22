/*
 * validationFunctions.cpp
 * Module 7 – Favorite Book Tracker
 *
 * Author: Jacob Sones
 * Date: 11/21/2025
 *
 * Description:
 * --------------------
 * This file provides the implementations for the helper
 * functions declared in validationFunctions.hpp. These
 * functions support safe numeric input handling and display
 * the formatted welcome banner used throughout the program.
 *
 * Implemented Functions:
 *
 *  - int validateInt(string prompt, int minNum, int maxNum)
 *      Prompts the user with a formatted message and accepts
 *      integer input within a required range. This function
 *      prevents invalid input (non-numerical values, out-of-
 *      range entries) by clearing the stream state and
 *      repeatedly requesting valid input.
 *
 *  - void welcomeMessage(string message)
 *      Outputs a stylized welcome or title banner for the
 *      application. Used for the main greeting and section
 *      transitions.
 */

#include "validationFunctions.hpp"
#include <iomanip>
#include <iostream>
using namespace std;


//Implementing a helper function validateInt to prompt the user to enter an integer in the range we specify in the parameters
int validateInt(string prompt, int minNum, int maxNum){
    int returnInt;
    int promtSize = prompt.size();
    //Displaying prompt to the user on what input the program is looking for
    cout << setfill('=') << setw(promtSize + 9) << "\n";
    cout << "|***" << prompt << "***|\n";
    cout << setw(promtSize + 9) << "\n";
    
    cout << "Please enter a valid numeric value in the range of " << minNum << " to " << maxNum << "\nNumber:";
    cin >> returnInt;
   
    
    //Using a while loop to go through and check if the user input is in the valid min to max range, and is the correct data type, and to keep reprompting till it meets the logic to break out
    while(returnInt < minNum || returnInt > maxNum || cin.fail()){
        cin.clear();
        cin.ignore(1000,'\n');
        cout << "Sorry, it seems you entered an input out of the range specified. Please try again\nReenter:";
        cin >> returnInt;
        
    }//end of while loop
    
    return returnInt;
}//end of validateInt function



//Message for intro to program display
void welcomeMessage(string message){
    int const COLUMN = 28;
    int messageLength = message.length();
    cout << setfill('=') << setw(COLUMN + messageLength) << " ";
    cout << "\n|*****Welcome to the " << message << "*****|\n";
    cout << setw(COLUMN + messageLength) << "\n";
    
}//end of welcomeMessage function
