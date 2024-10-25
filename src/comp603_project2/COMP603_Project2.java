/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comp603_project2;
import java.util.Scanner;

public class COMP603_Project2 {

   public static void main(String[] args) {
        int boardSize;                                                          //defining varibles 
        int shipCount;
        boolean player = true;
        boolean game = true;
        Scanner scan = new Scanner(System.in);                                  //creating scanner
        do {
            System.out.println("Enter Board Size between 2 - 26 or '1' to EXIT: ");                           //creates a gameboard based on user input sizes
            boardSize = scan.nextInt();
            if (boardSize == 1) {
                System.exit(0);
            }

        } while (boardSize < 2 || boardSize > 26);
        shipCount = boardSize - 1;                                              //sets the amount of ships to be -1 from board size

        GameBoardHome gameBoardHome = new GameBoardHome();                      //calling class functions
        GameBoardAway gameBoardAway = new GameBoardAway();
        gameBoardHome.initializeBoard(boardSize, shipCount);
        gameBoardHome.placeShip(boardSize, shipCount);
        System.out.println("BATTLESHIPS ROUND: 1" + "\n");
        gameBoardAway.initializeBoard(boardSize, shipCount);

        gameBoardAway.playGame(boardSize, game, shipCount);
        player = false;

        while (game) {                                                           //taking turns
            if (player) {
                gameBoardAway.playGame(boardSize, game, shipCount);
                player = false;
            } else if (!player) {
                gameBoardHome.playGame(boardSize, game, shipCount);
                player = true;
            }
        }

    }
}
