/*
 * File: utility.hpp
 * Author: Jacob Sones
 * Date: 11/12/2025
 *
 * Description:
 * This header file declares the structures and function prototypes used in the
 * Character Designer program. It defines the character struct and provides function
 * declarations for handling user input, character creation, deletion, and display.
 * The functions promote modular programming, reusability, and organized code design.
 *
 * Contents:
 * - struct character: Groups related data (name, health, level, and role) into one unit.
 * - welcomeMessage(): Displays a formatted welcome message for the program.
 * - getPositiveInt(): Validates and retrieves a positive integer from user input.
 * - addCharacter(): Adds a new character to the roster based on user input.
 * - deleteCharacter(): Removes a character from the roster by matching its name.
 * - displayCharacter(): Outputs all stored characters and their attributes.
 *
 * Purpose:
 * Provides structure and function declarations to support the Character Designer system.
 * This file acts as the interface between the main driver and implementation files,
 * enabling clean separation of logic and consistent function usage across the project.
 */


#ifndef utility_hpp
#define utility_hpp

//adding necessary libraries
#include <stdio.h>
#include <iomanip>
#include <vector>
#include <string>
using namespace std;

//Creating a struct for characters to group related data like HP level and name/role in one variable
struct character{
    string name;
    int health;
    int level;
    string role;
};


//Declaring function for welcome Message for the intro to program display
void welcomeMessage(string message);



//Declaring getPositiveInt to use in other functions to validate user input is positive for things like HP and Level when gathering input.
int getPositiveInt(string prompt);



//Declaring addChracter function to promt user to enter new character to the characterRoster vector
void addCharacter(vector<character>& characterRoster);


//Declaring the deleteCharacter function to prompt the user to enter the name of a character and then find the character in the vector and delete it from the vector
void deleteCharacter(vector<character>& characterRoster);


//Declaring the displayCharacter function to loop through a vector of structs and display each character with their hp level and job role
void displayCharacter(const vector<character>& characterRoster);

#endif /* utility_hpp */
