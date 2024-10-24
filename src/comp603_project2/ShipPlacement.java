/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603_project2;

import java.util.Random;

/**
 *
 * @author Rory
 */
public class ShipPlacement {

    public static void placeShips(char[][] board, int shipCount, char water, char ship) {   //function to place AI ships
        int placedShips = 0;
        int boardSize = board.length;
        while (placedShips < shipCount) {
            int[] location = generateShipCoordinates(boardSize);
            if (board[location[0]][location[1]] == water) {
                board[location[0]][location[1]] = ship;
                placedShips++;
            }
        }
    }

    private static int[] generateShipCoordinates(int boardSize) {               // function to generate random coordiantes for placing ships
        Random random = new Random();
        return new int[]{random.nextInt(boardSize), random.nextInt(boardSize)};
    }
}
