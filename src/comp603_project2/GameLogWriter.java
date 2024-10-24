/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603_project2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Rory
 */
public class GameLogWriter {                                                    //function for taking user input to put into file

    public static String readGameLogFromCommandLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the game winner: ");
        return scanner.nextLine();
    }

    public static String writefilename() {                                       //function for user being able to choose file name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose File Name: ");
        String userinput = scanner.nextLine();
        return userinput + ".txt";
    }

    public static void saveGameLogToFile(String gameLog, String fileName) {     //saves the users score/message to the file of their choice
        try ( FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(gameLog);
            System.out.println("Game winner saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving game winner: " + e.getMessage());
        }
    }
}
