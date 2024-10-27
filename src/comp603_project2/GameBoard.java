/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603_project2;

import java.util.Arrays;

public class GameBoard {
    public char[][] board;
    private final char water = '~';
    private final char ship = 'S';
    private final char hit = 'X';
    private final char miss = '0';
    private int undetectedShips;
    private int roundCount = 1;
    private int unplacedShipCount = 10;
    private boolean isHome;
    private BattleshipDatabase battleshipDatabase;

    public GameBoard(boolean isHome) {
        this.isHome = isHome;
        this.battleshipDatabase = new BattleshipDatabase();  // Initialize BattleshipDatabase to handle DB operations
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
            ShipPlacement.placeShips(board, shipCount, water, ship);
            printBoard(boardSize, "AWAY");
        }
    }

    public int placeShip(int boardSize, int shipCount, String coordinates,boolean game) {
        if (unplacedShipCount > 0) {
            int[] guessCoordinates = UserInput.processCoordinates(coordinates);
            char result = GaameLogic.evaluatePlacement(guessCoordinates, board, ship, water, hit, miss);

            if (result == ship && board[guessCoordinates[0]][guessCoordinates[1]] != ship) {
                unplacedShipCount--;
            }
            updateBoard(guessCoordinates, result);
            battleshipDatabase.logMove("place", coordinates, result);  // Log move via BattleshipDatabase
            printBoard(boardSize, "HOME");

            if (unplacedShipCount == 0) {
                System.out.println("All Ships Placed!");
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
            }
            battleshipDatabase.logMove("attack", coordinates, result);  // Log attack via BattleshipDatabase
            updateBoard(guessCoordinates, result);
            printBoard(boardSize, isHome ? "HOME" : "AWAY");

            if (undetectedShips == 0) {
                battleshipDatabase.logGameResult(isHome ? "lose" : "win");  // Log game result via BattleshipDatabase
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
