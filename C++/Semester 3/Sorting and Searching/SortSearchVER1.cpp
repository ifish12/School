// asst3v1.cpp    ALGORITHM DESIGN   
// array of strings
#include <iostream>
#include <iomanip>             //for setw function to format output
using namespace std;
const int LMAX = 100;       //maximum number of name strings in array
const int NMAX = 10;        //maximum size of each name string
int LSIZE = 20;		       //number of actual name strings in array

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
   cout << "UNSORTED ARRAY DATA:" << endl << endl;
   cout << setw(12) << "NAMES" << setw(12) << "WEIGHTS" << endl << endl;

   for(int j=0; j<LSIZE; j++)  //display name strings & corresponding weights
      cout << setw(12) << nam[j] << setw(12) << wght[j]  << endl;

    cout << endl << endl;
	system ( "pause" );

/****************************************************************************
          1 - PUT UP MENU .... LET THE USER CHOOSE A SORT ALGORITHM            
****************************************************************************/
	
/****************************************************************************
          2 - COPY THE ARRAYS INTO WORK ARRAY i.e. don't clobber originals
****************************************************************************/

/****************************************************************************
                    3 - SORT THE ARRAYS WITH RESPECT TO NAME            
****************************************************************************/


/****************************************************************************
                        4 - PRINT THE SORTED ARRAYS            
****************************************************************************/

/****************************************************************************
                    5 - REPEAT STEPS 1-4 AS DESIRED
*****************************************************************************/

/****************************************************************************
                      6 - PROCESS THE INPUT SEARCH TRANSACTIONS            
****************************************************************************/
 
   return 0;
}