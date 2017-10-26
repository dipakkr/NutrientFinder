package com.parivartan.github.wfi2017.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.parivartan.github.wfi2017.R;
import com.parivartan.github.wfi2017.model.FoodItem;

/**
 * Created by root on 10/25/17.
 */

public class FoodDetailActivity extends AppCompatActivity {

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

    DatabaseReference mRef;
    TextView txt_cal, txt_carbs, txt_fat, txt_protein, txt_state, txt_type, txt_type2, txt_serving;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(toolbar != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        food_name = getIntent().getStringExtra("foodname");
        setTitle(food_name);
        mRef = FirebaseDatabase.getInstance().getReference("food_item");

        txt_cal = (TextView)findViewById(R.id.txt_calorie);
        txt_carbs = (TextView)findViewById(R.id.content_carbs);
        txt_fat = (TextView)findViewById(R.id.content_fat);
        txt_protein = (TextView)findViewById(R.id.content_protein);
        txt_state = (TextView)findViewById(R.id.content_state_id);
        txt_type = (TextView)findViewById(R.id.content_type);
        txt_type2 = (TextView)findViewById(R.id.content_type2);
        txt_serving = (TextView)findViewById(R.id.content_serving);

        mRef.orderByChild("food_name").startAt(food_name).endAt(food_name)
                .addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                FoodItem foodItem = dataSnapshot.getValue(FoodItem.class);
                carbohydrates = foodItem.getCarbohydrates();
                txt_fat.setText(foodItem.getFat() + " fat");
                txt_protein.setText(foodItem.getProtein() + " Protein");
                txt_carbs.setText(carbohydrates + " carbs");
                txt_type.setText(foodItem.getType());
                txt_type2.setText(foodItem.getType2());
                txt_serving.setText(foodItem.getServing() + " Servings");

                txt_cal.setText(foodItem.getCalories() + "  Kcal");

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_food_detail,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.set_fav : //TODO add code here
                break;

            case R.id.setting : //TODO add code here
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
