//
//  Utilities.cpp
//  M 5 Lab 2 Shopping Cart Summary
//
//  Created by Jacob Sones on 10/23/25.
//
//  --------------------------------------------------------------
//  FILE PURPOSE:
//  This file contains the function definitions (implementations)
//  declared in Utilities.hpp. Each function performs a specific
//  operation used by the main program, such as displaying messages,
//  formatting product listings, calculating totals, and computing tax.
//
//  RELATIONSHIP TO OTHER FILES:
//  - Implements all function prototypes declared in Utilities.hpp.
//  - Called by main.cpp to handle calculations and output formatting.
//
//  OVERALL FUNCTION:
//  Provides the core logic and display functions for the Shopping
//  Cart Summary program.
//  --------------------------------------------------------------


#include "Utilities.hpp"
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

//Start of implementation of shoppingCartDisplay to show all items in cart and their corresponding prices on the right
void shoppingCartDisplay(string productNames[], double productPrices[] ){
    
          cout << setfill('=') << setw(39) << " \n";
          cout << "|***Graveyard Goods Shopping Cart***|\n";
          cout << setw(38) << "\n";
          cout << setfill('-') << setw(29) << "\n";
      
      cout << productNames[0] << setfill(' ') << setw(15) << "$:" << fixed << setprecision(2) << productPrices[0] << "|\n";
      cout << productNames[1] << setfill(' ') << setw(18) << "$:" << fixed << setprecision(2) << productPrices[1] << "|\n";
      cout << productNames[2] << setfill(' ') << setw(12) << "$:" << fixed << setprecision(2) << productPrices[2] << "|\n";
      cout << productNames[3] << setfill(' ') << setw(13) << "$:" << fixed << setprecision(2) << productPrices[3] << "|\n";
      cout << productNames[4] << setfill(' ') << setw(8) << "$:" << fixed << setprecision(2) << productPrices[4] << "|\n";
      
      cout << setfill('-') << setw(29) << "\n";
    
}//end of shoppingCartDisplay function


//start of implementation of calculatingTotal function to add all items' prices together to get the total before tax
double calculatingTotal(double productPrices[], int size){
    double tempTotal = 0;
    int i = 0;
    //start of for loop to go through all prices and add to temp total
    for(i = 0; i < size; i++){
        tempTotal += productPrices[i];
        
    }//End of for loop
    
    
    
    return tempTotal;
}//End of calculatingTotal function


//Implementing the taxOfCart function to calculate the tax of the total variable
double taxOfCart(double total){
    double tempTax = total * 0.0825;
    
    return tempTax;
}//End of taxOfCart

//Implementing the finalDisplay function to output the total cost, tax, and total cost with tax in a neatly formatted way.
void finalDisplay( double total, double tax){
    cout << setfill('-') << setw(24) << " \n";
    cout << "|***Check Out Page***|\n";
    cout << setw(24) << " \n";
    cout << setw(46) << "\n";
    cout << "Total cost of cart before tax" << setfill(' ') << setw(10) << " $:" << fixed << setprecision(2)<< total << "|\n";
    cout << "Total tax of cart" << setw(23) << " $:" << fixed << setprecision(2) << tax << "|\n";
    cout << "Total of cart with tax" << setw(22)<< fixed << setprecision(2) << total + tax << "|\n";
    cout << setfill('-') << setw(46) << "\n";
    
    
}//end of finalDisplay function
