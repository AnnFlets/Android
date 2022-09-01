package com.fletes.myappsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MADetalle extends AppCompatActivity {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madetalle);
        fragment = new FragmentDetalle();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor, fragment).commit();
        this.obtenerDatos();
    }

    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        String codigo = bundle.getString("codigo");
        String nombre = bundle.getString("nombre");
        String sabor = bundle.getString("sabor");
        String presentacion = bundle.getString("presentacion");
        String tipo = bundle.getString("tipo");
        String precio = bundle.getString("precio");
        trasladarFragmento(codigo, nombre, sabor, presentacion, tipo, precio);
    }

    private void trasladarFragmento(String codigo, String nombre, String sabor, String presentacion, String tipo, String precio){
        Bundle bundle = new Bundle();
        bundle.putString("codigo", codigo);
        bundle.putString("nombre", nombre);
        bundle.putString("sabor", sabor);
        bundle.putString("presentacion", presentacion);
        bundle.putString("tipo", tipo);
        bundle.putString("precio", precio);
        fragment.setArguments(bundle);
    }
}