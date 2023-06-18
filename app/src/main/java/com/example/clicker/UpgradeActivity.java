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
    private double boost = 0.5;
    private double up2=0.1;
    private double up1 = 0.1;


    private double all = up1 +up2;

    private double boostnum = 100;
    private double boostnum2=1000;
    private double boostnum3= 5000;


    TextView text;
    TextView boost1;
    TextView boost2;
    TextView boost3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade);
        text = findViewById(R.id.textView2);
        boost1 = findViewById(R.id.textsale);
        boost2 = findViewById(R.id.textView9);
        boost3 = findViewById(R.id.textView10);

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
public void onBoost2(View view){
    if(number >=boostnum2){
        up1 = up1*5;// увеличиваем буст в  2 раза
        number= number- boostnum2; // остаток
        boostnum2= boostnum2 *5;  // повышаем цену
        boost2.setText("Цена: "+boostnum2+"$");
        text.setText(number+ "$");// меняем текст на кнопке

    }
    else{}

}
public void onBoost3(View view){
    if(number >=boostnum3){
       up2 = up2*10;// увеличиваем буст в  2 раза
        number= number- boostnum3; // остаток
        boostnum3= boostnum3 *6;  // повышаем цену
        boost3.setText("Цена: "+boostnum3+"$");
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
        editor.putFloat("up1",(float) up1);
        editor.putFloat("up2",(float)up2);
        editor.putFloat("boostnum2",(float) boostnum2);
        editor.putFloat("boostnum3",(float) boostnum3);
        editor.putFloat("all",(float) all);

        editor.apply();

    }
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        number = prefs.getFloat("number", 0);
        boost = prefs.getFloat("boost", 0.5f);
         boostnum = prefs.getFloat("boostnum",100);
        up1= prefs.getFloat("up1",0.1f);
        up2= prefs.getFloat("up2",0.1f);
        boostnum2= prefs.getFloat("boostnum2",1000f);
        boostnum3 = prefs.getFloat("boostnum3",5000f);
        all = prefs.getFloat("all",0.2f);
       boost1.setText("Цена: "+boostnum+"$");
       boost2.setText("Цена: "+boostnum2+"$");
       boost3.setText("Цена: "+boostnum3+"$");

    }
}
