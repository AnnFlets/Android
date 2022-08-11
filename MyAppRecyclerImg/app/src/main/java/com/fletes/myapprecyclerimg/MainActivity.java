package com.fletes.myapprecyclerimg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.rvAnimales);
        setSupportActionBar(toolbar);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        AdapterRecyclerView adapterRecyclerView = new AdapterRecyclerView(img(), nombre());
        recyclerView.setAdapter(adapterRecyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemLista:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                AdapterRecyclerView adapterRecyclerViewA = new AdapterRecyclerView(img(), nombre());
                recyclerView.setAdapter(adapterRecyclerViewA);
                Toast.makeText(this, "Estilo lista", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemGrid:
                recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                AdapterRecyclerView adapterRecyclerViewB = new AdapterRecyclerView(img(), nombre());
                recyclerView.setAdapter(adapterRecyclerViewB);
                Toast.makeText(this, "Estilo cuadrícula", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Integer> img(){
        ArrayList<Integer> img = new ArrayList<>();
        img.add(R.drawable.ic_anguila);
        img.add(R.drawable.ic_ballena);
        img.add(R.drawable.ic_caballitodemar);
        img.add(R.drawable.ic_cangrejo);
        img.add(R.drawable.ic_cangrejohermitanio);
        img.add(R.drawable.ic_delfin);
        img.add(R.drawable.ic_estrellademar);
        img.add(R.drawable.ic_pez);
        img.add(R.drawable.ic_pezpayaso);
        img.add(R.drawable.ic_tiburon);
        return img;
    }

    private ArrayList<String> nombre(){
        ArrayList<String> nombre = new ArrayList<>();
        nombre.add("Anguila");
        nombre.add("Ballena");
        nombre.add("Caballito de mar");
        nombre.add("Cangrejo");
        nombre.add("Cangrejo ermitaño");
        nombre.add("Delfín");
        nombre.add("Estrella de mar");
        nombre.add("Pez");
        nombre.add("Pez payaso");
        nombre.add("Tiburón");
        return nombre;
    }
}