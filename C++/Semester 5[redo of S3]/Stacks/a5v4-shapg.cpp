// asst5v1.cpp       ALGORITHM DESIGN 306  
// arrays of infix strings, postfix strings, operands and operand-values
#include <iostream>
#include <iomanip>             //for setw function to format output
#pragma warning(disable:4996)
using namespace std;		   //standard namespace

//Global variables
const int LMAX = 50;        //maximum number of infix strings in array
const int NMAX = 30;        //maximum size of each infix string
const int NUMOPNDS = 10;    //number of different operands i.e. A through J
char opnd[NUMOPNDS] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
float opndval[NUMOPNDS] = { 3, 1, 2, 5, 2, 4, -1, 3, 7, 187};

const int MAXSTACK = 100;
struct OPERATOR_STACK	// declare the operator-stack structure to be used in conversion
{	int top;
	char item[MAXSTACK];
};

struct OPERAND_STACK		// declare the operand-stack structure to be used in evaluation
{	int top;
	double item[MAXSTACK];
};

OPERATOR_STACK opstk; 	// declare a variable opstk of type OPERATOR_STACK
OPERAND_STACK opndstk;	// declare a variable opndstk of type OPERAND_STACK

//array of infix strings
char infix[LMAX][NMAX] = {"A+B-C",
						  "(A+B)*(C-D)", 
						  "A$B*C-D+E/F/(G+H)",
						  "((A+B)*C-(D-E))$(F+G)", 
					      "A-B/(C*D$E)"  };			
//array of postfix strings
char postfix[LMAX][NMAX] = {"AB+C-",
							"AB+CD-*", 
							"AB$C*D-EF/GH+/+",
							"AB+C*DE--FG+$", 
					    	"ABCDE$*/-"  };
int IDX;
//Function Prototypes
void ifxToPfx(char[], char[]);
double evaluate(char[]);
void pushOpndStk(double);
double popOpndStk();
void dumpStack();

int main() 
{   const int LSIZE = 5;        //actual number of infix strings in the array infix
	
	const int MAXSTACK = 100;   //maximum number of items allowed in the stack structures
			
	//arrays for the operands and their values
	
	int j;
	char ifx[NMAX];
	char pfx[NMAX];
	double val;

	cout << setw(40) << "OPERANDS AND THEIR VALUES:" << endl << endl;
	for( j=0; j<NUMOPNDS; j++)
 		cout << setw(5) << opnd[j];

	cout << endl << endl;

	for( j=0; j<NUMOPNDS; j++)
		cout << setw(5) << opndval[opnd[j] - 'A']; //is not SIMPLER to just use j ONLY as the subscript?
	//Q:  why the more complex syntax?   A:  j ONLY assumes that operands are in lexical order

	cout << endl << endl << endl;

	for(IDX=0; IDX<LSIZE; IDX++)  //display name strings & corresponding weights
	{   strcpy(ifx, infix[IDX]);
		ifxToPfx(ifx, pfx);
		val = evaluate(pfx);
		cout << setw(25) << ifx << setw(20) << pfx << setw(8) << val << endl;
	}
	cout << endl << endl << endl;
	system("PAUSE");
	return 0;
}

void ifxToPfx(char ifx[], char pfx[])
{   strcpy(pfx, postfix[IDX]);

}

double evaluate(char s[])
{   int i = 0;
	double op1;
	double op2;
	double val;

	while(s[i] != '\0')
	{   if (isalpha(s[i]))
			pushOpndStk(opndval[s[i]-'A']);
		else
		{   op2 = popOpndStk();
			op1 = popOpndStk();
			switch(s[i])
			{   case '+':
					val = op1 + op2;
					break;
				case '-':
					val = op1 - op2;
					break;
				case '*':
					val = op1 * op2;
					break;
				case '/':
					val = op1 / op2;
					break;
				case '$':
					val = pow(op1, op2);
					break;
			}
			pushOpndStk(val);
		}
		i++;
	}
	val = popOpndStk();
	return val;
}

void pushOpndStk(double a)
{   opndstk.item[opndstk.top] = a;
	opndstk.top++;
}

double popOpndStk()
{   double i;
	opndstk.top--;
	i = opndstk.item[opndstk.top];
	
	return i;
}

void dumpStack()
{   cout << "Operand Stack: ";
	for (int a = 0; a < opndstk.top; a++)
			cout << opndstk.item[a] << ", ";
	cout << endl;
}