package comp603_project2;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.awt.*;
import java.util.List;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Ben
 */
public class COMP604_GUI_Form extends javax.swing.JFrame {
    // declaring variables
        int boardSize = 9;
        int shipCount = 10;
        int round = 1;
        private int undetectedShipCount =10;
        private int unplacedShipCount = 10;
        String coordinates;
        boolean game = true;
        private final Map<String, JButton> buttonMap = new HashMap<>();
        GameBoard Home = new GameBoard(true);                     
        GameBoard Away = new GameBoard(false);
        
        
        

    /**
     * Creates new form COMP604_GUI_Form
     */
    public COMP604_GUI_Form() {
        // assigning buttons to map
        initComponents();
        
        buttonMap.put("A1", HomeA1);
        buttonMap.put("A2", HomeA2);
        buttonMap.put("A3", HomeA3);
        buttonMap.put("A4", HomeA4);
        buttonMap.put("A5", HomeA5);
        buttonMap.put("A6", HomeA6);
        buttonMap.put("A7", HomeA7);
        buttonMap.put("A8", HomeA8);
        buttonMap.put("A9", HomeA9);
        
        buttonMap.put("B1", HomeB1);
        buttonMap.put("B2", HomeB2);
        buttonMap.put("B3", HomeB3);
        buttonMap.put("B4", HomeB4);
        buttonMap.put("B5", HomeB5);
        buttonMap.put("B6", HomeB6);
        buttonMap.put("B7", HomeB7);
        buttonMap.put("B8", HomeB8);
        buttonMap.put("B9", HomeB9);
        
        buttonMap.put("C1", HomeC1);
        buttonMap.put("C2", HomeC2);
        buttonMap.put("C3", HomeC3);
        buttonMap.put("C4", HomeC4);
        buttonMap.put("C5", HomeC5);
        buttonMap.put("C6", HomeC6);
        buttonMap.put("C7", HomeC7);
        buttonMap.put("C8", HomeC8);
        buttonMap.put("C9", HomeC9);
        
        buttonMap.put("D1", HomeD1);
        buttonMap.put("D2", HomeD2);
        buttonMap.put("D3", HomeD3);
        buttonMap.put("D4", HomeD4);
        buttonMap.put("D5", HomeD5);
        buttonMap.put("D6", HomeD6);
        buttonMap.put("D7", HomeD7);
        buttonMap.put("D8", HomeD8);
        buttonMap.put("D9", HomeD9);
        
        buttonMap.put("E1", HomeE1);
        buttonMap.put("E2", HomeE2);
        buttonMap.put("E3", HomeE3);
        buttonMap.put("E4", HomeE4);
        buttonMap.put("E5", HomeE5);
        buttonMap.put("E6", HomeE6);
        buttonMap.put("E7", HomeE7);
        buttonMap.put("E8", HomeE8);
        buttonMap.put("E9", HomeE9);
        
        buttonMap.put("F1", HomeF1);
        buttonMap.put("F2", HomeF2);
        buttonMap.put("F3", HomeF3);
        buttonMap.put("F4", HomeF4);
        buttonMap.put("F5", HomeF5);
        buttonMap.put("F6", HomeF6);
        buttonMap.put("F7", HomeF7);
        buttonMap.put("F8", HomeF8);
        buttonMap.put("F9", HomeF9);
        
        buttonMap.put("G1", HomeG1);
        buttonMap.put("G2", HomeG2);
        buttonMap.put("G3", HomeG3);
        buttonMap.put("G4", HomeG4);
        buttonMap.put("G5", HomeG5);
        buttonMap.put("G6", HomeG6);
        buttonMap.put("G7", HomeG7);
        buttonMap.put("G8", HomeG8);
        buttonMap.put("G9", HomeG9);
        
        buttonMap.put("H1", HomeH1);
        buttonMap.put("H2", HomeH2);
        buttonMap.put("H3", HomeH3);
        buttonMap.put("H4", HomeH4);
        buttonMap.put("H5", HomeH5);
        buttonMap.put("H6", HomeH6);
        buttonMap.put("H7", HomeH7);
        buttonMap.put("H8", HomeH8);
        buttonMap.put("H9", HomeH9);
        
        buttonMap.put("I1", HomeI1);
        buttonMap.put("I2", HomeI2);
        buttonMap.put("I3", HomeI3);
        buttonMap.put("I4", HomeI4);
        buttonMap.put("I5", HomeI5);
        buttonMap.put("I6", HomeI6);
        buttonMap.put("I7", HomeI7);
        buttonMap.put("I8", HomeI8);
        buttonMap.put("I9", HomeI9);


        
        // Initializes the game boards
        Home.initializeBoard(boardSize, shipCount);
        Away.initializeBoard(boardSize, shipCount);
        
        
           
            
            
        }
    
    public void gameUpdator() {
        // Updates the game in the GUI
            round = round+1;
            if (undetectedShipCount ==0){
                InstructionText.setText("YOU WIN!!!");
                
            }
            
            InstructionText.setText("Round: " + round + " Ships Left: "+ undetectedShipCount);
        for (char col = 'A'; col <= 'I'; col++) { // for loop checks and updates conditions of all grid positions
            for (int row = 1; row <= 9; row++) {
                String coords = col + Integer.toString(row);
                JButton button = buttonMap.get(coords);
                if (button == null) continue; // Safeguard if the button is missing

                int colIndex = col - 'A';
                int rowIndex = row - 1; // Adjust for zero-based indexing
                char cell = Home.board[rowIndex][colIndex];

                if (cell == 'X') { // formats GUI based on game state
                    button.setBackground(Color.red);
                    button.setText("X");
                } else if (cell == '0') {
                    button.setBackground(new Color(0, 0, 102));
                    button.setText("0");
                }
            }
        }
        
    }
        
       
        
    
    
    
    public void gamePlay (String coordinates){
        // calls the gameplaying function when button is clicked
     
            
            System.out.println("Player's turn to attack:");
            Away.playGame(boardSize, coordinates);
            
            System.out.println("Computer's turn to attack:");
            Home.playGame(boardSize, coordinates);
            
            //System.out.println("Place Ships");
            
            
            game = Home.hasUndetectedShips() && Away.hasUndetectedShips();

          }
    

private void displayGameResults() {
    BattleshipDatabase database = new BattleshipDatabase();
    List<String> results = database.getGameResults();
    
    // Create a new JFrame to display results
    JFrame resultsFrame = new JFrame("Game Results");
    resultsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    resultsFrame.setSize(300, 300);
    
    JTextArea textArea = new JTextArea();
    textArea.setEditable(false);
    
    // Add the results to the text area
    for (String result : results) {
        textArea.append(result + "\n");
    }
    
    // Add text area to frame
    resultsFrame.add(new JScrollPane(textArea));
    resultsFrame.setVisible(true);
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        panel5 = new java.awt.Panel();
        panel6 = new java.awt.Panel();
        label5 = new java.awt.Label();
        label8 = new java.awt.Label();
        label6 = new java.awt.Label();
        panel3 = new java.awt.Panel();
        HomeBoard = new java.awt.Panel();
        label23 = new java.awt.Label();
        label34 = new java.awt.Label();
        label25 = new java.awt.Label();
        label26 = new java.awt.Label();
        label27 = new java.awt.Label();
        label28 = new java.awt.Label();
        label29 = new java.awt.Label();
        label30 = new java.awt.Label();
        label31 = new java.awt.Label();
        label32 = new java.awt.Label();
        label42 = new java.awt.Label();
        HomeA1 = new javax.swing.JButton();
        HomeB1 = new javax.swing.JButton();
        HomeC1 = new javax.swing.JButton();
        HomeD1 = new javax.swing.JButton();
        HomeE1 = new javax.swing.JButton();
        HomeF1 = new javax.swing.JButton();
        HomeG1 = new javax.swing.JButton();
        HomeH1 = new javax.swing.JButton();
        HomeI1 = new javax.swing.JButton();
        label35 = new java.awt.Label();
        HomeA2 = new javax.swing.JButton();
        HomeB2 = new javax.swing.JButton();
        HomeC2 = new javax.swing.JButton();
        HomeD2 = new javax.swing.JButton();
        HomeE2 = new javax.swing.JButton();
        HomeF2 = new javax.swing.JButton();
        HomeG2 = new javax.swing.JButton();
        HomeH2 = new javax.swing.JButton();
        HomeI2 = new javax.swing.JButton();
        label24 = new java.awt.Label();
        HomeA3 = new javax.swing.JButton();
        HomeB3 = new javax.swing.JButton();
        HomeC3 = new javax.swing.JButton();
        HomeD3 = new javax.swing.JButton();
        HomeE3 = new javax.swing.JButton();
        HomeF3 = new javax.swing.JButton();
        HomeG3 = new javax.swing.JButton();
        HomeH3 = new javax.swing.JButton();
        HomeI3 = new javax.swing.JButton();
        label36 = new java.awt.Label();
        HomeA4 = new javax.swing.JButton();
        HomeB4 = new javax.swing.JButton();
        HomeC4 = new javax.swing.JButton();
        HomeD4 = new javax.swing.JButton();
        HomeE4 = new javax.swing.JButton();
        HomeF4 = new javax.swing.JButton();
        HomeG4 = new javax.swing.JButton();
        HomeH4 = new javax.swing.JButton();
        HomeI4 = new javax.swing.JButton();
        label37 = new java.awt.Label();
        HomeA5 = new javax.swing.JButton();
        HomeB5 = new javax.swing.JButton();
        HomeC5 = new javax.swing.JButton();
        HomeD5 = new javax.swing.JButton();
        HomeE5 = new javax.swing.JButton();
        HomeF5 = new javax.swing.JButton();
        HomeG5 = new javax.swing.JButton();
        HomeH5 = new javax.swing.JButton();
        HomeI5 = new javax.swing.JButton();
        label38 = new java.awt.Label();
        HomeA6 = new javax.swing.JButton();
        HomeB6 = new javax.swing.JButton();
        HomeC6 = new javax.swing.JButton();
        HomeD6 = new javax.swing.JButton();
        HomeE6 = new javax.swing.JButton();
        HomeF6 = new javax.swing.JButton();
        HomeG6 = new javax.swing.JButton();
        HomeH6 = new javax.swing.JButton();
        HomeI6 = new javax.swing.JButton();
        label39 = new java.awt.Label();
        HomeA7 = new javax.swing.JButton();
        HomeB7 = new javax.swing.JButton();
        HomeC7 = new javax.swing.JButton();
        HomeD7 = new javax.swing.JButton();
        HomeE7 = new javax.swing.JButton();
        HomeF7 = new javax.swing.JButton();
        HomeG7 = new javax.swing.JButton();
        HomeH7 = new javax.swing.JButton();
        HomeI7 = new javax.swing.JButton();
        label40 = new java.awt.Label();
        HomeA8 = new javax.swing.JButton();
        HomeB8 = new javax.swing.JButton();
        HomeC8 = new javax.swing.JButton();
        HomeD8 = new javax.swing.JButton();
        HomeE8 = new javax.swing.JButton();
        HomeF8 = new javax.swing.JButton();
        HomeG8 = new javax.swing.JButton();
        HomeH8 = new javax.swing.JButton();
        HomeI8 = new javax.swing.JButton();
        label43 = new java.awt.Label();
        HomeA9 = new javax.swing.JButton();
        HomeB9 = new javax.swing.JButton();
        HomeC9 = new javax.swing.JButton();
        HomeD9 = new javax.swing.JButton();
        HomeE9 = new javax.swing.JButton();
        HomeF9 = new javax.swing.JButton();
        HomeG9 = new javax.swing.JButton();
        HomeH9 = new javax.swing.JButton();
        HomeI9 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        AwayBoard = new java.awt.Panel();
        label44 = new java.awt.Label();
        label45 = new java.awt.Label();
        label46 = new java.awt.Label();
        label47 = new java.awt.Label();
        label48 = new java.awt.Label();
        label49 = new java.awt.Label();
        label50 = new java.awt.Label();
        label51 = new java.awt.Label();
        label52 = new java.awt.Label();
        label53 = new java.awt.Label();
        label55 = new java.awt.Label();
        AwayA1 = new javax.swing.JButton();
        AwayB1 = new javax.swing.JButton();
        AwayC1 = new javax.swing.JButton();
        AwayD1 = new javax.swing.JButton();
        AwayE1 = new javax.swing.JButton();
        AwayF1 = new javax.swing.JButton();
        AwayG1 = new javax.swing.JButton();
        AwayH1 = new javax.swing.JButton();
        AwayI1 = new javax.swing.JButton();
        label56 = new java.awt.Label();
        AwayA2 = new javax.swing.JButton();
        AwayB2 = new javax.swing.JButton();
        AwayC2 = new javax.swing.JButton();
        AwayD2 = new javax.swing.JButton();
        AwayE2 = new javax.swing.JButton();
        AwayF2 = new javax.swing.JButton();
        AwayG2 = new javax.swing.JButton();
        AwayH2 = new javax.swing.JButton();
        AwayI2 = new javax.swing.JButton();
        label57 = new java.awt.Label();
        AwayA3 = new javax.swing.JButton();
        AwayB3 = new javax.swing.JButton();
        AwayC3 = new javax.swing.JButton();
        AwayD3 = new javax.swing.JButton();
        AwayE3 = new javax.swing.JButton();
        AwayF3 = new javax.swing.JButton();
        AwayG3 = new javax.swing.JButton();
        AwayH3 = new javax.swing.JButton();
        AwayI3 = new javax.swing.JButton();
        label58 = new java.awt.Label();
        AwayA4 = new javax.swing.JButton();
        AwayB4 = new javax.swing.JButton();
        AwayC4 = new javax.swing.JButton();
        AwayD4 = new javax.swing.JButton();
        AwayE4 = new javax.swing.JButton();
        AwayF4 = new javax.swing.JButton();
        AwayG4 = new javax.swing.JButton();
        AwayH4 = new javax.swing.JButton();
        AwayI4 = new javax.swing.JButton();
        label59 = new java.awt.Label();
        AwayA5 = new javax.swing.JButton();
        AwayB5 = new javax.swing.JButton();
        AwayC5 = new javax.swing.JButton();
        AwayD5 = new javax.swing.JButton();
        AwayE5 = new javax.swing.JButton();
        AwayF5 = new javax.swing.JButton();
        AwayG5 = new javax.swing.JButton();
        AwayH5 = new javax.swing.JButton();
        AwayI5 = new javax.swing.JButton();
        label60 = new java.awt.Label();
        AwayA6 = new javax.swing.JButton();
        AwayB6 = new javax.swing.JButton();
        AwayC6 = new javax.swing.JButton();
        AwayD6 = new javax.swing.JButton();
        AwayE6 = new javax.swing.JButton();
        AwayF6 = new javax.swing.JButton();
        AwayG6 = new javax.swing.JButton();
        AwayH6 = new javax.swing.JButton();
        AwayI6 = new javax.swing.JButton();
        label61 = new java.awt.Label();
        AwayA7 = new javax.swing.JButton();
        AwayB7 = new javax.swing.JButton();
        AwayC7 = new javax.swing.JButton();
        AwayD7 = new javax.swing.JButton();
        AwayE7 = new javax.swing.JButton();
        AwayF7 = new javax.swing.JButton();
        AwayG7 = new javax.swing.JButton();
        AwayH7 = new javax.swing.JButton();
        AwayI7 = new javax.swing.JButton();
        label62 = new java.awt.Label();
        AwayA8 = new javax.swing.JButton();
        AwayB8 = new javax.swing.JButton();
        AwayC8 = new javax.swing.JButton();
        AwayD8 = new javax.swing.JButton();
        AwayE8 = new javax.swing.JButton();
        AwayF8 = new javax.swing.JButton();
        AwayG8 = new javax.swing.JButton();
        AwayH8 = new javax.swing.JButton();
        AwayI8 = new javax.swing.JButton();
        label63 = new java.awt.Label();
        AwayA9 = new javax.swing.JButton();
        AwayB9 = new javax.swing.JButton();
        AwayC9 = new javax.swing.JButton();
        AwayD9 = new javax.swing.JButton();
        AwayE9 = new javax.swing.JButton();
        AwayF9 = new javax.swing.JButton();
        AwayG9 = new javax.swing.JButton();
        AwayH9 = new javax.swing.JButton();
        AwayI9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        viewreultsbutton = new javax.swing.JButton();
        InstructionText = new javax.swing.JTextField();
        ExitButton = new javax.swing.JButton();

        jPopupMenu1.setBackground(new java.awt.Color(0, 0, 102));

        jMenuItem1.setBackground(new java.awt.Color(0, 0, 102));
        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("YOU WIN!!!");
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 102));
        setResizable(false);
        setSize(new java.awt.Dimension(1094, 666));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        panel5.setLayout(new java.awt.GridBagLayout());

        panel6.setBackground(new java.awt.Color(0, 0, 102));
        panel6.setForeground(new java.awt.Color(255, 255, 255));
        panel6.setPreferredSize(new java.awt.Dimension(1200, 100));
        panel6.setLayout(new java.awt.GridLayout(1, 3));

        label5.setAlignment(java.awt.Label.CENTER);
        label5.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label5.setForeground(new java.awt.Color(255, 255, 255));
        label5.setMinimumSize(new java.awt.Dimension(400, 51));
        label5.setText("HOME");
        panel6.add(label5);

        label8.setAlignment(java.awt.Label.CENTER);
        label8.setFont(new java.awt.Font("Dialog", 1, 32)); // NOI18N
        label8.setForeground(new java.awt.Color(255, 255, 255));
        label8.setMinimumSize(new java.awt.Dimension(400, 51));
        label8.setText("BATTLE SHIPS EXTREME!");
        panel6.add(label8);

        label6.setAlignment(java.awt.Label.CENTER);
        label6.setFont(new java.awt.Font("Dialog", 1, 32)); // NOI18N
        label6.setForeground(new java.awt.Color(255, 255, 255));
        label6.setMinimumSize(new java.awt.Dimension(400, 51));
        label6.setText("AWAY");
        panel6.add(label6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panel5.add(panel6, gridBagConstraints);

        panel3.setBackground(new java.awt.Color(0, 0, 102));
        panel3.setMaximumSize(new java.awt.Dimension(800, 80));
        panel3.setMinimumSize(new java.awt.Dimension(1200, 1200));
        panel3.setPreferredSize(new java.awt.Dimension(800, 500));
        panel3.setLayout(new javax.swing.BoxLayout(panel3, javax.swing.BoxLayout.LINE_AXIS));

        HomeBoard.setBackground(new java.awt.Color(0, 0, 102));
        HomeBoard.setPreferredSize(new java.awt.Dimension(540, 350));
        HomeBoard.setLayout(new java.awt.GridLayout(11, 11));
        HomeBoard.add(label23);

        label34.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label34.setForeground(new java.awt.Color(255, 255, 255));
        label34.setText(" A");
        HomeBoard.add(label34);

        label25.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label25.setForeground(new java.awt.Color(255, 255, 255));
        label25.setText(" B");
        HomeBoard.add(label25);

        label26.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label26.setForeground(new java.awt.Color(255, 255, 255));
        label26.setText(" C");
        HomeBoard.add(label26);

        label27.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label27.setForeground(new java.awt.Color(255, 255, 255));
        label27.setText(" D");
        HomeBoard.add(label27);

        label28.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label28.setForeground(new java.awt.Color(255, 255, 255));
        label28.setText(" E");
        HomeBoard.add(label28);

        label29.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label29.setForeground(new java.awt.Color(255, 255, 255));
        label29.setText(" F");
        HomeBoard.add(label29);

        label30.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label30.setForeground(new java.awt.Color(255, 255, 255));
        label30.setText(" G");
        HomeBoard.add(label30);

        label31.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label31.setForeground(new java.awt.Color(255, 255, 255));
        label31.setText(" H");
        HomeBoard.add(label31);

        label32.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label32.setForeground(new java.awt.Color(255, 255, 255));
        label32.setText("  I");
        HomeBoard.add(label32);

        label42.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label42.setForeground(new java.awt.Color(255, 255, 255));
        label42.setText("01");
        HomeBoard.add(label42);

        HomeA1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeA1.setText("~");
        HomeA1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeA1MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeA1);

        HomeB1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeB1.setText("~");
        HomeB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeB1MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeB1);

        HomeC1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeC1.setText("~");
        HomeC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeC1MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeC1);

        HomeD1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeD1.setText("~");
        HomeD1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeD1MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeD1);

        HomeE1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeE1.setText("~");
        HomeE1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeE1MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeE1);

        HomeF1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeF1.setText("~");
        HomeF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeF1MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeF1);

        HomeG1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeG1.setText("~");
        HomeG1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeG1MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeG1);

        HomeH1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeH1.setText("~");
        HomeH1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeH1MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeH1);

        HomeI1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeI1.setText("~");
        HomeI1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeI1MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeI1);

        label35.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label35.setForeground(new java.awt.Color(255, 255, 255));
        label35.setText("02");
        HomeBoard.add(label35);

        HomeA2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeA2.setText("~");
        HomeA2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeA2MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeA2);

        HomeB2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeB2.setText("~");
        HomeB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeB2MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeB2);

        HomeC2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeC2.setText("~");
        HomeC2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeC2MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeC2);

        HomeD2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeD2.setText("~");
        HomeD2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeD2MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeD2);

        HomeE2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeE2.setText("~");
        HomeE2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeE2MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeE2);

        HomeF2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeF2.setText("~");
        HomeF2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeF2MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeF2);

        HomeG2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeG2.setText("~");
        HomeG2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeG2MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeG2);

        HomeH2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeH2.setText("~");
        HomeH2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeH2MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeH2);

        HomeI2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeI2.setText("~");
        HomeI2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeI2MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeI2);

        label24.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label24.setForeground(new java.awt.Color(255, 255, 255));
        label24.setText("03");
        HomeBoard.add(label24);

        HomeA3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeA3.setText("~");
        HomeA3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeA3MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeA3);

        HomeB3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeB3.setText("~");
        HomeB3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeB3MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeB3);

        HomeC3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeC3.setText("~");
        HomeC3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeC3MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeC3);

        HomeD3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeD3.setText("~");
        HomeD3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeD3MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeD3);

        HomeE3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeE3.setText("~");
        HomeE3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeE3MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeE3);

        HomeF3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeF3.setText("~");
        HomeF3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeF3MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeF3);

        HomeG3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeG3.setText("~");
        HomeG3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeG3MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeG3);

        HomeH3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeH3.setText("~");
        HomeH3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeH3MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeH3);

        HomeI3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeI3.setText("~");
        HomeI3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeI3MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeI3);

        label36.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label36.setForeground(new java.awt.Color(255, 255, 255));
        label36.setText("04");
        HomeBoard.add(label36);

        HomeA4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeA4.setText("~");
        HomeA4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeA4MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeA4);

        HomeB4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeB4.setText("~");
        HomeB4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeB4MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeB4);

        HomeC4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeC4.setText("~");
        HomeC4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeC4MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeC4);

        HomeD4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeD4.setText("~");
        HomeD4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeD4MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeD4);

        HomeE4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeE4.setText("~");
        HomeE4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeE4MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeE4);

        HomeF4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeF4.setText("~");
        HomeF4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeF4MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeF4);

        HomeG4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeG4.setText("~");
        HomeG4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeG4MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeG4);

        HomeH4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeH4.setText("~");
        HomeH4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeH4MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeH4);

        HomeI4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeI4.setText("~");
        HomeI4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeI4MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeI4);

        label37.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label37.setForeground(new java.awt.Color(255, 255, 255));
        label37.setText("05");
        HomeBoard.add(label37);

        HomeA5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeA5.setText("~");
        HomeA5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeA5MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeA5);

        HomeB5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeB5.setText("~");
        HomeB5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeB5MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeB5);

        HomeC5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeC5.setText("~");
        HomeC5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeC5MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeC5);

        HomeD5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeD5.setText("~");
        HomeD5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeD5MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeD5);

        HomeE5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeE5.setText("~");
        HomeE5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeE5MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeE5);

        HomeF5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeF5.setText("~");
        HomeF5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeF5MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeF5);

        HomeG5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeG5.setText("~");
        HomeG5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeG5MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeG5);

        HomeH5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeH5.setText("~");
        HomeH5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeH5MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeH5);

        HomeI5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeI5.setText("~");
        HomeI5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeI5MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeI5);

        label38.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label38.setForeground(new java.awt.Color(255, 255, 255));
        label38.setText("06");
        HomeBoard.add(label38);

        HomeA6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeA6.setText("~");
        HomeA6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeA6MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeA6);

        HomeB6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeB6.setText("~");
        HomeB6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeB6MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeB6);

        HomeC6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeC6.setText("~");
        HomeC6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeC6MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeC6);

        HomeD6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeD6.setText("~");
        HomeD6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeD6MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeD6);

        HomeE6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeE6.setText("~");
        HomeE6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeE6MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeE6);

        HomeF6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeF6.setText("~");
        HomeF6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeF6MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeF6);

        HomeG6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeG6.setText("~");
        HomeG6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeG6MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeG6);

        HomeH6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeH6.setText("~");
        HomeH6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeH6MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeH6);

        HomeI6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeI6.setText("~");
        HomeI6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeI6MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeI6);

        label39.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label39.setForeground(new java.awt.Color(255, 255, 255));
        label39.setText("07");
        HomeBoard.add(label39);

        HomeA7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeA7.setText("~");
        HomeA7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeA7MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeA7);

        HomeB7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeB7.setText("~");
        HomeB7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeB7MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeB7);

        HomeC7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeC7.setText("~");
        HomeC7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeC7MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeC7);

        HomeD7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeD7.setText("~");
        HomeD7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeD7MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeD7);

        HomeE7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeE7.setText("~");
        HomeE7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeE7MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeE7);

        HomeF7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeF7.setText("~");
        HomeF7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeF7MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeF7);

        HomeG7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeG7.setText("~");
        HomeG7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeG7MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeG7);

        HomeH7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeH7.setText("~");
        HomeH7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeH7MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeH7);

        HomeI7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeI7.setText("~");
        HomeI7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeI7MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeI7);

        label40.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label40.setForeground(new java.awt.Color(255, 255, 255));
        label40.setText("08");
        HomeBoard.add(label40);

        HomeA8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeA8.setText("~");
        HomeA8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeA8MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeA8);

        HomeB8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeB8.setText("~");
        HomeB8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeB8MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeB8);

        HomeC8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeC8.setText("~");
        HomeC8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeC8MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeC8);

        HomeD8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeD8.setText("~");
        HomeD8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeD8MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeD8);

        HomeE8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeE8.setText("~");
        HomeE8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeE8MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeE8);

        HomeF8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeF8.setText("~");
        HomeF8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeF8MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeF8);

        HomeG8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeG8.setText("~");
        HomeG8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeG8MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeG8);

        HomeH8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeH8.setText("~");
        HomeH8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeH8MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeH8);

        HomeI8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeI8.setText("~");
        HomeI8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeI8MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeI8);

        label43.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label43.setForeground(new java.awt.Color(255, 255, 255));
        label43.setText("09");
        HomeBoard.add(label43);

        HomeA9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeA9.setText("~");
        HomeA9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeA9MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeA9);

        HomeB9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeB9.setText("~");
        HomeB9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeB9MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeB9);

        HomeC9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeC9.setText("~");
        HomeC9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeC9MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeC9);

        HomeD9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeD9.setText("~");
        HomeD9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeD9MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeD9);

        HomeE9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeE9.setText("~");
        HomeE9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeE9MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeE9);

        HomeF9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeF9.setText("~");
        HomeF9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeF9MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeF9);

        HomeG9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeG9.setText("~");
        HomeG9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeG9MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeG9);

        HomeH9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeH9.setText("~");
        HomeH9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeH9MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeH9);

        HomeI9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeI9.setText("~");
        HomeI9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeI9MouseClicked(evt);
            }
        });
        HomeBoard.add(HomeI9);

        panel3.add(HomeBoard);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 102));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        panel3.add(jSeparator1);

        AwayBoard.setBackground(new java.awt.Color(0, 0, 102));
        AwayBoard.setPreferredSize(new java.awt.Dimension(540, 350));
        AwayBoard.setLayout(new java.awt.GridLayout(11, 11));
        AwayBoard.add(label44);

        label45.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label45.setForeground(new java.awt.Color(255, 255, 255));
        label45.setText(" A");
        AwayBoard.add(label45);

        label46.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label46.setForeground(new java.awt.Color(255, 255, 255));
        label46.setText(" B");
        AwayBoard.add(label46);

        label47.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label47.setForeground(new java.awt.Color(255, 255, 255));
        label47.setText(" C");
        AwayBoard.add(label47);

        label48.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label48.setForeground(new java.awt.Color(255, 255, 255));
        label48.setText(" D");
        AwayBoard.add(label48);

        label49.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label49.setForeground(new java.awt.Color(255, 255, 255));
        label49.setText(" E");
        AwayBoard.add(label49);

        label50.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label50.setForeground(new java.awt.Color(255, 255, 255));
        label50.setText(" F");
        AwayBoard.add(label50);

        label51.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label51.setForeground(new java.awt.Color(255, 255, 255));
        label51.setText(" G");
        AwayBoard.add(label51);

        label52.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label52.setForeground(new java.awt.Color(255, 255, 255));
        label52.setText(" H");
        AwayBoard.add(label52);

        label53.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label53.setForeground(new java.awt.Color(255, 255, 255));
        label53.setText("  I");
        AwayBoard.add(label53);

        label55.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label55.setForeground(new java.awt.Color(255, 255, 255));
        label55.setText("01");
        AwayBoard.add(label55);

        AwayA1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayA1.setText("~");
        AwayA1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayA1MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayA1);

        AwayB1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayB1.setText("~");
        AwayB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayB1MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayB1);

        AwayC1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayC1.setText("~");
        AwayC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayC1MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayC1);

        AwayD1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayD1.setText("~");
        AwayD1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayD1MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayD1);

        AwayE1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayE1.setText("~");
        AwayE1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayE1MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayE1);

        AwayF1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayF1.setText("~");
        AwayF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayF1MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayF1);

        AwayG1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayG1.setText("~");
        AwayG1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayG1MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayG1);

        AwayH1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayH1.setText("~");
        AwayH1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayH1MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayH1);

        AwayI1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayI1.setText("~");
        AwayI1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayI1MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayI1);

        label56.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label56.setForeground(new java.awt.Color(255, 255, 255));
        label56.setText("02");
        AwayBoard.add(label56);

        AwayA2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayA2.setText("~");
        AwayA2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayA2MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayA2);

        AwayB2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayB2.setText("~");
        AwayB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayB2MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayB2);

        AwayC2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayC2.setText("~");
        AwayC2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayC2MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayC2);

        AwayD2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayD2.setText("~");
        AwayD2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayD2MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayD2);

        AwayE2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayE2.setText("~");
        AwayE2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayE2MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayE2);

        AwayF2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayF2.setText("~");
        AwayF2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayF2MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayF2);

        AwayG2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayG2.setText("~");
        AwayG2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayG2MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayG2);

        AwayH2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayH2.setText("~");
        AwayH2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayH2MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayH2);

        AwayI2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayI2.setText("~");
        AwayI2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayI2MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayI2);

        label57.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label57.setForeground(new java.awt.Color(255, 255, 255));
        label57.setText("03");
        AwayBoard.add(label57);

        AwayA3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayA3.setText("~");
        AwayA3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayA3MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayA3);

        AwayB3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayB3.setText("~");
        AwayB3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayB3MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayB3);

        AwayC3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayC3.setText("~");
        AwayC3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayC3MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayC3);

        AwayD3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayD3.setText("~");
        AwayD3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayD3MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayD3);

        AwayE3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayE3.setText("~");
        AwayE3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayE3MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayE3);

        AwayF3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayF3.setText("~");
        AwayF3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayF3MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayF3);

        AwayG3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayG3.setText("~");
        AwayG3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayG3MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayG3);

        AwayH3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayH3.setText("~");
        AwayH3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayH3MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayH3);

        AwayI3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayI3.setText("~");
        AwayI3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayI3MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayI3);

        label58.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label58.setForeground(new java.awt.Color(255, 255, 255));
        label58.setText("04");
        AwayBoard.add(label58);

        AwayA4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayA4.setText("~");
        AwayA4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayA4MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayA4);

        AwayB4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayB4.setText("~");
        AwayB4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayB4MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayB4);

        AwayC4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayC4.setText("~");
        AwayC4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayC4MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayC4);

        AwayD4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayD4.setText("~");
        AwayD4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayD4MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayD4);

        AwayE4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayE4.setText("~");
        AwayE4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayE4MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayE4);

        AwayF4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayF4.setText("~");
        AwayF4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayF4MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayF4);

        AwayG4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayG4.setText("~");
        AwayG4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayG4MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayG4);

        AwayH4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayH4.setText("~");
        AwayH4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayH4MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayH4);

        AwayI4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayI4.setText("~");
        AwayI4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayI4MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayI4);

        label59.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label59.setForeground(new java.awt.Color(255, 255, 255));
        label59.setText("05");
        AwayBoard.add(label59);

        AwayA5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayA5.setText("~");
        AwayA5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayA5MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayA5);

        AwayB5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayB5.setText("~");
        AwayB5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayB5MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayB5);

        AwayC5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayC5.setText("~");
        AwayC5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayC5MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayC5);

        AwayD5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayD5.setText("~");
        AwayD5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayD5MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayD5);

        AwayE5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayE5.setText("~");
        AwayE5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayE5MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayE5);

        AwayF5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayF5.setText("~");
        AwayF5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayF5MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayF5);

        AwayG5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayG5.setText("~");
        AwayG5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayG5MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayG5);

        AwayH5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayH5.setText("~");
        AwayH5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayH5MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayH5);

        AwayI5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayI5.setText("~");
        AwayI5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayI5MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayI5);

        label60.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label60.setForeground(new java.awt.Color(255, 255, 255));
        label60.setText("06");
        AwayBoard.add(label60);

        AwayA6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayA6.setText("~");
        AwayA6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayA6MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayA6);

        AwayB6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayB6.setText("~");
        AwayB6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayB6MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayB6);

        AwayC6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayC6.setText("~");
        AwayC6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayC6MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayC6);

        AwayD6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayD6.setText("~");
        AwayD6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayD6MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayD6);

        AwayE6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayE6.setText("~");
        AwayE6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayE6MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayE6);

        AwayF6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayF6.setText("~");
        AwayF6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayF6MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayF6);

        AwayG6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayG6.setText("~");
        AwayG6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayG6MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayG6);

        AwayH6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayH6.setText("~");
        AwayH6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayH6MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayH6);

        AwayI6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayI6.setText("~");
        AwayI6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayI6MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayI6);

        label61.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label61.setForeground(new java.awt.Color(255, 255, 255));
        label61.setText("07");
        AwayBoard.add(label61);

        AwayA7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayA7.setText("~");
        AwayA7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayA7MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayA7);

        AwayB7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayB7.setText("~");
        AwayB7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayB7MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayB7);

        AwayC7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayC7.setText("~");
        AwayC7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayC7MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayC7);

        AwayD7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayD7.setText("~");
        AwayD7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayD7MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayD7);

        AwayE7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayE7.setText("~");
        AwayE7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayE7MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayE7);

        AwayF7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayF7.setText("~");
        AwayF7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayF7MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayF7);

        AwayG7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayG7.setText("~");
        AwayG7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayG7MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayG7);

        AwayH7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayH7.setText("~");
        AwayH7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayH7MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayH7);

        AwayI7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayI7.setText("~");
        AwayI7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayI7MouseClicked(evt);
            }
        });
        AwayI7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AwayI7ActionPerformed(evt);
            }
        });
        AwayBoard.add(AwayI7);

        label62.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label62.setForeground(new java.awt.Color(255, 255, 255));
        label62.setText("08");
        AwayBoard.add(label62);

        AwayA8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayA8.setText("~");
        AwayA8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayA8MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayA8);

        AwayB8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayB8.setText("~");
        AwayB8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayB8MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayB8);

        AwayC8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayC8.setText("~");
        AwayC8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayC8MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayC8);

        AwayD8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayD8.setText("~");
        AwayD8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayD8MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayD8);

        AwayE8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayE8.setText("~");
        AwayE8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayE8MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayE8);

        AwayF8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayF8.setText("~");
        AwayF8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayF8MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayF8);

        AwayG8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayG8.setText("~");
        AwayG8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayG8MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayG8);

        AwayH8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayH8.setText("~");
        AwayH8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayH8MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayH8);

        AwayI8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayI8.setText("~");
        AwayI8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayI8MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayI8);

        label63.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label63.setForeground(new java.awt.Color(255, 255, 255));
        label63.setText("09");
        AwayBoard.add(label63);

        AwayA9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayA9.setText("~");
        AwayA9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayA9MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayA9);

        AwayB9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayB9.setText("~");
        AwayB9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayB9MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayB9);

        AwayC9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayC9.setText("~");
        AwayC9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayC9MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayC9);

        AwayD9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayD9.setText("~");
        AwayD9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayD9MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayD9);

        AwayE9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayE9.setText("~");
        AwayE9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayE9MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayE9);

        AwayF9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayF9.setText("~");
        AwayF9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayF9MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayF9);

        AwayG9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayG9.setText("~");
        AwayG9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayG9MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayG9);

        AwayH9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayH9.setText("~");
        AwayH9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayH9MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayH9);

        AwayI9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AwayI9.setText("~");
        AwayI9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AwayI9MouseClicked(evt);
            }
        });
        AwayBoard.add(AwayI9);

        panel3.add(AwayBoard);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panel5.add(panel3, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 38));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        viewreultsbutton.setBackground(new java.awt.Color(0, 0, 153));
        viewreultsbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        viewreultsbutton.setForeground(new java.awt.Color(255, 255, 255));
        viewreultsbutton.setText("View Results");
        viewreultsbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewreultsbuttonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(viewreultsbutton, gridBagConstraints);

        InstructionText.setEditable(false);
        InstructionText.setBackground(new java.awt.Color(0, 0, 102));
        InstructionText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        InstructionText.setForeground(new java.awt.Color(255, 255, 255));
        InstructionText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: 10");
        InstructionText.setAutoscrolls(false);
        InstructionText.setPreferredSize(new java.awt.Dimension(730, 38));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        jPanel1.add(InstructionText, gridBagConstraints);

        ExitButton.setBackground(new java.awt.Color(255, 0, 0));
        ExitButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ExitButton.setForeground(new java.awt.Color(255, 255, 255));
        ExitButton.setText("EXIT");
        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 10.0;
        jPanel1.add(ExitButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel5.add(jPanel1, gridBagConstraints);

        getContentPane().add(panel5);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AwayI7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AwayI7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AwayI7ActionPerformed

    private void HomeA1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeA1MouseClicked
        // TODO add your handling code here:
        coordinates = "A1"; // Assigns coordiantes from button
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]); // checks game state at coordinates
        if (c != 'S'){ // makes sure the coordinates are not already selected
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount); // prints to system for debugging
        HomeA1.setBackground(Color.green); // formats grid for selected ships
        HomeA1.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount); // changes ship count
        }
        if (unplacedShipCount ==0){ // if all ships are placed changes instructions.
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeA1MouseClicked

    private void HomeB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeB1MouseClicked
        // TODO add your handling code here:
        coordinates = "B1";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeB1.setBackground(Color.green);
        HomeB1.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeB1MouseClicked

    private void HomeC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeC1MouseClicked
        // TODO add your handling code here:
        coordinates = "C1";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeC1.setBackground(Color.green);
        HomeC1.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
        }
    }//GEN-LAST:event_HomeC1MouseClicked

    private void HomeD1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeD1MouseClicked
        // TODO add your handling code here:
        coordinates = "D1";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeD1.setBackground(Color.green);
        HomeD1.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeD1MouseClicked

    private void HomeE1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeE1MouseClicked
        // TODO add your handling code here:
        coordinates = "E1";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeE1.setBackground(Color.green);
        HomeE1.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeE1MouseClicked

    private void HomeF1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeF1MouseClicked
        // TODO add your handling code here:
        coordinates = "F1";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeF1.setBackground(Color.green);
        HomeF1.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeF1MouseClicked

    private void HomeG1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeG1MouseClicked
        // TODO add your handling code here:
        coordinates = "G1";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeG1.setBackground(Color.green);
        HomeG1.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeG1MouseClicked

    private void HomeH1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeH1MouseClicked
        // TODO add your handling code here:
        coordinates = "H1";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeH1.setBackground(Color.green);
        HomeH1.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeH1MouseClicked

    private void HomeI1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeI1MouseClicked
        // TODO add your handling code here:
        coordinates = "I1";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeI1.setBackground(Color.green);
        HomeI1.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeI1MouseClicked

    private void HomeA2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeA2MouseClicked
        // TODO add your handling code here:
        coordinates = "A2";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeA2.setBackground(Color.green);
        HomeA2.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeA2MouseClicked

    private void HomeB2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeB2MouseClicked
        // TODO add your handling code here:
        coordinates = "B2";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeB2.setBackground(Color.green);
        HomeB2.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeB2MouseClicked

    private void HomeC2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeC2MouseClicked
        // TODO add your handling code here:
        coordinates = "C2";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeC2.setBackground(Color.green);
        HomeC2.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeC2MouseClicked

    private void HomeD2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeD2MouseClicked
        // TODO add your handling code here:
        coordinates = "D2";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeD2.setBackground(Color.green);
        HomeD2.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeD2MouseClicked

    private void HomeE2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeE2MouseClicked
        // TODO add your handling code here:
        coordinates = "E2";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeE2.setBackground(Color.green);
        HomeE2.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeE2MouseClicked

    private void HomeF2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeF2MouseClicked
        // TODO add your handling code here:
        coordinates = "F2";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeF2.setBackground(Color.green);
        HomeF2.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeF2MouseClicked

    private void HomeG2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeG2MouseClicked
        // TODO add your handling code here:
        coordinates = "G2";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeG2.setBackground(Color.green);
        HomeG2.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeG2MouseClicked

    private void HomeH2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeH2MouseClicked
        // TODO add your handling code here:
        coordinates = "H2";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeH2.setBackground(Color.green);
        HomeH2.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeH2MouseClicked

    private void HomeI2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeI2MouseClicked
        // TODO add your handling code here:
        coordinates = "I2";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeI2.setBackground(Color.green);
        HomeI2.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeI2MouseClicked

    private void HomeA3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeA3MouseClicked
        // TODO add your handling code here:
        coordinates = "A3";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeA3.setBackground(Color.green);
        HomeA3.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeA3MouseClicked

    private void HomeB3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeB3MouseClicked
        // TODO add your handling code here:
        coordinates = "B3";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeB3.setBackground(Color.green);
        HomeB3.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeB3MouseClicked

    private void HomeC3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeC3MouseClicked
        // TODO add your handling code here:
        coordinates = "C3";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeC3.setBackground(Color.green);
        HomeC3.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeC3MouseClicked

    private void HomeD3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeD3MouseClicked
        // TODO add your handling code here:
        coordinates = "D3";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeD3.setBackground(Color.green);
        HomeD3.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
       InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeD3MouseClicked

    private void HomeE3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeE3MouseClicked
        // TODO add your handling code here:
        coordinates = "E3";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeE3.setBackground(Color.green);
        HomeE3.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeE3MouseClicked

    private void HomeF3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeF3MouseClicked
        // TODO add your handling code here:
        coordinates = "F3";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeF3.setBackground(Color.green);
        HomeF3.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeF3MouseClicked

    private void HomeG3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeG3MouseClicked
        // TODO add your handling code here:
        coordinates = "G3";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeG3.setBackground(Color.green);
        HomeG3.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeG3MouseClicked

    private void HomeH3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeH3MouseClicked
        // TODO add your handling code here:
        coordinates = "H3";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeH3.setBackground(Color.green);
        HomeH3.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeH3MouseClicked

    private void HomeI3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeI3MouseClicked
        // TODO add your handling code here:
        coordinates = "I3";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeI3.setBackground(Color.green);
        HomeI3.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeI3MouseClicked

    private void AwayA1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayA1MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){ // runs if all ships are placed only
        
        coordinates = "A1"; // assigns coordinates from button
        gamePlay(coordinates); // plays game using coordinates
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayA1.setText(status); // changes board for game state
        if (c == '0'){
            AwayA1.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayA1.setBackground(Color.RED);
            undetectedShipCount --;
            InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
            
        }
        
        gameUpdator();
        }
               
    }//GEN-LAST:event_AwayA1MouseClicked

    private void AwayB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayB1MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
            //gameUpdator();
        coordinates = "B1";
        gamePlay(coordinates);
        int row = (coordinates.charAt(1) - '1');
        int col = (coordinates.charAt(0) - 'A');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayB1.setText(status);
        if (c == '0'){
            AwayB1.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayB1.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayB1MouseClicked

    private void AwayC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayC1MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
            //gameUpdator();
        coordinates = "C1";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayC1.setText(status);
        if (c == '0'){
            AwayC1.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayC1.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayC1MouseClicked

    private void AwayD1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayD1MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
            //gameUpdator();
        coordinates = "D1";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayD1.setText(status);
        if (c == '0'){
            AwayD1.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayD1.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayD1MouseClicked

    private void AwayE1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayE1MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
            //gameUpdator();
        coordinates = "E1";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayE1.setText(status);
        if (c == '0'){
            AwayE1.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayE1.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayE1MouseClicked

    private void AwayF1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayF1MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
            //gameUpdator();
        coordinates = "F1";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayF1.setText(status);
        if (c == '0'){
            AwayF1.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayF1.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayF1MouseClicked

    private void AwayG1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayG1MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
            //gameUpdator();
        coordinates = "G1";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayG1.setText(status);
        if (c == '0'){
            AwayG1.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayG1.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayG1MouseClicked

    private void AwayH1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayH1MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
            //gameUpdator();
        coordinates = "H1";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayH1.setText(status);
        if (c == '0'){
            AwayH1.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayH1.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayH1MouseClicked

    private void AwayI1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayI1MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
            //gameUpdator();
        coordinates = "I1";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayI1.setText(status);
        if (c == '0'){
            AwayI1.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayI1.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayI1MouseClicked

    private void AwayA2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayA2MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "A2";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayA2.setText(status);
        if (c == '0'){
            AwayA2.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayA2.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayA2MouseClicked

    private void AwayB2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayB2MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "B2";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayB2.setText(status);
        if (c == '0'){
            AwayB2.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayB2.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayB2MouseClicked

    private void AwayC2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayC2MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "C2";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayC2.setText(status);
        if (c == '0'){
            AwayC2.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayC2.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayC2MouseClicked

    private void AwayD2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayD2MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "D2";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayD2.setText(status);
        if (c == '0'){
            AwayD2.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayD2.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayD2MouseClicked

    private void AwayE2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayE2MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "E2";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayE2.setText(status);
        if (c == '0'){
            AwayE2.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayE2.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayE2MouseClicked

    private void AwayF2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayF2MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "F2";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayF2.setText(status);
        if (c == '0'){
            AwayF2.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayF2.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayF2MouseClicked

    private void AwayG2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayG2MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "G2";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayG2.setText(status);
        if (c == '0'){
            AwayG2.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayG2.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayG2MouseClicked

    private void AwayH2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayH2MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "H2";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayH2.setText(status);
        if (c == '0'){
            AwayH2.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayH2.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayH2MouseClicked

    private void AwayI2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayI2MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "I2";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayI2.setText(status);
        if (c == '0'){
            AwayI2.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayI2.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayI2MouseClicked

    private void AwayA3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayA3MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "A3";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayA3.setText(status);
        if (c == '0'){
            AwayA3.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayA3.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayA3MouseClicked

    private void AwayB3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayB3MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "B3";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayB3.setText(status);
        if (c == '0'){
            AwayB3.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayB3.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayB3MouseClicked

    private void AwayC3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayC3MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "C3";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayC3.setText(status);
        if (c == '0'){
            AwayC3.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayC3.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayC3MouseClicked

    private void AwayD3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayD3MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "D3";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayD3.setText(status);
        if (c == '0'){
            AwayD3.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayD3.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayD3MouseClicked

    private void AwayE3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayE3MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "E3";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayE3.setText(status);
        if (c == '0'){
            AwayE3.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayE3.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayE3MouseClicked

    private void AwayF3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayF3MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "F3";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayF3.setText(status);
        if (c == '0'){
            AwayF3.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayF3.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayF3MouseClicked

    private void AwayG3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayG3MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "G3";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayG3.setText(status);
        if (c == '0'){
            AwayG3.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayG3.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayG3MouseClicked

    private void AwayH3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayH3MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "H3";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayH3.setText(status);
        if (c == '0'){
            AwayH3.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayH3.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayH3MouseClicked

    private void AwayI3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayI3MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "I3";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayI3.setText(status);
        if (c == '0'){
            AwayI3.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayI3.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayI3MouseClicked

    private void AwayA4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayA4MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "A4";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayA4.setText(status);
        if (c == '0'){
            AwayA4.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayA4.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayA4MouseClicked

    private void AwayB4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayB4MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "B4";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayB4.setText(status);
        if (c == '0'){
            AwayB4.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayB4.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayB4MouseClicked

    private void AwayC4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayC4MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "C4";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayC4.setText(status);
        if (c == '0'){
            AwayC4.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayC4.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
            
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayC4MouseClicked

    private void AwayD4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayD4MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "D4";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayD4.setText(status);
        if (c == '0'){
            AwayD4.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayD4.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayD4MouseClicked

    private void AwayE4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayE4MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "E4";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayE4.setText(status);
        if (c == '0'){
            AwayE4.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayE4.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayE4MouseClicked

    private void AwayF4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayF4MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "F4";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayF4.setText(status);
        if (c == '0'){
            AwayF4.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayF4.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayF4MouseClicked

    private void AwayG4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayG4MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "G4";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayG4.setText(status);
        if (c == '0'){
            AwayG4.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayG4.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayG4MouseClicked

    private void AwayH4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayH4MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "H4";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayH4.setText(status);
        if (c == '0'){
            AwayH4.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayH4.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayH4MouseClicked

    private void AwayI4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayI4MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "I4";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayI4.setText(status);
        if (c == '0'){
            AwayI4.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayI4.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayI4MouseClicked

    private void AwayA5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayA5MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "A5";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayA5.setText(status);
        if (c == '0'){
            AwayA5.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayA5.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayA5MouseClicked

    private void AwayB5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayB5MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "B5";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayB5.setText(status);
        if (c == '0'){
            AwayB5.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayB5.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayB5MouseClicked

    private void AwayC5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayC5MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "C5";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayC5.setText(status);
        if (c == '0'){
            AwayC5.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayC5.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayC5MouseClicked

    private void AwayD5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayD5MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "D5";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayD5.setText(status);
        if (c == '0'){
            AwayD5.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayD5.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayD5MouseClicked

    private void AwayE5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayE5MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "E5";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayE5.setText(status);
        if (c == '0'){
            AwayE5.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayE5.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayE5MouseClicked

    private void AwayF5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayF5MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "F5";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayF5.setText(status);
        if (c == '0'){
            AwayF5.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayF5.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayF5MouseClicked

    private void AwayG5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayG5MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "G5";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayG5.setText(status);
        if (c == '0'){
            AwayG5.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayG5.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayG5MouseClicked

    private void AwayH5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayH5MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "H5";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayH5.setText(status);
        if (c == '0'){
            AwayH5.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayH5.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayH5MouseClicked

    private void AwayI5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayI5MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
         coordinates = "I5";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayI5.setText(status);
        if (c == '0'){
            AwayI5.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayI5.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayI5MouseClicked

    private void AwayA6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayA6MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "A6";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayA6.setText(status);
        if (c == '0'){
            AwayA6.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayA6.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayA6MouseClicked

    private void AwayB6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayB6MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "B6";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayB6.setText(status);
        if (c == '0'){
            AwayB6.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayB6.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayB6MouseClicked

    private void AwayC6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayC6MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "C6";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayC6.setText(status);
        if (c == '0'){
            AwayC6.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayC6.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayC6MouseClicked

    private void AwayD6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayD6MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "D6";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayD6.setText(status);
        if (c == '0'){
            AwayD6.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayD6.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayD6MouseClicked

    private void AwayE6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayE6MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "E6";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayE6.setText(status);
        if (c == '0'){
            AwayE6.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayE6.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayE6MouseClicked

    private void AwayF6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayF6MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "F6";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayF6.setText(status);
        if (c == '0'){
            AwayF6.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayF6.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayF6MouseClicked

    private void AwayG6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayG6MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "G6";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayG6.setText(status);
        if (c == '0'){
            AwayG6.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayG6.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayG6MouseClicked

    private void AwayH6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayH6MouseClicked
        // TODO add your handling code here:\
        if (unplacedShipCount == 0){
          coordinates = "H6";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayH6.setText(status);
        if (c == '0'){
            AwayH6.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayH6.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayH6MouseClicked

    private void AwayI6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayI6MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "I6";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayI6.setText(status);
        if (c == '0'){
            AwayI6.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayI6.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayI6MouseClicked

    private void AwayA7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayA7MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "A7";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayA7.setText(status);
        if (c == '0'){
            AwayA7.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayA7.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayA7MouseClicked

    private void AwayB7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayB7MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "B7";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayB7.setText(status);
        if (c == '0'){
            AwayB7.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayB7.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayB7MouseClicked

    private void AwayC7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayC7MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "C7";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayC7.setText(status);
        if (c == '0'){
            AwayC7.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayC7.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayC7MouseClicked

    private void AwayD7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayD7MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "D7";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayD7.setText(status);
        if (c == '0'){
            AwayD7.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayD7.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayD7MouseClicked

    private void AwayE7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayE7MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "E7";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayE7.setText(status);
        if (c == '0'){
            AwayE7.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayE7.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayE7MouseClicked

    private void AwayF7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayF7MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "F7";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayF7.setText(status);
        if (c == '0'){
            AwayF7.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayF7.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayF7MouseClicked

    private void AwayG7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayG7MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "G7";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayG7.setText(status);
        if (c == '0'){
            AwayG7.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayG7.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayG7MouseClicked

    private void AwayH7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayH7MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "H7";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayH7.setText(status);
        if (c == '0'){
            AwayH7.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayH7.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayH7MouseClicked

    private void AwayI7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayI7MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "I7";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayI7.setText(status);
        if (c == '0'){
            AwayI7.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayI7.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayI7MouseClicked

    private void AwayA8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayA8MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "A8";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayA8.setText(status);
        if (c == '0'){
            AwayA8.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayA8.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayA8MouseClicked

    private void AwayB8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayB8MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "B8";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayB8.setText(status);
        if (c == '0'){
            AwayB8.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayB8.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayB8MouseClicked

    private void AwayC8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayC8MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "C8";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayC8.setText(status);
        if (c == '0'){
            AwayC8.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayC8.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayC8MouseClicked

    private void AwayD8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayD8MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "D8";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayD8.setText(status);
        if (c == '0'){
            AwayD8.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayD8.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayD8MouseClicked

    private void AwayE8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayE8MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "E8";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayE8.setText(status);
        if (c == '0'){
            AwayE8.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayE8.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayE8MouseClicked

    private void AwayF8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayF8MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "F8";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayF8.setText(status);
        if (c == '0'){
            AwayF8.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayF8.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayF8MouseClicked

    private void AwayG8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayG8MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "G8";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayG8.setText(status);
        if (c == '0'){
            AwayG8.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayG8.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayG8MouseClicked

    private void AwayH8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayH8MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "H8";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayH8.setText(status);
        if (c == '0'){
            AwayH8.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayH8.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayH8MouseClicked

    private void AwayI8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayI8MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "I8";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayI8.setText(status);
        if (c == '0'){
            AwayI8.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayI8.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayI8MouseClicked

    private void AwayA9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayA9MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "A9";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayA9.setText(status);
        if (c == '0'){
            AwayA9.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayA9.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayA9MouseClicked

    private void AwayB9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayB9MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "B9";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayB9.setText(status);
        if (c == '0'){
            AwayB9.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayB9.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayB9MouseClicked

    private void AwayC9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayC9MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "C9";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayC9.setText(status);
        if (c == '0'){
            AwayC9.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayC9.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayC9MouseClicked

    private void AwayD9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayD9MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "D9";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayD9.setText(status);
        if (c == '0'){
            AwayD9.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayD9.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayD9MouseClicked

    private void AwayE9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayE9MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "E9";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayE9.setText(status);
        if (c == '0'){
            AwayE9.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayE9.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayE9MouseClicked

    private void AwayF9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayF9MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "F9";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayF9.setText(status);
        if (c == '0'){
            AwayF9.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayF9.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayF9MouseClicked

    private void AwayG9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayG9MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "G9";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayG9.setText(status);
        if (c == '0'){
            AwayG9.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayG9.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayG9MouseClicked

    private void AwayH9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayH9MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "H9";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayH9.setText(status);
        if (c == '0'){
            AwayH9.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayH9.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayH9MouseClicked

    private void AwayI9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AwayI9MouseClicked
        // TODO add your handling code here:
        if (unplacedShipCount == 0){
          coordinates = "I9";
        gamePlay(coordinates);
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Away.board[row][col]);
        String status = Character.toString(c);
        System.out.println(status);
        AwayI9.setText(status);
        if (c == '0'){
            AwayI9.setBackground(new Color(0,0,102));
        }
        else if (c == 'X'){
            AwayI9.setBackground(Color.RED);
            undetectedShipCount --;
                    InstructionText.setText("Round: " + round + " Ships Left:"+ undetectedShipCount);
        }
        gameUpdator();
        }
    }//GEN-LAST:event_AwayI9MouseClicked

    private void HomeA4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeA4MouseClicked
        // TODO add your handling code here:
        coordinates = "A4";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeA4.setBackground(Color.green);
        HomeA4.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
        
    }
    }//GEN-LAST:event_HomeA4MouseClicked

    private void HomeB4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeB4MouseClicked
        // TODO add your handling code here:
        coordinates = "B4";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeB4.setBackground(Color.green);
        HomeB4.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
 
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
        
    }
    }//GEN-LAST:event_HomeB4MouseClicked

    private void HomeC4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeC4MouseClicked
        // TODO add your handling code here:
        coordinates = "C4";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeC4.setBackground(Color.green);
        HomeC4.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeC4MouseClicked

    private void HomeD4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeD4MouseClicked
        // TODO add your handling code here:
        coordinates = "D4";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeD4.setBackground(Color.green);
        HomeD4.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeD4MouseClicked

    private void HomeE4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeE4MouseClicked
        // TODO add your handling code here:
        coordinates = "E4";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeE4.setBackground(Color.green);
        HomeE4.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeE4MouseClicked

    private void HomeF4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeF4MouseClicked
        // TODO add your handling code here:
        coordinates = "F4";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeF4.setBackground(Color.green);
        HomeF4.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeF4MouseClicked

    private void HomeG4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeG4MouseClicked
        // TODO add your handling code here:
        coordinates = "G4";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeG4.setBackground(Color.green);
        HomeG4.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeG4MouseClicked

    private void HomeH4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeH4MouseClicked
        // TODO add your handling code here:
        coordinates = "H4";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeH4.setBackground(Color.green);
        HomeH4.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeH4MouseClicked

    private void HomeI4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeI4MouseClicked
        // TODO add your handling code here:
        coordinates = "I4";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeI4.setBackground(Color.green);
        HomeI4.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeI4MouseClicked

    private void HomeA5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeA5MouseClicked
        // TODO add your handling code here:
        coordinates = "A5";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeA5.setBackground(Color.green);
        HomeA5.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeA5MouseClicked

    private void HomeB5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeB5MouseClicked
        // TODO add your handling code here:
        coordinates = "B5";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeB5.setBackground(Color.green);
        HomeB5.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeB5MouseClicked

    private void HomeC5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeC5MouseClicked
        // TODO add your handling code here:
        coordinates = "C5";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeC5.setBackground(Color.green);
        HomeC5.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeC5MouseClicked

    private void HomeD5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeD5MouseClicked
        // TODO add your handling code here:
        coordinates = "D5";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeD5.setBackground(Color.green);
        HomeD5.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeD5MouseClicked

    private void HomeE5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeE5MouseClicked
        // TODO add your handling code here:
        coordinates = "E5";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeE5.setBackground(Color.green);
        HomeE5.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeE5MouseClicked

    private void HomeF5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeF5MouseClicked
        // TODO add your handling code here:
        coordinates = "F5";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeF5.setBackground(Color.green);
        HomeF5.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeF5MouseClicked

    private void HomeG5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeG5MouseClicked
        // TODO add your handling code here:
        coordinates = "G5";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeG5.setBackground(Color.green);
        HomeG5.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeG5MouseClicked

    private void HomeH5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeH5MouseClicked
        // TODO add your handling code here:
        coordinates = "H5";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeH5.setBackground(Color.green);
        HomeH5.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeH5MouseClicked

    private void HomeI5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeI5MouseClicked
        // TODO add your handling code here:
        coordinates = "I5";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeI5.setBackground(Color.green);
        HomeI5.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeI5MouseClicked

    private void HomeA6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeA6MouseClicked
        // TODO add your handling code here:
        coordinates = "A6";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeA6.setBackground(Color.green);
        HomeA6.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeA6MouseClicked

    private void HomeB6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeB6MouseClicked
        // TODO add your handling code here:
        coordinates = "B6";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeB6.setBackground(Color.green);
        HomeB6.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeB6MouseClicked

    private void HomeC6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeC6MouseClicked
        // TODO add your handling code here:
        coordinates = "C6";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeC6.setBackground(Color.green);
        HomeC6.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeC6MouseClicked

    private void HomeD6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeD6MouseClicked
        // TODO add your handling code here:
        coordinates = "D6";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeD6.setBackground(Color.green);
        HomeD6.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeD6MouseClicked

    private void HomeE6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeE6MouseClicked
        // TODO add your handling code here:
        coordinates = "E6";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeE6.setBackground(Color.green);
        HomeE6.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeE6MouseClicked

    private void HomeF6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeF6MouseClicked
        // TODO add your handling code here:
        coordinates = "F6";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeF6.setBackground(Color.green);
        HomeF6.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeF6MouseClicked

    private void HomeG6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeG6MouseClicked
        // TODO add your handling code here:
        coordinates = "G6";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeG6.setBackground(Color.green);
        HomeG6.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeG6MouseClicked

    private void HomeH6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeH6MouseClicked
        // TODO add your handling code here:
        coordinates = "H6";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeH6.setBackground(Color.green);
        HomeH6.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeH6MouseClicked

    private void HomeI6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeI6MouseClicked
        // TODO add your handling code here:
        coordinates = "I6";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeI6.setBackground(Color.green);
        HomeI6.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeI6MouseClicked

    private void HomeA7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeA7MouseClicked
        // TODO add your handling code here:
        coordinates = "A7";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeA7.setBackground(Color.green);
        HomeA7.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeA7MouseClicked

    private void HomeB7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeB7MouseClicked
        // TODO add your handling code here:
        coordinates = "B7";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeB7.setBackground(Color.green);
        HomeB7.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeB7MouseClicked

    private void HomeC7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeC7MouseClicked
        // TODO add your handling code here:
        coordinates = "C7";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeC7.setBackground(Color.green);
        HomeC7.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeC7MouseClicked

    private void HomeD7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeD7MouseClicked
        // TODO add your handling code here:
        coordinates = "D7";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeD7.setBackground(Color.green);
        HomeD7.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeD7MouseClicked

    private void HomeE7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeE7MouseClicked
        // TODO add your handling code here:
        coordinates = "E7";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeE7.setBackground(Color.green);
        HomeE7.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeE7MouseClicked

    private void HomeF7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeF7MouseClicked
        // TODO add your handling code here:
        coordinates = "F7";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeF7.setBackground(Color.green);
        HomeF7.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeF7MouseClicked

    private void HomeG7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeG7MouseClicked
        // TODO add your handling code here:
        coordinates = "G7";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeG7.setBackground(Color.green);
        HomeG7.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeG7MouseClicked

    private void HomeH7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeH7MouseClicked
        // TODO add your handling code here:
        coordinates = "H7";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeH7.setBackground(Color.green);
        HomeH7.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeH7MouseClicked

    private void HomeI7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeI7MouseClicked
        // TODO add your handling code here:
        coordinates = "I7";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeI7.setBackground(Color.green);
        HomeI7.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeI7MouseClicked

    private void HomeA8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeA8MouseClicked
        // TODO add your handling code here:
        coordinates = "A8";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeA8.setBackground(Color.green);
        HomeA8.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeA8MouseClicked

    private void HomeB8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeB8MouseClicked
        // TODO add your handling code here:
        coordinates = "B8";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeB8.setBackground(Color.green);
        HomeB8.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeB8MouseClicked

    private void HomeC8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeC8MouseClicked
        // TODO add your handling code here:
        coordinates = "C8";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeC8.setBackground(Color.green);
        HomeC8.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeC8MouseClicked

    private void HomeD8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeD8MouseClicked
        // TODO add your handling code here:
        coordinates = "D8";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeD8.setBackground(Color.green);
        HomeD8.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeD8MouseClicked

    private void HomeE8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeE8MouseClicked
        // TODO add your handling code here:
        coordinates = "E8";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeE8.setBackground(Color.green);
        HomeE8.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeE8MouseClicked

    private void HomeF8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeF8MouseClicked
        // TODO add your handling code here:
        coordinates = "F8";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeF8.setBackground(Color.green);
        HomeF8.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeF8MouseClicked

    private void HomeG8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeG8MouseClicked
        // TODO add your handling code here:
        coordinates = "G8";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeG8.setBackground(Color.green);
        HomeG8.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeG8MouseClicked

    private void HomeH8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeH8MouseClicked
        // TODO add your handling code here:
        coordinates = "H8";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeH8.setBackground(Color.green);
        HomeH8.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeH8MouseClicked

    private void HomeI8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeI8MouseClicked
        // TODO add your handling code here:
        coordinates = "I8";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeI8.setBackground(Color.green);
        HomeI8.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeI8MouseClicked

    private void HomeA9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeA9MouseClicked
        // TODO add your handling code here:
        coordinates = "A9";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeA9.setBackground(Color.green);
        HomeA9.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeA9MouseClicked

    private void HomeB9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeB9MouseClicked
        // TODO add your handling code here:
        coordinates = "B9";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeB9.setBackground(Color.green);
        HomeB9.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeB9MouseClicked

    private void HomeC9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeC9MouseClicked
        // TODO add your handling code here:
        coordinates = "C9";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeC9.setBackground(Color.green);
        HomeC9.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeC9MouseClicked

    private void HomeD9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeD9MouseClicked
        // TODO add your handling code here:
        coordinates = "D9";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeD9.setBackground(Color.green);
        HomeD9.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeD9MouseClicked

    private void HomeE9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeE9MouseClicked
        // TODO add your handling code here:
        coordinates = "E9";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeE9.setBackground(Color.green);
        HomeE9.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeE9MouseClicked

    private void HomeF9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeF9MouseClicked
        // TODO add your handling code here:
        coordinates = "F9";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeF9.setBackground(Color.green);
        HomeF9.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeF9MouseClicked

    private void HomeG9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeG9MouseClicked
        // TODO add your handling code here:
        coordinates = "G9";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeG9.setBackground(Color.green);
        HomeG9.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeG9MouseClicked

    private void HomeH9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeH9MouseClicked
        // TODO add your handling code here:
        coordinates = "H9";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeH9.setBackground(Color.green);
        HomeH9.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeH9MouseClicked

    private void HomeI9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeI9MouseClicked
        // TODO add your handling code here:
        coordinates = "I9";
        int col = (coordinates.charAt(0) - 'A');
        int row = (coordinates.charAt(1) - '1');
        char c = (Home.board[row][col]);
        if (c != 'S'){
        if (unplacedShipCount > 0){
            unplacedShipCount --;
            System.out.println(unplacedShipCount);
        HomeI9.setBackground(Color.green);
        HomeI9.setText("S");
        //HomeA1.setBackground(Color.red);
        System.out.println(coordinates);
        Home.placeShip(boardSize, shipCount, coordinates, game);
        InstructionText.setText("PLACE YOUR SHIPS! Ships left: " + unplacedShipCount);
        }
        if (unplacedShipCount ==0){
            InstructionText.setText("Round: " + round + " ATTACK!");
        }
    }
    }//GEN-LAST:event_HomeI9MouseClicked

    private void viewreultsbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewreultsbuttonMouseClicked
        displayGameResults();
    }//GEN-LAST:event_viewreultsbuttonMouseClicked

    private void ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(COMP604_GUI_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(COMP604_GUI_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(COMP604_GUI_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(COMP604_GUI_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new COMP604_GUI_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AwayA1;
    private javax.swing.JButton AwayA2;
    private javax.swing.JButton AwayA3;
    private javax.swing.JButton AwayA4;
    private javax.swing.JButton AwayA5;
    private javax.swing.JButton AwayA6;
    private javax.swing.JButton AwayA7;
    private javax.swing.JButton AwayA8;
    private javax.swing.JButton AwayA9;
    private javax.swing.JButton AwayB1;
    private javax.swing.JButton AwayB2;
    private javax.swing.JButton AwayB3;
    private javax.swing.JButton AwayB4;
    private javax.swing.JButton AwayB5;
    private javax.swing.JButton AwayB6;
    private javax.swing.JButton AwayB7;
    private javax.swing.JButton AwayB8;
    private javax.swing.JButton AwayB9;
    private java.awt.Panel AwayBoard;
    private javax.swing.JButton AwayC1;
    private javax.swing.JButton AwayC2;
    private javax.swing.JButton AwayC3;
    private javax.swing.JButton AwayC4;
    private javax.swing.JButton AwayC5;
    private javax.swing.JButton AwayC6;
    private javax.swing.JButton AwayC7;
    private javax.swing.JButton AwayC8;
    private javax.swing.JButton AwayC9;
    private javax.swing.JButton AwayD1;
    private javax.swing.JButton AwayD2;
    private javax.swing.JButton AwayD3;
    private javax.swing.JButton AwayD4;
    private javax.swing.JButton AwayD5;
    private javax.swing.JButton AwayD6;
    private javax.swing.JButton AwayD7;
    private javax.swing.JButton AwayD8;
    private javax.swing.JButton AwayD9;
    private javax.swing.JButton AwayE1;
    private javax.swing.JButton AwayE2;
    private javax.swing.JButton AwayE3;
    private javax.swing.JButton AwayE4;
    private javax.swing.JButton AwayE5;
    private javax.swing.JButton AwayE6;
    private javax.swing.JButton AwayE7;
    private javax.swing.JButton AwayE8;
    private javax.swing.JButton AwayE9;
    private javax.swing.JButton AwayF1;
    private javax.swing.JButton AwayF2;
    private javax.swing.JButton AwayF3;
    private javax.swing.JButton AwayF4;
    private javax.swing.JButton AwayF5;
    private javax.swing.JButton AwayF6;
    private javax.swing.JButton AwayF7;
    private javax.swing.JButton AwayF8;
    private javax.swing.JButton AwayF9;
    private javax.swing.JButton AwayG1;
    private javax.swing.JButton AwayG2;
    private javax.swing.JButton AwayG3;
    private javax.swing.JButton AwayG4;
    private javax.swing.JButton AwayG5;
    private javax.swing.JButton AwayG6;
    private javax.swing.JButton AwayG7;
    private javax.swing.JButton AwayG8;
    private javax.swing.JButton AwayG9;
    private javax.swing.JButton AwayH1;
    private javax.swing.JButton AwayH2;
    private javax.swing.JButton AwayH3;
    private javax.swing.JButton AwayH4;
    private javax.swing.JButton AwayH5;
    private javax.swing.JButton AwayH6;
    private javax.swing.JButton AwayH7;
    private javax.swing.JButton AwayH8;
    private javax.swing.JButton AwayH9;
    private javax.swing.JButton AwayI1;
    private javax.swing.JButton AwayI2;
    private javax.swing.JButton AwayI3;
    private javax.swing.JButton AwayI4;
    private javax.swing.JButton AwayI5;
    private javax.swing.JButton AwayI6;
    private javax.swing.JButton AwayI7;
    private javax.swing.JButton AwayI8;
    private javax.swing.JButton AwayI9;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton HomeA1;
    private javax.swing.JButton HomeA2;
    private javax.swing.JButton HomeA3;
    private javax.swing.JButton HomeA4;
    private javax.swing.JButton HomeA5;
    private javax.swing.JButton HomeA6;
    private javax.swing.JButton HomeA7;
    private javax.swing.JButton HomeA8;
    private javax.swing.JButton HomeA9;
    private javax.swing.JButton HomeB1;
    private javax.swing.JButton HomeB2;
    private javax.swing.JButton HomeB3;
    private javax.swing.JButton HomeB4;
    private javax.swing.JButton HomeB5;
    private javax.swing.JButton HomeB6;
    private javax.swing.JButton HomeB7;
    private javax.swing.JButton HomeB8;
    private javax.swing.JButton HomeB9;
    private java.awt.Panel HomeBoard;
    private javax.swing.JButton HomeC1;
    private javax.swing.JButton HomeC2;
    private javax.swing.JButton HomeC3;
    private javax.swing.JButton HomeC4;
    private javax.swing.JButton HomeC5;
    private javax.swing.JButton HomeC6;
    private javax.swing.JButton HomeC7;
    private javax.swing.JButton HomeC8;
    private javax.swing.JButton HomeC9;
    private javax.swing.JButton HomeD1;
    private javax.swing.JButton HomeD2;
    private javax.swing.JButton HomeD3;
    private javax.swing.JButton HomeD4;
    private javax.swing.JButton HomeD5;
    private javax.swing.JButton HomeD6;
    private javax.swing.JButton HomeD7;
    private javax.swing.JButton HomeD8;
    private javax.swing.JButton HomeD9;
    private javax.swing.JButton HomeE1;
    private javax.swing.JButton HomeE2;
    private javax.swing.JButton HomeE3;
    private javax.swing.JButton HomeE4;
    private javax.swing.JButton HomeE5;
    private javax.swing.JButton HomeE6;
    private javax.swing.JButton HomeE7;
    private javax.swing.JButton HomeE8;
    private javax.swing.JButton HomeE9;
    private javax.swing.JButton HomeF1;
    private javax.swing.JButton HomeF2;
    private javax.swing.JButton HomeF3;
    private javax.swing.JButton HomeF4;
    private javax.swing.JButton HomeF5;
    private javax.swing.JButton HomeF6;
    private javax.swing.JButton HomeF7;
    private javax.swing.JButton HomeF8;
    private javax.swing.JButton HomeF9;
    private javax.swing.JButton HomeG1;
    private javax.swing.JButton HomeG2;
    private javax.swing.JButton HomeG3;
    private javax.swing.JButton HomeG4;
    private javax.swing.JButton HomeG5;
    private javax.swing.JButton HomeG6;
    private javax.swing.JButton HomeG7;
    private javax.swing.JButton HomeG8;
    private javax.swing.JButton HomeG9;
    private javax.swing.JButton HomeH1;
    private javax.swing.JButton HomeH2;
    private javax.swing.JButton HomeH3;
    private javax.swing.JButton HomeH4;
    private javax.swing.JButton HomeH5;
    private javax.swing.JButton HomeH6;
    private javax.swing.JButton HomeH7;
    private javax.swing.JButton HomeH8;
    private javax.swing.JButton HomeH9;
    private javax.swing.JButton HomeI1;
    private javax.swing.JButton HomeI2;
    private javax.swing.JButton HomeI3;
    private javax.swing.JButton HomeI4;
    private javax.swing.JButton HomeI5;
    private javax.swing.JButton HomeI6;
    private javax.swing.JButton HomeI7;
    private javax.swing.JButton HomeI8;
    private javax.swing.JButton HomeI9;
    private javax.swing.JTextField InstructionText;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label label23;
    private java.awt.Label label24;
    private java.awt.Label label25;
    private java.awt.Label label26;
    private java.awt.Label label27;
    private java.awt.Label label28;
    private java.awt.Label label29;
    private java.awt.Label label30;
    private java.awt.Label label31;
    private java.awt.Label label32;
    private java.awt.Label label34;
    private java.awt.Label label35;
    private java.awt.Label label36;
    private java.awt.Label label37;
    private java.awt.Label label38;
    private java.awt.Label label39;
    private java.awt.Label label40;
    private java.awt.Label label42;
    private java.awt.Label label43;
    private java.awt.Label label44;
    private java.awt.Label label45;
    private java.awt.Label label46;
    private java.awt.Label label47;
    private java.awt.Label label48;
    private java.awt.Label label49;
    private java.awt.Label label5;
    private java.awt.Label label50;
    private java.awt.Label label51;
    private java.awt.Label label52;
    private java.awt.Label label53;
    private java.awt.Label label55;
    private java.awt.Label label56;
    private java.awt.Label label57;
    private java.awt.Label label58;
    private java.awt.Label label59;
    private java.awt.Label label6;
    private java.awt.Label label60;
    private java.awt.Label label61;
    private java.awt.Label label62;
    private java.awt.Label label63;
    private java.awt.Label label8;
    private java.awt.Panel panel3;
    private java.awt.Panel panel5;
    private java.awt.Panel panel6;
    private javax.swing.JButton viewreultsbutton;
    // End of variables declaration//GEN-END:variables
}
