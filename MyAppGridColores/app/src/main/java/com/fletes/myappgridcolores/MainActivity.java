package com.fletes.myappgridcolores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridColores);
        AdapterGrid adapterGrid = new AdapterGrid(this, R.layout.grid_personalizado, fondo(), nombre());
        gridView.setAdapter(adapterGrid);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trasladarColor(position);
            }
        });
    }
    private ArrayList<String> fondo(){
        ArrayList<String> fondo = new ArrayList<>();
        fondo.add("#E8D7F1");
        fondo.add("#D3BCCC");
        fondo.add("#A167A5");
        fondo.add("#4A306D");
        fondo.add("#0E273C");
        fondo.add("#EABFCB");
        fondo.add("#C191A1");
        fondo.add("#A4508B");
        fondo.add("#5F0A87");
        fondo.add("#2F004F");
        fondo.add("#E2E8DD");
        fondo.add("#B7D1DA");
        fondo.add("#95A3A4");
        fondo.add("#697268");
        fondo.add("#4E5340");
        return fondo;
    }
    private ArrayList<String> nombre(){
        ArrayList<String> nombre = new ArrayList<>();
        nombre.add("Pale Purple Pantone");
        nombre.add("Thistle");
        nombre.add("Pearly Purple");
        nombre.add("Spanish Violet");
        nombre.add("Prussian Blue");
        nombre.add("Cameo Pink");
        nombre.add("English Lavender");
        nombre.add("Magenta Haze");
        nombre.add("Blue Violet Color Wheel");
        nombre.add("Russian Violet");
        nombre.add("Alabaster");
        nombre.add("Columbia Blue");
        nombre.add("Cadet Grey");
        nombre.add("Nickel");
        nombre.add("Rifle Green");
        return nombre;
    }
    private void trasladarColor(int position){
        Intent intent = new Intent(this, MAColor.class);
        intent.putExtra("color", this.fondo().get(position));
        intent.putExtra("nombre", this.nombre().get(position));
        this.startActivity(intent);
    }
}