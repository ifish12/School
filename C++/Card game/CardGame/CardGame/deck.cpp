#include <iostream>
#include "deck.h"
#include "card.h"
#include <time.h>
#include <stdlib.h>
#include <cstdlib>


using namespace std;

// Build a proper deck
  Deck::Deck()
  {
	  currentCard = 0;
	  for (int count = 0; count < 4; count++) // For reference: for (Suit thesuit = Hearts; thesuit <= Spades; thesuit = (Suit)(thesuit +1))
		  {
			  for (int FaceVal = 0; FaceVal < 13; FaceVal++)
			  {
				  
				  theDeck[currentCard].SetFaceValue(FaceValue(FaceVal));
				  theDeck[currentCard].SetSuit(Suit(count));
				  currentCard ++;
	  
			  }
		  }
	  currentCard = 0;
  }

  

  // Must use time as the random generator seed.
  // Shuffle resets the deck to full
  void Deck::Shuffle()
  {  
	
	  srand( time(NULL) );
	for (currentCard = 0; currentCard <52; currentCard++)
	{
		int randomNum = rand() % 52;
		swap (theDeck[currentCard], theDeck[randomNum]);
	}
	currentCard = 0;
	
  }
  
  // Is the deck empty?
  bool Deck::EmptyDeck()
  {
	  bool empty = false;

	  if (currentCard == 52)
	  {
		  empty = true;
		  return empty;
	  }
	  return empty;
		  
  }
  
  // Pre-condition: The deck is not empty.
   Card Deck::DealACard()
  {
	  if (currentCard !=52)
		  return theDeck[currentCard++];

  }

 // Print the cards remaining in the Deck.
  void Deck::Print()
  {
	  int remain = 0;
	  remain = 52 - currentCard;

	  cout << "There are " << remain << "card(s) reamining in the deck" << endl;
  }