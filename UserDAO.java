package com.fitness.tracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDAO {
    // Method to insert a new user
    public static boolean addUser(User user) {
        String sql = "INSERT INTO Users (name, age, weight, height, gender) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, user.getName());
            pstmt.setInt(2, user.getAge());
            pstmt.setFloat(3, user.getWeight());
            pstmt.setFloat(4, user.getHeight());
            pstmt.setString(5, user.getGender());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;  // Returns true if insertion was successful
            
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // Method to get user details by ID
    public static User getUserById(int userId) {
        String sql = "SELECT * FROM Users WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("user_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Weight: " + rs.getFloat("weight") + "kg");
                System.out.println("Height: " + rs.getInt("height") + "cm");
                System.out.println("Gender: " + rs.getString("gender")); // ✅ FIXED
                System.out.println("------------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving user: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    
}

