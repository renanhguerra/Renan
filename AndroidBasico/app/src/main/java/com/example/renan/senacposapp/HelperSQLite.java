package com.example.renan.senacposapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HelperSQLite extends SQLiteOpenHelper {
    private static final String nomeBD = "gastos.db";
    private static String createTable = "CREATE TABLE despesa" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "descricao VARCHAR(30)," +
            "categoria VARCHAR(30)," +
            "valor VARCHAR(20))";


    public HelperSQLite(Context context) {
        super(context, nomeBD, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE despesas");
        db.execSQL(createTable);
    }






}
