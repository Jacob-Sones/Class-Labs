/*
 * book.cpp
 * Module 7 – Favorite Book Tracker
 *
 * Author: Jacob Sones
 * Date: 11/20/2025
 *
 * Description:
 * --------------------
 * This file contains the full implementation of the Book class
 * declared in book.hpp. The class provides a structured way to
 * represent and manage information for a user's favorite book,
 * including its title, author, and page count.
 *
 * Implemented Features:
 *  - Default Constructor:
 *        Initializes book attributes with placeholder values
 *        ("Unknown", "Unknown", and 0 pages).
 *
 *  - Parameterized Constructor:
 *        Initializes a Book object using user-supplied data for
 *        title, author, and page count.
 *
 *  - displayBook():
 *        Outputs formatted book information to the console using
 *        stylized separators and layout.
 *
 *  - Setter Functions:
 *        setTitle(), setAuthor(), setPageCount() allow controlled
 *        modification of individual book fields while maintaining
 *        data encapsulation.
 */

#include "book.hpp"
#include <iostream>
#include <iomanip>
using namespace std;

//Implementing a default constructor to fill the member variables of the object if they are known.
book::book(){
    title = "Unknown";
    author = "Unknown";
    amountOfPages = 0;
    
}//end of defualt constructor


//Implementing a permertized constructor to set the values of the member variables to what is passed into the parameters of the object at initialization.
book::book(string bookTitle, string bookAuthor, int pageCount){
    title = bookTitle;
    author = bookAuthor;
    amountOfPages = pageCount;
    
}//end of permertized constructor

//implementing the displayBooks member function for the book class to show users' favorite books, title, author, and page count,
void book:: displayBook(){
    cout << setfill('=') << setw(35) << "\n";
    cout << "|***Users Favorite Book Info***|\n";
    cout << setw(35) << "\n";
   
    cout << "Title Of Book:" << title << "\n";
    cout << "Authors Name:" << author << "\n";
    cout << "Page count of " << title << ":" << amountOfPages << "\n";
}


//start of implementation of the setter member function to change private member variables
void book::setTitle(string pTitle) {
    title = pTitle;
}//end of setTitle


void book::setPageCount(int pPageCount) { 
    amountOfPages = pPageCount;
}//end of setPageCount


void book::setAuthor(string pAuthor) { 
    author = pAuthor;
}//end of setAuthor

