/*
	Geoffrey Shapirio
	Assignment 4
	Oct, 26, 2012
	IDs and such??????
*/ 
#include <iostream>
#include <iomanip>
using namespace std;

void main()
{
	const int MAX_IDS = 8;
	const int GAMES  = 4;

	int IDs[MAX_IDS] = {126, 376, 495, 553, 575, 643, 768, 850};
	int scores[MAX_IDS] = {0};
	int count;
	int totals = 0;
	int who;
	int ID; 
	int score;
	int scoreTotal = 0;
	int highest;


	cout << "GAME TESTING - TESTERS PLAY 4 GAMES EACH" << endl;
	cout << endl;

	while (true)
	{
		cout << endl;
		cout << "Possible Tester IDs are ";
		for (count = 0; count < MAX_IDS - 1; count++)
			cout << IDs[count] << ", ";
			cout << IDs[MAX_IDS - 1] << endl;

		do
		{

			cout << "Enter your employee id (0 to exit): ";
			cin  >> ID;

			if (ID == 0)
				break;
			
			for (who = 0; who < MAX_IDS; who++)
				if (ID == IDs[who])
					break;
		}
		while (who == MAX_IDS);

		if (ID == 0)
			break;

		scoreTotal = 0;
		highest = 0;
		for (count = 0; count < GAMES; count++)
		{
			do
			{
				cout << "Score Game " << count + 1 << " (10-1000, 0 to exit): "; 
				cin  >> score;

			}
			while ((score < 10 || score > 1000)  && score != 0);
		
			if (score == 0)
			{
				break;
				scoreTotal = 0;
			}
			

			scoreTotal = score + scoreTotal;
			
			if (scoreTotal > highest)
				highest = scoreTotal;
		}
		totals++;

		scores[who] = scoreTotal;

		if (score == 0)
			break;

	}
	if (score > 0)
	{
	system ("cls");
	cout << "GAME TESTING - SUMMARY" << endl;
	cout << endl;
	cout << totals << " testers have recorded their 4 game scores" << endl;
	cout << endl;
	cout << "Tester IDs          Cumulative Score" << endl;
	for (count = 0; count < MAX_IDS; count++)
		if (scores[count] > 0)
			cout << IDs[count] << "                              " << scores[count] << endl;
	cout << endl;
	cout << "The highest cumulative score is " << highest << endl << endl;
	}
}