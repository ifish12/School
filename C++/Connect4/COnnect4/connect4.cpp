#include <iostream>
using namespace std;

/* ************************************************** */

const int BOARD_SIZE = 7;

const char EMPTY_TOKEN = ' ';  
const char PLAYER_1_TOKEN = 'X';  
const char PLAYER_2_TOKEN = 'O';
  
/* ************************************************** */

struct Connect4
{
	char theBoard[BOARD_SIZE][BOARD_SIZE];
	char currentPlayer;
};

/* ************************************************** */

void initGame(Connect4 &);
void drawBoard(Connect4);
void makeMove(Connect4&, int);
int getMove(Connect4&);
bool noMoreMoves(Connect4); 
char isThereAWinner(Connect4);

/* ************************************************** */

void main(void)
{
	Connect4 theGame;
	int theMove;
	char winner=EMPTY_TOKEN;
	
	initGame(theGame);
	drawBoard(theGame);

	while( !noMoreMoves(theGame) )		
	{
		theMove=getMove(theGame);
		makeMove(theGame, theMove);
		system("cls");
		drawBoard(theGame);
	


		winner=isThereAWinner(theGame);
		if ( winner != EMPTY_TOKEN )
		{
			break;
		}
	}
	
	if ( winner != EMPTY_TOKEN )
	{
		cout << winner << " wins!" << endl;
	}
	else
	{
		cout << "Tie!\n";
	}

	system("pause");

}

/* ************************************************** */

void initGame(Connect4 &aGame)
{

	aGame.currentPlayer = PLAYER_1_TOKEN;
	for (int count = 0; count < BOARD_SIZE; count++)
	{
		for (int count2 = 0; count2 < BOARD_SIZE; count2++)
		{
			aGame.theBoard[count][count2] = EMPTY_TOKEN;
		}
	}
}

/* ************************************************** */

void drawBoard(Connect4 theGame)
{
	cout << " ";
	for (int column = 0; column < 7; column++)	
	{
		bool emptyInRow = false;
		
		for (int row = 0; row < 7; row++)
		{
			if(theGame.theBoard[column][row] == EMPTY_TOKEN)
			{
				emptyInRow = true;
				break;
			}
		}
		
		if(emptyInRow == false)
			cout << "  ";
		else
			cout << column+1 << " ";
	}

	cout << endl;

	cout << "+-+-+-+-+-+-+-+" << endl;
	for (int count = 0; count < 7; count++)
	{
		for (int count2 = 0; count2 < 7; count2++)
		{
			cout << "|" << theGame.theBoard[count][count2] ; //<< "|" << theGame.theBoard[count][2] << "|" << theGame.theBoard[count][3] << "|"  << theGame.theBoard[count][4] << "|"  << theGame.theBoard[count][5] << "|"  << theGame.theBoard[count][6] << "|"  << theGame.theBoard[count][7] << "|"  << endl;
	
		}
		cout << "\n";
		cout << "+-+-+-+-+-+-+-+" << endl;
	}


}

/* ************************************************** */

void makeMove(Connect4 &theGame , int slot)
{
	int place = 0;
	
		for (int count = BOARD_SIZE - 1; count >= 0; count--)
		{
			if (place == 0)
			{
				if (theGame.theBoard[count][slot-1] == EMPTY_TOKEN)
				{
					place++;
					theGame.theBoard[count][slot-1] = theGame.currentPlayer;
				}
			}
		}
	


}

/* ************************************************** */

int getMove(Connect4& theGame)
{
	int play = 0;
	char token;



	do
	{
	cout << "Your turn player " << theGame.currentPlayer << " where do you wish to move: ";
	cin  >> play;

	}
	while (play > 7);

	if (theGame.theBoard[0][play] == 'X' || theGame.theBoard [0][play] == 'O')
	{
			cout << "That slot is too full!" << endl;
			system("pause");
	}
	if (theGame.currentPlayer == PLAYER_1_TOKEN)
		theGame.currentPlayer = PLAYER_2_TOKEN;
	else
		theGame.currentPlayer = PLAYER_1_TOKEN;
	
	return play;


	
}

/* ************************************************** */

bool noMoreMoves(Connect4 theGame)
{
	bool test = false;

	int counter = 0;

	for (int count = 0; count < 7; count++)
	{
		if (theGame.theBoard[0][count] != EMPTY_TOKEN)
			counter++;
	}
	if (counter == 7)
		test = true;

	return test;
}
  
/* ************************************************** */

char isThereAWinner(Connect4 theGame)
{ 
	for (int x = 0; x < BOARD_SIZE; x++)
	{
		for (int y = 0; y < BOARD_SIZE; y++)
		{
			//Horizontal
			if (x < BOARD_SIZE - 3)
			{
				if (theGame.theBoard[x  ][y] == PLAYER_1_TOKEN && theGame.theBoard[x+1][y] == PLAYER_1_TOKEN &&  
					theGame.theBoard[x+2][y] == PLAYER_1_TOKEN && theGame.theBoard[x+3][y] == PLAYER_1_TOKEN)
					return PLAYER_1_TOKEN;
				if (theGame.theBoard[x  ][y] == PLAYER_2_TOKEN && theGame.theBoard[x+1][y] == PLAYER_2_TOKEN &&
					theGame.theBoard[x+2][y] == PLAYER_2_TOKEN && theGame.theBoard[x+3][y] == PLAYER_2_TOKEN)
					return PLAYER_2_TOKEN;
			}

			//Vertical
			if (y < BOARD_SIZE - 3)
			{
				if (theGame.theBoard[x][y  ] == PLAYER_1_TOKEN && theGame.theBoard[x][y+1] == PLAYER_1_TOKEN &&
					theGame.theBoard[x][y+2] == PLAYER_1_TOKEN && theGame.theBoard[x][y+3] == PLAYER_1_TOKEN)
					return PLAYER_1_TOKEN;
				if (theGame.theBoard[x][y  ] == PLAYER_2_TOKEN && theGame.theBoard[x][y+1] == PLAYER_2_TOKEN &&
					theGame.theBoard[x][y+2] == PLAYER_2_TOKEN && theGame.theBoard[x][y+3] == PLAYER_2_TOKEN)
					return PLAYER_2_TOKEN;
			}

			//Diagnal (/)
			if (x < BOARD_SIZE - 3 && y < BOARD_SIZE - 3)
			{
				if (theGame.theBoard[x  ][y  ] == PLAYER_1_TOKEN && theGame.theBoard[x+1][y+1] == PLAYER_1_TOKEN &&
					theGame.theBoard[x+2][y+2] == PLAYER_1_TOKEN && theGame.theBoard[x+3][y+3] == PLAYER_1_TOKEN)
					return PLAYER_1_TOKEN;
				if (theGame.theBoard[x  ][y  ] == PLAYER_2_TOKEN && theGame.theBoard[x+1][y+1] == PLAYER_2_TOKEN &&
					theGame.theBoard[x+2][y+2] == PLAYER_2_TOKEN && theGame.theBoard[x+3][y+3] == PLAYER_2_TOKEN)
					return PLAYER_2_TOKEN;
			}

			//Diagnal(\)
			if (x < BOARD_SIZE - 3 && y >= 3)
			{
				if (theGame.theBoard[x  ][y  ] == PLAYER_1_TOKEN && theGame.theBoard[x+1][y-1] == PLAYER_1_TOKEN &&
					theGame.theBoard[x+2][y-2] == PLAYER_1_TOKEN && theGame.theBoard[x+3][y-3] == PLAYER_1_TOKEN)
					return PLAYER_1_TOKEN;
				if (theGame.theBoard[x  ][y  ] == PLAYER_2_TOKEN && theGame.theBoard[x+1][y-1] == PLAYER_2_TOKEN &&
					theGame.theBoard[x+2][y-2] == PLAYER_2_TOKEN && theGame.theBoard[x+3][y-3] == PLAYER_2_TOKEN)
					return PLAYER_2_TOKEN;
			}
		}
	}
	return EMPTY_TOKEN;
} 