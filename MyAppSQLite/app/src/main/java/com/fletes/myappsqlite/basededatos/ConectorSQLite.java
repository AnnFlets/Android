package com.fletes.myappsqlite.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.fletes.myappsqlite.complementos.ConstantesSQL;

//Paso 1 - Extender SQLiteOpenHelper
public class ConectorSQLite extends SQLiteOpenHelper {
    //Paso 3 - generar el primer constructor que aparece
    public ConectorSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //Paso 2 - implementar metodos abstractos
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Crear la table
        sqLiteDatabase.execSQL(ConstantesSQL.CREAR_TBL_BEBIDA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Borrar la tabla si ya existe
        sqLiteDatabase.execSQL(ConstantesSQL.BORRAR_TBL_BEBIDA);
        onCreate(sqLiteDatabase);
    }
}