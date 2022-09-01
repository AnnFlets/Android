package com.fletes.myappsqlite.basededatos;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public interface ConsultasDAO {

    public boolean insertarBebida(BebidaVO bvo, Context context);
    public Cursor buscarIdBebida(BebidaVO bvo, Context context);
    public ArrayList<BebidaVO> listarBebida(BebidaVO bvo, Context context);
    public boolean actualizarBebida(BebidaVO bvo, Context context);
}
