package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class Logs{

   
    private static final String DB_URL = "jdbc:mysql://localhost:3306/supplytracker_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void logFunctionCall(String functionName) {
        String sql = "INSERT INTO function_logs (function_name) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, functionName);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
    public void logActivity(int userId, String activity) {
    String logQuery = "INSERT INTO logs (u_id, activity) VALUES (?, ?)";

    try (Connection conn = new DbConnect().getConnection();
         PreparedStatement stmt = conn.prepareStatement(logQuery)) {

        stmt.setInt(1, userId);
        stmt.setString(2, activity);
        stmt.executeUpdate();

        System.out.println("Activity logged: " + activity);

    } catch (SQLException ex) {
        System.err.println("Failed to log activity: " + ex.getMessage());
    }
}

}
