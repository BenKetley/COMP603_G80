
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comp603_project2;

import java.util.Scanner;

public class COMP603_Project2 {

    public static void main(String[] args) {
        // Initialize the database
        BattleshipDatabase battleshipDatabase = new BattleshipDatabase();

        String boardSize;
        int boardSizeint = 0;
        int shipCount;
        boolean player = true;
        boolean game = true;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Enter Board Size between 2 - 26 or '1' to EXIT: ");
            boardSize = scan.nextLine();
            if (boardSize.length() == 2){
                boardSizeint = (((boardSize.charAt(0) - '0')*10) + (boardSize.charAt(1) - '0'));
            }
            else if (boardSize.length() == 1){
                boardSizeint = ((boardSize.charAt(0) - '0'));
            }
            
            if (boardSizeint == 1) {
                System.exit(0);
            }

        } while ((boardSizeint < 2 || boardSizeint > 26));
        
        shipCount = boardSizeint - 1;

        GameBoardHome gameBoardHome = new GameBoardHome();
        GameBoardAway gameBoardAway = new GameBoardAway();
        
        gameBoardHome.initializeBoard(boardSizeint, shipCount);
        gameBoardHome.placeShip(boardSizeint, shipCount);
        System.out.println("BATTLESHIPS ROUND: 1" + "\n");
        gameBoardAway.initializeBoard(boardSizeint, shipCount);

        // Example of using the database to save board size and ship count
        try {
            battleshipDatabase.statement.executeUpdate("INSERT INTO BattleShips (BoardSize, HIT, MISS) VALUES (" 
                                                       + boardSizeint + ", 'False', 'True')");
        } catch (Exception e) {
            System.out.println("Error inserting data into the database: " + e.getMessage());
        }

        // Gameplay loop
        gameBoardAway.playGame(boardSizeint, game, shipCount);
        player = false;

        while (game) {
            if (player) {
                gameBoardAway.playGame(boardSizeint, game, shipCount);
                player = false;
            } else {
                gameBoardHome.playGame(boardSizeint, game, shipCount);
                player = true;
            }
        }

        // Close the database connection when the game ends
        battleshipDatabase.closeConnection();
    }
}

    
