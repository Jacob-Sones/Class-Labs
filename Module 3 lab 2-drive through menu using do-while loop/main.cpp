/*
 * File: main.cpp
 * Author: Jacob Sones
 * Date: 09/27/2025
 * Course: Module 3 — Assignment Lab 2
 * Title: Fast-Food Ordering System (Menu-Driven)
 *
 * Description:
 *   Console program that displays a Wacky Snack Pack menu and lets the user
 *   add items to an order until they choose to check out. The program keeps a
 *   running total (prices stored as doubles) and counts how many items were
 *   ordered. When the user selects Checkout, it prints:
 *    • total number of items ordered
 *    • total amount due formatted to two decimal places. */

#include <iostream>
#include <iomanip>
using namespace std;


int main () {
//Declaring variables
double centuryEgg= 260.34;
double tunaEyeball= 0.50;
double liveOctopus= 35.2;
double friedSpider = 8.40;
double applePie = 10;
int choice;
    double total = 0;
    int amountOfItems =0;
    
    const int COLLEMSIZE = 30;
    const int SMALLCOLLEM = 10;
    // start of do loop
    do{
        
        //Display of a welcome message in the shop, along with snacks and their corresponding cost, and a selection of numbers.
        cout << setfill('*') << setw(COLLEMSIZE + 12) << " \n";
        cout << "|*Welcome to the Wacky Snack Pack shop*|\n";
        cout << setw(42) << " \n";
        
        cout << left <<"Item" << setfill(' ') << setw(COLLEMSIZE)<< right << "Price\n";
        cout << setfill('-') << setw(COLLEMSIZE + 9) << " \n";
        //output of prices and items
        cout << left << "1:Century egg" << setfill(' ') << setw(SMALLCOLLEM + 6) << fixed << setprecision(2) << right << "$:" << centuryEgg << " |\n";
        cout << left << "2:Tunna Eye Balls" << setw(SMALLCOLLEM + 2) << fixed << setprecision(2) << right << "$:" << tunaEyeball << "   |\n";
        cout << left << "3:Live Octoput" << setw(SMALLCOLLEM + 5) << fixed << setprecision(2) << right << "$:" << liveOctopus << "  |\n";
        cout << left << "4:Fried Spider" << setw(SMALLCOLLEM + 5) << fixed << setprecision(2) << right << "$:" << friedSpider << "   |\n";
        cout << left << "5:Apple Pie" << setw(SMALLCOLLEM + 8) << fixed << setprecision(2) << right << "$:" << applePie << "  |\n";
        cout << left << "6:Check out" << setw(SMALLCOLLEM + 17) << right << "|\n";
        cout << setfill('-') << setw(COLLEMSIZE + 10) << " \n\n";
        
        //asking for option choice
        cout << "Please select an option between 1-5!:";
        cin >> choice;
        cout << setw(COLLEMSIZE + 12 )<< " \n\n";
        
        
        //Validating user input is in the proper range of options choice
        while( cin.fail() || choice < 1 || choice > 6 ){
            cin.clear();
            cin.ignore(1000,'\n');
            cout << "Sorry, you entered a number outside the valid range. Please enter only 1-6\n:";
            cin >>choice;}
        
        // Start of switch statement to allow the program to branch off into different blocks
        switch (choice) {
            case 1:
                // Switch statement for option two
                cout << "You selected the option of :century Egg" <<  endl;
                cout << setw(41) << "\n\n";
                cout << setw(21) << " \n";
                cout << " Total is :$ " << centuryEgg  << endl;
                cout << setw(21) << "\n\n";
                break;
                
                
                //Switch statement for option two
            case 2:
                cout << "You selected the option of :Tuna Eye Balls" << endl;
                cout << setw(45) << " \n\n";
                cout << setw(18) << " \n";
                cout << "Total is :$ " << tunaEyeball << endl;
                cout << setw(19) << " \n\n";
                break;
                
                
                //Switch statement for option three
            case 3:
                cout << "You selected the option of :Live Octopus" << endl;
                cout << setw(43) << " \n\n";
                cout << setw(18) << " \n";
                cout <<"Total is :$" << liveOctopus << endl;
                cout << setw(19) << " \n\n";
                break;
                
                
                //Switch statement for option four
            case 4:
                cout << "You selected the option of :Fried Spider" << endl;
                cout << setw(43) << " \n\n";
                cout << setw(17) << " \n";
                cout << "Total is :$" << friedSpider << endl;
                cout << setw(18) << " \n\n";
                break;
                
                
                //Switch statement for option five
            case 5:
                cout << "You selected the option of :Apple Pie" << endl;
                cout << setw(39) << " \n\n";
                cout << setw(18) << " \n";
                cout << "Total is :$" << applePie << endl;
                cout << setw(19) << " \n\n";
                break;
            
                // Display the final total when the user wants to check out
            case 6:
                cout << setfill('-') << setw(COLLEMSIZE) << "|\n";
                cout << "You got:" << amountOfItems << setfill(' ') << setw(SMALLCOLLEM + 11) << right << " items|\n";
                cout << "Total amount:" << fixed << setprecision(2) << setw(SMALLCOLLEM + 1) << "$" << total << "|\n";
                cout << setfill('-') << setw(COLLEMSIZE + 2) << "|\n\n\n";
               
                cout << setfill('=') << setw(COLLEMSIZE + 37) << "|\n";
                cout << "|*Thanks for eating at the Wacky Snack Shop, hope you enjoy your*|\n" << setw(COLLEMSIZE + 37) << "|\n";
                break;
        }// end of switch loop
        
        // start of adding totals together from user choice
        switch(choice){
            case 1:
                total = total + centuryEgg;
                amountOfItems++;
                break;
            case 2:
                total = total + tunaEyeball;
                amountOfItems++;
                break;
            case 3:
                total = total + liveOctopus;
                amountOfItems++;
                break;
            case 4:
                total = total + friedSpider;
                amountOfItems++;
                break;
            case 5:
                total = total + applePie;
                amountOfItems++;
                break;
        }
        
       
    }
        
        while(choice != 6 );
        
        
        
        
        return 0;
    }
