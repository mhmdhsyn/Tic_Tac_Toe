package edu.truman;
import java.util.Scanner;

public class TicTacToe {


    //Main function
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);//Initializing new scanner object
        Board gameBoard= new Board();// creating board object

        // Create a computer player object
        CompPlayer comp = new CompPlayer(gameBoard);
        // Create a HumanPlayer object
        HumanPlayer human = new HumanPlayer(gameBoard);


        //Initializing the first game
        String gameInput= "Y";
        //The game while loop
        while(gameInput.equals("Y") )
        {
            //Reset and draw the board
            gameBoard.boardReset();
            gameBoard.drawBoard();


            while(true)
            {
                System.out.println("Human player turn .. ");
                //taking user input
                human.CompNextMove();

                if(gameBoard.playerHasWon() =='H')// checking if human won
                {
                    System.out.println("Human won the game");
                    gameBoard.drawBoard();
                    break;
                }

                // call the computer player method to make computer move
                comp.CompNextMove();
                System.out.println("Computer has made the following move... ");
                gameBoard.drawBoard();


                if(gameBoard.playerHasWon() =='C')//checking if computer won
                {
                    System.out.println("Computer won the game");
                    gameBoard.drawBoard();
                    break;
                }

                if(gameBoard.playerHasWon() =='T')// checking if it is a tie
                {
                    System.out.println("There is a Tie between the Computer and the Human");
                    gameBoard.drawBoard();
                    break;
                }
            }
            //Asking if user wants to play again
            System.out.println("Do you want to continue or not, if so press Y otherwise N");
            gameInput = in.next();

        }
        in.close();
    }
}