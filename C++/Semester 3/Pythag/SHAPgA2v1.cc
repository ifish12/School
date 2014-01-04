// pythVER1.cpp
// works with nested loops, integer arithmetic and arrays 
// generates the upper triangular table beautifully, with columns aligned 
// overflows the screen when m > 798 
#include <iostream>
using namespace std;
#include <conio.h> 
#include <math.h>
#include <iomanip> 

int main()
   {
   int m, i, j, c;
   int mm;
   double xm;
   
   cout << "This program generates Pythagorean candidate numbers in a table.\n";
   cout << "Type integer candidate number size limit m\n";
   cin >> m;
   
   xm = m + 1;				//find corresponding table-size mm for this limit
   mm = sqrt(xm/2.) +2;
   cout << "The row/column size of the candidate-table is: " << mm - 1 <<"\n\n\n";

   cout << "COL ";
   for ( j=2; j < mm; j++ )
	   cout <<  setw(5) << j;
   cout << "\n\n";

   // generate the upper-right triangular table
   // using field-size = 5 character positions
   for ( i=1; i < mm - 1; i++ )         // begin row loop; note row mm [i.e. last] is empty
   {  cout << "R=" << setw(2) << i;  // header

                                        // handle columns
	  for ( j= 2; j <= i; j++)          // note: column 1 is empty 
		  cout << setw(5) << " ";       // leave columns 2 to i blank

	  for ( j= i + 1; j < mm; j++)      // show p-candidates on rest of row
	  {
		  c = i*i + j*j;
		  cout << setw(5) << c ;	
	  }
      cout << "\n";
   }  // end the row loop
   system( "pause");
   return 0;
   }  //end main