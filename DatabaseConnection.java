package com.fitness.tracker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/fitnesstracker";
    private static final String USER = "root";  // Change to your MySQL username
    private static final String PASSWORD = "cse23";  // Replace with your MySQL password

    public static Connection getConnection() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected Successfully!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found!");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        getConnection();  // Test database connection
    }
}
