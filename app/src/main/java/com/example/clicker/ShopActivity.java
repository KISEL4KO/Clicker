package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {

    private double crystal = 0;// кристаллы

    private int cpusid = 0;
    View a;
    View b ;
    View c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        a = findViewById(R.id.rectangle_10);
        b = findViewById(R.id.rectangle_17);
        c = findViewById(R.id.rectangle_16);
    }

    public void onCPU1(View view){
        if(crystal >= 500){
            crystal = crystal-500;
            cpusid = 1;
            a.setOnClickListener(null);

        }
        else {}
    }
    public void onCPU2(View view){
        if(crystal >= 1000){
            crystal = crystal-1000;
            cpusid =  2;
            b.setOnClickListener(null);

        }
        else {}
    }
    public void onCPU3(View view){
        if(crystal >= 1500){
            crystal = crystal-1500;
            cpusid =  3;
            c.setOnClickListener(null);

        }
        else {}
    }









    /**Переходы между активностями*/
    public void onBack2(View view){
        Intent intent = new Intent(ShopActivity.this, MainActivity.class);
        startActivity(intent);


    }

    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat("crystal", (float) crystal);
        editor.putInt("cpus",cpusid);
        editor.apply();
    }
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        cpusid = prefs.getInt("cpus",0);
        crystal= prefs.getFloat("crystal",0);
    }
}



