/*
	Assignment 2
	Geoffrey Shapiro
	October 5th, 2012
	Change calculator

*/

#include <iostream>
using namespace std;

void main()
{
	int    toonies;
	int    loonies;
	int    pennies;
	int    quarters;
	int    dimes;
	int    nickels;
	int    uses;
	int    totalPennies;
	int    total5To300;
	int    total301To600;
	int    total601To999;
	int    startPennies;
	int    newPennies;
	double avgPennies;
	char   choice;

	uses           = 0;
	totalPennies   = 0;
	total5To300    = 0;
	total301To600  = 0;
	total601To999  = 0;




	cout << "CHANGE CALCULATOR - PENNIES TO MINIMUM NUMBER OF COINS" << endl;
	cout << endl << endl;

	do 
	{
		cout << "Do you want to use the Change Calculator (Y/N)? ";
		cin  >> choice;
		choice = toupper (choice);
	
	}
		while (choice != 'Y' && choice != 'N');

		system ("cls");

		while (choice == 'Y')
		{

			do
			{
				cout << "Amount of pennies (5 to 999): ";
				cin  >> pennies;
			}
			while (pennies < 5 || pennies > 999);
		

            toonies      = pennies / 200;
			startPennies = pennies % 200;

			loonies      = startPennies / 100;
			startPennies = startPennies % 100;

			quarters     = startPennies / 25;
			startPennies = startPennies % 25; 

			dimes        = startPennies / 10;
			startPennies = startPennies % 10;
			
			nickels      = startPennies / 5;
			newPennies   = startPennies % 5;



			cout << endl;
			cout << "The change for " << pennies << " pennies is" << endl;
			if (toonies > 0)
			cout << toonies    << " toonie(s)"   << endl; 
			if (loonies > 0)
			cout << loonies    << " loonie(s)"   << endl;
			if (quarters > 0)
			cout << quarters   << " quarter(s)"  << endl;
			if (dimes > 0)
			cout << dimes      << " dime(s)"     << endl;
			if (nickels > 0)
			cout << nickels    << " nickel(s)"   << endl; 
			if (newPennies > 0)
			cout << newPennies << " penny(ies)"  << endl;
			cout << endl << endl;

			if (pennies <= 300)
				total5To300++;
			else
				if (pennies > 300 && pennies <= 600)
					total301To600++;
				else
					total601To999++;

		    uses++; 
			totalPennies = totalPennies + pennies;

			do 
			{
				cout << "Do you want to use the Change Calculator (Y/N)? ";
				cin  >> choice;
				choice = toupper (choice);
				
			}
			while (choice != 'Y' && choice != 'N');
			system ("cls");
		}

		if (uses != 0)
		{
		
		avgPennies = (double) totalPennies / uses; 
		
		cout << "----------STATISTICS----------" << endl;
        if (uses > 0)
		cout << "Change Calculator was used to calculate exact change " << uses << " time(s)" << endl;
        cout << endl;
		cout << "Average # of pennies calculated exact change for: "    << avgPennies << endl;
		cout << endl;
		cout <<  "Starting penny value   (5 to 300) used " << total5To300    << " time(s)" << endl;
        cout <<  "Starting penny value (301 to 600) used " << total301To600  << " time(s)" << endl;
	    cout <<  "Starting penny value (601 to 999) used " << total601To999  << " time(s)" << endl;
	    cout << endl;
	}

}

	




