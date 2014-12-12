/**************************** ID BLOCK *******************************

Due Date:          November 18, 2013
Software Designer: Geoffrey Shapiro
Course:            420-306-AB Fall 2013
Deliverable:       Assignment #4 --- State Parsing
Description:       This program will input lines of strings and convert them into
words, integers and double values. The program uses different "states" to process
strings one character at a time based on character type. The states are entered or
left using transition functions. Once in a state, the data is saved into variables
and on exiting the states the variables are saved to arrays that are later printed.
*/

/************************ PRELIMINARIES ************************/
#include <iostream>
#include <iomanip>              // for setw function to format output
#pragma warning(disable: 4996 ) // disable string library deprecation warnings 

//enums for the states and chartypes. (also int values)
enum StateType { white, word, num, dble, expnt };
enum CharType { whsp, lett, expo, digit, plus, minus, point, quote, endstr };

/********************* GLOBAL VARIABLES **********************/
CharType chtype;
StateType state;

const int LMAX = 200;		// maximum number of chars per line 
const int NLINES = 10;		// maximum number of lines
const int myLINES = 4;      // ACTUAL number of text data lines
const int NDBLE = 10;		// maximum number of doubles
const int NINT = 10;		// maximum number of integers
const int WMAX = 15;		// maximum number of characters in a word

int len;           //string length of current line
char ch;           //current char
char line[LMAX];   //line string
int wlen;          //word length
int k = 0;         //current charater index for line string
int ival;          //integer value used in number state
double val;        //double value used in double and expo states
double expval;     //value of exponent used in expo state
int power;         //used to count places after the decimal
int sign;          //positive or negative holder
int esign;         //positive or negative holder for exponent value

int wordi = 0;     //words array index
int inti = 0;      //ints array index
int dblei = 0;     //dbles array index

int mywords[WMAX] = { 0 };  // word length array
int myints[NINT];         //  integer array
double mydbles[NDBLE];    // double array

/********************* FUNCTION PROTOTYPES **********************/
void CharTypeHandler(void);
void whitespace(void);
void exponent(void);
void number(void);
void doublestate(void);
void wordstate(void);
void whitetonum(void);
void whitetodble(void);
void whitetoword(void);
void wordtowhite(void);
void expotowhite(void);
void dbletowhite(void);
void numtowhite(void);
void dbletoexpo(void);
void numtodble(void);
void numtoexpo(void);

int main()
{
	//array of text lines i.e. the input data
	   char tline[NLINES][LMAX] = {
		" first 123		and then -.1234 but you'll need 123.456		 and 7e-4 plus one like +321. all quite avant-",
		"garde   whereas ellen's true favourites are 123.654E-2	exponent-form which can also be -54321E-03 or this -.9E+5",
		"We'll prefer items like			fmt1-decimal		+.1234567e+05 or fmt2-dec -765.3245 or fmt1-int -837465 and vice-",
		"versa or even format2-integers -19283746   making one think of each state's behaviour for 9 or even 3471e-7 states ",
	};

	state = white;
	/****************************************************************************
						  PRINT OUT THE RAW TEXT LINES
	****************************************************************************/
	std::cout << "TEXT DATA LINES:" << std::endl << std::endl;
	std::cout << std::endl;
	for (int j = 0; j < myLINES; j++)				//display name strings & matching weights
	{	strcpy(line, tline[j]);
		len = strlen(tline[j]);
		std::cout << std::endl << line << std::endl;// first via 1 command 
		k = 0;
		ch = line[k];       //get char
		CharTypeHandler();  //get char type

		if (state != word)
			state = white;
		while (k <= len)      //run state functions based on current state until end of line
		{	switch (state)
			{	case white:
					whitespace(); break;
				case num:
					number(); break;
				case word:
					wordstate(); break;
				case dble:
					doublestate(); break;
				case expnt:
					exponent(); break;
			}
		}
		std::cout << std::endl;
	}
	//WORD RESULTS
	printf("ANALYSIS RESULTS\n-------------------------\n\n");
	printf("WORD RESULTS\n-------------------------\n");
	printf("WORD LENGTH     FREQUENCY\n");
	for (int i = 0; i < WMAX; i++)
		printf("%-2d%*d\n", i + 1, 23, mywords[i]);
	printf("-------------------------\n\n");
	//INT RESULTS
	printf("INTEGER RESULTS\n-------------------------\n");
	printf("INDEX               VALUE\n");
	for (int i = 0; i < inti; i++)
		printf("%-2d%*d\n", i, 23, myints[i]);
	printf("-------------------------\n\n");
	//DOUBLE RESULTS
	printf("DOUBLE RESULTS\n-------------------------\n");
	printf("INDEX               VALUE\n");
	for (int i = 0; i < dblei; i++)
		printf("%-2d%*.7g\n", i, 23, mydbles[i]);
	printf("-------------------------\n\n\n");

	system("pause");
	return 0;
}

//Char Type Handler
void CharTypeHandler(void) //sets the char type variable
{
	if (isspace(ch))
		chtype = whsp;
	if (isalpha(ch))
		chtype = lett;
	if (isdigit(ch))
		chtype = digit;
	if (toupper(ch) == 'E')
		chtype = expo;
	if (ch == '+')
		chtype = plus;
	if (ch == '-')
		chtype = minus;
	if (ch == '.')
		chtype = point;
	if (ch == '\'')
		chtype = quote;
	if (k == len)
		chtype = endstr;
}

//State Handlers
void whitespace(void)
{
	while (state == white && k <= len)
	{	switch (chtype) //choose transition based on chartype
		{	case expo:
			case lett:
				whitetoword(); break;
			case digit:
			case plus:
			case minus:
				whitetonum(); break;
			case point:
				whitetodble(); break;
			case endstr:
			default:
				ch = line[++k];     //next char in line
				CharTypeHandler();  //get char type
		}
	}
}

void exponent(void)
{
	while (state == expnt && k <= len)
	{	switch (chtype) //pick transition based on chartype
		{	case whsp:
			case endstr:
				expotowhite(); break;
			case expo:
				ch = line[++k];
				CharTypeHandler();
				break;
			case plus:
			case minus:
				if (chtype == minus)
					esign = -1;
				ch = line[++k];
				CharTypeHandler();
				break;
			default:
				expval = expval * 10 + ch - '0'; // ascii digit to expval
				ch = line[++k];    //next char in line
				CharTypeHandler(); //get char type
		}
	}
}

void number(void)
{
	while (state == num && k <= len)
	{	switch (chtype) //pick transition based on chartype
		{	case whsp:
			case endstr:
				numtowhite(); break;
			case expo:
				numtoexpo(); break;
			case point:
				numtodble(); break;
			case plus:
			case minus:
				ch = line[++k];
				CharTypeHandler();
				break;
			default:
				ival = ival * 10 + ch - '0'; //next ascii digit to ival
				ch = line[++k];    //next char in line
				CharTypeHandler();	//get char type 
		}
	}
}

void doublestate(void)
{
	while (state == dble && k <= len)
	{	switch (chtype) //choose transition based on chartype
		{	case whsp:
			case endstr:
				dbletowhite(); break;
			case expo:
				dbletoexpo(); break;
			case point:
				ch = line[++k];
				CharTypeHandler();
				break;
			default:
				val = val * 10 + ch - '0'; //next ascii digit to val
				power *= 10;        //increase power to next decimal place
				ch = line[++k];     // next char in line
				CharTypeHandler();  //get char type
		}
	}
}

void wordstate(void)
{
	while (state == word && k <= len)
	{	switch (chtype) //choose transition based on chartype
		{	case whsp:
				wordtowhite(); break;
			case endstr:
				ch = line[++k];
				CharTypeHandler(); break;
			default:
				ch = line[++k];   // next char in line
				CharTypeHandler(); //get char type
				wlen++;            //increase word length of current word
		}
	}
}

//White Transitions
void whitetonum(void)
{
	state = num;  //set state
	ival = 0;     //initilize ival
	sign = (chtype == minus) ? -1 : 1;	//check and set sign, default positive if no sign
}

void whitetodble(void)
{
	state = dble; //set state
	val = 0;      //initilize val
	power = 1;    //initilize power
	sign = 1;     //set default sign
}

void whitetoword(void)
{
	state = word; //set state
	wlen = 0;     //initilize word length
}

//Word Transitions
void wordtowhite(void)
{
	mywords[wlen - 1]++; //increase count of current word length
	state = white;     //set state
}

// Exponent Transitions
void expotowhite(void)
{
	state = white;         //set state
	val = val*sign / power;  //calculate val
	while (expval > 0)
	{   if (esign == 1)
			val = val * 10;
		else
			val = val / 10;
		expval--;
	}
	mydbles[dblei] = val; //add val to next double array value
	dblei++;
}

//Double Transitions
void dbletowhite(void)
{
	state = white;         //set state
	val = val*sign / power;  //calculate val
	mydbles[dblei] = val;   //add val to the double array
	dblei++;
}

void dbletoexpo(void)
{
	state = expnt;  //set state
	esign = 1;      //initilize exponent sign
	expval = 0;     //initilize exponent value
}

// Number Transitions
void numtowhite(void)
{
	ival = ival*sign;    //calculate ival
	myints[inti] = ival; //add ival to the int array
	inti++;
	state = white;  //set state
}

void numtodble(void)
{   
	state = dble;   //set state
	val = ival*1.0; //calculate ival
	power = 1;      //initilize power
}

void numtoexpo(void)
{
	state = expnt;  //set state
	esign = 1;      //initilize exponent sign
	expval = 0;     //initilize exponent value
	val = ival*1.0; //set val to ival
	power = 1;      //initilize power
}