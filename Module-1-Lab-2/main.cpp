//
//  main.cpp
//  lab1-part two
//
//  Created by Jacob Sones on 9/5/25.
/*
* lab1-part two — Travel Journal App
* ----------------------------------
* This program collects travel information from the user to
* generate a simple "journal entry" about their trip.
*
* The user is prompted for:
*   - Full name
*   - Vacation location
*   - Favorite food during the trip
*   - Number of days spent on vacation
*   - Experience rating (1–10 scale)
*
* The program demonstrates:
*   - Console input/output with cin, getline(), cin.ignore()
*   - Formatting with setw(), setfill(), and manipulators
*   - Building output strings with variables for a dynamic report
*
* The result is a formatted journal entry displayed back to the user.
*/


#include <iostream>
#include <iomanip>
#include <string>
using namespace std;
//declare variables
int main(){
    string fullName;
    string location;
    string favFood;
    int daysGone;
    int experience;
   
    
    // start of welcome display to the Journal app displays "****Welcome to the Travel Journal App****|"
    cout << setfill('-') << setw(45) << " \n";
    cout << "|****Welcome to the Travel Journal App****|" << endl;
    cout << setw(44)<< " " << endl;
    cout << "So you went on a big trip, huh? Sounds cool; \nI want to hear all about it.\nLet’s make an entry in your journal about your trip.\n\n";
   

    //gets users full name
    cout << endl << setfill('=') << setw(25) << "\n ";
    cout << "what's your full name?";
    cout << endl << setfill('=') << setw(25) << "\n ";
    cout << ":";
    getline(cin,fullName);
    cout << setfill('-') << setw(24) << " ";
    cout << "\nPlease Hit [Enter] to proceed \n";
    cin.ignore();// clear leftover newline so next getline works
    
    
    // ask where they went on vaction to
    cout << endl << setfill('=') << setw(32) << "\n ";
    cout << "Where did you go on vacation:";
    cout << endl << setfill('=') << setw(32) << "\n ";
    cout << ":";
    getline(cin,location);
    cout << setfill('-') << setw(31);
    cout << "\nPlease Hit [Enter] to proceed \n\n";
    cin.ignore();// clear leftover newline so next getline works
    
    
    // uses the location variable from the past line to make the app feel more interactive aswell as asking what ther fav food is while there was
    cout << "Wow! " << location << " that's a really cool place!\n";
    cout << setfill('=') << setw(39) << "\n";
    cout << "I bet you had all types of food there! \n";
    cout << setw(39) << "\n";
    cout << "What was your favorite food you ate when in " << location << "?\n";
    cout << setw(50) << "\n";
    cout << ":";
    getline(cin,favFood);
    cout << setfill('-') << setw(39) << " ";
    cout << "\nPlease Hit [Enter] to proceed \n";
    cin.ignore();// clear leftover newline so next getline works
    
    
    // ask how long they were on vacation for
    cout << setfill('=') << setw(36) << "\n";
    cout << " How many days where you there for?\n";
    cout << setfill('=') << setw(36) << "\n" << "Please only use numeric numbers\n" << ":";
    cin >> daysGone;
    cout << setfill('-') << setw(36) << endl;
    
    
    
    // asking what they rate there vacation
    cout << setfill('=') << setw(57) << "\n";
    cout << "How would you rate your experience on a scale of [1-10]?\n";
    cout << setfill('=') << setw(57) << "\n" << ":";
    cin >> experience;
    cout << setfill('-') << setw(59) << " \n\n\n";
   
    
    
    //output for display of Journal entry
    cout << setfill('-') << setw(57) << " \n";
    cout << setfill('+') << setw(50)  << " \n";
    cout <<"******Journal Entry For The Trip To "<< location << "******\n";
    cout << setw(50) << " \n";
    cout << setfill('-') << setw(57) << " \n\n";
   
    
    
    // start of Journal entry
    cout << "Nomads name :" << fullName  << endl;
    cout << fullName << " Went on a Journy to a far, far away land called "<< location << "," << fullName << " was gone for " << daysGone << " days.\n";
    cout << "On this journey " << fullName << " had all types of foods there favorite being " <<favFood << endl;
    cout << "on a scale from 1 to 10 " << fullName << " rated their experience a " << experience << endl << endl;





    return 0;
}

