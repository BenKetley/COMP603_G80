/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603_project2;

import java.util.Scanner;

/**
 *
 * @author Rory
 */
public class UserInputPlace {

    public static int[] getUserCoordinates(int boardSize) {                     // function to get user inputs for an attack
        Scanner scanner = new Scanner(System.in);
        String coordinates;
        int row = -50;
        int col = -50;
        do {
            System.out.print("Enter Coordinates to place your ship (e.g B2) or 'EXIT' to exit: ");

            coordinates = scanner.nextLine().toUpperCase();
            System.out.println("");
            //System.out.println(coordinates.length());
            if ((coordinates.charAt(0) == 'E') && (coordinates.charAt(1) == 'X') && (coordinates.charAt(2) == 'I') && (coordinates.charAt(3) == 'T')) {  //if user types in exit it will evaluate these as coordiantes and exit
                System.exit(0);
            } else if (coordinates.length() == 2) {                                // takes in user input and takes away the character equvielent to get the number value for our board
                row = coordinates.charAt(1) - '0';
                col = coordinates.charAt(0) - 'A';
            }
            //row = coordinates.charAt(1) - '0';
            //col = coordinates.charAt(0) - 'A';
        } while (row < 1 || row > boardSize || col < 0 || col >= boardSize);    //while loop that ensures user coordinates are correct if not restart fuction or return users attack coordinates
        return new int[]{row - 1, col};
    }
}
