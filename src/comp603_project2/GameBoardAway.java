/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603_project2;

import java.util.Arrays;

/**
 *
 * @author Rory
 */
public class GameBoardAway {

    private char[][] board;                                                                                             // private variables used in the class.
    private final char water = '~';
    private final char ship = 'S';
    private final char hit = 'X';
    private final char miss = '0';
    public int roundCount = 1;
    private int undetectedship;
    

    public void initializeBoard(int boardSize, int shipCount) {
//        Scanner scan = new Scanner(System.in);
//        do {
//            System.out.println("Enter Board Size: ");
//            boardSize = scan.nextInt();
//        } while (boardSize < 2 || boardSize > 26);
        undetectedship = shipCount;
        board = new char[boardSize][boardSize];                                                                        // creates new board with dimensions of size
        for (char[] row : board) {
            Arrays.fill(row, water);                                                                                    // Fills board with water
        }
        ShipPlacement.placeShips(board, shipCount, water, ship);                                                        // Calls Ship placement class to place AI Ships
        printBoardAway(boardSize);                                                                                      // Print the board after initialization
    }

    public void playGame(int boardSize, boolean game, int shipCount) {

        if (undetectedship > 0) {                                                                                  // If statement checks there are still safe ships
            roundCount++;
            int[] guessCoordinates = UserInputAttack.getUserCoordinates(boardSize);                                     // Calls the function to cake users input coordinates
            char result = GaameLogic.evaluateTarget(guessCoordinates, board, ship, water, hit, miss, roundCount);                   // checks what the coordinates hit
            if (result == hit && (board[guessCoordinates[0]][guessCoordinates[1]] != hit)) {                              // if statement to check if a ship has been hit & was not hit before
                undetectedship--;                                                                                  // minus count of safe ship
            }
            if (undetectedship == 0) {                                                                              // if away board has no more safe ship you win
                System.out.println("You Win!");
                String gamelog = GameLogWriter.readGameLogFromCommandLine();                                                //uses GameLogwriter function to read users message
                String fileName = GameLogWriter.writefilename();                                                            //then asks them what they would like to name the file
                GameLogWriter.saveGameLogToFile(gamelog, fileName);                                                         //saves the file with users choosen name
                System.exit(0);                                                                                             //closes the game when finished
            } else {                                                                                                       // if away board still have safe ship the gameboard is updated and printed to console.
                updateBoard(guessCoordinates, result);
                printBoardAway(boardSize);
            }
        }

    }

    private void updateBoard(int[] coordinates, char result) {                                                          // updates the board with the result of shot.
        int row = coordinates[0];
        int col = coordinates[1];
        board[row][col] = result;
    }

    private void printBoardAway(int boardSize) {                                                                        // function to print board

        System.out.println("      AWAY");                                                                               // board title
        System.out.print("   ");                                                                                        // off set to line up with board
        for (char i = 'A'; i < (boardSize + 65); i++) {                                                                 // Print out X axis guide
            System.out.print(i + " ");                                                                                  // formatting
        }
        System.out.println();                                                                                           // formatting
        for (int row = 0; row < boardSize; row++) {                                                                     // for loop for printing y axis
            if (row < 9) {                                                                                              // If statement prints 0 in front of single digit numbers
                System.out.print("0" + (row + 1) + " ");
            } else {                                                                                                    //prints y axis for double digits
                System.out.print((row + 1) + " ");
            }
            for (int col = 0; col < boardSize; col++) {                                                                 // function for printing board contents
                char position = board[row][col];
                if (position == ship) {                                                                                 // hides ships from enemy
                    System.out.print(water + " ");
                } else {
                    System.out.print(position + " ");                                                                   // prints out anything but ship, water, hit and miss
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
