/*
	Assignment 6
	November, 30th, 2012
	Geoffrey Shapiro.
	
	Program will ask for input the date of the offence, the police officer’s badge number, 
	the driver’s name (first and last) and the velocity at which the vehicle was going.
	For each offender entered, the program will display a ticket summary.
	At the end, the program will display the total # of tickets issued, 
	the total amount of fines and the total amount of fines per police officer 
	(going from the highest to the lowest).

*/

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

int    TicketInfo(string&);
int    Month(int&, int&);
int   sortArrays (int[], double[], const int, string[]);
int    BadgeNum(int[], int&, const int);
int    Driver(string, string&, const int);
int    Fines(int&, int, double[], double&, const int);
int    DisplaySummary (int, int, string, string, string, double, string);
int     theEnd (double,int, int[], string[], double[], const int);

int main()
{
	const int MAX_BADGE      = 4;
	const int MAX_FIRST      = 20;
	const int MAX_LAST       = 25;
	string ticketInfo;
	int badge[MAX_BADGE]     = {1234, 2345, 3456, 4567};
	double officerFines[MAX_BADGE] = {0};
	string monthName[12]     = { "January", "February", "March", "April", "May", "June",  "July", "August", "September", "October", "November", "December" };
	string question1         = "Driver's first name (20 chars max): ";
	string question2         = "Driver's last name (25 chars max): ";
	string firstName;
	string lastName;
	string officerName [MAX_BADGE] = {"Sandra Claus", "Jack Frost", "Peter Snow", "Wendy White"};
	int    totalTickets;
	int    day;
	int    year;
	int    month; 
	int    guy; 
	double fines;
	double totalFines;
	totalFines = 0;

	year = 2012;

	while(true)
	{
	TicketInfo(ticketInfo);

	if (ticketInfo[0] == 'N')
		break;
	cout << endl;
	Month(month, day);
	cout << endl; 
	BadgeNum(badge,guy, MAX_BADGE);
	cout << endl;
	Driver(question1, firstName, MAX_FIRST);
	Driver(question2, lastName, MAX_FIRST);
	if (firstName == "Quit")
		break;
	fines = Fines(totalTickets, guy, officerFines, fines, MAX_BADGE);
	DisplaySummary(day, year, monthName[month], officerName[guy], firstName, fines, lastName);

	}
	sortArrays (badge, officerFines, MAX_BADGE, officerName);
	theEnd ( totalFines,totalTickets, badge, officerName, officerFines, MAX_BADGE);
	system("pause");

	return 0;
}

int TicketInfo (string& ticket)
{
	do
	{
		do
		{
		cout << "Enter ticket(Y or N): ";
		getline (cin, ticket);
		}
		while (ticket.empty() || ticket.length() > 1);
		
		ticket[0] = toupper (ticket[0]);
	}
	while(ticket[0] != 'Y' && ticket[0] != 'N');

	
	return 0;
}

int Month(int& month, int& day)
{
	do
	{
		cout << "Day of offence (1 to 31): ";
		cin  >> day;
	}
	while(day > 31 || day < 1);
	
	do
	{
		cout << "Month of offence (1 to 12): ";
		cin  >> month; 
	}
	while(month > 12 || month < 1);

	return 0;
}

int BadgeNum(int badge[], int& guy, const int MAX)
{
	int count;
		
	cout << "Possible Officer Badge #s: ";
	for(count = 0; count < MAX - 1; count++)
		cout << badge[count] << ", "; 
	cout << badge[MAX - 1];
	cout << endl;

	do
	{
		cout << "Officer badge #: ";
		cin  >> guy;
		for(count = 0; count < MAX; count++)
			if(guy  == badge[count])
				break;
	}
	while(guy != badge[count]);

	return 0;

}

int Driver (string question, string& answer, const int MAX) // <-- Function definition
{
	int count;
	

	do
	{
		cout << question;
		cin.ignore();
		getline (cin, answer);
	}
	while (answer.empty() || answer.length() > MAX); // Checking the length of the string

	answer[0] = toupper (answer[0]); // Changing the first letter to a capital

	for (count = 1; count < answer.length(); count++)
		answer[count] = tolower (answer[count]); // Making all the other letters in the string lowercase

	return 0;
}




double Fines(int& total, int who, double officer[], double& totalFine, const int MAX)
{
    int    velocity;
    double fine;
 
    do
    {
        cout << "Vehicle velocity (71 to 180):          ";
        cin  >> velocity;
    }
    while (velocity < 71 || velocity > 180);
 
    cout << endl;
 
    if (velocity < 91)
        fine = 4 * (velocity - 70);
    else
        if (velocity <101)
            fine = 8.5 * (velocity - 70);
        else
            if (velocity < 111)
                fine = 15.5 * (velocity - 70);
            else
                fine = 22 * (velocity - 70);
    total++;
    totalFine = totalFine + fine;
    officer[who] = officer[who] + fine;
 
    return fine;
}

 

int DisplaySummary (int day, int year, string month, string guy, string first, double fines, string last)
{
	string dayEndings[4] = { "th", "st", "nd", "rd" };
	string order;
	
	if (day % 10 < 4 && day / 10 != 1 )

		order = dayEndings[day % 10];
	else
		order = dayEndings[0];
	
	system ("cls");

	cout << month << " " << day << order << ", " << year << endl;
	cout << "Arrest made by " << guy << endl;
	cout << "Offender " << first << " " << last << " was fined ";
	cout << setw (3) << fixed << setprecision(2) << fines << "$" << endl;
	cout << endl << endl;

	return 0;
}



int sortArrays (int badge[], double fine[], const int MAX, string officer[])
{
		int    start;
		int    element;

		for ( start = 0; start < MAX - 1; start++ )
			for ( element = start + 1; element < MAX; element++ )
				if ( fine[element] > fine[start] )
				{
					swap (fine[start], fine[element]);
					swap (badge[start], badge[element]);
					swap (officer[start], officer[element]);

				}
			return 0;
}


int theEnd (double totalFine,int total, int officer[], string names[], double fines[], const int MAX)
{
	int count;

	cout << "Total # of tickets\tTotal amount of fines" << endl;
	cout << setw(18) << right << total << "\t" << setw(21) << setprecision(2) << totalFine << "$" << endl;
	cout << "Police Officer\tTotal amount of fines" << endl;

	for (count = 0; count < MAX; count++)
		cout << setw(7) << left << officer[count] << names[count] << "\t" << setw(21) << setprecision(2) << right << fines[count] << "$" << endl;
return 0;
}











































