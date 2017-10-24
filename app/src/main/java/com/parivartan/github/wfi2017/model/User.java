package com.parivartan.github.wfi2017.model;

/**
 * Created by root on 10/23/17.
 */

public class User {
    public String name;
    public String username;
    public String age;
    public int gender;
    public String weight;
    public double height;
    public int activity;

    public User(){

    }

    public User(String name, String username,String age, int gender, String weight, double height, int activity) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getAge() {
        return age;
    }

    public int getGender() {
        return gender;
    }

    public String getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getActivity() {
        return activity;
    }
}