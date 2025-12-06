//
//  Podcast.hpp
//  Module 8 Podcast Lab
//
//  Created by Jacob Sones on 12/5/25.
//
//  Description:
//      This header file defines the Podcast class used in the Podcast
//      Management Program. The class represents a single podcast entry and
//      stores all related information such as host name, title, genre,
//      duration, and release year.
//
//      The Podcast class provides:
//          - A default constructor for creating an empty or placeholder podcast.
//          - A parameterized constructor for building a fully initialized
//            Podcast object with all required fields.
//          - Setter methods for modifying the podcast's attributes.
//          - Getter methods for retrieving stored information.
//          - A displayPodcast() method that outputs all podcast details in a
//            clean, formatted layout.
//
//      This class acts as the core data model for the program and is used in
//      vectors, searching, sorting, and user-driven podcast creation.
//

#pragma once

#include <stdio.h>
#include <iostream>
#include <iomanip>
using namespace std;

class Podcast{
private:
    string hostName;
    string title;
    string genre;
    int duration;
    int releaseYear;
    
public:
    
    //Prototype for the Default constructor to assign values to private attributes of the podcast class if none are provided
    Podcast();
    
    
    //Prototype for the perimiterized constructor to assign values to private attributes of the podcast class
    Podcast(string pHostName, string pTitle, string pGenre, int pDuration, int pReleaseYear);
    
    
    //setters
    void setHostName(string pHostName);
    
    void setTitle(string pTitle);
    
    void setGenre(string pGenre);
    
    void setDuration(int pDuration);
    
    void setReleaseYear(int pReleaseYear);
    
    
   //getters
    string getHostName() const;
    
    string getTitle() const;
    
    string getGenre() const;
    
    int getDuration() const;
    
    int getReleaseYear() const;
    
    
    //Display function to show all info in the private attribute fields of the object made from the class
    void displayPodcast() const;
    
    
    
    
};
