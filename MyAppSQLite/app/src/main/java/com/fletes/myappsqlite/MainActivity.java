package com.fletes.myappsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonInsertar, buttonBuscar, buttonListado, buttonActualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonInsertar = findViewById(R.id.btnInsertarMenu);
        buttonBuscar = findViewById(R.id.btnBuscarMenu);
        buttonListado = findViewById(R.id.btnListadoMenu);
        buttonActualizar = findViewById(R.id.btnActualizarMenu);
        this.navegacionMenu();
    }

    private void navegacionMenu(){
        buttonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirInsertar();
            }
        });
        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirBuscar();
            }
        });
        buttonListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirLista();
            }
        });
        buttonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActualizar();
            }
        });
    }

    private void abrirInsertar(){
        Intent intent = new Intent(this, MAInsertarSQLite.class);
        startActivity(intent);
    }

    private void abrirBuscar(){
        Intent intent = new Intent(this, MABuscarIdSQLite.class);
        startActivity(intent);
    }

    private void abrirLista(){
        Intent intent = new Intent(this, MAListarSQLite.class);
        startActivity(intent);
    }

    private void abrirActualizar(){
        Intent intent = new Intent(this, MAActualizarSQLite.class);
        startActivity(intent);
    }
}