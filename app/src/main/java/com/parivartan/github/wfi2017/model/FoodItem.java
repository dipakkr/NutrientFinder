package com.parivartan.github.wfi2017.model;

/**
 * Created by root on 10/24/17.
 */

public class FoodItem {
    public String mId;
    public String mFoodName;
    public String mQuantity;
    public String mCarbs;
    public String mProtein;
    public String mFat;
    public String mCalorie;
    public String mCategoryId;
    public String mStateId;

    public FoodItem(String mId, String mFoodName, String mQuantity, String mCarbs, String mProtein, String mFat, String mCalorie, String mCategoryId, String mStateId) {
        this.mId = mId;
        this.mFoodName = mFoodName;
        this.mQuantity = mQuantity;
        this.mCarbs = mCarbs;
        this.mProtein = mProtein;
        this.mFat = mFat;
        this.mCalorie = mCalorie;
        this.mCategoryId = mCategoryId;
        this.mStateId = mStateId;
    }

    public String getmId() {
        return mId;
    }

    public String getmFoodName() {
        return mFoodName;
    }

    public String getmQuantity() {
        return mQuantity;
    }

    public String getmCarbs() {
        return mCarbs;
    }

    public String getmProtein() {
        return mProtein;
    }

    public String getmFat() {
        return mFat;
    }

    public String getmCalorie() {
        return mCalorie;
    }

    public String getmCategoryId() {
        return mCategoryId;
    }

    public String getmStateId() {
        return mStateId;
    }
}