package com.fletes.myapptrasladodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MAReceptor extends AppCompatActivity {

    private TextView textViewN, textViewA, textViewE, textViewD, textViewT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mareceptor);
        textViewN = findViewById(R.id.txtNombre);
        textViewA = findViewById(R.id.txtApe);
        textViewE = findViewById(R.id.txtEdad);
        textViewD = findViewById(R.id.txtDire);
        textViewT = findViewById(R.id.txtTel);
        obtenerDatosTrasladados();
    }

    private void obtenerDatosTrasladados(){
        //Agregamos el objeto Bundle para poder recibir
        //De forma óptima los datos trasladados por medio del intent
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String nombre = bundle.getString("nom");
            String apellido = bundle.getString("ape");
            String edad = bundle.getString("eda");
            String direccion = bundle.getString("dir");
            String telefono = bundle.getString("tel");
            textViewN.setText("Nombre: " + nombre);
            textViewA.setText("Apellido: " + apellido);
            textViewN.setText("Edad: " + edad + " años");
            textViewA.setText("Dirección: " + direccion);
            textViewN.setText("Teléfono: " + telefono);
        }else{
            Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
        }
    }
}