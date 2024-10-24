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
public class ComputerAttack {

//    public static void placeShot(char[][] board, int shipCount, char water, char ship) {
//        int placedShips = 0;
//        int boardSize = board.length;
//        while (placedShips < shipCount) {
//            int[] location = generateShotCoordinates(boardSize);
//            if (board[location[0]][location[1]] == water) {
//                board[location[0]][location[1]] = ship;
//                placedShips++;
//            }
//        }
//    }
    public static int[] generateShotCoordinates(int boardSize) {                //creates random coordinates to be used by the computer
        Random random = new Random();
        return new int[]{random.nextInt(boardSize), random.nextInt(boardSize)};
    }
}
