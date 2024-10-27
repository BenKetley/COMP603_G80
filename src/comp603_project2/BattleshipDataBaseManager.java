package comp603_project2;

/**
 *
 * @author Rory
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BattleshipDataBaseManager {

    private static final String USER_NAME = "";//Database Username
    private static final String PASSWORD = "";//Database Password
    private static final String URL = "jdbc:derby:BattleShipDB;create=true";//url of embeded database

    Connection conn;

    public BattleshipDataBaseManager() {
        establishConnection(); //creates connection
    }

    public static void main(String[] args) {
        BattleshipDataBaseManager dbManager = new BattleshipDataBaseManager();
        System.out.println(dbManager.getConnection());
    }

    public Connection getConnection() {
        if (conn == null) {
            System.out.println("Connection not established."); //error if connection isnt established 
        }
        return this.conn;
    }


    public void establishConnection() { // Establish connection
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
   
    public void closeConnections() { //close connection
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
