/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603_project2;

/**
 *
 * @author Rory
 */
public class UserInput {

    public static int[] processCoordinates(String coordinates) {                     // function to get user inputs for an attack
        //Scanner scanner = new Scanner(System.in);
        //String coordinates;
        int row = - 50;
        int col = -60;

        System.out.print("Enter Coordinates to place your ship (e.g B2) or 'EXIT' to exit: ");
        if (coordinates.length() == 2) {                                // takes in user input and takes away the character equvielent to get the number value for our board
            row = coordinates.charAt(1) - '0';
            col = coordinates.charAt(0) - 'A';
            System.out.print(col + "     ");
            System.out.println(row);
        }
        //row = coordinates.charAt(1) - '0';
        //col = coordinates.charAt(0) - 'A';

        return new int[]{row - 1, col};
    }
}
