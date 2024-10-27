/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603_project2;

/**
 *
 * @author Rory
 */
public class GaameLogic {

    public static char evaluateTarget(int[] coordinates, char[][] board, char ship, char water, char hit, char miss, int roundCount) {

        int row = coordinates[0];
        int col = coordinates[1];
        char target = board[row][col];                                          // creates a target array based on user input coordinates

        if (target == hit) {

            System.out.println("BATTLESHIPS ROUND: " + roundCount + "\n");
            System.out.println("Already Hit!");
            return hit;                                                         // Return hit
        } else if (target == ship) {

            System.out.println("BATTLESHIPS ROUND: " + roundCount + "\n");
            System.out.println("Hit!");
            return hit;                                                         // Return hit 
        } else if (target == water) {

            System.out.println("BATTLESHIPS ROUND: " + roundCount + "\n");
            System.out.println("Miss!");
            return miss;                                                        // Return miss
        }
        return target;
    }

    public static char evaluatePlacement(int[] coordinates, char[][] board, char ship, char water, char hit, char miss) {
        int row = coordinates[0];
        int col = coordinates[1];
        char target = board[row][col];                                          // creates a target array based on user input coordinates

        if (target == ship) {
            System.out.println("Already Placed!");
            return ship;
        } else if (target == water) {
            System.out.println("Placed");
            return ship;
        } //else if (target == water) {
        // System.out.println("Miss!");
        // return miss; // Return miss to indicate a miss
        //}
        return target;
    }

    public static char evaluateComputer(int[] coordinates, char[][] board, char ship, char water, char hit, char miss, int boardSize) {
        int row = coordinates[0];
        int col = coordinates[1];
        char target = board[row][col];                                          // creates a target array based on user input coordinates

        if (target == hit) {
            ComputerAttack.generateShotCoordinates(boardSize);
        } else if (target == ship) {
            //System.out.println("Hit!");
            return hit;                                                         // Return hit
        } else if (target == water) {
            System.out.println("Miss");
            return miss;                                                        // Return miss
        }
        return target;
    }

}
