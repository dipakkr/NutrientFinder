package com.parivartan.github.wfi2017;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.parivartan.github.wfi2017.activity.DashBoardActivity;
import com.parivartan.github.wfi2017.model.User;

public class MainActivity extends AppCompatActivity {

    Button bt_next;
    EditText et_name;
    EditText et_weight;
    EditText height_ft;
    EditText height_inch;
    EditText et_age;
    EditText et_email;

    RadioButton sex, activity;

    RadioGroup rg_sex;
    RadioGroup rg_activity;

    FirebaseDatabase database;
    DatabaseReference mRef;
    String name, weight,age, txt_ft, txt_inch;

    String username = "rajdeeepak";
    String txt_email = "deepakkumar@gmail.com";

    int sex_num = 0;
    int actvity_num = 1;

    double user_height = 0;
    int user_weight;

    int selectedsex;
    int selectedActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        database = FirebaseDatabase.getInstance();
        mRef = database.getReference("users");

        bt_next = (Button)findViewById(R.id.bt_next);
        et_name = (EditText)findViewById(R.id.et_name);

        et_weight = (EditText)findViewById(R.id.et_weight);
        height_ft = (EditText)findViewById(R.id.height_ft);
        height_inch = (EditText)findViewById(R.id.height_in);
        et_age = (EditText)findViewById(R.id.et_age);
        et_email = (EditText)findViewById(R.id.et_email);

        rg_sex = (RadioGroup)findViewById(R.id.rg_sex);
        rg_activity = (RadioGroup)findViewById(R.id.rg_activity);

        //Converting height to cm

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = et_name.getText().toString();
                weight = et_weight.getText().toString();
                age = et_age.getText().toString();
                txt_ft = height_ft.getText().toString();
                txt_inch = height_inch.getText().toString();
                txt_email = et_email.getText().toString();

                int ft = Integer.valueOf(txt_ft);
                int inch = Integer.valueOf(txt_inch);
                user_height = ft*30.48 + inch*2.54 ;

                selectedsex = rg_sex.getCheckedRadioButtonId();
                selectedActivity  = rg_activity.getCheckedRadioButtonId();
                sex = (RadioButton)findViewById(selectedsex);
                activity = (RadioButton)findViewById(selectedActivity);


                //Setting username
                int index = txt_email.indexOf('@');
                username = txt_email.substring(0,index);

                //Selecting sex
                if(selectedsex == R.id.sex_male){
                    sex_num = 0;
                }else if(selectedsex == R.id.sex_female){
                    sex_num = 1;
                }else {
                    sex_num = 2;
                }

                //Selecting Activity
                if(selectedActivity == R.id.q6_a){
                    actvity_num = 1;
                }else if(selectedActivity == R.id.q6_b){
                    actvity_num = 2;
                }else if(selectedActivity == R.id.q6_c){
                    actvity_num = 3;
                }else {
                    actvity_num = 4;
                }

                SharedPreferences.Editor editor = pref.edit();
                editor.putString("user_name",username);
                editor.apply();

                User user = new User(name, username, age, sex_num, weight, user_height, actvity_num);
                mRef.child(username).setValue(user);

                startActivity(new Intent(MainActivity.this, DashBoardActivity.class));
            }
        });
    }
}
