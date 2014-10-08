// pythVER2.cpp
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
	int high;
	int low;
	int mm;
	double xm;
	int pCan[1000] = { 0 };
	int testCounter = 0;

	cout << "This program generates Pythagorean candidate numbers in a table.\n";
	cout << "Type integer candidate number size limit m\n";
	cin >> m;
	cout << "Type the higher bound limit\n";
	cin >> high;
	cout << "Type the lower bound limit\n";
	cin >> low;
	cout << endl;


	xm = m + 1;				            //find corresponding table-size mm for this limit
	mm = sqrt(xm / 2.) + 2;

	for (i = 1; i < mm - 1; i++)         // begin row loop; note row mm [i.e. last] is empty
	{                                    // handle columns

		for (j = i + 1; j < mm; j++)      // show p-candidates on rest of row
		{
			c = i*i + j*j;
			if (c >= low && c <= high) // Only putting the the numbers within the limits in the array.
				pCan[testCounter] = c;

			testCounter++;
		}

	}
	for (int counter = 0; counter < 1001; counter++)
	{
		if (pCan[counter] != 0 && pCan[counter] >= 1) // Logic to not output the excess numbers
			cout << pCan[counter] << endl;

	}
	system("pause");
	return 0;
}  //end main