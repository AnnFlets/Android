package com.fletes.myappmeses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MACelebraciones extends AppCompatActivity {

    private TextView textViewNombreMes, textViewCelebracionMes, textViewDescripcionMes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macelebraciones);
        textViewNombreMes = findViewById(R.id.txtMes);
        textViewCelebracionMes = findViewById(R.id.txtNombreCelebracion);
        textViewDescripcionMes = findViewById(R.id.txtDescripCelebracion);
        this.obtenerDatos();
    }

    private void obtenerDatos() {
        Bundle bundle = getIntent().getExtras();
        String nomMes = bundle.getString("nomMes");
        String celebracion = bundle.getString("celebracion");
        int descripcion = bundle.getInt("descripcion");
        textViewNombreMes.setText(String.valueOf(nomMes));
        textViewCelebracionMes.setText(String.valueOf(celebracion));
        textViewDescripcionMes.setText(descripcion);
    }
}