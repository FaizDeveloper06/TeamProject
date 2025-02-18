package com.fitness.tracker;
public class User {
    private int id;
    private String name;
    private int age;
    private float weight;
    private float height;
    private String gender;

    public User(String name, int age, float weight, float height, String gender) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
    }

	public User(int int1, String string, int int2, float float1, float float2, String string2) {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}

	public float getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	public float getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	public String getGender() {
		// TODO Auto-generated method stub
		return gender;
	}

	public String getUserId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	
