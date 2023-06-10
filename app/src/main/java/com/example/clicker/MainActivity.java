package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  TextView money;
  private long number = 0;// счетчик
  private long boost = 1; // активные бусты
    private long clicker = 0;//счетчик кликов



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        money= findViewById(R.id.money);

    }
    /**кликер
     * */
    public  void onClick(View view){
        number = boost + number++;
        money.setText(number + "$");
        clicker++;
    }












    /**Переходы между активностями*/
    public void onUpgrade(View view){
        Intent intent = new Intent(MainActivity.this, UpgradeActivity.class);
        Log.i("Upd","True");
        startActivity(intent);

    }
    public void onShop(View view){
        Intent intent = new Intent(MainActivity.this, ShopActivity.class);

        startActivity(intent);

    }
    public void onINFO(View view){
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        startActivity(intent);

    }

}


