package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



        public static double number = 0; // баланс в долларах
        private double boost =0.25;//  1 буст
    private double crystalboost = 0.25;
        private int clicker = 0; // счетчик кликов
        private double crystal = 0;// кристаллы
        private String  cpusid ="core3" ; //id cpu


    private double all ;// сумма остальных бустов






        private TextView money;

        private TextView crystallmoney;
       private ImageView view;
       private TextView temperature;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            money = findViewById(R.id.money);
            view = findViewById(R.id.imageView);
            crystallmoney = findViewById(R.id.crystallmoney);


        }

        /**кликер*/

        public void onClick(View view) {

            number += boost+all;
            money.setText(String.format("%.2f$", number));
            clicker++;
            crystal+= crystalboost;
            crystallmoney.setText(crystal+"");


        }

        /**Переходы между активностями*/
        public void onUpgrade(View view) {


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
/**Смена картинки cpu*/

    private void updateCover() {
        switch (cpusid) {
            case "core5":
                view.setImageResource(R.drawable.core5);
                boost = 0.5;
                crystalboost = 1;
                break;
            case "core7":
                view.setImageResource(R.drawable.core7);
                boost = 1;
                crystalboost = 1.5;
                break;
            case "core9":
                view.setImageResource(R.drawable.core9);
                boost = 1.5;
                crystalboost = 2;
                break;
            case "ryzen5":
                view.setImageResource(R.drawable.ryzen5);
                boost = 1;
                break;
            case "ryzen7":
                view.setImageResource(R.drawable.ryzen7);
                boost = 1.5;
                crystalboost = 0.5;
                break;
                case "ryzen9":
                view.setImageResource(R.drawable.ryzen9);
                boost = 2;
                crystalboost = 1;
                break;
            // и т.д. для каждого возможного значения cpusid
        }
    }





    @Override
        protected void onDestroy() {
            super.onDestroy();

        }


/** сохранения*/
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat("number", (float) number);
        editor.putFloat("boost", (float) boost);
        editor.putInt("clicker", clicker);
        editor.putFloat("crystal", (float) crystal);
        editor.putString("cpus",cpusid);
        editor.putFloat("crystalb",(float) crystalboost);
        editor.apply();
    }
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        number = prefs.getFloat("number", 0);
        boost = prefs.getFloat("boost", 0.25f);
        clicker = prefs.getInt("clicker", 0);
       // boostnum = prefs.getInt("boostnum",100);
        crystal= prefs.getFloat("crystal",0);
        all = prefs.getFloat("all",0.2f);
        cpusid = prefs.getString("cpus","core3");
        crystalboost = prefs.getFloat("crystalb",0.25f);
        money.setText(number + "$");
       // upgrade.setText(boostnum+"$");
        crystallmoney.setText(crystal+"");
        updateCover();
    }
}


