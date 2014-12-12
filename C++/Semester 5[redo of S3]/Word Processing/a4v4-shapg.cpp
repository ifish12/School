#include <iostream>
#include <iomanip>              // for setw function to format output
#pragma warning(disable: 4996 ) // disable string library deprecation warnings 


enum StateType { white, word, num, dble, expnt };
enum CharType { whsp, lett, expo, digit, plus, minus, point, quote, endstr };

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
int ival;
double val;
double expval;
int power;
int sign;
int esign;

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
		"first 123		and then -.1234 but you'll need 123.456		 and -.7e6 plus one like +123. all quite avant-",
		"garde   whereas ellen's true favourites are 123.654E-2	exponent-form which can also be -54321E-03 or this +.9e-5",
		"We'll prefer items like			fmt1-decimal		+.1234567e+05 or fmt2-dec -765.3245 or fmt1-int -837465 and vice-",
		"versa or even format2-integers -19283746   making one think of each state's behaviour for 9 or even 3471e-7 states ",
	};
	state = white;
	// ARRAYS FOR RESULTS
	// double mydbls [NDBLE];
	// int myints [NINT];
	// int mywords[WMAX];

	/****************************************************************************
						  PRINT OUT THE RAW TEXT LINES
						  ****************************************************************************/
	std::cout << "TEXT DATA LINES:" << std::endl << std::endl;
	std::cout << std::endl;
	for (int j = 0; j < myLINES; j++)				//display name strings & matching weights
	{
		strcpy(line, tline[j]);
		len = strlen(tline[j]);
		std::cout << std::endl << std::endl << line << std::endl;;				// first via 1 command 

		k = 0;
		ch = line[k];
		CharTypeHandler();

		if (state != word)
			state = white;

		while (k <= len)
		{
			switch (state)
			{
			case white:
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
	//if (ch == '\0')
	//chtype = whsp;
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
	{
		switch (chtype)
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
			ch = line[++k];
			CharTypeHandler();
		}
	}
}

void exponent(void)
{

	while (state == expnt && k <= len)
	{
		switch (chtype)
		{
		case whsp:
			expotowhite(); break;
		case endstr:
			expotowhite(); break;
		case expo:
			printf("%c", ch);
			ch = line[++k];
			CharTypeHandler();
			break;
		case plus:
		case minus:
			printf("%c", ch);
			if (chtype == minus)
				esign = -1;
			ch = line[++k];
			CharTypeHandler();
			break;
		default:
			printf("%c", ch);
			expval = expval * 10 + ch - '0';
			ch = line[++k];
			CharTypeHandler();
		}
	}
}

void number(void)
{
	while (state == num && k <= len)
	{
		switch (chtype)
		{
		case whsp:
			numtowhite(); break;
		case expo:
			numtoexpo(); break;
		case point:
			numtodble(); break;
		case plus:
		case minus:
			printf("%c", ch);
			ch = line[++k];
			CharTypeHandler();
			break;

		default:
			printf("%c", ch);
			ival = ival * 10 + ch - '0';
			ch = line[++k];
			CharTypeHandler();
		}
	}
}

void doublestate(void)
{
	while (state == dble && k <= len)
	{
		switch (chtype)
		{
		case whsp:
			dbletowhite(); break;
		case expo:
			dbletoexpo(); break;
		case point:
			printf("%c", ch);
			ch = line[++k];
			CharTypeHandler();
			break;
		default:
			printf("%c", ch);
			val = val * 10 + ch - '0';
			power *= 10;
			ch = line[++k];
			CharTypeHandler();
		}
	}
}

void wordstate(void)
{
	while (state == word && k <= len)
	{
		switch (chtype)
		{
		case whsp:
			wordtowhite(); break;
		case endstr:
			printf("%c", ch);
			ch = line[++k];
			CharTypeHandler(); break;
		default:
			printf("%c", ch);
			ch = line[++k];
			CharTypeHandler();
			wlen++;
		}
	}
}

//White Transitions
void whitetonum(void)
{
	printf("ST%d-%d\n", white, num);
	state = num;
	ival = 0;
	sign = (chtype == minus) ? -1 : 1;
}

void whitetodble(void)
{
	printf("ST%d-%d\n", white, dble);
	state = dble;
	val = 0;
	power = 1;
	sign = 1;


}

void whitetoword(void)
{
	printf("ST%d-%d\n", white, word);
	state = word;
	wlen = 0;
}

//Word Transitions
void wordtowhite(void)
{
	printf("ST%d-%d Word Length: %d\n", word, white, wlen);
	state = white;
}

// Exponent Transitions
void expotowhite(void)
{
	state = white;
	val = val*sign / power;
	while (expval > 0)
	{
		if (esign == 1)
		{
			val = val * 10;
		}
		else
		{
			val = val / 10;
		}
		expval--;
	}
	printf("ST%d-%d Double Value: %0.7g\n", expnt, white, val);

}

//Double Transitions
void dbletowhite(void)
{
	state = white;
	val = val*sign / power;
	printf("ST%d-%d Double Value: %0.7g\n", dble, white, val);
}

void dbletoexpo(void)
{
	printf("ST%d-%d\n", dble, expnt);
	state = expnt;
	esign = 1;
	expval = 0;
}


// Number Transitions
void numtowhite(void)
{
	ival = ival*sign;
	printf("ST%d-%d Integer Value: %d\n", num, white, ival);
	state = white;
}

void numtodble(void)
{
	printf("ST%d-%d\n", num, dble);
	state = dble;
	val = ival*1.0;
	power = 1;
}

void numtoexpo(void)
{
	printf("ST%d-%d\n", num, expnt);
	state = expnt;
	esign = 1;
	expval = 0;
	val = ival*1.0;
	power = 1;
}