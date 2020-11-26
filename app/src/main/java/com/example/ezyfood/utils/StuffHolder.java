package com.example.ezyfood.utils;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.R;
import com.example.ezyfood.model.Stuff;

public class StuffHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView price;
    private ImageView image;


    public StuffHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tv_stuff_name);
        price = itemView.findViewById(R.id.tv_stuff_price);
        image = itemView.findViewById(R.id.iv_thumbnail);
    }

    void setDetails(Stuff stuff){
        name.setText(stuff.getName());
        price.setText("Rp." + stuff.getPrice());
        if(stuff.getType().equals("Food"))
            image.setImageResource(R.mipmap.hamburger);
        else if(stuff.getType().equals("Drink"))
            image.setImageResource(R.mipmap.drinks);
        else if(stuff.getType().equals("Snack"))
            image.setImageResource(R.mipmap.snacks);
    }
}
