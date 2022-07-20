package com.fletes.myapplistapaises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listPaises);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPaises());
        listView.setAdapter(arrayAdapter);
        this.clickItem();
    }

    public void clickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trasladarDatos(position);
            }
        });
    }

    private ArrayList<String> listaPaises(){
        ArrayList<String> paises = new ArrayList<>();
        paises.add("Alemania");
        paises.add("Australia");
        paises.add("Bélgica");
        paises.add("Bután");
        paises.add("Canadá");
        paises.add("China");
        paises.add("Guatemala");
        paises.add("Japón");
        paises.add("Sudáfrica");
        paises.add("Suecia");
        return paises;
    }

    private ArrayList<Integer> imagenesPais(){
        ArrayList<Integer> img = new ArrayList<>();
        img.add(R.drawable.ic_alemania);
        img.add(R.drawable.ic_australia);
        img.add(R.drawable.ic_belgica);
        img.add(R.drawable.ic_butan);
        img.add(R.drawable.ic_canada);
        img.add(R.drawable.ic_china);
        img.add(R.drawable.ic_guatemala);
        img.add(R.drawable.ic_japon);
        img.add(R.drawable.ic_sudafrica);
        img.add(R.drawable.ic_suecia);
        return  img;
    }

    private ArrayList<Integer> nombrePais(){
        ArrayList<Integer> nomPais = new ArrayList<>();
        nomPais.add(R.string.nomAlemania);
        nomPais.add(R.string.nomAustralia);
        nomPais.add(R.string.nomBelgica);
        nomPais.add(R.string.nomButan);
        nomPais.add(R.string.nomCanada);
        nomPais.add(R.string.nomChina);
        nomPais.add(R.string.nomGuatemala);
        nomPais.add(R.string.nomJapon);
        nomPais.add(R.string.nomSudafrica);
        nomPais.add(R.string.nomSuecia);
        return nomPais;
    }

    private ArrayList<Integer> poblacionPais(){
        ArrayList<Integer> pobPais = new ArrayList<>();
        pobPais.add(R.string.poblaAlemania);
        pobPais.add(R.string.poblaAustralia);
        pobPais.add(R.string.poblaBelgica);
        pobPais.add(R.string.poblaButan);
        pobPais.add(R.string.poblaCanada);
        pobPais.add(R.string.poblaChina);
        pobPais.add(R.string.poblaGuatemala);
        pobPais.add(R.string.poblaJapon);
        pobPais.add(R.string.poblaSudafrica);
        pobPais.add(R.string.poblaSuecia);
        return pobPais;
    }

    private void trasladarDatos(int position){
        Intent intent = new Intent(this, MAPais.class);
        intent.putExtra("img", imagenesPais().get(position));
        intent.putExtra("nom", nombrePais().get(position));
        intent.putExtra("pob", poblacionPais().get(position));
        startActivity(intent);
    }
}