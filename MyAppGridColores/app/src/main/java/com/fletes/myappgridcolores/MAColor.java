package com.fletes.myappgridcolores;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MAColor extends AppCompatActivity {

    private TextView textViewFondo, textViewCodigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macolor);
        textViewFondo = findViewById(R.id.txtBackgroud);
        textViewCodigo = findViewById(R.id.txtCodigoColor);
        obtenerInfo();
    }

    private void obtenerInfo(){
        Bundle bundle = getIntent().getExtras();
        String color = bundle.getString("color");
        textViewFondo.setBackgroundColor(Color.parseColor(color.toString()));
        textViewCodigo.setText(String.valueOf(color));
    }
}