package com.parivartan.github.wfi2017.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.parivartan.github.wfi2017.R;
import com.parivartan.github.wfi2017.model.FoodItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/25/17.
 */

public class CatFoodListActivity extends AppCompatActivity {

    String category_name = "Type2";
    DatabaseReference mRef;
    SharedPreferences pref;

    ListView food_list;
    ArrayAdapter<String> adapter;
    String[] values = new String[] { "DRINKS", "DISH", "FRUITS","VEGETABLES","Snacks","Soups","Non-Vegetarian"};

    String[] title = new String[] { "Drinks", "Dishes", "Fruits","Vegetables","Snacks","Soups","Non-Veg"};

    int pos ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorized_list);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(toolbar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        mRef = FirebaseDatabase.getInstance().getReference("food_item");
        int id = getIntent().getIntExtra("position",0);

        setTitle("Select  " + title[id]);

        food_list = (ListView)findViewById(R.id.food_list);
        final List<String> foods = new ArrayList<>();
        adapter = new ArrayAdapter(this,android.R.layout.select_dialog_item,foods);
        foods.clear();
        food_list.setAdapter(adapter);


        mRef.orderByChild("type2").startAt(values[id]).endAt(values[id]).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                FoodItem foodItem = dataSnapshot.getValue(FoodItem.class);
                String foo = foodItem.getfood_name();
                foods.add(foo);
                food_list.setAdapter(adapter);
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
}
