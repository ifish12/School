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
				  f = t;
				  t = p;
			  }
			  else
		      t = t + 2;

		  }
		  if (f == 1)
		  {
			  cout << "Prime!";
			  cout << setw(6) << p << '\n';
			  if (sw == 0)
			  {
				  sw = 1; // The checker for the first prime number in the twins set
				  p = p + n;
			  }
			  else if (sw == 1)
			  {
				  cout << p-n << " and " << p << " are twins! \n";
				  sw = 0;
				  p = p - n;
				  p = p + 2;
			  }
		  }
		  else
		  {
			  if (sw == 1)
			  {
				  sw = 0;
				  p = p - n;
			  }
			  p = p + 2;

		  }
		  
      }                        //end while
   system( "pause");
   return 0;
}  //end main
