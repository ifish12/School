// asst5v1.cpp       ALGORITHM DESIGN 306  
// arrays of infix strings, postfix strings, operands and operand-values
#include <iostream>
#include <iomanip>             //for setw function to format output
#include <cmath>
#pragma warning(disable:4996)
using namespace std;		   //standard namespace



//Global Variables
const int LMAX = 50;        //maximum number of infix strings in array
const int NMAX = 30;        //maximum size of each infix string
const int LSIZE = 5;        //actual number of infix strings in the array infix
const int NUMOPNDS = 10;    //number of different operands i.e. A through J
const int MAXSTACK = 100;   //maximum number of items allowed in the stack structures



struct OPERAND_STACK
{
	int top;
	double item[MAXSTACK];

	OPERAND_STACK()
	{
		top = 0;
	}


};

struct OPERATOR_STACK
{
	int top;
	char item[MAXSTACK];

	OPERATOR_STACK()
	{
		top = 0;
	}
	
};

char infix[LMAX][NMAX] = { "A+B-C",
							"(A+B)*(C-D)", 
	                         "A$B*C-D+E/F/(G+H)",
							 "((A+B)*C-(D-E))$(F+G)", 
					    	 "A-B/(C*D$E)"  };			
 
char postfix[LMAX][NMAX] = { "AB+C-",
							"AB+CD-*", 
	                         "AB$C*D-EF/GH+/+",
							 "AB+C*DE--FG+$", 
					    	 "ABCDE$*/-"  };	

char ifx[NMAX];
char pfx[NMAX];

int IDX;
double val;

bool und = true;


OPERAND_STACK opndstk;
OPERATOR_STACK opstk;

  //arrays for the operands and their values
   char opnd[NUMOPNDS] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
   float opndval[NUMOPNDS] = { 3, 1, 2, 5, 2, 4, -1, 3, 7, 187};

// Function Prototypes
void Convert(char[], char[]);
double evaluate(char[]);

double pop(OPERAND_STACK&);
char pop(OPERATOR_STACK&);

void push(OPERAND_STACK&, char);
void push(OPERATOR_STACK&, int);

void dumpstack(OPERAND_STACK);
void dumpstack(OPERATOR_STACK);

double search(char);
double evalPostfix(char[]);

char optrPopandTest(OPERATOR_STACK&);



int main() {
   	
 
   int j;
   int counter = 0;
/*************************************************************************
                      PRINT OUT THE INFIX EXPRESSIONS            
**************************************************************************/

   cout << "         INFIX EXPRESSION                POSTFIX RESULT                   VALUES" << endl << endl;
   cout << endl << endl;

   for (IDX = 0; IDX < LSIZE-1; IDX++)
   {   strcpy(ifx, infix[IDX]);
	   Convert(ifx,pfx);
	   val = evaluate(pfx);
	   cout << setw(25) << infix[IDX] << setw(30) << postfix[IDX] << setw(25) << val << endl;
   }
   cout << endl << endl << endl << endl;

/*************************************************************************
                   PRINT OUT THE OPERANDS AND THEIR VALUES            
**************************************************************************/
   cout << setw(40) << "OPERANDS AND THEIR VALUES:" << endl << endl;
   for( j=0; j<NUMOPNDS; j++)
 	   cout << setw(5) << opnd[j];
   cout << endl << endl;
   for( j=0; j<NUMOPNDS; j++)
	   cout << setw(5) << opndval[opnd[j] - 'A']; //is not SIMPLER to just use j ONLY as the subscript?
	//Q:  why the more complex syntax?   A:  j ONLY assumes that operands are in lexical order
   cout << endl << endl;

   cout << "CONVERSION STACK" << endl;
   cout << "Testing push: " << endl;
   for(int i = 0; i < 5; i++)
   {
		if (opstk.top == 0)
			cout << "| Stack is empty |" << endl;
		push(opstk,opnd[i]);
		dumpstack(opstk);
   }
   cout << "Testing pop: " << endl;
   while(und)
   {
	   dumpstack(opstk);
	   optrPopandTest(opstk);
   }
   if (und == false)
			cout << "| Stack is empty |" << endl;

   system("PAUSE");


   
   //cout << evalPostfix(postfix[0]) << endl;
   //system("pause");

   return 0;
   }
/****************************************************************************
                 CONVERSION FUNCTION: INFIX TO POSTFIX NOTATION
****************************************************************************/
void Convert(char s[], char t[]) {	
	strcpy(t, postfix[IDX]);
}

double evaluate(char t[]) {
	return 187;
}

double pop(OPERAND_STACK& stack)
{
	return stack.item[stack.top--];

}

char pop(OPERATOR_STACK& stack)
{
	return stack.item[stack.top--];
}

char optrPopandTest(OPERATOR_STACK& stack)
{
	if (stack.top == 0)
		und = false;
	else
		return stack.item[stack.top--];
}

void push(OPERAND_STACK& stack, char stuff)
{
	stack.item[stack.top++] = stuff;
}

void push(OPERATOR_STACK& stack, int stuff)
{
	stack.item[stack.top++] = stuff;
}

void dumpstack(OPERAND_STACK stack)
{
	int j = 0;
	//cout << "Top is: " << stack.top << endl;
		for (int i = 0; i < stack.top; i++)
			cout << "| " << stack.item[i] << " |";
		if (j < stack.top)
		{
			cout << "|";
			cout << endl;
		}
}

void dumpstack(OPERATOR_STACK stack)
{
	int j = 0;
	//cout << "Top is: " << stack.top << endl;
	for (int i = 0; i < stack.top; i++)
		cout << "| " << stack.item[i] << " ";
	if (j < stack.top)
	{
		cout << "|";
		cout << endl;
	}
	
}

double search(char q)
{
	for (int i = 0; i < NUMOPNDS; i++)
	{
		if (q == opnd[i])
			return opndval[i];
	}
}
double evalPostfix(char pstfx[])
{
	char s;
	double op1;
	double op2;

	double  val;

	for (int i = 0;  i < strlen(pstfx); i++)
	{
		s = pstfx[i];

		if (isalpha(s))
		{
			push(opndstk, search(s));
		
		}
		else
		{
			op2 = pop(opndstk);
			op1 = pop(opndstk);
			switch (s)
			{
				case '+':
					val = op1 + op2;
					break;
				case '-':
					val = op1 - op2;
					break;
				case '*':
					val = op1 - op2;
					break;
				case '/':
					val = op1 / op2;
					break;
				case '$':
					val = pow(op1,op2);
					break;
			}
			push(opndstk,val);

		}
	
	}
	val = pop(opndstk);
	return val;
}

/****************************************************************************
               FUNCTION TO DISPLAY INFIX AND POSTFIX EXPRESSIONS            
****************************************************************************/
/****************************************************************************
                 FUNCTION TO EVALUATE THE POSTFIX EXPRESSION           
****************************************************************************/
