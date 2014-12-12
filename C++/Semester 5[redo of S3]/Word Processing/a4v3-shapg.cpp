// asst4v1.cpp    ALG306 
// parsing, text processing and numeric conversion
// this is an exercise in state-analysis and state-variable application design 
// data is supplied as an array of strings

#include <iostream>
#include <iomanip>              // for setw function to format output
#pragma warning(disable: 4996 ) // disable string library deprecation warnings 


enum StateType {white, word, num, dble, expnt};
enum CharType {whsp, lett, expo, digit, plus, minus, point, quote, endstr};

CharType chtype;
StateType state;

const int LMAX = 200;		// maximum number of chars per line 
const int NLINES = 10;		// maximum number of lines
const int myLINES = 4;      // ACTUAL number of text data lines
const int NDBLE = 10;		// maximum number of doubles
const int NINT = 10;		// maximum number of integers
const int WMAX = 10;		// maximum number of characters in a word

   		
   
	int len;
	char ch, line[LMAX];
	int wlen;
	int k = 0;

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
   std::cout << "TEXT DATA LINES:" << std::endl << std::endl;	
	std::cout << std ::endl;
	for(int j=0; j<myLINES; j++)				//display name strings & matching weights
	{	strcpy( line, tline[j]);
		len=strlen(tline[j]);
		std::cout << std::endl << std::endl << line << std::endl;			// first via 1 command 
	   
		k = 0;	        
		ch = line[k];
		CharTypeHandler();
		state = white;
		while(k < len)
		{	switch (state)
			{case white:
				whitespace();break;

			 case num:
				number();break;

			 case word:
				wordstate();break;

			 case dble:
				 doublestate();break;

			 case expnt:
				 exponent();break;
			}
		}
	std::cout << std::endl;
	system("PAUSE");
	std::cout << std::endl;
	}
	
   return 0;
   }

//Char Type Handler
void CharTypeHandler(void)
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
	while(state == white && k < len)
	{switch (chtype)
	 {
	 case expo:
	 case lett:
		 whitetoword(); break;
	 case digit:
	 case plus:
	 case minus:
		 whitetonum(); break;
	 case point:
		 whitetodble(); break;
	 default:
		 printf("%c", ch);
	 }
	 ch = line[++k];
	 CharTypeHandler();
	}
}

void exponent(void)
{
	while(state == expnt && k < len)
	{switch (chtype)
	 {
	 case whsp:
		 expotowhite();break;
	 default:
		 printf("%c", ch);
	 }
	 ch = line[++k];
	 CharTypeHandler();
	}
}

void number(void)
{
	while(state == num && k < len)
	{switch (chtype)
	 {
	 case whsp:
		 numtowhite();break;
	 case expo:
		 numtoexpo(); break;
	 case point:
		 numtodble(); break;
	 default:
		 printf("%c", ch);
	 }
	 ch = line[++k];
	 CharTypeHandler();
	}
}

void doublestate(void)
{
	while(state == dble && k < len)
	{switch (chtype)
	 {
	 case whsp:
		 dbletowhite(); break;
	 case expo:
		 dbletoexpo(); break;
	 default:
		 printf("%c", ch);
	 }
	 ch = line[++k];
	 CharTypeHandler();
	}
}

void wordstate(void)
{
	while(state == word && k < len)
	{switch (chtype)
	 {
	case whsp:
		 wordtowhite(); break;
	 default:
		 printf("%c", ch);
	 }
	 ch = line[++k];
	 CharTypeHandler();
	}
}

//White Transitions
void whitetonum(void)
{
	printf("\n%cST%d-%d\n", ch, white, num);
	state = num;
}

void whitetodble(void)
{
	printf("\n%cST%d-%d", ch, white, dble);
	state = dble;
}

void whitetoword(void)
{
	printf("\n%cST%d-%d\n", ch, white, word);
	state = word;
}

//Word Transitions
void wordtowhite(void)
{
	printf("\n%cST%d-%d", ch, word, white);
	state = white;
}

// Exponent Transitions
void expotowhite(void)
{
	printf("\n%cST%d-%d", ch, expnt, white);
	state = white;
}

//Double Transitions
void dbletowhite(void)
{
	printf("\n%cST%d-%d", ch, dble, white);
	state = white;
}

void dbletoexpo(void)
{
	printf("\n%cST%d-%d\n", ch, dble, expnt);
	state = expnt;
}


// Number Transitions
void numtowhite(void)
{
	printf("\n%cST%d-%d", ch, num, white);
	state = white;
}

void numtodble(void)
{
	printf("\n%cST%d-%d\n", ch, num, dble);
	state = dble;
}

void numtoexpo(void)
{
	printf("\n%cST%d-%d\n", ch, num, expo);
	state = expnt;
}




