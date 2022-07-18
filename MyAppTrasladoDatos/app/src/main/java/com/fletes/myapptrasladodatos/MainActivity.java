package com.fletes.myapptrasladodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextN, editTextA, editTextE, editTextD, editTextT;
    private Button buttonTD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextN = findViewById(R.id.edtNombre);
        editTextA = findViewById(R.id.edtApellido);
        editTextE = findViewById(R.id.edtEdad);
        editTextD = findViewById(R.id.edtDire);
        editTextT = findViewById(R.id.edtTel);
        buttonTD = findViewById(R.id.btnTrasladar);
        this.click();
    }

    private void click() {
        buttonTD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datosATrasladar();
            }
        });
    }

    private void datosATrasladar(){
        String nombre = editTextN.getText().toString();
        String apellido = editTextA.getText().toString();
        String edad = editTextE.getText().toString();
        String direccion = editTextD.getText().toString();
        String telefono = editTextT.getText().toString();
        if(!nombre.isEmpty() && !apellido.isEmpty() && !edad.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty()){
            Intent intent = new Intent(this, MAReceptor.class);
            intent.putExtra("nom", nombre);
            intent.putExtra("ape", apellido);
            intent.putExtra("eda", edad);
            intent.putExtra("dir", direccion);
            intent.putExtra("tel", telefono);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }
}