package com.fletes.myappcine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MACompraEntradas extends AppCompatActivity {

    private GridView gridView;
    private EditText editTextNombre, editTextApellido, editTextNit;
    private Button buttonMenos, buttonMas, buttonComprar;
    private TextView textViewCantidadBoletos, textViewTotal;
    private ArrayList<Integer> asientos = new ArrayList<>();
    private int cantidadEntradas = 0;
    private int cantidadAsientosOcupados = 0;
    private int precioBoleto = 50;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macompra_entradas);
        editTextNombre = findViewById(R.id.edtNombre);
        editTextApellido = findViewById(R.id.edtApellido);
        editTextNit = findViewById(R.id.edtNit);
        buttonMenos = findViewById(R.id.btnMenosEntradas);
        buttonMas = findViewById(R.id.btnMasEntradas);
        buttonComprar = findViewById(R.id.btnComprar);
        textViewCantidadBoletos = findViewById(R.id.txtCantidadEntradas);
        textViewTotal = findViewById(R.id.txtTotal);
        gridView = findViewById(R.id.gridAsientos);
        asientos();
        AdapterGrid adapterGrid = new AdapterGrid(this, R.layout.grid_asientos, asientos);
        gridView.setAdapter(adapterGrid);
        this.click(adapterGrid);
    }

    private void click(AdapterGrid adapterGrid) {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                administrarAsientos(adapterGrid, position);
            }
        });
        buttonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disminuirEntradas();
                limpiarAsientos(adapterGrid);
            }
        });
        buttonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aumentarEntradas();
                limpiarAsientos(adapterGrid);
            }
        });
        buttonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarCompra();
            }
        });
    }

    private void asientos(){
        for(int i = 0; i < 21; i++){
            this.asientos.add(i, R.drawable.ic_asiento_libre);
        }
    }
    
    private void realizarCompra(){
        String nombre = editTextNombre.getText().toString();
        String apellido = editTextApellido.getText().toString();
        String nit = editTextNit.getText().toString();
        if(!(nombre.isEmpty()) && !(apellido.isEmpty()) && !(nit.isEmpty())){
            if(!(cantidadEntradas == 0)){
                if(cantidadAsientosOcupados == cantidadEntradas){
                    Intent intent = new Intent(this, MainActivity.class);
                    this.startActivity(intent);
                    Toast.makeText(MACompraEntradas.this, "Su compra fue satisfactoria", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(this, "No ha seleccionado los asientos a ocupar", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "No ha seleccionado la cantidad de boletos", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(MACompraEntradas.this, "Datos de facturación incompletos", Toast.LENGTH_SHORT).show();
        }
    }

    private void administrarAsientos(AdapterGrid adapterGrid, int position){
        if(!(cantidadEntradas == 0)){
            if(asientos.get(position) == R.drawable.ic_asiento_libre){
                if(cantidadAsientosOcupados < cantidadEntradas){
                    asientos.set(position, R.drawable.ic_asiento_ocupado);
                    adapterGrid.notifyDataSetChanged();
                    cantidadAsientosOcupados++;
                }
            }else{
                if(cantidadAsientosOcupados <= cantidadEntradas){
                    asientos.set(position, R.drawable.ic_asiento_libre);
                    adapterGrid.notifyDataSetChanged();
                    cantidadAsientosOcupados--;
                }
            }
        }
    }

    private void limpiarAsientos(AdapterGrid adapterGrid){
        for(int i = 0; i < asientos.size(); i++){
            asientos.set(i, R.drawable.ic_asiento_libre);
        }
        adapterGrid.notifyDataSetChanged();
        cantidadAsientosOcupados = 0;
    }

    private void disminuirEntradas(){
        if(!(cantidadEntradas == 0)){
            this.cantidadEntradas--;
            textViewCantidadBoletos.setText(String.valueOf(cantidadEntradas));
            this.total = this.precioBoleto * cantidadEntradas;
            textViewTotal.setText(String.valueOf(total));
        }
    }

    private void aumentarEntradas(){
        if(!(cantidadEntradas == 21)){
            this.cantidadEntradas++;
            textViewCantidadBoletos.setText(String.valueOf(cantidadEntradas));
            this.total = this.precioBoleto * cantidadEntradas;
            textViewTotal.setText(String.valueOf(total));
        }
    }
}