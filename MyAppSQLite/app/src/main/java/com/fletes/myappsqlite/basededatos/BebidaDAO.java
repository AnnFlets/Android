package com.fletes.myappsqlite.basededatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fletes.myappsqlite.complementos.ConstantesSQL;
import com.fletes.myappsqlite.complementos.ConsultasDAO;

import java.util.ArrayList;

public class BebidaDAO implements ConsultasDAO {
    @Override
    public boolean insertarBebida(BebidaVO bvo, Context context) {
        boolean resultado = false;//Validar con contexto null
        //Paso 1 - Implementar el constructor del conector
        ConectorSQLite conectorSQLite = new ConectorSQLite(context, ConstantesSQL.BD_BEBIDA,null,ConstantesSQL.VERSION);
        //Paso 2 - Instaciar un objeto que nos permitira realizar la accion de escribir, registrar o insertar datos
        SQLiteDatabase database = conectorSQLite.getWritableDatabase();
        try {
            String consulta = "INSERT INTO "+ConstantesSQL.TBL_BEBIDA+"("+ConstantesSQL.CAMPO_NOMBRE+", "+ConstantesSQL.CAMPO_SABOR+", "+
                    ConstantesSQL.CAMPO_PRESENTACION+", "+ConstantesSQL.CAMPO_TIPO+", "+ConstantesSQL.CAMPO_PRECIO+") VALUES ('"+
                    bvo.getNombreBebida()+"', '"+bvo.getSaborBebida()+"', "+bvo.getPresentacionBebida()+", '"+bvo.getTipoBebida()+"', "+
                    bvo.getPrecioBebida()+")";

            database.execSQL(consulta);
            database.close();
            resultado = true;

        }catch (Exception e){
            e.getMessage();
            database.close();
        }
        return resultado;
    }

    @Override
    public Cursor buscarIdBebida(BebidaVO bvo, Context context) {
        ConectorSQLite conectorSQLite = new ConectorSQLite(context,ConstantesSQL.BD_BEBIDA,null,ConstantesSQL.VERSION);
        //Declara el objeto que nos permitira leer la informacion
        SQLiteDatabase database = conectorSQLite.getReadableDatabase();
        //Creamos el objeto de tipo cursor, este me permite solicitar informacion a la BD y luego leerla y obtenerla
        Cursor cursor = null;
        //Este arreglo permite identificar un parametro para consultar
        String[] valorCondicionConsulta = {bvo.getCodBebida().toString()};
        try {
            String consulta = "SELECT "+ConstantesSQL.CAMPO_CODIGO + ", "
                    +ConstantesSQL.CAMPO_NOMBRE + ", "
                    +ConstantesSQL.CAMPO_SABOR + ", "
                    +ConstantesSQL.CAMPO_PRESENTACION + ", "
                    +ConstantesSQL.CAMPO_TIPO + ", "
                    +ConstantesSQL.CAMPO_PRECIO + " FROM "+ConstantesSQL.TBL_BEBIDA
                    + " WHERE "+ConstantesSQL.CAMPO_CODIGO +" = ?";

            cursor = database.rawQuery(consulta,valorCondicionConsulta);
            cursor.moveToFirst();
            bvo.setCodBebida(cursor.getInt(0));
            bvo.setNombreBebida(cursor.getString(1));
            bvo.setSaborBebida(cursor.getString(2));
            bvo.setPresentacionBebida(cursor.getInt(3));
            bvo.setTipoBebida(cursor.getString(4));
            bvo.setPrecioBebida(cursor.getDouble(5));
            cursor.close();

        }
        catch (Exception e){
            e.getMessage();
            cursor.close();
            database.close();
        }
        return cursor;
    }

    @Override
    public ArrayList<BebidaVO> listarBebida(BebidaVO bvo, Context context) {
        ConectorSQLite conectorSQLite = new ConectorSQLite(context,ConstantesSQL.BD_BEBIDA,null,ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLite.getReadableDatabase();
        ArrayList<BebidaVO> listadoBebidas = new ArrayList<>();
        Cursor cursor = null;
        try {
            String consulta = "SELECT * FROM "+ConstantesSQL.TBL_BEBIDA;
            cursor = database.rawQuery(consulta,null);
            while (cursor.moveToNext()){
                bvo = new BebidaVO();
                bvo.setCodBebida(cursor.getInt(0));
                bvo.setNombreBebida(cursor.getString(1));
                bvo.setSaborBebida(cursor.getString(2));
                bvo.setPresentacionBebida(cursor.getInt(3));
                bvo.setTipoBebida(cursor.getString(4));
                bvo.setPrecioBebida(cursor.getDouble(5));
                listadoBebidas.add(bvo);
            }
            cursor.close();

        }
        catch (Exception e){
            e.getMessage();
            cursor.close();
            database.close();
        }
        return listadoBebidas;
    }

    @Override
    public boolean actualizarBebida(BebidaVO bvo, Context context) {
        boolean resultado = false;
        ConectorSQLite conectorSQLite = new ConectorSQLite(context,ConstantesSQL.BD_BEBIDA,null,ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLite.getWritableDatabase();
        try {
            String consulta = "UPDATE "+ConstantesSQL.TBL_BEBIDA+" SET "+
                    ConstantesSQL.CAMPO_NOMBRE+"= '"+bvo.getNombreBebida()+"', "+
                    ConstantesSQL.CAMPO_SABOR+"= '"+bvo.getSaborBebida()+"', "+
                    ConstantesSQL.CAMPO_PRESENTACION+"= "+bvo.getPresentacionBebida()+","+
                    ConstantesSQL.CAMPO_TIPO+"= '"+bvo.getTipoBebida()+"', "+
                    ConstantesSQL.CAMPO_PRECIO+"= "+bvo.getPrecioBebida()+
                    " WHERE "+ConstantesSQL.CAMPO_CODIGO+"= "+bvo.getCodBebida();

            database.execSQL(consulta);
            database.close();
            resultado = true;

        }
        catch (Exception e){
            e.getMessage();
            database.close();
        }
        return resultado;
    }

    @Override
    public boolean eliminarBebida(BebidaVO bvo, Context context) {
        boolean resultado = false;
        ConectorSQLite conectorSQLite = new ConectorSQLite(context,ConstantesSQL.BD_BEBIDA,null,ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLite.getWritableDatabase();
        try {
            String consulta = "DELETE FROM "+ConstantesSQL.TBL_BEBIDA
                    +" WHERE "+ConstantesSQL.CAMPO_CODIGO+"= "+bvo.getCodBebida();
            database.execSQL(consulta);
            database.close();
            resultado = true;
        }
        catch (Exception e){
            e.getMessage();
            database.close();
        }


        return resultado;
    }
}
