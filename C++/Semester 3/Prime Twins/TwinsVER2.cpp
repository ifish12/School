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
   int lo, hi, p, t, f;

   cout << "This program generates odd numbers between odd limits lo and hi.\n";
   cout << "Type a positive odd integer lower limit lo: \n";
   cin >> lo;
   cout << "Type a positive odd integer upper limit hi >= lo + 2: \n";
   cin >> hi;

   p = lo;
   while( p <= hi )            //until upper limit
      {
		  t = 3;
		  f = 1;

		  while((t*t <= p) && f == 1)
		  {
			  if (p % t == 0)
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
		  }
		  
		  
		  p = p+2; 
      }                        //end while
   system( "pause");
   return 0;
}  //end main
