//
//  HelperFunctions.cpp
//  Module 8 Podcast Lab
//
//  Created by Jacob Sones on 12/5/25.
//
//  Description:
//      This source file contains the implementations of all helper functions
//      used throughout the Podcast Management Program. These functions handle
//      user input validation, creation of Podcast objects, displaying all
//      podcasts, searching the podcast list, and supporting sorting operations.
//
//      The purpose of this file is to keep main() clean by modularizing all
//      reusable logic into separate helper routines. This includes validating
//      integers and strings, prompting for podcast information, building new
//      Podcast objects with a parameterized constructor, and searching the
//      vector of Podcast objects using a range-based loop.
//
//      Functions Implemented:
//          - welcomeMessage()        → Displays a formatted welcome banner.
//          - validateInt()           → Validates numeric input within a given range.
//          - getValidateString()     → Ensures user enters a non-empty string.
//          - addPodcast()            → Prompts user for podcast fields and returns a new Podcast object.
//          - displayAllPodcast()     → Loops through the vector and displays all podcasts.
//          - searchPodcastByName()   → Searches for a podcast by title and displays its information.
//          - sortByDuration()        → Comparison function used by std::sort for ordering podcasts by duration.
//
//      All functions in this file work closely with the Podcast class to provide
//      a complete user-interactive podcast management system.
//


#include "HelperFuntions.hpp"
#include <iostream>
#include <iomanip>
#include "Podcast.hpp"
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



//Implementing getValidateString to check if the user input is not empty
string getValidateString(string prompt){
    string input;
    
    //Start of a while loop to keep iterating through the loop until the if statement is met and the input variable is not empty
        while(true){
        cout << prompt << "\n:";
        getline(cin,input);
        
        //Start of if statement to check if user input is empty or not, if not empty, returns input
            if(input.length() > 0){
            return input;
        }//end of if statment
        
        cout << "Input cannot be empty please try again\n";
        
    }//end of while loop

    }//end of getValidateString function
    
  

//Implementing the addPodcast function to gather user input and create an object with it from the perimeter constructor
Podcast addPodcast(){

    //creating temporary variables to store user input to pass to the parameters of the podcast constructor
    string tempHostName;
    string tempTitle;
    string tempGenre;
    int tempDuration;
    int tempReleaseYear;
    cin.ignore(1000,'\n');
    
    //Gather user input with the getValidateString for Host Name, Title, and Genre of the podcast that's being added to make sure the user inputs something, and the fields are not blank.
    tempHostName = getValidateString("Please Enter Host Name Of Podcast");
    cout << "\n";
    
    tempTitle = getValidateString("Please Enter Title Of The Podcast");
    cout << "\n";

    tempGenre = getValidateString("Please Enter Genre Of The Podcast");
    cout << "\n";

    //Gather user input with the validateInt for the tempDuration and tempReleaseYear variables to make sure user input is an integer data type and input is in a valid range
    tempDuration = validateInt("Please Enter Duration Of The Podcast In Minutes", 0, 600);
    cout << "\n";

    tempReleaseYear = validateInt("Please Enter Release Year Of The Podcast", 2003, 2025);
    cout << "\n";

    //using a parameterized constructor to create a new Podcast object with the variable given by the user
    Podcast newPodcast(tempHostName, tempTitle, tempGenre, tempDuration, tempReleaseYear);
    
    return newPodcast;
    
}
  


void displayAllPodcast(const vector<Podcast>& list){
    int i;
    //An if statement to check if the vector is empty before going into the loop. If it is empty, a message telling the user no podcasts are currently available, directing them to add a new one. Podcast before trying again
    if(list.empty()){
        cout << "\nNo podcasts are currently available please add a new podcast and then try again\n";

    }//end of if statment
    
    
    //start of for loop to iterate through each element/object in the list vector and use the displayPodcast method on each iteration
    for(i = 0; i < list.size(); i++ ){
       //Using at() for bounds checking vectors' range
        list.at(i).displayPodcast();
        
        
    }//end of for loop
    
    cout << "\nPlease Hit [ENTER] To Continue Back To Menu\n";
   cin.ignore(1000,'\n');
    cin.get();
    
}


//Implementing the searchPodcastByName function to gather user input and loop through the podcast vector to see if it matches any of the title fields
void searchPodcastByName(const vector<Podcast> list){
    //Clearing input with cin.ignore so getline doesn't take any leftover buffer space from the user hitting enter
    cin.ignore(1000,'\n');
    //Creating temporary local variables to store the name of the podcast the user wants to search, and I so the loop doesn't throw any errors
    string tempTitle;
    bool found = false;
    int i;
    cout << setfill('=') << setw(46) << "\n";
    cout << "|***Title Of Podcast You'd Like To Search***|\n";
    cout << setw(52) << "\nTitle:";
    getline(cin,tempTitle);
    
    //Using a range based for loop to check each podcast object stored in the vector of podcasts, and checking if the title given by the user matches any of the title fields
    for(const Podcast& p : list){
      //Using an if statement to check each iteration of the for loop to see if the user input matches the title of the podcast stored in the vector
        if(tempTitle == p.getTitle()){
            cout << "\nTitle of Podcast found more info below on podcast you searched\n";
            p.displayPodcast();
            found = true;
            break;
        }//end of if statment
        
    }//end of range based for loop
  
    //Using another if statement to check if found is false and if so to then display that the Title given was not found
    if(!found){
        cout << "Sorry, the Title you entered could not be found. Select Search By Title again and try a new title, or check for spelling errors\n";
    }
    
}//end of searchPodcastByName function


//Implementing a comparison function to be used in the sort() function
bool sortByDuration(const Podcast& a, const Podcast& b) {
    return a.getDuration() < b.getDuration();
}
