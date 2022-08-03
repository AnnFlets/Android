package com.fletes.myappgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridAnimalesDomes);
        //ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.animales());
        //gridView.setAdapter(arrayAdapter);
        AdapterGrid adapterGrid = new AdapterGrid(this, R.layout.grid_personalizado, this.imagenes(), this.nombres());
        gridView.setAdapter(adapterGrid);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                traslado(position);
            }
        });
    }

    private ArrayList<String> nombres(){
        ArrayList<String> animales = new ArrayList<>();
        animales.add("Perro");
        animales.add("Gato");
        animales.add("Hámster");
        animales.add("Loro");
        animales.add("Tortuga");
        animales.add("Periquito");
        return animales;
    }
    private ArrayList<Integer> imagenes(){
        ArrayList<Integer> imagenes = new ArrayList<>();
        imagenes.add(R.drawable.ic_perro);
        imagenes.add(R.drawable.ic_gato);
        imagenes.add(R.drawable.ic_hamster);
        imagenes.add(R.drawable.ic_loro);
        imagenes.add(R.drawable.ic_tortuga);
        imagenes.add(R.drawable.ic_perico);
        return imagenes;
    }
    private void traslado(int position){
        Intent intent = new Intent(this, MAImagen.class);
        intent.putExtra("img", this.imagenes().get(position));
        this.startActivity(intent);
    }
}