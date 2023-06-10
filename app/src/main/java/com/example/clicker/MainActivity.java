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

public class MainActivity extends AppCompatActivity {



        private double number = 0; // счетчик
        private double boost = 0.5; // активные бусты
        private int clicker = 0; // счетчик кликов

    private double claim = 100;//для подарка
    private double gift = 200;//подарок

    private  double boostnum = 100;// 2 буст
    private  double level1 = 1;
    private double level2 = 1;

        private TextView money;
        private TextView upgrade;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            money = findViewById(R.id.money);
            upgrade = findViewById(R.id.money1);

        }

        /**кликер*/
        public void onClick(View view) {
            number = boost + number++;
            money.setText(number + "$");
            clicker++;
        }

        /**Переходы между активностями*/
        public void onUpgrade(View view) {

            if(number >=boostnum){
                boost= boost * 2;// увеличиваем буст в  2 раза
                number= number- boostnum; // остаток
                money.setText(number+"$"); // выводим остаток
                boostnum= boostnum *2;  // повышаем цену
                upgrade.setText(boostnum+ "$");// меняем текст на кнопке

            }
            else{}


            /*   Intent intent = new Intent(MainActivity.this, UpgradeActivity.class);
            intent.putExtra("key", number);

            Log.i("Upd", "True");
            startActivity(intent);*/
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
    }


