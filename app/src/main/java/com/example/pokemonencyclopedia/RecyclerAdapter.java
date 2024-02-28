package com.example.pokemonencyclopedia;

import static com.google.android.material.internal.ContextUtils.getActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.loader.AssetsProvider;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DataViewHolder> {
    private Context context;
    //ArrayList of that holds all data fields
    private ArrayList<Pokemon> list = new ArrayList<Pokemon>();

    // Uses sharedPref to save favorites chose by users;
    SharedPreferences sharedPref;
    TreeSet<Integer> favorites = new TreeSet<Integer>();

    //constructor
    public RecyclerAdapter(ArrayList<Pokemon> list, Context context) {
        this.list = list;
        this.context = context;

        // Load favorites from shared preference;
        sharedPref = context.getSharedPreferences(
                "favorite", Context.MODE_PRIVATE);
        loadFavorites(favorites, sharedPref.getString("favor", ""));
    }

    // Utility function to load favorites from sharedpref (persistent storage);
    public static void loadFavorites(TreeSet<Integer> set, String str) {
        if (str.isEmpty()) return;
        set.clear();
        String value = str.substring(1, str.length() - 1);
        if (value.isEmpty()) return;
        for (String s: value.split(",")) {
            set.add(Integer.parseInt(s.trim()));
        }
    }


    public static class DataViewHolder extends RecyclerView.ViewHolder {
        private TextView pokemon;
        private TextView info;
        private CardView cardView;
        private ImageView imageView1;
        private ImageView imageView2;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            pokemon= itemView.findViewById(R.id.pokemon);
            info = itemView.findViewById(R.id.pokemon2);
            imageView1 = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.poke);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }

    @NonNull
    @Override

    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemoncardview, parent, false);
        return new DataViewHolder((view));
    }

    @Override
    //assigning values/data to the views we created in the card_design.xml layout file
    //based on position (row)
    public void onBindViewHolder(@NonNull DataViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.pokemon.setText(list.get(position).getName());
        holder.info.setText("Click here for more info");

        // Dynamically synthesize the image name e.g. p1001.
        int imageIndex = position + 1;
        String imageName = "p" + imageIndex;
        holder.imageView1.setImageResource(getResourceId(imageName, "drawable", MainActivity.PACKAGE_NAME));

        holder.imageView2.setImageResource(R.drawable.star);
        if (favorites.contains(position)) {
            holder.imageView2.setImageResource(R.drawable.filledstar);
        }


        holder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (favorites.contains(position)) {
                    favorites.remove(position);
                    holder.imageView2.setImageResource(R.drawable.star);
                } else {
                    favorites.add(position);
                    holder.imageView2.setImageResource(R.drawable.filledstar);
                }

                // Save favorites into sharedpref whenever it was updated.
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("favor", favorites.toString());
                editor.apply();

            }
        });
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> arr = new ArrayList<String>(12);
                arr.add(list.get(position).getName());
                arr.add(list.get(position).getId());
                arr.add(list.get(position).getDesc());
                arr.add(list.get(position).getType1());
                arr.add(list.get(position).getType2());
                arr.add(list.get(position).getHp());
                arr.add(list.get(position).getAtk());
                arr.add(list.get(position).getDef());
                arr.add(list.get(position).getSpatk());
                arr.add(list.get(position).getSpdef());
                arr.add(list.get(position).getSpeed());
                arr.add(list.get(position).getTotal());
                Intent intent = new Intent(context, MainActivity6.class);
                intent.putExtra("keyword", arr);
                context.startActivity(intent);
            }
        });

    }

    @Override
    //recycler view wants to know how many items(rows) will be displayed
    public int getItemCount() {
        return list.size();

    }

    // Utility function to load resource programatically.
    public int getResourceId(String pVariableName, String pResourcename, String pPackageName)
    {
        try {
            return context.getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
