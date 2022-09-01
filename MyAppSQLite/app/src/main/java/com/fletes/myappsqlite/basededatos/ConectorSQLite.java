package com.fletes.myappsqlite.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.fletes.myappsqlite.complementos.ConstantesSQL;

//Paso 1 - Extender SQLiteOpenHelper
public class ConectorSQLite extends SQLiteOpenHelper {
    //Paso 3 - Generar el primer constructor que aparece
    public ConectorSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Paso 2 - Implementar métodos abstractos
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Paso 4 - Crear la tabla
        db.execSQL(ConstantesSQL.CREAR_TBL_BEBIDA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Paso 5 - Borrar la tablasi ya existe
        db.execSQL(ConstantesSQL.BORRAR_TBL_BEBIDA);
        onCreate(db);
    }
}