package com.example.comparadorliquidos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtNome;
    EditText edtMl;
    EditText edtRs;
    Button btnToast;
    private Button btnA;
    
    ArrayList<Liquido> liquidos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNome =  findViewById(R.id.edtNome);
        edtMl = findViewById(R.id.edtMl);
        edtRs = findViewById(R.id.edtRs);
        btnToast = findViewById(R.id.btnCalcular);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Liquido maisBarato = null;
                for (Liquido l: liquidos) {
                    if(maisBarato == null || l.calculaResultado() > maisBarato.calculaResultado()){
                        maisBarato = l;
                    }
                }
                if(maisBarato != null){
                    Intent it = new Intent(getBaseContext(), msgActivity.class);
                    it.putExtra("maisBarato",maisBarato.getNome());
                    it.putExtra("volume",maisBarato.getVolume().toString());
                    it.putExtra("preco",maisBarato.getPreco().toString());
                    Float calculo = maisBarato.calculaResultado();
                    it.putExtra("calculo",calculo.toString());
                    startActivity(it);
                }else{
                    criarToast("Nenhum líquido adicionado");
                }
            }
        });
    }

    public void criarToast(String texto){
        Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();
        if(id == R.id.action_add) {
            if (edtMl.length() != 0 && edtRs.length() != 0 && Float.parseFloat(edtRs.getText().toString()) > 0) {
                liquidos.add(new Liquido(edtNome.getText().toString(), Float.parseFloat(edtMl.getText().toString()), Float.parseFloat(edtRs.getText().toString())));
                criarToast("Adicionado!");
                //Limpar Campos
                edtNome.setText(null);
                edtMl.setText(null);
                edtRs.setText(null);
            }else{
                criarToast("Preencha os campos");
            }
        }
        
        return true;
    }
}

