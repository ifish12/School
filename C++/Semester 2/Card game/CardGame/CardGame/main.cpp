#include <iostream>
#include "deck.h"
#include "card.h"
#include <time.h>
#include <string>
//#include <stdlib.h>
//#include <cstdlib>
using namespace std;

void main()
{
	string Face[13] =  {"Two", "Three", "Four", "Five", 
		"Six", "Seven", "Eight", "Nine", 
		"Ten", "Jack", "Queen", "King", 
		"Ace"};
	string Suit[4] = {"Hearts", "Diamonds", "Clubs", "Spades"};

	Card P1;
	Card P2;
	char again;
	double Pone = 0;
	double Ptwo = 0;
	double pot = 0;
	int round = 0;
	Deck deck;
	

	deck.Shuffle();
	
	
	while(deck.EmptyDeck() == false)
	{
		round++;
		
		P1 = deck.DealACard();
		P2 = deck.DealACard();
		 pot = pot + 2;
		 cout << "Round " << round << endl;
		 cout << "Player 1 has " << Face[P1.GetFaceValue()] << " of " << Suit[P1.GetSuit()] << "\n";
		 cout << "Player 2 has " << Face[P2.GetFaceValue()] << " of " << Suit[P2.GetSuit()] << "\n";
		 if (P1 > P2)
		 {
			 Pone = Pone + pot;
			 pot = 0;
			 cout << "P1 wins." << "P1 now has " << Pone << " points" << endl;
		 }
		 else if (P2 > P1)
		 {
			 Ptwo = Ptwo + pot;
			 pot = 0;
			 cout << "P2 wins " << "P2 now has" << Ptwo << " points" << endl;
		 }
		 else
			 printf ("It was a tie! Player 1 has %.1f points. Player 2 has %.1f points.\n", Pone, Ptwo);
			 //cout << "Player 1 has " << int(Pone) << " points. Player 2 has " << Ptwo << " points";
		 
		 system("pause");
		 deck.Print();
		 cout << "Play again? (Y or N)";
		 cin >> again;
		 again = toupper(again);
		 if (again == 'N')
			 break;
	}

	if (pot != 0)
	{
		Pone = pot / 2;
		Ptwo = pot / 2;
		cout << "Your last game was a tie so I split the pot amoung the both of you" << endl;
	}
	if (Pone > Ptwo)
	{
		cout << "P1 won with "  << Pone << endl;
		cout << "P2 lost with " << Ptwo << endl;
	}
	else if (Pone < Ptwo)
	{
		cout << "P2 won with "  << Ptwo << endl;
		cout << "P1 lost with " << Pone << endl;
	}
	if (Pone == Ptwo)
		cout << "P2 and P1 both tied with a score of " << Pone << endl;
	system("pause");

	    


}

