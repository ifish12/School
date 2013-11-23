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
 
int ival;
double val;
int sign;
int esign;
int power;
int expval;

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
			printf("%c", ch);
            WhiteToWord();
        }
        else if (isdigit(ch))
        {   chtype = digit;
			printf("%c", ch);
            WhiteToNum();
        }
		else if (ch == '\0')
			break;
        else
        {   switch (ch)
            {   case '+':			    
                    chtype = plus;
					printf("%c", ch);
                    WhiteToNum();
                    break;
                case '-':
                    chtype = minus;
					printf("%c", ch);
                    WhiteToNum();
                    break;
                case '.':
                    chtype = point;
					printf("%c", ch);
                    WhiteToDble();
                    break;
                case '\'':
                    chtype = apos;
					printf("%c", ch);
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
		{
			printf("%c", ch);
			ival = ival * 10 + ch - '0';
		}

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
		{
			power = power * 10;
            val = val * 10 + ch - '0';
            printf("%c", ch);
		}

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
		{
			chtype = digit;
			expval = expval * 10 + ch - '0';
		}
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
					esign = 1;
					break;
				case '-':
					chtype = minus;
					esign = -1;
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
		printf("%c", ch);
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
	ival = 0;
    if(ch == '+')
        sign = 1;
    else if(ch == '-')
        sign = -1;
    else
        sign = 1;
	printf("\n%c\ST\%d\-\%d\n", ch, white, num);
    state = num;
}
 
void WhiteToDble()
{
	power = 1;
    sign = 1;
    val = 0;
	printf("\n%c\ST\%d\-\%d\n", ch, white, dble);
    state = dble;
}
 
void WhiteToWord()
{
	wlen = 0;
	printf("\n%c\ST\%d\-\%d\n", ch, white, word);
    state = word;
	
}
 
void WordToWhite()
{
	printf("ST%d", state);
    state = white;
    printf("-%d Word length: %i\n", state, wlen);
}
 
void NumToWhite()
{
ival = ival * sign;

	printf("\n%c\ST\%d\-\%d", ch, num, white);
    state = white;
	printf("-%d Integer value: %i\n", state, ival);
}
 
void DbleToWhite()
{
	val = val * sign / power;
    printf("ST%d", state);
    state = white;
    printf("-%d Double value: %f\n", state, val);
}
 
void ExpntToWhite()
{
	if(sign == 1)
        while(expval > 0)
        {
            val *= 10;
            expval--;
        }
    else
        while(expval > 0)
        {
            val /= 10;
            expval--;
        }
    val = val * sign;
    printf("ST%d", state);
        state = white;
        printf("-%d Double value: %f\n", state, val);
}
 
void NumToDble()
{
	  power = 1;
    val = ival;
    printf("ST%d", state);
    state = dble;
    printf("-%d\n", state);
}
 
void NumToExpnt()
{
	esign = 1;
    expval = 0;
    val = ival;
    printf("ST%d", state);
    state = expo;
    printf("-%d\n", state);
}
 
void DbleToExpnt()
{
	val = val * sign / power;
    esign = 1;
    expval = 0;
    printf("ST%d", state);
    state = expo;
    printf("-%d\n", state);
}