/*
 * book.hpp 
 * Module 7 – Favorite Book Tracker
 *
 * Author: Jacob Sones
 * Date: 11/20/2025
 *
 * Description:
 * --------------------
 * This header file defines the Book class used by the
 * Favorite Book Tracker program. The class provides a
 * structured way to store and manage information about a
 * user's favorite book, including the title, author name,
 * and total page count.
 *
 * The class encapsulates all book-related data through
 * private member variables and exposes constructors along
 * with setter and display functions that allow the program
 * to safely modify and output book information.
 *
 * Provided Class Members:
 *  - Default constructor
 *  - Parameterized constructor (title, author, page count)
 *  - displayBook() – outputs stored book information
 *  - setTitle(), setAuthor(), setPageCount()
 *      Setter functions used to update individual fiel
*/
#ifndef book_hpp
#define book_hpp

#include <stdio.h>
#include<string>
#include <iostream>
using namespace std;

//Creating a book class to create a blueprint for making objects resembling attributes of real-life books
class book{
//creating private member variables to store data like book title, authors' names, and page count in a safe, secure way so I can only be accessed by public member functions
private:
    string title;
    string author;
    int amountOfPages;
    
    
    
public:
    //Creating the prototype for public overloaded constructors to handle multiple types of input when creating objects from the book class
    //prototype for default constructor if an object is passed, known parameters to fill the attributes of the class
    book();
    
    
    //Start of prototype of peramiterized constuctor to initialize/pass the parameters of the title, author, and page count to the object when it's being made
    book(string bookTitle, string bookAuthor, int pageCount);
    
    
    
    //start of member function or methods to prototype displayBook function
    void displayBook();
    
    
    //Creating setters to allow the user to change their favorite book, ie, title, author, and page count.
    void setTitle(string pTitle);
    
    void setAuthor(string pAuthor);
    
    void setPageCount(int pPageCount);
    
};





#endif /* book_hpp */
