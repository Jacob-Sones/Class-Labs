/*
 * main.cpp
 * Module 7 Lab 2 – Game Character Builder
 *
 * Description:
 *      This is the main driver file for the Game Character Builder program.
 *      It coordinates user interaction by creating two `gameCharacter` objects,
 *      collecting their initial attributes (name, class, HP, and hit points),
 *      and then presenting a menu-driven interface that allows the user to
 *      view or modify the characters’ stats.
 *
 *      The program uses helper functions (for input, validation, and menus)
 *      and the `gameCharacter` class to demonstrate object creation, data
 *      encapsulation, and basic input validation in a console-based game
 *      character setup.
 *
 * Author: Jacob Sones
 * Date: 11/25/25
 */

#include <iostream>
#include "GameCharacter.hpp"
#include <string>
#include "helperFuntions.hpp"
#include <iomanip>
using namespace std;


int main() {
   
    //Declaring necessary variables, ie,(name, role, hp, hitPoints ), in the main to pass to setters and a parameterized constructor to create a new object from the gameCharacter class
    string name;
    string role;
    int hp;
    int hitPoints;
    int userChoice;
    int statMenuChoice;
    
    
    //Creating an object from the gameCharacter class with default constructors
    gameCharacter characterOne;
    
    
    //Using the welcomeMessage function to display a welcome message to users at the beginning of the program
    welcomeMessage("Game Character Builder");
    cout << "\n\n";


    cout << "Let's create our first character\n";
    
    //Gathering user input for the Name of the character
    name = inputName("your first character");
    
    
    cout << "\n";
    //Gathering user input for the class of the character
    role = inputClass("first character");
  
    
    cout << "\n";
    //Gathering input for HP using the validateInt function to check if it's in the range of 1-100
    hp = validateInt("Please enter HP for your first character", 1, 100);
    
    
    cout << "\n";
    //Gathering input for hitpoints using the validateInt function to check if it's in the range of 1-50
    hitPoints = validateInt("Please enter Hit Points for your first character", 1, 50);
    
  
    
    //Using setters to input data gathered in the main to the characterOne objects' private member variables
    characterOne.setName(name);
    
    characterOne.setCharacterClass(role);
    
    characterOne.setHp(hp);
    
    characterOne.setHitPoints(hitPoints);
    
    
    //Displaying a Message to the user confirming their first character has been created, then using cin.ignore and cin.get to prompt the user to hit enter to continue to the next part of the program
    cout << "\n\nGreat job, your first character " << characterOne.getName() << " has been created.\n";
    cout << "Please Hit [ENTER] To Continue\n";
    cin.ignore(1000,'\n');
    cin.get();
    cout << "\n\n";

    cout <<"Let's create a second character\n";
    
    //Gathering user input for the Name of the character
    name = inputName("your second character");
    
    
    cout << "\n";
    //Gathering user input for the class of the character
    role = inputClass("second character");
  
    
    cout << "\n";
    //Gathering input for HP using the validateInt function to check if it's in the range of 1-100
    hp = validateInt("Please enter HP for your second character", 1, 100);
    
    
    cout << "\n";
    //Gathering input for hitpoints using the validateInt function to check if it's in the range of 1-50
    hitPoints = validateInt("Please enter Hit Points for your second character", 1, 50);
    
    
    //Creating a second character object and assigning data gathered in the main for the second character in the permiters to utilize our permiterized constructor
    gameCharacter characterTwo(name, role, hp, hitPoints);
    
    
    
    cout << "\n\nGreat job, your Second character " << characterTwo.getName() << " has been created.\n";
    cout << "Please Hit [ENTER] To Proceed To The Character Menu\n";
    cin.ignore(1000,'\n');
    cin.get();
    cout << "\n\n";
    
    
    do{
        //Start of menu-driven options function: display/show options to show stats of character one or two, or to change specific character stat
        displayMenu(characterOne,characterTwo);
        //Using validateInt to make sure user input is in the range of 1 to 4
        userChoice = validateInt("Menu Option", 1, 4);
        
        
        //Start of switch to go into each option displayed on the menu, depending on the user's choice entered into the program.
        switch (userChoice) {
                //using the .characterDisplay method to display character ones stats
            case 1:
                characterOne.characterDisplay();
                
                cout << "\nPlease Hit [ENTER] To Proceed Back To Character Menu\n";
                cin.ignore(1000,'\n');
                cin.get();
                
                break;
                
                //using Getters methods to display each individual stat of character two
            case 2:
                cout << setfill('=') << setw(24) << "\n";
                cout << "|***Character Stats***|\n";
                cout << setw(24) << "\n";
                cout << "Name:" << characterTwo.getName() << "\n";
                cout << "Class:" << characterTwo.getCharacterClass() << "\n";
                cout << "HP:" << characterTwo.getHitPoints() << "\n";
                cout << "Hit Points:" << characterTwo.getHitPoints() << "\n";
               
                cout << "\nPlease Hit [ENTER] To Proceed To The Character Menu\n";
                cin.ignore(1000,'\n');
                cin.get();
                break;
                
                
                //start of case three to change specific stats of character one or two, depending on the user's choice
            case 3:
                //Displaying a menu of both characters and prompting the user to pick which character's stats they'd like to alter
                cout << setfill('=') << setw(62) << "\n";
                cout << "|***Which character would you like to alter the stats of?***|\n";
                cout << setw(62) << "\n";
                cout << setfill('-') << setw(17) << "\n";
                cout << "1:" << "Character one|\n";
                cout << "2:" << "Character two|\n";
                cout << setw(17) << "\n";
                
                //Using validateInt to prompt the user to enter either 1 or 2
                userChoice = validateInt("Choice", 1, 2);
                cout << "\n";
                
                
                //Using displayEditStatsMenu to show all valid options of stats, the user can change the character selected
                displayEditStatsMenu();
                
                //Using validateInt to prompt the user to enter options 1 to 4 from the stats menu
                statMenuChoice = validateInt("Stat Menu Choice", 1, 4);
                
                // Pass the user's character choice (userChoice), the stat they want to modify (statMenuChoice),and both character objects so runStatsMenuChoice can update the correct character's data.
                    runStatsMenuChoice(userChoice, statMenuChoice, characterOne, characterTwo);
                
     
                cout << "\nPlease Hit [ENTER] To Proceed To The Character Menu\n";
                cin.ignore(1000,'\n');
                cin.get();
                break;
                
                
            case 4:
                
                cout << "Thanks For Using Game Character Builder Hope You Have A Great Day :)\n";
                
                break;
                
        }
        
        
        
    }while(userChoice != 4);
    
    
    
    
    
    
}
