/*
 * helperFuntions.cpp
 * Module 7 Lab 2 – Game Character Builder
 *
 * Description:
 *      This source file implements the helper functions declared in
 *      helperFuntions.hpp for the Game Character Builder program. These
 *      functions handle user interaction tasks such as displaying formatted
 *      welcome messages, validating integer input, collecting character names
 *      and classes, showing menus, and processing menu selections to update
 *      character stats.
 *
 *      The functions work together with the `gameCharacter` class to provide
 *      a menu-driven interface that allows the user to view and edit the
 *      attributes of two character objects.
 *
 * Author: Jacob Sones
 * Date: 11/26/25
 */

#include "helperFuntions.hpp"
#include <iostream>
#include <iomanip>
#include <string>
#include "GameCharacter.hpp"
using namespace std;

//Message for intro to program display
void welcomeMessage(string message){
    int const COLUMN = 28;
    int messageLength = message.length();
    cout << setfill('=') << setw(COLUMN + messageLength) << " ";
    cout << "\n|*****Welcome to the " << message << "*****|\n";
    cout << setw(COLUMN + messageLength) << "\n";
    
}//end of welcomeMessage function




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




//Creating an inputName function to gather input using getline and return tempName to the string
string inputName(string prompt){
    
    //Creating a temporary variable for a function
    string tempName;
    int promptSize = prompt.size();
    
    cout << setfill('-') << setw(30 + promptSize) << "\n";
    cout << "|**Please Enter Name For " << prompt << "***|\n";
    cout << setw(35 + promptSize) << "\nName:";
    //using getline to capture everything, including spaces, from user input
    getline(cin,tempName);
    
    return tempName;
}//end of inputName function




//Creating an inputClass function with a menu-driven display, giving the user options 1 to 3 of Warrior, Mage, and Rogue
string inputClass(string prompt){
    
    //Creating a temporary variable for a function
    string tempClass;
    int promptSize;
    int choice;
    promptSize = prompt.size();
    
    cout << setfill('-') << setw(34 + promptSize) << "\n";
    cout << "|**Please Choose A Class For " << prompt << "***|\n";
    cout << setw(34 + promptSize) << "\n";
    cout << "1:" << setfill(' ') << setw(25) << "Warrior|\n";
    cout << "2:" << setw(25) << "Mage|\n";
    cout << "3:" << setw(25) << "Rogue|\n";
    cout << setfill('-') << setw(34) << "\nChoice:";
    
    //Gathering user input for the choice of class options
    cin >> choice;
    
    //Using a while loop to check if the user input is in the valid range of 1-3 and the correct data type
    while(cin.fail() || choice < 1 || choice > 3){
        //clearing bad input from the choice variable with cin.clear and cin.ignore
        cin.clear();
        cin.ignore(100,'\n');
        cout << "Sorry, it seems you picked an invalid option. Please try again and enter a value in the range of 1-3\nChoice:";
        cin >> choice;
        
    }//end of while loop
    

    //Creating a switch statement to go into each option and assign the tempClass variable with the corresponding case statement from the classes in the menu
    switch(choice){
        case 1:
            tempClass = "Warrior";
            break;
            
        case 2:
            tempClass = "Mage";
            break;
            
        case 3:
            tempClass = "Rogue";
            break;
            
    }//end of switch statmen
    
    
    return tempClass;
    
}//end of inputClass




//Implementing logic for the displayMenu function to show a menu option to give info about character one or two, or to change the stats of a specific character
void displayMenu(const gameCharacter char1, const gameCharacter char2){

    
    cout << setfill('=') << setw(23) << "\n";
    cout << "|***Character Menu***|\n";
    cout << setw(23) << "\n";
    cout << "1:" << "Display " << char1.getName() << " Stats" << "\n";
    cout << "2:" << "Display " << char2.getName() << " Stats" << "\n";
    cout << "3:" << "Change Stats Of Character" << "\n";
    cout << "4:" << "Exit Menu" << "\n";
    
    
    
}//end of displayMenu function




//Implementing logic for displayEditStatsMenu() to show all stats that the user can change for the character they select
void displayEditStatsMenu(){
    
    cout << setfill('=') << setw(28) << "\n";
    cout << "|***Chacter Stats Menu***|\n";
    cout << setw(28) << "\n";
    cout << setfill('-') << setw(31) << "\n";
    cout << "1:" << "Change Character Name" << setfill(' ') << setw(8) << "|\n";
    cout << "2:" << "Change Character Class" << setw(7) << "|\n";
    cout << "3:" << "Change Character Hp" << setw(10) << "|\n";
    cout << "4:" << "Change Character Hit Points|\n";
    cout << setfill('-') << setw(31) << "\n";
    
 
}//end of displayEditStatsMenu





//Implementing logic for the runStatsMenuChoice to process user selection and prompt/gather new data to be stored in the private member variable of the character object they want to alter
void runStatsMenuChoice(int characterSelected, int menuChoice,gameCharacter& char1, gameCharacter& char2){
    
    string name;
    string role;
    int hp;
    int hitPoints;
    
    //Using a switch to go into each choice of the stats menu to ask the user for new data to assign to the character, then using setters to alter the private member variables of the object(the character they selected)
    switch (menuChoice) {
        
      //start of case 1, prompting the user for a new Name for the character, then going into if statements to change the private name attribute of the character object selected
        case 1:
         
      //using the inputName function to gather user input for a new name for a character
            name = inputName("New Name");
            
            
      //Start of if statement to alter the name of character 1 or 2, depending on user selection
            if(characterSelected == 1){
                cout << "Character one's name has been updated\n";
                char1.setName(name);

            }else if(characterSelected == 2){
                cout << "Character two's name has been updated\n";
                char2.setName(name);

            }//end of if if-else statment
            
            break;
          
            
        //start of case 2, prompting the user for a new Class for the character, then going into if statements to change the private Class attribute of the character object selected
        case 2:
           
        //using the inputClass function to prompt/gather new data for a private class attribute
            role = inputClass("New Class");
            
        //Start of if statement to alter the Class of character 1 or 2, depending on user selection
            if(characterSelected == 1){
                cout << "Character one's Class has been updated\n";
                char1.setCharacterClass(role);
                
            }else if(characterSelected == 2){
                cout << "Character two's Class has been updated\n";
                char2.setCharacterClass(role);
                
            }//end of if if-else statment
            
            break;
            
        
        //start of case 3, prompting the user for a new Hp for the character, then going into if statements to change the private Hp attribute of the character object selected
        case 3:
            //using the inputClass function to prompt/gather new data for a private hp attribute
            hp = validateInt("New HP For Character", 1, 100);
            
            //Start of if statement to alter the hp of character 1 or 2, depending on user selection
            if(characterSelected == 1){
                cout << "Character one's Hp has been updated\n";
                char1.setHp(hp);
                
            }else if(characterSelected == 2){
                cout << "Character one's Hp has been updated\n";
                char2.setHp(hp);
                
            }//end of if if-else statment
            
            break;
           
            
            //start of case 4, prompting the user for a new hit points for the character, then going into if statements to change the private Hp attribute of the character object selected
        case 4:
            //using the inputClass function to prompt/gather new data for a private hitPoints attribute
            hitPoints = validateInt("New Hit Points For Character", 1, 50);
            
            //Start of if statement to alter the hp of character 1 or 2, depending on user selection
                if(characterSelected == 1){
                    cout << "Character one's Hit Points has been updated\n";
                    char1.setHitPoints(hitPoints);
                    
            }else if(characterSelected == 2){
                cout << "Character two's Hit Points has been updated\n";
                char2.setHitPoints(hitPoints);
                
            }//end of if if-else statment
            
            
            
            break;
            
    }//end of switch statment
    
  
    
    
}
