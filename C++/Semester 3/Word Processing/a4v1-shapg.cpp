// asst4v1.cpp    ALG306 
// parsing, text processing and numeric conversion
// this is an exercise in state-analysis and state-variable application design 
// data is supplied as an array of strings

#include <iostream>
#include <iomanip>             //for setw function to format output
using namespace std;

int main()
   {
	const int LMAX = 200;		//maximum number of chars per line 
	const int NLINES = 10;		//maximum number of lines
	const int NDBLE = 10;		//maximum number of doubles
	const int NINT = 10;		//maximum number of integers
	const int WMAX = 10;		//maximum number of characters in a word
   
   //array of text lines i.e. the input data
   char tline[NLINES][LMAX] = {
   "  first 123 and now second -.1234 and you're needing this 123.456 plus one of these +123. too",
   "  ellen's favourites are 123.654E-2 eg exponent-form which can also be -54321E-03 or this +432e2",
   " I'll prefer numbers like fmt1-dec +.1234567e+05 or fmt2-dec -765.3245 or fmt1-int -837465 or ", 
   " even fmt2-int -19283746 which make us think of each state's behaviour for +3 or even .3471e7 states ", 
   };			

	// ARRAYS FOR RESULTS
	// double mydbls [NDBLE];
	// int myints [NINT];
	// int mywords[WMAX];
    
/****************************************************************************
                      PRINT OUT THE RAW TEXT LINES            
****************************************************************************/
	cout << "TEXT DATA LINES:" << endl << endl;
	cout << endl;
	for(int j=0; j<NLINES; j++)  //display name strings & corresponding weights
		cout <<  tline[j]  << endl;
	cout << endl << endl;
	system("PAUSE");
   return 0;
   }