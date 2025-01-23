package com.example.sqlinjectiontest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Init data input

        LOGGER.info("Type your ID: ");
        String userId = scanner.nextLine();

        String query = "SELECT id, name FROM users WHERE id = ?"; // Use parameterized query to prevent SQL injection

        // Use environment variables or a secret manager for credentials
        String dbUrl = System.getenv("DB_URL");
        String dbUser = System.getenv("DB_USER");
        String dbPassword = System.getenv("DB_PASSWORD");

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, userId); // Set the user ID parameter
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // Process the result set
                    LOGGER.log(Level.INFO, "User ID: {0}", rs.getString("id"));
                    LOGGER.log(Level.INFO, "User Name: {0}", rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error", e); // Log the error
        } finally {
            scanner.close(); // Close the scanner
        }
    }
}