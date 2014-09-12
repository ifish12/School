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
{   int lo, hi, p;
	cout << "This program generates odd numbers between odd limits lo and hi.\n";
	cout << "Type a positive odd integer lower limit lo: ";
	cin >> lo;
	cout << "Type a positive odd integer upper limit hi (hi must be >= lo + 2): ";
	cin >> hi;
	p = lo;
	while (p <= hi)            //until upper limit
	{ cout << setw(6) << p << '\n';
		p = p + 2;
	}                        //end while
	system("pause");
	return 0;
}  //end main