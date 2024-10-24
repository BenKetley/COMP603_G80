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
public class GameBoardHome {

    private char[][] board;                                                                                             // private variables used in the class.
    //public int boardSize;
    private final char water = '~';
    private final char ship = 'S';
    private final char hit = 'X';
    private final char miss = '0';
    private int homeship;
    
    public void initializeBoard(int boardSize, int shipCount) {
        homeship = shipCount;
        board = new char[boardSize][boardSize];                                                                         // creates new board with dimensions of size
        for (char[] row : board) {
            Arrays.fill(row, water);                                                                                    // Fills board with water
        }
        //ShipPlacement.placeShips(board, shipCount, water, ship);
        printBoardHome(boardSize);                                                                                      // Print the board immediately after initialization
    }

    public void placeShip(int boardSize, int shipCount) {
        //int undetectedShipCount = shipCount;
        int unplacedShipCount = shipCount;

        while (unplacedShipCount > 0) {                                                                                  //checks that unplaced ships are greatere than 0
            int[] guessCoordinates = UserInputPlace.getUserCoordinates(boardSize);                                      // calls function to take users input coordinates
            char result = GaameLogic.evaluatePlacement(guessCoordinates, board, ship, water, hit, miss);                //checks if coordinates are valid
            if (result == ship && board[guessCoordinates[0]][guessCoordinates[1]] != ship) {                            //checks if ship has been placed before and if not reduce amount of unplaced ships
                unplacedShipCount--;
            }
            updateBoard(guessCoordinates, result);
            System.out.println("PLACE YOUR SHIPS");
            printBoardHome(boardSize);
            if (unplacedShipCount > 0) {
                System.out.println("Ships left: " + unplacedShipCount);
            }
        }
        System.out.println("All Ships Placed!");
        System.out.println("\n" + "\n");
    }

    public void playGame(int boardSize, boolean game, int shipCount) {                                                   // Variable for checking number of ships safe
        
        //int unplacedShipCount = shipCount;

        if (homeship > 0) {                                                                                            //If statement checks there are still safe ships
            int[] guessCoordinates = ComputerAttack.generateShotCoordinates(boardSize);                                 //Calls the function to cake users input coordinates 
            char result = GaameLogic.evaluateComputer(guessCoordinates, board, ship, water, hit, miss, boardSize);      //checks what the coordinates hit
            if (result == hit && (board[guessCoordinates[0]][guessCoordinates[1]] != hit)) {                              //if statement to check if a ship has been hit & was not hit before
                homeship--;                                                                                            // minus count of safe ship
                System.out.println("Hit! Your ships left = " + homeship);                                              //messasge saying how many ships you have left

            }
            if (homeship == 0) {                                                                                         // if home board has no more safe ship you loose
                System.out.println("You Lose!");
                String gamelog = GameLogWriter.readGameLogFromCommandLine();                                                //uses GameLogwriter function to read users message
                String fileName = GameLogWriter.writefilename();                                                            //then asks them what they would like to name the file
                GameLogWriter.saveGameLogToFile(gamelog, fileName);                                                         //saves the file with users choosen name
                System.exit(0);                                                                                             //closes the game when finished
            } else {                                                                                                      //else the game loops until if statment is true
                updateBoard(guessCoordinates, result);
                printBoardHome(boardSize);
            }
        }
    }

    private void updateBoard(int[] coordinates, char result) {                                                          // updates the board with the result of shot.
        int row = coordinates[0];
        int col = coordinates[1];
        board[row][col] = result;
    }

    public void printBoardHome(int boardSize) {
        System.out.println("      HOME");
        System.out.print("   ");
        for (char i = 'A'; i < (boardSize + 65); i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int row = 0; row < boardSize; row++) {
            if (row < 9) {
                System.out.print("0" + (row + 1) + " ");
            } else {
                System.out.print((row + 1) + " ");
            }
            for (int col = 0; col < boardSize; col++) {
                char position = board[row][col];

//                if (position == ship) {
//                    System.out.print(water + " ");
//                }
//                else {
                System.out.print(position + " ");
                //}
            }
            System.out.println();
        }
        System.out.println();
    }
}
