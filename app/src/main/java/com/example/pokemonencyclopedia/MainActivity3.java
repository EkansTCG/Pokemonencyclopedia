package com.example.pokemonencyclopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    ArrayList<Items> itemsList =  new ArrayList<Items>();
    JSONArray items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        String item = loadJSONFromAsset("Items.json");
        try {
            items = new JSONArray(item);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        try {
            for(int i = 0; i < items.length(); i++) {
                itemsList.add(getItems(items, i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Items getItems(JSONArray obj, int i) throws Exception {
        Items a = new Items(obj.getJSONObject(i));
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