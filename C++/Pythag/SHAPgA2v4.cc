/*********************************** ID BLOCK **************************************


Due Date: September 27th, 2013
Software Designer: Geoffrey Shapiro
Course: 420-306 Fall 2013
Deliverable: Assignment #2--- Pythagorean perfect squares 
Description: This program generates a pythaagorean list of numbers, orders them, removes duplicates 
and then checks which numbers are pythagorean squares 


***********************************************************************************/
/************************* PRELIMINARIES **************************/
#include <iostream>
#include <conio.h>  
#include <math.h>
#include <iomanip> 
using namespace std;
/************************* Prototypes*********************************/
void MakeList(int&, int, int[]);
/*********************************************************************/

/************************* MAIN BLOCK BEGINS *************************/


int main()
   {
   int i, j, c;
   int r; // The number we want to insert into the array
   int tail = -1; // How many variables are in the set of numbers
   int high;
   int low;
   int mm; 
   double xm;
   int pCan[1000] = {0}; // The array to use for storing the C values 
   int testCounter = 0; // Subscript for pCan[]
   
   cout << "This program generates Pythagorean candidate numbers in a table.\n";

   cout << "Type the higher bound limit\n";
   cin >> high;
   cout << "Type the lower bound limit\n";
   cin >> low;
   cout << endl;

   
   xm = high + 1;				            //find corresponding table-size mm for this limit
   mm = sqrt(high +1);
   
   for ( i=1; i < high; i++ )         // begin row loop; note row mm [i.e. last] is empty
   {   for ( j= i + 1; j < mm; j++)      // show p-candidates on rest of row
	  {   c = i*i + j*j;
		  if(c >= low && c <= high) // Only putting the the numbers within the limits in the array.
			{   r = c; 
				MakeList(tail, r, pCan);
				testCounter++;     // Incrementing of subscript
		    }
      }  

   }


   // Variables I'm going to use just for the perfect square stuff
   double sq;
   int perfectSQ;
   int pythC = 0;
   int pyth[1000] = {0}; // The array we're going to use to store the pythagorean squares

   // End of vatiables I'm going to be using for the perfect squares
   cout << "q" << "     " << "p[q]\n \n";
   for (int count = 0; count < testCounter; count++)
   {  
	   sq = sqrt((double)pCan[count]); // Getting the square root of the pCan value
	   perfectSQ = (int)sq;
	   if (sq == perfectSQ)
	   {  
		   //cout << pCan[count] << " Is a perfect square! \n\n";
		   pyth[pythC] = pCan[count];
		   pythC++;
	   }
   }

  for (int i = 0; i < testCounter; i++)
   {   if (pyth[i] != 0)
          cout << i << setw(7) << pyth[i] << " Is a perfect square\n";
   }
   
  
   system( "pause");
   return 0;
   }  //end main

void MakeList(int &t, int r, int p[])    // I hope you can sense the frustration is this code. 
{
	int q = -1; // Initial value of Q needs to be -1 so we can make sure T is bigger
	bool f = false; // This is the value we change when we found the correct place for the value r
	int x;
   

		if (t == -1)
		{   p[0] = r; // Putting the the R value into the first section of my array
			t = t + 1;
			f = true;
		}
		while (q < t && !f)
		{   q = q + 1;
			if (r <= p[q])
			{	f = true;
				if (r != p[q]) // Making sure the value we want to put into the array is unique
				{   x = t;
					while (x >= q) // Moves and checkes numbers in the array to find the correct place
					{   p[x+1] = p[x]; // The move
						x = x - 1;	// Making X one less so it can keep on moving the value if need be
					}
                        t = t + 1; // Getting ready for the next number by making tail incriment
						p[q] = r;   // We finally put the new value into pCan
				}

			}
						
		}
	
	
	if (f == false) // R is the biggest number we want to insert
		{   t = t + 1;
			p[t] = r;
		}
	
}