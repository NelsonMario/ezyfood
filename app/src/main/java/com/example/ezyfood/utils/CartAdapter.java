package com.example.ezyfood.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.ezyfood.R;
import com.example.ezyfood.helper.StaticCart;
import com.example.ezyfood.model.Cart;

import java.util.ArrayList;

public class CartAdapter extends BaseAdapter implements ListAdapter {

    private Context context;

    public CartAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return StaticCart.carts.size();
    }

    @Override
    public Object getItem(int i) {
        return StaticCart.carts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, final ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.cart_stuff, null);
        }

        TextView cartNameTv = (TextView)view.findViewById(R.id.tv_cartName);
        cartNameTv.setText(StaticCart.carts.get(position).getStuff().getName());

        TextView cartQtyTv = (TextView)view.findViewById(R.id.tv_cartQty);
        cartQtyTv.setText(StaticCart.carts.get(position).getQuantity().toString());
//
        TextView cartPriceTv = (TextView)view.findViewById(R.id.tv_cartPrice);
        cartPriceTv.setText(StaticCart.carts.get(position).getStuff().getPrice().toString());

        Button deleteBtn = (Button)view.findViewById(R.id.delete_btn);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                StaticCart.carts.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
