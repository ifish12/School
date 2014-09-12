/*********************************** ID BLOCK **************************************
Due Date: September 10th, 2014
Software Designer: Geoffrey Shapiro
Course: 420-306 Fall 2014
Deliverable: Assignment #1--- Gap-n Twins
Description: demonstrates integer arithmetic. Program loops the odd
integers between a lower and upper limit inputed by the user.

***********************************************************************************/
/************************* PRELIMINARIES **************************/
#include <iostream>
#include <conio.h>    
#include <iomanip> 
using namespace std;
/************************* MAIN BLOCK BEGINS *************************/
int main()
{	int lo, hi, p, t, f, gap, sw;
	sw = 0;
	cout << "This program generates odd numbers between odd limits lo and hi.\n";
	cout << "Type a positive odd integer lower limit lo: ";
	cin >> lo;
	cout << "Type a positive odd integer upper limit hi (hi must be >= lo + 2): ";
	cin >> hi;
	cout << "Type a gap that you want us to use for the twins check: ";
	cin >> gap;
	p = lo;
	while (p <= hi)//until upper limit
	{   t = 3;     // Most numbers that are prime, and odd can't be devided by 3
		f = 1; 
		while ((t*t <= p) && f == 1)
		{   if (p % t == 0)// Checking if number is divisible evenly
			{   f = t; // Not prime
				t = p; // Giving T lower limit
			}else
				t = t + 2; // Incremening T by two and it is prime
		}if (f == 1) // found at least one prime
	    	{	cout << "Prime!";
				cout << setw(6) << p << '\n'; 
				if (sw == 0) 
				{	sw = 1;// We found the first prime in set
					p = p + gap;// next number to check in the gap
				}else if (sw == 1)// The 2nd twin has been found
				{   cout << p - gap << " and " << p << " are sexy twins! \n";
					sw = 0;// set switch back to 0
					p = p - gap;// make P back to the original number
					p = p + 2;// move towards the next number
				}
		   }else
			 {	if (sw == 1)// We found one prime number but no twin
				{	sw = 0;// Restart
					p = p - gap;// Make P normal again
				}p = p + 2;// increment P
			 }
	}   //end while
	system("pause");
	return 0;
}  //end main