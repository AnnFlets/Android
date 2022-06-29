package com.fletes.myappproducto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombreP, editTextValorP, editTextCantidadP;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombreP = findViewById(R.id.edtNombreP);
        editTextValorP = findViewById(R.id.edtValorP);
        editTextCantidadP = findViewById(R.id.edtCantidadP);
        textViewResultado = findViewById(R.id.txtResultado);
    }

    private void calculoIva(){
        String nombreProducto = editTextNombreP.getText().toString();
        String valorProducto = editTextValorP.getText().toString();
        String cantidadProducto = editTextCantidadP.getText().toString();
        if(!nombreProducto.isEmpty() && !valorProducto.isEmpty() && !cantidadProducto.isEmpty()){
            double valorConIva = Math.round((((Double.parseDouble(valorProducto) * 0.12) + Double.parseDouble(valorProducto)) * Double.parseDouble(cantidadProducto))*100.0)/100.0;
            textViewResultado.setText("El producto es: " + nombreProducto + ", el valor total con IVA es: " + valorConIva);
        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCalcular:
                this.calculoIva();
                break;
        }
    }
}