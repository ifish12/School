// asst5v1.cpp       ALGORITHM DESIGN 306  
// arrays of infix strings, postfix strings, operands and operand-values
#include <iostream>
#include <iomanip>             //for setw function to format output
#pragma warning(disable:4996)
using namespace std;		   //standard namespace



//Global Variables
const int LMAX = 50;        //maximum number of infix strings in array
const int NMAX = 30;        //maximum size of each infix string
const int LSIZE = 5;        //actual number of infix strings in the array infix
const int NUMOPNDS = 10;    //number of different operands i.e. A through J
const int MAXSTACK = 100;   //maximum number of items allowed in the stack structures

struct OPERATOR_STACK
{
	int top;
	char item[MAXSTACK];

	OPERATOR_STACK()
	{
		top = 0;
	}

	char pop()
	{
		return item[top--];
	}

	void push (char stuff)
	{
		item[top++] = stuff;
	}

	void dumpstack()
	{
		cout << "Top is: " << top << endl;
		for (int i = 0; i < top; i++)
			cout << item[i] << " | " ;
		cout << endl;
	}
	
};

struct OPERAND_STACK
{
	int top;
	double item[MAXSTACK];

	OPERAND_STACK()
	{
		top = 0;
	}

	int pop()
	{
		return item[top--];
	}

	void push (char stuff)
	{
		item[top++] = stuff;
	}

	void dumpstack()
	{
		cout << "Top is: " << top << endl;
		for (int i = 0; i < top; i++)
			cout << item[i] << " | " ;
		cout << endl;
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

OPERATOR_STACK opstk;
OPERAND_STACK opndstk;

// Function Prototypes
void Convert(char[], char[]);
double evaluate(char[]);




int main() {
   	
   //arrays for the operands and their values
   char opnd[NUMOPNDS] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
   float opndval[NUMOPNDS] = { 3, 1, 2, 5, 2, 4, -1, 3, 7, 187};
   int j;
   int counter = 0;
/*************************************************************************
                      PRINT OUT THE INFIX EXPRESSIONS            
**************************************************************************/
   cout << "TESTING PUSH OPERATOR STACK" << endl;
   while (counter < 4)
   {
	  opstk.push('d');
	  opstk.dumpstack();
	  counter++;

   }
      cout << "TESTING POP OPERATOR STACK" << endl;
   counter = 0;
   while(counter < 4)
   {
		opstk.pop();
		opstk.dumpstack();
		counter++;
   }

   cout << "TESTING PUSH FOR OPERAND STACK" << endl;
   counter = 0;
      while (counter < 4)
	 {
	  opndstk.push(69);
	  opndstk.dumpstack();
	  counter++;

	  }
   counter = 0;
    cout << "TESTING POP FOR OPERAND STACK" << endl;
   while(counter < 4)
   {
		opndstk.pop();
		opndstk.dumpstack();
		counter++;
   }



   cout << opstk.pop() << endl << endl;

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
   system("PAUSE");
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
/****************************************************************************
               FUNCTION TO DISPLAY INFIX AND POSTFIX EXPRESSIONS            
****************************************************************************/
/****************************************************************************
                 FUNCTION TO EVALUATE THE POSTFIX EXPRESSION           
****************************************************************************/
