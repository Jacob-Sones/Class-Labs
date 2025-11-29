/*
 * GameCharacter.hpp
 * Module 7 Lab 2 – Game Character Builder
 *
 * Description:
 *      This header file defines the `gameCharacter` class, which represents a
 *      customizable character in the game character builder program. The class
 *      stores core character attributes such as name, character class, hit
 *      points (HP), and attack strength. It also provides constructors for
 *      object creation, getter and setter methods for data access and
 *      modification, and a display function used to output character details.
 *
 *      This file contains only the class declaration; the method definitions
 *      are implemented in the corresponding .cpp file.
 *
 * Author: Jacob Sones
 * Date: 11/25/25
 */
#pragma once

#include <stdio.h>
#include <iostream>
using namespace std;

class gameCharacter{

//Creating private member variables for encapsulation and security of data
private:
    string name;
    string characterClass;
    int hp;
    int hitPoints;
    
    
    
    
//Creating a default constructor to assign data to member variables if none are given on the creation of the object.
public:
   gameCharacter();
    
    //Creating a prototype for a permiterized constructor to assign gameCharacter objects with the data specified in the perimeter, i.e., name, characterClass, hp, hitPoints
    gameCharacter(string charName, string charClass, int charHp, int charHitPoints);
    
    
    //Creating the prototype for the characterDisplay method to display all the info about the character, i.e.,(name, characterClass, hp, and hitPoints), stored in objects created from the gameCharacter class
    void characterDisplay();
    
    
    //Declaring prototypes for getters to return specified data stored in the member variables, ie, (name, characterClass, hp, and hitPoints).
    string getName() const;
    
    string getCharacterClass() const;
    
    int getHp() const;
    
    int getHitPoints() const;
    
    //Declaring prototypes for setters to change specified member variables, ie, (name, characterClass, hp, and hitPoints).
    void setName(string pName);
    
    void setCharacterClass(string pClass);
    
    void setHp(int pHp);
    
    void setHitPoints(int pHitPoints);
    
    
    
    
    
};
