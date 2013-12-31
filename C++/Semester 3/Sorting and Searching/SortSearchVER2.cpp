/*********************************** ID BLOCK **************************************


Due Date: October, 19th 2013
Software Designer: Geoffrey Shapiro
Course: 420-306 Fall 2013
Deliverable: Assignment #3--- Sorting and Searching
Description: 


***********************************************************************************/
#include <iostream>
#include <iomanip>             //for setw function to format output
#include <string>
#include <cstring>
using namespace std;

const int LMAX = 100;       //maximum number of name strings in array
const int NMAX = 10;        //maximum size of each name string
int LSIZE = 20;		       //number of actual name strings in array

/************************* Prototypes*********************************/
void OutList (int, char[][NMAX], int[]);
/*********************************************************************/


int main()
  {					    //array of name strings
   char nam[LMAX][NMAX] = { "wendy", "ellen", "freddy", "tom", "susan", 
	                         "dick", "harry", "aloysius", "zelda", "sammy",
							 "mary", "hortense", "georgie", "ada", "daisy", 
					    	 "paula", "alexander", "louis", "fiona", "bessie"  };			

						//array of weights corresponding to these names
   int wght[LMAX] = { 120, 115, 195, 235, 138, 177, 163, 150, 128, 142,
                       118, 134, 255, 140, 121, 108, 170, 225, 132, 148 };
   
/****************************************************************************
                      PRINT OUT THE UNSORTED ARRAY DATA            
****************************************************************************/
   //cout << "UNSORTED ARRAY DATA:" << endl << endl;
   //cout << setw(12) << "NAMES" << setw(12) << "WEIGHTS" << endl << endl;

   //for(int j=0; j<LSIZE; j++)  //display name strings & corresponding weights
   //   cout << setw(12) << nam[j] << setw(12) << wght[j]  << endl;

   // cout << endl << endl;
    OutList(LSIZE, nam, wght);
	system ( "pause" );
 
   return 0;
}

void OutList(int nn, char nm[][NMAX], int wt[])
{
   cout << "UNSORTED ARRAY DATA:" << endl << endl;
   cout << setw(12) << "NAMES" << setw(12) << "WEIGHTS" << endl << endl;

   for(int j=0; j< nn; j++)  //display name strings & corresponding weights
      cout << setw(12) << nm[j] << setw(12) << wt[j]  << endl;

    cout << endl << endl;

}