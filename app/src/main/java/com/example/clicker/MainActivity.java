package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



        public static double number = 0; // баланс в долларах
        private double boost =0.5;
        private int clicker = 0; // счетчик кликов
        private double crystal = 0;// кристаллы





  // 2 буст


        private TextView money;

        private TextView crystallmoney;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            money = findViewById(R.id.money);

            crystallmoney = findViewById(R.id.crystallmoney);
            number = getIntent().getIntExtra("a", 0);

        }

        /**кликер*/
        public void onClick(View view) {
            number = boost + number++;
            money.setText(number + "$");
            clicker++;
            crystal=  0.25+ crystal++;
            crystallmoney.setText(crystal+"");


        }

        /**Переходы между активностями*/
        public void onUpgrade(View view) {

            /*    if(number >=boostnum){
                boost= boost * 2;// увеличиваем буст в  2 раза
                number= number- boostnum; // остаток
                money.setText(number+"$"); // выводим остаток
                boostnum= boostnum *2;  // повышаем цену
                upgrade.setText(boostnum+ "$");// меняем текст на кнопке

            }
            else{}
*/

              Intent intent = new Intent(MainActivity.this, UpgradeActivity.class);
            intent.putExtra("key", number);


            Log.i("Upd", "True");
            startActivity(intent);
        }

        public void onShop(View view) {
            Intent intent = new Intent(MainActivity.this, ShopActivity.class);

            startActivity(intent);
        }

        public void onINFO(View view) {
            Intent intent = new Intent(MainActivity.this, InfoActivity.class);
            intent.putExtra("key",clicker);
            startActivity(intent);
        }




        @Override
        protected void onDestroy() {
            super.onDestroy();

        }
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat("number", (float) number);
        editor.putFloat("boost", (float) boost);
        editor.putInt("clicker", clicker);
       // editor.putInt("boostnum",boostnum);
        editor.putFloat("crystal", (float) crystal);
        editor.apply();
    }
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        number = prefs.getFloat("number", 0);
        boost = prefs.getFloat("boost", 0.5f);
        clicker = prefs.getInt("clicker", 0);
       // boostnum = prefs.getInt("boostnum",100);
        crystal= prefs.getFloat("crystal",0);
        money.setText(number + "$");
       // upgrade.setText(boostnum+"$");
        crystallmoney.setText(crystal+"");
    }
}


