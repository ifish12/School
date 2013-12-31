#include <iostream>
#include "card.h"

using namespace std;


  // Default Constructor
  Card::Card()
  {
	   faceValue = Ace;
	   suit      = Spades;
  }
  // Regular Constructor
  Card::Card(FaceValue a, Suit b)
  {
	  faceValue = a;
	  suit = b;

  }

  //The following 3 operators are based on FaceValue
  bool Card::operator==(Card a)
  {
	  bool eq = false;
	  if (faceValue == a.faceValue)
		  eq = true;
	  return eq;
  }
  bool Card::operator>(Card a)
  {
	   bool eq = false;
	  if (faceValue > a.faceValue)
		  eq = true;
	  return eq;
  }
  bool Card::operator<(Card a)
  {
	   bool eq = false;
	  if (faceValue < a.faceValue)
		  eq = true;
	  return eq;
  }
  
  void Card::SetFaceValue(FaceValue c)
  {
	  faceValue = c;
  }
  void Card::SetSuit(Suit b)
  {
	  suit = b;
  }
  FaceValue Card::GetFaceValue()
  {
	  return faceValue;
  }
  Suit Card::GetSuit()
  {
	   return suit;
  }
  
  //Prints the card, example: Nine of Clubs
  void Card::Print()
  {
	 cout << faceValue << "of " << suit;
  }