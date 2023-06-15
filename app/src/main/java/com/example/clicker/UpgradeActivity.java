package com.example.clicker;

import static com.example.clicker.MainActivity.number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UpgradeActivity extends AppCompatActivity {


    public static double number = 0; // баланс в долларах
    private double boost =0.5;


    private double boostnum = 100;

    TextView text;
    TextView boost1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade);
        text = findViewById(R.id.textView2);
        boost1 = findViewById(R.id.textsale);

        // получение значения, 0 - значение по умолчанию


    }


public void onBuy1(View view){
    if(number >=boostnum){
        boost= boost * 2;// увеличиваем буст в  2 раза
        number= number- boostnum; // остаток
        boostnum= boostnum *2;  // повышаем цену
        boost1.setText("Цена: "+boostnum+"$");
       text.setText(number+ "$");// меняем текст на кнопке

    }
    else{}

}



    /**Переходы между активностями*/
    public void onBack3(View view){
        Intent intent = new Intent(UpgradeActivity.this, MainActivity.class);
         //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

    }
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat("number", (float) number);
        editor.putFloat("boost", (float) boost);
        editor.putFloat("boostnum", (float) boostnum);
        editor.apply();
    }
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        number = prefs.getFloat("number", 0);
        boost = prefs.getFloat("boost", 0.5f);
         boostnum = prefs.getFloat("boostnum",100);
       text.setText("Баланс: "+ number +"$");
       boost1.setText("Цена: "+boostnum+"$");
    }
}
