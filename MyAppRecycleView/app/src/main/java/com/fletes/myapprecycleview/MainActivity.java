package com.fletes.myapprecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        AdaptadorRecyclerView adaptadorRecyclerView = new AdaptadorRecyclerView(articulosOficina());
        recyclerView.setAdapter(adaptadorRecyclerView);
    }

    private ArrayList<String> articulosOficina(){
        ArrayList<String> articulos = new ArrayList<>();
        articulos.add("Lapicero");
        articulos.add("Lápiz");
        articulos.add("Computadora");
        articulos.add("Hojas de papel");
        articulos.add("Engrapadora");
        articulos.add("Silla");
        articulos.add("Escritorio");
        articulos.add("Fólderes");
        articulos.add("Sobres");
        articulos.add("Teléfono");
        return articulos;
    }
}