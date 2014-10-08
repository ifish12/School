/*********************************** ID BLOCK **************************************


Due Date: September 30th, 2013
Software Designer: Geoffrey Shapiro
Course: 420-306 Fall 2014
Deliverable: Assignment #2--- Pythagorean perfect squares
Description: This program generates pythagorean candidates and checks them against out upper and lower limit
			 and then makes an ordered list with all of the unique pythagorean candidates.
			 After that, we look through our list pCand and extract the pythagorean numbers.

			 A pythagorean number is a number that is the sum of the square of two whole numbers and that is a perfect square.

***********************************************************************************/
/************************* PRELIMINARIES *****************************/
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
{	int i, j, c;
	int r; // The number we want to insert into the array
	int tail = -1; // How many variables are in the set of numbers
	int high; // Highest number
	int low; // Lowest Number
	int mm;
	double xm;
	int pCan[100000] = {0}; // The array to use for storing the C values 
	int sP = 0; // Subscript for pCan[]

	cout << "This program generates Pythagorean candidate numbers in a table.\n";
	cout << "Type the higher bound limit\n";
	cin >> high;
	cout << "Type the lower bound limit\n";
	cin >> low;
	cout << endl;

	xm = high + 1;	//find corresponding table-size mm for this limit
	mm = sqrt(xm / 2.) + 2;

	for (i = 1; i < high; i++)// begin row loop; note row mm [i.e. last] is empty
	{	for (j = i + 1; j < mm; j++)// show p-candidates on rest of row
		{	c = i*i + j*j; // calculate pythagorean candidate
			if (c >= low && c <= high) // Only putting the the numbers within the limits in the array.
			{	r = c;
				MakeList(tail, r, pCan); // Call the MakeList function
				sP++; 
			}
		}
	}
	// Variables for the perfect squares(V4)
	double sq;
	int perfectSQ;
	int pythC = 0; // pyth[] subscript
	int pyth[1000] = {0}; // The array to store the pythagorean numbers
	cout << "q" << "     " << "p[q]\n \n";
	for (int count = 0; count < sP; count++)
	{	sq = sqrt((double)pCan[count]); //square root of the pCan value
		perfectSQ = (int)sq; // convert to int
		if (sq == perfectSQ) // check if perfect square
		{	pyth[pythC] = pCan[count]; // move perfect into pythangorean number array
			pythC++; // ready for next number
		}
	}
	for (int i = 0; i < sP; i++)
	{	if (pyth[i] != 0)
			cout << i << setw(7) << pyth[i] << " Is a perfect square\n";
	}
	system("pause");
	return 0;
}  //end main

void MakeList(int &t, int r, int p[])
{	int q = -1; // Initial value of q needs to be -1 so we can make sure T is bigger
	bool f = false; // did we find where r belongs?
	int x;
	if (t == -1)
	{   p[0] = r; // insert r into start of array p
		t = t + 1; //ready for next r value
		f = true; // found a value
	}
	while (q < t && !f)
	{	q = q + 1; 
		if (r <= p[q]) // does r belong before p[q]?
		{	f = true; // r is less than or equal to p[q]
			if (r != p[q]) // is r unique?
			{	x = t; // move tail into x for manipulation
				while (x >= q) // Moves and checkes numbers in p[] to find the correct place for r
				{	p[x + 1] = p[x]; 
					x = x - 1;	// Making x one less so it can check again for more than one duplicate
				}
				t = t + 1; // ready for next r value
				p[q] = r;   // move r into array p[]
			}
		}
	}
	if (f == false) // r is the biggest number we want to insert
	{	t = t + 1; 
		p[t] = r; 
	}
}// end MakeList function