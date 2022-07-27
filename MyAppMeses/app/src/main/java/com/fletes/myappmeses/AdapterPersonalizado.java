package com.fletes.myappmeses;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

//Se debe realizar el extends de la clase BaseAdapter para poder utilizar
//los métodos abstractos que esta tiene y así poder crear nuestro propio
//adapter
public class AdapterPersonalizado extends BaseAdapter {

    //Declaración de variables a utilizar para el item personalizado de la lista
    private Context context;
    private int referenciaLista;
    ArrayList<Integer> numeroMes = new ArrayList<>();
    ArrayList<String> nombreMes = new ArrayList<>();
    ArrayList<Integer> descripcionCelebracionMes = new ArrayList<>();
    ArrayList<String> celebracionMes = new ArrayList<>();

    public AdapterPersonalizado(Context context, int referenciaLista,
                                ArrayList<Integer> numeroMes, ArrayList<String> nombreMes,
                                ArrayList<Integer> descripcionCelebracionMes,
                                ArrayList<String> celebracionMes) {
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.numeroMes = numeroMes;
        this.nombreMes = nombreMes;
        this.descripcionCelebracionMes = descripcionCelebracionMes;
        this.celebracionMes = celebracionMes;
    }

    //Identifica el tamaño de la lista
    @Override
    public int getCount() {
        return this.numeroMes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Variable para el retorno, esta será de tipo View
        View v = convertView;
        //Nos permite realizar una implementación de una vista (view) ya diseñado
        //el cual reconoce el contexto de donde se va a mostrar ese diseño (esa view)
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.list_personalizada, null);
        //Recibimos la información por posición de los arreglos (ArrayLis)
        int numeroDeMes = this.numeroMes.get(position);
        String nombreDeMes = this.nombreMes.get(position);
        int descripcionMes = this.descripcionCelebracionMes.get(position);
        String celebracion = this.celebracionMes.get(position);
        TextView textViewNumMes = v.findViewById(R.id.txtNumeroMes);
        TextView textViewNomMes = v.findViewById(R.id.txtNombreMes);
        TextView textViewAnio = v.findViewById(R.id.txtAnio);
        Button buttonVer = v.findViewById(R.id.btnVer);
        textViewNumMes.setText(String.valueOf(numeroDeMes));
        textViewNomMes.setText(String.valueOf(nombreDeMes));
        textViewAnio.setText(String.valueOf(anioActual()));

        //Método del click del botón
        buttonVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trasladar(nombreDeMes, celebracion, descripcionMes);
            }
        });
        return v;
    }

    private int anioActual(){
        Calendar calendar = Calendar.getInstance();
        int anio = calendar.get(Calendar.YEAR);
        return anio;
    }

    private void trasladar(String nomMes, String celebracion, int descripcion){
        Intent intent = new Intent(context, MACelebraciones.class);
        intent.putExtra("nomMes", nomMes);
        intent.putExtra("celebracion", celebracion);
        intent.putExtra("descriocion", descripcion);
        context.startActivity(intent);
    }
}
