/*
 * File: travelFunctions.hpp
 * Title: Road Trip Fuel & Cost Estimator (Module 4 – Lab 2)
 * Author: Jacob Sones
 * Date: 10/11/2025
 *
 * Description:
 *  Declarations for a console program that estimates fuel needs and total
 *  trip cost for a road journey. The interface includes user prompts for
 *  destination, miles to travel, vehicle MPG, and fuel price; calculation
 *  helpers to compute total gallons and total cost; and a final formatted
 *  summary display.
 *
 * Notes:
 *  - Assumes miles ≥ 0, MPG > 0, and fuel price ≥ 0 (validated elsewhere).
 *  
 */

#ifndef travelFunctions_hpp
#define travelFunctions_hpp

#include <stdio.h>
#include <iostream>
#include <iomanip>
using namespace std;

#endif /* travelFunctions_hpp */

//Declaring function for welcome Message for the intro to program display
void welcomeMessage(string message);


//Declaring a function to ask the user where they are traveling to, to make the program more interactive and friendly, and include it in the finalDisplay function.
string destinationOfTrip();




//Declaring a function to ask the user total Miles traveled or planning on traveling
double totalMiles();

//Declaring a function for asking user what there cars MPG(Mile Per Gallon)
double mpg();

//Declaring a function to ask $ per gallon of gas for user
double costPerGallon();

//Declaring a function to calculate the total amount of gallons the user is going to need to get to their destination
double totalGallons(double miles, double mpg);

//Declaring a function to calculate the total cost of gas for the road trip that the user will use
double totalCost(double gallons, double cost);


//Declaring a function to display the final results of the travel estimator program to the user.
void finalDisplay(double milesToTravel, double gallonsOfGas, double costOfDrive, string location);
