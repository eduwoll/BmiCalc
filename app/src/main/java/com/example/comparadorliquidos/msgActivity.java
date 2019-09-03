package com.example.comparadorliquidos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class msgActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);
        TextView txt= findViewById(R.id.mostra);

        Intent it= getIntent();
        String maisBarato= it.getStringExtra("maisBarato");
        String volume = it.getStringExtra("volume");
        String preco = it.getStringExtra("preco");
        String calculo = it.getStringExtra("calculo");
        String toastMsg = "O Líquido mais barato é " + maisBarato + " com o valor de: " + calculo + "mL/R$";
        txt.setContentDescription("O Líquido mais barato é " + maisBarato + " com o valor de: " + calculo + "mL/R$");

        Toast.makeText(getApplicationContext(),toastMsg,Toast.LENGTH_LONG).show();
        txt.setText(toastMsg);
    }
}
