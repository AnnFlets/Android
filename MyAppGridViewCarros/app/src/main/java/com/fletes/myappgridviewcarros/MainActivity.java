package com.fletes.myappgridviewcarros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridMarcas);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, marcas());
        gridView.setAdapter(arrayAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Pulsó: " + marcas().get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<String> marcas(){
        ArrayList<String> marcas = new ArrayList<>();
        marcas.add("Toyota");
        marcas.add("Nissan");
        marcas.add("Mitsubishi");
        marcas.add("Suzuki");
        marcas.add("Mazda");
        marcas.add("Volkswagen");
        marcas.add("Mercedes-Benz");
        marcas.add("Honda");
        marcas.add("Chevrolet");
        marcas.add("Ford");
        return marcas;
    }
}