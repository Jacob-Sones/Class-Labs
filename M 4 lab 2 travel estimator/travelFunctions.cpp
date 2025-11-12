/*
 * File: travelFunctions.cpp
 * Title: Road Trip Fuel & Cost Estimator — Implementation (Module 4 – Lab 2)
 * Author: Jacob Sones
 * Date: 10/11/2025
 *
 * Description:
 *  Implements the console I/O and calculations for a simple travel estimator.
 *  Provides:
 *   - welcomeMessage(message): prints a framed welcome banner.
 *   - destinationOfTrip(): prompts and returns the trip destination (getline).
 *   - totalMiles(): prompts for miles; validates numeric input (miles ≥ 0).
 *   - mpg(): prompts for vehicle MPG; validates (MPG > 0).
 *   - costPerGallon(): prompts for fuel price; validates (price > 0).
 *   - totalGallons(miles, mpg): computes gallons needed (miles / mpg).
 *   - totalCost(gallons, cost): computes total fuel cost (gallons * price).
 *   - finalDisplay(miles, gallons, cost, destination): prints a formatted summary.
 *
 * Implementation Notes:
 *  - Uses <iostream> and <iomanip> (setfill, setw, fixed, setprecision) for output.
 *  - Uses input-guard loops with cin.clear() and cin.ignore(1000, '\n') to recover from
 *    invalid input and to handle mixed use of operator>> and getline.
 *  - Assumes validation stops at simple range checks; no currency/locale formatting.
 */

#include "travelFunctions.hpp"
#include <iostream>
#include <iomanip>
using namespace std;




//Message for intro to program display
void welcomeMessage(string message){
    int const COLUMN = 28;
    int messageLength = message.length();
    cout << setfill('=') << setw(COLUMN + messageLength) << " ";
    cout << "\n|*****Welcome to the " << message << "*****|\n";
    cout << setw(COLUMN + messageLength) << "\n";
    
}//end of welcomeMessage function


// Asking the user where they're traveling so I can include it in the final display output of the program to make the travel estimater feel more friendly and interactive
string destinationOfTrip(){
    string destination;
    cout << "Where are you traveling to?\n:";
    getline(cin, destination);
  
    return destination;
}



//Function for getting users' total miles planned to travel or already traveled.
double totalMiles(){
    double miles;
    //Start of do-while loop to make sure user enters proper data type and is in a positive range
    cout << "To continue, Please Hit [ENTER]\n";
    do{
        cin.clear();
        cin.ignore(1000,'\n');
        cout << "What is your estimated distance in miles that you have or are going to travel? Please enter only a numeric value 0 or higher. \n:";
        cin >> miles;
    }while(cin.fail() || miles < 0);
    //end of do-while loop
    
    return miles;
}//end of totalMiles function



//emplamenting function for MPG(Miles Per Gallon) for car user is traveling in
double mpg(){
    double milePerGallon;
    //Start of do-while loop to make sure user enters proper data type and is in a positive range
    do{
            cin.clear();
            cin.ignore(1000, '\n');
            cout << "What is the MPG(Miles Per Gallon) of the car you are driving for the road trip? Please enter only a numeric value higher then 0.\n:";
            cin >> milePerGallon;
        }while(cin.fail() || milePerGallon <=0);
    //end of do-while loop
    return milePerGallon;
}//end of mpg function

//emplamenting function to get cost of gas per gallon for user
double costPerGallon(){
    double costOfGollon;
    //Start of do-while loop to make sure user enters proper data type and is in a positive range
    do {
        cin.clear();
        cin.ignore(1000,'\n');
        cout << "What's the current price of gas per gallon for you?\n:";
        cin >> costOfGollon;

    }while(cin.fail() || costOfGollon <= 0);
    //End of do-while loop
    return costOfGollon;
}//end of costPerGallon function


//Implementing the totalGallons function to calculate the user's total gallons needed for the road trip
double totalGallons(double miles, double mpg){
 double total = miles / mpg;
    
    return total;
}//end of totalGallons function


//Implementing the totalCost function to calculate the total cost of gas for the road trip.
double totalCost(double gallons, double cost){
    double total = gallons * cost;
    
    
    return total;
}//end of totalCost function


//Implementing the finalDisplay function to present the location and miles it will take, as well as gallons needed, and the cost of total gas.
void finalDisplay(double milesToTravel, double gallonsOfGas, double costOfDrive, string location){
    
    cout << setfill('=') << setw(107) << " ";
    cout << "\n|Thanks for the info. Generating Final Results, hit [ENTER] for the Travel Estimator to give your results|\n";
    cout << setw(109) << " \n\n";
    cin.clear();
    cin.ignore(1000,'\n');
    cout << "You are traveling to " << location <<  ", it will take you an estimated " << milesToTravel << " miles to get to " << location << "\n\n";
    
    
    cout << "You need to have " << fixed << setprecision(2) << gallonsOfGas << " gallons of gas for the road trip, it will cost you $" << fixed << setprecision(2) << costOfDrive << "\n\n";
    
    cout << "Thanks for using the Travel Estimator program. I hope you have a great trip to " << location << " , and drive safely :).\n\n";
    
    
}





