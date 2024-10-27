
//
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
// */
//package comp603_project2;
//
//import java.util.Scanner;
//
///**
// *
// * @author Ben
// */
//public class COMP603_Project2 {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        String boardSize;   //defining varibles 
//        int boardSizeint = 0;
//        int shipCount;
//        boolean player = true;
//        boolean game = true;
//        Scanner scan = new Scanner(System.in);                                  //creating scanner
//        do {
//            System.out.println("Enter Board Size between 2 - 26 or '1' to EXIT: ");                           //creates a gameboard based on user input sizes
//            boardSize = scan.nextLine();
//            System.out.println((boardSize.charAt(0)));
//            //System.out.println((boardSize.charAt(0)));
//            if (boardSize.length() == 2){
//                boardSizeint = (((boardSize.charAt(0) - '0')*10) + (boardSize.charAt(1) - '0'));
//            }
//            else if (boardSize.length() == 1){
//                boardSizeint = ((boardSize.charAt(0) - '0'));
//            }
//            
//            if (boardSizeint == 1) {
//                System.exit(0);
//            }
//
//        } while ((boardSizeint < 2 || boardSizeint > 26));
//        shipCount = boardSizeint - 1;                                              //sets the amount of ships to be -1 from board size
//
//        //GameBoardHome gameBoardHome = new GameBoardHome();                      //calling class functions
//        ///GameBoardAway gameBoardAway = new GameBoardAway();
//        gameBoardHome.initializeBoard(boardSizeint, shipCount);
//        gameBoardHome.placeShip(boardSizeint, shipCount);
//        System.out.println("BATTLESHIPS ROUND: 1" + "\n");
//        gameBoardAway.initializeBoard(boardSizeint, shipCount);
//
//        gameBoardAway.playGame(boardSizeint, game, shipCount);
//        player = false;
//
//        while (game) {                                                           //taking turns
//            if (player) {
//                gameBoardAway.playGame(boardSizeint, game, shipCount);
//                player = false;
//            } else if (!player) {
//                gameBoardHome.playGame(boardSizeint, game, shipCount);
//                player = true;
//            }
//        }
//
//    }
//    }
