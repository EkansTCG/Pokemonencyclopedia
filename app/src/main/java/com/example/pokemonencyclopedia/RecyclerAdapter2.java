package com.example.pokemonencyclopedia;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.DataViewHolder> {
    private Context context;
    //ArrayList of that holds all data fields
    private ArrayList<Abilities> list = new ArrayList<Abilities>();

    String str;

    //constructor
    public RecyclerAdapter2(ArrayList<Abilities> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView ability;
        private TextView info;
        private CardView cardView;
        private ImageView image;

        //
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            ability = itemView.findViewById(R.id.abilities);
            info = itemView.findViewById(R.id.abilities2);
            cardView = itemView.findViewById(R.id.poke);
            image= itemView.findViewById(R.id.image2);
        }
    }

    @NonNull
    @Override
    //this where you inflate ("draw" the view on screen) the layout
    public RecyclerAdapter2.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //take note that we are using the custom card layout here
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.abilitiescardview, parent, false);
        return new RecyclerAdapter2.DataViewHolder(view);
    }

    @Override
    //assigning values/data to the views we created in the card_design.xml layout file
    //based on position (row)
    public void onBindViewHolder(@NonNull RecyclerAdapter2.DataViewHolder holder, @SuppressLint("RecyclerView") int position) {



        holder.ability.setText(list.get(position).getName());
        holder.info.setText("Click here for more info");
        holder.image.setImageResource(R.drawable.star);


        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += position + " ";
                if(contains(str, position)) {
                    holder.image.setImageResource(R.drawable.star);
                }else{
                    holder.image.setImageResource(R.drawable.filledstar);
                }

            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> arr = new ArrayList<String>(2);
                arr.add(list.get(position).getName());
                arr.add(list.get(position).getDescription());
                Intent intent = new Intent(context, MainActivity7.class);
                intent.putExtra("keyword", arr);
                //editor1.putString("fave" + position, String.valueOf(tree));
                context.startActivity(intent);
            }
        });

    }
    public boolean contains(String s, int pos) {
        String[] arr =  s.toString().split(" ");
        for(String str : arr) {
            if(str.equals(String.valueOf(pos))) {
                return true;
            }
        }
        return false;
    }

    @Override
    //recycler view wants to know how many items(rows) will be displayed
    public int getItemCount() {
        return list.size();

    }
}
