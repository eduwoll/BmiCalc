package com.example.comparadorliquidos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MsgActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);
        TextView txt= findViewById(R.id.mostra);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent it= getIntent();
        String maisBarato= it.getStringExtra("maisBarato");
        String volume = it.getStringExtra("volume");
        String preco = it.getStringExtra("preco");
        String calculo = it.getStringExtra("calculo");
        String Msg = getResources().getString(R.string.cheapest) + " " + maisBarato + " " + getResources().getString(R.string.value) + " " + calculo + " mL/R$";

        txt.setContentDescription(Msg);

        //Toast.makeText(getApplicationContext(),Msg,Toast.LENGTH_LONG).show();
        txt.setText(Msg);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_msg, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();

        if (id==android.R.id.home) {
            finish();
        }
        return true;
    }
}
