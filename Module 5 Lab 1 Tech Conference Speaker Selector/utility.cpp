/*
 * File: utility.cpp
 * Project: Tech Conference Speaker Selector
 * Author: Jacob Sones
 * Date: 10/18/2025
 *
 * Description:
 *   This file implements the utility functions declared in utility.hpp.
 *   These functions handle user interaction and data collection for the TCSS program.
 *
 *   Functions implemented:
 *     - welcomeMessage()      : Displays a stylized welcome message using iostream and iomanip.
 *     - getNames()            : Prompts the user for the names of all speakers.
 *     - getTopics()           : Asks what each speaker will discuss.
 *     - getDiscussionLength() : Validates and stores the time each seminar will last.
 *     - speakersRoom()        : Prompts for and records the room assignment of each speaker.
 *
 *   This file emphasizes the use of modular function design, input validation, and
 *   array management to keep the main program organized and readable.
 */

//Adding needed libraries and files like iostream for output and input, iomanip for display manipulation, and utility.h for function calls
#include "utility.hpp"
#include <iostream>
#include <iomanip>
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


//Implementation of getInfo to ask all in one function for the user's name, topic,the length of the topic and room
void getInfo(string speakerNames[], string topics[],int lengthOfDiscusion[],string rooms[], int size){
    int i = 0;
    for(i = 0; i < size; i++){
        cout << setfill('-') << setw(29) << "\n";
        cout << "|***Info About Speaker " << i + 1 << "***|\n";
        cout << setw(29);
        
        cout << "\n";
        getNames( speakerNames, i);
        cout << "\n";
        getTopics(topics, speakerNames, i);
        cout << "\n";
        getDiscussionLength(lengthOfDiscusion, topics, speakerNames, i);
        cout << "\n";
        getRoom(rooms, speakerNames, i);
      
    }
    
    
}//End of getInfo function


//Implementation of getName function to gather user input for the speaker's name using getline, then storing it in the index starting at 0, going to 5 of the speakerNames[] array.
void getNames(string speakerNames[], int index){

    cout << "Whats the name of speaker " << index + 1 << "\nName:";
    getline(cin,speakerNames[index]);
    cout << "\nPlease hit [ENTER] to continue";
    cin.ignore(1000,'\n');
    
}//End of getInput function


//Implementation of getTopic function to gather user input for speakers’ topic using getline, then storing it in the index starting at 0, going to 5 of the topics[] array.
void getTopics(string topics[],string speakerNames[], int index){
    
    cout << "What will " << speakerNames[index] << " be speaking about? \nTopic:";
    getline(cin, topics[index]);
    cout << "\nPlease hit [ENTER] to continue";
    cin.ignore(1000,'\n');
    
    
}//end of getTopics function
    


//Implementation of getDiscussionLength function to gather user input for length of speakers’ topic, then storing it in the index starting at 0, going to 5 of the lengthOfDiscussing[] array
void getDiscussionLength(int lengthOfDiscusion[],string topics[], string speakerNames[], int index){
   
    cout << "How long will " << speakerNames[index] << " be talking about " << topics[index] << " for in there ceminar? please enter in minutes\nLength Of Ceminar:";
    int tempTime;

    cin >> tempTime;
    //Using a while loop to check that the time user input is in a valid range(is positive), and is an integer and not a string or character.
    while(tempTime <= 0 || cin.fail()){
        cin.clear();
        cin.ignore(1000,'\n');
        cout << "Sorry, it seems like you entered bad input into the TSCC program. Please only enter positive numeric values. Please try again and enter the length of time " << speakerNames[index] << " will be talking about in there ceminar on " << topics[index] << "\nLength Of Ceminar:";
        cin >> tempTime;
    }//End of while loop to make sure user inputs a positive number, and also make sure it's an integer.
    cout << "\nPlease hit [ENTER] to continue";
    cin.get();
    cin.ignore(1000,'\n');
    
    lengthOfDiscusion[index] = tempTime;

}//End of getDiscussionLength
    
  
//Implementation of getRoom function to gather user input for room speakers’ will be in then storing it in the index starting at 0, going to 5 of the of rooms[] array
void getRoom(string rooms[], string speakerNames[], int index){
    
    cout << "What room will " << speakerNames[index] << " be presenting in? \nRoom:";
    getline(cin, rooms[index]);
    
}//end of getRoom function


//start of implementation of finalDisplay function passing the arrays as argument to our function being speakerName
void finalDisplay(string speakerNames[], string topics[], string rooms[], int lengthOfDiscusion[], int size){
    
    cout << setfill('=') << setw(45) << "\n";
    cout << "|Name\t\t Room\t\t Time\t\t Topic |\n";
    cout << setw(45) << "\n";

    int  i = 0;
    
    for(i = 0; i < size; i++){
        cout << speakerNames[i] << " will be talking in room " << rooms[i] << " they will be talking for " << lengthOfDiscusion[i] << " minutes about " << topics[i] << " \n\n";
        
        
    }//end of for loop
    
    
    
    
}//end of finalDisplay


//Implementing the searchName function to prompt the user for a name to search and then loop through the speakersNames array, and if there is a match, we will output the name, room, topic, and length of the speaker. If no name is found, we will prompt name not found and have it all inside a do-while loop to repeat until the user exits
void searchName(string speakerNames[], string topics[], string rooms[], int lengthOfDiscusion[], int size){
    
    
    string tempName;
    int continueOrExit;
    int i = 0;
    //start of do-while loop to keep prompting user to search for a speaker until user wants to exit
    do{
        //Display a message to the user introducing them to the speaker searcher part of the program.
        cout << setfill('=') << setw(25) << "\n";
        cout << "|***Speaker Searcher***|\n";
        cout << setw(25) << "\n";
        cout << setfill('-') << setw(34) << "\n";
        cout << "Options" << setfill(' ') << setw(27) << "|\n";
        cout << "Search For Speakers Name" << setw(10) << ":1 |\n";
        cout << "Exit Speaker Search" << setw(15) << ":2 |\n";
        cout << setfill('-') << setw(35) << " \n";
        //Asking user to pick if they want to continue or exit the speaker searcher loop
        cout << "Hit [ENTER] to continue after entering the Speaker's name\n";
        cout << "Option :";
        cin >> continueOrExit;
        cin.ignore(1000,'\n');
        
        
        //using a while loop to make sure user input in in a correct range and is a int
        while( cin.fail() || continueOrExit < 1 || continueOrExit > 2){
            cin.clear();
            cin.ignore(1000, '\n');
            cout << "Sorry, it looks like you entered an invalid range or a non-numeric value. Please try again and enter 1 or 2\n";
            cout << "Hit [ENTER] to continue after entering the Speaker's name\n";
            cout << "Option :";
            cin >> continueOrExit;
            cin.ignore(1000,'\n');
        }//End of while loop
       
        //Using an if statement so if the user selects 2 code breaks and ends right here, and doesn't output the rest of the program
        if(continueOrExit == 2){
            break;
        }//end of if statment
        cout << "\n";
        
        
        //Asking the user for the name of the speaker they'd like to search.
        cout << "Who would you like to search for?\nName:";
        getline(cin,tempName);
        cout << "\n";
        //Using a for loop to go through the speakerNames array and find a match for the user's input.
        for(i = 0; i <= 6; i++){
            if(tempName == speakerNames[i]){
                cout << speakerNames[i] << " will be at the Tech Conference and will be talking about " << topics[i] << " for " << lengthOfDiscusion[i] << " minutes in room " << rooms[i] << "\n\n";
                break;
            }else if(i == 6){
                cout << "Sorry, the Name you entered is not on the itinerary of the Tech Conference speakers. If you had a typo or want to look up another name, please re-enter a name.\n\n";
               
            }
            
            
        }//End of for loop
        
      //End of do-while loop
    } while(continueOrExit != 2);
    
    
    
}//End of searchName function
