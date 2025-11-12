//
//  Utilities.hpp
//  M 5 Lab 2 Shopping Cart Summary
//
//  Created by Jacob Sones on 10/23/25.
//
//  --------------------------------------------------------------
//  FILE PURPOSE:
//  This header file contains all the function declarations used by
//  the Shopping Cart Summary Tool. It defines the interface between
//  the main program (main.cpp) and the function implementations
//  located in Utilities.cpp.
//
//  RELATIONSHIP TO OTHER FILES:
//  - Included by main.cpp to access reusable functions.
//  - Implemented by Utilities.cpp which provides the actual logic
//    for displaying messages, showing products, and calculating totals.
//
//  OVERALL FUNCTION:
//  Acts as a blueprint for the utility functions that perform
//  program operations such as displaying output and computing values.
//  --------------------------------------------------------------


#ifndef Utilities_hpp
#define Utilities_hpp

//Adding needed libraries and files like iostream for output and input, iomanip for display manipulation.
#include <stdio.h>
#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

//Declaring function for welcome Message for the intro to program display
void welcomeMessage(string message);


//Declaring a function to show shopping cart items in a formatted output with the price of each item aligned to the right of the item
void shoppingCartDisplay(string productNames[], double productPrices[]);

//Declaring a function to calculate the total of all items in the shopping car```
double calculatingTotal(double productPrices[], int size);

//Declaring a function to calculate the total sales tax of the shopping cart
double taxOfCart(double total);

//Declaring a function to display the final results of the program, including the total cost of the cart, tax, and the total cost with tax of the cart.
void finalDisplay( double total, double tax);
#endif /* Utilities_hpp */
