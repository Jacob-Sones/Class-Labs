/*
 * File: main.cpp
 * Author: Jacob Sones
 * Date: 11/12/2025
 *
 * Description:
 * This is the main driver file for the Character Designer program. It serves as the
 * central control point for user interaction, managing program flow through a menu-
 * driven interface. The program allows users to create, delete, and display characters
 * stored in a vector of structures. Each option calls modular functions defined in
 * utility.hpp and implemented in utility.cpp.
 *
 * Program Overview:
 * - Displays a formatted welcome message and main menu using a do-while loop.
 * - Accepts and validates user input for menu selection.
 * - Calls addCharacter(), deleteCharacter(), and displayCharacter() based on input.
 * - Continues looping until the user chooses to exit.
 *
 * Core Concepts Demonstrated:
 * - Modular programming using header and implementation files.
 * - Dynamic data management with vectors and structures.
 * - Input validation and control flow using conditionals and loops.
 * - Function-based design to improve readability, reusability, and maintainability.
 *
 * Purpose:
 * Provides the entry point for the Character Designer application, linking all
 * supporting modules together. Demonstrates structured program flow, user-driven
 * interaction, and clean code practices consistent with C++ programming standards.
 */

//adding necessary libraries
#include <iostream>
#include "utility.hpp"
#include <iomanip>
#include <vector>
#include <string>

using namespace std;

int main(){

    //creating a vector of characters called CharacterRoster to store multiple struct character variables all in one place
    vector<character> characterRoster;
    characterRoster.reserve(10);
    
    
    int choice;
    //Start of a do-while loop to keep displaying the menu until the user inputs an option to exit
    do{
    //Display a menu of welcome messages to the program and prompt with a menu of options to choose from
    welcomeMessage("Character Design Program");
    cout << "Options" << setfill(' ') << setw(35) << "|\n";
    cout << "Add New Character" << setw(25) << ":1|\n";
    cout << "Remove Charecter" << setw(26) << ":2|\n";
    cout << "Display Charecter Roster" << setw(18) << ":3|\n";
    cout << "Exit Program" << setw(30) << ":4|\n";
    cout << setfill('-') << setw(50) << "\nChoice:";
   //Getting user input for the selected option
    cin  >> choice;
    
    //A while loop to check if the user input is in a correct range before moving on to the switch statement
    while(cin.fail() || choice <= 0 || choice >= 5){
        cout << "Sorry, it seems you entered an invalid input. Please try again and enter only a numeric value from 1 to 4\nChoice:";
        cin.clear();
        cin.ignore(1000,'\n');
        cin >> choice;
    }
    

   // going into switch statment depending on user selection
    switch(choice){
    case 1:
            cout << "\n";
            addCharacter(characterRoster);
            cout << "\n";
            break;
        
        case 2:
            
            deleteCharacter(characterRoster);
            break;
            
        case 3:
            displayCharacter(characterRoster);
            break;
            
        case 4:
            cout << "Thank you for using the Character Design Program hope you have great rest of your day :)\n";
            break;
            
            
            
        
    }//End of swich statment
        
    
    
        
        
        
        
        
    }while(choice != 4); //end of do while loop
    
    
    
    
    
    
    
    
    
    return 0;
}

