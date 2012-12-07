/*
	Geoffrey Shapiro
	November, 16th, 2012
	Usin many different funtions to validate things and put thngs into arrays and outpur bar charts!
*/

#include <iostream>
#include <string>
using namespace std;


void SurveyMember (string, string&, const int);
void InputRatings (int[], const int);
void Stats        (int[] ,const int);


void main()
{
	const int MAX_FIRST  = 20;
	const int MAX_LAST   = 25;
	const int MAX_VALUES = 5;
	int       ratingsArray[MAX_VALUES];
	
	string firstNameQuestion = "First Name (20 chracters max, type \"quit\" to stop): ";
	string lastNameQuestion  = "Last  Name (25 chracters max, type \"quit\" to stop): ";

	string firstName;
	string lastName;
	
	while (true)
	{
		SurveyMember(firstNameQuestion, firstName, MAX_FIRST); // <--- function call
		
			if (firstName == "Quit")
				break;

		SurveyMember(lastNameQuestion, lastName, MAX_LAST);

			if (lastName == "Quit")
				break;

	system ("cls");

	cout << "First Name: " << firstName << endl;
	cout << "Last Name:  " << lastName << endl;
	cout << endl << endl;

	InputRatings(ratingsArray, MAX_VALUES);
	
	
	cout << endl << endl;

	cout << "Consumer satisfaction bar chart: ";
	cout << endl << endl;
	
	Stats(ratingsArray, MAX_VALUES); 
	cout << endl << endl;

	}

	system ("pause");
}

void SurveyMember (string question, string& answer, const int MAX) // <-- Function definition
{
	int count;
	

	do
	{
		cout << question;
		getline (cin, answer);
	}
	while (answer.empty() || answer.length() > MAX); // Checking the length of the string

	answer[0] = toupper (answer[0]); // Changing the first letter to a capital

	for (count = 1; count < answer.length(); count++)
		answer[count] = tolower (answer[count]); // Making all the other letters in the string lowercase
}

void InputRatings (int Array[], const int MAX)
{
	int count;
	string letter;


	for(count = 0; count < MAX; count++)
	{
		do
		{
			do
			{
				cout << "Rating for product no." << count + 1 << " (A to E): ";
				getline (cin, letter);
			}
			while (letter.empty() || letter.length() > 1);
			letter[0] = toupper(letter[0]);
		}
		while (letter[0] < 'A' || letter[0] > 'E');

		if (letter[0] == 'A')
			Array[count] = 10;
		else
			if (letter[0] == 'B')
				Array[count] = 8;
			else
				if (letter[0] == 'C')
					Array[count] = 6;
				else
					if (letter[0] == 'D')
						Array[count] = 4;
					else
						Array[count] = 2;
	}
}

void Stats (int Array[], const int MAX)
{
	int count;
	int what;

		for (count = 0; count < MAX; count++)
		{
			cout << "Product #" << count + 1 << "      ";
			for (what = 0; what < Array[count]; what++)
				cout <<  "*";
		cout << endl;
		}
}