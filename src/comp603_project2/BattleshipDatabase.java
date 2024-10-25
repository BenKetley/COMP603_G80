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
        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        BattleshipDatabase sbs = new BattleshipDatabase();

        try {
            sbs.statement.addBatch("CREATE  TABLE BOOK  (ShipPlacement  INT,   HIT   VARCHAR(50),   MISS   VARCHAR(20))");
            sbs.statement.addBatch("INSERT INTO BOOK VALUES (1, 'Slum Dog Millionaire', 'Fiction', 19.90),\n");
            sbs.statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        sbs.closeConnection();
    }

    public void closeConnection() {
        this.dbManager.closeConnections();
    }

}
