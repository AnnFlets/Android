package com.fletes.myappgridcolores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MAColor extends AppCompatActivity {

    private TextView textViewFondo, textViewCodigo;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macolor);
        textViewFondo = findViewById(R.id.txtBackgroud);
        textViewCodigo = findViewById(R.id.txtCodigoColor);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        obtenerInfo();
    }

    private void obtenerInfo(){
        Bundle bundle = getIntent().getExtras();
        String color = bundle.getString("color");
        textViewFondo.setBackgroundColor(Color.parseColor(color.toString()));
        textViewCodigo.setText(String.valueOf(color));
    }

    private String obtenerNombreColor(){
        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        return nombre;
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
            case R.id.itemColor:
                Toast.makeText(this, obtenerNombreColor(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}