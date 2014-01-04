/*********************************** ID BLOCK **************************************


Due Date:			October, 18th, 2013
Software Designer:  Geoffrey Shapiro
Course:				420-306 Fall 2013
Deliverable:	    Assignment #4--- Word Processing
Description:		This programs takes an already made 2D array of characters and parses them into other forms of data. 
					It handles the states and manages the numbers. It'll convert the numbers stored in chars into ints and doubles 



***********************************************************************************/

/************************* PRELIMINARIES **************************/

#include <iostream>
#include <iomanip>              // for setw function to format output
#pragma warning(4996: disable ) // disable string library deprecation warnings
using namespace std;
 /******************************************************************/

/************************PROTOTYPES**************************/

enum StateType{white, word, num, dble, expo}; // The states
enum CharType{whsp, lett, expnt, digit, plus, minus, point, apos, endstr}; // Each character type
 
//The states
void WhiteState(); 
void NumState();
void DbleState();
void ExpntState();
void WordState();
 
// The state transitions
void WhiteToNum();
void WhiteToDble();
void WhiteToWord();
void WordToWhite();
void NumToWhite();
void DbleToWhite();
void ExpntToWhite();
void NumToDble();
void NumToExpnt();
void DbleToExpnt();

// Printing the final results
void PrintResults();
 
const int LMAX    = 200;                // maximum number of chars per line
const int NLINES  = 10;         // maximum number of lines
const int myLINES = 4;      // ACTUAL number of text data lines
const int NDBLE   = 10;         // maximum number of doubles
const int NINT    = 10;         // maximum number of integers
const int WMAX    = 13;         // maximum number of characters in a word
 
int ival; // Convered char numbers to actual numbers
double val; // Converted decimal char numbers to actual doubles
int sign; // negative or positive numb
int esign; // exponent sign
int power; // Converting the power
int expval; // exponent value

// Version 5 arrays and counters

int intergerValue[NINT]; // Stored ints for results
double doubleValue[NDBLE]; // doubles for results
int wordFreq[WMAX]; // number of words

int numbCount = 0; // Counter for the ints
int dbleCount = 0; // counter for the dbls


int len; // string length
int wlen; // word lenght
int k; // counter
char ch; // character
char line[LMAX]; // current line
CharType chtype; 
StateType state;
 
int main()
{
    //array of text lines i.e. the input data
    char tline[NLINES][LMAX] = {
    "  first 123 and now second -.1234 and you're needing this 123.456 plus one of these +123. too",
    "  ellen's favourites are 123.654E-2 eg exponent-form which can also be -54321E-03 or this +432e2",
    " I'll prefer numbers like fmt1-dec +.1234567e+05 or fmt2-dec -765.3245 or fmt1-int -837465 or ",
    " even fmt2-int -19283746 which make us think of each state's behaviour for +3 or even .3471e7 states ",
        };                     
   
/****************************************************************************
                      PRINT OUT THE RAW TEXT LINES            
****************************************************************************/
        cout << "TEXT DATA LINES:" << endl << endl;
        cout << endl;
        state  = white; // Initial state is white
        chtype = whsp; // Initial chartype is white
        for(int j=0; j<myLINES; j++)                    //display name strings & matching weights
        {   strcpy_s(line, tline[j]); // Getting the current line
            len = strlen(tline[j]); // Getting the length
            cout <<  line  << endl;                         // first via 1 command
		    ch=line[k]; // Getting the current char
            for (k=0; k < len;)                // secondly, in a char-by-char loop
            {	switch (state) // State manager, calls the correct states
                {   case white:
                        WhiteState(); //To White State
                    case word:
                        WordState(); // To Word State
                    case num:
                        NumState(); // To Number State
                    case dble:
                        DbleState(); // Double State
                    case expo:
                        ExpntState();  // To Exponent State
                }
            }   
			system("pause");
		    printf("\n");
			//Line is done, prep for new line by resetting the two type variables
		    state = white;
		    chtype = whsp;
        }
		cout << endl << endl;
		PrintResults(); // Print the results
        system("PAUSE");
    return 0;
}
 
void WhiteState()
{
    while (state == white) // Continue as long as whit
    {   k++; // incement counter

        ch = line[k]; // grab next char
        if (isspace(ch)) // check if white
            chtype = whsp; // change to white
        else if (isalpha(ch)) // check if letter
        {   chtype = lett; // change
			//printf("%c", ch);
            WhiteToWord(); // state transition
        }
        else if (isdigit(ch)) // check if number
        {   chtype = digit; // change
			//printf("%c", ch);
            WhiteToNum(); // state transition
        }
		else if (ch == '\0') // end of line
			break;
        else
        {   switch (ch)
            {   case '+': // check if sign			    
                    chtype = plus; //change
					//printf("%c", ch);
                    WhiteToNum(); // state transition
                    break;
                case '-': // check if sign
                    chtype = minus; // change
					//printf("%c", ch);
                    WhiteToNum(); // stat transition
                    break;
                case '.': // check if decimal
                    chtype = point; // change
					//printf("%c", ch);
                    WhiteToDble(); // state transition
                    break;
                case '\'': // check if apostrophe
                    chtype = apos; // change
					//printf("%c", ch);
                    WhiteToWord(); // state transition
                    break;
            }
        }
    }
}
 
void NumState()
{
    while (state == num )
    {   k++; // Increment k
        ch = line[k]; // get next char
		ch = toupper(ch); // make ch uppercase
		if (ch != 'E' && ch != '.' && ch !=' ') // calculate?
			ival = ival * 10 + ch - '0'; // conversion

		if (isdigit(ch)) // check if digit
			chtype = digit; // change
		else   if (isspace(ch)) // check if space
		{   chtype = whsp; // change
			NumToWhite(); // state transition
		}      
        else if (ch == '.') // check if point
        {   chtype = point; // change
            NumToDble();   //stage transition
        }
		else if (ch == 'e' || ch == 'E') // exponent?
		{   chtype = expnt; // change
			NumToExpnt(); // state transition
		}
		else if (ch == '\0') // end of string
			break;
		else
        {   switch (ch)
            {   case '+': // check sign
					chtype = plus; // change
					break;
				case '-':
					chtype = minus; // change
					break;
            }
        }
		
	}
	   
} 
void DbleState()
{
	while (state == dble) // check if still in state
    {   k++; // increment k
        ch = line[k]; // get character
		ch = toupper(ch); // make it uppercase
		if (ch != 'E' && ch != '.') // check whether it's good
		{
			power = power * 10; // calculation
            val = val * 10 + ch - '0'; // conversion
        //    printf("%c", ch);
		}
        if (isspace(ch)) // check if space
		{   chtype = whsp; // change 
			DbleToWhite(); // state transition
		}
        else if (ch == 'e' || ch == 'E') // check if exponent
		{  chtype = expnt; // change
		   NumToExpnt(); // state transition
		}
		else if (ch == '\0') // end of string 
			break;
    }
} 
void ExpntState()
{
    while (state == expo) // stay as long as expo state
    {   k++; // increment k
        ch = line[k]; // get current char
		//printf("%c", ch);
		if (isdigit(ch)) // check if digit
		{
			chtype = digit; // chage
			expval = expval * 10 + ch - '0'; // convert
		}
		else if (isspace(ch)) // check if space
		{   chtype = whsp; // change
			ExpntToWhite(); // state transition
		}  
		else if (ch == 'e' || ch == 'E') // check if exponent
		{   chtype = expnt; // change
			NumToExpnt(); // state transition
		}
		else if (ch == '\0') // end of line
		{
			ExpntToWhite();
			break;
		}
		else
        {   switch (ch) // check sign
            {   case '+': 
					chtype = plus; // change
					esign = 1; // esign change
					break;
				case '-':
					chtype = minus; // change
					esign = -1; // set
					break;
            }
        }		
    }
}
void WordState()
{  
	while (state == word)
     {  k++;
		wlen++;
        ch = line[k];
		//printf("%c", ch);
        if (isalpha(ch))
		{
            chtype = lett;
		}
        else if (ch == '\'')
            chtype = apos;
        else if (isspace(ch))
        {   chtype = whsp;
            WordToWhite();
        }
		else if (ch == '\0')
			break;
    }
}
 
void WhiteToNum()
{
	ival = 0; // set ival to 0
    if(ch == '+') // check sign
        sign = 1;
    else if(ch == '-')
        sign = -1;
    else
        sign = 1; // if no sign, it's positive
	//printf("\n%c\ST\%d\-\%d\n", ch, white, num);
    state = num; // change to num state
}
 
void WhiteToDble()
{
	power = 1; // Initializing power
    sign = 1; // initializing sign
    val = 0; // initializing val
	//printf("\n%c\ST\%d\-\%d\n", ch, white, dble);
    state = dble; //  state change
}
 
void WhiteToWord()
{
	wlen = 0; // initializing wlen
//	printf("\n%c\ST\%d\-\%d\n", ch, white, word);
    state = word; // change
	
}
 
void WordToWhite()
{
	//printf("ST%d", state);
    state = white;
    //printf("-%d Word length: %i\n", state, wlen);
	wordFreq[wlen-1]++;

}
 
void NumToWhite()
{
ival = ival * sign;

	//printf("\n%c\ST\%d\-\%d", ch, num, white);
    state = white; // change
	//printf("-%d Integer value: %i\n", state, ival);
	intergerValue[numbCount] = ival; // storing int val into array
	numbCount++; // increment

}
 
void DbleToWhite()
{
	val = val * sign / power; // calculation
   // printf("ST%d", state);
    state = white; // change
  //  printf("-%d Double value: %f\n", state, val);
	doubleValue[dbleCount] = val; // storing value
	dbleCount++; // increment
}
 
void ExpntToWhite()
{
	if(sign == 1) // check sign
        while(expval > 0)
        {   val *= 10; 
            expval--;
        }
    else
        while(expval > 0)
        {   val /= 10;
            expval--;
        }
    val = val * sign; // conversion
   // printf("ST%d", state);
    state = white; // change
  //  printf("-%d Double value: %f\n", state, val);
	doubleValue[dbleCount] = val; // storing 
	dbleCount++; // incrementing
}
 
void NumToDble()
{
	power = 1; // Initializing powe
    val = ival; // passing values
   // printf("ST%d", state);
    state = dble; // state change
    //printf("-%d\n", state);
}
 
void NumToExpnt()
{
	esign = 1; // Initializing esign
    expval = 0; // initializing exponent val
    val = ival; // passing val ival
   // printf("ST%d", state);
    state = expo; // state change
   // printf("-%d\n", state);
}
 
void DbleToExpnt()
{
	val = val * sign / power; // calculations
    esign = 1; // assigning esign a value
    expval = 0; // initializing
   // printf("ST%d", state);
    state = expo; // state change
   // printf("-%d\n", state);
}

/*
		PrintResults
	This simple function only outputs the values
	stores in our 3 arrays into a pretty and readable fashion


*/


void PrintResults()
{
	printf("Word results\n");
	printf("-----------------------------\n");
	printf("|WORD LENGTH       FREQUENCY|\n");
	printf("-----------------------------\n");	
	for(int count = 0; count < WMAX; count++)
	{
		if (wordFreq[count] != 0) // As long as the value isn't 0
		{
			printf("|%-2d%25d|\n", count+1, wordFreq[count]);
			printf("-----------------------------\n");
		}

	}

	printf("Integer results\n");
	printf("-----------------------------\n");
	printf("|INDEX                 VALUE|\n");
	printf("-----------------------------\n");	
	for(int count = 0; count < NINT; count++)
	{
		if (intergerValue[count] != 0)// As long as the value isn't 0
		{
			printf("|%-2d%25d|\n", count, intergerValue[count]);
			printf("-----------------------------\n");
		}

	}

	printf("Double results\n");
	printf("-----------------------------\n");
	printf("|INDEX                 VALUE|\n");
	printf("-----------------------------\n");	
	for(int count = 0; count < NDBLE; count++)
	{
		if (doubleValue[count] != 0)// As long as the value isn't 0
		{
			printf("|%-2d%g|\n", count, doubleValue[count]);
			printf("-----------------------------\n");
		}

	}

}