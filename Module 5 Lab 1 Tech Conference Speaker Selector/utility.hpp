/*
 * File: utility.hpp
 * Project: Tech Conference Speaker Selector
 * Author: Jacob Sones
 * Date: 10/18/2025
 *
 * Description:
 *   This header file declares the utility functions used by the Tech Conference Speaker Selector (TCSS).
 *   It provides function prototypes for user input, validation, and formatted output.
 *
 *   Functions declared here:
 *     - welcomeMessage()        : Displays an introduction banner for the program.
 *     - getNames()              : Collects speaker names from the user.
 *     - getTopics()             : Collects discussion topics for each speaker.
 *     - getDiscussionLength()   : Gathers the time each speaker will present.
 *     - speakersRoom()          : Collects room assignments for each speaker.
 *
 *   The file should be included in both main.cpp and utility.cpp to ensure consistent linkage.
 */

#ifndef utility_hpp
#define utility_hpp

//Adding needed libraries and files like iostream for output and input, iomanip for display manipulation.
#include <stdio.h>
#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

//Declaring function for welcome Message for the intro to program display
void welcomeMessage(string message);


//Declaring the getInfo function to use another function to get user input, like names of speakers, topics, and length
void getInfo(string speakerNames[], string topics[],int lengthOfDiscusion[],string rooms[], int size);


//declaring getNames function to gather user input for speakers’ names using getline, then storing it in the index starting at 0, going to 5 of the speakerNames[] array
void getNames(string speakerNames[], int index);


//declaring getTopics function to gather user input for topic that speakers will be going over using getline, then storing it in the index starting at 0, going to 5 of the topic[] array.
void getTopics(string topics[],string speakerNames[], int index);


//declaring getDiscussionLength function to gather user input for the length of the topic that the speaker will be going over, storing it in the index starting at 0, going to 5 of the topic[] array.
void getDiscussionLength(int lengthOfDiscusion[],string topics[], string speakerNames[], int index);


//declaring getRoom fucntion to ask what rooms the speaker will be talking in
void getRoom(string rooms[], string speakerNames[], int index);


//Creating a finalDisplay function to display the final results of all data we gathered with the getName(), getTopics(), getDiscussionLength, and getRoom() functions, neatly formatting our output.
void finalDisplay(string speakerNames[], string topics[], string rooms[], int lengthOfDiscusion[], int size);


//Declaring a function to search through the names array for a specific name after getting it from a user
void searchName(string speakerNames[], string topics[], string rooms[], int lengthOfDiscusion[], int size);

#endif /* utility_hpp */
