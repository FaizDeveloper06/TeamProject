package com.fitness.tracker;
public class Workout {
    private int id;
    private int userId;
    private String workoutType;
    private int duration;
    private float caloriesBurned;
    private int steps;
    private float distance;

    public Workout(int userId, String workoutType, int duration, double caloriesBurned, int steps, float distance) {
        this.userId = userId;
        this.workoutType = workoutType;
        this.duration = duration;
        this.caloriesBurned = (float) caloriesBurned;
        this.steps = steps;
        this.distance = distance;
    }
    // Getters and setters

	public int getUserId() {
		// TODO Auto-generated method stub
		return userId;
	}

	public String getWorkoutType() {
		// TODO Auto-generated method stub
		return workoutType;
	}

	public int getDuration() {
		// TODO Auto-generated method stub
		return duration;
	}

	public float getCaloriesBurned() {
		// TODO Auto-generated method stub
		return caloriesBurned;
	}

	public int getSteps() {
		// TODO Auto-generated method stub
		return steps;
	}

	public float getDistance() {
		// TODO Auto-generated method stub
		return distance;
	}
	
	
}
