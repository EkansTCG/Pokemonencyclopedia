package com.example.pokemonencyclopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity7 extends AppCompatActivity {
    Button back;
    TextView name;
    TextView desc;
    ArrayList<String> arrList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        name = findViewById(R.id.textView1);
        desc = findViewById(R.id.textView2);
        Intent intent = getIntent();
        arrList = intent.getStringArrayListExtra("keyword");
        name.setText(arrList.get(0));
        desc.setText(arrList.get(1));
        back = findViewById(R.id.back1);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity5.class);
                intent.putExtra("num", 0);
                startActivity(intent);
            }
        });
    }
}