package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezyfood.helper.Currency;
import com.example.ezyfood.helper.StaticCart;
import com.example.ezyfood.model.Cart;
import com.example.ezyfood.utils.CartAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import javax.crypto.Cipher;

public class CartActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private FloatingActionButton fab2;
    private TextView totalPriceTv;
    private TextView currBalanceTv;
    Integer totalPrice = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        CartAdapter cartAdapter = new CartAdapter(this);

        ListView lv = (ListView)findViewById(R.id.lv_carts);
        lv.setAdapter(cartAdapter);

        fab = findViewById(R.id.fab_cart);
        fab2 = findViewById(R.id.fab2_cart);
        totalPriceTv = findViewById(R.id.tv_totalPrice);
        currBalanceTv = findViewById(R.id.tv_currBalance);




        for (Cart c : StaticCart.carts) {
            totalPrice += c.getStuff().getPrice() * c.getQuantity();
        }

        totalPriceTv.setText("Total Price : Rp." + totalPrice.toString());
        currBalanceTv.setText("Saldo : Rp." + Currency.currency.toString());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (totalPrice < Currency.currency){
                    StaticCart.carts.removeAll(StaticCart.carts);
                    Currency.currency -= totalPrice;
                    Toast.makeText(view.getContext(), "Tramsaksi berhasil", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(CartActivity.this, MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(view.getContext(), "Saldo tidak cukup", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CartActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

}
