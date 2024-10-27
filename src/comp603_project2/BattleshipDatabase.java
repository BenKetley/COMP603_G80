package comp603_project2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BattleshipDatabase {

    private BattleshipDataBaseManager dbManager;
    private Connection conn;

    public BattleshipDatabase() {
        dbManager = new BattleshipDataBaseManager();
        conn = dbManager.getConnection();

        if (conn == null) {
            throw new IllegalStateException("Failed to establish database connection.");
        }
        createTables(); // Call to create tables upon initialization
    }

    private void createTables() { //creates tables upon starting code
        createActionsTable();
        createGameResultsTable();
    }

    private void createActionsTable() { // Create BATTLESHIPACTIONS table if it doesn't exist
        try ( Statement stmt = conn.createStatement()) {     
            stmt.execute("CREATE TABLE BATTLESHIPACTIONS ("
                    + "ID,"
                    + "ActionType VARCHAR(50), "
                    + "Coordinates VARCHAR(10), "
                    + "Result VARCHAR(10), "
                    + "Timestamp)");
        } catch (SQLException e) {
            System.out.println("Error creating table BATTLESHIPACTIONS: " + e.getMessage());
        }
    }

    private void createGameResultsTable() { // Create GAMERESULTS table if it doesn't exist
        try ( Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE GAMERESULTS ("
                    + "ID, "
                    + "Outcome VARCHAR(50), "
                    + "Timestamp)");
        } catch (SQLException e) {
            System.out.println("Error creating table GAMERESULTS: " + e.getMessage());
        }
    }

    public void logMove(String actionType, String coordinates, char result) {  //records moves made by player
        try ( PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO BATTLESHIPACTIONS (ActionType, Coordinates, Result) VALUES (?, ?, ?)")) {
            stmt.setString(1, actionType);
            stmt.setString(2, coordinates);
            stmt.setString(3, String.valueOf(result));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error logging move: " + e.getMessage());
        }
    }

    public void logGameResult(String outcome) { //records game results
        try ( PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO GAMERESULTS (Outcome) VALUES (?)")) {
            stmt.setString(1, outcome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error logging game result: " + e.getMessage());
        }
    }

    public List<String> getGameResults() { //a function for getting game results so it can be displayed
        List<String> results = new ArrayList<>();
        String query = "SELECT Outcome FROM GameResults";

        try ( PreparedStatement stmt = conn.prepareStatement(query);  ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                results.add(rs.getString("Outcome"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving game results: " + e.getMessage());
        }

        return results;
    }

    public void closeConnection() {
        dbManager.closeConnections();
    }
}
