package com.example.pokemonencyclopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {
    RatingBar r2;
    RatingBar r5;
    RatingBar r1;
    RatingBar r4;
    RatingBar r3;
    RatingBar r6;
    RatingBar r7;
    TextView name;
    TextView id;
    TextView t2;
    TextView t5;
    TextView t1;
    TextView t4;
    TextView t3;
    TextView desc;
    TextView type1;
    ArrayList<String> arrList;
    Button back;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        name = findViewById(R.id.textView5);
        r2  = findViewById(R.id.ratingBar2);
        r5  = findViewById(R.id.ratingBar5);
        r1  = findViewById(R.id.ratingBar);
        r4  = findViewById(R.id.ratingBar4);
        r3  = findViewById(R.id.ratingBar8);
        r6  = findViewById(R.id.ratingBar6);
        r7  = findViewById(R.id.ratingBar7);
        id = findViewById(R.id.textView6);
        t2 = findViewById(R.id.textView13);
        t5 = findViewById(R.id.textView12);
        t1 = findViewById(R.id.textView11);
        t4 = findViewById(R.id.textView12);
        t3 = findViewById(R.id.textView13);
        type1 = findViewById(R.id.textView17);
        desc = findViewById(R.id.textView16);
        Intent intent = getIntent();
        arrList = intent.getStringArrayListExtra("keyword");
        name.setText(arrList.get(0));
        id.setText(arrList.get(1));
        desc.setText(arrList.get(2));
        type1.setText(arrList.get(3) + ", " + arrList.get(4));
        back = findViewById(R.id.back128);

        for(int i = 5; i <= 11; i++) {
            int value = Integer.parseInt(arrList.get(i));
            float rate =  Math.round((value / 130.0) * 5.0);
            if (rate > 5) rate = 5;
            if(i == 5) {
                r2.setRating(rate);
            }
            if(i == 6) {
                r5.setRating(rate);
            }
            if(i == 7) {
                r1.setRating(rate);
            }
            if(i == 8) {
                r4.setRating(rate);
            }
            if(i == 9) {
                r3.setRating(rate);
            }
            if(i == 10) {
                r7.setRating(rate);
            }
            if(i == 11) {
                r6.setRating(rate);
            }

        }

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("num", 0);
                startActivity(intent);
            }
        });


    }
}