/*********************************** ID BLOCK **************************************


Due Date: October, 19th 2014
Software Designer: Geoffrey Shapiro
Course: 420-306 Fall 2014
Deliverable: Assignment #3--- Sorting and Searching
Description:
***********************************************************************************/
#include <iostream>
#include <string>
#include <cstring>
#pragma warning(disable: 4996)
using namespace std;

const int LMAX = 100;       //maximum number of name strings in array
const int NMAX = 10;        //maximum size of each name string
const int LSIZE = 20;		       //number of actual name strings in array
/************************* Prototypes*********************************/
void OutList(char[][NMAX], int[], char[], char[], char[]); // Gets lsize, our name array, our weight array, and 3 titles
void PutMenu(); // Puts up a menu
char GetChoice();  // Grabs a character and returns it
bool ChooseSort(char, int, char[][NMAX], int[], bool&); // picks sort
void CopyList(int, char[][NMAX], int[], char[][NMAX], int[]);
void InSort(int, char[][NMAX], int[]);
void SelSort(int, char[][NMAX], int[]);
void ShellSort(int, char[][NMAX], int[]);
int  GetGaps(int[]);
int BinarySearch(char[][NMAX], char[], char[]);

/*********************************************************************/


int main()
{	//array of name strings
	char nam[LMAX][NMAX] = { "wendy", "ellen", "freddy", "tom", "susan",
		"dick", "harry", "aloysius", "zelda", "sammy",
		"mary", "hortense", "georgie", "ada", "daisy",
		"paula", "alexander", "louis", "fiona", "bessie" };
	//array of weights corresponding to these names
	int wght[LMAX] = { 120, 115, 195, 235, 138, 177, 163, 150, 128, 142,
		118, 134, 255, 140, 121, 108, 170, 225, 132, 148 };
	char WKnam[LMAX][NMAX]; // An array used to store the sorted name array to keep the original in-tact
	char lnam[NMAX];       // The lowercase name to search for 
	int WKwght[LMAX];       // An array used to store the sorted weights array to keep the original in-tact
	char Choice;   // The choice that is passed to ChooseSort which contains a number between 1 and4
	char xnam[10]; // The name for to search for with BinarySearch
	bool dosort = false; // The boolean used to know if the user wants to keep sorting
	bool donesort = false; // The boolean used to make sure the user has sorted at least once.
	int location; // This is the subscript in both the WKnam and WKwght arrays where the name is found.

	OutList(nam, wght, "UNSORTED ARRAY DATA: ", "NAMES", "WEIGHTS"); // Passing the variables we want to pass to the OutList function. 
	system("pause");

	while (dosort == false) // Checks whether the user wants to keep sorting
	{	PutMenu(); // Prints out our menu
		Choice = GetChoice(); // Getting the choice from the user
		if (Choice != '4') // when choice is 4 we don't want to copy the unsorted list
			CopyList(LSIZE, nam, wght, WKnam, WKwght);  // Copies the original name and weight arrays and puts them into WKnam and WKwght respectively 
		dosort = ChooseSort(Choice, LSIZE, WKnam, WKwght, donesort); // Calls the functions for sorting or searching and lets us know whether to keep the loop going
		system("pause");
	}
	system("cls");
	printf("Please enter a name to search for: ");
	gets(xnam); // Storing the name our user wants to search for
	while (xnam[0] != 0) // Checks whether the user filled out the name properly or just his enter to escape
	{	system("cls");
		printf("\n");
		location = BinarySearch(WKnam, xnam, lnam); // The subscript location of the name being searched for. Or -1
		if (location > -1) // Successfully found name in the array
		{	printf("%s was found as position %i and their body weight is %i\n\n", xnam, location, WKwght[location]);
			system("pause");
		}
		else // Did not successfully find person
		{	printf("%s was not found\n\n", xnam);
			system("pause");
		}
		system("cls");
		printf("Please enter a name to search for: ");
		gets(xnam);
	}
	return 0;
}


/*
OutList:

OutList is a function used to output the name
and weight arrays. Sorted or unsorted. The
3 titles(title, names, and wghts) are dynamic because
it will either say "UNSORTED" or "SORTED" depending
on the situation.
*/
void OutList( char nm[][NMAX], int wt[], char title[], char names[], char wghts[])
{	printf("%s\n\n", title);
	printf("%12s %12s\n\n", names, wghts);
	for (int j = 0; j < LSIZE; j++) //display name strings & corresponding weights
		printf("%12s %12i\n",nm[j], wt[j]); // outputs names and weights
	printf("\n\n");
}

/*
PutMenu:

PutMenu just prints out a simple
5 line menu of what the user has
the ability to choose.
*/

void PutMenu()
{	system("cls");
	printf("Please choose what you would like to do: \n\n");
	printf("1     Insertion Sort\n");
	printf("2     Selection Sort\n");
	printf("3     Shell Sort\n");
	printf("4     Do search transactions\n");
}

/*
GetChoice:

GetChoice basically gets the choice
from the user and then returns it back to the main function
*/

char GetChoice()
{	char choice[100]; // An array we use to get the choice from our user
	char ch; // The first actual choice from the user. 
	bool done = false; // A boolean that will change when the user finally inputs a proper choice
	while (!done) // We'll keep asking and doing this until we get a valid choice. 
	{	printf("Choice: ");
		gets_s(choice); // Storing the input into our variable
		ch = choice[0]; // Grabbing the first character because that's all we need
		if (ch >= '1' && ch <= '4') // Making sure ch is between 1 and 4.
			done = true; // Valid choice, we don't want to keep looping
		else
			done = false; // We didn't get a valid choice, need to ask user again
	}
	return ch;
}

/*

ChooseSort:

ChooseSort is the logic I'm using to call the correct
sorting functions and making sure they're good.
Also when the user wants to stop sorting, it's in charge
of the boolean value used in main's sorting loop
*/

bool ChooseSort(char ch, int size, char WKnam[][NMAX], int WKwght[], bool& DoneSort)
{	switch (ch) // Sends us to the correct case based on ch
	{   case '1':
			printf("I am insertion\n");
			InSort(size, WKnam, WKwght); // Calls the InSort function with all the correct paramaters
			system("cls");
			OutList(WKnam, WKwght, "SORTED ARRAY DATA", "SORTED NAMES", "SORTED WEIGHTS"); // Outputting the sorted arrays
			DoneSort = true; // Changes this bool to true so the user can then move on to searching
			return false; // Keeps dosort false in main so we can get here once again
		case '2':
			printf("I am selection\n");
			SelSort(size, WKnam, WKwght); // Calls the SelSort function with all the correct paramaters
			system("cls");
			OutList(WKnam, WKwght, "SORTED ARRAY DATA", "SORTED NAMES", "SORTED WEIGHTS"); // Outputting the sorted arrays
			DoneSort = true; // Changes this bool to true so the user can then move on to searching
			return false; // Keeps dosort false in the main so we can get back here
		case '3':
			printf("I am  shell\n");
			ShellSort(size, WKnam, WKwght); // Calls the ShellSort function with all correct parameters
			system("cls");
			OutList(WKnam, WKwght, "SORTED ARRAY DATA", "SORTED NAMES", "SORTED WEIGHTS"); // Outputting the sorted arrays
			DoneSort = true;  // Changes this bool to true so the user can them move on to searching
			return false; // Keeps dosort false in the main so we can return here 
		case '4':
			if (DoneSort == true) // Making sure the user sorted at least once
				return true; // Returns true to break out of the sorting loop in main
			else
				return false;
		default:
			printf("Nothing was picked\n");
			break;
	}
}

/*
CopyList:

Copies the original name and weight
arrays and copies them into WKnam
and WKwght
*/

void CopyList(int lsize, char nm[][NMAX], int wt[], char wm[][NMAX], int wwt[])
{	for (int count = 0; count < lsize; count++) // Goes through each part of our arrays once
	{	strcpy_s(wm[count], nm[count]); // Copies the current section of the original name array into the new one
		wwt[count] = wt[count];  // Copies the current section of our origina weight array into our new one
	}
}

void InSort(int lsize, char name[][NMAX], int weight[])
{	printf("Insetion is running\n");
	int k = 1;
	char y[10];
	int i;
	bool found = false;
	int weightQ;

	do
	{   strcpy(y, name[k]);
		weightQ = weight[k];
		i = k - 1;
		found = false;
		while (i >= 0 && !found)
		{	if (strcmp(y, name[i]) < 0)
			{	strcpy(name[i + 1], name[i]);
				weight[i + 1] = weight[i];
				i = i - 1;
			}
			else
				found = true;
		}
		strcpy(name[i + 1], y);
		weight[i + 1] = weightQ;
		k = k + 1;
	} while (k <= lsize - 1);
	system("pause");
}

/*
SelSort:
This function does the selection sort
algorithm and sorts the name and weights
arrays correctly.


*/

void SelSort(int lsize, char name[][NMAX], int weight[])
{	printf("Selection sort is running\n");
	int i; // The subscript which increments down
	int what; // The location of the found match
	int j; // a counter
	char big[10]; // The "biggest" name
	int weightQ; // the biggest weight
	i = lsize - 1;
	do
	{	strcpy(big, name[0]); // Initially storing the first subscript / name into the biggest spot
		weightQ = weight[0]; // Initially making the first weight the biggest
		what = 0;  
		j = 1; 
		do
		{	if (strcmp(name[j], big) >= 1) // Is name[j] greater than big?
			{	strcpy(big, name[j]); // Put name[j] into big because it's greater
				weightQ = weight[j]; // The weight will move with it because the name is what we're sorting by
				what = j; // What goes to J because it's where we found the switch	
			}
			j = j + 1; 
		} while (j <= i);
		strcpy(name[what], name[i]); // Moving name[i] into name[what] because it's bigger
		weight[what] = weight[i];  // Moving the weight because it has to match the correct person
		strcpy(name[i], big); // Moving the biggest value into name[i]
		weight[i] = weightQ;  // Moving the weight because it has to match the correct person
		i = i - 1; 
	} while (i > 0); // Making sure i is still greater than 0 so we can still continue
	system("pause");
}

int GetGaps(int gaplist[])
{	printf("generatins gaps\n");
	int gap = 1;
	int pos = 0;
	int numgaps;
	int high = LSIZE - 1;
	int low = 0;

	while (gap < (high - low) + 1)
	{	gaplist[pos] = gap;
		gap = gap * 3;
		pos = pos + 1;
	}
	numgaps = pos - 1;
	return numgaps;
}

void ShellSort(int lsize, char name[][NMAX], int wght[])
{	printf("Shell sort running\n");
	int gaplist[20] = { 0 };
	int numgaps = 0;
	int gap;
	int i;
	int j;
	bool found;
	int k;
	char y[10];
	int weightQ;
	numgaps = GetGaps(gaplist);
	i = numgaps;
	do
	{	gap = gaplist[i];
		j = gap;
		do
		{	strcpy(y, name[j]);
			weightQ = wght[j];
			k = j - gap;
			found = false;
			while (k >= 0 && !found)
			{	if (strcmp(y, name[k]) == -1)
				{	strcpy(name[k + gap], name[k]);
					wght[k + gap] = wght[k];
					k = k - gap;
				}
				else
					found = true;
			}
			strcpy(name[k + gap], y);
			wght[k + gap] = weightQ;
			j = j + 1;
		} while (j <= lsize - 1);
		i = i - 1;
	} while (i >= 0);
}
int BinarySearch(char name[][NMAX], char xname[], char lnam[])
{	int bsrch;
	int low;
	int high;
	int mid;
	bsrch = -1;
	low = 0;
	high = LSIZE - 1;
	for (int i = 0; i < NMAX; i++)
		lnam[i] = tolower(xname[i]);
	while (low <= high)
	{	mid = (low + high) / 2;
		if (strcmp(lnam, name[mid]) == 0)
			return mid;
		else if (strcmp(lnam, name[mid]) == -1)
			high = mid - 1;
		else
			low = mid + 1;
	}
	return -1;
}
