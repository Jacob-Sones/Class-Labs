//
//  main.cpp
//  lab1_finished
//  Created by Jacob Sones on 9/5/25.
/*
* Academic Profile Program
* ------------------------
* This program collects personal information from the user
* (name, birthplace, major, GPA, and age) and generates a
* formatted academic profile. It demonstrates:
*   - Input handling with cin, getline(), cin.ignore(), and cin.get()
*   - Output formatting using setw(), setfill(), left, right, fixed, and setprecision()
*   - Simple text-based UI with banners and alignment
*
* The final result is a neatly formatted profile box printed
* to the console with the user’s information.
*/



#include <string>
#include <iostream>
#include <iomanip>

using namespace std;
//declare variables ie my strings GPA and Age
string birthPlace;
string degree;
string name;
double GPA;
int age;
int const INNER_LABEL = 40; // used for the bottom banner
int main() {
    cout << setw(51) << setfill('*') << " " << endl;
    cout <<"----Hey Welcome To the Acadmic Profile Program----\n";
    cout << setfill('*') << setw(51) << " " << endl;
    
    cout << "What is your full Name?:"; // gets the users full name
    getline(cin,name);
    cout << endl;
    cout << "to continue press enter";
    cin.ignore();
    
    
    cout << "\n whats your place of birth?:"; // asking the user where they where born
    getline(cin,birthPlace);
    //cout << "\n";
   // cout << "to continue press enter";
cin.ignore();
    
    cout << "\nwhats your Major:"; // asking what the user is studing
    getline(cin,degree);
    cout << "\n";
    
    cout << "whats your GPA:"; // asking the user what there current GPA
    cin >> GPA;
    cout << "\n";
    
    cout << "whats your Age:"; // asking the user what there full name is
    cin >> age;
    cout << endl << endl;
    
    cout << "thanks for using my program, Creating a profile, [Press Enter] to generate your academic profile :).\n\n" << " ";
    cin.ignore();
    cin.get();
// this is the start of the output
//this set the banner for the profile i used a const variable to set the legnth
    cout << "|" << setfill('-') << setw(INNER_LABEL) << "|\n";
    cout << "|---------------PROFILE----------------|" << endl;
    cout << "|" << setfill('-') << setw(INNER_LABEL) << "|\n";
    setfill('_');
    cout << setw(30) << left << "Name:" << name << endl;
    
    cout << setw(30) << left << "Born:" << birthPlace << endl;
    
    cout << setw(30) << left << "Major:" << degree << endl;
    //allows the decimal to go three space back
    cout << setw(30) << left << "GPA:" <<fixed << setprecision(3) << showpoint << GPA << endl;
    
    cout << setw(30) << left << "Age:" << age << endl;
    
    cout <<"All finished up, thanks again, hope you have a great day! :)\n ";

    
    return 0;
}
