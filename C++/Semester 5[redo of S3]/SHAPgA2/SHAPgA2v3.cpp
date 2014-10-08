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
	int pCan[1000] = { 0 }; // The array to use for storing the C values 
	int testCounter = 0; // The counter I use to know how to fill the pcan array

	cout << "This program generates Pythagorean candidate numbers in a table.\n";

	cout << "Type the higher bound limit\n";
	cin >> high;
	cout << "Type the lower bound limit\n";
	cin >> low;
	cout << endl;


	xm = high + 1;				            //find corresponding table-size mm for this limit
	mm = sqrt(high + 1);

	for (i = 1; i < high; i++)         // begin row loop; note row mm [i.e. last] is empty
	{                                    // handle columns

		for (j = i + 1; j < mm; j++)      // show p-candidates on rest of row
		{
			c = i*i + j*j;
			if (c >= low && c <= high) // Only putting the the numbers within the limits in the array.
			{
				r = c;
				MakeList(tail, r, pCan);
				testCounter++;

			}
		}

	}

	system("pause");
	return 0;
}  //end main

void MakeList(int &t, int r, int p[])    // I hope you can sense the frustration is this code. 
{
	int q = -1; // Initial value of Q needs to be -1 so we can make sure T is bigger
	bool f = false; // This is the value we change when we found the correct place for the value r
	int x;


	if (t == -1)
	{
		p[0] = r; // Putting the the R value into the first section of my array
		t = t + 1;
		f = true;
	}
	while (q < t && !f)
	{
		q = q + 1;

		if (r <= p[q])
		{
			f = true;
			if (r != p[q]) // Making sure the value we want to put into the array isn't already in the current place
			{

				x = t;
				while (x >= q) // This is the loop which "moves" and checkes numbers in the array to find the correct place
				{

					p[x + 1] = p[x]; // The move
					x = x - 1;			// Making X one less so it can keep on moving the value if need be			
				}
				t = t + 1; // Getting ready for the next number by making tail jump to the closest empty part
				p[q] = r;   // We finally put the new value into pCan
			}


		}

	}


	if (f == false)
	{
		t = t + 1;
		p[t] = r;

	}
	for (int count = 0; count < t; count++)
	{
		cout << p[count] << endl; // We use this to output the numbers from the list we just made

	}
	system("pause");

}