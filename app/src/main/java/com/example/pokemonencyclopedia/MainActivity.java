package com.example.pokemonencyclopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String PACKAGE_NAME;
    TextView pokemonT;
    TextView itemsT;
    TextView abilitiesT;
    TextView movesT;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // There are 4 actions designed (2 fully implemented, 2 coming soon)

        // Fully funcion now
        pokemonT = findViewById(R.id.pokemon);
        abilitiesT = findViewById(R.id.abilities);

        // Coming soon
        itemsT = findViewById(R.id.items);
        movesT = findViewById(R.id.moves);


        PACKAGE_NAME = getApplicationContext().getPackageName();

        pokemonT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("pokemon", 0);
                startActivity(intent);
            }
        });
        abilitiesT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity5.class);
                intent.putExtra("abilities", 0);
                startActivity(intent);
            }
        });

//        itemsT.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
//                intent.putExtra("items", 0);
//                startActivity(intent);
//            }
//        });
//        movesT.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, MainActivity4.class);
//                intent.putExtra("moves", 0);
//                startActivity(intent);
//            }
//        });
    }
}