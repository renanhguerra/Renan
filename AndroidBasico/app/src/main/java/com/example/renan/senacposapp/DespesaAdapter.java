package com.example.renan.senacposapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DespesaAdapter extends BaseAdapter {

    private Context context;
    private List<Despesa> listaDespesas;


    public DespesaAdapter(Context context, List<Despesa> listaDespesas) {
        this.context = context;
        this.listaDespesas = listaDespesas;
    }

    public void setListaDespesas(List<Despesa> listaDespesas){
        this.listaDespesas = listaDespesas;
    }

    @Override
    public int getCount() {
        return listaDespesas.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDespesas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Despesa despesa = listaDespesas.get(position);


            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.layoutlist_despesas, null);


        TextView descricao = (TextView) layout.findViewById(R.id.itemDesc);
        descricao.setText(despesa.getDescricao());
        TextView categoria = (TextView) layout.findViewById(R.id.itemCategoria);
        categoria.setText(despesa.getCategoria());
        TextView valor = (TextView) layout.findViewById(R.id.itemValor);
        valor.setText(despesa.getValor());

        if (position % 2 == 1) {
            layout.setBackgroundColor(Color.LTGRAY);
        } else {
            layout.setBackgroundColor(Color.GRAY);
        }



        return layout;
    }
}
