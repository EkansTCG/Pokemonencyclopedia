package com.example.pokemonencyclopedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {
    JSONArray abilities;
    ArrayList<Abilities> abilitiesList =  new ArrayList<Abilities>();
    Button back;
    private RecyclerAdapter2 recyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        String ability = loadJSONFromAsset("Abilities.json");

        try {
            abilities = new JSONArray(ability);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        try {
            for(int i = 0; i < abilities.length(); i++) {
                abilitiesList.add(getAbilities(abilities, i));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        recyclerAdapter = new RecyclerAdapter2(abilitiesList, MainActivity5.this);
        RecyclerView recycler = findViewById(R.id.abillitiesrecyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity5.this));
        recycler.setAdapter(recyclerAdapter);
        back = findViewById(R.id.BackA);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("num",0);
                startActivity(intent);
            }
        });
    }
    public Abilities getAbilities(JSONArray obj, int i) throws Exception {
        Abilities a = new Abilities(obj.getJSONObject(i));
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