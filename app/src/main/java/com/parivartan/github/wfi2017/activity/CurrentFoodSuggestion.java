package com.parivartan.github.wfi2017.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

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
 * Created by root on 10/24/17.
 */

public class CurrentFoodSuggestion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatabaseReference mRef;
    FirebaseDatabase database;

    int key = 0;

    Button bt_search;
    Spinner state_spinner;
    String state_key = "state_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_current);

        mRef = FirebaseDatabase.getInstance().getReference("food_item");

        state_spinner = (Spinner)findViewById(R.id.state_spinner);
        state_spinner.setOnItemSelectedListener(this);
        bt_search = (Button)findViewById(R.id.bt_search);

        final List<String> states = new ArrayList<String>();
        //Add data to states
        states.add("Andhra Pradesh");
        states.add("Arunachal Pradesh");
        states.add("Assam");
        states.add("Bihar");
        states.add("Chhattisgarh");
        states.add("Delhi");
        states.add("Goa");
        states.add("Gujarat");
        states.add("Haryana");
        states.add("Himachal Pradesh");
        states.add("Jammu and Kashmir");
        states.add("Jharkhand");
        states.add("Karnataka");
        states.add("Kerala");
        states.add("Maharashtra");
        states.add("Manipur");
        states.add("Madhya Pradesh");
        states.add("Meghalaya");
        states.add("Mizoram");
        states.add("Nagaland");
        states.add("Odisha");
        states.add("Punjab");
        states.add("Rajasthan");
        states.add("Sikkim");
        states.add("Tamil Nadu");
        states.add("Telangana");
        states.add("Tripura");
        states.add("Uttar Pradesh");
        states.add("Uttarakhand");
        states.add("West Bengal");

        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,states);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state_spinner.setAdapter(dataAdapter);


        final List<String> foods_state_wise = new ArrayList<>();
        foods_state_wise.clear();
        final ListView listView = (ListView)findViewById(R.id.list_diseases);
        final ArrayAdapter<String> listadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,foods_state_wise);
        listView.setAdapter(listadapter);


        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mRef.orderByChild(state_key).startAt(key).endAt(key)
                        .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        FoodItem fooditem = dataSnapshot.getValue(FoodItem.class);
                        String foo = fooditem.getfood_name();
                        foods_state_wise.add(foo);
                        listView.setAdapter(listadapter);

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
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item =  parent.getItemAtPosition(position).toString();

        switch (item) {

            case "Andhra Pradesh":
                key = 25;
                break;

            case "Arunachal Pradesh":
                key = 16;
                break;

            case "Assam":
                key = 14;
                break;

            case "Bihar":
                key = 10;
                break;

            case "Chhattisgarh":
                key = 22;
                break;

            case "Goa":
                key = 23;
                break;

            case "Gujarat":
                key = 9;
                break;

            case "Haryana":
                    key = 2;
                    break;

            case "Himachal Pradesh":
                key = 3;
                break;

            case "Jammu and Kashmir":
                key = 1;
                break;

            case "Jharkhand":
                key = 11;
                break;

            case "Karnataka":
                key = 26;
                break;

            case "Kerala":
                key = 28;
                break;

            case "Maharashtra":
                key = 12;
                break;

            case "Madhya Pradesh" :
                key = 8;
                break;

            case "Manipur" :
                key = 17;
                break;

            case  "Meghalaya" :

                key = 30;
                break;

            case "Mizoram" :
                key = 18;
                break;

            case "Nagaland" :
                key = 19;
                break;

            case "Odisha" :
                key = 21;
                break;

            case  "Punjab" :
                key = 2;
                break;

            case "Rajasthan" :
                key = 6;
                break;

            case "Sikkim"  :
                key = 15;
                break;

            case "Tamil Nadu" :
                key = 27;
                break;

            case "Telangana" :
                key = 24;
                break;

            case "Tripura" :
                key = 20;
                break;

            case "Uttar Pradesh" :
                key = 7;
                break;

            case "Uttarakhand" :
                key = 5;
                break;

            case "West Bengal" :
                key = 13;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
