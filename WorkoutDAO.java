package com.fitness.tracker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkoutDAO {
    public static void addWorkout(Workout workout) {
        String query = "INSERT INTO Workouts (user_id, workout_type, duration, calories_burned, steps, distance) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, workout.getUserId());
            stmt.setString(2, workout.getWorkoutType());
            stmt.setInt(3, workout.getDuration());
            stmt.setFloat(4, workout.getCaloriesBurned());
            stmt.setInt(5, workout.getSteps());
            stmt.setFloat(6, workout.getDistance());
            stmt.executeUpdate();
            System.out.println("Workout recorded successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getWorkoutsByUserId(int userId) {
        String query = "SELECT * FROM Workouts WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Workout ID: " + rs.getInt("workout_id"));
                System.out.println("Workout Type: " + rs.getString("workout_type"));
                System.out.println("Duration: " + rs.getInt("duration") + " minutes");
                System.out.println("Calories Burned: " + rs.getFloat("calories_burned"));
                System.out.println("Steps: " + rs.getInt("steps"));
                System.out.println("Distance: " + rs.getFloat("distance") + " km");
                System.out.println("------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
