//
//  main.cpp
//  Module 3 lab 1
//
//  Created by Jacob Sones on 9/23/25.
//
// Description:
//   Console calculator that displays a menu, reads a user choice (1–5),
//   then asks for two numbers and performs Add / Subtract / Divide / Multiply
//  using a switch statement. Input for the menu is validated and the program
//   repeats in a do–while loop until the user selects 5 (Exit).
//Notes:
//  - Uses do–while so the menu shows at least once.
//  - Keep the switch inside the do { … } block; the while(...) follows the closing brace.
//  - When re-prompting after bad input, clear fail state and ignore the rest of the line.



// Adding necessary libraries for input, output, and formatting
#include <iostream>
#include <iomanip>
// grouping the standard code from libraries to avoid naming conflicts
using namespace std;

int main() {
    
    //declaring variables for user input, like option chosen, number1, number2, and final results
    
    int userChoice;
    double number1;
    double number2;
    double finalResult;
    
    // Start of calculator to prompt the user with menu for their options: adding, subtracting, dividing, multiplying, or exiting the calculator
    
    do {
        cout << setfill('=') << setw(51) << " \n";
        cout << "|Welcome to the simple but smart math calculator|\n";
        cout << setw(51) << " \n";
        
        cout << setfill('-') << setw(23) << " \n";
        cout << "Options" << right << setfill(' ') << setw(15) << "|\n";
        cout << "1:Add" << right << setw(17) << "|\n";
        cout << "2:Subtract" << right << setw(12) << "|\n";
        cout << "3:Divide" << right << setw(14) << "|\n";
        cout << "4:Mutiply" << right << setw(13) << "|\n";
        cout<< "5:Exit Calculator" << right << setw(5) << "|\n";
        cout << setfill('-') << setw(24) << " \n\n";
        
        //Asking the user which option they want to select after giving them all possible options through he menu.
        cout << "Please choose an option from the list :)\n:";
        cin >> userChoice;
        cout << endl;
        
        
        //Checking if it's a valid input with cin.fail, then using cin.Clear and cin. Ignore to clear and prompt the user for the correct range of options to choose from
        while( cin.fail() || userChoice < 1 || userChoice > 5){
            cin.clear();
            cin.ignore(1000, '\n');
            cout << "Sorry, it seems you entered an invalid option. Please try again only options between 1-5 are valid\n:";
            cin >> userChoice;
        }
        
        
        
        //Asking the user what two numbers they want to add, subtract, divide, or multiply, using an if statement to make the code feel more dynamic, depending on the options chosen
        if ( userChoice == 1){
            cout << "What is the first number?\n:";
            cin >> number1;
            cout << "\nWhat is the second number youd like to Add to " << number1 << "\n:";
            cin >> number2;
        }else if (userChoice == 2) {
            cout << "What is the first number?\n:";
            cin >> number1;
            cout << "\nWhat is the second number youd like to Subtract from " << number1 << "\n:";
            cin >> number2;
        }else if( userChoice == 3){
            cout << "What is the first number?\n:";
            cin >> number1;
            cout << "\nWhat is the second number youd like to Divide into " << number1 << "\n:";
            cin >> number2;
        }else if( userChoice == 4){
            cout << "What is the first number?\n:";
            cin >> number1;
            cout << "\nWhat is the second number youd like to Mutiply by " << number1 << "\n:";
            cin >> number2;
        }else
            cout << "Glad you stopped by to use my simple but smart calculator. Hope you have a great day :)\n";
    
    
    //Start of switch loop for the actual process of doing our math on the variables and the choice picked
    switch (userChoice) {
        case 1://Add
            finalResult = number1 + number2;
            cout << "You wanted to Add " << number1 << " to " << number2 << endl;
            cout << "Your final result for adding these two numbers is :" << finalResult << endl << endl;
            break;
            
        case 2://Subtract
            finalResult = number1 - number1;
            cout << "You wanted to Subtract " << number2 << " from " << number1 << endl;
            cout << "Your final result for Subtracting these two numbers is :" << finalResult << endl << endl;
            break;
            
        case 3://Divide
            if (number1 != 0 || number2 !=0 ) {
                finalResult = number1 / number2;
                cout << "You wanted to Divide "<< number2 << " from " << number1 << endl;
                cout << "Your final result for Dividing these two numbers is :" << fixed << setprecision(2) << finalResult << endl << endl;
                break;
            }else {
                cout << "ERROR canot divide by zero plz try again and dont enter '0'\n";
                break;
            }
        case 4://Mutiply
            finalResult = number1 * number2;
            cout << "You wanted to Mutiply " << number1 << " by " << number2 << endl;
            cout << "Your final result for Mutiply these two numbers is :" << fixed << setprecision(2)<< finalResult << endl << endl;
            break;
    }
    //end of loop
} while (userChoice != 5);
    
    
    
    
return 0;
    
}

