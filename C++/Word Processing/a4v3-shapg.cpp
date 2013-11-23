// asst4v1.cpp    ALG306 
// parsing, text processing and numeric conversion
// this is an exercise in state-analysis and state-variable application design 
// data is supplied as an array of strings

#include <iostream>
#include <iomanip>              // for setw function to format output
#pragma warning(4996: disable ) // disable string library deprecation warnings
using namespace std;
 
enum StateType{white, word, num, dble, expo};
enum CharType{whsp, lett, expnt, digit, plus, minus, point, apos, endstr};
 
void WhiteState();
void NumState();
void DbleState();
void ExpntState();
void WordState();
 
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
 
const int LMAX    = 200;                // maximum number of chars per line
const int NLINES  = 10;         // maximum number of lines
const int myLINES = 4;      // ACTUAL number of text data lines
const int NDBLE   = 10;         // maximum number of doubles
const int NINT    = 10;         // maximum number of integers
const int WMAX    = 10;         // maximum number of characters in a word
 
int len;
int wlen;
int k;
char ch, line[LMAX];
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
   
        // ARRAYS FOR RESULTS
        // double mydbls [NDBLE];
        // int myints [NINT];
        // int mywords[WMAX];
   
/****************************************************************************
                      PRINT OUT THE RAW TEXT LINES            
****************************************************************************/
        cout << "TEXT DATA LINES:" << endl << endl;
        cout << endl;
        state  = white;
        chtype = whsp;
        for(int j=0; j<myLINES; j++)                    //display name strings & matching weights
        {   strcpy_s(line, tline[j]);
            len = strlen(tline[j]);
            cout <<  line  << endl;                         // first via 1 command
		    ch=line[k];
            for (k=0; k < len;)                // secondly, in a char-by-char loop
            {   switch (state)
                {   case white:
                        WhiteState();
                    case word:
                        WordState();
                    case num:
                        NumState();
                    case dble:
                        DbleState();
                    case expo:
                        ExpntState();  
                }
            }   
			system("pause");
		    printf("\n");
		    state = white;
		    chtype = whsp;
        }
		cout << endl << endl;
        system("PAUSE");
    return 0;
}
 
void WhiteState()
{
    while (state == white)
    {   k++;
        ch = line[k];
        if (isspace(ch))
            chtype = whsp;
        else if (isalpha(ch))
        {   chtype = lett;
            WhiteToWord();
        }
        else if (isdigit(ch))
        {   chtype = digit;
            WhiteToNum();
        }
		else if (ch == '\0')
			break;
        else
        {   switch (ch)
            {   case '+':			    
                    chtype = plus;
                    WhiteToNum();
                    break;
                case '-':
                    chtype = minus;
                    WhiteToNum();
                    break;
                case '.':
                    chtype = point;
                    WhiteToDble();
                    break;
                case '\'':
                    chtype = apos;
                    WhiteToWord();
                    break;
            }
        }
    }
}
 
void NumState()
{
    while (state == num )
    {   k++;
        ch = line[k];
		ch = toupper(ch);
		if (ch != 'E' && ch != '.')
			printf("%c", ch);
		if (isdigit(ch))
			chtype = digit;
		else   if (isspace(ch))
		{   chtype = whsp;
			NumToWhite();
		}      
        else if (ch == '.')
        {   chtype = point;
            NumToDble();   
        }
		else if (ch == 'e' || ch == 'E')
		{   chtype = expnt;
			NumToExpnt();
		}
		else if (ch == '\0')
			break;
		else
        {   switch (ch)
            {   case '+':
					chtype = plus;
					break;
				case '-':
					chtype = minus;
					break;
            }
        }
    }
}
 
void DbleState()
{
	while (state == dble)
    {   k++;
        ch = line[k];
		ch = toupper(ch);
		if (ch != 'E' && ch != '.')
			printf("%c", ch);
        if (isspace(ch))
		{   chtype = whsp;
			DbleToWhite();
		}
        else if (ch == 'e' || ch == 'E')
		{  chtype = expnt;
		   NumToExpnt();
		}
		else if (ch == '\0')
			break;
    }
}
 
void ExpntState()
{
    while (state == expo)
    {   k++;
        ch = line[k];
		printf("%c", ch);
		if (isdigit(ch))
			chtype = digit;
		else if (isspace(ch))
		{   chtype = whsp;
			ExpntToWhite();
		}  
		else if (ch == 'e' || ch == 'E')
		{   chtype = expnt;
			NumToExpnt();
		}
		else if (ch == '\0')
			break;
		else
        {   switch (ch)
            {   case '+':
					chtype = plus;
					break;
				case '-':
					chtype = minus;
					break;
            }
        }		
    }
}
void WordState()
{  
	while (state == word)
     {  k++;
        ch = line[k];
		printf("%c", ch);
        if (isalpha(ch))
            chtype = lett;
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
	printf("\n%c\ST\%d\-\%d\n", ch, white, num);
    state = num;
}
 
void WhiteToDble()
{
	printf("\n%c\ST\%d\-\%d\n", ch, white, dble);
    state = dble;
}
 
void WhiteToWord()
{
	printf("\n%c\ST\%d\-\%d\n", ch, white, word);
    state = word;
}
 
void WordToWhite()
{
	printf("\n%c\ST\%d\-\%d", ch, word, white);
    state = white;
}
 
void NumToWhite()
{
	printf("\n%c\ST\%d\-\%d", ch, num, white);
    state = white;
}
 
void DbleToWhite()
{
	printf("\n%c\ST\%d\-\%d", ch, dble, white);
    state = white;
}
 
void ExpntToWhite()
{
	printf("\n%c\ST\%d\-\%d", ch, expo, white);
    state = white;
}
 
void NumToDble()
{
	printf("\n%c\ST\%d\-\%d\n", ch, num, dble);
    state = dble;
}
 
void NumToExpnt()
{
	printf("\n%c\ST\%d\-\%d\n", ch, num, expo);
    state = expo;
}
 
void DbleToExpnt()
{
	printf("\n%c\ST\%d\-\%d\n", ch, dble, expo);
    state = expo;
}