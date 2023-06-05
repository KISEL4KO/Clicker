package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  TextView money;
  private long number = 0;// счетчик
  private long boost = 1; // активные бусты
  private long boostnum = 100;// 1 буст
    private long clicker = 0;//счетчик кликов
    private long claim = 100;//для подарка
    private long gift = 200;//подарок

  private  long boostnum2 = 500;// 2 буст
     private  int level1 = 1;
    private int level2 = 1;
  Button boostbutton;// 1 кнопка
  Button boostbutton2;// 2 кнопка
    Button  claimbutton;
    TextView lvl1;
    TextView lvl2;
    TextView clicks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        money= findViewById(R.id.money);
        boostbutton = findViewById(R.id.buttonboost);
        boostbutton2 = findViewById(R.id.button2);
        lvl1 = findViewById(R.id.textView1);
        lvl2 = findViewById(R.id.textView2);
        clicks = findViewById(R.id.textView3);
        claimbutton =findViewById(R.id.button4);
    }
    /**кликер
     * */
    public  void onClick(View view){
        number = boost + number++;
        money.setText(number + "$");
        clicker++;
        clicks.setText(clicker +"/"+claim);
    }
    /** 1 буст */
    public void onBoost(View view){
        if(number >=boostnum){
        boost= boost * 2;// увеличиваем буст в  2 раза
        number= number- boostnum; // остаток
        money.setText(number+"$"); // выводим остаток
        boostnum= boostnum *2;  // повышаем цену
        boostbutton.setText(boostnum+ "$");// меняем текст на кнопке

            level1++;
            lvl1.setText(level1 + "lvl");
    }
        else{}


}

   /**2 буст */
    public void onUpgrade(View view){
        if(number >= boostnum2){
            boost= boost * 5;// увеличиваем буст в 5 раз
            number= number- boostnum2;// остаток
            money.setText(number+"$");//выводим остаток
            boostnum2= boostnum2 *3;//повышаем цену
            boostbutton2.setText(boostnum2+ "$");//меняем текст на кнопке

            level2++;
            lvl2.setText(level2 + "lvl");
    }
        else{}
}
public void onClaim(View view){
        if (clicker >=claim){
            number = number + gift;
            gift = gift *2;
            claim = claim * 4;
            claimbutton.setText(gift +"@");

}

}}


