package com.parivartan.github.wfi2017.model;

/**
 * Created by root on 10/24/17.
 */

public class FoodItem {
    public String food_id;
    public String food_name;
    public int state_id;
    public String carbohydrates;
    public String protein;
    public String fat;
    public String calories;
    public String serving;
    public String type;
    public String type2;
    public String availability;

    public FoodItem(){

    }

    public FoodItem(String food_id, String food_name, int state_id, String carbohydrates,
                    String protein, String fat, String calories, String serving, String type, String type2, String availability) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.state_id = state_id;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
        this.fat = fat;
        this.calories = calories;
        this.serving = serving;
        this.type = type;
        this.type2 = type2;
        this.availability = availability;
    }

    public String getFood_id() {
        return food_id;
    }

    public String getfood_name() {
        return food_name;
    }

    public int getState_id() {
        return state_id;
    }

    public String getCarbohydrates() {
        return carbohydrates;
    }

    public String getProtein() {
        return protein;
    }

    public String getFat() {
        return fat;
    }

    public String getCalories() {
        return calories;
    }

    public String getServing() {
        return serving;
    }

    public String getType() {
        return type;
    }

    public String getType2() {
        return type2;
    }

    public String getAvailability() {
        return availability;
    }
}