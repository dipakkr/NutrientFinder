package com.parivartan.github.wfi2017;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parivartan.github.wfi2017.activity.DashBoardActivity;

public class MainActivity extends AppCompatActivity {

    Button bt_next;
    EditText et_name;
    EditText et_weight;
    EditText height_ft;
    EditText height_inch;

    String name, weight, txt_ft, txt_inch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_next = (Button)findViewById(R.id.bt_next);
        et_name = (EditText)findViewById(R.id.et_name);
        et_weight = (EditText)findViewById(R.id.et_weight);
        height_ft = (EditText)findViewById(R.id.height_ft);
        height_inch = (EditText)findViewById(R.id.height_in);

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DashBoardActivity.class));
            }
        });
    }
}
