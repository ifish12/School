/********************************************ID BLOCK**********************************************
	Due Date:			December 6th, 2013
	Software Designer:	Geoffrey Shapiro
	Course:				420-306 Fall 2014
	Deliverable:		Assignment #4 Infix to Postfix conversion
	Description:		Infix is the normal way to do algebra and follows the rules of BEDMAS.
						Postfix writes operators after 2 operands eliminating the need for 
						brackets. This program converts an Infix expression to a Postfix
						expression and evaluates the same postfix expression given values
						of the operands.
******************************************PRELIMINARIES*******************************************/
#include <iostream>
#include <iomanip>             //for setw function to format output
#pragma warning(disable: 4996) 
using namespace std;		   //standard namespace

/****************************************GLOBAL VARIABLES*****************************************/
const int LMAX = 50;        //maximum number of infix strings in array
const int NMAX = 30;        //maximum size of each infix string
const int NUMOPNDS = 10;    //number of different operands i.e. A through J
char opnd[NUMOPNDS] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
float opndval[NUMOPNDS] = { 3, 1, 2, 5, 2, 4, -1, 3, 7, 187};

const int MAXSTACK = 100;
struct OPERATOR_STACK	//declare the operator-stack structure to be used in conversion
{	int top;
	char item[MAXSTACK];
};

struct OPERAND_STACK		//declare the operand-stack structure to be used in evaluation
{	int top;
	double item[MAXSTACK];
};

OPERATOR_STACK opstk; 	//declare a variable opstk of type OPERATOR_STACK
OPERAND_STACK opndstk;	//declare a variable opndstk of type OPERAND_STACK
bool und = true;		//identifies whether the operator stack is empty

//array of infix strings
char infix[LMAX][NMAX] = {"A+B-C",
						  "(A+B)*(C-D)", 
						  "A$B*C-D+E/F/(G+H)",
						  "((A+B)*C-(D-E))$(F+G)", 
					      "A-B/(C*D$E)"  };			
int IDX;	//Index to loop through each infix expression

/**************************************FUNCTION PROTOTYPES****************************************/
void   conversion(char[], char[]); //convert infix string to postfix string
double evaluate(char[]);		   //evaluate postfix string and return its value
void   pushOpndStk(double);	   	   //push operand onto the top of the stack
double popOpndStk();			   //pop operand from the top of the stack
void   OptrPush(char);			   //push operator onto the top of the stack
char   OptrPopAndTest();		   //pop operator from the top of the stack
bool   prcd(char, char);		   //true if an operator procedes another (BEDMAS)
int    priority(char);			   //returns priority level of operator (BEDMAS)

/*******************************************MAIN BLOCK********************************************/
int main() 
{   const int LSIZE = 5;        //actual number of infix strings in the array infix
	const int MAXSTACK = 100;   //maximum number of items allowed in the stack structures
			
	//arrays for the operands and their values
	int j;				//index to loop and output operands and their values
	char ifx[NMAX];		//work infix expression
	char pfx[NMAX];		//resulting postfix expression
	double val;			//value of a postfix expression

	cout << setw(40) << "OPERANDS AND THEIR VALUES:" << endl << endl;
	for( j=0; j<NUMOPNDS; j++)			//print operands and their matching values
 		cout << setw(5) << opnd[j];
	cout << endl << endl;
	for( j=0; j<NUMOPNDS; j++)
		cout << setw(5) << opndval[opnd[j] - 'A'];
	cout << endl << endl;

	cout << setw(23) << "Infix Expression" << setw(20) << "Postfix Expression" << setw(8) << "Value" << endl;
	for(IDX=0; IDX<LSIZE; IDX++)	  //loop through each infix expression
	{   strcpy(ifx, infix[IDX]);	  //copy infix expression to work infix expression
		conversion(ifx, pfx);		  //convert infix to postfix expression
		val = evaluate(pfx);		  //evaluate postfix expression
		cout << setw(23) << ifx << setw(20) << pfx << setw(8) << val << endl;
	}
	system("PAUSE");
	return 0;
}

/****************************EVALUATE********************************
	This function loops through each character in a postfix 
	expression and evaluates each operation. It pushes operands
	onto the stack and evaluates each time it reaches a 
********************************************************************/
double evaluate(char s[])
{   int i = 0;		//subscript for current character beng processed
	double op1;		//first operator
	double op2;		//second operator
	double val;		//value of resulting operation

	while(s[i] != '\0')						//until end of postfix expression
	{   if (isalpha(s[i]))					//is the next char a letter
			pushOpndStk(opndval[s[i]-'A']); //push operand value onto stack
		else
		{   op2 = popOpndStk();			//pop operand stack to get op2 then op1
			op1 = popOpndStk();			
			switch(s[i])				//performs math operation
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
			pushOpndStk(val);	//push value back onto stack
		}
		i++;					//get next char in expression
	}
	val = popOpndStk();			//pop last value off of the stack
	return val;					//return the value
}

/***************************OPERAND STACK HANDLERS************************
	These functions either add a double to the operand stack or remove
	a double to the operand stack. The top of the stack is adjusted
	accordingly.
*************************************************************************/
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

/***************************CONVERSION************************************
	This function loops through each character of an infix expression.
	It adds operands to a postfix expression and pushes operators onto 
	a stack if it procedes the current operator in question. The rest 
	of the operator stack is added on to complete a postfix expression.
*************************************************************************/
void conversion(char ifx[], char pfx[])
{   int i = 0;			//index to add characters to pfx[]
	int q = 0;			//current character being processed
	char topsym;		//the char at the top of the operator stack
	while (ifx[q] != '\0')	//until the end of the ifx[]
	{	char s = ifx[q];	//get next char of ifx[]
		if (!isalpha(s))	//if the character is an operator
		{	topsym = OptrPopAndTest();			//pop the top of the operator stack

			while (!und && prcd(topsym, s))		//if operator stack is not empty and operand topsym procedes operand s
			{	pfx[i++] = topsym;				//add topsym to the postfix string
				topsym = OptrPopAndTest();		//get the next operator from the operator stack
			}

			if (!und)						//if the stack is not empty
				OptrPush(topsym);			//return topsym to the top of the operator stack
			if (und || s != ')')			//if stack is empty or brackets do
				OptrPush(s);				//push operator s onto operator stack
			else
				topsym = OptrPopAndTest();	//remove top of the operator stack
		}
		else
			pfx[i++] = s;					//add operand to postfix string
		q++;
	}
	while (!und)							//until the operator stack is empty
		pfx[i++] = OptrPopAndTest();		//add operators from the top of the stack to the postfix expression
}

/*********************************PRECEDENCE******************************
	This function determines whether an operator should procede another 
	operator. The function returns true if the left operator has 
	precedence and returns false if it does not have precedence.
*************************************************************************/
bool prcd(char op1, char op2)
{	if (op1 == '(' || op2 == '(')		
		return false;
	else if (op2 == ')')			
		return true;
	else if (op1 == '$' && op2 == '$')  //$ does not procede $
		return false;
	else if (priority(op2) <= priority(op1)) 
		return true;		
	else        
		return false;
}

int priority(char a)
{   int p = 0;		//initialize priority level to 0
	switch (a)
	{   case '+':	//+ and - have a level 1 priority
		case '-':
			p = 1;
			break;
		case '*':	//* and / have a level 2 priority
		case '/':
			p = 2;
			break;
		case '$':	//$ has a level 3 priority
			p = 3;
			break;
	}
	return p;
}

/***************************OPERATOR STACK HANDLER************************
	These functions either add a character to the operator stack or 
	remove a character to the operator stack. The top of the stack is 
	adjusted accordingly. If the stack is empty then und becomes true
	otherwise it will stay false.
*************************************************************************/
void OptrPush(char b)		
{   opstk.item[opstk.top] = b;
	opstk.top += 1;
	und = false;			
}

char OptrPopAndTest()		
{   char i;
	if (opstk.top == 0)		
		und = true;		
	if (und)		
		return NULL;	
	else
	{	opstk.top--;			
		i = opstk.item[opstk.top];
		return i;			
	}	
}