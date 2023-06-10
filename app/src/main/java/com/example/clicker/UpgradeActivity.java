package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UpgradeActivity<Int> extends AppCompatActivity {


    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade);
        text = findViewById(R.id.textView2);
        int value = getIntent().getIntExtra("key", 0); // получение значения, 0 - значение по умолчанию
        text.setText(value +"$"); // вывод значения в TextView
        text.setText("Баланс: "+ value +"$");

    }






    /**Переходы между активностями*/
    public void onBack3(View view){
        Intent intent = new Intent(UpgradeActivity.this, MainActivity.class);
        // intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);


        startActivity(intent);

    }
}