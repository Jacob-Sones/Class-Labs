//
//  HelperFunctions.hpp
//  Module 8 Podcast Lab
//
//  Created by Jacob Sones on 12/5/25.
//
//  Description:
//      This header file declares all helper functions used throughout the
//      Podcast Management Program. These functions support input validation,
//      podcast creation, searching, sorting, and displaying information from
//      the vector of Podcast objects.
//
//      The functions defined here help keep main() clean by separating
//      reusable logic such as validating integers and strings, adding new
//      Podcast objects, listing all podcasts, and searching for a podcast
//      by its title. A comparison function is also provided for sorting by
//      podcast duration.
//
//      Functions Declared:
//          - welcomeMessage()        → Displays a formatted program introduction.
//          - validateInt()           → Validates integer input within a range.
//          - getValidateString()     → Ensures the user enters a non-empty string.
//          - addPodcast()            → Builds and returns a complete Podcast object.
//          - displayAllPodcast()     → Prints all Podcast objects in the vector.
//          - searchPodcastByName()   → Searches for a podcast by title.
//          - sortByDuration()        → Comparison function used for sorting Podcast objects.
//
//      This file is included in multiple .cpp files and provides a centralized
//      location for function declarations to promote reusability and modular design.
//

#pragma once

#include <stdio.h>
#include <iostream>
#include <iomanip>
#include "Podcast.hpp"
#include <vector>
using namespace std;

//Declaring function for welcome Message for the intro to program display
void welcomeMessage(string message);


//Declaring a helper function to validate integer values
int validateInt(string prompt, int minNum, int maxNum);

//prototyping getValidateString to check if user input is not empty
string getValidateString(string prompt);


//prototyping the addPodcast function
Podcast addPodcast();

//Prototyping the displayAllPodcast function to loop through the podcast vector and show all info of every object in the vector of podcast objects
void displayAllPodcast(const vector<Podcast>& list);


//Prototyping the searchPodcastByName function to gather user input and loop through the podcast vector to see if it matches any of the title fields
void searchPodcastByName(const vector<Podcast> list);

//prototyping the sortByDuration comparison function to be used in the sort() function
bool sortByDuration(const Podcast& a, const Podcast& b);
