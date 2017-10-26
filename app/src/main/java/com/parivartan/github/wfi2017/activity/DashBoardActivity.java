package com.parivartan.github.wfi2017.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.parivartan.github.wfi2017.MainActivity;
import com.parivartan.github.wfi2017.R;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by deepak on 10/18/17.
 */

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener{

    TextView food_nutrients;
    TextView food_diseases;
    TextView health_tracker;
    TextView current_location;

    SharedPreferences pref;
    private int counter = 0;

    FloatingActionButton fab_camera;


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
        fab_camera = (FloatingActionButton)findViewById(R.id.fab_camera);

        food_diseases.setOnClickListener(this);
        food_nutrients.setOnClickListener(this);
        health_tracker.setOnClickListener(this);
        current_location.setOnClickListener(this);
        fab_camera.setOnClickListener(this);


//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
//                Toast.makeText(this, "Details are here", Toast.LENGTH_SHORT).show();
//            } else {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_LOCATION_SERVICE);
//            }
//        }
//
//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
//        fusedLocationProviderClient.getLastLocation()
//                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
//                    @Override
//                    public void onSuccess(Location location) {
//
//                        if (location != null) {
//                            Geocoder gcd = new Geocoder(getApplicationContext(), Locale.getDefault());
//
//                            String state;
//                            List<Address> address;
//
//                            try{
//                                address = gcd.getFromLocation(location.getLatitude(),location.getLongitude(),1);
//                                if(address.size() > 0){
//                                    state = address.get(0).getAdminArea();
//                                    Log.e("MY CURRENT STATE",state);
//                                }
//                            }catch (IOException e){
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                });
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

            case R.id.suggestion_current_location :
                startActivity(new Intent(DashBoardActivity.this,CurrentFoodSuggestion.class));
                break;

            case R.id.health_track :
                startActivity(new Intent(DashBoardActivity.this,AddFoodActivity.class));
                break;

            case R.id.fab_camera :
                startActivity(new Intent(DashBoardActivity.this,VisionActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


}
