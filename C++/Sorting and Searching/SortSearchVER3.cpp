/*********************************** ID BLOCK **************************************


Due Date: October, 19th 2013
Software Designer: Geoffrey Shapiro
Course: 420-306 Fall 2013
Deliverable: Assignment #3--- Sorting and Searching
Description: 


***********************************************************************************/
#include <iostream>
#include <iomanip>             //for setw function to format output
#include <string>
#include <cstring>

using namespace std;

const int LMAX = 100;       //maximum number of name strings in array
const int NMAX = 10;        //maximum size of each name string
int LSIZE = 20;		       //number of actual name strings in array

/************************* Prototypes*********************************/
void OutList (int, char[][NMAX], int[]);
void PutMenu ();
char GetChoice();
void ChooseSort(char);
void CopyList(int, char[][NMAX], int[], char[][NMAX], int[]);

/*********************************************************************/


int main()
  {					    //array of name strings
   char nam[LMAX][NMAX] = { "wendy", "ellen", "freddy", "tom", "susan", 
	                         "dick", "harry", "aloysius", "zelda", "sammy",
							 "mary", "hortense", "georgie", "ada", "daisy", 
					    	 "paula", "alexander", "louis", "fiona", "bessie"  };			

						//array of weights corresponding to these names
   int wght[LMAX] = { 120, 115, 195, 235, 138, 177, 163, 150, 128, 142,
                       118, 134, 255, 140, 121, 108, 170, 225, 132, 148 };

   char WKnam[LMAX][NMAX];

   int WKwght[LMAX];

   char Choice;
   

    OutList(LSIZE, nam, wght);

	system("pause");

	PutMenu();

	Choice = GetChoice();

	CopyList(LSIZE, nam, wght, WKnam, WKwght);

	ChooseSort(Choice);

	

	system ( "pause" );
 
   return 0;
}

void OutList(int nn, char nm[][NMAX], int wt[])
{
   cout << "UNSORTED ARRAY DATA:" << endl << endl;
   cout << setw(12) << "NAMES" << setw(12) << "WEIGHTS" << endl << endl;

   for(int j=0; j< nn; j++)  //display name strings & corresponding weights
      cout << setw(12) << nm[j] << setw(12) << wt[j]  << endl;

    cout << endl << endl;

}

void PutMenu()
{
	system("cls");
	cout << "Please choose what you would like to do" << endl << endl;
	cout << "1" << "     " <<"Insertion sort" << endl;
	cout << "2" << "     " << "Selection sort" << endl;
	cout << "3" << "     " << "Shell sort" << endl;
	cout << "4" << "     " << "Do search transactions" << endl;
}

char GetChoice()
{
	char choice[100];
	char ch;
	bool done = false;


	while(!done)
	{
		cout << "Choice: ";
		gets_s(choice);
		ch = choice[0];


		if(ch >= '1' && ch <= '4')
			done = true;
		else
			done = false;
	}
	//cout << ch << endl;
	return ch;
}

void ChooseSort(char ch)
{
	switch(ch)
	{
		case '1': 
			cout << "I am an insertion" << endl;
			break;
		case '2':
			cout << "I am a selection" << endl;
			break;
		case '3':
			cout << "I am Shell" << endl;
			break;
		case '4':
			cout << "I am search transactions" << endl;
			break;
		default:
			cout << "Nothing was picked" << endl;
			break;
	}
}

void CopyList(int lsize, char nm[][NMAX], int wt[], char wm[][NMAX], int wwt[])
{
	for (int count = 0; count < lsize; count++)
	{
		strcpy_s(wm[count], nm[count]);
		wwt[count] = wt[count];

	}
}