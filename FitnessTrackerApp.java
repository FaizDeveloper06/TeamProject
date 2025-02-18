package com.fitness.tracker;

import java.util.Scanner;

public class FitnessTrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("password")) {  // Improved login check
        	for(int i=0;i<=4;i++) {
            System.out.println("Welcome to Fitness Tracker!");
            System.out.println("1. Register User");
            System.out.println("2. Log Workout");
            System.out.println("3. View User Details");
            System.out.println("4. View Workouts");
            System.out.println("5.Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine(); // Use nextLine() to avoid skipping

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter weight (kg): ");
                    float weight = scanner.nextFloat();
                    scanner.nextLine();

                    System.out.print("Enter height (cm): ");
                    float height = scanner.nextFloat();
                    scanner.nextLine();

                    System.out.print("Enter gender (Male/Female/Other): ");
                    String gender = scanner.nextLine(); // Use nextLine() to capture full input

                    User user = new User(name, age, weight, height, gender);
                    UserDAO.addUser(user);
                    break;

                case 2:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter workout type: ");
                    String workoutType = scanner.nextLine(); // Use nextLine() for full input

                    System.out.print("Enter duration (minutes): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter calories burned: ");
                    float calories = scanner.nextFloat();
                    scanner.nextLine();

                    System.out.print("Enter steps: ");
                    int steps = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter distance (km): ");
                    float distance = scanner.nextFloat();
                    scanner.nextLine();

                    Workout workout = new Workout(userId, workoutType, duration, calories, steps, distance);
                    WorkoutDAO.addWorkout(workout);
                    break;

                case 3:
                    System.out.print("Enter user ID: ");
                    int uid = scanner.nextInt();
                    scanner.nextLine();
                    UserDAO.getUserById(uid);
                    break;

                case 4:
                    System.out.print("Enter user ID: ");
                    int wid = scanner.nextInt();
                    scanner.nextLine();
                    WorkoutDAO.getWorkoutsByUserId(wid);
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0); 
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
                    break;
            }
        	}
        } else {
            System.out.println("Invalid Username or Password");
        }

        scanner.close();
    }
}
