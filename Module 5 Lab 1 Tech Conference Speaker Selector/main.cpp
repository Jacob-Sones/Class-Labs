/*
 * File: main.cpp
 * Project: Tech Conference Speaker Selector
 * Author: Jacob Sones
 * Date: 10/18/2025
 *
 * Description:
 *   This file contains the main driver program for the Tech Conference Speaker Selector (TCSS).
 *   It coordinates the flow of the program by calling helper functions defined in utility.cpp
 *   through the declarations in utility.hpp.
 *
 *   The program collects and displays information about conference speakers, including:
 *     - Speaker names
 *     - Discussion topics
 *     - Length of each seminar (in minutes)
 *     - Room assignments
 *
 *   It demonstrates basic array handling, string input/output, and modular function design in C++.
 */

//Adding needed libraries and files like iostream for output and input, iomanip for display manipulation, and utility.h for function calls
#include "utility.hpp"
#include <iostream>
#include <iomanip>
using namespace std;


int main(){
    
   // Declaring and specifying the perimeter length of elements stored in arrays we are going to use, like speakerNames[6], topics[6], lengthOfDiscussing[6]
    string speakerNames[6];
    string topics[6];
    int lengthOfDiscusion[6];
    string rooms[6];
    
    
    
    //using the welcomeMessage function to display an intro to the program, welcoming the user
    welcomeMessage("TCSS(Tech Conference Speaker Selector) Program");
    
    
    //Using the getInfo function to gather info like the speaker's name, topics, and the length of the seminar room, it will be done using other functions declared and implemented in our utility file.
    getInfo(speakerNames,topics,lengthOfDiscusion,rooms, 6);
    
    
   //Using the finalDisplay function to display each speaker's name, what room they will be in, how long they will be talking for, and what they will be talking about
    finalDisplay(speakerNames, topics, rooms, lengthOfDiscusion, 6);
    
    
    searchName(speakerNames, topics, rooms, lengthOfDiscusion, 6);
    
    
}//end of main code body function
