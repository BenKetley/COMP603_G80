/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603_project2;

/**
 *
 * @author Rory
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BattleshipDatabase {
    
    BattleshipDataBaseManager dbManager;
    Connection conn;
    Statement statement;

    public BattleshipDatabase() {
        dbManager = new BattleshipDataBaseManager();
        conn = dbManager.getConnection();
        
        if (conn == null) {
            throw new IllegalStateException("Failed to establish database connection.");
        }

        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error creating statement: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        BattleshipDatabase sbs = new BattleshipDatabase();

        try {
            sbs.statement.addBatch("CREATE TABLE BattleShips (ShipPlacement INT, HIT VARCHAR(50), MISS VARCHAR(20))");
            sbs.statement.addBatch("INSERT INTO BattleShips (ShipPlacement, HIT, MISS) VALUES (1, 'False', 'True')");
            sbs.statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println("Batch execution error: " + ex.getMessage());
        }
        sbs.closeConnection();
    }

    public void closeConnection() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error closing statement: " + e.getMessage());
            }
        }
        dbManager.closeConnections();
    }
}
