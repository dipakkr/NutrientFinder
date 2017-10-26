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
import android.widget.AdapterView;
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

/**
 * Created by root on 10/21/17.
 */

public class FoodNutrientActivity extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    DatabaseReference mRef;

    ListView listView;
    String[] values;

    SharedPreferences pref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_nutrient);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setTitle("Choose Category");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor editor = pref.edit();

        mRef = FirebaseDatabase.getInstance().getReference("food_items");

        final ListView listview = (ListView) findViewById(R.id.listview);
        values = new String[] { "DRINKS", "DISH", "FRUITS","VEGETABLES","SNACKS","SOUPS","NON-VEG"};

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.select_dialog_item, list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle bundle = new Bundle();
                bundle.putInt("position",position);
                Intent intent = new Intent(FoodNutrientActivity.this,CatFoodListActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),position + "clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
