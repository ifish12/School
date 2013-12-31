// asst5v1.cpp       ALGORITHM DESIGN 306  
// arrays of infix strings, postfix strings, operands and operand-values
#include <iostream>
#include <iomanip>             //for setw function to format output
using namespace std;		   //standard namespace
int main() {
   const int LMAX = 50;        //maximum number of infix strings in array
   const int NMAX = 30;        //maximum size of each infix string
   const int LSIZE = 5;        //actual number of infix strings in the array infix
   const int NUMOPNDS = 10;    //number of different operands i.e. A through J
   const int MAXSTACK = 100;   //maximum number of items allowed in the stack structures
   //array of infix strings
   char infix[LMAX][NMAX] = { "A+B-C",
							"(A+B)*(C-D)", 
	                         "A$B*C-D+E/F/(G+H)",
							 "((A+B)*C-(D-E))$(F+G)", 
					    	 "A-B/(C*D$E)"  };			
   //array of postfix strings
   char postfix[LMAX][NMAX] = { "AB+C-",
							"AB+CD-*", 
	                         "AB$C*D-EF/GH+/+",
							 "AB+C*DE--FG+$", 
					    	 "ABCDE$*/-"  };			
   //arrays for the operands and their values
   char opnd[NUMOPNDS] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
   float opndval[NUMOPNDS] = { 3, 1, 2, 5, 2, 4, -1, 3, 7, 187};
   int j;
/*************************************************************************
                      PRINT OUT THE INFIX EXPRESSIONS            
**************************************************************************/
   cout << "         INFIX EXPRESSION                POSTFIX RESULT" << endl << endl;
   cout << endl << endl;
   for( j=0; j<LSIZE; j++)  //display name strings & corresponding weights
      cout << setw(25) << infix[j] << setw(30) << postfix[j] << endl;

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
/****************************************************************************
               FUNCTION TO DISPLAY INFIX AND POSTFIX EXPRESSIONS            
****************************************************************************/
/****************************************************************************
                 FUNCTION TO EVALUATE THE POSTFIX EXPRESSION           
****************************************************************************/
