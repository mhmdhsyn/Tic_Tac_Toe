package edu.truman;
//Definition of CompPlayer Class
public class CompPlayer extends Player{


    char[] gameBoard; //Defining the array
    //Constructor of the class
    public CompPlayer(Board obj) {
        gameBoard = obj.gameBoard; //Passing the gameBoard to the object
    }

    boolean compuTerWinCheck() {
        int position = 0;

        //Winning approach for Computer
        for(int i =0; i<3; i++)
        {
            // checking if there is a possible row combination that can be used to win and doing all
            // three rows in a loop

            if (getRowTotal(gameBoard, i).equals("CC+")) {
                position = i * 3 + 2;
                gameBoard[position] = 'C';
                return true;
            }
            else if(getRowTotal(gameBoard,i).equals("C+C")){
                position = i * 3 + 1;
                gameBoard[position]= 'C';
                return true;
            }else if (getRowTotal(gameBoard,i).equals("+CC")){
                position = i * 3;
                gameBoard[position]= 'C';
                return true;
            }


            // checking if there is a possible column combination that can be used to win
            // and doing all three column in a loop
            if (getColumnTotal(gameBoard, i).equals("CC+")) {
                position = i + 6;
                gameBoard[position] = 'C';
                return true;
            } else if (getColumnTotal(gameBoard, i).equals("C+C")) {
                position = i + 3;
                gameBoard[position] = 'C';
                return true;
            } else if (getColumnTotal(gameBoard, i).equals("+CC")) {
                position = i;
                gameBoard[position] = 'C';
                return true;
            }

        }


        if (getFirstDiagnolTotal(gameBoard).equals("CC+")) {
            gameBoard[8] = 'C';
            return true;
        } else if (getFirstDiagnolTotal(gameBoard).equals("C+C")) {
            gameBoard[4] = 'C';
            return true;
        } else if (getFirstDiagnolTotal(gameBoard).equals("+CC")) {
            gameBoard[0] = 'C';
            return true;
        }

        if (getSecondDiagnolTotal(gameBoard).equals("CC+")) {
            gameBoard[6] = 'C';
            return true;
        } else if (getSecondDiagnolTotal(gameBoard).equals("C+C")) {
            gameBoard[4] = 'C';
            return true;
        } else if (getSecondDiagnolTotal(gameBoard).equals("+CC")) {
            gameBoard[2] = 'C';
            return true;
        }

        return false;
    }


    boolean humanWinCheck() {
        int position = 0;

        // Winning condition for Human
        for (int i = 0; i < 3; i++) {
            // checking if there is a possible row combination that can be used to win and
            // doing all three rows in a loop

            if (getRowTotal(gameBoard, i).equals("HH+")) {
                position = i * 3 + 2;
                gameBoard[position] = 'C';
                return true;
            } else if (getRowTotal(gameBoard, i).equals("H+H")) {
                position = i * 3 + 1;
                gameBoard[position] = 'C';
                return true;
            } else if (getRowTotal(gameBoard, i).equals("+HH")) {
                position = i * 3;
                gameBoard[position] = 'C';
                return true;
            }

            // checking if there is a possible column combination that can be used to win
            // and doing all three column in a loop
            if (getColumnTotal(gameBoard, i).equals("HH+")) {
                position = i + 6;
                gameBoard[position] = 'C';
                return true;
            } else if (getColumnTotal(gameBoard, i).equals("H+H")) {
                position = i + 3;
                gameBoard[position] = 'C';
                return true;
            } else if (getColumnTotal(gameBoard, i).equals("+HH")) {
                position = i;
                gameBoard[position] = 'C';
                return true;
            }

        }

        if (getFirstDiagnolTotal(gameBoard).equals("HH+")) {
            gameBoard[8] = 'C';
            return true;
        } else if (getFirstDiagnolTotal(gameBoard).equals("H+H")) {
            gameBoard[4] = 'C';
            return true;
        } else if (getFirstDiagnolTotal(gameBoard).equals("+HH")) {
            gameBoard[0] = 'C';
            return true;
        }

        if (getSecondDiagnolTotal(gameBoard).equals("HH+")) {
            gameBoard[6] = 'C';
            return true;
        } else if (getSecondDiagnolTotal(gameBoard).equals("H+H")) {
            gameBoard[4] = 'C';
            return true;
        } else if (getSecondDiagnolTotal(gameBoard).equals("+HH")) {
            gameBoard[2] = 'C';
            return true;
        }

        return false;
    }


    public void  CompNextMove()
    {
        // is the computer winning?
        // make the move and stop
        if (compuTerWinCheck() == true)
            return;

        // is the human winning?
        // stop winning condition
        if (humanWinCheck() == true)
            return;


        //////////////////////////////////////////////////
        if (gameBoard[4] == '+')// if center is empty put C there. It makes it unbeatable.
        {
            gameBoard[4] = 'C';
            return;
        }

        else {

            // select any unused space and select it
            for (int index = 0; index < Board.SIZE; index++) {
                if (gameBoard[index] == Board.EMPTY) {
                    gameBoard[index] = 'C';
                    return;
                }

            }
        }
    }


    ///////////////////////////////////////////////////////////////

    //Getting a string of row elements
    public static String getRowTotal(char[] array, int r) {
        String total = "";

        int row = r * 3;
        // 0: 0 1 2
        // 1: 3 4 5
        // 2: 6 7 8
        total = "" + array[row] + array[row + 1] + array[row + 2];

        return total;
    }
    ///////////////////////////////////////////////////////////////

    //Getting a string of column elements
    public static String getColumnTotal(char[] array, int col) {
        String total = "";

        total = "" + array[col] + array[col + 3] + array[col + 6];

        // System.out.println(" this is column matrix "+ total);
        return total;

    }

    //////////////////////////////////////////////////////

    //Getting the diagonal elements
    public static String getFirstDiagnolTotal(char[] array) {

        String total = "";

        total = "" + array[0] + array[4] + array[8];

        return total;
    }

    //////////////////////////////////////////////////////

    public static String getSecondDiagnolTotal(char[] array) {// getting the second diagonal elements
        String total = "";

        total = "" + array[2] + array[4] + array[6];

        return total;
    }

    ////////////////////////////////////////////////////////////
}


