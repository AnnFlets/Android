package com.fletes.myapppinturas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MACompra extends AppCompatActivity {

    private TextView textViewNomPin, textViewNomComprador, textViewApeComprador, textViewNitComprador, textViewTotalCompra;
    private Button buttonFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macompra);
        textViewNomPin = findViewById(R.id.txtNombrePin);
        textViewNomComprador = findViewById(R.id.txtNombreComprador);
        textViewApeComprador = findViewById(R.id.txtApellidoComprador);
        textViewNitComprador = findViewById(R.id.txtNitComprador);
        textViewTotalCompra = findViewById(R.id.txtTotalCompra);
        buttonFinalizar = findViewById(R.id.btnFinalizar);
        obtenerDatos();
        click();
    }

    private void click() {
        buttonFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regreso();
            }
        });
    }

    private void regreso(){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        String nomPin = bundle.getString("pin");
        String nombreComprador = bundle.getString("nom");
        String apellidoComprador = bundle.getString("ape");
        String nitComprador = bundle.getString("nit");
        String precioPin = bundle.getString("pre");
        textViewNomPin.setText(String.valueOf(nomPin));
        textViewNomComprador.setText(String.valueOf(nombreComprador));
        textViewApeComprador.setText(String.valueOf(apellidoComprador));
        textViewNitComprador.setText(String.valueOf(nitComprador));
        textViewTotalCompra.setText(String.valueOf(calculoTotalCompra(precioPin)));
    }

    private double calculoTotalCompra(String precio){
        double precioSinIva = Double.parseDouble(precio);
        double total = precioSinIva + precioSinIva * 0.12;
        return total;
    }
}