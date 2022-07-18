package com.fletes.myappbisiesto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAnio;
    private Button buttonVerificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextAnio = findViewById(R.id.edtAnio);
        buttonVerificar = findViewById(R.id.btnVerificar);
        this.click();
    }

    private void click() {
        buttonVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trasladoDatos();
            }
        });
    }

    private void trasladoDatos(){
        String anio = editTextAnio.getText().toString();
        if(!anio.isEmpty()){
            Intent intent = new Intent(this, MA2.class);
            intent.putExtra("anio", anio);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Dato no ingresado", Toast.LENGTH_SHORT).show();
        }
    }
}