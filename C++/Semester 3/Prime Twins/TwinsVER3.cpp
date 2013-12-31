/*********************************** ID BLOCK **************************************


Due Date: September 18th, 2013
Software Designer: Geoffrey Shapiro
Course: 420-306 Fall 2013
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


#include <iostream>
#include <conio.h>    
#include <iomanip> 
using namespace std;

int main()
{
   int lo, hi, p, t, f, n, sw;
   sw = 0;

   cout << "This program generates odd numbers between odd limits lo and hi.\n";
   cout << "Type a positive odd integer lower limit lo: \n";
   cin >> lo;
   cout << "Type a positive odd integer upper limit hi >= lo + 2: \n";
   cin >> hi;
    cout << "Type a gap that you want us to use for the twins check: \n";
   cin >> n;

   p = lo;
   while( p <= hi )            //until upper limit
      {
		
		  t = 3;
		  f = 1;

		  while((t*t <= p) && f == 1)
		  {
			  if (p % t == 0) // Checking is the number is divisible evenly
			  {
				  f = t; // Not prime 
				  t = p; // giving T the lower limit
			  }
			  else
		      t = t + 2; // Incremening T by two and it is prime

		  }
		  if (f == 1) // This means we found at least one prime
		  {
			  cout << "Prime!";
			  cout << setw(6) << p << '\n';
			  if (sw == 0) // Checking if this is already a twin
			  {
				  sw = 1; // We found the first prime in the set
				  p = p + n; // Making P the next nubmer to check
			  }
			  else if (sw == 1) // The 2nd twin has been found
			  {
				  cout << p-n << " and " << p << " are twins! \n";
				  sw = 0; // set switch back to 0
				  p = p - n; // make P back to the original number
				  p = p + 2; // move towards the next number
			  }
		  }
		  else
		  {
			  if (sw == 1) // We found one prime number but no twin
			  {
				  sw = 0; // Restart
				  p = p - n; // Make P normal again
			  }
			  p = p + 2; // increment P

		  }
		  
      }                        //end while
   system( "pause");
   return 0;
}  //end main
