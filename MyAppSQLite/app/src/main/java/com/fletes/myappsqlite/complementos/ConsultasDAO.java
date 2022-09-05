package com.fletes.myappsqlite.complementos;

import android.content.Context;
import android.database.Cursor;

import com.fletes.myappsqlite.basededatos.BebidaVO;

import java.util.ArrayList;

public interface ConsultasDAO {
    public boolean insertarBebida(BebidaVO bvo, Context context);
    public Cursor buscarIdBebida(BebidaVO bvo, Context context);
    public ArrayList<BebidaVO> listarBebida(BebidaVO bvo, Context context);
    public boolean actualizarBebida(BebidaVO bvo, Context context);
    public boolean eliminarBebida(BebidaVO bvo, Context context);
}
