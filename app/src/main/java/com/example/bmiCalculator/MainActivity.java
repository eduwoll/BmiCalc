package com.example.bmiCalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.bmiCalculator.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtWeight;
    EditText edtHeight;
    Button btnCalc;

    ArrayList<Bmi> bmis = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName =  findViewById(R.id.edtName);
        edtWeight = findViewById(R.id.edtWeight);
        edtHeight = findViewById(R.id.edtHeight);
        btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean isNameValid = edtName.length() > 2;
                boolean isWeightValid = edtWeight.length() > 0 && Float.parseFloat(edtWeight.getText().toString()) > 5 && Float.parseFloat(edtWeight.getText().toString()) < 500;
                boolean isHeightValid = edtHeight.length() > 0 && Float.parseFloat(edtHeight.getText().toString()) > 50 && Float.parseFloat(edtHeight.getText().toString()) < 300;

                if (isNameValid && isWeightValid && isHeightValid) {
                    Bmi bmi = new Bmi(edtName.getText().toString(), Float.parseFloat(edtWeight.getText().toString()), Integer.parseInt(edtHeight.getText().toString()));

                    String category = "";

                    switch(bmi.getCategory()){
                        case 1:
                            category = getResources().getString(R.string.underweight);
                            break;
                        case 2:
                            category = getResources().getString(R.string.normalWeight);
                            break;
                        case 3:
                            category = getResources().getString(R.string.overweight);
                            break;
                        case 4:
                            category = getResources().getString(R.string.obesity1);
                            break;
                        case 5:
                            category = getResources().getString(R.string.obesity2);
                            break;
                        case 6:
                            category = getResources().getString(R.string.obesity3);
                            break;
                            default:
                    }

                    Intent it = new Intent(getBaseContext(), MsgActivity.class);
                    it.putExtra("name",bmi.getName());
                    it.putExtra("weight",bmi.getWeight().toString());
                    it.putExtra("height",bmi.getHeight().toString());
                    it.putExtra("bmi",String.format( "%.1f", bmi.getBmi()));
                    it.putExtra("category",category);
                    startActivity(it);
                }else{
                    createToast(getResources().getString(R.string.fill));
                }
            }
        });
    }

    public void createToast(String text){
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}

