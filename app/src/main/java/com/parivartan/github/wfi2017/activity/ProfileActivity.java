package com.parivartan.github.wfi2017.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.parivartan.github.wfi2017.R;

import org.w3c.dom.Text;

/**
 * Created by root on 10/18/17.
 */

public class ProfileActivity extends AppCompatActivity{

    LinearLayout body_health;
    LinearLayout lifestyle;
    LinearLayout my_favoutites;

    private int weight = 70;
    private int age  = 23;
    private int sex = 2; /* sex_male = 1 ; sex_female = 0; sex_others = 11; */
    private double ft = 5;
    private double inch = 1;

    private double BMR = 0;

    private double total_req_cal = 0.0;

    private double calorie = 0;

    private int activity_id = 1;

    TextView mCalorie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");

        ImageView edit = (ImageView)findViewById(R.id.menu_back);
        ImageView back = (ImageView)findViewById(R.id.menu_profile);

        mCalorie = (TextView)findViewById(R.id.txt_calorie);

        body_health = (LinearLayout)findViewById(R.id.ll1);
        lifestyle = (LinearLayout)findViewById(R.id.ll3);
        my_favoutites = (LinearLayout)findViewById(R.id.ll2);


        //Calorie calculation For male

        double expr_weight = 0, expr_age=0, expr_height=0;
        double total_cm = ft*30.48 + inch*2.54;

        double BMR = 0;

        if(sex == 1){

             expr_weight = 13.75*weight;
             expr_age = 6.75 * age;
             expr_height = 5*total_cm;
             BMR = 66 + expr_weight + expr_height - expr_age;

        } else {

            //Calorie calculation for female

            expr_weight = 9.6 * expr_weight;
            expr_height = 1.8 * total_cm;
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
