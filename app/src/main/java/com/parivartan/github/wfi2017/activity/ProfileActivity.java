package com.parivartan.github.wfi2017.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.parivartan.github.wfi2017.R;
import com.parivartan.github.wfi2017.model.User;

import org.w3c.dom.Text;

/**
 * Created by root on 10/18/17.
 */

public class ProfileActivity extends AppCompatActivity{

    private DatabaseReference mRef;
    private ValueEventListener mValueEventListener;

    LinearLayout body_health;
    LinearLayout lifestyle;
    LinearLayout my_favoutites;

    private double BMR = 0;
    private double total_req_cal = 0.0;
    private double calorie = 0;

    private String username;
    private String name = "Deepak Singh";
    public String age = "20";
    private int sex = 2;    /* sex_male = 1 ; sex_female = 0; sex_others = 11; */
    private String weight = "72";
    private double height = 172.50;
    private int activity_id = 1;

    TextView mCalorie, mName, mAge_sex;

    SharedPreferences pref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");

        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String fUserName = pref.getString("user_name","");
        Log.v("USERNAME IN PROFILE",fUserName);

        mRef = FirebaseDatabase.getInstance().getReference("users").child(fUserName);

        ImageView mEditButton = (ImageView)findViewById(R.id.menu_back);
        ImageView mBackButton = (ImageView)findViewById(R.id.menu_profile);

        mCalorie = (TextView)findViewById(R.id.txt_calorie);
        body_health = (LinearLayout)findViewById(R.id.ll1);
        lifestyle = (LinearLayout)findViewById(R.id.ll3);
        my_favoutites = (LinearLayout)findViewById(R.id.ll2);
        mName = (TextView)findViewById(R.id.field_name);
        mAge_sex = (TextView)findViewById(R.id.field_age_sex);


        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                User user = dataSnapshot.getValue(User.class);
                name = user.getName();
                age = user.getAge();
                sex = user.getGender();
                weight = user.getWeight();
                height = user.getHeight();
                activity_id = user.getActivity();

                UpdateUI(name,age,sex,weight,height,activity_id);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        Log.e("NAMEEE",name);
        Log.e("AGGGE",age);

        mRef.addValueEventListener(valueEventListener);
        mValueEventListener = valueEventListener;

    }

    public void UpdateUI(String name,String age,int sex,String weight,double height, int activity_id){

        String sex_name = "Male";

        mName.setText(name);

        if(sex == 0){
            sex_name = "Male";
        }else if(sex == 1){
            sex_name = "Female";
        }else{
            sex_name = "Others";
        }

        mAge_sex.setText(age + ",  " + sex_name);

        //Calorie calculation For male
        double expr_weight = 0, expr_age=0, expr_height=0;
        double BMR = 0;

        int mAge = Integer.valueOf(age);
        int mweight = Integer.valueOf(weight);

        if(sex == 1){

            expr_weight = 13.75*mweight;
            expr_age = 6.75 *mAge;
            expr_height = 5*height;
            BMR = 66 + expr_weight + expr_height - expr_age;

        } else {

            //Calorie calculation for female
            expr_weight = 9.6 * expr_weight;
            expr_height = 1.8 * height;
            expr_age = 4.7 * expr_age;
            BMR = 655 + expr_height + expr_height - expr_age;
        }

        if (activity_id == 1){
            calorie = BMR*1.1;
        } else if (activity_id == 2){
            calorie = BMR*1.275;
        } else if (activity_id == 3){
            calorie = BMR*1.35;
        } else {
            calorie = BMR*1.525;
        }

        int cal_x = (int)calorie;
        String txt_cal = String.valueOf(cal_x);

        mCalorie.setText(txt_cal);

    }
}
