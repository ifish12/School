/* 
	Assignment 1
	September, 21st, 2012
	Geoffrey Shapiro

	Write a program that will read in a batch number and 3 results,
	validate the 3 results (valid results are whole numbers, 1 to 500),
	calculate the sum and the average of the 3 results and display the calculated sum and average along with the batch number and 3 results read in.
	The program should also display, at the end, the quantity of entered batches,
	the sum of all first results, the sum of all second results and the sum of all third results.
	Program should stop when 0 is entered for the batch number.

*/

#include <iostream>
using namespace std;

int main()
{
	int    batch;
	int    result1;
	int    result2;
	int    result3;
	int    sum;
	int    totalBatch;
	int    result1Sum;
	int    result2Sum;
	int    result3Sum;
	double average;
// All my variables above
	sum        = 0;
	totalBatch = 0;
	result1Sum = 0;
	result2Sum = 0;
	result3Sum = 0;
// Results have to be set to zero first
	cout << "Enter Batch number (Whole #, 0 to stop): ";
	cin  >> batch;

	while (batch != 0)
	{
		cout << "First result (whole #, 1 to 500): ";
		cin  >> result1;
		while (result1 < 1 || result1 > 500)
		{
			cout << "Invalid. Re-enter: ";
			cin  >> result1;
		}

		cout << "Second result (whole #, 1 to 500): ";
		cin  >> result2;
		while (result2 < 1 || result2 > 500)
		{
			cout << "Invalid. Re-enter: ";
			cin  >> result2;
		}

		cout << "Third result (whole #, 1 to 500): ";
		cin  >> result3;
		while (result3 < 1 || result3 > 500)
		{
			cout << "Invalid. Re-enter: ";
			cin  >> result3;
		}

		average = (result1 + result2 + result3) / 3.0;
		sum     = (result1 + result2 + result3);
		// The math involved in calculating the sum and averages
		system ("cls");

		cout << "Batch #:       " << batch   << endl << endl;
		cout << "First result:  " << result1 << endl;
		cout << "Second result: " << result2 << endl;
		cout << "Third result:  " << result3 << endl;
		cout << "Sum:           " << sum     << endl;
		cout << "Average:       " << average << endl;
		cout << endl << endl;

		totalBatch    = totalBatch + 1;
		result1Sum    = result1Sum + result1;
		result2Sum    = result2Sum + result2;
		result3Sum    = result3Sum + result3;
        // More sums ans totals
		cout << "Enter Batch number (Whole #, 0 to stop): ";
	    cin  >> batch;

	}

	system ("cls");

	cout << "Quantity of entered batches:   " << totalBatch    << endl << endl;
	cout << "Sum of all first  results:     " << result1Sum    << endl;
	cout << "Sum of all second results:     " << result2Sum    << endl;
	cout << "Sum of all third results:      " << result3Sum    << endl;
return 0;
} 
