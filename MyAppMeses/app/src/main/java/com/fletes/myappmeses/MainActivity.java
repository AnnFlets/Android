package com.fletes.myappmeses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listMeses);
        AdapterPersonalizado adapterPersonalizado = new AdapterPersonalizado(this,
                R.layout.list_personalizada, numeroMes(), meses(), descripcionCelebracionMes(), celebracionMes());
        //ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, meses());
        listView.setAdapter(adapterPersonalizado);
    }

    private ArrayList<Integer> numeroMes(){
        ArrayList<Integer> numeroMes = new ArrayList<>();
        for(int i = 1; i <= 12; i++){
            numeroMes.add(i);
        }
        return numeroMes;
    }

    private ArrayList<String> meses(){
        ArrayList<String> meses = new ArrayList<>();
        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        meses.add("Abril");
        meses.add("Mayo");
        meses.add("Junio");
        meses.add("Julio");
        meses.add("Agosto");
        meses.add("Septiembre");
        meses.add("Octubre");
        meses.add("Noviembre");
        meses.add("Diciembre");
        return meses;
    }

    private ArrayList<String> celebracionMes(){
        ArrayList<String> celebracionMes = new ArrayList<>();
        celebracionMes.add("Celebración: Año Nuevo");
        celebracionMes.add("Celebración: Huelga de Dolores");
        celebracionMes.add("Celebración: Semana Santa");
        celebracionMes.add("Celebración: Semana Santa");
        celebracionMes.add("Celebración: Santa Cruz");
        celebracionMes.add("Celebración: Baile de los Gigantes");
        celebracionMes.add("Celebración: Fiesta Nacional Indígena Rabin Ajaw");
        celebracionMes.add("Celebración: Festival Folklórico Nacional El Paab’anc");
        celebracionMes.add("Celebración: Día de la Independencia");
        celebracionMes.add("Celebración: San Francisco de Asís");
        celebracionMes.add("Celebración: Todos los Santos");
        celebracionMes.add("Celebración: Quema del Diablo");
        return celebracionMes;
    }

    private ArrayList<Integer> descripcionCelebracionMes(){
        ArrayList<Integer> descripcionCelebracionMes = new ArrayList<>();
        descripcionCelebracionMes.add(R.string.mes1);
        descripcionCelebracionMes.add(R.string.mes2);
        descripcionCelebracionMes.add(R.string.mes3);
        descripcionCelebracionMes.add(R.string.mes4);
        descripcionCelebracionMes.add(R.string.mes5);
        descripcionCelebracionMes.add(R.string.mes6);
        descripcionCelebracionMes.add(R.string.mes7);
        descripcionCelebracionMes.add(R.string.mes8);
        descripcionCelebracionMes.add(R.string.mes9);
        descripcionCelebracionMes.add(R.string.mes10);
        descripcionCelebracionMes.add(R.string.mes11);
        descripcionCelebracionMes.add(R.string.mes12);
        return descripcionCelebracionMes;
    }
}