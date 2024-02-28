package com.example.pokemonencyclopedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ArrayList<Pokemon> pokeList =  new ArrayList<Pokemon>();
    JSONArray pokemon;
    Context context;
    Button back;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        // Load data from file;
        String mons = loadJSONFromAsset("Pokemon.json");
        recyclerAdapter = new RecyclerAdapter(pokeList, MainActivity2.this);
        RecyclerView recycler = findViewById(R.id.pokemonrecyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
        recycler.setAdapter(recyclerAdapter);
        try {
            pokemon = new JSONArray(mons);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        try {
            for (int i = 0; i < pokemon.length(); i++) {
                pokeList.add(getPokemon(pokemon, i));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Implements the back button
        back = findViewById(R.id.BackP);
        back.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("num",0);
                    startActivity(intent);
                }
        });
    }
    public Pokemon getPokemon(JSONArray obj, int i) throws Exception {
        Pokemon a = new Pokemon(obj.getJSONObject(i));
        return a;
    }
    public String loadJSONFromAsset(String fileName) {
        String json = "";
        try {
            InputStream is = getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}