package com.fletes.myapplistapaises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MAPais extends AppCompatActivity {

    private TextView textViewNombre, textViewPoblacion;
    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapais);
        textViewNombre = findViewById(R.id.txtNomPais);
        textViewPoblacion = findViewById(R.id.txtPobPais);
        imageView = findViewById(R.id.imgPais);
        button = findViewById(R.id.btnRegresar);
        this.obtenerInfo();
        this.click();
    }

    private void obtenerInfo() {
        Bundle bundle = getIntent().getExtras();
        int imagenP = bundle.getInt("img");
        int nombreP = bundle.getInt("nom");
        int poblacionP = bundle.getInt("pob");
        imageView.setImageResource(imagenP);
        textViewNombre.setText(nombreP);
        textViewPoblacion.setText(poblacionP);
    }

    private void click() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresarPrincipal();
            }
        });
    }

    private void regresarPrincipal(){
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }
}