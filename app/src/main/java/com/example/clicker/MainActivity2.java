package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    private double number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onGet1(View view){
        number = number +100;
    }
    public void onGet2(View view){
        number = number +1000;
    }
    public void onGet3(View view){
        number = number +10000;
    }
    public void onGet4(View view){
        number = number +100000;
    }
    public void onGet5(View view){
        number = number +10000000;
    }







    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat("number", (float) number);

        editor.apply();
    }
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        number = prefs.getFloat("number", 0);


    }
}
