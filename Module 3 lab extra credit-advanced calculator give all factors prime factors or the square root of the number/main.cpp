/*
 * File: main.cpp
 * Author: Jacob Sones
 * Date: 10/03/2025
 * Course: Intro to Programming
 * Lab: Extra Credit
 * Title: Number Simple Analyzer (Menu-Driven)
 *
 * Description:
 *   Console program that analyzes an integer in the range 1–10,000. The user
 *   selects one of three options and can repeat until they choose to exit.
 *   Menu options:
 *     • List all factors of the number
 *     • List all prime factors (trial division)
 *     • Show the number squared and its square root (2 decimal places)
 *
 * Notes:
 *   • Validates number input (1–10,000) and menu choice (1–3).
 *   • Prime factorization modifies the working copy of the number.
 */

#include <iostream>
#include <iomanip>
#include <cmath>
using namespace std;
char continueOrExit;
int analyzeNumber;
int choice;
const int LARGECOLUMN = 30;
const int SMALLCOLUMN = 10;
int i = 1;
int j = 1;
int main() {
    do{
        
        //display for user welcome message
        cout << setfill('=') << setw(LARGECOLUMN + 13) << " \n";
        cout << "|*Welcome to the number simple analyzer*|\n";
        cout << setfill('=') << setw(LARGECOLUMN + 14) << " \n\n";
        
        //getting the number the user would like to analyze
        cout << "What number would you like to analyze today? Please keep within valid ranges,being 1-10,000 only whole numbers \nNumber:";
        cin >> analyzeNumber;
        
        // Checking if the user input is in a valid range or if it's an integer data type with a do-while loop and if statements
        do{
            if(analyzeNumber >= 1 && analyzeNumber <= 10000 ){
                cout << "Thanks for your valid input and following directions :)\n";
                break;
            }else if(cin.fail() || analyzeNumber < 1 || analyzeNumber > 10000)
                cin.clear();
            cin.ignore(1000,'\n');
            cout << "Seems you were not paying attention to the direction. You entered an invalid input or range of input. Please try again. What number would you like analyzed\n:";
            cin >> analyzeNumber;
        }while(analyzeNumber < 1 || analyzeNumber > 10000);
        
        cout << endl << endl;
        
        //Start of menu for analyzing numbers with either 1. factors of all numbers, 2. all prime factors of the number, as well as 3. numbers squared and their square root.
        cout << setw(LARGECOLUMN + 30) << " \n";
        cout << "|*What type of analysis do you want to do on your number*|\n";
        cout << setw(LARGECOLUMN + 30) << " \n";
        
        cout << setfill('-') << setw(LARGECOLUMN + 11) << "|\n";
        cout << left << "1:All Factors of number" << setfill(' ') << setw(SMALLCOLUMN + 8) << right << "|\n";
        cout << left << "2:All Prim Factors of number" << setw(SMALLCOLUMN + 3) << right << "|\n";
        cout << left << "3:Numbered squared and its square root" << setw(SMALLCOLUMN -7) << right << "|\n";
        cout << setfill('-') << setw(LARGECOLUMN + 13) << "|\n\n\n";
        
        //Getting user input for what option they want to pick
        cout << "Which option would you like to pick to perform on\n:";
        cin >> choice;
        
        //Checking if the user input is in a valid range and data type with a while loop
        while(cin.fail() || choice < 1 || choice > 3) {
            cin.clear(); cin.ignore(1000, '\n');
            cout << "Sorry, it seems like you have entered an invalid option. Please pick between 1-3\n:";
            cin >> choice;
        }
        
        //Start of switch statement to go into three options: all factors of the number, all prime factors of the number, and the square and the square root of the number
        switch(choice){
                
                // all factors of the number
            case 1:
                
                //amount of collumns(rows) for(outer loop) will print of factors number
            //   for( i = 1; i <= analyzeNumber; i++){
                    //for each iteration of our number factored in each column
                    for( j = 1; j <= analyzeNumber; j++) {
                        
                        if( analyzeNumber % j != 0){
                            continue;
                    
                            
                        }
                        cout << j << " \t";
                        
                    }// end of i for loop
                    cout << endl << endl;
                  
                  //  break;
                   
                //}
                break;
                    // all prime factors of the number
                case 2:
                    //Start of all prime factors,
                    while(analyzeNumber != 1){
                        for(i = 2 ;i <= analyzeNumber; i++){
                            if(analyzeNumber % i == 0){
                                cout << i << " \t";
                                analyzeNumber = analyzeNumber / i;
                                break;}
                        }
                        
                    }// end of case 2
                    break;
                    
                    // squared and square root of a number
                case 3:
                    cout << endl;
                    //changing Number to double so it will show to two decimal places
                    static_cast<double>(analyzeNumber);
                    double numberSquared = analyzeNumber * analyzeNumber;
                    
                    cout << analyzeNumber << " squared is :" << analyzeNumber << " * " << analyzeNumber << " = " << fixed << setprecision(2) << numberSquared << endl;
                    
                    cout <<"square root of " << analyzeNumber << " is :" << fixed << setprecision(2) << sqrt(analyzeNumber) << endl << endl;
                    
                    // add in notes that forgetting the break statement for the  switch
                    
                    
                //end of case 3
                break;
        }
        //ask for user to enter if they want to repeat program and enter new number, meaning y for yes and then n for no
        cout << "\nDo you want to continue with more numbers? (y/n)\n:";
        cin >>continueOrExit;
        
        
        //  While loop to check if user input is either y-Y or n-N or in a bad input or really anything that is not those, so if user input is w, r, j, etc, it will catch bad input and re-prompt
                while (cin.fail() || (continueOrExit != 'y' && continueOrExit != 'Y' && continueOrExit != 'n' && continueOrExit != 'N')){
                    cin.clear();
                    cin.ignore(1000,'\n');
                    cout << "Sorry, it appears you entered invalid input. Please only enter (y/Y) to continue the calculator, or  (n/N) to exit the calculator, try again.\n:";
                    cin >> continueOrExit;
                }
        } while(continueOrExit == 'y' || continueOrExit == 'Y');// end of while loop
    
    
    
//start of switch statement for option 1-,3 doing all factors, or prime factors, or number squared and its square root
    return 0;
}
