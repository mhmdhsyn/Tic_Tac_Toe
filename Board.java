package edu.truman;
//Definition of Board Class
public class Board  {

    char[] gameBoard = new char[9]; // 3*3 array for gameBoard
    public static final int SIZE = 9; //Size of gameBoard
    public static final char EMPTY = '+'; //Defining what is an Empty space
    //Constructor of the class
    public Board() {

        //Initializing the array
        for (int i = 0; i < SIZE; i++) {
            gameBoard[i] = '+';
        }

    }

    public  void drawBoard()// display function to display the content of the array( tic tac toe)
    {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| " + gameBoard[i] + " |");
            if ((i + 1) % 3 == 0) //Printing a new line at end of each row
                System.out.println();

        }

        System.out.println();
    }

    /////////////////////////////////

    public void boardReset()// This function resets the Board to all + spaces
    {
        for (int i = 0; i < SIZE; i++) {
            gameBoard[i] = EMPTY;
        }
    }

    // Finding if someone won or not
    public char playerHasWon() {

        //Check each row
        if (gameBoard[0] == 'H' && gameBoard[1]=='H' && gameBoard[2]=='H') return 'H';
        else if (gameBoard[3] == 'H' && gameBoard[4]=='H' && gameBoard[5]=='H') return 'H';
        else if (gameBoard[6] == 'H' && gameBoard[7]=='H' && gameBoard[8]=='H') return 'H';
        //Checking if computer wins
        else if (gameBoard[0] == 'C' && gameBoard[1]=='C' && gameBoard[2]=='C') return 'C';
        else if (gameBoard[3] == 'C' && gameBoard[4]=='C' && gameBoard[5]=='C') return 'C';
        else if (gameBoard[6] == 'C' && gameBoard[7]=='C' && gameBoard[8]=='C') return 'C';


        //Check each column
        if (gameBoard[0] == 'H' && gameBoard[3]=='H' && gameBoard[6]=='H') return 'H';
        else if (gameBoard[1] == 'H' && gameBoard[4]=='H' && gameBoard[7]=='H') return 'H';
        else if (gameBoard[2] == 'H' && gameBoard[5]=='H' && gameBoard[8]=='H') return 'H';
        //Checking if computer wins
        else if (gameBoard[0] == 'C' && gameBoard[3]=='C' && gameBoard[6]=='C') return 'C';
        else if (gameBoard[1] == 'C' && gameBoard[4]=='C' && gameBoard[7]=='C') return 'C';
        else if (gameBoard[2] == 'C' && gameBoard[5]=='C' && gameBoard[8]=='C') return 'C';
        /////////////////////////////////////////

        String sumOfChars = "";// making a string from the array elements.
        for( int index = 0; index < SIZE; index++)
        {
            sumOfChars = sumOfChars + gameBoard[index];

        }

        if (sumOfChars.indexOf(EMPTY) < 0)// looking if there is a '+' left.
        // if not then it means the gameBoard is full and it is a tie
        {	return 'T';}

        //Check the diagonals
        if (gameBoard[0] == 'H' && gameBoard[4]=='H' && gameBoard[8]=='H') return 'H';
        else if (gameBoard[2] == 'H' && gameBoard[4]=='H' && gameBoard[6]=='H') return 'H';
        //Checking if computer wins
        else if (gameBoard[0] == 'C' && gameBoard[4]=='C' && gameBoard[8]=='C') return 'C';
        else if (gameBoard[2] == 'C' && gameBoard[4]=='C' && gameBoard[6]=='C') return 'C';

        // Otherwise nobody has won yet
        return ' ';

    }



}