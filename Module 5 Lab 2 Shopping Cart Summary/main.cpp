//
//  main.cpp
//  M 5 Lab 2 Shopping Cart Summary
//
//  Created by Jacob Sones on 10/23/25.
//
//  --------------------------------------------------------------
//  FILE PURPOSE:
//  This is the main driver file for the Shopping Cart Summary Tool.
//  It initializes two parallel arrays: one for product names and
//  one for their prices. It then calls functions from Utilities.cpp
//  (declared in Utilities.hpp) to display a welcome message,
//  show the shopping cart items, calculate totals and tax,
//  and display the final checkout summary.
//
//  RELATIONSHIP TO OTHER FILES:
//  - Includes "Utilities.hpp" to access function declarations.
//  - Uses functions implemented in Utilities.cpp to handle all
//    calculations and formatted output tasks.
//
//  OVERALL FUNCTION:
//  The main function coordinates the flow of the program and
//  manages data passed to utility functions.
//  --------------------------------------------------------------

#include "Utilities.hpp"
#include <iostream>
#include <iomanip>
#include <string>
using namespace std;


int main() {
    
    //Creating parallel arrays for product names and their corresponding prices
    string productNames[5] = {"Pumpkins", "Candy", "Skull Glass", "Spiderweb", "Potion bottles"} ;
    double productPrices[5] = {3.90, 5.75, 6.99, 12.99, 15.60 };
    
    //using the welcomeMessage function to display a greeting to the user at the Graveyard goods shop
    welcomeMessage("Graveyard Goods Shopping Cart Summary Tool");
    cout << "\n\n\n";

    //Using the shoppingCartDisplay function to show what's in the user's shopping cart
    shoppingCartDisplay(productNames, productPrices);
    cout << "\n";
 
    double total = calculatingTotal(productPrices, 5);
   
    
    
    double tax = taxOfCart(total);
   
    
    
//Using finalDisplay function to show total of cart and tax and then total of cart with tax
    finalDisplay(total, tax);
    return 0;
}
