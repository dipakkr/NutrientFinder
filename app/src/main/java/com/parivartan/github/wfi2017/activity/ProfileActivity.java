package com.parivartan.github.wfi2017.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.widget.ImageView;
import android.widget.LinearLayout;

import com.parivartan.github.wfi2017.R;

/**
 * Created by root on 10/18/17.
 */

public class ProfileActivity extends AppCompatActivity{

    LinearLayout body_health;
    LinearLayout lifestyle;
    LinearLayout my_favoutites;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");

        ImageView edit = (ImageView)findViewById(R.id.menu_back);
        ImageView back = (ImageView)findViewById(R.id.menu_profile);

        body_health = (LinearLayout)findViewById(R.id.ll1);
        lifestyle = (LinearLayout)findViewById(R.id.ll3);
        my_favoutites = (LinearLayout)findViewById(R.id.ll2);

    }
}
