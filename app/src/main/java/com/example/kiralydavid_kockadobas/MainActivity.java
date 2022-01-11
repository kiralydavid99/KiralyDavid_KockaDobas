package com.example.kiralydavid_kockadobas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView kocka;
    private ImageView kockaMasik;
    private Button btnKocka;
    private Button btnKockak;
    private Button btnDobas;
    private Button btnReset;
    private TextView twAdatok;
    private boolean isKettoKocka;
    private int[] kockakInt;
    private Random rnd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        btnKocka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isKettoKocka = false;
                kockaMasik.setImageResource(android.R.color.transparent);
            }
        });
        btnKockak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isKettoKocka = true;
                kockaMasik.setImageResource(R.mipmap.kocka1);
            }
        });

        btnDobas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isKettoKocka) {
                    int dobas = rnd.nextInt(6);
                    String szam = String.valueOf(dobas + 1) + "\n";
                    String adatok = (String) twAdatok.getText();

                    kocka.setImageResource(kockakInt[dobas]);
                    twAdatok.setText(adatok + szam);
                }
                else{
                    int dobas = rnd.nextInt(6);
                    int dobasMasik = rnd.nextInt(6);
                    int osszeg = (dobas + 1) + (dobasMasik + 1);
                    String szam = String.valueOf(osszeg) + " ("+ String.valueOf(dobas + 1) + "+"+ String.valueOf(dobasMasik + 1) +")\n";
                    String adatok = (String) twAdatok.getText();

                    kocka.setImageResource(kockakInt[dobas]);
                    kockaMasik.setImageResource(kockakInt[dobas]);
                    twAdatok.setText(adatok + szam);
                }
            }
        });



    }

    private void init(){
        kocka = findViewById(R.id.kocka1);
        kockaMasik = findViewById(R.id.kocka2);
        btnKocka = findViewById(R.id.btnKocka);
        btnKockak = findViewById(R.id.btnKockak);
        btnDobas = findViewById(R.id.btnDobas);
        btnReset = findViewById(R.id.btnReset);
        twAdatok = findViewById(R.id.twAdatok);

        isKettoKocka = true;
        kockakInt = new int[]{
                R.mipmap.kocka1,
                R.mipmap.kocka2,
                R.mipmap.kocka3,
                R.mipmap.kocka4,
                R.mipmap.kocka5,
                R.mipmap.kocka6,
        };
        rnd = new Random();
    }
}