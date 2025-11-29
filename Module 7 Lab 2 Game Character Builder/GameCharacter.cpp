/*
 * GameCharacter.cpp
 * Module 7 Lab 2 – Game Character Builder
 *
 * Description:
 *      This source file provides the full implementation of the `gameCharacter`
 *      class declared in GameCharacter.hpp. It defines the constructors, getter
 *      and setter methods, and the `characterDisplay()` function used to print
 *      a formatted summary of the character’s statistics. The setters also
 *      include basic input validation to ensure values such as HP and character
 *      class stay within acceptable ranges.
 *
 *      Together with the header file, this implementation supports the
 *      creation, customization, and display of game character objects for the
 *      Module 7 Lab assignment.
 *
 * Author: Jacob Sones
 * Date: 11/25/25
 */

#include "GameCharacter.hpp"
#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

//Creating the implementation for a default constructor to assign data to member variables if none are given on the creation of the object.
gameCharacter::gameCharacter(){
    
    name = "Unkown";
    characterClass = "Unkown";
    hp = 0;
    hitPoints = 0;
    
}//End of defualt constructor


//Creating an implementation for a permiterized constructor to assign game character objects with the data specified in the perimeter, i.e., name, character class, hp, hit points
gameCharacter::gameCharacter(string charName, string charClass, int charHp, int charHitPoints){
    
    name = charName;
    characterClass = charClass;
    hp = charHp;
    hitPoints = charHitPoints;
    
}//End of periterized constructor


//Creating the implementation for the characterDisplay method to display all the info about the character, i.e.,(name, characterClass, hp, and hitPoints), stored in objects created from the gameCharacter class
void gameCharacter::characterDisplay(){
    
    cout << setfill('=') << setw(24) << "\n";
    cout << "|***Character Stats***|\n";
    cout << setw(24) << "\n";
    cout << "Name:" << name << "\n";
    cout << "Class:" << characterClass << "\n";
    cout << "HP:" << hp << "\n";
    cout << "Hit Points:" << hitPoints << "\n";
    
    
    
}//End of characterDisplay function



//Declaring implementation for getters

string gameCharacter::getName() const{
    
    return name;
    
}//end of getName getter


string gameCharacter::getCharacterClass() const{
    
    return characterClass;
    
}//end of getCharacterClass getter


int gameCharacter::getHp() const{
    
    return hp;
    
}//end of getHp getter

int gameCharacter::getHitPoints() const{
    
    return hitPoints;
    
}//end of getHitPoints getter



//Declaring implementation for setters to change private data through public methods.
//Setter to change the private name variable to what is passed in the parameters of the setter
void gameCharacter::setName(string pName){
    
    name = pName;
    
}//end of setName setter



//Setter to change the characterClass private variable to what is passed in the parameters, and checking if it's in the valid list of classes the user can pick from
void gameCharacter::setCharacterClass(string pClass){
    
    //Using if and else if statements to check if the user input is in the allowed list of character classes that are presented to them
        if(pClass == "Warrior"){
        characterClass = pClass;
        
    }else if(pClass == "Mage"){
        characterClass = pClass;
   
    }else if(pClass == "Rogue"){
        characterClass = pClass;
        
    }else{
        cout << "\nSorry, it seems you entered a character not in the allowed list. Please try again, and keep in mind that input is case-sensitive, so make sure you have it spelled correctly and that the first letter is capitalized.\n";
    }//end of if statment
        
    
}//end of setCharacterClass setter



//Setter to change the HP private variable to what is passed in the parameters, checking if it's in a valid range, being 1-100
void gameCharacter::setHp(int pHp){
   
    //Using an if statement to check if pHp is in a valid range of 1 to 100, if it's not, a message will display telling them it's not valid and to try again.
        if(pHp >= 1 && pHp <= 100){
      
        hp = pHp;
        
    }else{
        
        cout << "Sorry, your input is out of range. Please make sure it's in the range of 1-100\n";
    }//end of if statment
    
}//end of setHp setter



//Setter to change the hitPoints private variable to what is passed in the parameters, checking if it's in a valid range, being 1-50
void gameCharacter:: setHitPoints(int pHitPoints){
   
    //Using an if statement to check if pHitPoints is in a valid range of 1 to 50, if it's not, a message will display telling them it's not valid and to try again.
    if(pHitPoints >= 1 && pHitPoints < 100){
        
        hitPoints = pHitPoints;
        
    }else{
        
        cout << "Sorry, your input is out of range. Please make sure it’s in the range of 1-50\n";
    }//end of if statment
    
}//end of setHitPoints setter


                            
                                   






