package com.fletes.myappnombre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextEdad;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre = findViewById(R.id.edtNombre);
        editTextEdad = findViewById(R.id.edtEdad);
        textViewResultado = findViewById(R.id.txtResultado);
    }

    private void mostrar(){
        String nombre = editTextNombre.getText().toString();
        String edad = editTextEdad.getText().toString();
        if(!nombre.isEmpty() && !edad.isEmpty()){
            Calendar c = Calendar.getInstance();
            int aNacimiento = c.get(Calendar.YEAR) - Integer.parseInt(edad);
            textViewResultado.setText("Su nombre es " + nombre + " y su año de nacimiento es: " + aNacimiento);
        }else{
            Toast.makeText(this, "Dato no ingresado", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnMostrar:
                this.mostrar();
                break;
        }
    }
}