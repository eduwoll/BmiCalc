package com.example.bmiCalculator;

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
        TextView txtName = findViewById(R.id.txtName);
        TextView txtBmiDetail = findViewById(R.id.txtBmiDetail);
        TextView txtResult = findViewById(R.id.txtResult);
        TextView txtCategory = findViewById(R.id.txtCategory);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent it= getIntent();
        String name= it.getStringExtra("name");
        String weight = it.getStringExtra("weight");
        String height = it.getStringExtra("height");
        String bmi = it.getStringExtra("bmi");
        String categoryText = it.getStringExtra("category");

        String msg1 = getResources().getString(R.string.hello) + ", " + name + "!";
        String msg2 = getResources().getString(R.string.yourWeight) + " " + weight + "Kg "
                + getResources().getString(R.string.yourHeight) + " " + height + "cm. " + getResources().getString(R.string.based)+ " " + getResources().getString(R.string.yourBmi) + ":";


        txtName.setText(msg1);
        txtBmiDetail.setText(msg2);
        txtResult.setText(bmi);
        txtCategory.setText(categoryText);
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
