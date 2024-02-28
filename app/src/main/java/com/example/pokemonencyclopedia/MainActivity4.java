package com.example.pokemonencyclopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    JSONArray moves;
    ArrayList<Moves> movesList =  new ArrayList<Moves>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        String attacks = loadJSONFromAsset("Moves.json");
        try {
            moves = new JSONArray(attacks);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        try {
            for(int i = 0; i < moves.length(); i++) {
                movesList.add(getMoves(moves, i));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Moves getMoves(JSONArray obj, int i) throws Exception {
        Moves a = new Moves(obj.getJSONObject(i));
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