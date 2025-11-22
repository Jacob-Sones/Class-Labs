/*
 * main.cpp
 * Module 7 – Favorite Book Tracker
 *
 * Author: Jacob Sones
 * Date: 11/20/2025
 *
 * Description:
 * --------------------
 * This file contains the main driver for the Favorite Book
 * Tracker program. It presents a menu-driven user interface
 * that allows the user to add, modify, and display information
 * about their favorite book using a Book object.
 *
 * The program loops continuously until the user selects the
 * exit option. All numeric input is validated using the
 * validateInt() helper function, while the Book class
 * manages storage and display of book-related data.
 *
 * Major Features:
 *  1. Add Favorite Book – collects title, author, and page
 *     count from the user and stores the values in a Book object.
 *
 *  2. Change Favorite Book – allows updating the existing
 *     Book object's fields with new user-provided values.
 *
 *  3. Display Favorite Book – shows all stored information in
 *     a formatted output.
 *
 *  4. Controlled Input Handling – combines getline() and
 *     validated numeric input with cin.ignore() to handle
 *     mixed-type input safely.
 *
 * Program Flow:
 *  - A do–while loop displays the menu and processes user choices.
 *  - A switch statement handles each menu action.
 *  - A single Book object (favoriteBook) persists across
 *    iterations so user changes are retained.
 */

#include <iostream>
#include <iomanip>
#include "book.hpp"
#include "validationFunctions.hpp"
using namespace std;


int main(){
    
    //Creating a userChoice variable to gather the option the user wants to pick, and another variable that will be used to temporarily store data for objects created from the book class
    int userChoice;
    string tempTitle;
    string tempAuthor;
    int tempPageCount;
    //Creating favoriteBook object so it can be used inside switch statements even if it hasn't been populated with user data from case 1
    book favoriteBook;
    
    //Start of do-while loop to keep prompting the user with a menu to choose from options
    do{
        //using the welcomeMessage function to display the prompt given in the perimeter feild
        welcomeMessage("Welcome To The Favorite Book Tracker");
        
        
        //Creating a menu to display all the options of the program and then prompting the user to enter their choice
        cout << "\nFavorite Book Tracker Menu\n";
        cout << setfill('-') << setw(40) << "\n";
        
        cout << "1:" << setfill(' ') << setw(38) << "Add Favorite Book|\n";
        cout << "2:" << setw(38) << "Change Favorite Book|\n";
        cout << "3:" << setw(38) << "Display Favorite Book Info|\n";
        cout << "4:" << setw(38) << "Exit Favorite Book Menu|\n";
        cout << setfill('-') << setw(40) << "\n";
        
        userChoice = validateInt("Enter Option", 1, 4);
        
        cout << "\n\n";
        
        
        //Start of switch statement to go into a case statement for each option displayed on the menu
        switch(userChoice){
                
                
                //Creating case 1 for adding a favorite book to the object created
            case 1:{
                //asking and gathering user input for the title of the book using getline to get full user input
                cout << setfill('=') << setw(47) << "\n";
                cout << "|***Please enter your favorite books title***|\n";
                cout << setw(53) << "\nTitle:";
                cin.ignore(1000,'\n');
                getline(cin,tempTitle);
                
                //cin.ignore(1000,'\n');
                
                cout << "\n\n";
                
                //Asking the user for the number of pages in the book using the validateInt function to make sure the page count is in a positive range and is not too big
                cout << setfill('=') << setw(58) << "\n";
                cout << "|***Please enter the page count of your favorite book***|\n";
                cout << setw(58) << "\n";
                tempPageCount = validateInt("Page count", 1, 500);
                cin.ignore(1000,'\n');
                cout << "\n\n";
                
                //asking and gathering user input for the author of the book, using getline to fill the input
                cout << setfill('=') << setw(54) << "\n";
                cout << "|***Please enter the author of your favorite book***|\n";
                cout << setw(67) << "\nAuthors Name:";
                getline(cin,tempAuthor);
                cin.ignore(1000,'\n');
                
                //using setters to add user input to the object's private member variables
                favoriteBook.setTitle(tempTitle);
                
                favoriteBook.setAuthor(tempAuthor);
                
                favoriteBook.setPageCount(tempPageCount);
                
                
                
                //Adding a pause in the program to make it feel more user-friendly
                cout << "\n\nPlease hit [ENTER] to continue with the program\n";
                cin.get();
                
                break;
            }//end of case statement 1
                
                
                //Created case 2 to change the user's favorite book from the one they added
            case 2:{
                //displaying the menu for changing users favorite book
                cout << setfill('=') << setw(29) << "\n";
                cout << "|***Change Favorite Book***|\n";
                cout << setw(29) << "\n";
                cin.ignore(1000,'\n');
                //asking the user for the new title of their favorite book
                cout << "\n";
                cout << setfill('=') << setw(20) << "\n";
                cout << "|New title of book|\n";
                cout << setw(26) << "\nTitle:";
                getline(cin,tempTitle);
                cout << "\n\n";
         
                
                //asking the user for the new page count for the new book
                cout << "New page count\n";
                tempPageCount = validateInt("Page Count", 1, 500);
                cout << "\n\n";
                cin.ignore(1000,'\n');
                
                
                // Asking the user for a new author's name
                cout << setw(19) << "\n";
                cout << "|New authors name|\n";
                cout << setw(27) << "\nAuthor:";
               // cin.ignore(1000,'\n');
                getline(cin,tempAuthor);
                cout << "\n\n";
               
                
                //Adding new variables to the favoriteBook object's private member variables
                favoriteBook.setTitle(tempTitle);
                
                favoriteBook.setAuthor(tempAuthor);
                
                favoriteBook.setPageCount(tempPageCount);
                
                
                //Adding a pause in the program to make it feel more user-friendly
                cout << "Please hit [ENTER] to continue with the program\n";
                cin.get();
              
                
                break;
            }//end of case statement 2
                
                
                //Creating case 3 to display all the information about the user's favorite book
            case 3:{
                favoriteBook.displayBook();
                
                
                
                //Adding a pause in the program to make it feel more user-friendly
                cout << "\n\nPlease hit [ENTER] to continue with the program\n";
                cin.get();
                cin.ignore(1000,'\n');
                break;
            }//end of case statement 3
                
                
                //case 4 to exit the program's favorite book menu
            case 4:{
                cout << "Thank you for using the favorite book tracker. Hope you have a great day :)\n";
                break;
                
                
                
            }//end of case statement 4
        }//end of switch statement
        
        
        
        
        //end of do-while loop if userChoice is == to 4
    }while(userChoice != 4);
    
    
    return 0;
}


