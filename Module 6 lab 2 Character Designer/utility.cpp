/*
 * File: utility.cpp
 * Author: Jacob Sones
 * Date: 11/12/2025
 *
 * Description:
 * This implementation file defines the functions declared in utility.hpp for the
 * Character Designer program. It manages character creation, deletion, and display
 * features using a vector of structures. Functions include user input validation,
 * formatted output, and data handling to maintain a dynamic roster of characters.
 *
 * Functions Implemented:
 * - welcomeMessage(): Displays a formatted welcome message for the program.
 * - getPositiveInt(): Prompts and validates user input for positive integers.
 * - addCharacter(): Collects user input and adds a new character to the roster.
 * - deleteCharacter(): Searches and removes a character from the vector by name.
 * - displayCharacter(): Displays all character details from the vector.
 *
 * Dependencies:
 * - utility.hpp: Header file containing function declarations and structure definition.
 * - <vector>, <iostream>, <iomanip>, <string>
 *
 * Purpose:
 * Provides core functionality for managing a list of characters, emphasizing modular
 * programming practices, input validation, and structured data organization in C++.
 */


//adding necessary libraries
#include "utility.hpp"
#include <iomanip>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

//Message for intro to program display
void welcomeMessage(string message){
    int const COLUMN = 28;
    int messageLength = message.length();
    cout << setfill('=') << setw(COLUMN + messageLength) << " ";
    cout << "\n|*****Welcome to the " << message << "*****|\n";
    cout << setw(COLUMN + messageLength) << "\n";
    
}//end of welcomeMessage function




//Implementing the getPositiveInt function to prompt the user for a positive integer for the prompt we enter in the perimeter feild
int getPositiveInt(string prompt){
    int tempInput;
    //Asking the user to enter a positive integer input for the prompt entered in the perimeter feild
        cout << "Please enter a positive numerical value for " << prompt << "\n" << prompt << ":";
    cin >> tempInput;
    //Start of while loop to check if user input is in a valid range of a positive integer or is an actual integer data type
    while(cin.fail() || tempInput <= 0){
        cin.clear();
        cin.ignore(1000,'\n');
        cout << "Sorry, it seems you entered an invalid input. Please try again and make sure the input is a valid positive numeric value\n" << prompt << ":";
        cin >> tempInput;
        
    }//end of while loop
    
    return tempInput;
    
}//end of getPositiveInt function



//Implementing the addCharacter function to prompt the user for info like Name, job, hp, and level, and then add that to a character struct and push it back into the vector
void addCharacter(vector<character>& characterRoster){
    character p;
    string tempName;
    string tempJob;
    
    
    //gather input for new character name
    cout << "Please enter the Name of the new character\nName:";
     cin.ignore(1000,'\n');
    getline(cin,tempName);
    p.name = tempName;
    
    
    //start of while loop to check if user enters anything into the name feild of the new character
    while(p.name.empty()){
        cout << "Seems you didn't enter any info in the name feild of the new character. Please enter a name for your character\nName:";
        cin.clear();
        getline(cin,tempName);
        p.name = tempName;
        
    }//End of while loop for name
    
    
    //gather input for job role of new character
    cout <<"\nPlease enter the Job role of the new character\nJob Role:";
    getline(cin, tempJob);
    p.role = tempJob;
    
    //start of while loop to check if user enters anything into the job role feild of the new character
    while(p.role.empty()){
        cout << "Seems you didn't enter any info in the Job role feild of the new character. Please enter a role for your character\nRole:";
        cin.clear();
        getline(cin,tempJob);
        p.role = tempJob;
        
    }//End of while loop for name
    
    
    cout << "\n";
    //using the getPositiveInt function to gather info for HP and the level of the new character
    p.health = getPositiveInt("New Characters HP");
    
    cout << "\n";
    p.level = getPositiveInt("New Character lvl");
   
    characterRoster.push_back(p);
    
    cout << "\n" <<  p.name << " was added to Character list\n";
    
}//End of the addCharacter function



//Implementing the delete Character function to gather the name of the desired character that the user would like to delete, then loop through the vector, and if the name matches any of the structure fields for name, it will be deleted
void deleteCharacter(vector<character>& characterRoster){
    string tempCharacter;
    int i;
    cin.ignore(1000,'\n');
    //Gathering user input for the name of the desired character that they want to delete
    cout << "Please enter the name of the character you would like to delete from the list\nName:";
    getline(cin,tempCharacter);
    

    //Start of for loop to check each index of the vector's struct name field and to see if there is a match with the user input and the vector's elements
    for(i = 0; i < characterRoster.size(); i++){
        //Using an if statement to check if the name matches any fields of structs in the vector
        if(tempCharacter == characterRoster[i].name){
            characterRoster.erase(characterRoster.begin() + i);
            cout << tempCharacter << " was Delete from character list\n";
        }//end of if statment

    }//end of for loop
    
}//end of deleteCharacter



//Implementation of the displayCharacter function to loop through the characterRoster vector and display all characters and their related data
void displayCharacter(const vector<character>& characterRoster){
    //Checking if characterRoster is empty or not before going into a for loop to display all characters
    if(characterRoster.empty()){
        cout << "No character is currently in the list. Please add a new character, then try to display again.";
        return;
    }//end of if statment
    
    
    //start of for loop to go through the vector and display all elements in the vector and all fields of the struct 
    int i;
    for(i = 0; i < characterRoster.size(); i++){
        int sizeOfName = characterRoster[i].name.size();
        cout << setfill('=') << setw(15 + sizeOfName) << "\n";
        cout << "|Character " << (i + 1)  << " " << characterRoster[i].name << "|\n";
        cout << setw(15 + sizeOfName) << "\n";
        
        cout << "HP: " << characterRoster[i].health << "\n";
        cout << "Level: " << characterRoster[i].level << "\n";
        cout << "Job Role: " << characterRoster[i].role << "\n";
        
    }//end of for loop
    
    
    
    
    
}// end of displayCharacter function







