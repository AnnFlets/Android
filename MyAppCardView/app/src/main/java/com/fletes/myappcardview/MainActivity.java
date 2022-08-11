package com.fletes.myappcardview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listCard);
        AdapterLista adapterLista = new AdapterLista(this, R.layout.list_card_view,saludo());
        listView.setAdapter(adapterLista);
    }

    private ArrayList<String> saludo(){
        ArrayList<String> saludo = new ArrayList<>();
        saludo.add("Hola");
        saludo.add("Adiós");
        saludo.add("Buenos días");
        saludo.add("Buenas tardes");
        saludo.add("Buenas noches");
        return saludo;
    }
}