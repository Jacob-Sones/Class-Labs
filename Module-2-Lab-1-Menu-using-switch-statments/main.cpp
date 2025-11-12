//
//  main.cpp
//  lab 2 part 1
//
//  Created by Jacob Sones on 9/9/25.
/* main.cpp
Lab 2 - Part 1
Author: Jacob Sones
Date: 9/9/25

Description:
This program simulates a menu-based ordering system for a snack shop.
It displays a list of five snack items, each with a unique number and price.
The user is prompted to enter a number (1–5) to select an item. Using a
switch statement, the program then outputs the selected item’s name, its
formatted price (to two decimal places), and a thank-you message. If the
user enters an invalid option outside the range of 1–5, the program
displays an error message and prompts them to try again. The code also
uses iomanip features (setw, setfill, setprecision) to align and format
the output for better readability.
*/


//Adding the proper library for input output and formatting in code.
#include <iostream>
#include <iomanip>
using namespace std;

//Declaring variables
double centuryEgg= 260.34;
double tunaEyeball= 0.50;
double liveOctopus= 35.2;
double friedSpider = 8.40;
double aplePie = 10;
int choice;


int main (){
    //Display of a welcome message in the shop, along with snacks and their corresponding cost, and a selection of numbers.
    cout << setfill('*') << setw(42) << " \n";
    cout << "|*Welcome to the Wacky Snack Pack shop*|\n";
    cout << setw(42) << " \n";
    
    cout << left <<"Item" << setfill(' ') << setw(30)<< right << "Price\n";
    cout << setfill('-') << setw(39) << " \n";
    //output of prices and items
    cout << left << "1:Century egg" << setfill(' ') << setw(16) << fixed << setprecision(2) << right << "$:" << centuryEgg << " |\n";
    cout << left << "2:Tunna Eye Balls" << setw(12) << fixed << setprecision(2) << right << "$:" << tunaEyeball << "   |\n";
    cout << left << "3:Live Octoput" << setw(15) << fixed << setprecision(2) << right << "$:" << liveOctopus << "  |\n";
    cout << left << "4:Fried Spider" << setw(15) << fixed << setprecision(2) << right << "$:" << friedSpider << "   |\n";
    cout << left << "5:Aple Pie" << setw(19) << fixed << setprecision(2) << right << "$:" << aplePie << "  |\n";
    cout << setfill('-') << setw(40) << " \n\n";
    
    cout << "Please select an option between 1-5!: ";
    cin >> choice;
    cout << setw(41)<< " \n\n";
    
    
   
    
    
    // Start of switch statement to allow the program to branch off into different blocks
    switch (choice) {
        case 1:
            // Switch statement for option two
            cout << "You selected the option of :century Egg" <<  endl;
            cout << setw(41) << "\n\n";
            cout << setw(21) << " \n";
            cout << " Total is :$ " << centuryEgg  << endl;
            cout << setw(21) << "\n\n";
            cout << "Thanks for eating at the Wacky Snack Shop, hope you enjoy your Century Egg\n\n";
                break;
            
            
            //Switch statement for option two
        case 2:
            cout << "You selected the option of :Tuna Eye Balls" << endl;
            cout << setw(45) << " \n\n";
            cout << setw(18) << " \n";
            cout << "Total is :$ " << tunaEyeball << endl;
            cout << setw(19) << " \n\n";
            cout << "Thanks for eating at the Wacky Snack Shop, hope you enjoy your Tuna Eye Balls\n\n";
            break;
            
            
            //Switch statement for option three
        case 3:
            cout << "You selected the option of :Live Octopus" << endl;
            cout << setw(43) << " \n\n";
            cout << setw(18) << " \n";
            cout <<"Total is :$" << liveOctopus << endl;
            cout << setw(19) << " \n\n";
            cout << "Thanks for eating at the Wacky Snack Shop, hope you enjoy your Live Octopus\n\n";
            break;
            
            
            //Switch statement for option four
        case 4:
            cout << "You selected the option of :Fried Spider" << endl;
            cout << setw(43) << " \n\n";
            cout << setw(17) << " \n";
            cout << "Total is :$" << friedSpider << endl;
            cout << setw(18) << " \n\n";
            cout << "Thanks for eating at the Wacky Snack Shop, hope you enjoy your Fried Spider\n\n";
            break;
            
            
            //Switch statement for option five
        case 5:
            cout << "You selected the option of :Aple Pie" << endl;
            cout << setw(39) << " \n\n";
            cout << setw(18) << " \n";
            cout << "Total is :$" << aplePie << endl;
            cout << setw(19) << " \n\n";
            cout << "Thanks for eating at the Wacky Snack Shop, hope you enjoy your Apple pie\n\n";
            break;
       
        //if user inputs anything beside 1-5
        default:
            cout << "Sorry, that's not a valid option. Please select again\n\n";
           break;
    }
    
    
    
    
    return 0;
}

