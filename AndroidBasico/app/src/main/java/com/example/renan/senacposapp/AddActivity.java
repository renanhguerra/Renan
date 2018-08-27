package com.example.renan.senacposapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Alimentação", "Contas", "Lazer"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

    }


    public void addButton (View view){

        EditText textoDescricao = (EditText) findViewById(R.id.editTextDesc);
        EditText textoValor = (EditText) findViewById(R.id.editTextVal);
        String descricao = textoDescricao.getText().toString();
        String valor = textoValor.getText().toString();
        Spinner spinnerCategoria = (Spinner) findViewById(R.id.spinner1);
        String categoria = spinnerCategoria.getSelectedItem().toString();

        if((textoDescricao.getText().length() == 0)  || (textoValor.getText().length() == 0) ){//como o tamanho é zero é nulla aresposta

            Toast.makeText(this,"Favor preencher todos os campos.",Toast.LENGTH_LONG)
                    .show();

        }else {

            Despesa despesa = new Despesa(descricao, categoria, valor);

            db banco= new db(this);
            banco.inserir(despesa);
            Toast.makeText(this,"Registro realizado com sucesso!",Toast.LENGTH_SHORT)
                    .show();
            finish();


            Intent myIntent = new Intent(AddActivity.this, MainActivity.class);
            // myIntent.putExtra("key", value); //Optional parameters
            AddActivity.this.startActivity(myIntent);

        }




    }



}
