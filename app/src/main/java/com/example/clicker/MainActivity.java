package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  TextView money;
  private long number = 0;
  private long boost = 1;
  private long boostnum = 100;
  Button boostbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        money= findViewById(R.id.money);
        boostbutton = findViewById(R.id.buttonboost);
    }

    public  void onClick(View view){
        number = boost + number++;
        money.setText(number + "$");
    }
    public void onBoost(View view){
        if(number >=boostnum){
        boost= boost * 2;
        number= number- boostnum;
        money.setText(number+"$");
        boostnum= boostnum *2;
        boostbutton.setText(boostnum+ "$");

    }
        else{
}
}
}

