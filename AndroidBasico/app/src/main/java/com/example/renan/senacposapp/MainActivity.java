package com.example.renan.senacposapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = (FloatingActionButton)findViewById(R.id.fab);
        ListView listView=(ListView)findViewById(R.id.listv);


        db banco = new db(this);
        DespesaAdapter adapter = new DespesaAdapter(this, banco.buscar());
        listView.setAdapter(adapter );
        listView.setOnItemClickListener(chamaItem(this));

    }

    @Override
    public void onResume() {
        super.onResume();
        fab = (FloatingActionButton)findViewById(R.id.fab);
        ListView listView=(ListView)findViewById(R.id.listv);

        db banco = new db(this);
        DespesaAdapter adapter = new DespesaAdapter(this, banco.buscar());
        listView.setAdapter(adapter );
        listView.setOnItemClickListener(chamaItem(this));    }

    public AdapterView.OnItemClickListener chamaItem(final Context context){
        return(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent , View view, int position, long id) {
                Intent intent;

                intent = new Intent(context, EditActivity.class);

                db banco = new db(MainActivity.this);

                Despesa despesa = banco.buscar().get(position);

                intent.putExtra("idDespesa", despesa.getId());

                startActivity(intent);
            }
        });


    }


    public void addFloatButton(View view){
        Intent myIntent = new Intent(MainActivity.this, AddActivity.class);
        // myIntent.putExtra("key", value); //Optional parameters
        MainActivity.this.startActivity(myIntent);

    }



}
