/*
	Geoffrey Shapiro
	Oct, 19th, 2012
	Outputting letters using other letters
	Assignmant 3
*/

#include <iostream>
using namespace std;

void main()
{	
	char choice;
	int  rowsWanted;
	int  colsWanted;
	int  rows;
	int  cols;

	cout << "DRAWLING LETTERS";
	cout << endl << endl << endl;

	while (true)
	{
	

		do 
		{
			cout << "Letter to draw (F, N, R, V, W, Y, or Q to quit program): ";
			cin  >> choice;
			choice = toupper (choice);
		}
		while (choice != 'F' && choice != 'N' && choice != 'R' && choice != 'Y' && choice != 'V' && choice != 'W' && choice != 'Q');
		
		if (choice == 'Q')
			break; 

		do 
		{
			cout << "Rows wanted (odd number, 7 to 17, or 0 to quit program): ";
			cin  >> rowsWanted;
	
		}
		while ((rowsWanted < 7 || rowsWanted > 17 || rowsWanted%2 == 0) && rowsWanted != 0);

		if (rowsWanted == 0)
			break; 

		cout << endl << endl;

		if (choice == 'F')
		{
			colsWanted = rowsWanted;
			for (rows = 0; rows < rowsWanted; rows++)
			{
				for (cols = 0; cols < colsWanted; cols++)
					if  ( rows == 0 || rows == rowsWanted / 2 || cols == 0)
						cout << 'F';
					else
						cout << ' ';
				cout << endl;
			}
		}

		if (choice == 'N')
		{
			colsWanted = rowsWanted;
			for (rows = 0; rows < rowsWanted; rows++)
			{
				for (cols = 0; cols < colsWanted; cols++)
					if  ( rows == cols || cols == colsWanted-1 || cols == 0)
						cout << 'N';
					else
						cout << ' ';
				cout << endl;
			}
		}

		if (choice == 'R')
		{
			colsWanted = rowsWanted;
			for (rows = 0; rows < rowsWanted; rows++)
			{
				for (cols = 0; cols < colsWanted; cols++)

					if  ( rows == 0 || rows == rowsWanted / 2 || cols == 0 || rows == cols && rows >= rowsWanted/2 || cols == colsWanted-1  && rows <= rowsWanted / 2)
						cout << 'R';
					else
						cout << ' ';
				cout << endl;
			}
		}

		if (choice == 'V')
		{
			colsWanted = rowsWanted;
			for (rows = 0; rows < rowsWanted; rows++)
			{
				for (cols = 0; cols < colsWanted*2-1; cols++)
					if  ( rows == cols || rows+cols == (rowsWanted-1)*2)
						cout << 'V';
					else
						cout << ' ';
				cout << endl;
			}
		}

		if (choice == 'W')
		{
			colsWanted = rowsWanted;
			for (rows = 0; rows < rowsWanted; rows++)
			{
				for (cols = 0; cols < colsWanted*4-3; cols++)
					if  ( rows == cols || rows+cols == (rowsWanted-1)*2 || rows == cols - (rowsWanted-1)*2  || rows+cols == (rowsWanted-1)*4) 
						cout << 'W';
					else
						cout << ' ';
				cout << endl;
			}
		}
		if (choice == 'Y')
		{
			colsWanted = rowsWanted;
			for (rows = 0; rows < rowsWanted; rows++)
			{
				for (cols = 0; cols < colsWanted; cols++)
					if  ( rows == cols && rows <= rowsWanted/2 || rows+cols == rowsWanted - 1 && rows < rowsWanted/2 || cols == colsWanted/2 && rows > rowsWanted/2)
						cout << 'Y';
					else
						cout << ' ';
				cout << endl;
			}
		}
		cout << endl << endl;
	}
}
