package com.fletes.myapppinturas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listCat);
        AdapterPersonalizado adapterPersonalizado = new AdapterPersonalizado(this,
                R.layout.lista_personalizada, imgCategoria(), nombreCategoria());
        listView.setAdapter(adapterPersonalizado);
        clicItem();
    }

    private void clicItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trasladarInfo(position);
            }
        });
    }

    private ArrayList<Integer> imgCategoria(){
        ArrayList<Integer> imgCategoria = new ArrayList<>();
        imgCategoria.add(R.drawable.ic_abstracto);
        imgCategoria.add(R.drawable.ic_impresionismo);
        imgCategoria.add(R.drawable.ic_realismo);
        imgCategoria.add(R.drawable.ic_surrealismo);
        return imgCategoria;
    }

    private ArrayList<String> nombreCategoria(){
        ArrayList<String> nombreCategoria = new ArrayList<>();
        nombreCategoria.add("ARTE ABSTRACTO");
        nombreCategoria.add("IMPRESIONISMO");
        nombreCategoria.add("REALISMO");
        nombreCategoria.add("SURREALISMO");
        return nombreCategoria;
    }

    private void trasladarInfo(int position) {
        Intent intent = new Intent(this, MACategoriaPinturas.class);
        intent.putExtra("nomCat", nombreCategoria().get(position));
        this.startActivity(intent);
    }
}