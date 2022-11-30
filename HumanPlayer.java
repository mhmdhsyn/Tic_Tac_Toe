package edu.truman;
import java.util.Scanner;
//Defining HumanPlayer class
public class HumanPlayer extends Player {

    char[] gameBoard; //Gameboard array to store state of the game
    //Constructor of HumanPlayer Class
    public HumanPlayer(Board obj) {
        gameBoard = obj.gameBoard;
    }
    //Function to ask user for input and reflecting it on the board
    public void CompNextMove() {
        Scanner input = new Scanner(System.in); //Initializing scanner object
        System.out.print("Enter a position (0--9):"); //Asking user for input
        while(!input.hasNextInt()){
            System.out.println("Enter Integer!");
            input.nextLine();
        }
        int user_input = input.nextInt(); //Taking input form the user

        //Validating User input
        while(user_input > 8 || user_input < 0){
            System.out.println("Please Enter a Valid Number!");
            System.out.print("Enter a position (0--9):");
            user_input = input.nextInt();
        }

        while(!(gameBoard[user_input] == '+')){
            System.out.println("This is not an empty space!");
            System.out.print("Enter a position (0--9):");
            user_input = input.nextInt();
        }
        //Assigning the value H to the space chosen
        gameBoard[user_input] = 'H';
    }
}