package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezyfood.helper.StaticCart;
import com.example.ezyfood.model.Stuff;

public class OrderedStuffActivity extends AppCompatActivity {

    private Stuff stuff;

    private ImageView stuffImageIv;
    private TextView stuffNameTv;
    private TextView stuffDescTv;
    private TextView stuffPriceTv;

    private EditText qtyEt;
    private Button qtyBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered_stuff);

        stuffImageIv = findViewById(R.id.iv_orderedThumbnail);
        stuffNameTv = findViewById(R.id.tv_orderedStuff_name);
        stuffDescTv = findViewById(R.id.tv_orderedStuff_desc);
        stuffPriceTv = findViewById(R.id.tv_orderedStuff_price);
        qtyEt = findViewById(R.id.et_qty);
        qtyBtn = findViewById(R.id.btn_qty);

        if(getIntent().getExtras() != null){
            stuff = getIntent().getParcelableExtra("ordered");

            if(stuff.getType().equals("Food"))
                stuffImageIv.setImageResource(R.mipmap.hamburger);
            else if(stuff.getType().equals("Drink"))
                stuffImageIv.setImageResource(R.mipmap.drinks);
            else if(stuff.getType().equals("Snack"))
                stuffImageIv.setImageResource(R.mipmap.snacks);

            stuffNameTv.setText(stuff.getName());
            stuffDescTv.setText(stuff.getDescription());
            stuffPriceTv.setText("Rp. " + stuff.getPrice());

        }

        qtyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qty = 0;

                try {
                    qty = Integer.parseInt(qtyEt.getText().toString());
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                }

                if(qty <= 0){
                    Toast.makeText(getApplicationContext(), "Minimum pembelian 1", Toast.LENGTH_SHORT).show();
                }else{
                    Intent i = new Intent(OrderedStuffActivity.this, MainActivity.class);
                    StaticCart.carts.add(new com.example.ezyfood.model.Cart(stuff, qty));
                    startActivity(i);
                }
            }
        });


    }
}
