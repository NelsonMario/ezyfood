package com.example.ezyfood.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.OrderedStuffActivity;
import com.example.ezyfood.R;
import com.example.ezyfood.model.Stuff;

import java.util.ArrayList;

public class StuffAdapter extends RecyclerView.Adapter<StuffHolder> {

    private Context context;
    private ArrayList<Stuff> stuffs;

    public StuffAdapter(Context context, ArrayList<Stuff>stuffs) {
        this.context = context;
        this.stuffs = stuffs;
    }

    @NonNull
    @Override
    public StuffHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_stuff, parent, false);
        return new StuffHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StuffHolder holder, int position) {
        final Stuff stuff = stuffs.get(position);
        holder.setDetails(stuff);
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, OrderedStuffActivity.class);
                i.putExtra("ordered", stuff);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stuffs.size();
    }
}


