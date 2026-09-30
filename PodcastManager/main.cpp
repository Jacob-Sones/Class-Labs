//
//  main.cpp
//  Module 8 Podcast Lab
//
//  Created by Jacob Sones on 12/5/25.
//
//  Description:
//      This file contains the main driver for the Podcast Management Program.
//      It provides a menu-based interface that allows the user to interact with
//      a dynamic list (vector) of Podcast objects. Through the menu, users can
//      add new podcasts, display all stored podcasts, search for a podcast by
//      title, sort the list by podcast duration, or exit the program.
//
//      The main function coordinates all program operations by calling helper
//      functions defined in HelperFunctions.cpp and using the Podcast class
//      defined in Podcast.hpp. It continuously displays the menu using a
//      do-while loop and validates user choices with validateInt() to ensure
//      proper program flow.
//
//      Program Features Provided in the Menu:
//          1. Add Podcast – Uses addPodcast() to gather user input and create
//             a new Podcast object, which is then added to the vector.
//          2. Display Podcast – Calls displayAllPodcast() to print all stored
//             podcasts in a formatted layout.
//          3. Search Podcast By Title – Prompts the user for a podcast title
//             and uses searchPodcastByName() to locate and display a match.
//          4. Sort Podcasts By Duration – Uses std::sort with sortByDuration()
//             to arrange the vector in ascending order of duration.
//          5. Exit Program – Ends the menu loop and terminates the program.
//
//      This file serves as the user-interaction hub and ties together all
//      supporting components of the Podcast Management application.
//

#include <iostream>
#include "HelperFuntions.hpp"
#include "Podcast.hpp"
#include <vector>
#include <algorithm>
using namespace std;



int main(){
    vector<Podcast> list;
    int choice;
    Podcast tempNewPodcast;
    
    //using the welcomeMessage function to display a welcome message to the user, introducing the program’s name
    welcomeMessage("Podcast Tracker");
    
    
   do{
    
    
    //Creating a menu of 5 options the user can choose from, including Add New Podcast, Display Podcast Info, Search Podcast By Title, Sort Podcast by Duration, and Exit Program
    cout << setfill('-') << setw(29) << "\n";
    cout << "|***Podcast Tracker Menu***|\n";
    cout << setw(29) << "\n";
    cout << setfill('=') << setw(33) << "\n";
    cout << "1: Add Podcast" << setfill(' ') << setw(19) << "|\n";
    cout << "2: Display Podcast"<< setfill(' ') << setw(15) << "|\n";
    cout << "3: Search Podcast By Title" << setfill(' ') << setw(7) << "|\n";
    cout << "4: Sort Podcasts By Duration"<< setfill(' ') << setw(5) << "|\n";
    cout << "5: Exit Program" << setfill(' ') << setw(18) << "|\n";
    cout << setfill('=') << setw(33) << "\n";
    
    //Gather user input with the validateInt function to make sure user input is in a valid range, being 1-5
    choice = validateInt("Please Enter Option", 1, 5);
    
    
    //Start of switch statement to go into each case option provided by the menu, ie, Add New Podcast, Display Podcast Info, Search Podcast By Title, Sort Podcast by Duration, and Exit Program.
    switch (choice) {
        
            //case 1 logic to add a new podcast using the addPodcast function to gather user input for new Podcast object fields and to return our object to the main to be added to the vector of Podcast objects
        case 1:
            
            tempNewPodcast = addPodcast();
            
            //Adding a new podcast to the vector using .push_back()
            list.push_back(tempNewPodcast);
            
            break;
            
            //case 2 logic to display all podcast using the displayAllPodcast function to loop through the vector and show all info about each podcast stored in the vector
        case 2:
            
            displayAllPodcast(list);
            
            break;
            
            //Case 3 logic prompts the user to enter input for the Title of the podcast the user wants to search for, and then loops through the vector of podcasts to see if any podcast title matches the user's input.
        case 3:
            searchPodcastByName(list);
            
            break;
            
            //case 4 logic using the sort() function from the algorithm library to sort by duration of all podcasts in the podcast vector
        case 4:
            sort( list.begin(), list.end(), sortByDuration);
            cout << "\nPodcast Sorted Please Hit [ENTER] To Continue Back To Menu\n";
            cin.ignore(1000,'\n');
            cin.get();
            
            break;
            
        case 5:
            cout << "thank You For Using The Podcast Tacker Hope You Have A Great Day:)\n";
            break;
            
        default:
            break;
    }
    
    
    
    
    
    
        
  }while(choice != 5);
}













