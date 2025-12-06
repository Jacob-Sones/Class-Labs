//
//  Podcast.cpp
//  Module 8 Podcast Lab
//
//  Created by Jacob Sones on 12/5/25.
//
//  Description:
//      This source file contains the full implementation of the Podcast class
//      declared in Podcast.hpp. The Podcast class serves as the core data model
//      for the Podcast Management Program and stores all information related to
//      a single podcast entry.
//
//      This file defines:
//          - The default constructor, which assigns placeholder values when
//            no specific podcast data is provided.
//          - The parameterized constructor used to initialize a Podcast object
//            with host name, title, genre, duration, and release year.
//          - Setter methods for modifying private attributes.
//          - Getter methods that return read-only access to podcast data.
//          - The displayPodcast() method, which outputs all podcast attributes
//            in a formatted and user-friendly layout.
//
//      These implementations support storing, displaying, sorting, and searching
//      podcast information throughout the program.
//


#include <iostream>
#include <iomanip>
#include "Podcast.hpp"
using namespace std;

//Implementing the default constructor to assign a default value to our private attributes if none are given
Podcast::Podcast(){
    
    hostName = "Unkown";
    title = "Unkown";
    genre = "Unkown";
    duration = 0;
    releaseYear = 0;
}//end of default constructor

//Implementing a parameterized constructor to assign the value given in the parameters of the constructor to the private attributes of the object being created
Podcast::Podcast(string pHostName, string pTitle, string pGenre, int pDuration, int pReleaseYear){
    
    hostName = pHostName;
    title = pTitle;
    genre = pGenre;
    duration = pDuration;
    releaseYear = pReleaseYear;
    
}//end of parameterized constructor


//Implementing setters
void Podcast::setReleaseYear(int pReleaseYear) {
    releaseYear = pReleaseYear;
}


void Podcast::setDuration(int pDuration) {
    duration = pDuration;
}


void Podcast::setGenre(string pGenre) {
    genre = pGenre;
}


void Podcast::setTitle(string pTitle) {
    title = pTitle;
}


void Podcast::setHostName(string pHostName) {
    hostName = pHostName;
}



//Implementing getters
int Podcast::getReleaseYear() const {
    return releaseYear;
    
}


int Podcast::getDuration() const {
    return duration;
}


string Podcast::getGenre() const {
    return genre;
}


string Podcast::getTitle() const {
    return title;
}


string Podcast::getHostName() const {
    return hostName;
}



//start of implementation of displayPodcast function/method
void Podcast::displayPodcast() const {
    cout << setfill('=') << setw(21) << "\n";
    cout << "|***Podcast Info***|\n";
    cout << setw(21) << "\n";
    cout << "Title:" << title << "\n";
    cout << "Host Name:" << hostName << "\n";
    cout << "Genre:" << genre << "\n";
    cout << "Duration:" << duration << " Minutes\n";
    cout << "Release Year:" << releaseYear << "\n";
    
}//end of displayPodcast method


