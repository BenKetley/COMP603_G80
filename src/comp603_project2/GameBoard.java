/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603_project2;

/**
 *
 * @author Ben
 */
import java.util.Arrays;

public class GameBoard {
    public char[][] board;                                                                                            
    private final char water = '~';
    private final char ship = 'S';
    private final char hit = 'X';
    private final char miss = '0';
    private int undetectedShips;
    private boolean isHome;  // Flag to distinguish between Home and Away boards
    private int roundCount = 1;
    private int unplacedShipCount = 10;
    //private boolean game = true;
    //private String coordinates;

    public GameBoard(boolean isHome) {
        this.isHome = isHome;
    }

    public void initializeBoard(int boardSize, int shipCount) {
        undetectedShips = shipCount;
        board = new char[boardSize][boardSize];
        for (char[] row : board) {
            Arrays.fill(row, water);
        }
        if (isHome) {
            printBoard(boardSize, "HOME");
        } else {
            ShipPlacement.placeShips(board, shipCount, water, ship); // Place AI ships for Away board
            printBoard(boardSize, "AWAY");
        }
    }
    
//    public void runGame(int boardSize){
//        while(game){
//            
//            System.out.println("Player's turn to attack:");
//            playGame(boardSize);
//            
//            System.out.println("Computer's turn to attack:");
//            playGame(boardSize);
//            
//            //System.out.println("Place Ships");
//            
//            
//            game = Home.hasUndetectedShips() && Away.hasUndetectedShips();
//        
//        }
//    }

    public int placeShip(int boardSize, int shipCount, String coordinates, boolean game) {
        //int undetectedShipCount = shipCount;
        

        if (unplacedShipCount > 0) { 
             //checks that unplaced ships are greatere than 0
            
            int[] guessCoordinates = UserInput.processCoordinates(coordinates);                                      // calls function to take users input coordinates
            char result = GaameLogic.evaluatePlacement(guessCoordinates, board, ship, water, hit, miss);                //checks if coordinates are valid
            if (result == ship && board[guessCoordinates[0]][guessCoordinates[1]] != ship) {                            //checks if ship has been placed before and if not reduce amount of unplaced ships
                unplacedShipCount--;
            }
            updateBoard(guessCoordinates, result);
            System.out.println("PLACE YOUR SHIPS");
            printBoard(boardSize, "HOME");
            if (unplacedShipCount > 0) {
                System.out.println("Ships left: " + unplacedShipCount);
            }
         else if (unplacedShipCount == 0){
        System.out.println("All Ships Placed!");
        System.out.println("\n" + "\n");
        System.out.println("Game = True");
        
        }
            }
        return unplacedShipCount;
    }

    public void playGame(int boardSize, String coordinates) {
        if (undetectedShips > 0) {
            int[] guessCoordinates = isHome ? ComputerAttack.generateShotCoordinates(boardSize) 
                                            : UserInput.processCoordinates(coordinates);
            char result = isHome ? GaameLogic.evaluateComputer(guessCoordinates, board, ship, water, hit, miss, boardSize) 
                                 : GaameLogic.evaluateTarget(guessCoordinates, board, ship, water, hit, miss, roundCount++);
            if (result == hit && board[guessCoordinates[0]][guessCoordinates[1]] != hit) {
                undetectedShips--;
                System.out.println((isHome ? "Hit! Your ships left = " : "Hit! Enemy ships left = ") + undetectedShips);
            }
            if (undetectedShips == 0) {
                System.out.println(isHome ? "You Lose!" : "You Win!");
                String gamelog = GameLogWriter.readGameLogFromCommandLine();
                String fileName = GameLogWriter.writefilename();
                GameLogWriter.saveGameLogToFile(gamelog, fileName);
                System.exit(0);
            } else {
                updateBoard(guessCoordinates, result);
                printBoard(boardSize, isHome ? "HOME" : "AWAY");
            }
        }
    }

    public void updateBoard(int[] coordinates, char result) {
        int row = coordinates[0];
        int col = coordinates[1];
        board[row][col] = result;
    }

    private void printBoard(int boardSize, String boardType) {
        System.out.println("      " + boardType);
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
                System.out.print((!isHome && position == ship ? water : position) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public boolean hasUndetectedShips() {
        return undetectedShips > 0;
}

}
