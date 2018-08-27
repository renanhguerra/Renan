package com.example.renan.senacposapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    Despesa d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();
        int id = intent.getIntExtra("idDespesa", 0);
        Log.e("id", "" + id);
        db banco= new db(this);
        d = banco.buscarId(id);

        Spinner dropdown = findViewById(R.id.spinnerUpd);
        String[] items = new String[]{"Alimentação", "Contas", "Lazer"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        EditText textoDescricao = (EditText) findViewById(R.id.editTextDescUpd);
        EditText textoValor = (EditText) findViewById(R.id.editTextValorUpd);
        Spinner spinnerCategoria = (Spinner) findViewById(R.id.spinnerUpd);
        String descricao = d.getDescricao().toString();
        String valor = d.getValor().toString();
        String categoria = d.getCategoria().toString();


        textoDescricao.setText(descricao);
        textoValor.setText(valor);
        spinnerCategoria.setSelection(((ArrayAdapter)spinnerCategoria.getAdapter()).getPosition(categoria));
    }

    public void botaoAtualizar(View v){
        EditText textoDescricao = (EditText) findViewById(R.id.editTextDescUpd);
        EditText textoValor = (EditText) findViewById(R.id.editTextValorUpd);
        Spinner spinnerCategoria = (Spinner) findViewById(R.id.spinnerUpd);
        String descricao = textoDescricao.getText().toString();
        String valor = textoValor.getText().toString();
        String categoria = spinnerCategoria.getSelectedItem().toString();
        int identificador = d.getId();


        db banco= new db(this);
        banco.atualizarId(identificador, descricao, valor, categoria);

        Toast.makeText(this,"Edição realizada com sucesso!",Toast.LENGTH_SHORT)
                .show();

        Intent intent;

        intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void botaoDeletar(View v){
        int identificador = d.getId();
        db banco= new db(this);
        banco.deletar(identificador);
        Toast.makeText(this,"Registro deletado com sucesso!",Toast.LENGTH_SHORT)
                .show();

        Intent intent;

        intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
