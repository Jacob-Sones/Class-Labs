/*
 * helperFunctions.hpp
 * Module 7 Lab 2 – Game Character Builder
 *
 * Description:
 *      This header file declares a collection of helper and utility functions
 *      used throughout the Game Character Builder program. These functions
 *      support user interaction, input validation, menu display, and character
 *      stat editing. By separating these operations from the main program and
 *      class definitions, the file keeps the code organized, modular, and easy
 *      to maintain.
 *
 *      Key functionality includes:
 *          - Displaying the program’s welcome message
 *          - Validating numeric input within a given range
 *          - Collecting user-entered character names and classes
 *          - Displaying menus for viewing or editing character stats
 *          - Processing user choices to update the selected character object
 *
 * Author: Jacob Sones
 * Date: 11/26/25
 */
#pragma once
#include <stdio.h>
#include <iostream>
#include "GameCharacter.hpp"
using namespace std;


//Declaring function for welcome Message for the intro to program display
void welcomeMessage(string message);



//Declaring a helper function to validate integer values
int validateInt(string prompt, int minNum, int maxNum);

//Declaring a prototype for inputName to gather the name for the character and return it to the string
string inputName(string prompt);


//Declaring a prototype for inputClass to get the user's choice on three classes: Warrior, Mage, and Rogue
string inputClass(string prompt);


//Declaring a prototype for the displayMenu function to display a menu of options to pick from to display character info or change character states
void displayMenu(const gameCharacter char1, const gameCharacter char2);


//Declaring prototype displayEditStatsMenu() to show all stats that the user can change for the character they select
void displayEditStatsMenu();


//Declaring prototype for runStatsMenuChoice process user choice and alter selected stat for the character selected ie character1 or character2
void runStatsMenuChoice(int characterSelected, int menuChoice,gameCharacter& char1, gameCharacter& char2);
