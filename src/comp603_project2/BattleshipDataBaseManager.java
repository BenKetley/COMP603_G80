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
import java.sql.DriverManager;
import java.sql.SQLException;

public class BattleshipDataBaseManager {

    private static final String USER_NAME = "";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:derby:BattleShipDB;create=true";

    Connection conn;

    public BattleshipDataBaseManager() {
        establishConnection();
    }

    public static void main(String[] args) {
        BattleshipDataBaseManager dbManager = new BattleshipDataBaseManager();
        System.out.println(dbManager.getConnection());
    }

    public Connection getConnection() {
        if (conn == null) {
            System.out.println("Connection not established.");
        }
        return this.conn;
    }

    // Establish connection
    public void establishConnection() {
        if (this.conn == null) {
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Connected successfully...");
            } catch (SQLException ex) {
                System.out.println("SQL Exception: " + ex.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Driver not found: " + e.getMessage());
            }
        }
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException ex) {
                System.out.println("Error closing connection: " + ex.getMessage());
            }
        }
    }
}

