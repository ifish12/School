#include <iostream>
#include <string>
#include "deck.h"
#include "card.h"
using namespace std;

enum Rank {Nothing, Pair, TwoPair, ThreeOfAKindes, Straight, Flushes, FullHouse, FourOfAKindes, StraightFlush, RoyalFlush};

int GetBet     (int&);
void DealaHand (Card[], Deck&);
void PrintHand (Card[]);
void Discard   (Card[], Deck&);
void SortSuits (Card[], int[]);
void SortFVs   (Card[], int[]);
bool PairCheck (int[], FaceValue&);
bool TwoPairCheck (int[]);
bool ThreeOfAKind(int[]);
bool FourOfAKind(int[]);
bool StraightCheck(int[], FaceValue&);
bool Flush(int[]);

int calculateWinnings(Rank, int);

Rank Evaluate(Card[]);

void PrintRank(Rank);
 
void main()
{
        const int HAND_SIZE    = 5;
        int tokens             = 1000;
        int bet;
		int winnings = 0;
		Rank TheRank;

        Deck theDeck;
        Card hand[HAND_SIZE];

        do
        {
                bet = GetBet (tokens);
 
                if (bet == -1)
                {
                        break;
                }
               
                theDeck.Shuffle();
 
                DealaHand (hand, theDeck);
                PrintHand (hand);
 
                Discard (hand, theDeck);
				// Tests
				/*hand[0].SetFaceValue(Ten);
				hand[0].SetSuit(Clubs);

				hand[1].SetFaceValue(Ten);
				hand[1].SetSuit(Hearts);
				
				hand[2].SetFaceValue(Ten);
				hand[2].SetSuit(Diamonds);

				hand[3].SetFaceValue(Queen);
				hand[3].SetSuit(Diamonds);
				
				hand[4].SetFaceValue(Queen);
				hand[4].SetSuit(Clubs);*/
				

				TheRank = Evaluate(hand);

				winnings = calculateWinnings(TheRank,bet);

				tokens += winnings;

				cout << "You got a ";
 				PrintRank(TheRank);
				cout << endl;

				cout << "You've won: " << winnings << "\n";
				

	
                system ("pause");
                system ("cls");  
        }
        while (tokens > 0);
 
        system ("cls");
 
}
 
 
int GetBet (int& tokens)
{
        int bet;
 
        cout << "Your Tokens: " << tokens << endl;
 
                cout << "How much do you wish to bet? (-1 To Exit): ";
                cin  >> bet;
                while (bet > tokens || bet < 1 && bet != -1)
                {
 
                        if (bet > tokens)
                        {
                                cout << "Bet Is Too Large, Place New Bet: ";
                                cin  >> bet;
                        }
 
                        if (bet < 1 && bet != -1)
                        {
                                cout << "Bet Is Too Small, Place New Bet: ";
                                cin  >> bet;
                        }
                }
 
                if (bet != -1)
                {
                        tokens -= bet;
                }
 
                return bet;
}
 
void DealaHand (Card hand[5], Deck& theDeck)
{
        for (int count = 0; count < 5; count++)
        {
                hand[count] = theDeck.DealACard();
        }
 
        cout << endl;
}
 
void PrintHand (Card hand[5])
{
        int cardNum = 1;
 
        cout << "Your Hand Is: " << endl;
 
        for (int count = 0; count < 5; count++)
        {
                cout << "[" << cardNum << "] ";
                hand[count].Print();
                cout << endl;
 
                cardNum++;
        }
}
 
void Discard   (Card hand[5], Deck& theDeck)
{
        int discards;
        int cardNum;
        int cards = 1;
        int repeat[4]        = {100, 100, 100, 100};
 
        cout << "How Many Cards Do You Wish To Discard? (4 Max): ";
        cin  >> discards;
        while(discards > 4 || discards < 0)
        {
                if (discards > 4)
                {
                        cout << "Too Many Cards, Try Again: ";
                        cin  >> discards;
                }
                if (discards < 0)
                {
                        cout << "Too Little Cards, Try again: ";
                        cin  >> discards;
                }
        }
 
        cout << endl;
        if (discards > 0)
        {
                for (int count = 0; count < discards; count++)
                {
                        cout << "Choose Card To Discard (1-5, No Repetition): ";
                        cin  >> cardNum;
 
                        while(cardNum < 1 || cardNum > 5)
                        {
                                cout << "Invalid Number, Try Again : ";
                                cin  >> cardNum;
                        }
 
                                for (int card = 0; card < discards; card++)
                                {
                                        if(cardNum == repeat[card])
                                        {
                                                while (cardNum == repeat[card])
                                                {
                                                        cout << "No Repetition Allowed, Try Again: ";
                                                        cin  >> cardNum;
                                                }
                                        }
 
                                        if (cardNum != repeat[card] && repeat[card] == 100)
                                        {
                                                repeat[card] = cardNum;
                                        }
                                }
 
                                hand[cardNum-1] = theDeck.DealACard();
                        }
               
                cout << endl;
 
                cout << "Your New Hand Is: " << endl;
 
                for (int count = 0; count < 5; count++)
                {
                        cout << "[" << cards << "] ";
 
                        hand[count].Print();
 
                        cout << endl;
 
                        cards++;
                }
        }
        else
        {
                cout << "Your Hand Remains: " << endl;
 
                for (int count = 0; count < 5; count++)
                {
                        cout << "[" << cards << "] ";
 
                        hand[count].Print();
 
                        cout << endl;
 
                        cards++;
                }
        }
}

// Sortings

void SortSuits (Card Hand[5], int Suits[3])
{
	for (int count = 0; count < 5; count++)
	{
		Suits[Hand[count].GetSuit()]++;

	}

}

void SortFVs (Card Hand[5], int fv[13])
{
	for (int count = 0; count < 5; count++)
	{
		fv[Hand[count].GetFaceValue()]++;

	}

}

// Evaluations

bool PairCheck (int fv[13], FaceValue& thePair)
{

	for (int count = 0; count < 13; count++)
	{
		if (fv[count] == 2)
		{
			thePair = (FaceValue)count;
			return true;
		}
	}
	return false;
}

bool TwoPairCheck (int fv[13])
{
	bool one = false;
	bool two = false;
	for (int count = 0; count < 13; count++)
	{
		if (one == false || two == false)
		{
			if (fv[count] == 2)
			{
				if (one == false)
					one = true;
				else if (two == false)
					two = true;
			}
		}
		else
			break;
		
	}
	if (one == true && two == true)
				return true;
	
	return false;
	
	
}

bool ThreeOfAKind (int fv[13])
{

	for (int count = 0; count < 13; count++)
	{
		if (fv[count] == 3)
			 return true;
	}
	return false;
}

bool FourOfAKind (int fv[13])
{

	for (int count = 0; count < 13; count++)
	{
		if (fv[count] == 4)
			 return true;
	}
	return false;
}


bool StraightCheck(int fv[13], FaceValue& start)
{
	for (int count = 0; count < 9; count++)
	{
		if(fv[count] == 1 && fv[count+1] == 1 && fv[count+2] == 1 && fv[count+3] == 1 && fv[count+4] == 1)
		{
			start = (FaceValue)count;
			return true;
		}
	}
	return false;
}

bool Flush(int suits[4])
{
	for (int num = 0; num < 4; num++)
	{
		if (suits[num] == 5)
			return true;

	}
	return false;
}

Rank Evaluate(Card hand[])
{
	bool isFlush = false;
	bool isPair = false;
	bool isTwoPair = false;
	bool isThree = false;
    bool isStraight = false;
	bool isFour = false;
    int straightStart;
    int pairStart;
    int fv[13]              = {0};
    int suits[4]            = {0}; //  0= "Hearts", 1= "Diamonds", 2= "Clubs", 3= "Spades"
    FaceValue thePair;
	FaceValue StartStraight;

	SortSuits(hand, suits);
	SortFVs  (hand, fv);

	isPair = PairCheck(thePair);

	isTwoPair = TwoPairCheck(fv);

	isThree = ThreeOfAKind(fv);

	isFour = FourOfAKind(fv);
	
	isStraight = StraightCheck(fv,  StartStraight);

	isFlush = Flush(suits);
 
	if ( isFlush && isStraight && StartStraight == Ten )
		return RoyalFlush;
	else if ( isFlush && isStraight )
		return StraightFlush;
	else if ( isFour )
		return FourOfAKindes;
	else if ( isPair && isThree)
		return FullHouse;
	else if ( isFlush )
		return Flushes;
	else if ( isStraight )
		return Straight;
	else if ( isThree )
		return ThreeOfAKindes;
	else if ( isTwoPair )
		return TwoPair;
	else if ( isPair && thePair >= Jack)
		return Pair;
	else
		return Nothing;

}

int calculateWinnings(Rank TheRank, int bet)
{

	if (TheRank == RoyalFlush)
		return bet * 250;
	else if (TheRank == StraightFlush)
		return bet * 50;
	else if (TheRank == FourOfAKindes)
		return bet * 25;
	else if (TheRank == FullHouse)
		return bet * 9;
	else if (TheRank == Flushes)
		return bet * 6;
	else if (TheRank == Straight)
		return bet * 4;
	else if (TheRank == ThreeOfAKindes)
		return bet * 3;
	else if (TheRank == TwoPair)
		return bet * 2;
	else if (TheRank == Pair)
		return bet;
	else
		return 0;
}

void PrintRank(Rank TheRank)
{
	if (TheRank == RoyalFlush)
		cout << "Royal Flush";
	else if (TheRank == StraightFlush)
		cout << "Straight Flush";
	else if (TheRank == FourOfAKindes)
		cout << "Four of a kind";
	else if (TheRank == FullHouse)
		cout << "Full House(not the sitcom)";
	else if (TheRank == Flushes)
		cout << "Flush";
	else if (TheRank == Straight)
		cout << "Straight";
	else if (TheRank == ThreeOfAKindes)
		cout << "Three of a kind";
	else if (TheRank == TwoPair)
		cout << "Two pairs";
	else if (TheRank == Pair)
		cout << "Pair";
	else
		cout << "Nada";
}