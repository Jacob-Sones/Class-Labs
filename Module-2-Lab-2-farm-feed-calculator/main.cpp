//
//  main.cpp
//  lab 2 part 2 farm_labf
//
//  Created by Jacob Sones on 9/13/25.
//
//  Description:
//  This program simulates a farm readiness checker. The user enters the number
//  of animals, the current amount of feed in kilograms, and the status of the
//  tractor (ready or not). The program calculates the amount of feed per animal,
//  compares it against a recommended value being 4.50kg, and checks if the tractor is ready.
//  Based on the results, it outputs customized messages indicating whether the
//  farm is prepared for the harvest season.
//
//  Key Features:
//  - Uses formatted output (setw, setfill, setprecision) for clean console display.
//  - Dynamically adjusts setw alignment based on user input length by converting
//    numeric values into strings using `to_string` or `ostringstream`.
//  - Incorporates conditional logic to provide tailored readiness messages.
//  - Requires user input pauses (cin.get / cin.ignore) so results don’t all
//    display at once.
//
//  Sources and Citations:
//  - Idea for using `to_string` and `ostringstream` to dynamically calculate
//    the length of user input for setw formatting was adapted from guidance
//    provided by chatGPT
//As I found, I couldn't use the regular conversion as they were not strings, like I learned in class last Friday about getting the length of
//variable and adding it to setw

//adding correct lib 
#include <iostream>
#include <iomanip>
#include <cctype>
//both used for the extra formating on the in int and double convertion to be added to the setw
#include <string>
#include <sstream>
using namespace std;


int main() {
    const int SET_WIDTH = 30;
    //Intro and welcome message to the end user
    cout << setfill('*') << setw(56) << " \n";
    cout << "|-----Welcome to Ronald McDonald’s farm checker.-----|\n"
    << setw(57) << " \n\n";
    
    cout << setfill('-') << setw(93) << " \n";
    cout << "Let’s get started. I’m going to need to collect some info about your farm to get us started\n"
    << setw(94) << " \n\n";
    
    cout << setw(50) << "\n";
    cout << "|To start the farm checker Please hit [ENTER]!!!|\n"
    << setw(50) << "\n";
    cin.get();
    cout << endl;
    
    
    
    //Creating variables for the number of animals as well as the amount of feed currently available on the farm, along with whether the tractor is ready or not.
    int numberOfAnimals;
    double amountOfFeed;
    char tractorStatus;
    
    
    
    //Start of data collection, including the number of animals, the amount of feed, and the tractor's status.
    cout << "How many animals do you have on your farm currently?\n"
    << setw(54) << " \n";
    cout << "Amount of Animals:";
    cin >> numberOfAnimals;
    //turning numberOfAnimals int into a string so we can use the length function and add it to setw()
    string stringOfAnimals = to_string(numberOfAnimals);
    size_t  numberOfCharsInAnimals = stringOfAnimals.length();
    cout << setfill('=') << setw(22 + numberOfCharsInAnimals) << " \n\n\n";
    
    
    
    
    // asking for amount of food they have curently and then formating to always be two decimal places in the output
    
    cout << "How much feed do you have on the farm currently in Kg?\n"
    << setfill('-') << setw(56) << " \n";
    cout << "Amount of food in Kg:";
    cin >> amountOfFeed;
    
    
    // make a string stream to be able to hold amountOfFood in it without buging out like to_string, making it format to 6 decimals, allowing us to use it more like cout, allowing us to set fixed and setprecision to two decimals
    ostringstream lengthOfFood;
    // pipe amountOfFood variable into lengthOfFood, so the setw can fit it perfectly
    lengthOfFood << fixed << setprecision(2) << amountOfFeed;
    // grab the result as lengthOfFood and covert to a normal string with the .str() function
    string stringOfFood = lengthOfFood.str();
    //converting stringOfFood into number of space inputed to the amountOfFood variable with length() now becouse its a string now
    size_t charsOfFood = stringOfFood.length();
    //formating output to fit perfect with user input for the amount of food in kg line
    cout << setfill('=') << setw(25 + charsOfFood) << " \n\n\n";
    
    
    //gathering of tractor status, whether it's Y or N
    cout << "What is the current status of your tractor?\n"
    << setfill('-') << setw(45) << " \n";
    cout << "Is your tractor ready? y/n :";
    cin >> tractorStatus;
    cout << setfill('=') << setw(33) << " \n\n\n";
    
    //start of generating final output thanking the user for using and giving the info about animals, tractor, and feed
    cout << "Thanks for all the info. Let's generate your final results\n"
    << setfill('-') << setw(60) << " \n\n";
    //showing amount of feed per animal
    double feedPerAnimal = amountOfFeed / numberOfAnimals;
    cout << "Feed per animals:" << fixed << setprecision(2)<< feedPerAnimal << endl;
    cout << setfill('=') << setw(24) << " \n";
    
    //showing recemonded amount of feed
    cout << setfill('*') << setw(50) << " \n";
    cout << "|Recomended amount of feed per animal is 4.50Kg|\n";
    cout << setw(51) << " \n\n";
    
    // displaying the difference between the amount of feed per animal and the recommended feed
    cout << setfill('-') << setw(85) << " \n";
    cout << "|Difference between the recommended amount and the current amount of feed: " << feedPerAnimal - 4.50 << " Kg|\n";
    cout << setw(86) << " \n\n";
    
    
    
    
    // display of tractor status
    cout << "Tractor status currently is :" << (char)toupper(tractorStatus) << endl << endl << endl;
    
    
    //making user hit enter so its not all being displayed all at once
    cout << setw(41) << "\n";
    cout << "|To move on to the final step[ENTER]!!!|\n"
    << setw(41) << "\n";
    cin.ignore();
    cin.get();
    cout << endl;
    
    
    // start if statments checking wether or not theres enough feed or wether tractor status is ready
    
    if(feedPerAnimal >= 4.50 && tractorStatus == 'y') {
        cout << "You have sufficient food, and your tractor is ready. Your farm is fully prepared for the harvest season\n\n";
        
        
    }else if ( feedPerAnimal  < 4.50 && tractorStatus == 'y'){
        cout << "It looks like you're low on feed, but your tractor is ready to go. Just restock on some more feed, and you'll be looking great.\n\n";
        
        
    }else if( feedPerAnimal >= 4.50 && tractorStatus == 'n') {
        cout << " It looks like your tractor isn’t ready, but you’re doing well with feeding your animals. Go ahead and get your tractor up and ready, and you'll be all good for the harvest \n\n";
        
        
    } else {
        cout << "Looks like you don't have enough feed, and the tractor is not ready. Address these problems before trying again to see if you're prepared for harvest\n\n";

}
    
    
   return 0;
}
