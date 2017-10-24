package com.parivartan.github.wfi2017.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.parivartan.github.wfi2017.R;

import org.w3c.dom.Text;

/**
 * Created by deepak on 10/18/17.
 */

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener{

    TextView food_nutrients;
    TextView food_diseases;
    TextView health_tracker;
    TextView current_location;

    SharedPreferences pref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");

        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String mName = pref.getString("user_name","");
        Log.v("USERNAME",mName);

        ImageView profile_menu = (ImageView)findViewById(R.id.menu_profile);
        profile_menu.setOnClickListener(this);

        food_nutrients = (TextView)findViewById(R.id.food_nutrient);
        food_diseases = (TextView)findViewById(R.id.food_disease);
        health_tracker = (TextView)findViewById(R.id.health_track);
        current_location = (TextView)findViewById(R.id.suggestion_current_location);

        food_diseases.setOnClickListener(this);
        food_nutrients.setOnClickListener(this);
        health_tracker.setOnClickListener(this);
        current_location.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.menu_profile :
                startActivity(new Intent(DashBoardActivity.this,ProfileActivity.class));
                break;

            case R.id.food_nutrient :
                startActivity(new Intent(DashBoardActivity.this,FoodNutrientActivity.class));
                break;

            case R.id.food_disease :
                startActivity(new Intent(DashBoardActivity.this,FoodDieseaseActivity.class));
                break;

            case R.id.health_track :
                startActivity(new Intent(DashBoardActivity.this,HealthTrackerActivity.class));
                break;

            case R.id.suggestion_current_location :
                startActivity(new Intent(DashBoardActivity.this,CurrentFoodSuggestion.class));
                break;
        }
    }
}
