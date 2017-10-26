package com.parivartan.github.wfi2017.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.parivartan.github.wfi2017.R;
import com.parivartan.github.wfi2017.model.FoodItem;

/**
 * Created by root on 10/26/17.
 */

public class AddFoodActivity extends AppCompatActivity{

    public String food_id;
    public String food_name;

    public String state_id;

    public int int_state_id;
    public String carbohydrates;
    public String protein;
    public String fat;
    public String calories;
    public String serving;
    public String type;
    public String type2;
    public String availability;


    EditText et_food_id, et_food_name, et_state_id, et_carbs, et_protein, et_fat, et_calories, et_serving, et_type,
            et_availablity;

    Spinner spinner_food_type;
    String key = "Drinks";
    Button submit;

    FirebaseDatabase database;
    DatabaseReference mRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        mRef = FirebaseDatabase.getInstance().getReference("food_item");

        et_food_id = (EditText)findViewById(R.id.food_id);
        et_food_name = (EditText)findViewById(R.id.food_name);
        et_state_id = (EditText)findViewById(R.id.food_state_id);
        et_carbs = (EditText)findViewById(R.id.food_carbohydrates);
        et_protein = (EditText)findViewById(R.id.food_Protein);
        et_fat = (EditText)findViewById(R.id.food_fat);
        et_calories = (EditText)findViewById(R.id.food_calories);
        et_serving = (EditText)findViewById(R.id.food_serving);
        et_type = (EditText)findViewById(R.id.food_Type);

        spinner_food_type = (Spinner)findViewById(R.id.spinner_food_type);
        setupSpinner();


        et_availablity = (EditText)findViewById(R.id.food_availability);

        submit = (Button)findViewById(R.id.bt_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                food_id = et_food_id.getText().toString();
                food_name = et_food_name.getText().toString();
                state_id = et_state_id.getText().toString();
                carbohydrates = et_carbs.getText().toString();
                protein = et_protein.getText().toString();
                fat = et_protein.getText().toString();
                calories = et_calories.getText().toString();
                serving = et_serving.getText().toString();
                type = et_type.getText().toString();

                type2 = key;
                //TODO Add type 2 string

                availability = et_availablity.getText().toString();

                int_state_id = Integer.valueOf(state_id);

                Toast.makeText(getApplicationContext(), "  Data Uploaded ",Toast.LENGTH_LONG).show();

                FoodItem foodItem = new FoodItem(food_id,food_name,int_state_id,carbohydrates,protein,fat,calories,serving,type,type2,availability);
                mRef.child(food_name).setValue(foodItem);
            }
        });
    }


    private void setupSpinner(){

        spinner_food_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                key = (String)adapterView.getItemAtPosition(i);
                if(key.equals(getString(R.string.type_dish))){
                    key = "DISH";
                }else if(key.equals(getString(R.string.type_drinks))){
                    key = "DRINKS";
                }else if(key.equals(getString(R.string.type_fruits))){
                    key = "FRUITS";
                }else if(key.equals(getString(R.string.type_vegetables))){
                    key = "VEGETABLES";
                }else if(key.equals(getString(R.string.type_snacks))){
                    key = "SNACKS";
                }else if(key.equals(getString(R.string.type_soups))){
                    key = "SOUPS";
                }else if(key.equals(getString(R.string.type_nonveg))){
                    key = "NON-VEG";
                }else {
                    key = "DISHes";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
             Toast.makeText(getApplicationContext(),"Please select food category",Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.array_food_type,
                android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_food_type.setAdapter(adapter);

    }
}
