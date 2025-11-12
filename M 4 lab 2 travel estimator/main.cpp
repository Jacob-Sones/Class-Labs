/*
 * File: main.cpp
 * Title: Road Trip Fuel & Cost Estimator — Driver (Module 4 – Lab 2)
 * Author: Jacob Sones
 * Date: 10/11/2025
 *
 * Description:
 *  Program entry point that orchestrates the travel estimator workflow.
 *  It greets the user, collects inputs (destination, miles, MPG, fuel price),
 *  computes gallons needed and total fuel cost via helper functions, and prints
 *  a formatted summary.
 *
 * Notes:
 *  - Relies on functions declared in travelFunctions.hpp and implemented in
 *    travelFunctions.cpp.
 *  - Assumes basic input validation is handled by the helper functions.
 */


//Adding libraries for input output, formatting, and for my function
#include <iostream>
#include <iomanip>
#include "travelFunctions.hpp"
//Using namespace std to avoid naming conflicts and the need to do std::
using namespace std;

//main body of code
int main(){
    // Using the welcomeMessage function to welcome the user with a nicely formatted display, welcoming them to the program, and telling them what it does.
    welcomeMessage("Travel Estimator");
    
    cout << "So you're going on a trip, sounds fun, but you need to know how much the road trip is going to cost ya. I can help out with that\n\n";
    
    
    
    // Asking for the user's destination to add to the finalDestination function to make the program feel more interactive and friendly.
    string usersDestination = destinationOfTrip();
    cout << "\n\n";
    
    
    //Using the totalMiles function to get the total miles the user is planning to travel on the trip.
    double milesTraveled = totalMiles();
    cout << "\n\n";
    
    
   //Using the mpg function to get the user's miles per gallon on the car they are traveling in.
    double milesPerGallon = mpg();
    cout << "\n\n";
    
    
    //Using the costPerGallon function to ask the user what the current cost per gallon of gas is for them.
    double costOfGas = costPerGallon();
    cout << "\n\n";
    
    
    
    //Using the totalGallons function, calculate the amount of gallons of gas needed for the trip.
   double gallonsForTrip = totalGallons(milesTraveled, milesPerGallon);
    cout << "\n\n";
    
    
 // Using the totalCost function to calculate the amount of money the user will spend on gas for the road trip.
    double costOfTrip = totalCost(gallonsForTrip, costOfGas);
    cout << "\n\n";
    
    
    
    //Using the finalDisplay function to output a thank you to the user for using the program, and give them the info on how far they're going to need to travel, how many gallons they will need to get there, and how much it will cost them.
    finalDisplay(milesTraveled, gallonsForTrip, costOfTrip, usersDestination);
    
    
    
    
    
    return 0;
}
