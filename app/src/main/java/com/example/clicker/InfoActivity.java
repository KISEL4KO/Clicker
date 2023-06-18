package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

   private double number = 0;
    TextView edit;
     private int a =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
       edit = findViewById(R.id.textView2);
       int value = getIntent().getIntExtra("key", 0); // получение значения, 0 - значение
    edit.setText("Кликов "+ value);

    }

    public void onBack1(View view){
        Intent intent = new Intent(InfoActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);;
        startActivity(intent);

    }



    public void onCheck(View view){
   if(a == 1){
       Intent intent = new Intent(InfoActivity.this,MainActivity2.class);
startActivity(intent);

   }
   else{}
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