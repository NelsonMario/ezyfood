package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezyfood.helper.Currency;

public class TopUpActivity extends AppCompatActivity {

    private TextView balanceTv;
    private Button topupBtn;
    private EditText topupEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        topupEt = findViewById(R.id.et_topup);
        topupBtn = findViewById(R.id.btn_topup);

        balanceTv = findViewById(R.id.tv_balance);
        balanceTv.setText(Currency.currency.toString());


        topupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int balance = 0;

                try {
                    balance = Integer.parseInt(topupEt.getText().toString());
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                }

                if(balance < 10000){
                    Toast.makeText(getApplicationContext(), "Minimum saldo 10000", Toast.LENGTH_SHORT).show();
                }else{
                    Currency.currency += balance;
                    Intent i = new Intent(TopUpActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
