/*
 * File: main.cpp
 * Title: Podcast Host Introduction (Module 4 – Lab 1)
 * Author: Jacob Sones
 * Date: 10/06/2025
 *
 * Description:
 *  A small console app that generates an automated introduction for a podcast
 *  episode. The program gathers the podcast name, guest’s name, discussion
 *  topic, and the expected runtime (in minutes), validates that the runtime is
 *  a positive integer, and then prints a formatted introduction using three
 *  parameterized functions.
 */

#include <iostream>
#include <iomanip>

using namespace std;

//Prototyping functions announceGuest(string name) announceTopic(string name, string topic) announceRuntime(int minutes)

void announceGuest(string guestName, string podcastName);

void announceTopic(string guestName, string topic);

void announceRuntime(int runTime ,string GuestName, string topic);


int main() {
    //declaring variables for column size for formatting
    int const LARGCOLUMN = 45;
    int const SMALLCOLUMN = 20;
    //Declaring variables for data/argument that will be passed to the function, ie, guestName, topic, and runTime
    string guestName;
    string topic;
    string podcastName;
    int runTime;

    
    //Welcome message to user
    cout << setfill('=') << setw(LARGCOLUMN + 8) << " ";
    cout << "\n|****Welcome to the Podcast Introduction Helper****|\n";
    cout << setw(LARGCOLUMN + 11) << " \n\n\n";

    
    //asking user for Podcast name
    cout << setfill('-') << setw(SMALLCOLUMN + 9) << " ";
    cout << "\n|Whats your Podcast called?|\n";
    cout << setw(SMALLCOLUMN + 9) << "\n";
    cout << "Please hit [ENTER] to continue twice after you input desired info\n:";
    getline(cin, podcastName);
    cin.ignore(1000, '\n');
    cout << "\n\n\n";
    
    
    //asking user for guest name
    cout << setw(LARGCOLUMN - 2) << " \n";
    cout << "|What guest will you be having on today?|\n";
    cout << setw(LARGCOLUMN - 2) << " \n";
    //getting user input for guestName
    cout << "Please hit [ENTER] to continue twice after you input desired info\n:";
    getline(cin, guestName);
    cin.ignore(1000, '\n');
    cout << "\n\n\n";
    
    
    //Asking for the topic the Podcast will be covering
    cout << setw(LARGCOLUMN + 6) << " ";
    cout << "\n|What topic will you be covering with your guest?|\n";
    cout << setw(LARGCOLUMN + 6) << "\n";
    // getting user input for topic
    cout << "Please hit [ENTER] to continue twice after you input desired info\n:";
    getline(cin, topic);
    cin.ignore(1000, '\n');
    //cin >> topic;
    cout << "\n\n\n";
    
    
    //Asking the Podcaster how long the episode will be, ie, the runtime of the Podcast
    cout << setw(LARGCOLUMN + 14) << " ";
    cout << "\n|What is the expected length of this episode(in Minutes)?|\n";
    cout << setw(LARGCOLUMN + 15) << "\n:";
    //getting user input for runtime of ep
    cin >> runTime;
  
    
    //While loop to check if user input is in a valid range, ie, not negative or a different data type
    while(cin.fail() || runTime < 1){
        cin.clear();
        cin.ignore(1000, '\n');
        cout << "sorry seems you enters an invalid amount of time please try again with only positive numbers and no words\n:";
        cin >> runTime;
        cout << " \n";
    }//end of while loop
    cout << " \n\n";
    cin.ignore(1000, '\n');
    
    
    cout << setfill('=') << setw(LARGCOLUMN + 43) << " ";
    cout << "\n||**Generating podcast info, hit [ENTER] to display the final result of the program**||\n";
    cout << setw(LARGCOLUMN + 43) << "\n";
    cin.get();
    
    cout << "\n\n\n\n";
   
    
    //start of function calls
    announceGuest(guestName, podcastName);
    cout << "\n\n";
   
    announceTopic(guestName, topic);
    cout << "\n";
    
    announceRuntime(runTime, guestName, topic);
    cout << "\n";
    
    return 0;
}




//implementation of functions announceGuest(string name) announceTopic(string name, string topic) announceRuntime(int minutes)

//start of announceGuest function
void announceGuest(string guestName, string podcastName){
    int lengthOfPodcast = podcastName.length();
    cout << setfill('=') << setw(20 - 2 + lengthOfPodcast) << " ";
    cout << "\n|Welcome To the " << podcastName << "|\n";
    cout << setw( 20 - 2 + lengthOfPodcast ) << "\n";
    
    cout << "Today on " << podcastName << ", we are honored to be joined by an individual who has been an inspiration to many people, a person who has faced numerous trials and tribulations, and is here today to share their story with us. Welcome " << guestName << ". So glad to finally meet you," << guestName << ".";
}// end of anounceGuest function


//start of announceTopic function
void announceTopic(string guestName, string topic){
 
    cout << "We will be talking about " << topic << " with our esteemed guest, " << guestName << ".\n";
    
    
}//end of anounceTopic function


//start of anounceRunTime function
void announceRuntime(int runTime, string guestName, string topic ){
    
    cout << "We will be talking for about " << runTime << " minutes going in depth on the introduction of " << topic << " in length, and really drill deep into " << guestName << " perspective and wisdom on " << topic << ".\n";
        
}//end of anounceRunTime function

