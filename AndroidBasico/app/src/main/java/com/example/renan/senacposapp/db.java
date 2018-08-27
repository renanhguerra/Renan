package com.example.renan.senacposapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class db {
    private HelperSQLite helper;

    public db(Context context){
        helper  = new HelperSQLite(context);


    }

    public void inserir(Despesa despesa){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("descricao", despesa.getDescricao());
        valores.put("valor", despesa.getValor());
        valores.put("categoria", despesa.getCategoria());

        db.insert("despesa", null, valores);
        db.close();
    }

    public void atualizar (Despesa despesa){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("descricao", despesa.getDescricao());
        valores.put("valor", despesa.getValor());
        valores.put("categoria", despesa.getCategoria());

        db.update("despesa", valores, "id = ?", new String[]{""+despesa.getId()});
        db.close();
    }

    public void atualizarId (int id, String descricao, String valor, String categoria){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("descricao", descricao);
        valores.put("valor", valor);
        valores.put("categoria", categoria);

        db.update("despesa", valores, "id = ?", new String[]{""+id});
        db.close();
    }

    public void deletar (int id){
        SQLiteDatabase db = helper.getWritableDatabase();

        db.delete("despesa", "id = "+String.valueOf(id),null);
        db.close();
    }

    public List<Despesa> buscar (){
        SQLiteDatabase db = helper.getReadableDatabase();
        List<Despesa>  list = new ArrayList<Despesa>();
        String[] colunas = new String[]{"id", "descricao", "categoria", "valor"};
        Cursor cursor = db.query("despesa", colunas, null,  null, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();

            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
                String categoria = cursor.getString(cursor.getColumnIndex("categoria"));
                String valor = cursor.getString(cursor.getColumnIndex("valor"));
                Despesa d = new Despesa(descricao, categoria, valor, id);

                list.add(d);

            }while(cursor.moveToNext());{

            }


        }
        return(list);
    }

    public Despesa buscarId (int id){
        SQLiteDatabase db = helper.getReadableDatabase();
        String[] colunas = new String[]{"id", "descricao", "categoria", "valor"};
        Cursor cursor = db.query("despesa", colunas, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();}
        String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
        String categoria = cursor.getString(cursor.getColumnIndex("categoria"));
        String valor = cursor.getString(cursor.getColumnIndex("valor"));
        Despesa d = new Despesa(descricao, categoria, valor, id);

        return d;


    }
}
